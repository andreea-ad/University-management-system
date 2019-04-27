import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

public class ViewTeachersAdminGUI {
    private JFrame frame;
    private JComboBox<Faculty> faculties;
    private HashSet<Faculty> facultati;
    private HashSet<Professor> profesori;
    private TeacherTableModel dataModel = new TeacherTableModel();
    private JTable tabelProfesori = new JTable();
    private JScrollPane scrollPane = new JScrollPane(tabelProfesori);
    private JButton inapoi;
    public ViewTeachersAdminGUI() {
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Vizualizare profesori");
        faculties = new JComboBox<>();
        inapoi = new JButton("Înapoi");

        ManagerGUI mng = new ManagerGUI();
        facultati = mng.getInstance().getSetFacultati();
        profesori = mng.getInstance().getSetProfesori();
        String[] coloane = {"NUME", "PRENUME", "CNP", "DATA NAȘTERII", "NUMĂR DE TELEFON", "ADRESĂ", "ADRESĂ DE EMAIL", "FACULTATE", "MATERIE PREDATĂ", "DATA ANGAJĂRII", "SALARIU"};
        int i = 0;
        //add faculties in combobox
        faculties.addItem(new Faculty("Toate facultățile"));
        for (Faculty f : facultati) {
            faculties.addItem(f);
        }
        //add all teachers into table
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
        TableModel model = new DefaultTableModel(dataModel.getProfesori(), coloane) {
            public boolean isCellEditable(int row, int column) {
                //set cells uneditable
                return false;
            }
        };
        frame.add(scrollPane);
        frame.add(faculties);
        frame.add(inapoi);
        frame.getContentPane().setBackground(Color.WHITE);
        tabelProfesori.setModel(model);
        scrollPane.setViewportView(tabelProfesori);
        scrollPane.setBounds(42, 110, 1100, 183);
        faculties.setBounds(42, 60, 300, 25);
        inapoi.setBounds(510,320,145,25);
        frame.setLayout(null);
        //set frame size
        frame.setPreferredSize(new Dimension(1200, 450));
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
        //add teachers into table when selecting a faculty
        faculties.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int i = 0;
                    dataModel.removeTable();
                    if (e.getSource() == faculties) {
                        for (Professor p : profesori) {
                            if (p.getFaculty().equals(faculties.getSelectedItem().toString())) {
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
}

