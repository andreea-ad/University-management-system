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

public class EditSubjectAdminGUI {
    private JFrame frame;
    private HashSet<Faculty> facultati;
    private HashSet<Department> specializari;
    private HashSet<Subject> materii;
    private JComboBox<Faculty> faculties;
    private JComboBox<Department> departments;
    private SubjectTableModel dataModel;
    private JTable tabelMaterii = new JTable();
    private JScrollPane scrollPane = new JScrollPane(tabelMaterii);
    private JButton selecteaza, inapoi;
    public EditSubjectAdminGUI(){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Modificare materie");
        faculties = new JComboBox<>();
        departments = new JComboBox<>();
        selecteaza = new JButton("Selectează");
        inapoi = new JButton("Înapoi");
        ManagerGUI mng = new ManagerGUI();
        facultati = mng.getSetFacultati();
        specializari = mng.getSetSpecializari();
        materii = mng.getSetMaterii();
        int n = materii.size();
        dataModel = new SubjectTableModel(n);
        //add all faculties into combobox
        faculties.addItem(new Faculty("Toate facultățile"));
        for(Faculty f:facultati){
            faculties.addItem(f);
        }
        //add all subjects into table
        int i = 0;
        for(Subject s:materii){
            dataModel.setValueAt(s.getTitle(),i,0);
            dataModel.setValueAt(s.getFaculty(),i,1);
            dataModel.setValueAt(s.getDepartment(),i,2);
            dataModel.setValueAt(s.getDegree(),i,3);
            dataModel.setValueAt(s.getSemester(),i,4);
            dataModel.setValueAt(s.getNumberOfCredits(),i,5);
            dataModel.setValueAt(s.getTeacherLastName() + " " + s.getTeacherFirstName(),i,6);
            i++;
        }
        String[] coloane = {"DENUMIRE", "FACULTATE", "SPECIALIZARE", "CICLU UNIVERSITAR", "SEMESTRU", "NUMĂR DE CREDITE", "PROFESOR"};
        TableModel model = new DefaultTableModel(dataModel.getMaterii(), coloane) {
            public boolean isCellEditable(int row, int column) {
                //set cells uneditable
                return false;
            }
        };
        //add elements to the frame
        frame.add(scrollPane);
        frame.add(faculties);
        frame.add(selecteaza);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        tabelMaterii.setModel(model);
        scrollPane.setViewportView(tabelMaterii);
        //set table sorter
        tabelMaterii.setAutoCreateRowSorter(true);
        //set bounds for elements
        faculties.setBounds(42,60,300,25);
        scrollPane.setBounds(42,110,1300,437);
        selecteaza.setBounds(530,575,145,25);
        inapoi.setBounds(690,575,145,25);
        //buttons design
        selecteaza.setBorderPainted(false);
        selecteaza.setBackground(new Color(233,233,233));
        selecteaza.setForeground(new Color(100,100,100));
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
        frame.setPreferredSize(new Dimension(1400,700));
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
        //add departments and subjects when selecting a faculty
        faculties.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0, q = 0;
                departments.removeAllItems();
                for(Subject s:materii){
                    if(faculties.getSelectedItem().toString().equals("Toate facultățile")){
                        q = facultati.size();
                    }else if(s.getFaculty().equals(faculties.getSelectedItem().toString())){
                        q++;
                    }
                }
                dataModel = new SubjectTableModel(q);
                for(Subject s:materii){
                    if(faculties.getSelectedItem().toString().equals("Toate facultățile")){
                        dataModel.setValueAt(s.getTitle(),i,0);
                        dataModel.setValueAt(s.getFaculty(),i,1);
                        dataModel.setValueAt(s.getDepartment(),i,2);
                        dataModel.setValueAt(s.getDegree(),i,3);
                        dataModel.setValueAt(s.getSemester(),i,4);
                        dataModel.setValueAt(s.getNumberOfCredits(),i,5);
                        dataModel.setValueAt(s.getTeacherLastName() + " " + s.getTeacherFirstName(),i,6);
                        i++;
                    }else if(s.getFaculty().equals(faculties.getSelectedItem().toString())){
                        dataModel.setValueAt(s.getTitle(),i,0);
                        dataModel.setValueAt(s.getFaculty(),i,1);
                        dataModel.setValueAt(s.getDepartment(),i,2);
                        dataModel.setValueAt(s.getDegree(),i,3);
                        dataModel.setValueAt(s.getSemester(),i,4);
                        dataModel.setValueAt(s.getNumberOfCredits(),i,5);
                        dataModel.setValueAt(s.getTeacherLastName() + " " + s.getTeacherFirstName(),i,6);
                        i++;
                    }
                }
                departments.addItem(new Department("Toate specializările"));
                for(Department d:specializari){
                    if(faculties.getSelectedItem().toString().equals("Toate facultățile")){
                        departments.addItem(d);
                    }else if(d.getFaculty().equals(faculties.getSelectedItem().toString())){
                        departments.addItem(d);
                    }
                }
                tabelMaterii.setModel(dataModel);
            }
        });
        //show edit menu when picking a subject
        selecteaza.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    DefaultTableModel model = (DefaultTableModel) tabelMaterii.getModel();
                    int indexRandSelectat = tabelMaterii.getSelectedRow();
                    frame.setVisible(false);
                    String[] profesor = String.valueOf(model.getValueAt(indexRandSelectat, 6)).split(" ");
                    EditSubjectGUI window = new EditSubjectGUI(model.getValueAt(indexRandSelectat, 0).toString(), model.getValueAt(indexRandSelectat, 1).toString(), model.getValueAt(indexRandSelectat, 2).toString(), model.getValueAt(indexRandSelectat, 3).toString(), (int) model.getValueAt(indexRandSelectat, 4), (int) model.getValueAt(indexRandSelectat, 5), model.getValueAt(indexRandSelectat, 6).toString());
                }catch (Exception e1){
                    JOptionPane.showMessageDialog(null,"Selectați o înregistrare din tabel!");
                }
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
        EditSubjectAdminGUI window = new EditSubjectAdminGUI();
    }
}
