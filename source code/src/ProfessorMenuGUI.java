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

        popupMenu.add(item1);
        popupMenu.add(item2);
        popupMenu.add(item3);
        frame.add(label);
        frame.add(date);
        frame.add(note);
        frame.add(inapoi);
        frame.getContentPane().setBackground(Color.WHITE);
        label.setBounds(235, 35, 200, 30);
        label.setFont(new Font(String.valueOf(label.getFont().getName()),Font.PLAIN,20));
        date.setBounds(180,90,200,30);
        note.setBounds(180,130,200,30);
        inapoi.setBounds(180,170,200,30);
        note.setAlignmentX(RIGHT_ALIGNMENT);
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
