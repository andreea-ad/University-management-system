import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashSet;

public class ViewMarksProfessorGUI {
    private JFrame frame;
    private HashSet<Professor> profesori;
    private HashSet<MarkByEmail> note;
    private String numeProfesor="";
    private JTable tabelNote = new JTable();
    private MarkTableModel dataModel;
    private JScrollPane scrollPane = new JScrollPane(tabelNote);
    private JButton inapoi;
    public ViewMarksProfessorGUI(String email){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Vizualizare note");
        inapoi = new JButton("Înapoi");
        ManagerGUI mng = new ManagerGUI();
        profesori = mng.getSetProfesori();
        note = mng.getSetNoteDupaEmail();
        int n = 0;
        int i = 0;
        //get teacher's full name
        for(Professor p:profesori){
            if(p.getEmailAddress().equals(email)){
                numeProfesor += p.getLastName() + " " + p.getFirstName();
                break;
            }
        }
        for(MarkByEmail m:note){
            if(m.getProfessor().equals(numeProfesor)){
                n++;
            }
        }
        dataModel = new MarkTableModel(n,7);
        //add marks given by the logged teacher into table
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
        String[] coloane = {"STUDENT", "MATERIE", "NUMĂR DE CREDITE", "NOTĂ", "DATA ULTIMEI MODIFICĂRI"};
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
        //set table sorter
        tabelNote.setAutoCreateRowSorter(true);
        //set bounds for selements
        scrollPane.setBounds(42,110,1100,183);
        inapoi.setBounds(520,320,145,25);
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
                ProfessorMenuGUI window = new ProfessorMenuGUI(email);
            }
        });
    }
    public static void main(String[] args){
        ViewMarksProfessorGUI window = new ViewMarksProfessorGUI("roxana.popescu@gmail.com");
    }
}
