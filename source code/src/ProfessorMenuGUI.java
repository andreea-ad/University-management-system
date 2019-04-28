import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class ProfessorMenuGUI extends JFrame {
	private JFrame  frame;
    private JButton date, note, inapoi;
    private JLabel label;
    public ProfessorMenuGUI(String email){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Profesor");
        label = new JLabel("Bun venit!");
        date = new JButton("Vizualizare date personale");
        note = new JButton("Note");
        inapoi = new JButton("Înapoi");
        final JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem item1 = new JMenuItem("Vizualizare");
        JMenuItem item2 = new JMenuItem("Adăugare");
        JMenuItem item3 = new JMenuItem("Editare");
        //add buttons in submenu
        popupMenu.add(item1);
        popupMenu.add(item2);
        popupMenu.add(item3);
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
        date.setBounds(180,90,210,30);
        note.setBounds(180,130,210,30);
        inapoi.setBounds(180,170,210,30);
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
        //submenu items design
        popupMenu.setBorderPainted(false);
        item1.setBorderPainted(false);
        item1.setBackground(Color.white);
        item1.setForeground(new Color(100,100,100));
        item2.setBorderPainted(false);
        item2.setBackground(Color.white);
        item2.setForeground(new Color(100,100,100));
        item3.setBorderPainted(false);
        item3.setBackground(Color.white);
        item3.setForeground(new Color(100,100,100));
        //set alignment for submenu
        note.setAlignmentX(RIGHT_ALIGNMENT);
        //set frame size
        frame.setPreferredSize(new Dimension(600,350));
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
                PDViewProfessorGUI window = new PDViewProfessorGUI(email);
                frame.setVisible(false);
            }
        });
        //open popup menu when clicked
        note.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                popupMenu.show(e.getComponent(),e.getX(),e.getY());
            }
        });
        //open view marks window when clicked
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
                frame.setVisible(false);
            }
        });
        //go back to user menu
        inapoi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setVisible(false);
                LoginGUI window = new LoginGUI();
            }
        });
    }
}
