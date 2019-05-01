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

public class RemoveStudentAdminGUI {
    private JFrame frame;
    private String studentCautat;
    private JTextField searchBox;
    private JComboBox<Faculty> facultate;
    private JButton eliminare, cautare, inapoi;
    private HashSet<Faculty> facultati;
    private HashSet<Student> studenti;
    private StudentTableModel dataModel;
    private JTable tabelStudenti = new JTable();
    private JScrollPane scrollPane = new JScrollPane(tabelStudenti);
    public RemoveStudentAdminGUI(){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Eliminare student");
        facultate = new JComboBox<>();
        eliminare = new JButton("Eliminare student");
        cautare = new JButton("Căutare");
        inapoi = new JButton("Înapoi");
        searchBox = new JTextField("");
        ManagerGUI mng = new ManagerGUI();
        facultati = mng.getInstance().getSetFacultati();
        studenti = mng.getInstance().getSetStudenti();
        int n = studenti.size();
        dataModel = new StudentTableModel(n);
        facultate.addItem(new Faculty("Toate facultățile"));
        for(Faculty f:facultati){
            facultate.addItem(f);
        }
        int i = 0;
        for(Student s:studenti){
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
        String[] coloane = {"NUME", "PRENUME", "CNP", "DATA NAȘTERII", "NUMĂR DE TELEFON", "ADRESĂ", "ADRESĂ DE EMAIL", "FACULTATE", "SPECIALIZARE", "CICLU UNIVERSITAR", "AN", "NUMĂR DE CREDITE"};
        TableModel model = new DefaultTableModel(dataModel.getStudenti(), coloane) {
            public boolean isCellEditable(int row, int column) {
                //set cells uneditable
                return false;
            }
        };
        //add elements to the frame
        frame.add(facultate);
        frame.add(scrollPane);
        frame.add(searchBox);
        frame.add(cautare);
        frame.add(eliminare);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        tabelStudenti.setModel(model);
        scrollPane.setViewportView(tabelStudenti);
        //set table sorter
        tabelStudenti.setAutoCreateRowSorter(true);
        //set bounds for elements
        scrollPane.setBounds(42,140,1100,183);
        facultate.setBounds(42,60,300,25);
        searchBox.setBounds(42,100,200,25);
        cautare.setBounds(255,100,100,25);
        eliminare.setBounds(430,350,150,25);
        inapoi.setBounds(590,350,150,25);
        //buttons design
        cautare.setBorderPainted(false);
        cautare.setBackground(new Color(233,233,233));
        cautare.setForeground(new Color(100,100,100));
        eliminare.setBorderPainted(false);
        eliminare.setBackground(new Color(233,233,233));
        eliminare.setForeground(new Color(100,100,100));
        inapoi.setBorderPainted(false);
        inapoi.setBackground(new Color(233,233,233));
        inapoi.setForeground(new Color(100,100,100));
        //set frame icon
        try {
            frame.setIconImage(ImageIO.read(getClass().getResource("resources/1.png")));
        }catch(IOException ie){
            ie.printStackTrace();
        }
        //set frame size
        frame.setPreferredSize(new Dimension(1200,500));
        frame.setLayout(null);
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
        //add students into table when selecting a faculty
        facultate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0, q = 0;
                for(Student s:studenti){
                    if(facultate.getSelectedItem().toString().equals("Toate facultățile")){
                        q = studenti.size();
                        break;
                    }else if(s.getFaculty().equals(facultate.getSelectedItem().toString())){
                        q++;
                    }
                }
                dataModel = new StudentTableModel(q);
                if (e.getSource() == facultate) {
                    for(Student s:studenti) {
                        if(facultate.getSelectedItem().toString().equals("Toate facultățile")){
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
                        }else if(s.getFaculty().equals(facultate.getSelectedItem().toString())) {
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
                TableModel model = new DefaultTableModel(dataModel.getStudenti(), coloane) {
                    public boolean isCellEditable(int row, int column) {
                        //set cells uneditable
                        return false;
                    }
                };
                tabelStudenti.setModel(model);
            }
        });
        //find student into table when hitting enter
        searchBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(searchBox.getText().equals("") || searchBox.getText().equals(" ")){
                    int i = 0;
                    for(Student s:studenti) {
                        if(facultate.getSelectedItem().toString().equals("Toate facultățile")){
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
                        }else if(s.getFaculty().equals(facultate.getSelectedItem().toString())) {
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
                }else{
                    studentCautat = searchBox.getText();
                    StudentTableModel modelCopy = new StudentTableModel(dataModel.getRowCount());
                    int q = 0;
                    for(int i = 0; i < dataModel.getRowCount(); i++) {
                        if (dataModel.getValueAt(i, 0).equals(studentCautat) || dataModel.getValueAt(i,0).toString().toLowerCase().equals(studentCautat) ||
                                (dataModel.getValueAt(i, 0) + " " + dataModel.getValueAt(i, 1)).equals(studentCautat) ||
                                (dataModel.getValueAt(i,0).toString().toLowerCase() + " " + dataModel.getValueAt(i,1).toString().toLowerCase()).equals(studentCautat) ||
                                (dataModel.getValueAt(i, 1) + " " + dataModel.getValueAt(i, 0)).equals(studentCautat) ||
                                (dataModel.getValueAt(i,1).toString().toLowerCase() + " " + dataModel.getValueAt(i,0).toString().toLowerCase()).equals(studentCautat) ||
                                dataModel.getValueAt(i,1).equals(studentCautat) || dataModel.getValueAt(i,1).toString().toLowerCase().equals(studentCautat)){
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
            }
        });
        //find student into table when clicked
        cautare.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                studentCautat = searchBox.getText();
                StudentTableModel modelCopy = new StudentTableModel(dataModel.getRowCount());
                int q = 0;
                for(int i = 0; i < dataModel.getRowCount(); i++) {
                    if (dataModel.getValueAt(i, 0).equals(studentCautat) || dataModel.getValueAt(i,0).toString().toLowerCase().equals(studentCautat) ||
                            (dataModel.getValueAt(i, 0) + " " + dataModel.getValueAt(i, 1)).equals(studentCautat) ||
                            (dataModel.getValueAt(i,0).toString().toLowerCase() + " " + dataModel.getValueAt(i,1).toString().toLowerCase()).equals(studentCautat) ||
                            (dataModel.getValueAt(i, 1) + " " + dataModel.getValueAt(i, 0)).equals(studentCautat) ||
                            (dataModel.getValueAt(i,1).toString().toLowerCase() + " " + dataModel.getValueAt(i,0).toString().toLowerCase()).equals(studentCautat) ||
                            dataModel.getValueAt(i,1).equals(studentCautat) || dataModel.getValueAt(i,1).toString().toLowerCase().equals(studentCautat)){
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
        //delete student from the database and from the table too
        eliminare.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DefaultTableModel model = (DefaultTableModel)tabelStudenti.getModel();
                int indexRandSelectat = tabelStudenti.getSelectedRow();
                mng.getInstance().removeStudentFromDB(model.getValueAt(indexRandSelectat,0).toString(), model.getValueAt(indexRandSelectat,1).toString(), model.getValueAt(indexRandSelectat,6).toString());
                mng.getInstance().removeMarkFromDB(model.getValueAt(indexRandSelectat,0).toString(), model.getValueAt(indexRandSelectat,1).toString());
                model.removeRow(indexRandSelectat);
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
        RemoveStudentAdminGUI window = new RemoveStudentAdminGUI();
    }
}
