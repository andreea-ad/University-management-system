import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class EditFacultyGUI {
    private JFrame frame;
    private JLabel labelTitlu;
    private JTextField title;
    private JButton editeaza, inapoi;
    public EditFacultyGUI(String facultate){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Modificare specializare");
        labelTitlu = new JLabel("Titlu: ");
        title = new JTextField(facultate);
        editeaza = new JButton("Editează");
        inapoi = new JButton("Înapoi");
        //add elements to the frame
        frame.add(labelTitlu);
        frame.add(title);
        frame.add(editeaza);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        //set bounds for elements
        labelTitlu.setBounds(170,60,170,25);
        title.setBounds(310,60,250,25);
        editeaza.setBounds(210,110,150,25);
        inapoi.setBounds(370,110,150,25);
        //buttons design
        editeaza.setBorderPainted(false);
        editeaza.setBackground(new Color(233,233,233));
        editeaza.setForeground(new Color(100,100,100));
        inapoi.setBorderPainted(false);
        inapoi.setBackground(new Color(233,233,233));
        inapoi.setForeground(new Color(100,100,100));
        //labels design
        labelTitlu.setForeground(new Color(100,100,100));
        //set frame icon
        try {
            frame.setIconImage(ImageIO.read(getClass().getResource("resources/1.png")));
        }catch(IOException ie){
            ie.printStackTrace();
        }
        //set frame size
        frame.setPreferredSize(new Dimension(745, 230));
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
        //update faculty into DB
        editeaza.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(ManagerGUI.updateFacultyFromDB(facultate, title.getText()) == 1){
                    JOptionPane.showMessageDialog(null,"Facultatea a fost modificată în baza de date!");
                }
            }
        });
        //go back to select faculty to edit window
        inapoi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setVisible(false);
                EditFacultyAdminGUI window = new EditFacultyAdminGUI();
            }
        });
    }
}
