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
    private JButton cautare, eliminare, inapoi, reseteaza;
    private StudentTableModel dataModel = new StudentTableModel();
    private JTable tabelStudenti = new JTable();
    private JScrollPane scrollPane = new JScrollPane(tabelStudenti);
    public RemoveStudentSecretaryGUI(String email){
        frame = new JFrame("Eliminare student");
        frame.getContentPane().setBackground(Color.WHITE);

        searchBox = new JTextField();
        cautare = new JButton("Caută");
        eliminare = new JButton("Elimină student");
        inapoi = new JButton("Înapoi");
        reseteaza = new JButton("Resetează");

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
                studentCautat = searchBox.getText();
                StudentTableModel modelCopy = new StudentTableModel();
                int q = 0;
                for(int i = 0; i < 5; i++) {
                    if (dataModel.getValueAt(i, 0).equals(studentCautat) ||
                            (dataModel.getValueAt(i, 0) + " " + dataModel.getValueAt(i, 1)).equals(studentCautat)) {
                        modelCopy.setValueAt(dataModel.getValueAt(i, 0), q, 0);
                        modelCopy.setValueAt(dataModel.getValueAt(i, 1), q, 1);
                        modelCopy.setValueAt(dataModel.getValueAt(i, 2), q, 2);
                        modelCopy.setValueAt(dataModel.getValueAt(i, 3), q, 3);
                        modelCopy.setValueAt(dataModel.getValueAt(i, 4), q, 4);
                        modelCopy.setValueAt(dataModel.getValueAt(i, 5), q, 5);
                        modelCopy.setValueAt(dataModel.getValueAt(i, 6), q, 6);
                        modelCopy.setValueAt(dataModel.getValueAt(i, 7), q, 7);
                        modelCopy.setValueAt(dataModel.getValueAt(i, 8), q, 8);
                        modelCopy.setValueAt(dataModel.getValueAt(i, 9), q, 9);
                        modelCopy.setValueAt(dataModel.getValueAt(i, 10), q, 10);
                        modelCopy.setValueAt(dataModel.getValueAt(i, 11), q, 11);
                        q++;
                    }
                }
                String[] coloane = {"NUME", "PRENUME", "CNP", "DATA NAȘTERII", "NUMĂR DE TELEFON", "ADRESĂ", "ADRESĂ DE EMAIL", "FACULTATE", "SPECIALIZARE", "CICLU UNIVERSITAR", "AN", "NUMĂR DE CREDITE"};
                TableModel model = new DefaultTableModel(modelCopy.getStudenti(), coloane) {
                    public boolean isCellEditable(int row, int column) {
                        //set cells uneditable
                        return false;
                    }
                };
                tabelStudenti.setModel(model);
            }
        });

        eliminare.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DefaultTableModel model = (DefaultTableModel)tabelStudenti.getModel();
                row = tabelStudenti.getSelectedRow();
                mng.getInstance().removeStudentFromDB(model.getValueAt(row,0).toString(), model.getValueAt(row,1).toString(), model.getValueAt(row,6).toString());
                model.removeRow(row);
            }
        });
        inapoi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setVisible(false);
                SecretaryMenuGUI window = new SecretaryMenuGUI(email);
            }
        });
        reseteaza.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
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
                String[] coloane = {"NUME", "PRENUME", "CNP", "DATA NAȘTERII", "NUMĂR DE TELEFON", "ADRESĂ", "ADRESĂ DE EMAIL", "FACULTATE", "SPECIALIZARE", "CICLU UNIVERSITAR", "AN", "NUMĂR DE CREDITE"};
                TableModel model = new DefaultTableModel(dataModel.getStudenti(), coloane) {
                    public boolean isCellEditable(int row, int column) {
                        //set cells uneditable
                        return false;
                    }
                };
                tabelStudenti.setModel(model);
            }
        });

        String[] coloane = {"NUME", "PRENUME", "CNP", "DATA NAȘTERII", "NUMĂR DE TELEFON", "ADRESĂ", "ADRESĂ DE EMAIL", "FACULTATE", "SPECIALIZARE", "CICLU UNIVERSITAR", "AN", "NUMĂR DE CREDITE"};
        TableModel model = new DefaultTableModel(dataModel.getStudenti(), coloane) {
            public boolean isCellEditable(int row, int column) {
                //set cells uneditable
                return false;
            }
        };

        tabelStudenti.setModel(model);
        scrollPane.setViewportView(tabelStudenti);
        scrollPane.setBounds(42,140,1100,183);
        searchBox.setBounds(42,80,200,25);
        cautare.setBounds(255,80,100,25);
        reseteaza.setBounds(360,80,100,25);
        eliminare.setBounds(420,355,145,25);
        inapoi.setBounds(570,355,145,25);

        frame.add(scrollPane);
        frame.add(searchBox);
        frame.add(cautare);
        frame.add(reseteaza);
        frame.add(eliminare);
        frame.add(inapoi);

        frame.setLayout(null);
        //set frame size
        frame.setPreferredSize(new Dimension(1200,500));
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
