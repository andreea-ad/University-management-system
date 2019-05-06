import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashSet;

public class EditFacultyAdminGUI {
    private JFrame frame;
    private HashSet<Faculty> facultati;
    private FacultyTableModel dataModel;
    private JTable tabelFacultati = new JTable();
    private JScrollPane scrollPane = new JScrollPane(tabelFacultati);
    private JButton selecteaza, inapoi;
    public EditFacultyAdminGUI(){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Modificare facultate");
        selecteaza = new JButton("Selectează");
        inapoi = new JButton("Înapoi");
        ManagerGUI mng = new ManagerGUI();
        facultati = mng.getSetFacultati();
        int n = facultati.size();
        dataModel = new FacultyTableModel(n);
        //add all faculties into table
        int i = 0;
        for(Faculty f:facultati){
            dataModel.setValueAt(f.getTitle(),i,0);
            i++;
        }
        String[] coloane = {"FACULTATE"};
        TableModel model = new DefaultTableModel(dataModel.getFacultati(), coloane) {
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
        tabelFacultati.setModel(model);
        scrollPane.setViewportView(tabelFacultati);
        //set table sorter
        tabelFacultati.setAutoCreateRowSorter(true);
        //set bounds for elements
        scrollPane.setBounds(42,60,1100,183);
        selecteaza.setBounds(430,280,145,25);
        inapoi.setBounds(590,280,145,25);
        //buttons design
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
        frame.setPreferredSize(new Dimension(1200,400));
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
        //show edit menu when picking a faculty
        selecteaza.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setVisible(false);
                DefaultTableModel model = (DefaultTableModel)tabelFacultati.getModel();
                int indexRandSelectat = tabelFacultati.getSelectedRow();
                EditFacultyGUI window = new EditFacultyGUI(model.getValueAt(indexRandSelectat,0).toString());
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
        EditFacultyAdminGUI window = new EditFacultyAdminGUI();
    }
}
