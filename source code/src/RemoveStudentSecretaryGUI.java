import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;

public class RemoveStudentSecretaryGUI {
    private JFrame frame;
    private int row;
    private String facultate = "", studentCautat;
    private HashSet<Student> studenti;
    private JTextField searchBox;
    private JButton cautare, eliminare;
    private StudentTableModel dataModel = new StudentTableModel();
    private JTable tabelStudenti = new JTable();
    private JScrollPane scrollPane = new JScrollPane(tabelStudenti);
    public RemoveStudentSecretaryGUI(String email){
        frame = new JFrame("Eliminare student");
        frame.getContentPane().setBackground(Color.WHITE);

        searchBox = new JTextField();
        cautare = new JButton("Caută student");
        eliminare = new JButton("Eliminare student");

        ManagerGUI mng = new ManagerGUI();
        facultate += mng.getInstance().getFacultateDupaEmail(email);
        studenti = mng.getInstance().getSetStudenti();

        int i = 0;
        for(Student s:studenti) {
            if(s.getFaculty().equals(facultate)) {
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

        cautare.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                studentCautat = searchBox.getText().toLowerCase();
                StudentTableModel dataModel = (StudentTableModel)tabelStudenti.getModel();
                Object[][] studenti = dataModel.getStudenti();
                for(int i = 0; i < dataModel.getRowCount(); i++){
                    if(((studenti[i][0] + " " +studenti[i][1]).toLowerCase().equals(studentCautat))||
                            ((studenti[i][1] + " " + studenti[i][0]).toLowerCase().equals(studentCautat))||
                            (studenti[i][0].equals(studentCautat))||
                            (studenti[i][1].equals(studentCautat))){
                        row = i;
                        dataModel.removeTable();
                        dataModel.setValueAt(studenti[row][0],row,0);
                        dataModel.setValueAt(studenti[row][1],row,1);
                        dataModel.setValueAt(studenti[row][2],row,2);
                        dataModel.setValueAt(studenti[row][3],row,3);
                        dataModel.setValueAt(studenti[row][4],row,4);
                        dataModel.setValueAt(studenti[row][5],row,5);
                        dataModel.setValueAt(studenti[row][6],row,6);
                        dataModel.setValueAt(studenti[row][7],row,7);
                        dataModel.setValueAt(studenti[row][8],row,8);
                        dataModel.setValueAt(studenti[row][9],row,9);
                        dataModel.setValueAt(studenti[row][10],row,10);
                        dataModel.setValueAt(studenti[row][11],row,11);
                        tabelStudenti.setModel(dataModel);
                        System.out.println("A");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Studentul căutat nu există în sistem","Student inexistent",JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });

        eliminare.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DefaultTableModel model = (DefaultTableModel)tabelStudenti.getModel();
                mng.getInstance().removeStudentFromDB(model.getValueAt(row,0).toString(), model.getValueAt(row,1).toString(), model.getValueAt(row,6).toString());
                model.removeRow(row);
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
        searchBox.setBounds(42,70,200,25);
        cautare.setBounds(255,70,150,25);
        eliminare.setBounds(230,300,100,25);
        frame.add(scrollPane);
        frame.add(searchBox);
        frame.add(cautare);
        frame.add(eliminare);

        frame.setLayout(null);
        //set frame size
        frame.setPreferredSize(new Dimension(930,500));
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
        RemoveStudentSecretaryGUI window = new RemoveStudentSecretaryGUI("litere@gmail.com");
    }
}
