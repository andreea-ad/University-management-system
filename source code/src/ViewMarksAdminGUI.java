import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;

public class ViewMarksAdminGUI {
    private JFrame frame;
    private JComboBox<Faculty> faculties;
    private HashSet<Faculty> facultati;
    private HashSet<MarkByFaculty> note;
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

        frame.getContentPane().setBackground(Color.WHITE);

        ManagerGUI mng = new ManagerGUI();
        facultati = mng.getInstance().getSetFacultati();
        note = mng.getInstance().getSetNoteDupaFacultate();
        int i = 0;
        //add all faculties in combobox
        faculties.addItem(new Faculty("Toate facultățile"));
        for(Faculty f:facultati){
            faculties.addItem(f);
        }
        //add all marks into table
        for(MarkByFaculty m:note){
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
        frame.add(scrollPane);
        frame.add(faculties);
        frame.add(inapoi);
        tabelNote.setModel(model);
        scrollPane.setViewportView(tabelNote);
        scrollPane.setBounds(42,110,1100,183);
        faculties.setBounds(42,60,300,25);
        inapoi.setBounds(510,320,145,25);
        frame.setLayout(null);
        //set frame size
        frame.setPreferredSize(new Dimension(1200,450));
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
        faculties.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0;
                dataModel.removeTable();
                if (e.getSource() == faculties) {
                    for(MarkByFaculty m:note){
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
                tabelNote.setModel(model);
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

