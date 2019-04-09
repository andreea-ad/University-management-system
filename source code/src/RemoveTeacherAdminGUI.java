import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.sql.*;

public class RemoveTeacherAdminGUI {
    private JFrame frame;
    private JButton elimina;
    private HashSet<Faculty> facultati;
    private HashSet<Professor> profesori;
    private JComboBox<Faculty> faculties;
    private JTable tabelProfesori = new JTable();
    private JScrollPane scrollPane = new JScrollPane(tabelProfesori);
    private TeacherTableModel dataModel = new TeacherTableModel();
    public RemoveTeacherAdminGUI(){
        frame = new JFrame("Eliminare profesor");

        faculties = new JComboBox<>();
        elimina = new JButton("Elimină profesor");

        ManagerGUI mng = new ManagerGUI();
        facultati = mng.getInstance().getSetFacultati();
        profesori = mng.getInstance().getSetProfesori();

        for(Faculty f:facultati){
            faculties.addItem(f);
        }
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
                int i=0;
                if(e.getSource()==faculties){
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

        elimina.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DefaultTableModel model = (DefaultTableModel)tabelProfesori.getModel();
                int indexRandSelectat = tabelProfesori.getSelectedRow();
                mng.getInstance().removeTeacherFromDB(model.getValueAt(indexRandSelectat,1).toString(),model.getValueAt(indexRandSelectat,0).toString(),model.getValueAt(indexRandSelectat,6).toString());
                model.removeRow(indexRandSelectat);
            }
        });
        tabelProfesori.setModel(model);
        scrollPane.setViewportView(tabelProfesori);
        scrollPane.setBounds(42, 100, 830, 183);
        faculties.setBounds(100, 60, 300, 30);
        elimina.setBounds(380,320,150,25);
        frame.add(scrollPane);
        frame.add(faculties);
        frame.add(elimina);

        frame.setLayout(null);
        //set frame size
        frame.setPreferredSize(new Dimension(930, 450));
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
