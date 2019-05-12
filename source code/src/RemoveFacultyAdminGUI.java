import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashSet;

public class RemoveFacultyAdminGUI {
    private JFrame frame;
    private HashSet<Faculty> facultati;
    private FacultyTableModel dataModel;
    private JTable tabelFacultati = new JTable();
    private JScrollPane scrollPane = new JScrollPane(tabelFacultati);
    private JButton eliminare, inapoi;
    public RemoveFacultyAdminGUI(){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Eliminare facultate");
        eliminare = new JButton("Elimină facultate");
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
        String[] coloane = {"DENUMIRE"};
        TableModel model = new DefaultTableModel(dataModel.getFacultati(), coloane) {
            public boolean isCellEditable(int row, int column) {
                //set cells uneditable
                return false;
            }
        };
        //add elements to the frame
        frame.add(scrollPane);
        frame.add(eliminare);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        tabelFacultati.setModel(model);
        scrollPane.setViewportView(tabelFacultati);
        //set table sorter
        tabelFacultati.setAutoCreateRowSorter(true);
        //set bounds for elements
        scrollPane.setBounds(42,80,1300,437);
        eliminare.setBounds(530,560,145,25);
        inapoi.setBounds(685,560,145,25);
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
        frame.setPreferredSize(new Dimension(1400,700));
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
        //remove faculty from DB and table too
        eliminare.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    DefaultTableModel model = (DefaultTableModel) tabelFacultati.getModel();
                    int indexRandSelectat = tabelFacultati.getSelectedRow();
                    if(mng.removeFacultyFromDB(model.getValueAt(indexRandSelectat, 0).toString()) == 1){
                        model.removeRow(indexRandSelectat);
                        JOptionPane.showMessageDialog(null, "Facultatea selectată a fost eliminată din sistem!");
                    }
                } catch (Exception e1) {
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
                AdminMenuGUI window = new AdminMenuGUI();
            }
        });
    }
    public static void main(String[] args){
        RemoveFacultyAdminGUI window = new RemoveFacultyAdminGUI();
    }
}
