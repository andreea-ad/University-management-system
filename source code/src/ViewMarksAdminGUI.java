import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class ViewMarksAdminGUI {
    private JFrame frame;
    private JComboBox<Faculty> faculties;
    private HashSet<Faculty> facultati;
    private HashSet<MarkByFaculty> note;
    private MarkTableModel dataModel = new MarkTableModel(7);
    private JTable tabelNote = new JTable();
    private JScrollPane scrollPane = new JScrollPane(tabelNote);
    public ViewMarksAdminGUI(){
        frame = new JFrame("Vizualizare note");
        frame.getContentPane().setBackground(Color.WHITE);

        ManagerGUI mng = new ManagerGUI();
        facultati = mng.getInstance().getSetFacultati();

        faculties = new JComboBox<>();
        for(Faculty f:facultati){
            faculties.addItem(f);
        }

        note = mng.getInstance().getSetNoteDupaFacultate();
        int i=0;
        for(MarkByFaculty m:note){
            if(m.getFaculty().equals(faculties.getSelectedItem().toString())){
                dataModel.setValueAt(m.getStudentLastName()+" "+m.getStudentFirstName(), i, 0);
                dataModel.setValueAt(m.getMark(),i,1);
                dataModel.setValueAt(m.getSubject(), i, 2);
                dataModel.setValueAt(m.getCredits(), i, 3);
                dataModel.setValueAt(m.getProfessor(),i,4);
                dataModel.setValueAt(m.getFaculty(),i,5);
                dataModel.setValueAt(m.getDateAdded(), i, 6);
                i++;
                if(i>dataModel.getNrNote()){
                    dataModel.setNrNote(i);
                }
            }
        }

        faculties.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i=0;
                if (e.getSource() == faculties) {
                    for(MarkByFaculty m:note){
                        if(m.getFaculty().equals(faculties.getSelectedItem().toString())){
                            dataModel.setValueAt(m.getStudentLastName()+" "+m.getStudentFirstName(), i, 0);
                            dataModel.setValueAt(m.getMark(),i,1);
                            dataModel.setValueAt(m.getSubject(), i, 2);
                            dataModel.setValueAt(m.getCredits(), i, 3);
                            dataModel.setValueAt(m.getProfessor(),i,4);
                            dataModel.setValueAt(m.getFaculty(),i,5);
                            dataModel.setValueAt(m.getDateAdded(), i, 6);
                            i++;
                            if(i>dataModel.getNrNote()){
                                dataModel.setNrNote(i);
                            }
                        }
                    }
                }
                String[] coloane ={"STUDENT", "NOTĂ","MATERIE","NUMĂR DE CREDITE", "PROFESOR", "FACULTATE", "DATA ULTIMEI MODIFICĂRI"};
                TableModel model = new DefaultTableModel(dataModel.getNote(), coloane)
                {
                    public boolean isCellEditable(int row, int column)
                    {
                        return false;//This causes all cells to be not editable
                    }
                };
                tabelNote.setModel(model);
            }
        });

        String[] coloane ={"STUDENT", "NOTĂ","MATERIE","NUMĂR DE CREDITE", "PROFESOR", "FACULTATE", "DATA ULTIMEI MODIFICĂRI"};
        TableModel model = new DefaultTableModel(dataModel.getNote(), coloane)
        {
            public boolean isCellEditable(int row, int column)
            {
                return false;//This causes all cells to be not editable
            }
        };
        tabelNote.setModel(model);
        scrollPane.setViewportView(tabelNote);
        scrollPane.setBounds(42,100,830,183);
        faculties.setBounds(100,60,300,25);

        frame.add(scrollPane);
        frame.add(faculties);

        frame.setLayout(null);
        //set frame size
        frame.setPreferredSize(new Dimension(930,520));
        frame.pack();
        //set window in the middle of the screen
        frame.setLocationRelativeTo(null);
        //set the default close button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //block resize operation
        frame.setResizable(false);
        //make visible frame
        frame.setVisible(true);
    }
}

