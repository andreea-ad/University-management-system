import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashSet;

public class ViewMarksStudentGUI2 {
    private JFrame frame;
    private JLabel labelAn1, labelAn2, labelSem1, labelSem2, labelSem3, labelSem4;
    private JTable tabelNote1 = new JTable(), tabelNote2 = new JTable(), tabelNote3 = new JTable(), tabelNote4 = new JTable();
    private MarkTableModel dataModel1, dataModel2, dataModel3, dataModel4;
    private JScrollPane scrollPane1 = new JScrollPane(tabelNote1), scrollPane2 = new JScrollPane(tabelNote2), scrollPane3 = new JScrollPane(tabelNote3), scrollPane4 = new JScrollPane(tabelNote4);
    private HashSet<MarkByEmail> note;
    private JButton inapoi;
    public ViewMarksStudentGUI2(String email) {
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Vizualizare note");
        inapoi = new JButton("Înapoi");
        labelAn1 = new JLabel("Anul 1");
        labelAn2 = new JLabel("Anul 2");
        labelSem1 = new JLabel("Semestrul I");
        labelSem2 = new JLabel("Semestrul al II-lea");
        labelSem3 = new JLabel("Semestrul I");
        labelSem4 = new JLabel("Semestrul al II-lea");
        ManagerGUI mng = new ManagerGUI();
        note = mng.getSetNoteDupaEmail();
        int[] n = new int[4];
        for(MarkByEmail m:note){
            if(m.getEmail().equals(email)) {
                if (m.getSemester() == 1) {
                    n[0]++;
                } else if (m.getSemester() == 2) {
                    n[1]++;
                } else if (m.getSemester() == 3) {
                    n[2]++;
                } else if (m.getSemester() == 4) {
                    n[3]++;
                }
            }
        }
        dataModel1 = new MarkTableModel(n[0],5);
        dataModel2 = new MarkTableModel(n[1],5);
        dataModel3 = new MarkTableModel(n[2],5);
        dataModel4 = new MarkTableModel(n[3],5);
        //first sem
        int i = 0;
        for(MarkByEmail m:note){
            if(m.getEmail().equals(email) && m.getSemester() == 1) {
                dataModel1.setValueAt(m.getMark(),i, 0);
                dataModel1.setValueAt(m.getSubject(),i, 1);
                dataModel1.setValueAt(m.getCredits(),i, 2);
                dataModel1.setValueAt(m.getProfessor(),i, 3);
                dataModel1.setValueAt(m.getDateAdded(),i, 4);
                i++;
            }
        }
        //second sem
        i = 0;
        for(MarkByEmail m:note){
            if(m.getEmail().equals(email) && m.getSemester() == 2){
                dataModel2.setValueAt(m.getMark(),i, 0);
                dataModel2.setValueAt(m.getSubject(),i, 1);
                dataModel2.setValueAt(m.getCredits(),i, 2);
                dataModel2.setValueAt(m.getProfessor(),i, 3);
                dataModel2.setValueAt(m.getDateAdded(),i, 4);
                i++;
            }
        }
        //third sem
        i = 0;
        for(MarkByEmail m:note){
            if(m.getEmail().equals(email) && m.getSemester() == 3){
                dataModel3.setValueAt(m.getMark(),i, 0);
                dataModel3.setValueAt(m.getSubject(),i, 1);
                dataModel3.setValueAt(m.getCredits(),i, 2);
                dataModel3.setValueAt(m.getProfessor(),i, 3);
                dataModel3.setValueAt(m.getDateAdded(),i, 4);
                i++;
            }
        }
        //fourth sem
        i = 0;
        for(MarkByEmail m:note){
            if(m.getEmail().equals(email) && m.getSemester() == 4){
                dataModel4.setValueAt(m.getMark(),i, 0);
                dataModel4.setValueAt(m.getSubject(),i, 1);
                dataModel4.setValueAt(m.getCredits(),i, 2);
                dataModel4.setValueAt(m.getProfessor(),i, 3);
                dataModel4.setValueAt(m.getDateAdded(),i, 4);
                i++;
            }
        }
        String[] coloane = {"NOTĂ","MATERIE","NUMĂR DE CREDITE","PROFESOR","DATA ULTIMEI MODIFICĂRI"};
        TableModel model1 = new DefaultTableModel(dataModel1.getNote(), coloane) {
            public boolean isCellEditable(int row, int column){
                //set cells uneditable
                return false;
            }
        };
        TableModel model2 = new DefaultTableModel(dataModel2.getNote(), coloane) {
            public boolean isCellEditable(int row, int column){
                //set cells uneditable
                return false;
            }
        };
        TableModel model3 = new DefaultTableModel(dataModel3.getNote(), coloane) {
            public boolean isCellEditable(int row, int column){
                //set cells uneditable
                return false;
            }
        };
        TableModel model4 = new DefaultTableModel(dataModel4.getNote(), coloane) {
            public boolean isCellEditable(int row, int column){
                //set cells uneditable
                return false;
            }
        };
        //add elements to the frame
        frame.add(labelAn1);
        frame.add(labelSem1);
        frame.add(labelSem2);
        frame.add(labelAn2);
        frame.add(labelSem3);
        frame.add(labelSem4);
        frame.add(scrollPane1);
        frame.add(scrollPane2);
        frame.add(scrollPane3);
        frame.add(scrollPane4);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        tabelNote1.setModel(model1);
        scrollPane1.setViewportView(tabelNote1);
        tabelNote2.setModel(model2);
        scrollPane2.setViewportView(tabelNote2);
        tabelNote3.setModel(model3);
        scrollPane3.setViewportView(tabelNote3);
        tabelNote4.setModel(model4);
        scrollPane4.setViewportView(tabelNote4);
        //set table sorter
        tabelNote1.setAutoCreateRowSorter(true);
        tabelNote2.setAutoCreateRowSorter(true);
        tabelNote3.setAutoCreateRowSorter(true);
        tabelNote4.setAutoCreateRowSorter(true);
        //set bounds for elements
        labelAn1.setBounds(555,35,120,25);
        labelSem1.setBounds(60,70,120,25);
        labelSem2.setBounds(1015,70,120,25);
        labelAn2.setBounds(555,255,120,25);
        labelSem3.setBounds(60,290,120,25);
        labelSem4.setBounds(1015,290,120,25);
        scrollPane1.setBounds(60,100,500,120);
        scrollPane2.setBounds(620,100,500,120);
        scrollPane3.setBounds(60,320,500,120);
        scrollPane4.setBounds(620,320,500,120);
        inapoi.setBounds(515,485,145,25);
        //button design
        inapoi.setBorderPainted(false);
        inapoi.setBackground(new Color(233,233,233));
        inapoi.setForeground(new Color(100,100,100));
        //labels design
        labelAn1.setForeground(new Color(100,100,100));
        labelAn2.setForeground(new Color(100,100,100));
        labelSem1.setForeground(new Color(100,100,100));
        labelSem2.setForeground(new Color(100,100,100));
        labelSem3.setForeground(new Color(100,100,100));
        labelSem4.setForeground(new Color(100,100,100));
        labelAn1.setFont(new Font(String.valueOf(labelAn1.getFont().getName()),Font.PLAIN,25));
        labelAn2.setFont(new Font(String.valueOf(labelAn1.getFont().getName()),Font.PLAIN,25));
        labelSem1.setFont(new Font(String.valueOf(labelAn1.getFont().getName()),Font.PLAIN,13));
        labelSem2.setFont(new Font(String.valueOf(labelAn1.getFont().getName()),Font.PLAIN,13));
        labelSem3.setFont(new Font(String.valueOf(labelAn1.getFont().getName()),Font.PLAIN,13));
        labelSem4.setFont(new Font(String.valueOf(labelAn1.getFont().getName()),Font.PLAIN,13));
        //set frame icon
        try {
            frame.setIconImage(ImageIO.read(getClass().getResource("resources/1.png")));
        }catch(IOException ie){
            ie.printStackTrace();
        }
        //set frame size
        frame.setPreferredSize(new Dimension(1200,600));
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
    public static void main(String[] args){
        ViewMarksStudentGUI2 window = new ViewMarksStudentGUI2("stefania.pop@gmail.com");
    }
}
