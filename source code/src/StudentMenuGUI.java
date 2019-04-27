import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudentMenuGUI{
    private JFrame frame;
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
        frame.add(label);
        frame.add(date);
        frame.add(note);
        frame.add(inapoi);
        frame.getContentPane().setBackground(Color.WHITE);
        label.setFont(new Font(String.valueOf(label.getFont().getName()),Font.PLAIN,20));
        label.setBounds(235, 35, 200, 30);
        date.setBounds(180,90,200,30);
        note.setBounds(180,130,200,30);
        inapoi.setBounds(180,170,200,30);
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
        date.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                PDViewStudentGUI window = new PDViewStudentGUI(email);
                frame.setVisible(false);
            }
        });
        note.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ViewMarksStudentGUI window = new ViewMarksStudentGUI(email);
                frame.setVisible(false);
            }
        });
        inapoi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                LoginGUI window = new LoginGUI();
            }
        });
    }
}
