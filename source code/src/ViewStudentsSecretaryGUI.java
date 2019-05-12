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
import java.util.HashSet;

public class ViewStudentsSecretaryGUI {
    private JFrame frame;
    private String facultate;
    private HashSet<Department> specializari;
    private HashSet<Student> studenti;
    private JComboBox<Department> departments;
    private JComboBox<String> degrees;
    private StudentTableModel dataModel;
    private JTable tabelStudenti = new JTable();
    private JScrollPane scrollPane = new JScrollPane(tabelStudenti);
    private JButton inapoi;
    private int n;
    public ViewStudentsSecretaryGUI(String email){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Vizualizare studenți");
        departments = new JComboBox<>();
        degrees = new JComboBox<>();
        inapoi = new JButton("Înapoi");
        ManagerGUI mng = new ManagerGUI();
        studenti = mng.getSetStudenti();
        specializari = mng.getSetSpecializari();
        facultate = mng.getFacultateDupaEmail(email);
        for(Student s:studenti){
            if(s.getFaculty().equals(facultate)){
                n++;
            }
        }
        dataModel = new StudentTableModel(n);
        //add degrees into combobox
        degrees.addItem("Toate ciclurile universitare");
        degrees.addItem("LICENTA");
        degrees.addItem("MASTER");
        degrees.addItem("DOCTORAT");
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
        String[] coloane = {"NUME","PRENUME","CNP","DATA NAȘTERII","NUMĂR DE TELEFON","ADRESĂ","ADRESĂ DE EMAIL","FACULTATE","SPECIALIZARE","CICLU UNIVERSITAR","AN UNIVERSITAR","NUMĂR DE CREDITE"};
        TableModel model = new DefaultTableModel(dataModel.getStudenti(), coloane) {
            public boolean isCellEditable(int row, int column){
                //set cells uneditable
                return false;
            }
        };
        //add elements to the frame
        frame.add(scrollPane);
        frame.add(degrees);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        tabelStudenti.setModel(model);
        scrollPane.setViewportView(tabelStudenti);
        //set table sorter
        tabelStudenti.setAutoCreateRowSorter(true);
        //set bounds for elements
        scrollPane.setBounds(42,110,1300,437);
        degrees.setBounds(42,60,185,25);
        inapoi.setBounds(610,570,145,25);
        //button design
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
        frame.setPreferredSize(new Dimension(1400,700));
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
        //add students when selecting a degree
        degrees.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0, q = 0;
                dataModel.removeTable();
                departments.removeAllItems();
                for(Student s:studenti){
                    if(degrees.getSelectedItem().toString().equals("Toate ciclurile universitare")){
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
                    }else if(s.getDegree().equals(Degree.valueOf(degrees.getSelectedItem().toString())) && s.getFaculty().equals(facultate)){
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
                String[] coloane = {"NUME","PRENUME","CNP","DATA NAȘTERII","NUMĂR DE TELEFON","ADRESĂ","ADRESĂ DE EMAIL","FACULTATE","SPECIALIZARE","CICLU UNIVERSITAR","AN UNIVERSITAR","NUMĂR DE CREDITE"};
                TableModel model = new DefaultTableModel(dataModel.getStudenti(), coloane) {
                    public boolean isCellEditable(int row, int column){
                        //set cells uneditable
                        return false;
                    }
                };
                departments.addItem(new Department("Toate specializările"));
                for(Department d:specializari){
                    if(degrees.getSelectedItem().toString().equals("Toate ciclurile universitare")){
                        if(d.getFaculty().equals(facultate)) {
                            departments.addItem(d);
                        }
                    }else if(d.getDegree().equals(Degree.valueOf(degrees.getSelectedItem().toString()))){
                        if(d.getFaculty().equals(facultate)) {
                            departments.addItem(d);
                        }
                    }

                }
                frame.add(departments);
                departments.setBounds(240,60,300,25);
                tabelStudenti.setModel(model);
            }
        });
        //add students when selecting a department
        departments.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0;
                dataModel.removeTable();
                if(departments.getItemCount() > 0) {
                    for (Student s : studenti) {
                        if (departments.getSelectedItem().toString().equals("Toate specializările") && s.getFaculty().equals(facultate)) {
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
                        } else if (s.getDepartment().equals(departments.getSelectedItem().toString())) {
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
                    String[] coloane = {"NUME","PRENUME","CNP","DATA NAȘTERII","NUMĂR DE TELEFON","ADRESĂ","ADRESĂ DE EMAIL","FACULTATE","SPECIALIZARE","CICLU UNIVERSITAR","AN UNIVERSITAR","NUMĂR DE CREDITE"};
                    TableModel model = new DefaultTableModel(dataModel.getStudenti(), coloane) {
                        public boolean isCellEditable(int row, int column){
                            //set cells uneditable
                            return false;
                        }
                    };
                    tabelStudenti.setModel(model);
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
        ViewStudentsSecretaryGUI window = new ViewStudentsSecretaryGUI("fizica@gmail.com");
    }
}
