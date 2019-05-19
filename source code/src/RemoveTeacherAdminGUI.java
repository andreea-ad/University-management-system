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
import java.util.*;

public class RemoveTeacherAdminGUI {
    private JFrame frame;
    private JButton elimina, inapoi;
    private HashSet<Faculty> facultati;
    private HashSet<Professor> profesori;
    private JComboBox<Faculty> faculties;
    private JTable tabelProfesori = new JTable();
    private JScrollPane scrollPane = new JScrollPane(tabelProfesori);
    private TeacherTableModel dataModel;
    public RemoveTeacherAdminGUI(){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Eliminare profesor");
        faculties = new JComboBox<>();
        elimina = new JButton("Elimină profesor");
        inapoi = new JButton("Înapoi");
        ManagerGUI mng = new ManagerGUI();
        facultati = mng.getSetFacultati();
        profesori = mng.getSetProfesori();
        int n = profesori.size();
        dataModel = new TeacherTableModel(n);
        //add faculties into combobox
        faculties.addItem(new Faculty("Toate facultățile"));
        for(Faculty f:facultati){
            faculties.addItem(f);
        }
        //add all teachers into table
        int i = 0;
        for (Professor p:profesori) {
            dataModel.setValueAt(p.getLastName(), i, 0);
            dataModel.setValueAt(p.getFirstName(), i, 1);
            dataModel.setValueAt(p.getCnp(), i, 2);
            dataModel.setValueAt(p.getDob(), i, 3);
            dataModel.setValueAt(p.getPhoneNumber(), i, 4);
            dataModel.setValueAt(p.getAddress(), i, 5);
            dataModel.setValueAt(p.getEmailAddress(), i, 6);
            dataModel.setValueAt(p.getFaculty(), i, 7);
            dataModel.setValueAt(p.getTeachingSubject(), i, 8);
            dataModel.setValueAt(p.getHireDate(), i, 9);
            dataModel.setValueAt(p.getSalary(), i, 10);
            i++;
        }
        String[] coloane = {"NUME", "PRENUME", "CNP", "DATA NAȘTERII", "NUMĂR DE TELEFON", "ADRESĂ", "ADRESĂ DE EMAIL", "FACULTATE", "MATERIE PREDATĂ", "DATA ANGAJĂRII", "SALARIU"};
        TableModel model = new DefaultTableModel(dataModel.getProfesori(), coloane) {
            public boolean isCellEditable(int row, int column) {
                //set cells uneditable
                return false;
            }
        };
        //add elements to the frame
        frame.add(scrollPane);
        frame.add(faculties);
        frame.add(elimina);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        tabelProfesori.setModel(model);
        scrollPane.setViewportView(tabelProfesori);
        //set table sorter
        tabelProfesori.setAutoCreateRowSorter(true);
        //set bounds for elements
        scrollPane.setBounds(42, 110, 1100, 183);
        faculties.setBounds(42, 60, 300, 25);
        elimina.setBounds(440,320,150,25);
        inapoi.setBounds(600,320,150,25);
        //button design
        inapoi.setBorderPainted(false);
        inapoi.setBackground(new Color(233,233,233));
        inapoi.setForeground(new Color(100,100,100));
        elimina.setBorderPainted(false);
        elimina.setBackground(new Color(233,233,233));
        elimina.setForeground(new Color(100,100,100));
        faculties.setBackground(new Color(233,233,233));
        faculties.setForeground(new Color(100,100,100));
        //set frame icon
        try {
            frame.setIconImage(ImageIO.read(getClass().getResource("resources/1.png")));
        }catch(IOException ie){
            ie.printStackTrace();
        }
        //set frame size
        frame.setPreferredSize(new Dimension(1200, 450));
        frame.setLayout(null);
        frame.pack();
        //set window in the middle of the screen
        frame.setLocationRelativeTo(null);
        //set the default close button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set frame visible
        frame.setVisible(true);
        /*
        ==============
        define actions
        ==============
        */
        //add teachers into table when selecting a faculty
        faculties.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0, q = 0;
                for(Professor p:profesori){
                    if(faculties.getSelectedItem().toString().equals("Toate facultățile")){
                        q = profesori.size();
                        break;
                    }else if(p.getFaculty().equals(faculties.getSelectedItem().toString())){
                        q++;
                    }
                }
                dataModel = new TeacherTableModel(q);
                    for(Professor p:profesori) {
                        if(faculties.getSelectedItem().toString().equals("Toate facultățile")){
                            dataModel.setValueAt(p.getLastName(), i, 0);
                            dataModel.setValueAt(p.getFirstName(), i, 1);
                            dataModel.setValueAt(p.getCnp(), i, 2);
                            dataModel.setValueAt(p.getDob(), i, 3);
                            dataModel.setValueAt(p.getPhoneNumber(), i, 4);
                            dataModel.setValueAt(p.getAddress(), i, 5);
                            dataModel.setValueAt(p.getEmailAddress(), i, 6);
                            dataModel.setValueAt(p.getFaculty(), i, 7);
                            dataModel.setValueAt(p.getTeachingSubject(), i, 8);
                            dataModel.setValueAt(p.getHireDate(), i, 9);
                            dataModel.setValueAt(p.getSalary(), i, 10);
                            i++;
                        }else if (p.getFaculty().equals(faculties.getSelectedItem().toString())) {
                            dataModel.setValueAt(p.getLastName(), i, 0);
                            dataModel.setValueAt(p.getFirstName(), i, 1);
                            dataModel.setValueAt(p.getCnp(), i, 2);
                            dataModel.setValueAt(p.getDob(), i, 3);
                            dataModel.setValueAt(p.getPhoneNumber(), i, 4);
                            dataModel.setValueAt(p.getAddress(), i, 5);
                            dataModel.setValueAt(p.getEmailAddress(), i, 6);
                            dataModel.setValueAt(p.getFaculty(), i, 7);
                            dataModel.setValueAt(p.getTeachingSubject(), i, 8);
                            dataModel.setValueAt(p.getHireDate(), i, 9);
                            dataModel.setValueAt(p.getSalary(), i, 10);
                            i++;
                        }
                    }
                String[] coloane = {"NUME", "PRENUME", "CNP", "DATA NAȘTERII", "NUMĂR DE TELEFON", "ADRESĂ", "ADRESĂ DE EMAIL", "FACULTATE", "MATERIE PREDATĂ", "DATA ANGAJĂRII", "SALARIU"};
                TableModel model = new DefaultTableModel(dataModel.getProfesori(), coloane) {
                    public boolean isCellEditable(int row, int column) {
                        //set cells uneditable
                        return false;
                    }
                };
                tabelProfesori.setModel(model);
            }
        });
        //remove the selected teacher from the database and from the table too
        elimina.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    DefaultTableModel model = (DefaultTableModel) tabelProfesori.getModel();
                    int indexRandSelectat = tabelProfesori.getSelectedRow();
                    mng.removeTeacherFromDB(model.getValueAt(indexRandSelectat, 1).toString(), model.getValueAt(indexRandSelectat, 0).toString(), model.getValueAt(indexRandSelectat, 6).toString());
                    model.removeRow(indexRandSelectat);
                }catch (Exception e1){
                    JOptionPane.showMessageDialog(null, "Selectați o înregistrare din tabel!");
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
        RemoveTeacherAdminGUI window = new RemoveTeacherAdminGUI();
    }
}
