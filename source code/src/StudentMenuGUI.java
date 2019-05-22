import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashSet;

public class StudentMenuGUI{
    private JFrame frame;
    private String cicluUniversitar = "";
    private HashSet<Student> studenti;
    private JButton date, note, inapoi;
    private JLabel label;
    public StudentMenuGUI(String email){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Student");
        label = new JLabel("Bun venit!");
        date = new JButton("Vizualizare date personale");
        note = new JButton("Vizualizare note");
        inapoi = new JButton("Înapoi");
        ManagerGUI mng = new ManagerGUI();
        studenti = mng.getSetStudenti();
        for(Student s:studenti){
            if(s.getEmailAddress().equals(email)){
                cicluUniversitar += s.getDegree();
                break;
            }
        }
        //add elements in frame
        frame.add(label);
        frame.add(date);
        frame.add(note);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        //set larger size for the font
        label.setFont(new Font(String.valueOf(label.getFont().getName()),Font.PLAIN,20));
        //set bounds for elements
        label.setBounds(233, 35, 200, 30);
        date.setBounds(180,90,200,30);
        note.setBounds(180,130,200,30);
        inapoi.setBounds(180,170,200,30);
        //buttons design
        date.setBorderPainted(false);
        date.setBackground(new Color(233,233,233));
        date.setForeground(new Color(100,100,100));
        note.setBorderPainted(false);
        note.setBackground(new Color(233,233,233));
        note.setForeground(new Color(100,100,100));
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
        frame.setPreferredSize(new Dimension(600,300));
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
        //open view personal data window when clicked
        date.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                PDViewStudentGUI window = new PDViewStudentGUI(1,"",email);
                frame.setVisible(false);
            }
        });
        //open view marks window when clicked
        note.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(cicluUniversitar.equals("LICENTA")) {
                    ViewMarksStudentGUI window = new ViewMarksStudentGUI(email);
                }else if(cicluUniversitar.equals("MASTER")){
                    ViewMarksStudentGUI2 window = new ViewMarksStudentGUI2(email);
                }
                frame.setVisible(false);
            }
        });
        //go back to login form
        inapoi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                LoginGUI window = new LoginGUI();
            }
        });
    }
}
