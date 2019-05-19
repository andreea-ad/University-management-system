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

public class ViewSubjectsAdminGUI {
    private JFrame frame;
    private JComboBox<Faculty> faculties;
    private JComboBox<Department> departments;
    private HashSet<Faculty> facultati;
    private HashSet<Department> specializari;
    private HashSet<Subject> materii;
    private SubjectTableModel dataModel;
    private JTable tabelMaterii = new JTable();
    private JScrollPane scrollPane = new JScrollPane(tabelMaterii);
    private JButton inapoi;
    public ViewSubjectsAdminGUI() {
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Vizualizare materii");
        faculties = new JComboBox<>();
        departments = new JComboBox<>();
        inapoi = new JButton("Înapoi");
        ManagerGUI mng = new ManagerGUI();
        facultati = ManagerGUI.getSetFacultati();
        specializari = ManagerGUI.getSetSpecializari();
        materii = ManagerGUI.getSetMaterii();
        int n = materii.size();
        dataModel = new SubjectTableModel(n);
        //add faculties into combobox
        faculties.addItem(new Faculty("Toate facultățile"));
        for (Faculty f : facultati) {
            faculties.addItem(f);
        }
        //add departments into combobox
        departments.addItem(new Department("Toate specializările"));
        for (Department d : specializari) {
            departments.addItem(d);
        }
        //add all subjects into table
        int i = 0;
        for (Subject s : materii) {
            dataModel.setValueAt(s.getTitle(), i, 0);
            dataModel.setValueAt(s.getFaculty(), i, 1);
            dataModel.setValueAt(s.getDepartment(), i, 2);
            dataModel.setValueAt(s.getDegree(), i, 3);
            dataModel.setValueAt(s.getSemester(), i, 4);
            dataModel.setValueAt(s.getNumberOfCredits(), i, 5);
            dataModel.setValueAt(s.getTeacherLastName() + " " + s.getTeacherFirstName(), i, 6);
            i++;
        }
        String[] coloane = {"DENUMIRE", "FACULTATE", "SPECIALIZARE", "CICLU UNIVERSITAR", "SEMESTRU", "NUMĂR DE CREDITE", "PROFESOR"};
        TableModel model = new DefaultTableModel(dataModel.getMaterii(), coloane) {
            public boolean isCellEditable(int row, int column) {
                //set cells uneditable
                return false;
            }
        };
        //add elements to the frame
        frame.add(faculties);
        frame.add(departments);
        frame.add(scrollPane);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        tabelMaterii.setModel(model);
        scrollPane.setViewportView(tabelMaterii);
        //set table sorter
        tabelMaterii.setAutoCreateRowSorter(true);
        //set bounds for elements
        faculties.setBounds(42, 60, 300, 25);
        departments.setBounds(350, 60, 180, 25);
        scrollPane.setBounds(42, 110, 1300, 437);
        inapoi.setBounds(610, 580, 145, 25);
        //buttons design
        inapoi.setBorderPainted(false);
        inapoi.setBackground(new Color(233, 233, 233));
        inapoi.setForeground(new Color(100, 100, 100));
        faculties.setBackground(new Color(233,233,233));
        faculties.setForeground(new Color(100,100,100));
        departments.setBackground(new Color(233,233,233));
        departments.setForeground(new Color(100,100,100));
        //set frame icon
        try {
            frame.setIconImage(ImageIO.read(getClass().getResource("resources/1.png")));
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        //set frame size
        frame.setPreferredSize(new Dimension(1400, 700));
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
        //add subjects into table when selecting a faculty
        faculties.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0, q = 0;
                departments.removeAllItems();
                for (Subject s : materii) {
                    if (faculties.getSelectedItem().toString().equals("Toate facultățile")) {
                        q = materii.size();
                        break;
                    } else if (s.getFaculty().equals(faculties.getSelectedItem().toString())) {
                        q++;
                    }
                }
                dataModel = new SubjectTableModel(q);
                for (Subject s : materii) {
                    if (faculties.getSelectedItem().toString().equals("Toate facultățile")) {
                        dataModel.setValueAt(s.getTitle(), i, 0);
                        dataModel.setValueAt(s.getFaculty(), i, 1);
                        dataModel.setValueAt(s.getDepartment(), i, 2);
                        dataModel.setValueAt(s.getDegree(), i, 3);
                        dataModel.setValueAt(s.getSemester(), i, 4);
                        dataModel.setValueAt(s.getNumberOfCredits(), i, 5);
                        dataModel.setValueAt(s.getTeacherLastName() + " " + s.getTeacherFirstName(), i, 6);
                        i++;
                    } else if (s.getFaculty().equals(faculties.getSelectedItem().toString())) {
                        dataModel.setValueAt(s.getTitle(), i, 0);
                        dataModel.setValueAt(s.getFaculty(), i, 1);
                        dataModel.setValueAt(s.getDepartment(), i, 2);
                        dataModel.setValueAt(s.getDegree(), i, 3);
                        dataModel.setValueAt(s.getSemester(), i, 4);
                        dataModel.setValueAt(s.getNumberOfCredits(), i, 5);
                        dataModel.setValueAt(s.getTeacherLastName() + " " + s.getTeacherFirstName(), i, 6);
                        i++;
                    }
                }
                String[] coloane = {"DENUMIRE", "FACULTATE", "SPECIALIZARE", "CICLU UNIVERSITAR", "SEMESTRU", "NUMĂR DE CREDITE", "PROFESOR"};
                TableModel model = new DefaultTableModel(dataModel.getMaterii(), coloane) {
                    public boolean isCellEditable(int row, int column) {
                        //set cells uneditable
                        return false;
                    }
                };
                departments.addItem(new Department("Toate specializările"));
                for (Department d : specializari) {
                    if (faculties.getSelectedItem().toString().equals("Toate facultățile")) {
                        departments.addItem(d);
                    } else if (d.getFaculty().equals(faculties.getSelectedItem().toString())) {
                        departments.addItem(d);
                    }
                }
                tabelMaterii.setModel(model);
            }
        });
        //add subjects into table when selecting a department
        departments.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0, q = 0;
                if (departments.getItemCount() > 0) {
                    for (Subject s : materii) {
                        if (faculties.getSelectedItem().toString().equals("Toate facultățile") && departments.getSelectedItem().toString().equals("Toate specializările")) {
                            q = materii.size();
                            break;
                        } else if (departments.getSelectedItem().toString().equals("Toate specializările") && s.getFaculty().equals(faculties.getSelectedItem().toString())) {
                            q++;
                        } else if (s.getDepartment().equals(departments.getSelectedItem().toString())) {
                            q++;
                        }
                    }
                    dataModel = new SubjectTableModel(q);
                    for (Subject s : materii) {
                        if (faculties.getSelectedItem().toString().equals("Toate facultățile") && departments.getSelectedItem().toString().equals("Toate specializările")) {
                            dataModel.setValueAt(s.getTitle(), i, 0);
                            dataModel.setValueAt(s.getFaculty(), i, 1);
                            dataModel.setValueAt(s.getDepartment(), i, 2);
                            dataModel.setValueAt(s.getDegree(), i, 3);
                            dataModel.setValueAt(s.getSemester(), i, 4);
                            dataModel.setValueAt(s.getNumberOfCredits(), i, 5);
                            dataModel.setValueAt(s.getTeacherLastName() + " " + s.getTeacherFirstName(), i, 6);
                            i++;
                        } else if (departments.getSelectedItem().toString().equals("Toate specializările") && s.getFaculty().equals(faculties.getSelectedItem().toString())) {
                            dataModel.setValueAt(s.getTitle(), i, 0);
                            dataModel.setValueAt(s.getFaculty(), i, 1);
                            dataModel.setValueAt(s.getDepartment(), i, 2);
                            dataModel.setValueAt(s.getDegree(), i, 3);
                            dataModel.setValueAt(s.getSemester(), i, 4);
                            dataModel.setValueAt(s.getNumberOfCredits(), i, 5);
                            dataModel.setValueAt(s.getTeacherLastName() + " " + s.getTeacherFirstName(), i, 6);
                            i++;
                        } else if (s.getDepartment().equals(departments.getSelectedItem().toString())) {
                            dataModel.setValueAt(s.getTitle(), i, 0);
                            dataModel.setValueAt(s.getFaculty(), i, 1);
                            dataModel.setValueAt(s.getDepartment(), i, 2);
                            dataModel.setValueAt(s.getDegree(), i, 3);
                            dataModel.setValueAt(s.getSemester(), i, 4);
                            dataModel.setValueAt(s.getNumberOfCredits(), i, 5);
                            dataModel.setValueAt(s.getTeacherLastName() + " " + s.getTeacherFirstName(), i, 6);
                            i++;
                        }
                    }
                    String[] coloane = {"DENUMIRE", "FACULTATE", "SPECIALIZARE", "CICLU UNIVERSITAR", "SEMESTRU", "NUMĂR DE CREDITE", "PROFESOR"};
                    TableModel model = new DefaultTableModel(dataModel.getMaterii(), coloane) {
                        public boolean isCellEditable(int row, int column) {
                            //set cells uneditable
                            return false;
                        }
                    };
                    tabelMaterii.setModel(model);
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

    public static void main(String[] args) {
        ViewSubjectsAdminGUI window = new ViewSubjectsAdminGUI();
    }
}
