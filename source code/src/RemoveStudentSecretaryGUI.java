import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashSet;

public class RemoveStudentSecretaryGUI {
    private JFrame frame;
    private String facultate = "", studentCautat;
    private HashSet<Student> studenti;
    private HashSet<Department> specializari;
    private JComboBox<Department> departments;
    private JTextField searchBox;
    private JButton cautare, eliminare, inapoi;
    private StudentTableModel dataModel;
    private JTable tabelStudenti = new JTable();
    private JScrollPane scrollPane = new JScrollPane(tabelStudenti);
    public RemoveStudentSecretaryGUI(String email){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Eliminare student");
        searchBox = new JTextField();
        departments = new JComboBox<>();
        cautare = new JButton("Caută");
        eliminare = new JButton("Elimină student");
        inapoi = new JButton("Înapoi");
        ManagerGUI mng = new ManagerGUI();
        facultate += mng.getFacultateDupaEmail(email);
        studenti = mng.getSetStudenti();
        specializari = mng.getSetSpecializari();
        int n = 0;
        for(Student s:studenti){
            if(s.getFaculty().equals(facultate)){
                n++;
            }
        }
        dataModel = new StudentTableModel(n);
        //add all departments into combobox
        departments.addItem(new Department("Toate specializările"));
        for(Department d:specializari){
            if(d.getFaculty().equals(facultate)){
                departments.addItem(d);
            }
        }
        //add all students into table
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
        //add elements to the frame
        frame.add(scrollPane);
        frame.add(departments);
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
        scrollPane.setBounds(42,170,1300,183);
        departments.setBounds(42,90,312,25);
        searchBox.setBounds(42,130,200,25);
        cautare.setBounds(255,130,100,25);
        eliminare.setBounds(530,400,150,25);
        inapoi.setBounds(690,400,150,25);
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
        departments.setBackground(new Color(233,233,233));
        departments.setForeground(new Color(100,100,100));
        //set frame icon
        try {
            frame.setIconImage(ImageIO.read(getClass().getResource("resources/1.png")));
        }catch(IOException ie){
            ie.printStackTrace();
        }
        //set frame size
        frame.setPreferredSize(new Dimension(1400,550));
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
        //add students into table when selecting a department
        departments.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0, q = 0;
                searchBox.setText("");
                for(Student s:studenti){
                    if(departments.getSelectedItem().toString().equals("Toate specializările") && s.getFaculty().equals(facultate)){
                        q++;
                    }else if(s.getDepartment().equals(departments.getSelectedItem().toString())){
                        q++;
                    }
                }
                dataModel = new StudentTableModel(q);
                for(Student s:studenti){
                    if(departments.getSelectedItem().toString().equals("Toate specializările") && s.getFaculty().equals(facultate)){
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
                    }else if(s.getDepartment().equals(departments.getSelectedItem().toString())){
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
        //update table when emptying the search box
        searchBox.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                int i = 0, q = 0;
                if(departments.getItemCount() > 0) {
                    for(Student s:studenti){
                        if(departments.getSelectedItem().toString().equals("Toate specializările") && s.getFaculty().equals(facultate)){
                            q++;
                        }else if(s.getDepartment().equals(departments.getSelectedItem().toString())){
                            q++;
                        }
                    }
                    dataModel = new StudentTableModel(q);
                    for(Student s:studenti){
                        if(departments.getSelectedItem().toString().equals("Toate specializările") && s.getFaculty().equals(facultate)){
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
                        }else if(s.getDepartment().equals(departments.getSelectedItem().toString())){
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
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        //find student into table when hitting enter
        searchBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (searchBox.getText().equals("") || searchBox.getText().equals(" ")) {
                    int i = 0;
                    for (Student s : studenti) {
                        if(departments.getSelectedItem().toString().equals("Toate specializările") && s.getFaculty().equals(facultate)){
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
                        }else if(s.getDepartment().equals(departments.getSelectedItem().toString())){
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
                } else {
                    studentCautat = searchBox.getText().toLowerCase();
                    DefaultTableModel mod = (DefaultTableModel) tabelStudenti.getModel();
                    int nrStudenti = 0;
                    int j = 0;
                    for (int i = 0; i < mod.getRowCount(); i++) {
                        if (departments.getSelectedItem().toString().equals("Toate specializările") && String.valueOf(mod.getValueAt(i,7)).equals(facultate)) {
                            nrStudenti++;
                        } else if (String.valueOf(mod.getValueAt(i,8)).equals(departments.getSelectedItem().toString())) {
                            nrStudenti++;
                        }
                    }
                    dataModel = new StudentTableModel(nrStudenti);
                    for(int i = 0; i < mod.getRowCount(); i++) {
                       if (departments.getSelectedItem().toString().equals("Toate specializările") &&
                                String.valueOf(mod.getValueAt(i, 7)).equals(facultate) &&
                                (String.valueOf(mod.getValueAt(i, 0)).toLowerCase().equals(studentCautat) ||
                                        String.valueOf(mod.getValueAt(i, 1)).toLowerCase().equals(studentCautat) ||
                                        (String.valueOf(mod.getValueAt(i, 0)).toLowerCase() + " " + String.valueOf(mod.getValueAt(i, 1)).toLowerCase()).equals(studentCautat) ||
                                        (String.valueOf(mod.getValueAt(i, 1)).toLowerCase() + " " + String.valueOf(mod.getValueAt(i, 0)).toLowerCase()).equals(studentCautat))) {
                            dataModel.setValueAt(mod.getValueAt(i, 0), j, 0);
                            dataModel.setValueAt(mod.getValueAt(i, 1), j, 1);
                            dataModel.setValueAt(mod.getValueAt(i, 2), j, 2);
                            dataModel.setValueAt(mod.getValueAt(i, 3), j, 3);
                            dataModel.setValueAt(mod.getValueAt(i, 4), j, 4);
                            dataModel.setValueAt(mod.getValueAt(i, 5), j, 5);
                            dataModel.setValueAt(mod.getValueAt(i, 6), j, 6);
                            dataModel.setValueAt(mod.getValueAt(i, 7), j, 7);
                            dataModel.setValueAt(mod.getValueAt(i, 8), j, 8);
                            dataModel.setValueAt(mod.getValueAt(i, 9), j, 9);
                            dataModel.setValueAt(mod.getValueAt(i, 10), j, 10);
                            dataModel.setValueAt(mod.getValueAt(i, 11), j, 11);
                            j++;
                        } else if (String.valueOf(mod.getValueAt(i, 8)).equals(departments.getSelectedItem().toString()) &&
                                (String.valueOf(mod.getValueAt(i, 0)).toLowerCase().equals(studentCautat) ||
                                        String.valueOf(mod.getValueAt(i, 1)).toLowerCase().equals(studentCautat) ||
                                        (String.valueOf(mod.getValueAt(i, 0)).toLowerCase() + " " + String.valueOf(mod.getValueAt(i, 1)).toLowerCase()).equals(studentCautat) ||
                                        (String.valueOf(mod.getValueAt(i, 1)).toLowerCase() + " " + String.valueOf(mod.getValueAt(i, 0)).toLowerCase()).equals(studentCautat))) {
                            dataModel.setValueAt(mod.getValueAt(i, 0), j, 0);
                            dataModel.setValueAt(mod.getValueAt(i, 1), j, 1);
                            dataModel.setValueAt(mod.getValueAt(i, 2), j, 2);
                            dataModel.setValueAt(mod.getValueAt(i, 3), j, 3);
                            dataModel.setValueAt(mod.getValueAt(i, 4), j, 4);
                            dataModel.setValueAt(mod.getValueAt(i, 5), j, 5);
                            dataModel.setValueAt(mod.getValueAt(i, 6), j, 6);
                            dataModel.setValueAt(mod.getValueAt(i, 7), j, 7);
                            dataModel.setValueAt(mod.getValueAt(i, 8), j, 8);
                            dataModel.setValueAt(mod.getValueAt(i, 9), j, 9);
                            dataModel.setValueAt(mod.getValueAt(i, 10), j, 10);
                            dataModel.setValueAt(mod.getValueAt(i, 11), j, 11);
                            j++;
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
                }
            }
        });
        //find student into table when clicked
        cautare.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (searchBox.getText().equals("") || searchBox.getText().equals(" ")) {
                    int i = 0;
                    for (Student s : studenti) {
                        if(departments.getSelectedItem().toString().equals("Toate specializările") && s.getFaculty().equals(facultate)){
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
                        }else if(s.getDepartment().equals(departments.getSelectedItem().toString())){
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
                } else {
                    studentCautat = searchBox.getText().toLowerCase();
                    DefaultTableModel mod = (DefaultTableModel) tabelStudenti.getModel();
                    int nrStudenti = 0;
                    int j = 0;
                    for (int i = 0; i < mod.getRowCount(); i++) {
                        if (departments.getSelectedItem().toString().equals("Toate specializările") && String.valueOf(mod.getValueAt(i,7)).equals(facultate)) {
                            nrStudenti++;
                        } else if (String.valueOf(mod.getValueAt(i,8)).equals(departments.getSelectedItem().toString())) {
                            nrStudenti++;
                        }
                    }
                    dataModel = new StudentTableModel(nrStudenti);
                    for(int i = 0; i < mod.getRowCount(); i++) {
                        if (departments.getSelectedItem().toString().equals("Toate specializările") &&
                                String.valueOf(mod.getValueAt(i, 7)).equals(facultate) &&
                                (String.valueOf(mod.getValueAt(i, 0)).toLowerCase().equals(studentCautat) ||
                                        String.valueOf(mod.getValueAt(i, 1)).toLowerCase().equals(studentCautat) ||
                                        (String.valueOf(mod.getValueAt(i, 0)).toLowerCase() + " " + String.valueOf(mod.getValueAt(i, 1)).toLowerCase()).equals(studentCautat) ||
                                        (String.valueOf(mod.getValueAt(i, 1)).toLowerCase() + " " + String.valueOf(mod.getValueAt(i, 0)).toLowerCase()).equals(studentCautat))) {
                            dataModel.setValueAt(mod.getValueAt(i, 0), j, 0);
                            dataModel.setValueAt(mod.getValueAt(i, 1), j, 1);
                            dataModel.setValueAt(mod.getValueAt(i, 2), j, 2);
                            dataModel.setValueAt(mod.getValueAt(i, 3), j, 3);
                            dataModel.setValueAt(mod.getValueAt(i, 4), j, 4);
                            dataModel.setValueAt(mod.getValueAt(i, 5), j, 5);
                            dataModel.setValueAt(mod.getValueAt(i, 6), j, 6);
                            dataModel.setValueAt(mod.getValueAt(i, 7), j, 7);
                            dataModel.setValueAt(mod.getValueAt(i, 8), j, 8);
                            dataModel.setValueAt(mod.getValueAt(i, 9), j, 9);
                            dataModel.setValueAt(mod.getValueAt(i, 10), j, 10);
                            dataModel.setValueAt(mod.getValueAt(i, 11), j, 11);
                            j++;
                        } else if (String.valueOf(mod.getValueAt(i, 8)).equals(departments.getSelectedItem().toString()) &&
                                (String.valueOf(mod.getValueAt(i, 0)).toLowerCase().equals(studentCautat) ||
                                        String.valueOf(mod.getValueAt(i, 1)).toLowerCase().equals(studentCautat) ||
                                        (String.valueOf(mod.getValueAt(i, 0)).toLowerCase() + " " + String.valueOf(mod.getValueAt(i, 1)).toLowerCase()).equals(studentCautat) ||
                                        (String.valueOf(mod.getValueAt(i, 1)).toLowerCase() + " " + String.valueOf(mod.getValueAt(i, 0)).toLowerCase()).equals(studentCautat))) {
                            dataModel.setValueAt(mod.getValueAt(i, 0), j, 0);
                            dataModel.setValueAt(mod.getValueAt(i, 1), j, 1);
                            dataModel.setValueAt(mod.getValueAt(i, 2), j, 2);
                            dataModel.setValueAt(mod.getValueAt(i, 3), j, 3);
                            dataModel.setValueAt(mod.getValueAt(i, 4), j, 4);
                            dataModel.setValueAt(mod.getValueAt(i, 5), j, 5);
                            dataModel.setValueAt(mod.getValueAt(i, 6), j, 6);
                            dataModel.setValueAt(mod.getValueAt(i, 7), j, 7);
                            dataModel.setValueAt(mod.getValueAt(i, 8), j, 8);
                            dataModel.setValueAt(mod.getValueAt(i, 9), j, 9);
                            dataModel.setValueAt(mod.getValueAt(i, 10), j, 10);
                            dataModel.setValueAt(mod.getValueAt(i, 11), j, 11);
                            j++;
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
                }
            }
        });
        //remove student from the database and from the table too
        eliminare.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    DefaultTableModel model = (DefaultTableModel) tabelStudenti.getModel();
                    int indexRandSelectat = tabelStudenti.getSelectedRow();
                    mng.removeStudentFromDB(model.getValueAt(indexRandSelectat, 0).toString(), model.getValueAt(indexRandSelectat, 1).toString(), model.getValueAt(indexRandSelectat, 6).toString());
                    mng.removeMarkFromDB(model.getValueAt(indexRandSelectat, 0).toString(), model.getValueAt(indexRandSelectat, 1).toString());
                    model.removeRow(indexRandSelectat);
                }catch (Exception e1){
                    JOptionPane.showMessageDialog(null, "Selectați o înregistrare din tabel!");
                }
            }
        });
        //go back to user menu
        inapoi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setVisible(false);
                SecretaryMenuGUI window = new SecretaryMenuGUI(email);
            }
        });
    }
    public static void main(String[] args){
        RemoveStudentSecretaryGUI window = new RemoveStudentSecretaryGUI("arte@gmail.com");
    }
}
