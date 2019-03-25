import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * WORK IN PROGRESS
 */
public class AdminMenuGUI extends JFrame {
    JLabel welcome;
    JButton faculties, professors, students;
    public AdminMenuGUI(){
        JFrame frame = new JFrame("Administrator");
        JPanel panel2 = new JPanel(new GridLayout(4,1));
        welcome = new JLabel("Bun venit, administrator!");
        faculties = new JButton("Facultati");
        professors = new JButton("Profesori");
        students = new JButton("Studenti");
        panel2.add(welcome);
        panel2.add(faculties);
        panel2.add(professors);
        panel2.add(students);
        panel2.setBounds(300,70,20,300);
        frame.add(panel2);
        frame.setPreferredSize(new Dimension(600,300));
        frame.setLayout(null);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
