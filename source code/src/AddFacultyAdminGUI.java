import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class AddFacultyAdminGUI {
    private JFrame frame;
    private JLabel labelDenumire;
    private JTextField titlu;
    private JButton adaugare, anulare, inapoi;
    public AddFacultyAdminGUI(){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Adăugare specializare");
        labelDenumire = new JLabel("Titlu: ");
        titlu = new JTextField();
        adaugare = new JButton("Adaugă facultate");
        anulare = new JButton("Anulează");
        inapoi = new JButton("Înapoi");
        ManagerGUI mng = new ManagerGUI();
        //add elements to the frame
        frame.add(labelDenumire);
        frame.add(titlu);
        frame.add(adaugare);
        frame.add(anulare);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        //set bounds for elements
        labelDenumire.setBounds(120,70,120,25);
        titlu.setBounds(240,70,300,25);
        adaugare.setBounds(100,110,150,25);
        anulare.setBounds(260,110,150,25);
        inapoi.setBounds(420,110,150,25);
        //buttons design
        adaugare.setBorderPainted(false);
        adaugare.setBackground(new Color(233,233,233));
        adaugare.setForeground(new Color(100,100,100));
        anulare.setBorderPainted(false);
        anulare.setBackground(new Color(233,233,233));
        anulare.setForeground(new Color(100,100,100));
        inapoi.setBorderPainted(false);
        inapoi.setBackground(new Color(233,233,233));
        inapoi.setForeground(new Color(100,100,100));
        //label design
        labelDenumire.setForeground(new Color(100,100,100));
        //set frame icon
        try {
            frame.setIconImage(ImageIO.read(getClass().getResource("resources/1.png")));
        }catch(IOException ie){
            ie.printStackTrace();
        }
        //set frame size
        frame.setPreferredSize(new Dimension(710,240));
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
        //add faculty into DB
        adaugare.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(mng.addFacultyInDB(titlu.getText()) == 1){
                    JOptionPane.showMessageDialog(null, "Facultatea a fost adăugată în baza de date!");
                }
            }
        });
        //empty the input field
        anulare.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                titlu.setText("");
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
        AddFacultyAdminGUI window = new AddFacultyAdminGUI();
    }
}
