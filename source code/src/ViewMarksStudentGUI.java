import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

public class ViewMarksStudentGUI {
    private HashSet<MarkByEmail> note;
    private JFrame frame;
    private JTable tabelNote = new JTable();
    private MarkTableModel dataModel = new MarkTableModel(7);
    private JScrollPane scrollPane = new JScrollPane(tabelNote);
    private JButton inapoi;
    public ViewMarksStudentGUI(String email) {
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Vizualizare note");
        inapoi = new JButton("Înapoi");

        ManagerGUI mng = new ManagerGUI();
        note = mng.getInstance().getSetNoteDupaEmail();
        int i = 0;
        for(MarkByEmail m:note){
            if(m.getEmail().equals(email)){
                dataModel.setValueAt(m.getMark(),i,0);
                dataModel.setValueAt(m.getSubject(),i,1);
                dataModel.setValueAt(m.getCredits(),i,2);
                dataModel.setValueAt(m.getProfessor(),i,3);
                dataModel.setValueAt(m.getDateAdded(),i,4);
                i++;
            }
        }
        String[] coloane = {"NOTĂ","MATERIE","NUMĂR DE CREDITE","PROFESOR","DATA ULTIMEI MODIFICĂRI"};
        TableModel model = new DefaultTableModel(dataModel.getNote(), coloane) {
            public boolean isCellEditable(int row, int column){
                //set cells uneditable
                return false;
            }
        };
        frame.add(scrollPane);
        frame.add(inapoi);
        frame.getContentPane().setBackground(Color.WHITE);
        tabelNote.setModel(model);
        scrollPane.setViewportView(tabelNote);
        scrollPane.setBounds(42,110,1100,183);
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
        //go back to user menu
        inapoi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setVisible(false);
                StudentMenuGUI window = new StudentMenuGUI(email);
            }
        });
    }
}
