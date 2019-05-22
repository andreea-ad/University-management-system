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

public class ViewMarksSecretaryGUI {
    private JFrame frame;
    private JComboBox<Department> department;
    private JComboBox<Subject> subject;
    private HashSet<Department> specializari;
    private HashSet<Subject> materii;
    private HashSet<MarkByDepartment> note;
    private String facultate;
    private JButton inapoi;
    private MarkTableModel dataModel;
    private JTable tabelNote = new JTable();
    private JScrollPane scrollPane = new JScrollPane(tabelNote);
    public ViewMarksSecretaryGUI(String email) {
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Vizualizare note");
        department = new JComboBox<>();
        subject = new JComboBox<>();
        inapoi = new JButton("Înapoi");
        ManagerGUI mng = new ManagerGUI();
        facultate = ManagerGUI.getFacultateDupaEmail(email);
        specializari = ManagerGUI.getSetSpecializari();
        materii = ManagerGUI.getSetMaterii();
        note = ManagerGUI.getSetNoteDupaSpecializare();
        int n = note.size();
        dataModel = new MarkTableModel(n, 7);
        int i = 0;
        department.addItem(new Department("Toate specializările"));
        for (Department d : specializari) {
            if (d.getFaculty().equals(facultate)) {
                department.addItem(d);
            }
        }
        subject.addItem(new Subject("Toate materiile"));
        for (Subject s : materii) {
            if (s.getFaculty().equals(facultate)) {
                subject.addItem(s);
            }
        }
        for (MarkByDepartment m : note) {
            if (m.getFaculty().equals(facultate)) {
                dataModel.setValueAt(m.getStudentLastName(), i, 0);
                dataModel.setValueAt(m.getStudentFirstName(), i, 1);
                dataModel.setValueAt(m.getMark(), i, 2);
                dataModel.setValueAt(m.getSubject(), i, 3);
                dataModel.setValueAt(m.getDepartment(), i, 4);
                dataModel.setValueAt(m.getProfessor(), i, 5);
                dataModel.setValueAt(m.getDateAdded(), i, 6);
                i++;
            }
        }
        String[] coloane = {"NUME STUDENT", "PRENUME STUDENT", "NOTĂ", "MATERIE", "SPECIALIZARE", "PROFESOR", "DATA ULTIMEI MODIFICĂRI"};
        TableModel model = new DefaultTableModel(dataModel.getNote(), coloane) {
            public boolean isCellEditable(int row, int column) {
                //set cells uneditable
                return false;
            }
        };
        //add elements to the frame
        frame.add(scrollPane);
        frame.add(department);
        frame.add(subject);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        tabelNote.setModel(model);
        scrollPane.setViewportView(tabelNote);
        //set table sorter
        tabelNote.setAutoCreateRowSorter(true);
        //set bounds for elements
        scrollPane.setBounds(42, 110, 1100, 393);
        department.setBounds(42, 60, 300, 25);
        subject.setBounds(350, 60, 300, 25);
        inapoi.setBounds(510, 520, 145, 25);
        //button design
        inapoi.setBorderPainted(false);
        inapoi.setBackground(new Color(233, 233, 233));
        inapoi.setForeground(new Color(100, 100, 100));
        department.setBackground(new Color(233,233,233));
        department.setForeground(new Color(100,100,100));
        subject.setBackground(new Color(233,233,233));
        subject.setForeground(new Color(100,100,100));
        //set frame icon
        try {
            frame.setIconImage(ImageIO.read(getClass().getResource("resources/1.png")));
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        frame.setLayout(null);
        //set frame size
        frame.setPreferredSize(new Dimension(1200, 650));
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
        //add marks into table when selecting a department
        //display the subject combobox
        department.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0, q = 0;
                subject.removeAllItems();
                for (MarkByDepartment m : note) {
                    if (department.getSelectedItem().toString().equals("Toate specializările") && m.getFaculty().equals(facultate)) {
                        q++;
                    } else if (m.getDepartment().equals(department.getSelectedItem().toString())) {
                        q++;
                    }
                }
                dataModel = new MarkTableModel(q, 7);
                for (MarkByDepartment m : note) {
                    if (department.getSelectedItem().toString().equals("Toate specializările") && m.getFaculty().equals(facultate)) {
                        dataModel.setValueAt(m.getStudentLastName(), i, 0);
                        dataModel.setValueAt(m.getStudentFirstName(), i, 1);
                        dataModel.setValueAt(m.getMark(), i, 2);
                        dataModel.setValueAt(m.getSubject(), i, 3);
                        dataModel.setValueAt(m.getDepartment(), i, 4);
                        dataModel.setValueAt(m.getProfessor(), i, 5);
                        dataModel.setValueAt(m.getDateAdded(), i, 6);
                        i++;
                    } else if (m.getDepartment().equals(department.getSelectedItem().toString())) {
                        dataModel.setValueAt(m.getStudentLastName(), i, 0);
                        dataModel.setValueAt(m.getStudentFirstName(), i, 1);
                        dataModel.setValueAt(m.getMark(), i, 2);
                        dataModel.setValueAt(m.getSubject(), i, 3);
                        dataModel.setValueAt(m.getDepartment(), i, 4);
                        dataModel.setValueAt(m.getProfessor(), i, 5);
                        dataModel.setValueAt(m.getDateAdded(), i, 6);
                        i++;
                    }
                }
                String[] coloane = {"NUME STUDENT", "PRENUME STUDENT", "NOTĂ", "MATERIE", "SPECIALIZARE", "PROFESOR", "DATA ULTIMEI MODIFICĂRI"};
                TableModel model = new DefaultTableModel(dataModel.getNote(), coloane) {
                    public boolean isCellEditable(int row, int column) {
                        //set cells uneditable
                        return false;
                    }
                };
                subject.addItem(new Subject("Toate materiile"));
                for (Subject s : materii) {
                    if (department.getSelectedItem().toString().equals("Toate specializările") && s.getFaculty().equals(facultate)) {
                        subject.addItem(s);
                    } else if (s.getDepartment().equals(department.getSelectedItem().toString())) {
                        subject.addItem(s);
                    }
                }
                tabelNote.setModel(model);
            }
        });
        //add marks into table when selecting a subject
        subject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0, q = 0;
                dataModel.removeTable();
                if (subject.getItemCount() > 0) {
                    for (MarkByDepartment m : note) {
                        if(department.getSelectedItem().toString().equals("Toate specializările") && subject.getSelectedItem().toString().equals("Toate materiile") && m.getFaculty().equals(facultate)){
                            q++;
                        }else if(subject.getSelectedItem().toString().equals("Toate materiile") && m.getDepartment().equals(department.getSelectedItem().toString())){
                            q++;
                        }else if(m.getSubject().equals(subject.getSelectedItem().toString())){
                            q++;
                        }
                    }
                    dataModel = new MarkTableModel(q,7);
                    for (MarkByDepartment m : note) {
                        if (subject.getSelectedItem().toString().equals("Toate materiile") && department.getSelectedItem().toString().equals("Toate specializările") && m.getFaculty().equals(facultate)) {
                            dataModel.setValueAt(m.getStudentLastName(), i, 0);
                            dataModel.setValueAt(m.getStudentFirstName(), i, 1);
                            dataModel.setValueAt(m.getMark(), i, 2);
                            dataModel.setValueAt(m.getSubject(), i, 3);
                            dataModel.setValueAt(m.getDepartment(), i, 4);
                            dataModel.setValueAt(m.getProfessor(), i, 5);
                            dataModel.setValueAt(m.getDateAdded(), i, 6);
                            i++;
                        } else if (subject.getSelectedItem().toString().equals("Toate materiile") && m.getDepartment().equals(department)) {
                            dataModel.setValueAt(m.getStudentLastName(), i, 0);
                            dataModel.setValueAt(m.getStudentFirstName(), i, 1);
                            dataModel.setValueAt(m.getMark(), i, 2);
                            dataModel.setValueAt(m.getSubject(), i, 3);
                            dataModel.setValueAt(m.getDepartment(), i, 4);
                            dataModel.setValueAt(m.getProfessor(), i, 5);
                            dataModel.setValueAt(m.getDateAdded(), i, 6);
                            i++;
                        } else if (m.getSubject().equals(subject.getSelectedItem().toString())) {
                            dataModel.setValueAt(m.getStudentLastName(), i, 0);
                            dataModel.setValueAt(m.getStudentFirstName(), i, 1);
                            dataModel.setValueAt(m.getMark(), i, 2);
                            dataModel.setValueAt(m.getSubject(), i, 3);
                            dataModel.setValueAt(m.getDepartment(), i, 4);
                            dataModel.setValueAt(m.getProfessor(), i, 5);
                            dataModel.setValueAt(m.getDateAdded(), i, 6);
                            i++;
                        }
                    }
                    String[] coloane = {"NUME STUDENT", "PRENUME STUDENT", "NOTĂ", "MATERIE", "SPECIALIZARE", "PROFESOR", "DATA ULTIMEI MODIFICĂRI"};
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
                SecretaryMenuGUI window = new SecretaryMenuGUI(email);
            }
        });
    }

    public static void main(String[] args) {
        ViewMarksSecretaryGUI window = new ViewMarksSecretaryGUI("litere@gmail.com");
    }
}
