import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.*;

public class ViewMarksStudentGUI {
    private HashSet<MarkByEmail> note1;
    private JFrame frame;
    private JTable tabelNote = new JTable();
    private MarkTableModel dataModel = new MarkTableModel(7);
    private JScrollPane scrollPane = new JScrollPane(tabelNote);
    ViewMarksStudentGUI(String email) {
        frame = new JFrame("Vizualizare note");
        frame.getContentPane().setBackground(Color.WHITE);

        ManagerGUI mng = new ManagerGUI();
        note1 = mng.getInstance().getSetNoteDupaEmail();


        int nrNote=0;

        for(MarkByEmail m:note1){
            if(m.getEmail().equals(email)){
                nrNote++;
            }
        }

        int i=0;

        for(MarkByEmail m:note1){
            if(m.getEmail().equals(email)){
                dataModel.setValueAt(m.getMark(),i,0);
                dataModel.setValueAt(m.getSubject(),i,1);
                dataModel.setValueAt(m.getCredits(),i,2);
                dataModel.setValueAt(m.getProfessor(),i,3);
                dataModel.setValueAt(m.getDateAdded(),i,4);
                ++i;
            }
        }

        String[] coloane = {"NOTĂ","MATERIE","NUMĂR DE CREDITE","PROFESOR","DATA ULTIMEI MODIFICĂRI"};
        TableModel model = new DefaultTableModel(dataModel.getNote(), coloane)
        {
            public boolean isCellEditable(int row, int column)
            {
                return false;//This causes all cells to be not editable
            }
        };
        tabelNote.setModel(model);
        scrollPane.setViewportView(tabelNote);
        scrollPane = new JScrollPane(tabelNote);
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
