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

public class ViewMarksAdminGUI {
    private JFrame frame;
    private JComboBox<Faculty> faculties;
    private JComboBox<Department> departments;
    private JComboBox<Subject> subjects;
    private HashSet<Faculty> facultati;
    private HashSet<MarkByDepartment> note;
    private HashSet<Subject> materii;
    private HashSet<Department> specializari;
    private MarkTableModel dataModel = new MarkTableModel(7);
    private JTable tabelNote = new JTable();
    private JScrollPane scrollPane = new JScrollPane(tabelNote);
    private JButton inapoi;
    public ViewMarksAdminGUI(){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Vizualizare note");
        inapoi = new JButton("Înapoi");
        faculties = new JComboBox<>();
        departments = new JComboBox<>();
        subjects = new JComboBox<>();

        ManagerGUI mng = new ManagerGUI();
        facultati = mng.getInstance().getSetFacultati();
        specializari = mng.getInstance().getSetSpecializari();
        materii = mng.getInstance().getSetMaterii();
        note = mng.getInstance().getSetNoteDupaSpecializare();
        int i = 0;
        //add all faculties in combobox
        faculties.addItem(new Faculty("Toate facultățile"));
        for(Faculty f:facultati){
            faculties.addItem(f);
        }
        //add all marks into table
        for(MarkByDepartment m:note){
            dataModel.setValueAt(m.getStudentLastName() + " " + m.getStudentFirstName(), i, 0);
            dataModel.setValueAt(m.getMark(),i,1);
            dataModel.setValueAt(m.getSubject(), i, 2);
            dataModel.setValueAt(m.getCredits(), i, 3);
            dataModel.setValueAt(m.getProfessor(),i,4);
            dataModel.setValueAt(m.getFaculty(),i,5);
            dataModel.setValueAt(m.getDateAdded(), i, 6);
            i++;
        }
        String[] coloane ={"STUDENT", "NOTĂ","MATERIE","NUMĂR DE CREDITE", "PROFESOR", "FACULTATE", "DATA ULTIMEI MODIFICĂRI"};
        TableModel model = new DefaultTableModel(dataModel.getNote(), coloane) {
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
        tabelNote.setModel(model);
        scrollPane.setViewportView(tabelNote);
        //set bounds for elements
        scrollPane.setBounds(42,110,1100,183);
        faculties.setBounds(42,60,300,25);
        inapoi.setBounds(510,320,145,25);
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
        frame.setPreferredSize(new Dimension(1200,450));
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
        //add marks in table when selecting a faculty
        //display the department combobox
        faculties.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0;
                dataModel.removeTable();
                departments.removeAllItems();
                if (e.getSource() == faculties) {
                    for(MarkByDepartment m:note){
                        if(faculties.getSelectedItem().toString().equals("Toate facultățile")){
                            dataModel.setValueAt(m.getStudentLastName() + " " + m.getStudentFirstName(), i, 0);
                            dataModel.setValueAt(m.getMark(),i,1);
                            dataModel.setValueAt(m.getSubject(), i, 2);
                            dataModel.setValueAt(m.getCredits(), i, 3);
                            dataModel.setValueAt(m.getProfessor(),i,4);
                            dataModel.setValueAt(m.getFaculty(),i,5);
                            dataModel.setValueAt(m.getDateAdded(), i, 6);
                            i++;
                        }else if(m.getFaculty().equals(faculties.getSelectedItem().toString())){
                            dataModel.setValueAt(m.getStudentLastName() + " " + m.getStudentFirstName(), i, 0);
                            dataModel.setValueAt(m.getMark(),i,1);
                            dataModel.setValueAt(m.getSubject(), i, 2);
                            dataModel.setValueAt(m.getCredits(), i, 3);
                            dataModel.setValueAt(m.getProfessor(),i,4);
                            dataModel.setValueAt(m.getFaculty(),i,5);
                            dataModel.setValueAt(m.getDateAdded(), i, 6);
                            i++;
                        }
                    }
                }
                String[] coloane = {"STUDENT", "NOTĂ","MATERIE","NUMĂR DE CREDITE", "PROFESOR", "FACULTATE", "DATA ULTIMEI MODIFICĂRI"};
                TableModel model = new DefaultTableModel(dataModel.getNote(), coloane) {
                    public boolean isCellEditable(int row, int column){
                        //set cells uneditable
                        return false;
                    }
                };
                departments.addItem(new Department("Toate specializările"));
                for(Department d:specializari){
                    if(faculties.getSelectedItem().toString().equals("Toate facultățile")){
                        departments.addItem(d);
                    }else if(d.getFaculty().equals(faculties.getSelectedItem().toString())){
                        departments.addItem(d);
                    }
                }
                tabelNote.setModel(model);
                frame.add(departments);
                departments.setBounds(350,60,300,25);
            }
        });
        departments.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0;
                dataModel.removeTable();
                subjects.removeAllItems();
                if(departments.getItemCount() > 0){
                    for(MarkByDepartment m:note){
                        if(m.getDepartment().equals("Toate specializările")){
                            dataModel.setValueAt(m.getStudentLastName() + " " + m.getStudentFirstName(), i, 0);
                            dataModel.setValueAt(m.getMark(),i,1);
                            dataModel.setValueAt(m.getSubject(), i, 2);
                            dataModel.setValueAt(m.getCredits(), i, 3);
                            dataModel.setValueAt(m.getProfessor(),i,4);
                            dataModel.setValueAt(m.getFaculty(),i,5);
                            dataModel.setValueAt(m.getDateAdded(), i, 6);
                            i++;
                        }
                        else if(m.getDepartment().equals(departments.getSelectedItem().toString())){
                            dataModel.setValueAt(m.getStudentLastName() + " " + m.getStudentFirstName(), i, 0);
                            dataModel.setValueAt(m.getMark(),i,1);
                            dataModel.setValueAt(m.getSubject(), i, 2);
                            dataModel.setValueAt(m.getCredits(), i, 3);
                            dataModel.setValueAt(m.getProfessor(),i,4);
                            dataModel.setValueAt(m.getFaculty(),i,5);
                            dataModel.setValueAt(m.getDateAdded(), i, 6);
                            i++;
                        }
                    }
                    String[] coloane = {"STUDENT", "NOTĂ","MATERIE","NUMĂR DE CREDITE", "PROFESOR", "FACULTATE", "DATA ULTIMEI MODIFICĂRI"};
                    TableModel model = new DefaultTableModel(dataModel.getNote(), coloane) {
                        public boolean isCellEditable(int row, int column) {
                            //set cells uneditable
                            return false;
                        }
                    };
                    subjects.addItem(new Subject("Toate materiile"));
                    for(Subject s:materii){
                        if(departments.getSelectedItem().toString().equals("Toate specializările")&&s.getFaculty().equals(faculties.getSelectedItem().toString())){
                            subjects.addItem(s);
                        }else if(s.getDepartment().equals(departments.getSelectedItem().toString())){
                            subjects.addItem(s);
                        }
                    }
                    tabelNote.setModel(model);
                    frame.add(subjects);
                    subjects.setBounds(658,60,300,25);
                }
            }
        });
        subjects.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0;
                dataModel.removeTable();
                if(subjects.getItemCount() > 0){
                    for(MarkByDepartment m:note){
                        if(m.getSubject().equals("Toate materiile")){
                            dataModel.setValueAt(m.getStudentLastName() + " " + m.getStudentFirstName(), i, 0);
                            dataModel.setValueAt(m.getMark(),i,1);
                            dataModel.setValueAt(m.getSubject(), i, 2);
                            dataModel.setValueAt(m.getCredits(), i, 3);
                            dataModel.setValueAt(m.getProfessor(),i,4);
                            dataModel.setValueAt(m.getFaculty(),i,5);
                            dataModel.setValueAt(m.getDateAdded(), i, 6);
                            i++;
                        }else if(m.getSubject().equals(subjects.getSelectedItem().toString())){
                            dataModel.setValueAt(m.getStudentLastName() + " " + m.getStudentFirstName(), i, 0);
                            dataModel.setValueAt(m.getMark(),i,1);
                            dataModel.setValueAt(m.getSubject(), i, 2);
                            dataModel.setValueAt(m.getCredits(), i, 3);
                            dataModel.setValueAt(m.getProfessor(),i,4);
                            dataModel.setValueAt(m.getFaculty(),i,5);
                            dataModel.setValueAt(m.getDateAdded(), i, 6);
                            i++;
                        }
                    }
                    String[] coloane = {"STUDENT", "NOTĂ","MATERIE","NUMĂR DE CREDITE", "PROFESOR", "FACULTATE", "DATA ULTIMEI MODIFICĂRI"};
                    TableModel model = new DefaultTableModel(dataModel.getNote(), coloane) {
                        public boolean isCellEditable(int row, int column) {
                            //set cells uneditable
                            return false;
                        }
                    };
                    tabelNote.setModel(model);
                }
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
}

