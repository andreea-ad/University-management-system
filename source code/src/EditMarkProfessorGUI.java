import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;

public class EditMarkProfessorGUI {
    private JFrame frame;
    private String[] profesor;
    private HashSet<Professor> profesori;
    private HashSet<Mark> note;
    private MarkTableModel dataModel;
    private JTable tabelNote = new JTable();
    private JScrollPane scrollPane = new JScrollPane(tabelNote);
    private JButton selecteaza, inapoi;
    public EditMarkProfessorGUI(String email){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Modificare notă");
        selecteaza = new JButton("Selectează");
        inapoi = new JButton("Înapoi");
        ManagerGUI mng = new ManagerGUI();
        profesor = mng.getProfesorDupaEmail(email);
        note = mng.getInstance().getSetNote();
        profesori = mng.getInstance().getSetProfesori();
        int n = 0;
        for(Mark m:note){
            if(m.getTeacherFirstName().equals(profesor[0]) && m.getTeacherLastName().equals(profesor[1])){
                n++;
            }
        }
        dataModel = new MarkTableModel(n,5);
        //add all marks from this professor into table
        int i = 0;
        for(Mark m:note){
            if(m.getTeacherFirstName().equals(profesor[0]) && m.getTeacherLastName().equals(profesor[1])){
                dataModel.setValueAt(m.getStudentLastName(),i,0);
                dataModel.setValueAt(m.getStudentFirstName(),i,1);
                dataModel.setValueAt(m.getMark(),i,2);
                dataModel.setValueAt(m.getSubject(),i,3);
                dataModel.setValueAt(m.getDateAdded(),i,4);
                i++;
            }
        }
        String[] coloane = {"NUME", "PRENUME", "NOTĂ", "MATERIE", "DATA ADĂUGĂRII"};
        TableModel model = new DefaultTableModel(dataModel.getNote(), coloane) {
            public boolean isCellEditable(int row, int column) {
                //set cells uneditable
                return false;
            }
        };
        //add elements to the frame
        frame.add(scrollPane);
        frame.add(selecteaza);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        tabelNote.setModel(model);
        scrollPane.setViewportView(tabelNote);
        //set table sorter
        tabelNote.setAutoCreateRowSorter(true);
        //set bounds for elements
        scrollPane.setBounds(42, 100, 1100, 183);
        selecteaza.setBounds(440,320,150,25);
        inapoi.setBounds(600,320,150,25);
        //button design
        selecteaza.setBorderPainted(false);
        selecteaza.setBackground(new Color(233,233,233));
        selecteaza.setForeground(new Color(100,100,100));
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
        frame.setPreferredSize(new Dimension(1200, 450));
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
        //show edit menu when picking a mark
        selecteaza.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setVisible(false);
                DefaultTableModel model = (DefaultTableModel)tabelNote.getModel();
                int indexRandSelectat = tabelNote.getSelectedRow();
                EditMarkGUI window = new EditMarkGUI(1, email, model.getValueAt(indexRandSelectat,0).toString(), model.getValueAt(indexRandSelectat,1).toString(), (int)model.getValueAt(indexRandSelectat,2), model.getValueAt(indexRandSelectat,3).toString(), (Date)model.getValueAt(indexRandSelectat,4));
            }
        });
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
        EditMarkProfessorGUI window = new EditMarkProfessorGUI("maria.ionescu@gmail.com");
    }
}
