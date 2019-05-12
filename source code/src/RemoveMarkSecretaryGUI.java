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

public class RemoveMarkSecretaryGUI {
    private JFrame frame;
    private String facultate;
    private JComboBox<Department> departments;
    private JComboBox<Subject> subjects;
    private HashSet<MarkByDepartment> note;
    private HashSet<Department> specializari;
    private HashSet<Subject> materii;
    private MarkTableModel dataModel;
    private JTable tabelNote = new JTable();
    private JScrollPane scrollPane = new JScrollPane(tabelNote);
    private JButton eliminare, inapoi;
    private String[] numeStudent;
    public RemoveMarkSecretaryGUI(String email){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Eliminare notă");
        departments = new JComboBox<>();
        subjects = new JComboBox<>();
        eliminare = new JButton("Elimină notă");
        inapoi = new JButton("Înapoi");
        ManagerGUI mng = new ManagerGUI();
        facultate = mng.getFacultateDupaEmail(email);
        specializari = mng.getSetSpecializari();
        materii = mng.getSetMaterii();
        note = mng.getSetNoteDupaSpecializare();
        int n = 0;
        for(MarkByDepartment m:note){
            if(m.getFaculty().equals(facultate)){
                n++;
            }
        }
        dataModel = new MarkTableModel(n,7);
        //add departments into combobox
        departments.addItem(new Department("Toate specializările"));
        for(Department d:specializari){
            if(d.getFaculty().equals(facultate)){
                departments.addItem(d);
            }
        }
        int i = 0;
        //add all marks into table
        for(MarkByDepartment m:note){
            if(m.getFaculty().equals(facultate)) {
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
        //add elements to the frame
        frame.add(scrollPane);
        frame.add(departments);
        frame.add(eliminare);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        tabelNote.setModel(model);
        scrollPane.setViewportView(tabelNote);
        //set table sorter
        tabelNote.setAutoCreateRowSorter(true);
        //set bounds for elements
        scrollPane.setBounds(42,110,1100,183);
        departments.setBounds(42,60,300,25);
        eliminare.setBounds(430,335,145,25);
        inapoi.setBounds(590,335,145,25);
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
        //add marks into table when selecting a department
        departments.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0;
                subjects.removeAllItems();
                dataModel.removeTable();
                if (e.getSource() == departments) {
                    for(MarkByDepartment m:note) {
                        if(departments.getSelectedItem().toString().equals("Toate specializările") && m.getFaculty().equals(facultate)){
                            dataModel.setValueAt(m.getStudentLastName() + " " + m.getStudentFirstName(), i, 0);
                            dataModel.setValueAt(m.getMark(), i, 1);
                            dataModel.setValueAt(m.getSubject(), i, 2);
                            dataModel.setValueAt(m.getCredits(), i, 3);
                            dataModel.setValueAt(m.getProfessor(), i, 4);
                            dataModel.setValueAt(m.getFaculty(), i, 5);
                            dataModel.setValueAt(m.getDateAdded(), i, 6);
                            i++;
                        }else if(m.getDepartment().equals(departments.getSelectedItem().toString())) {
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
                    if(departments.getSelectedItem().toString().equals("Toate specializările") && s.getFaculty().equals(facultate)){
                        subjects.addItem(s);
                    }else if(s.getDepartment().equals(departments.getSelectedItem().toString())){
                        subjects.addItem(s);
                    }
                }
                tabelNote.setModel(model);
                frame.add(subjects);
                subjects.setBounds(350,60,300,25);
            }
        });
        //add marks into table when selecting a subject
        subjects.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0;
                dataModel.removeTable();
                if(subjects.getItemCount() > 0){
                    for(MarkByDepartment m:note){
                        if(subjects.getSelectedItem().toString().equals("Toate materiile") && departments.getSelectedItem().toString().equals("Toate specializările") && m.getFaculty().equals(facultate)) {
                            dataModel.setValueAt(m.getStudentLastName() + " " + m.getStudentFirstName(), i, 0);
                            dataModel.setValueAt(m.getMark(), i, 1);
                            dataModel.setValueAt(m.getSubject(), i, 2);
                            dataModel.setValueAt(m.getCredits(), i, 3);
                            dataModel.setValueAt(m.getProfessor(), i, 4);
                            dataModel.setValueAt(m.getFaculty(), i, 5);
                            dataModel.setValueAt(m.getDateAdded(), i, 6);
                            i++;
                        }else if(subjects.getSelectedItem().toString().equals("Toate materiile") && m.getDepartment().equals(departments.getSelectedItem().toString())){
                            dataModel.setValueAt(m.getStudentLastName() + " " + m.getStudentFirstName(), i, 0);
                            dataModel.setValueAt(m.getMark(), i, 1);
                            dataModel.setValueAt(m.getSubject(), i, 2);
                            dataModel.setValueAt(m.getCredits(), i, 3);
                            dataModel.setValueAt(m.getProfessor(), i, 4);
                            dataModel.setValueAt(m.getFaculty(), i, 5);
                            dataModel.setValueAt(m.getDateAdded(), i, 6);
                            i++;
                        }else if(m.getSubject().equals(subjects.getSelectedItem().toString())){
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
                    JOptionPane.showMessageDialog(null, "Nota selectată a fost eliminată din sistem!");
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
        RemoveMarkSecretaryGUI window = new RemoveMarkSecretaryGUI("litere@gmail.com");
    }
}
