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

public class RemoveMarkAdminGUI {
    private JFrame frame;
    private JComboBox<Faculty> faculties;
    private JComboBox<Department> departments;
    private JComboBox<Subject> subjects;
    private HashSet<Faculty> facultati;
    private HashSet<MarkByDepartment> note;
    private HashSet<Department> specializari;
    private HashSet<Subject> materii;
    private MarkTableModel dataModel;
    private JTable tabelNote = new JTable();
    private JScrollPane scrollPane = new JScrollPane(tabelNote);
    private JButton eliminare, inapoi;
    private String[] numeStudent;
    public RemoveMarkAdminGUI(){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Eliminare note");
        eliminare = new JButton("Elimină notă");
        inapoi = new JButton("Înapoi");
        faculties = new JComboBox<>();
        departments = new JComboBox<>();
        subjects = new JComboBox<>();
        ManagerGUI mng = new ManagerGUI();
        facultati = mng.getSetFacultati();
        note = mng.getSetNoteDupaSpecializare();
        specializari = mng.getSetSpecializari();
        materii = mng.getSetMaterii();
        int n = note.size();
        dataModel = new MarkTableModel(n,7);
        //add all faculties into combobox
        faculties.addItem(new Faculty("Toate facultățile"));
        for(Faculty f:facultati){
            faculties.addItem(f);
        }
        //add all departments into combobox
        departments.addItem(new Department("Toate specializările"));
        for(Department d:specializari){
            departments.addItem(d);
        }
        //add all subjects into combobox
        subjects.addItem(new Subject("Toate materiile"));
        for(Subject s:materii){
            subjects.addItem(s);
        }
        //add all marks into table
        int i = 0;
        for(MarkByDepartment m:note){
            dataModel.setValueAt(m.getStudentLastName()+" "+m.getStudentFirstName(), i, 0);
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
            public boolean isCellEditable(int row, int column) {
                //set cells uneditable
                return false;
            }
        };
        //add elements to the frame
        frame.add(scrollPane);
        frame.add(faculties);
        frame.add(departments);
        frame.add(subjects);
        frame.add(eliminare);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        tabelNote.setModel(model);
        scrollPane.setViewportView(tabelNote);
        //set table sorter
        tabelNote.setAutoCreateRowSorter(true);
        //set bounds for elements
        scrollPane.setBounds(42,130,1100,183);
        faculties.setBounds(42,80,300,25);
        departments.setBounds(350,80,300,25);
        subjects.setBounds(660,80,200,25);
        eliminare.setBounds(430,335,145,25);
        inapoi.setBounds(590,335,145,25);
        //buttons design
        eliminare.setBorderPainted(false);
        eliminare.setBackground(new Color(233,233,233));
        eliminare.setForeground(new Color(100,100,100));
        inapoi.setBorderPainted(false);
        inapoi.setBackground(new Color(233,233,233));
        inapoi.setForeground(new Color(100,100,100));
        faculties.setBackground(new Color(233,233,233));
        faculties.setForeground(new Color(100,100,100));
        departments.setBackground(new Color(233,233,233));
        departments.setForeground(new Color(100,100,100));
        subjects.setBackground(new Color(233,233,233));
        subjects.setForeground(new Color(100,100,100));
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
        //set frame visible
        frame.setVisible(true);
        /*
        ==============
        define actions
        ==============
        */
        //add marks into table when selecting a faculty
        faculties.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0, q = 0;
                departments.removeAllItems();
                subjects.removeAllItems();
                for(MarkByDepartment m:note){
                    if(faculties.getSelectedItem().toString().equals("Toate facultățile")){
                        q = note.size();
                        break;
                    }else if(m.getFaculty().equals(faculties.getSelectedItem().toString())){
                        q++;
                    }
                }
                dataModel = new MarkTableModel(q,7);
                for(MarkByDepartment m:note){
                    if(faculties.getSelectedItem().toString().equals("Toate facultățile")){
                        dataModel.setValueAt(m.getStudentLastName() + " " + m.getStudentFirstName(), i, 0);
                        dataModel.setValueAt(m.getMark(), i, 1);
                        dataModel.setValueAt(m.getSubject(), i, 2);
                        dataModel.setValueAt(m.getCredits(), i, 3);
                        dataModel.setValueAt(m.getProfessor(), i, 4);
                        dataModel.setValueAt(m.getFaculty(), i, 5);
                        dataModel.setValueAt(m.getDateAdded(), i, 6);
                        i++;
                    }else if(m.getFaculty().equals(faculties.getSelectedItem().toString())){
                        dataModel.setValueAt(m.getStudentLastName() + " " + m.getStudentFirstName(), i, 0);
                        dataModel.setValueAt(m.getMark(), i, 1);
                        dataModel.setValueAt(m.getSubject(), i, 2);
                        dataModel.setValueAt(m.getCredits(), i, 3);
                        dataModel.setValueAt(m.getProfessor(), i, 4);
                        dataModel.setValueAt(m.getFaculty(), i, 5);
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
                departments.addItem(new Department("Toate specializările"));
                for(Department d:specializari){
                    if(faculties.getSelectedItem().toString().equals("Toate facultățile")){
                        departments.addItem(d);
                    }else if(d.getFaculty().equals(faculties.getSelectedItem().toString())){
                        departments.addItem(d);
                    }
                }
                subjects.addItem(new Subject("Toate materiile"));
                for(Subject s:materii){
                    if(faculties.getSelectedItem().toString().equals("Toate facultățile")){
                        subjects.addItem(s);
                    }else if(s.getFaculty().equals(faculties.getSelectedItem().toString())){
                        subjects.addItem(s);
                    }
                }
                tabelNote.setModel(model);
            }
        });
        //add marks into table when selecting a department
        departments.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0, q = 0;
                subjects.removeAllItems();
                if(departments.getItemCount() > 0){
                    for(MarkByDepartment m:note){
                        if(faculties.getSelectedItem().toString().equals("Toate facultățile") && departments.getSelectedItem().toString().equals("Toate specializările")) {
                            q = note.size();
                            break;
                        }else if(departments.getSelectedItem().toString().equals("Toate specializările") && m.getFaculty().equals(faculties.getSelectedItem().toString())){
                            q++;
                        }else if(m.getDepartment().equals(departments.getSelectedItem().toString())){
                            q++;
                        }
                    }
                    dataModel = new MarkTableModel(q,7);
                    for(MarkByDepartment m:note){
                        if(departments.getSelectedItem().toString().equals("Toate specializările") && faculties.getSelectedItem().toString().equals("Toate facultățile")){
                            dataModel.setValueAt(m.getStudentLastName() + " " + m.getStudentFirstName(), i, 0);
                            dataModel.setValueAt(m.getMark(), i, 1);
                            dataModel.setValueAt(m.getSubject(), i, 2);
                            dataModel.setValueAt(m.getCredits(), i, 3);
                            dataModel.setValueAt(m.getProfessor(), i, 4);
                            dataModel.setValueAt(m.getFaculty(), i, 5);
                            dataModel.setValueAt(m.getDateAdded(), i, 6);
                            i++;
                        }else if(departments.getSelectedItem().toString().equals("Toate specializările") && m.getFaculty().equals(faculties.getSelectedItem().toString())){
                            dataModel.setValueAt(m.getStudentLastName() + " " + m.getStudentFirstName(), i, 0);
                            dataModel.setValueAt(m.getMark(), i, 1);
                            dataModel.setValueAt(m.getSubject(), i, 2);
                            dataModel.setValueAt(m.getCredits(), i, 3);
                            dataModel.setValueAt(m.getProfessor(), i, 4);
                            dataModel.setValueAt(m.getFaculty(), i, 5);
                            dataModel.setValueAt(m.getDateAdded(), i, 6);
                            i++;
                        }else if(m.getDepartment().equals(departments.getSelectedItem().toString())){
                            dataModel.setValueAt(m.getStudentLastName() + " " + m.getStudentFirstName(), i, 0);
                            dataModel.setValueAt(m.getMark(), i, 1);
                            dataModel.setValueAt(m.getSubject(), i, 2);
                            dataModel.setValueAt(m.getCredits(), i, 3);
                            dataModel.setValueAt(m.getProfessor(), i, 4);
                            dataModel.setValueAt(m.getFaculty(), i, 5);
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
                        if(departments.getSelectedItem().toString().equals("Toate specializările") && faculties.getSelectedItem().toString().equals("Toate facultățile")){
                            subjects.addItem(s);
                        }else if(departments.getSelectedItem().toString().equals("Toate specializările") && s.getFaculty().equals(faculties.getSelectedItem().toString())){
                            subjects.addItem(s);
                        }else if(s.getDepartment().equals(departments.getSelectedItem().toString())){
                            subjects.addItem(s);
                        }
                    }
                    tabelNote.setModel(model);
                }
            }
        });
        //add marks into table when selecting a department
        subjects.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0, q = 0;
                if(subjects.getItemCount() > 0){
                    for(MarkByDepartment m:note){
                        if(faculties.getSelectedItem().toString().equals("Toate facultățile") && departments.getSelectedItem().toString().equals("Toate specializările") && subjects.getSelectedItem().toString().equals("Toate materiile")){
                            q = note.size();
                            break;
                        }else if(faculties.getSelectedItem().toString().equals("Toate facultățile") && departments.getSelectedItem().toString().equals("Toate specializările") && m.getSubject().equals(subjects.getSelectedItem().toString())){
                            q++;
                        }else if(m.getDepartment().equals(departments.getSelectedItem().toString()) && subjects.getSelectedItem().toString().equals("Toate materiile")){
                            q++;
                        }else if(m.getDepartment().equals(departments.getSelectedItem().toString()) && m.getSubject().equals(subjects.getSelectedItem().toString())){
                            q++;
                        }else if(m.getFaculty().equals(faculties.getSelectedItem().toString()) && departments.getSelectedItem().toString().equals("Toate specializările") && subjects.getSelectedItem().toString().equals("Toate materiile")){
                            q++;
                        }
                    }
                    dataModel = new MarkTableModel(q,7);
                    for(MarkByDepartment m:note){
                        if(faculties.getSelectedItem().toString().equals("Toate facultățile") && departments.getSelectedItem().toString().equals("Toate specializările") && subjects.getSelectedItem().toString().equals("Toate materiile")){
                            dataModel.setValueAt(m.getStudentLastName() + " " + m.getStudentFirstName(), i, 0);
                            dataModel.setValueAt(m.getMark(), i, 1);
                            dataModel.setValueAt(m.getSubject(), i, 2);
                            dataModel.setValueAt(m.getCredits(), i, 3);
                            dataModel.setValueAt(m.getProfessor(), i, 4);
                            dataModel.setValueAt(m.getFaculty(), i, 5);
                            dataModel.setValueAt(m.getDateAdded(), i, 6);
                            i++;
                        }else if(faculties.getSelectedItem().toString().equals("Toate facultățile") && departments.getSelectedItem().toString().equals("Toate specializările") && m.getSubject().equals(subjects.getSelectedItem().toString())){
                            dataModel.setValueAt(m.getStudentLastName() + " " + m.getStudentFirstName(), i, 0);
                            dataModel.setValueAt(m.getMark(), i, 1);
                            dataModel.setValueAt(m.getSubject(), i, 2);
                            dataModel.setValueAt(m.getCredits(), i, 3);
                            dataModel.setValueAt(m.getProfessor(), i, 4);
                            dataModel.setValueAt(m.getFaculty(), i, 5);
                            dataModel.setValueAt(m.getDateAdded(), i, 6);
                            i++;
                        }else if(m.getDepartment().equals(departments.getSelectedItem().toString()) && subjects.getSelectedItem().toString().equals("Toate materiile")){
                            dataModel.setValueAt(m.getStudentLastName() + " " + m.getStudentFirstName(), i, 0);
                            dataModel.setValueAt(m.getMark(), i, 1);
                            dataModel.setValueAt(m.getSubject(), i, 2);
                            dataModel.setValueAt(m.getCredits(), i, 3);
                            dataModel.setValueAt(m.getProfessor(), i, 4);
                            dataModel.setValueAt(m.getFaculty(), i, 5);
                            dataModel.setValueAt(m.getDateAdded(), i, 6);
                            i++;
                        }else if(m.getDepartment().equals(departments.getSelectedItem().toString()) && m.getSubject().equals(subjects.getSelectedItem().toString())){
                            dataModel.setValueAt(m.getStudentLastName() + " " + m.getStudentFirstName(), i, 0);
                            dataModel.setValueAt(m.getMark(), i, 1);
                            dataModel.setValueAt(m.getSubject(), i, 2);
                            dataModel.setValueAt(m.getCredits(), i, 3);
                            dataModel.setValueAt(m.getProfessor(), i, 4);
                            dataModel.setValueAt(m.getFaculty(), i, 5);
                            dataModel.setValueAt(m.getDateAdded(), i, 6);
                            i++;
                        }else if(m.getFaculty().equals(faculties.getSelectedItem().toString()) && departments.getSelectedItem().toString().equals("Toate specializările") && subjects.getSelectedItem().toString().equals("Toate materiile")){
                            dataModel.setValueAt(m.getStudentLastName() + " " + m.getStudentFirstName(), i, 0);
                            dataModel.setValueAt(m.getMark(), i, 1);
                            dataModel.setValueAt(m.getSubject(), i, 2);
                            dataModel.setValueAt(m.getCredits(), i, 3);
                            dataModel.setValueAt(m.getProfessor(), i, 4);
                            dataModel.setValueAt(m.getFaculty(), i, 5);
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
        //remove mark from the database and from the table too
        eliminare.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    DefaultTableModel model = (DefaultTableModel) tabelNote.getModel();
                    int indexRandSelectat = tabelNote.getSelectedRow();
                    numeStudent = String.valueOf(model.getValueAt(indexRandSelectat, 0)).split(" ");
                    mng.removeMarkFromDB(numeStudent[1], numeStudent[0], model.getValueAt(indexRandSelectat, 2).toString());
                    model.removeRow(indexRandSelectat);
                    JOptionPane.showMessageDialog(null, "Nota selectată a fost eliminată din baza de date!");
                } catch (Exception e1) {
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
                AdminMenuGUI window = new AdminMenuGUI();
            }
        });
    }
    public static void main(String[] args){
        RemoveMarkAdminGUI window = new RemoveMarkAdminGUI();
    }
}

