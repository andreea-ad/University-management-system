import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class EditDepartmentGUI {
    private JFrame frame;
    private JLabel labelTitlu, labelFacultate, labelCicluUniversitar;
    private JTextField title, faculty, degree;
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
        faculty = new JTextField(facultate);
        degree = new JTextField(cicluUniversitar);
        editeaza = new JButton("Editează");
        inapoi = new JButton("Înapoi");
        //add elements to the frame
        frame.add(labelTitlu);
        frame.add(title);
        frame.add(labelFacultate);
        frame.add(faculty);
        frame.add(labelCicluUniversitar);
        frame.add(degree);
        frame.add(editeaza);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        //set textfields not editable
        faculty.setEditable(false);
        degree.setEditable(false);
        //set bounds for elements
        labelTitlu.setBounds(170,60,170,25);
        title.setBounds(310,60,250,25);
        labelFacultate.setBounds(170,90,170,25);
        faculty.setBounds(310,90,250,25);
        labelCicluUniversitar.setBounds(170,120,170,25);
        degree.setBounds(310,120,250,25);
        editeaza.setBounds(210,170,150,25);
        inapoi.setBounds(370,170,150,25);
        //buttons design
        editeaza.setBorderPainted(false);
        editeaza.setBackground(new Color(233,233,233));
        editeaza.setForeground(new Color(100,100,100));
        inapoi.setBorderPainted(false);
        inapoi.setBackground(new Color(233,233,233));
        inapoi.setForeground(new Color(100,100,100));
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
                if(ManagerGUI.updateDepartmentFromDB(titlu, title.getText(), faculty.getText(), degree.getText()) == 1){
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
