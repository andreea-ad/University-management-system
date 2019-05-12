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
import java.util.Date;
import java.util.HashSet;

public class EditMarkAdminGUI {
    private JFrame frame;
    private HashSet<Faculty> facultati;
    private HashSet<Department> specializari;
    private HashSet<MarkByDepartment> note;
    private HashSet<Subject> materii;
    private MarkTableModel dataModel;
    private JTable tabelNote = new JTable();
    private JScrollPane scrollPane = new JScrollPane(tabelNote);
    private JComboBox<Faculty> faculties;
    private JComboBox<Department> departments;
    private JComboBox<Subject> subjects;
    private JButton selecteaza, inapoi;
    public EditMarkAdminGUI(){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Modificare notă");
        selecteaza = new JButton("Selectează");
        inapoi = new JButton("Înapoi");
        faculties = new JComboBox<>();
        departments = new JComboBox<>();
        subjects = new JComboBox<>();
        ManagerGUI mng = new ManagerGUI();
        facultati = mng.getSetFacultati();
        specializari = mng.getSetSpecializari();
        note = mng.getSetNoteDupaSpecializare();
        materii = mng.getSetMaterii();
        int n = note.size();
        dataModel = new MarkTableModel(n,7);
        //add all faculties into combobox
        faculties.addItem(new Faculty("Toate facultățile"));
        for(Faculty f:facultati){
            faculties.addItem(f);
        }
        //add all marks into table
        int i = 0;
        for(MarkByDepartment m:note){
            dataModel.setValueAt(m.getStudentLastName() + " " + m.getStudentFirstName(), i, 0);
            dataModel.setValueAt(m.getMark(), i, 1);
            dataModel.setValueAt(m.getSubject(), i, 2);
            dataModel.setValueAt(m.getCredits(), i, 3);
            dataModel.setValueAt(m.getProfessor(), i, 4);
            dataModel.setValueAt(m.getFaculty(), i, 5);
            dataModel.setValueAt(m.getDateAdded(), i, 6);
            i++;
        }
        String[] coloane = {"STUDENT", "NOTĂ","MATERIE","NUMĂR DE CREDITE", "PROFESOR", "FACULTATE", "DATA ULTIMEI MODIFICĂRI"};
        TableModel model = new DefaultTableModel(dataModel.getNote(), coloane) {
            public boolean isCellEditable(int row, int column) {
                //set cells uneditable
                return false;
            }
        };
        //add elements to the frame
        frame.add(scrollPane);
        frame.add(departments);
        frame.add(selecteaza);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        tabelNote.setModel(model);
        scrollPane.setViewportView(tabelNote);
        //set table sorter
        tabelNote.setAutoCreateRowSorter(true);
        //set bounds for elements
        scrollPane.setBounds(42,110,1100,183);
        faculties.setBounds(42,60,300,25);
        selecteaza.setBounds(430,335,145,25);
        inapoi.setBounds(590,335,145,25);
        //buttons design
        selecteaza.setBorderPainted(false);
        selecteaza.setBackground(new Color(233,233,233));
        selecteaza.setForeground(new Color(100,100,100));
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
        //add marks into table when selecting a faculty
        faculties.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0;
                dataModel.removeTable();
                departments.removeAllItems();
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
                tabelNote.setModel(model);
                frame.add(departments);
                departments.setBounds(350,60,300,25);
            }
        });
        //add marks into table when selecting a department
        departments.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0;
                dataModel.removeTable();
                subjects.removeAllItems();
                if(departments.getItemCount() > 0){
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
                    frame.add(subjects);
                    subjects.setBounds(658,60,300,25);
                }
            }
        });
        //show edit menu when picking a mark
        selecteaza.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    frame.setVisible(false);
                    DefaultTableModel model = (DefaultTableModel) tabelNote.getModel();
                    int indexRandSelectat = tabelNote.getSelectedRow();
                    String[] student = String.valueOf(model.getValueAt(indexRandSelectat, 0).toString()).split("\\s+");
                    EditMarkGUI window = new EditMarkGUI(3, "", student[0], student[1], (int) model.getValueAt(indexRandSelectat, 1), model.getValueAt(indexRandSelectat, 2).toString(), (Date) model.getValueAt(indexRandSelectat, 6));
                }catch (Exception e1){
                    JOptionPane.showMessageDialog(null,"Selectați o înregistrare din tabel!");
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
        EditMarkAdminGUI window = new EditMarkAdminGUI();
    }
}
