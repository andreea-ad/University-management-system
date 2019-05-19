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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class EditTeacherAdminGUI {
    private JFrame frame;
    private JComboBox<Faculty> faculties;
    private HashSet<Faculty> facultati;
    private HashSet<Professor> profesori;
    private TeacherTableModel dataModel;
    private JTable tabelProfesori = new JTable();
    private JScrollPane scrollPane = new JScrollPane(tabelProfesori);
    private JButton selecteaza, inapoi;
    public EditTeacherAdminGUI() {
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Modificare date profesor");
        faculties = new JComboBox<>();
        selecteaza = new JButton("Selectează");
        inapoi = new JButton("Înapoi");
        ManagerGUI mng = new ManagerGUI();
        facultati = mng.getSetFacultati();
        profesori = mng.getSetProfesori();
        int n = profesori.size();
        dataModel = new TeacherTableModel(n);
        //add all faculties into combobox
        faculties.addItem(new Faculty("Toate facultățile"));
        for (Faculty f:facultati) {
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
        frame.add(selecteaza);
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
        selecteaza.setBounds(440,320,150,25);
        inapoi.setBounds(600,320,150,25);
        //button design
        selecteaza.setBorderPainted(false);
        selecteaza.setBackground(new Color(233,233,233));
        selecteaza.setForeground(new Color(100,100,100));
        inapoi.setBorderPainted(false);
        inapoi.setBackground(new Color(233,233,233));
        inapoi.setForeground(new Color(100,100,100));
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
        //show edit menu when picking a teacher
        selecteaza.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    DefaultTableModel model = (DefaultTableModel) tabelProfesori.getModel();
                    int indexRandSelectat = tabelProfesori.getSelectedRow();
                    frame.setVisible(false);
                    EditTeacherGUI window = new EditTeacherGUI(model.getValueAt(indexRandSelectat, 0).toString(), model.getValueAt(indexRandSelectat, 1).toString(), model.getValueAt(indexRandSelectat, 2).toString(), (Date) model.getValueAt(indexRandSelectat, 3), model.getValueAt(indexRandSelectat, 4).toString(), model.getValueAt(indexRandSelectat, 5).toString(), model.getValueAt(indexRandSelectat, 6).toString(), model.getValueAt(indexRandSelectat, 7).toString(), model.getValueAt(indexRandSelectat, 8).toString(), (Date) model.getValueAt(indexRandSelectat, 9), (int) model.getValueAt(indexRandSelectat, 10));
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
        EditTeacherAdminGUI window = new EditTeacherAdminGUI();
    }

}
