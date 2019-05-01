import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashSet;

public class ViewStudentsAdminGUI {
    private JFrame frame;
    private JComboBox<Faculty> faculties;
    private HashSet<Faculty> facultati;
    private HashSet<Student> studenti;
    private StudentTableModel dataModel;
    private JTable tabelStudenti = new JTable();
    private JScrollPane scrollPane = new JScrollPane(tabelStudenti);
    private JButton inapoi;
    public ViewStudentsAdminGUI(){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Vizualizare studenti");
        faculties = new JComboBox<>();
        inapoi = new JButton("Înapoi");

        ManagerGUI mng = new ManagerGUI();
        facultati = mng.getInstance().getSetFacultati();
        studenti = mng.getInstance().getSetStudenti();
        int n = studenti.size();
        dataModel = new StudentTableModel(n);
        int i = 0;
        //add faculties in combobox
        faculties.addItem(new Faculty("Toate facultățile"));
        for(Faculty f:facultati){
            faculties.addItem(f);
        }
        //add all students into table
        for(Student s:studenti){
            dataModel.setValueAt(s.getLastName(),i,0);
            dataModel.setValueAt(s.getFirstName(),i,1);
            dataModel.setValueAt(s.getCnp(),i,2);
            dataModel.setValueAt(s.getDob(),i,3);
            dataModel.setValueAt(s.getPhoneNumber(),i,4);
            dataModel.setValueAt(s.getAddress(),i,5);
            dataModel.setValueAt(s.getEmailAddress(),i,6);
            dataModel.setValueAt(s.getFaculty(),i,7);
            dataModel.setValueAt(s.getDepartment(),i,8);
            dataModel.setValueAt(s.getDegree(),i,9);
            dataModel.setValueAt(s.getYear(),i,10);
            dataModel.setValueAt(s.getNumberOfCredits(),i,11);
            i++;
        }
        String[] coloane = {"NUME","PRENUME","CNP","DATA NAȘTERII","NUMĂR DE TELEFON","ADRESĂ","ADRESĂ DE EMAIL","FACULTATE","SPECIALIZARE","CICLU UNIVERSITAR","AN UNIVERSITAR","NUMĂR DE CREDITE"};
        TableModel model = new DefaultTableModel(dataModel.getStudenti(), coloane) {
            public boolean isCellEditable(int row, int column){
                //set cells uneditable
                return false;
            }
        };
        //add elements to the frame
        frame.add(scrollPane);
        frame.add(faculties);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        tabelStudenti.setModel(model);
        scrollPane.setViewportView(tabelStudenti);
        //set table sorter
        tabelStudenti.setAutoCreateRowSorter(true);
        //set bounds for elements
        scrollPane.setBounds(42,110,1100,183);
        faculties.setBounds(42,60,300,25);
        inapoi.setBounds(510,320,145,25);
        //button design
        inapoi.setBorderPainted(false);
        inapoi.setBackground(new Color(233,233,233));
        inapoi.setForeground(new Color(100,100,100));
        //set frame icon
        try {
            frame.setIconImage(ImageIO.read(getClass().getResource("resources/1.png")));
        }catch(IOException ie){
            ie.printStackTrace();
        }
        //set frame size
        frame.setPreferredSize(new Dimension(1200,450));
        frame.setLayout(null);
        frame.pack();
        //set window in the middle of the screen
        frame.setLocationRelativeTo(null);
        //set the default close button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //block resize operation
        frame.setResizable(false);
        //set frame visible
        frame.setVisible(true);
        /*
        ==============
        define actions
        ==============
        */
        //add students into table when selecting a faculty
        faculties.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0, q = 0;
                for(Student s:studenti){
                    if(faculties.getSelectedItem().toString().equals("Toate facultățile")){
                        q = studenti.size();
                        break;
                    }else if(s.getFaculty().equals(faculties.getSelectedItem().toString())){
                        q++;
                    }
                }
                dataModel = new StudentTableModel(q);
                if(e.getSource() == faculties){
                    for(Student s:studenti){
                        if(faculties.getSelectedItem().toString().equals("Toate facultățile")){
                            dataModel.setValueAt(s.getLastName(),i,0);
                            dataModel.setValueAt(s.getFirstName(),i,1);
                            dataModel.setValueAt(s.getCnp(),i,2);
                            dataModel.setValueAt(s.getDob(),i,3);
                            dataModel.setValueAt(s.getPhoneNumber(),i,4);
                            dataModel.setValueAt(s.getAddress(),i,5);
                            dataModel.setValueAt(s.getEmailAddress(),i,6);
                            dataModel.setValueAt(s.getFaculty(),i,7);
                            dataModel.setValueAt(s.getDepartment(),i,8);
                            dataModel.setValueAt(s.getDegree(),i,9);
                            dataModel.setValueAt(s.getYear(),i,10);
                            dataModel.setValueAt(s.getNumberOfCredits(),i,11);
                            i++;
                        }else if(s.getFaculty().equals(faculties.getSelectedItem().toString())){
                            dataModel.setValueAt(s.getLastName(),i,0);
                            dataModel.setValueAt(s.getFirstName(),i,1);
                            dataModel.setValueAt(s.getCnp(),i,2);
                            dataModel.setValueAt(s.getDob(),i,3);
                            dataModel.setValueAt(s.getPhoneNumber(),i,4);
                            dataModel.setValueAt(s.getAddress(),i,5);
                            dataModel.setValueAt(s.getEmailAddress(),i,6);
                            dataModel.setValueAt(s.getFaculty(),i,7);
                            dataModel.setValueAt(s.getDepartment(),i,8);
                            dataModel.setValueAt(s.getDegree(),i,9);
                            dataModel.setValueAt(s.getYear(),i,10);
                            dataModel.setValueAt(s.getNumberOfCredits(),i,11);
                            i++;
                        }
                    }
                }
                String[] coloane = {"NUME","PRENUME","CNP","DATA NAȘTERII","NUMĂR DE TELEFON","ADRESĂ","ADRESĂ DE EMAIL","FACULTATE","SPECIALIZARE","CICLU UNIVERSITAR","AN UNIVERSITAR","NUMĂR DE CREDITE"};
                TableModel model = new DefaultTableModel(dataModel.getStudenti(), coloane) {
                    public boolean isCellEditable(int row, int column){
                        //set cells uneditable
                        return false;
                    }
                };
                tabelStudenti.setModel(model);
            }
        });
        //go back to user menu
        inapoi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setVisible(false);
                AdminMenuGUI window = new AdminMenuGUI();
            }
        });
    }
    public static void main(String[] args){
        ViewStudentsAdminGUI window = new ViewStudentsAdminGUI();
    }
}
