import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
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
        //add elements to the frame
        frame.add(scrollPane);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        tabelNote.setModel(model);
        scrollPane.setViewportView(tabelNote);
        //set bounds for elements
        scrollPane.setBounds(42,110,1100,183);
        inapoi.setBounds(510,320,145,25);
        //button design
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
        frame.setPreferredSize(new Dimension(1200,450));
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
