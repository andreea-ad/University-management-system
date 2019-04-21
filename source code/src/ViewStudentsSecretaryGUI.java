import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class ViewStudentsSecretaryGUI {
    private JFrame frame;
    private String facultate = "";
    private HashSet<Department> specializari;
    private HashSet<Student> studenti;
    private HashSet<Department> specializariFacultate;
    private JComboBox<Department> departments;
    private StudentTableModel dataModel = new StudentTableModel();
    private JTable tabelStudenti = new JTable();
    private JScrollPane scrollPane = new JScrollPane(tabelStudenti);
    public ViewStudentsSecretaryGUI(String email){
        frame = new JFrame("Vizualizare studenți");

        ManagerGUI mng = new ManagerGUI();
        studenti = mng.getInstance().getSetStudenti();
        specializari = mng.getInstance().getSetSpecializari();

        facultate += mng.getFacultateDupaEmail(email);

        departments = new JComboBox<>();
        specializariFacultate = new HashSet<>();

        for(Department d:specializari){
            if(d.getFaculty().equals(facultate)){
                departments.addItem(d);
            }
        }


        int i = 0;
        for(Student s:studenti) {
            if (s.getDepartment().equals(departments.getSelectedItem())) {
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
        departments.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0;
                    for(Student s:studenti){
                        if(s.getDepartment().equals(departments.getSelectedItem().toString())){
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
                String[] coloane = {"NUME","PRENUME","CNP","DATA NAȘTERII","NUMĂR DE TELEFON","ADRESĂ","ADRESĂ DE EMAIL","FACULTATE","SPECIALIZARE","CICLU UNIVERSITAR","AN UNIVERSITAR","NUMĂR DE CREDITE"};
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

        String[] coloane = {"NUME","PRENUME","CNP","DATA NAȘTERII","NUMĂR DE TELEFON","ADRESĂ","ADRESĂ DE EMAIL","FACULTATE","SPECIALIZARE","CICLU UNIVERSITAR","AN UNIVERSITAR","NUMĂR DE CREDITE"};
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
        departments.setBounds(42,60,200,25);
        frame.add(scrollPane);
        frame.add(departments);

        frame.setLayout(null);
        //set frame size
        frame.setPreferredSize(new Dimension(930,520));
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
    public static void main(String[] args){
        ViewStudentsSecretaryGUI window = new ViewStudentsSecretaryGUI("litere@gmail.com");
    }
}
