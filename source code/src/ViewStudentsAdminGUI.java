import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class ViewStudentsAdminGUI {
    private JFrame frame;
    private JComboBox<Faculty> faculties;
    private HashSet<Faculty> facultati;
    private HashSet<Student> studenti;
    private StudentTableModel dataModel = new StudentTableModel();
    private JTable tabelStudenti = new JTable();
    private JScrollPane scrollPane = new JScrollPane(tabelStudenti);
    public ViewStudentsAdminGUI(){
        frame = new JFrame("Vizualizare studenti");

        ManagerGUI mng = new ManagerGUI();
        facultati = mng.getInstance().getSetFacultati();
        faculties = new JComboBox<Faculty>();
        for(Faculty f:facultati){
            faculties.addItem(f);
        }

        studenti = mng.getInstance().getSetStudenti();

        faculties.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i=0;
                if(e.getSource()==faculties){
                    for(Student s:studenti){
                        if(s.getFaculty().equals(faculties.getSelectedItem().toString())){
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

        faculties.setBounds(100,60,300,30);

        frame.add(scrollPane);
        frame.add(faculties);

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
}
