import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.io.IOException;
import java.util.HashSet;

public class ViewFacultiesAndDepartmentsAdminGUI {
    private JFrame frame;
    private JLabel facultate, specializare;
    private HashSet<Faculty> facultati;
    private HashSet<Department> specializari;
    private FacultyTableModel dataModel1;
    private DepartmentTableModel dataModel2;
    private JTable tabelFacultati = new JTable(), tabelSpecializari = new JTable();
    private JScrollPane scrollPane1 = new JScrollPane(tabelFacultati), scrollPane2 = new JScrollPane(tabelSpecializari);
    private JButton inapoi;
    public ViewFacultiesAndDepartmentsAdminGUI(){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Vizualizare facultăți și specializări");
        inapoi = new JButton("Înapoi");
        facultate = new JLabel("FACULTĂȚI");
        specializare = new JLabel("SPECIALIZĂRI");
        ManagerGUI mng = new ManagerGUI();
        facultati = mng.getSetFacultati();
        specializari = mng.getSetSpecializari();
        int n = facultati.size();
        dataModel1 = new FacultyTableModel(n);
        dataModel2 = new DepartmentTableModel(specializari.size());
        //add all faculties into table1
        int i = 0;
        for(Faculty f:facultati){
            dataModel1.setValueAt(f.getTitle(),i,0);
            i++;
        }
        //add all departments into table2
        i = 0;
        for(Department d:specializari){
            dataModel2.setValueAt(d.getTitle(),i,0);
            dataModel2.setValueAt(d.getFaculty(),i,1);
            dataModel2.setValueAt(d.getDegree(),i,2);
            i++;
        }
        String[] coloane1 = {"DENUMIRE"};
        TableModel model1 = new DefaultTableModel(dataModel1.getFacultati(), coloane1) {
            public boolean isCellEditable(int row, int column){
                //set cells uneditable
                return false;
            }
        };
        String[] coloane2 = {"DENUMIRE", "FACULTATE", "CICLU UNIVERSITAR"};
        TableModel model2 = new DefaultTableModel(dataModel2.getSpecializari(), coloane2) {
            public boolean isCellEditable(int row, int column){
                //set cells uneditable
                return false;
            }
        };
        //add elements to the frame
        frame.add(facultate);
        frame.add(specializare);
        frame.add(scrollPane1);
        frame.add(scrollPane2);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        tabelFacultati.setModel(model1);
        scrollPane1.setViewportView(tabelFacultati);
        tabelSpecializari.setModel(model2);
        scrollPane2.setViewportView(tabelSpecializari);
        //set table sorter
        tabelFacultati.setAutoCreateRowSorter(true);
        tabelSpecializari.setAutoCreateRowSorter(true);
        //set bounds for elements
        facultate.setBounds(305,60,150,25);
        specializare.setBounds(950,60,150,25);
        scrollPane1.setBounds(60,100,600,247);
        scrollPane2.setBounds(720,100,600,247);
        inapoi.setBounds(617,390,145,25);
        //button design
        inapoi.setBorderPainted(false);
        inapoi.setBackground(new Color(233,233,233));
        inapoi.setForeground(new Color(100,100,100));
        //labels design
        facultate.setForeground(new Color(100,100,100));
        specializare.setForeground(new Color(100,100,100));
        facultate.setFont(new Font(String.valueOf(facultate.getFont().getName()),Font.PLAIN,20));
        specializare.setFont(new Font(String.valueOf(specializare.getFont().getName()),Font.PLAIN,20));
        //set frame icon
        try {
            frame.setIconImage(ImageIO.read(getClass().getResource("resources/1.png")));
        }catch(IOException ie){
            ie.printStackTrace();
        }
        //set frame size
        frame.setPreferredSize(new Dimension(1400,520));
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
        tabelFacultati.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int i = 0, q = 0;
                dataModel2.removeTable();
                String facultate = tabelFacultati.getModel().getValueAt(tabelFacultati.getSelectedRow(),0).toString();
                for(Department d:specializari){
                    if(d.getFaculty().equals(facultate)){
                        q++;
                    }
                }
                dataModel2 = new DepartmentTableModel(q);
                for(Department d:specializari){
                    if(d.getFaculty().equals(facultate)){
                        dataModel2.setValueAt(d.getTitle(),i,0);
                        dataModel2.setValueAt(d.getFaculty(),i,1);
                        dataModel2.setValueAt(d.getDegree(),i,2);
                        i++;
                    }
                }
                String[] coloane2 = {"DENUMIRE", "FACULTATE", "CICLU UNIVERSITAR"};
                TableModel model2 = new DefaultTableModel(dataModel2.getSpecializari(), coloane2) {
                    public boolean isCellEditable(int row, int column){
                        //set cells uneditable
                        return false;
                    }
                };
                tabelSpecializari.setModel(model2);
            }
        });
    }
    public static void main(String[] args){
        ViewFacultiesAndDepartmentsAdminGUI window = new ViewFacultiesAndDepartmentsAdminGUI();
    }
}
