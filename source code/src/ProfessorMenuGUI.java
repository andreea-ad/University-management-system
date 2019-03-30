import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class ProfessorMenuGUI extends JFrame {
	private JFrame  frame;
    private JButton button1, button2;
    private JLabel label;
    public ProfessorMenuGUI(String email){
        frame = new JFrame("Profesor");

        label = new JLabel("Bun venit!");
        label.setBounds(235, 35, 200, 30);
        label.setFont(new Font(String.valueOf(label.getFont().getName()),Font.PLAIN,20));

        button1 = new JButton("Vizualizare date personale");
        button2 = new JButton("Note");
        button1.setBounds(180,90,200,30);
        button2.setBounds(180,130,200,30);


        final JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem item1 = new JMenuItem("Vizualizare");
        JMenuItem item2 = new JMenuItem("Adăugare");
        JMenuItem item3 = new JMenuItem("Editare");
        popupMenu.add(item1);
        popupMenu.add(item2);
        popupMenu.add(item3);

        //open view personal data window when clicked
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                PDViewProfessorGUI window = new PDViewProfessorGUI(email);
                frame.setVisible(false);
            }
        });

        button2.setAlignmentX(RIGHT_ALIGNMENT);
        //open popup menu when clicked
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                popupMenu.show(e.getComponent(),e.getX(),e.getY());
            }
        });

        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewMarksProfessorGUI window = new ViewMarksProfessorGUI(email);
                frame.setVisible(false);
            }
        });
        //open add mark window when clicked
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddMarkProfessorGUI window = new AddMarkProfessorGUI(email);
                frame.setVisible(false);
            }
        });
        //open edit mark window when clicked
        item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditMarkProfessorGUI window = new EditMarkProfessorGUI(email);
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
