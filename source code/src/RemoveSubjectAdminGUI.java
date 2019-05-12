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

public class RemoveSubjectAdminGUI {
    private JFrame frame;
    private JComboBox<Faculty> faculties;
    private JComboBox<Department> departments;
    private JComboBox<String> degrees, credits, semesters;
    private HashSet<Faculty> facultati;
    private HashSet<Department> specializari;
    private HashSet<Subject> materii;
    private SubjectTableModel dataModel;
    private JTable tabelMaterii = new JTable();
    private JScrollPane scrollPane = new JScrollPane(tabelMaterii);
    private JButton eliminare, inapoi;
    public RemoveSubjectAdminGUI(){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Eliminare materie");
        faculties = new JComboBox<>();
        departments = new JComboBox<>();
        degrees = new JComboBox<>();
        credits = new JComboBox<>();
        semesters = new JComboBox<>();
        eliminare = new JButton("Elimină materie");
        inapoi = new JButton("Înapoi");
        ManagerGUI mng = new ManagerGUI();
        facultati = mng.getSetFacultati();
        specializari = mng.getSetSpecializari();
        materii = mng.getSetMaterii();
        int n = materii.size();
        dataModel = new SubjectTableModel(n);
        //add faculties into combobox
        faculties.addItem(new Faculty("Toate facultățile"));
        for(Faculty f:facultati){
            faculties.addItem(f);
        }
        //add departments into combobox
        departments.addItem(new Department("Toate specializările"));
        for(Department d:specializari){
            departments.addItem(d);
        }
        //add degrees into combobox
        degrees.addItem("Toate ciclurile universitare");
        degrees.addItem("LICENTA");
        degrees.addItem("MASTER");
        degrees.addItem("DOCTORAT");
        //add credits into combobox
        credits.addItem("Toate creditele");
        for(int i = 1; i <= 10; i++){
            credits.addItem(String.valueOf(i));
        }
        //add semesters into combobox
        semesters.addItem("Toate semestrele");
        for(int i = 1; i <= 6; i++){
            semesters.addItem(String.valueOf(i));
        }
        //add all subjects into table
        int i = 0;
        for(Subject s:materii){
            dataModel.setValueAt(s.getTitle(),i,0);
            dataModel.setValueAt(s.getFaculty(),i,1);
            dataModel.setValueAt(s.getDepartment(),i,2);
            dataModel.setValueAt(s.getDegree(),i,3);
            dataModel.setValueAt(s.getSemester(),i,4);
            dataModel.setValueAt(s.getNumberOfCredits(),i,5);
            dataModel.setValueAt(s.getTeacherLastName() + " " + s.getTeacherFirstName(),i,6);
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
        frame.add(degrees);
        frame.add(credits);
        frame.add(semesters);
        frame.add(scrollPane);
        frame.add(eliminare);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        tabelMaterii.setModel(model);
        scrollPane.setViewportView(tabelMaterii);
        //set table sorter
        tabelMaterii.setAutoCreateRowSorter(true);
        //set bounds for elements
        faculties.setBounds(42,60,300,25);
        departments.setBounds(350,60,180,25);
        degrees.setBounds(538,60,180,25);
        semesters.setBounds(726,60,125,25);
        credits.setBounds(859,60,110,25);
        scrollPane.setBounds(42,110,1300,437);
        eliminare.setBounds(530,560,145,25);
        inapoi.setBounds(685,560,145,25);
        //buttons design
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
        //add subjects into table when selecting a faculty
        faculties.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0, q = 0;
                if (faculties.getItemCount() > 0) {
                    departments.setSelectedIndex(0);
                    degrees.setSelectedIndex(0);
                    semesters.setSelectedIndex(0);
                    credits.setSelectedIndex(0);
                    for (Subject s : materii) {
                        if (faculties.getSelectedItem().toString().equals("Toate facultățile")) {
                            dataModel = new SubjectTableModel(n);
                            break;
                        } else if (s.getFaculty().equals(faculties.getSelectedItem().toString())) {
                            q++;
                        }
                    }
                    if (!faculties.getSelectedItem().toString().equals("Toate facultățile")) {
                        dataModel = new SubjectTableModel(q);
                    }
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
                    tabelMaterii.setModel(model);
                }
            }
        });
        //add subjects into table when selecting a department
        departments.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0, q = 0;
                if (departments.getItemCount() > 0) {
                    for (Subject s : materii) {
                        if (departments.getSelectedItem().toString().equals("Toate specializările")) {
                            dataModel = new SubjectTableModel(n);
                            break;
                        } else if (s.getDepartment().equals(departments.getSelectedItem().toString())) {
                            q++;
                        }
                    }
                    if (!departments.getSelectedItem().toString().equals("Toate specializările")) {
                        dataModel = new SubjectTableModel(q);
                    }
                    for (Subject s : materii) {
                        if (departments.getSelectedItem().toString().equals("Toate specializările")) {
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
        //add subjects into table when selecting a degree
        degrees.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0, q = 0;
                if(degrees.getItemCount() > 0) {
                    for (Subject s : materii) {
                        if (degrees.getSelectedItem().toString().equals("Toate ciclurile universitare")) {
                            dataModel = new SubjectTableModel(n);
                            break;
                        } else if (s.getDegree().equals(Degree.valueOf(degrees.getSelectedItem().toString()))) {
                            q++;
                        }
                    }
                    if (!degrees.getSelectedItem().toString().equals("Toate ciclurile universitare")) {
                        dataModel = new SubjectTableModel(q);
                    }
                    for (Subject s : materii) {
                        if (degrees.getSelectedItem().toString().equals("Toate ciclurile universitare")) {
                            dataModel.setValueAt(s.getTitle(), i, 0);
                            dataModel.setValueAt(s.getFaculty(), i, 1);
                            dataModel.setValueAt(s.getDepartment(), i, 2);
                            dataModel.setValueAt(s.getDegree(), i, 3);
                            dataModel.setValueAt(s.getSemester(), i, 4);
                            dataModel.setValueAt(s.getNumberOfCredits(), i, 5);
                            dataModel.setValueAt(s.getTeacherLastName() + " " + s.getTeacherFirstName(), i, 6);
                            i++;
                        } else if (s.getDegree().equals(Degree.valueOf(degrees.getSelectedItem().toString()))) {
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
        //add subjects into table when selecting a semester
        semesters.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0, q = 0;
                if(semesters.getItemCount() > 0) {
                    for (Subject s : materii) {
                        if (semesters.getSelectedItem().toString().equals("Toate semestrele")) {
                            dataModel = new SubjectTableModel(n);
                            break;
                        } else if (s.getSemester() == Integer.valueOf(semesters.getSelectedItem().toString())) {
                            q++;
                        }
                    }
                    if (!semesters.getSelectedItem().toString().equals("Toate semestrele")) {
                        dataModel = new SubjectTableModel(q);
                    }
                    for (Subject s : materii) {
                        if (semesters.getSelectedItem().toString().equals("Toate semestrele")) {
                            dataModel.setValueAt(s.getTitle(), i, 0);
                            dataModel.setValueAt(s.getFaculty(), i, 1);
                            dataModel.setValueAt(s.getDepartment(), i, 2);
                            dataModel.setValueAt(s.getDegree(), i, 3);
                            dataModel.setValueAt(s.getSemester(), i, 4);
                            dataModel.setValueAt(s.getNumberOfCredits(), i, 5);
                            dataModel.setValueAt(s.getTeacherLastName() + " " + s.getTeacherFirstName(), i, 6);
                            i++;
                        } else if (s.getSemester() == Integer.valueOf(semesters.getSelectedItem().toString())) {
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
        //add subjects into table when selecting a number of credits
        credits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0, q = 0;
                if(credits.getItemCount() > 0) {
                    for (Subject s : materii) {
                        if (credits.getSelectedItem().toString().equals("Toate creditele")) {
                            dataModel = new SubjectTableModel(n);
                            break;
                        } else if (s.getNumberOfCredits() == Integer.valueOf(credits.getSelectedItem().toString())) {
                            q++;
                        }
                    }
                    if (!credits.getSelectedItem().toString().equals("Toate creditele")) {
                        dataModel = new SubjectTableModel(q);
                    }
                    for (Subject s : materii) {
                        if (credits.getSelectedItem().toString().equals("Toate creditele")) {
                            dataModel.setValueAt(s.getTitle(), i, 0);
                            dataModel.setValueAt(s.getFaculty(), i, 1);
                            dataModel.setValueAt(s.getDepartment(), i, 2);
                            dataModel.setValueAt(s.getDegree(), i, 3);
                            dataModel.setValueAt(s.getSemester(), i, 4);
                            dataModel.setValueAt(s.getNumberOfCredits(), i, 5);
                            dataModel.setValueAt(s.getTeacherLastName() + " " + s.getTeacherFirstName(), i, 6);
                            i++;
                        } else if (s.getNumberOfCredits() == Integer.valueOf(credits.getSelectedItem().toString())) {
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
        //remove the selected subject from DB and from the table too
        eliminare.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    DefaultTableModel model = (DefaultTableModel) tabelMaterii.getModel();
                    int indexRandSelectat = tabelMaterii.getSelectedRow();
                    if(mng.removeSubjectFromDB(model.getValueAt(indexRandSelectat,0).toString()) == 1){
                        model.removeRow(indexRandSelectat);
                        JOptionPane.showMessageDialog(null, "Materia selectată a fost eliminată din sistem!");
                    }
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
        RemoveSubjectAdminGUI window = new RemoveSubjectAdminGUI();
    }
}
