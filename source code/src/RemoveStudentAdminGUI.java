import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

public class RemoveStudentAdminGUI {
    private JFrame frame;
    private JComboBox<String> facultate;
    private JButton eliminare;
    private HashSet<Faculty> facultati;
    private HashSet<Student> studenti;
    private String facultateSelectata;
    private StudentTableModel dataModel = new StudentTableModel();
    private JTable tabelStudenti = new JTable();
    private JScrollPane scrollPane = new JScrollPane(tabelStudenti);
    public RemoveStudentAdminGUI(){
        frame = new JFrame("Eliminare student");
        frame.getContentPane().setBackground(Color.WHITE);

        facultate = new JComboBox<>();
        eliminare = new JButton("Eliminare student");

        ManagerGUI mng = new ManagerGUI();
        facultati = mng.getInstance().getSetFacultati();
        studenti = mng.getInstance().getSetStudenti();

        for(Faculty f:facultati){
            facultate.addItem(f.toString());
        }

        facultateSelectata = String.valueOf(facultate.getSelectedItem());

        int i=0;
        for(Student s:studenti){
            if(s.getFaculty().equals(facultateSelectata)){
                dataModel.setValueAt(s.getLastName(), i, 0);
                dataModel.setValueAt(s.getFirstName(), i, 1);
                dataModel.setValueAt(s.getCnp(), i, 2);
                dataModel.setValueAt(s.getDob(), i, 3);
                dataModel.setValueAt(s.getPhoneNumber(), i, 4);
                dataModel.setValueAt(s.getAddress(), i, 5);
                dataModel.setValueAt(s.getEmailAddress(), i, 6);
                dataModel.setValueAt(s.getFaculty(), i, 7);
                dataModel.setValueAt(s.getDepartment(), i, 8);
                dataModel.setValueAt(s.getDegree(), i, 9);
                dataModel.setValueAt(s.getYear(), i, 10);
                dataModel.setValueAt(s.getNumberOfCredits(), i, 11);
                i++;
            }
        }

        facultate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i=0;
                dataModel.removeTable();
                if (e.getSource() == facultate) {
                    for(Student s:studenti) {
                        if (s.getFaculty().equals(facultateSelectata)) {
                            dataModel.setValueAt(s.getLastName(), i, 0);
                            dataModel.setValueAt(s.getFirstName(), i, 1);
                            dataModel.setValueAt(s.getCnp(), i, 2);
                            dataModel.setValueAt(s.getDob(), i, 3);
                            dataModel.setValueAt(s.getPhoneNumber(), i, 4);
                            dataModel.setValueAt(s.getAddress(), i, 5);
                            dataModel.setValueAt(s.getEmailAddress(), i, 6);
                            dataModel.setValueAt(s.getFaculty(), i, 7);
                            dataModel.setValueAt(s.getDepartment(), i, 8);
                            dataModel.setValueAt(s.getDegree(), i, 9);
                            dataModel.setValueAt(s.getYear(), i, 10);
                            dataModel.setValueAt(s.getNumberOfCredits(), i, 11);
                            i++;
                        }
                    }
                }
                String[] coloane ={"NUME", "PRENUME", "CNP", "DATA NAȘTERII", "NUMĂR DE TELEFON", "ADRESĂ", "ADRESĂ DE EMAIL", "FACULTATE", "SPECIALIZARE", "CICLU UNIVERSITAR", "AN", "NUMĂR DE CREDITE"};
                TableModel model = new DefaultTableModel(dataModel.getStudenti(), coloane)
                {
                    public boolean isCellEditable(int row, int column)
                    {
                        return false;//This causes all cells to be not editable
                    }
                };
                tabelStudenti.setModel(model);
            }
        });

        String[] coloane ={"NUME", "PRENUME", "CNP", "DATA NAȘTERII", "NUMĂR DE TELEFON", "ADRESĂ", "ADRESĂ DE EMAIL", "FACULTATE", "SPECIALIZARE", "CICLU UNIVERSITAR", "AN", "NUMĂR DE CREDITE"};
        TableModel model = new DefaultTableModel(dataModel.getStudenti(), coloane)
        {
            public boolean isCellEditable(int row, int column)
            {
                return false;//This causes all cells to be not editable
            }
        };

        tabelStudenti.setModel(model);
        scrollPane.setViewportView(tabelStudenti);
        scrollPane.setBounds(42,100,830,183);
        facultate.setBounds(100,60,300,25);

        eliminare.setBounds(290,320,300,25);

        eliminare.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DefaultTableModel model = (DefaultTableModel)tabelStudenti.getModel();
                int indexRandSelectat = tabelStudenti.getSelectedRow();
                mng.getInstance().removeStudentFromDB(model.getValueAt(indexRandSelectat,0).toString(), model.getValueAt(indexRandSelectat,1).toString(), model.getValueAt(indexRandSelectat,6).toString());
                model.removeRow(indexRandSelectat);
            }
        });

        frame.add(facultate);
        frame.add(scrollPane);
        frame.add(eliminare);

        frame.setLayout(null);
        //set frame size
        frame.setPreferredSize(new Dimension(930,450));
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
