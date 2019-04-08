import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ViewTeachersAdminGUI {
    private JFrame frame;
    private JComboBox<Faculty> faculties;
    private HashSet<Faculty> facultati;
    private HashSet<Professor> profesori;
    private TeacherTableModel dataModel = new TeacherTableModel();
    private JTable tabelProfesori = new JTable();
    private JScrollPane scrollPane = new JScrollPane(tabelProfesori);

    public ViewTeachersAdminGUI() {
        frame = new JFrame("Vizualizare profesori");

        ManagerGUI mng = new ManagerGUI();
        facultati = mng.getInstance().getSetFacultati();
        faculties = new JComboBox<>();
        for (Faculty f : facultati) {
            faculties.addItem(f);
        }

        profesori = mng.getInstance().getSetProfesori();
        int i = 0;
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
        faculties.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int i = 0;
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
                            return false;//This causes all cells to be not editable
                        }
                    };

                    tabelProfesori.setModel(model);
                }
        });

        String[] coloane = {"NUME", "PRENUME", "CNP", "DATA NAȘTERII", "NUMĂR DE TELEFON", "ADRESĂ", "ADRESĂ DE EMAIL", "FACULTATE", "MATERIE PREDATĂ", "DATA ANGAJĂRII", "SALARIU"};
        TableModel model = new DefaultTableModel(dataModel.getProfesori(), coloane) {
            public boolean isCellEditable(int row, int column) {
                return false;//This causes all cells to be not editable
            }
        };

        tabelProfesori.setModel(model);
        scrollPane.setViewportView(tabelProfesori);
        scrollPane.setBounds(42, 100, 830, 183);
        faculties.setBounds(100, 60, 300, 30);

        frame.add(scrollPane);
        frame.add(faculties);

        frame.setLayout(null);
        //set frame size
        frame.setPreferredSize(new Dimension(930, 520));
        frame.pack();
        //set window in the middle of the screen
        frame.setLocationRelativeTo(null);
        //set the default close button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //block resize operation
        frame.setResizable(false);
        //make visible frame
        frame.setVisible(true);
    }
}

