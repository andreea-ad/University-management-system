import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.HashSet;

public class ViewMarksProfessorGUI {
    private JFrame frame;
    private HashSet<Professor> profesori;
    private HashSet<MarkByEmail> note;
    private String numeProfesor="";
    private JTable tabelNote = new JTable();
    private MarkTableModel dataModel = new MarkTableModel(5);
    private JScrollPane scrollPane = new JScrollPane(tabelNote);
    public ViewMarksProfessorGUI(String email){
        frame = new JFrame("Vizualizare note");

        ManagerGUI mng = new ManagerGUI();
        profesori = mng.getInstance().getSetProfesori();
        note = mng.getInstance().getSetNoteDupaEmail();

        for(Professor p:profesori){
            if(p.getEmailAddress().equals(email)){
                numeProfesor+=p.getLastName()+" "+p.getFirstName();
                break;
            }
        }

        int i=0;
        for(MarkByEmail m:note){
            if(m.getProfessor().equals(numeProfesor)) {
                dataModel.setValueAt(m.getStudentLastName() + " " + m.getStudentFirstName(), i, 0);
                dataModel.setValueAt(m.getSubject(), i, 1);
                dataModel.setValueAt(m.getCredits(), i, 2);
                dataModel.setValueAt(m.getMark(), i, 3);
                dataModel.setValueAt(m.getDateAdded(), i, 4);
                i++;
            }
        }

        String[] coloane ={"STUDENT", "MATERIE", "NUMĂR DE CREDITE", "NOTĂ", "DATA ULTIMEI MODIFICĂRI"};
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

        frame.add(scrollPane);

        frame.setLayout(null);
        //set frame size
        frame.setPreferredSize(new Dimension(930,620));
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
