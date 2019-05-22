import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashSet;

public class EditDepartmentGUI {
    private JFrame frame;
    private JLabel labelTitlu, labelFacultate, labelCicluUniversitar;
    private JComboBox<Faculty> faculties;
    private JComboBox<String> degrees;
    private JTextField title;
    private HashSet<Faculty> facultati;
    private JButton editeaza, inapoi;
    public EditDepartmentGUI(String titlu, String facultate, String cicluUniversitar){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Modificare specializare");
        labelTitlu = new JLabel("Titlu: ");
        labelFacultate = new JLabel("Facultate: ");
        labelCicluUniversitar = new JLabel("Ciclu universitar: ");
        title = new JTextField(titlu);
        faculties = new JComboBox<>();
        degrees = new JComboBox<>();
        ManagerGUI mng = new ManagerGUI();
        facultati = mng.getSetFacultati();
        editeaza = new JButton("Editează");
        inapoi = new JButton("Înapoi");
        for(Faculty f:facultati){
            faculties.addItem(f);
        }
        faculties.setSelectedItem(new Faculty(facultate));
        degrees.addItem("LICENTA");
        degrees.addItem("MASTER");
        degrees.addItem("DOCTORAT");
        degrees.setSelectedItem(cicluUniversitar);
        //add elements to the frame
        frame.add(labelTitlu);
        frame.add(title);
        frame.add(labelFacultate);
        frame.add(faculties);
        frame.add(labelCicluUniversitar);
        frame.add(degrees);
        frame.add(editeaza);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        //set bounds for elements
        labelTitlu.setBounds(170,60,170,25);
        title.setBounds(310,60,250,25);
        labelFacultate.setBounds(170,90,170,25);
        faculties.setBounds(310,90,250,25);
        labelCicluUniversitar.setBounds(170,120,170,25);
        degrees.setBounds(310,120,250,25);
        editeaza.setBounds(210,170,150,25);
        inapoi.setBounds(370,170,150,25);
        //buttons design
        editeaza.setBorderPainted(false);
        editeaza.setBackground(new Color(233,233,233));
        editeaza.setForeground(new Color(100,100,100));
        inapoi.setBorderPainted(false);
        inapoi.setBackground(new Color(233,233,233));
        inapoi.setForeground(new Color(100,100,100));
        degrees.setBackground(new Color(233,233,233));
        degrees.setForeground(new Color(100,100,100));
        //labels design
        labelTitlu.setForeground(new Color(100,100,100));
        labelFacultate.setForeground(new Color(100,100,100));
        labelCicluUniversitar.setForeground(new Color(100,100,100));
        //set frame icon
        try {
            frame.setIconImage(ImageIO.read(getClass().getResource("resources/1.png")));
        }catch(IOException ie){
            ie.printStackTrace();
        }
        //set frame size
        frame.setPreferredSize(new Dimension(745, 300));
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
        //update department into DB
        editeaza.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(ManagerGUI.updateDepartmentFromDB(titlu, title.getText(), faculties.getSelectedItem().toString(), degrees.getSelectedItem().toString()) == 1){
                    JOptionPane.showMessageDialog(null,"Specializarea a fost modificată în baza de date!");
                }
            }
        });
        //go back to select department to edit window
        inapoi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setVisible(false);
                EditDepartmentAdminGUI window = new EditDepartmentAdminGUI();
            }
        });


    }
}
