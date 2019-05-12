import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashSet;

public class ViewStudentsAdminGUI {
    private JFrame frame;
    private JComboBox<Faculty> faculties;
    private JComboBox<Department> departments;
    private JComboBox<String> degrees;
    private HashSet<Faculty> facultati;
    private HashSet<Department> specializari;
    private HashSet<Student> studenti;
    private StudentTableModel dataModel;
    private JTable tabelStudenti = new JTable();
    private JScrollPane scrollPane = new JScrollPane(tabelStudenti);
    private JButton inapoi;
    public ViewStudentsAdminGUI(){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Vizualizare studenti");
        faculties = new JComboBox<>();
        departments = new JComboBox<>();
        degrees = new JComboBox<>();
        inapoi = new JButton("Înapoi");
        ManagerGUI mng = new ManagerGUI();
        facultati = mng.getSetFacultati();
        specializari = mng.getSetSpecializari();
        studenti = mng.getSetStudenti();
        int n = studenti.size();
        dataModel = new StudentTableModel(n);
        int i = 0;
        //add faculties in combobox
        faculties.addItem(new Faculty("Toate facultățile"));
        for(Faculty f:facultati){
            faculties.addItem(f);
        }
        //add degrees into combobox
        degrees.addItem("Toate ciclurile universitare");
        degrees.addItem("LICENTA");
        degrees.addItem("MASTER");
        degrees.addItem("DOCTORAT");
        //add all students into table
        for(Student s:studenti){
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
        String[] coloane = {"NUME","PRENUME","CNP","DATA NAȘTERII","NUMĂR DE TELEFON","ADRESĂ","ADRESĂ DE EMAIL","FACULTATE","SPECIALIZARE","CICLU UNIVERSITAR","AN UNIVERSITAR","NUMĂR DE CREDITE"};
        TableModel model = new DefaultTableModel(dataModel.getStudenti(), coloane) {
            public boolean isCellEditable(int row, int column){
                //set cells uneditable
                return false;
            }
        };
        //add elements to the frame
        frame.add(scrollPane);
        frame.add(faculties);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        tabelStudenti.setModel(model);
        scrollPane.setViewportView(tabelStudenti);
        //set table sorter
        tabelStudenti.setAutoCreateRowSorter(true);
        //set bounds for elements
        scrollPane.setBounds(42,110,1300,437);
        faculties.setBounds(42,60,300,25);
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
        //add students into table when selecting a faculty
        faculties.addActionListener(e -> {
            int i1 = 0, q = 0;
            departments.removeAllItems();
            for(Student s:studenti){
                if(faculties.getSelectedItem().toString().equals("Toate facultățile")){
                    dataModel.removeTable();
                }else if(s.getFaculty().equals(faculties.getSelectedItem().toString())){
                    q++;
                }
            }
            if(!faculties.getSelectedItem().toString().equals("Toate facultățile")){
                dataModel = new StudentTableModel(q);
            }
            for(Student s:studenti){
                if(faculties.getSelectedItem().toString().equals("Toate facultățile")){
                    dataModel.setValueAt(s.getLastName(), i1,0);
                    dataModel.setValueAt(s.getFirstName(), i1,1);
                    dataModel.setValueAt(s.getCnp(), i1,2);
                    dataModel.setValueAt(s.getDob(), i1,3);
                    dataModel.setValueAt(s.getPhoneNumber(), i1,4);
                    dataModel.setValueAt(s.getAddress(), i1,5);
                    dataModel.setValueAt(s.getEmailAddress(), i1,6);
                    dataModel.setValueAt(s.getFaculty(), i1,7);
                    dataModel.setValueAt(s.getDepartment(), i1,8);
                    dataModel.setValueAt(s.getDegree(), i1,9);
                    dataModel.setValueAt(s.getYear(), i1,10);
                    dataModel.setValueAt(s.getNumberOfCredits(), i1,11);
                    i1++;
                }else if(s.getFaculty().equals(faculties.getSelectedItem().toString())){
                    dataModel.setValueAt(s.getLastName(), i1,0);
                    dataModel.setValueAt(s.getFirstName(), i1,1);
                    dataModel.setValueAt(s.getCnp(), i1,2);
                    dataModel.setValueAt(s.getDob(), i1,3);
                    dataModel.setValueAt(s.getPhoneNumber(), i1,4);
                    dataModel.setValueAt(s.getAddress(), i1,5);
                    dataModel.setValueAt(s.getEmailAddress(), i1,6);
                    dataModel.setValueAt(s.getFaculty(), i1,7);
                    dataModel.setValueAt(s.getDepartment(), i1,8);
                    dataModel.setValueAt(s.getDegree(), i1,9);
                    dataModel.setValueAt(s.getYear(), i1,10);
                    dataModel.setValueAt(s.getNumberOfCredits(), i1,11);
                    i1++;
                }
            }
            String[] coloane1 = {"NUME","PRENUME","CNP","DATA NAȘTERII","NUMĂR DE TELEFON","ADRESĂ","ADRESĂ DE EMAIL","FACULTATE","SPECIALIZARE","CICLU UNIVERSITAR","AN UNIVERSITAR","NUMĂR DE CREDITE"};
            TableModel model1 = new DefaultTableModel(dataModel.getStudenti(), coloane1) {
                public boolean isCellEditable(int row, int column){
                    //set cells uneditable
                    return false;
                }
            };
            degrees.setSelectedIndex(0);
            frame.add(degrees);
            degrees.setBounds(350,60,185,25);
            tabelStudenti.setModel(model1);
        });
        //add students into table when selecting a degree
        degrees.addActionListener(e -> {
            int i12 = 0;
            departments.removeAllItems();
            dataModel.removeTable();
            for(Student s:studenti){
                if(faculties.getSelectedItem().toString().equals("Toate facultățile") && degrees.getSelectedItem().toString().equals("Toate ciclurile universitare")) {
                    dataModel.setValueAt(s.getLastName(), i12, 0);
                    dataModel.setValueAt(s.getFirstName(), i12, 1);
                    dataModel.setValueAt(s.getCnp(), i12, 2);
                    dataModel.setValueAt(s.getDob(), i12, 3);
                    dataModel.setValueAt(s.getPhoneNumber(), i12, 4);
                    dataModel.setValueAt(s.getAddress(), i12, 5);
                    dataModel.setValueAt(s.getEmailAddress(), i12, 6);
                    dataModel.setValueAt(s.getFaculty(), i12, 7);
                    dataModel.setValueAt(s.getDepartment(), i12, 8);
                    dataModel.setValueAt(s.getDegree(), i12, 9);
                    dataModel.setValueAt(s.getYear(), i12, 10);
                    dataModel.setValueAt(s.getNumberOfCredits(), i12, 11);
                    i12++;
                }else if(faculties.getSelectedItem().toString().equals("Toate facultățile") && s.getDegree().equals(Degree.valueOf(degrees.getSelectedItem().toString()))) {
                    dataModel.setValueAt(s.getLastName(), i12, 0);
                    dataModel.setValueAt(s.getFirstName(), i12, 1);
                    dataModel.setValueAt(s.getCnp(), i12, 2);
                    dataModel.setValueAt(s.getDob(), i12, 3);
                    dataModel.setValueAt(s.getPhoneNumber(), i12, 4);
                    dataModel.setValueAt(s.getAddress(), i12, 5);
                    dataModel.setValueAt(s.getEmailAddress(), i12, 6);
                    dataModel.setValueAt(s.getFaculty(), i12, 7);
                    dataModel.setValueAt(s.getDepartment(), i12, 8);
                    dataModel.setValueAt(s.getDegree(), i12, 9);
                    dataModel.setValueAt(s.getYear(), i12, 10);
                    dataModel.setValueAt(s.getNumberOfCredits(), i12, 11);
                    i12++;
                }else if(degrees.getSelectedItem().toString().equals("Toate ciclurile universitare") && s.getFaculty().equals(faculties.getSelectedItem().toString())){
                    dataModel.setValueAt(s.getLastName(), i12, 0);
                    dataModel.setValueAt(s.getFirstName(), i12, 1);
                    dataModel.setValueAt(s.getCnp(), i12, 2);
                    dataModel.setValueAt(s.getDob(), i12, 3);
                    dataModel.setValueAt(s.getPhoneNumber(), i12, 4);
                    dataModel.setValueAt(s.getAddress(), i12, 5);
                    dataModel.setValueAt(s.getEmailAddress(), i12, 6);
                    dataModel.setValueAt(s.getFaculty(), i12, 7);
                    dataModel.setValueAt(s.getDepartment(), i12, 8);
                    dataModel.setValueAt(s.getDegree(), i12, 9);
                    dataModel.setValueAt(s.getYear(), i12, 10);
                    dataModel.setValueAt(s.getNumberOfCredits(), i12, 11);
                    i12++;
                }else if(s.getFaculty().equals(faculties.getSelectedItem().toString()) && s.getDegree().equals(Degree.valueOf(degrees.getSelectedItem().toString()))){
                    dataModel.setValueAt(s.getLastName(), i12, 0);
                    dataModel.setValueAt(s.getFirstName(), i12, 1);
                    dataModel.setValueAt(s.getCnp(), i12, 2);
                    dataModel.setValueAt(s.getDob(), i12, 3);
                    dataModel.setValueAt(s.getPhoneNumber(), i12, 4);
                    dataModel.setValueAt(s.getAddress(), i12, 5);
                    dataModel.setValueAt(s.getEmailAddress(), i12, 6);
                    dataModel.setValueAt(s.getFaculty(), i12, 7);
                    dataModel.setValueAt(s.getDepartment(), i12, 8);
                    dataModel.setValueAt(s.getDegree(), i12, 9);
                    dataModel.setValueAt(s.getYear(), i12, 10);
                    dataModel.setValueAt(s.getNumberOfCredits(), i12, 11);
                    i12++;
                }
            }
            String[] coloane12 = {"NUME","PRENUME","CNP","DATA NAȘTERII","NUMĂR DE TELEFON","ADRESĂ","ADRESĂ DE EMAIL","FACULTATE","SPECIALIZARE","CICLU UNIVERSITAR","AN UNIVERSITAR","NUMĂR DE CREDITE"};
            TableModel model12 = new DefaultTableModel(dataModel.getStudenti(), coloane12) {
                public boolean isCellEditable(int row, int column){
                    //set cells uneditable
                    return false;
                }
            };
            departments.addItem(new Department("Toate specializările"));
            for(Department d:specializari){
                if(faculties.getSelectedItem().toString().equals("Toate facultățile") && degrees.getSelectedItem().toString().equals("Toate ciclurile universitare")){
                    departments.addItem(d);
                }else if(d.getFaculty().equals(faculties.getSelectedItem().toString()) && degrees.getSelectedItem().toString().equals("Toate ciclurile universitare")){
                    departments.addItem(d);
                }else if(d.getFaculty().equals(faculties.getSelectedItem().toString()) && d.getDegree().equals(Degree.valueOf(degrees.getSelectedItem().toString()))){
                    departments.addItem(d);
                }
            }
            frame.add(departments);
            departments.setBounds(544,60,300,25);
            tabelStudenti.setModel(model12);
        });
        //add student into table when selecting a department
        departments.addActionListener(e -> {
            int i13 = 0;
            dataModel.removeTable();
            if(departments.getItemCount() > 0){
                for(Student s:studenti){
                    if(faculties.getSelectedItem().toString().equals("Toate facultățile") && degrees.getSelectedItem().toString().equals("Toate ciclurile universitare") && departments.getSelectedItem().toString().equals("Toate specializările")){
                        dataModel.setValueAt(s.getLastName(), i13,0);
                        dataModel.setValueAt(s.getFirstName(), i13,1);
                        dataModel.setValueAt(s.getCnp(), i13,2);
                        dataModel.setValueAt(s.getDob(), i13,3);
                        dataModel.setValueAt(s.getPhoneNumber(), i13,4);
                        dataModel.setValueAt(s.getAddress(), i13,5);
                        dataModel.setValueAt(s.getEmailAddress(), i13,6);
                        dataModel.setValueAt(s.getFaculty(), i13,7);
                        dataModel.setValueAt(s.getDepartment(), i13,8);
                        dataModel.setValueAt(s.getDegree(), i13,9);
                        dataModel.setValueAt(s.getYear(), i13,10);
                        dataModel.setValueAt(s.getNumberOfCredits(), i13,11);
                        i13++;
                    }else if(degrees.getSelectedItem().toString().equals("Toate ciclurile universitare") && departments.getSelectedItem().toString().equals("Toate specializările") && s.getFaculty().equals(faculties.getSelectedItem().toString())){
                        dataModel.setValueAt(s.getLastName(), i13,0);
                        dataModel.setValueAt(s.getFirstName(), i13,1);
                        dataModel.setValueAt(s.getCnp(), i13,2);
                        dataModel.setValueAt(s.getDob(), i13,3);
                        dataModel.setValueAt(s.getPhoneNumber(), i13,4);
                        dataModel.setValueAt(s.getAddress(), i13,5);
                        dataModel.setValueAt(s.getEmailAddress(), i13,6);
                        dataModel.setValueAt(s.getFaculty(), i13,7);
                        dataModel.setValueAt(s.getDepartment(), i13,8);
                        dataModel.setValueAt(s.getDegree(), i13,9);
                        dataModel.setValueAt(s.getYear(), i13,10);
                        dataModel.setValueAt(s.getNumberOfCredits(), i13,11);
                        i13++;
                    } else if(degrees.getSelectedItem().toString().equals("Toate ciclurile universitare") && s.getDepartment().equals(departments.getSelectedItem().toString())){
                        dataModel.setValueAt(s.getLastName(), i13,0);
                        dataModel.setValueAt(s.getFirstName(), i13,1);
                        dataModel.setValueAt(s.getCnp(), i13,2);
                        dataModel.setValueAt(s.getDob(), i13,3);
                        dataModel.setValueAt(s.getPhoneNumber(), i13,4);
                        dataModel.setValueAt(s.getAddress(), i13,5);
                        dataModel.setValueAt(s.getEmailAddress(), i13,6);
                        dataModel.setValueAt(s.getFaculty(), i13,7);
                        dataModel.setValueAt(s.getDepartment(), i13,8);
                        dataModel.setValueAt(s.getDegree(), i13,9);
                        dataModel.setValueAt(s.getYear(), i13,10);
                        dataModel.setValueAt(s.getNumberOfCredits(), i13,11);
                        i13++;
                    }
                }
                String[] coloane13 = {"NUME","PRENUME","CNP","DATA NAȘTERII","NUMĂR DE TELEFON","ADRESĂ","ADRESĂ DE EMAIL","FACULTATE","SPECIALIZARE","CICLU UNIVERSITAR","AN UNIVERSITAR","NUMĂR DE CREDITE"};
                TableModel model13 = new DefaultTableModel(dataModel.getStudenti(), coloane13) {
                    public boolean isCellEditable(int row, int column){
                        //set cells uneditable
                        return false;
                    }
                };
                tabelStudenti.setModel(model13);
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
        ViewStudentsAdminGUI window = new ViewStudentsAdminGUI();
    }
}
