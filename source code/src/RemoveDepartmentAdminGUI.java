import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashSet;

public class RemoveDepartmentAdminGUI {
    private JFrame frame;
    private JComboBox<Faculty> faculties;
    private HashSet<Faculty> facultati;
    private HashSet<Department> specializari;
    private DepartmentTableModel dataModel;
    private JTable tabelSpecializari = new JTable();
    private JScrollPane scrollPane = new JScrollPane(tabelSpecializari);
    private JButton eliminare, inapoi;
    public RemoveDepartmentAdminGUI(){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Eliminare specializare");
        faculties = new JComboBox<>();
        eliminare = new JButton("Elimină specializare");
        inapoi = new JButton("Înapoi");
        ManagerGUI mng = new ManagerGUI();
        facultati = mng.getSetFacultati();
        specializari = mng.getSetSpecializari();
        int n = specializari.size();
        dataModel = new DepartmentTableModel(n);
        //add all faculties into combobox
        faculties.addItem(new Faculty("Toate facultățile"));
        for(Faculty f:facultati){
            faculties.addItem(f);
        }
        //add all departments into table
        int i = 0;
        for(Department d:specializari){
            dataModel.setValueAt(d.getTitle(),i,0);
            dataModel.setValueAt(d.getFaculty(),i,1);
            dataModel.setValueAt(d.getDegree(),i,2);
            i++;
        }
        String[] coloane = {"DENUMIRE", "FACULTATE", "CICLU UNIVERSITAR"};
        TableModel model = new DefaultTableModel(dataModel.getSpecializari(), coloane) {
            public boolean isCellEditable(int row, int column) {
                //set cells uneditable
                return false;
            }
        };
        //add elements to the frame
        frame.add(faculties);
        frame.add(scrollPane);
        frame.add(eliminare);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        tabelSpecializari.setModel(model);
        scrollPane.setViewportView(tabelSpecializari);
        //set table sorter
        tabelSpecializari.setAutoCreateRowSorter(true);
        //set bounds for elements
        scrollPane.setBounds(42,110,1300,246);
        faculties.setBounds(42,60,300,25);
        eliminare.setBounds(530,380,145,25);
        inapoi.setBounds(685,380,145,25);
        //buttons design
        eliminare.setBorderPainted(false);
        eliminare.setBackground(new Color(233,233,233));
        eliminare.setForeground(new Color(100,100,100));
        inapoi.setBorderPainted(false);
        inapoi.setBackground(new Color(233,233,233));
        inapoi.setForeground(new Color(100,100,100));
        faculties.setBackground(new Color(233,233,233));
        faculties.setForeground(new Color(100,100,100));
        //set frame icon
        try {
            frame.setIconImage(ImageIO.read(getClass().getResource("resources/1.png")));
        }catch(IOException ie){
            ie.printStackTrace();
        }
        //set frame size
        frame.setPreferredSize(new Dimension(1400,500));
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
        //add departments when selecting a faculty
        faculties.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0, q = 0;
                for(Department d:specializari){
                    if(faculties.getSelectedItem().toString().equals("Toate facultățile")){
                        dataModel.removeTable();
                    }else if(d.getFaculty().equals(faculties.getSelectedItem().toString())){
                        q++;
                    }
                }
                if(!faculties.getSelectedItem().toString().equals("Toate facultățile")){
                    dataModel = new DepartmentTableModel(q);
                }
                for(Department d:specializari){
                    if(faculties.getSelectedItem().toString().equals("Toate facultățile")){
                        dataModel.setValueAt(d.getTitle(),i,0);
                        dataModel.setValueAt(d.getFaculty(),i,1);
                        dataModel.setValueAt(d.getDegree(),i,2);
                        i++;
                    }else if(d.getFaculty().equals(faculties.getSelectedItem().toString())){
                        dataModel.setValueAt(d.getTitle(),i,0);
                        dataModel.setValueAt(d.getFaculty(),i,1);
                        dataModel.setValueAt(d.getDegree(),i,2);
                        i++;
                    }
                }
                String[] coloane = {"DENUMIRE", "FACULTATE", "CICLU UNIVERSITAR"};
                TableModel model = new DefaultTableModel(dataModel.getSpecializari(), coloane) {
                    public boolean isCellEditable(int row, int column) {
                        //set cells uneditable
                        return false;
                    }
                };
                tabelSpecializari.setModel(model);
            }
        });
        //remove department from DB and table too
        eliminare.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try{
                    DefaultTableModel model = (DefaultTableModel) tabelSpecializari.getModel();
                    int indexRandSelectat = tabelSpecializari.getSelectedRow();
                    if(mng.removeDepartmentFromDB(model.getValueAt(indexRandSelectat,0).toString()) == 1){
                        model.removeRow(indexRandSelectat);
                        JOptionPane.showMessageDialog(null,"Specializarea selectată a fost eliminată din sistem!");
                    }
                }catch (Exception e1){
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
        RemoveDepartmentAdminGUI window = new RemoveDepartmentAdminGUI();
    }
}
