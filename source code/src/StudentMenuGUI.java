import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudentMenuGUI{
    JButton button1, button2;
    JLabel label;
    JFrame frame;
    public StudentMenuGUI(String email){
        frame = new JFrame("Student");
        frame.getContentPane().setBackground(Color.WHITE);

        label = new JLabel("Bun venit!");
        label.setBounds(235, 35, 200, 30);
        label.setFont(new Font(String.valueOf(label.getFont().getName()),Font.PLAIN,20));

        button1 = new JButton("Vizualizare date personale");
        button2 = new JButton("Vizualizare note");
        button1.setBounds(180,90,200,30);
        button2.setBounds(180,130,200,30);

        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                PDViewStudentGUI window = new PDViewStudentGUI(email);
                frame.setVisible(false);
            }
        });
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ViewMarksStudentGUI window = new ViewMarksStudentGUI(email);
                frame.setVisible(false);
            }
        });

        frame.add(label);
        frame.add(button1);
        frame.add(button2);
        frame.setPreferredSize(new Dimension(600,300));
        frame.setLayout(null);
        frame.pack();
        //set window in the middle of the screen
        frame.setLocationRelativeTo(null);
        //set the default close button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //block resize operation
        frame.setResizable(false);
        //make visible frame
        frame.setVisible(true);
    }
}
