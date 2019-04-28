import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SecretaryMenuGUI extends JFrame{
	private JFrame  frame;
    private JButton studenti, note, inapoi;
    private JLabel label;
    public SecretaryMenuGUI(String email) {
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Secretariat");
        label = new JLabel("Bun venit!");
        studenti = new JButton("Studenți");
        note = new JButton("Note");
        inapoi = new JButton("Înapoi");
        final JPopupMenu popupMenu1 = new JPopupMenu();
        JMenuItem item1 = new JMenuItem("Vizualizare");
        JMenuItem item2 = new JMenuItem("Adaugare");
        JMenuItem item3 = new JMenuItem("Editare");
        JMenuItem item4 = new JMenuItem("Eliminare");
        final JPopupMenu popupMenu2 = new JPopupMenu();
        JMenuItem item5 = new JMenuItem("Vizualizare");
        JMenuItem item6 = new JMenuItem("Adaugare");
        JMenuItem item7 = new JMenuItem("Editare");
        JMenuItem item8 = new JMenuItem("Eliminare");
        //add buttons in submenu
        popupMenu1.add(item1);
        popupMenu1.add(item2);
        popupMenu1.add(item3);
        popupMenu1.add(item4);
        popupMenu2.add(item5);
        popupMenu2.add(item6);
        popupMenu2.add(item7);
        popupMenu2.add(item8);
        //add elements in frame
        frame.add(label);
        frame.add(studenti);
        frame.add(note);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        //set larger size for the font
        label.setFont(new Font(String.valueOf(label.getFont().getName()),Font.PLAIN,20));
        //set bounds for elements
        label.setBounds(233, 35, 200, 30);
        studenti.setBounds(180, 90, 200, 30);
        note.setBounds(180, 130, 200, 30);
        inapoi.setBounds(180,170,200,30);
        //buttons design
        studenti.setBorderPainted(false);
        studenti.setBackground(new Color(233,233,233));
        studenti.setForeground(new Color(100,100,100));
        note.setBorderPainted(false);
        note.setBackground(new Color(233,233,233));
        note.setForeground(new Color(100,100,100));
        inapoi.setBorderPainted(false);
        inapoi.setBackground(new Color(233,233,233));
        inapoi.setForeground(new Color(100,100,100));
        //submenu items design
        popupMenu1.setBorderPainted(false);
        item1.setBorderPainted(false);
        item1.setBackground(Color.white);
        item1.setForeground(new Color(100,100,100));
        item2.setBorderPainted(false);
        item2.setBackground(Color.white);
        item2.setForeground(new Color(100,100,100));
        item3.setBorderPainted(false);
        item3.setBackground(Color.white);
        item3.setForeground(new Color(100,100,100));
        item4.setBorderPainted(false);
        item4.setBackground(Color.white);
        item4.setForeground(new Color(100,100,100));
        popupMenu2.setBorderPainted(false);
        item5.setBorderPainted(false);
        item5.setBackground(Color.white);
        item5.setForeground(new Color(100,100,100));
        item6.setBorderPainted(false);
        item6.setBackground(Color.white);
        item6.setForeground(new Color(100,100,100));
        item7.setBorderPainted(false);
        item7.setBackground(Color.white);
        item7.setForeground(new Color(100,100,100));
        item8.setBorderPainted(false);
        item8.setBackground(Color.white);
        item8.setForeground(new Color(100,100,100));
        //set alignment for submenu
        studenti.setAlignmentX(RIGHT_ALIGNMENT);
        note.setAlignmentX(RIGHT_ALIGNMENT);
        //set frame size
        frame.setPreferredSize(new Dimension(600, 300));
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
        //open submenu for student-based operations
        studenti.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                popupMenu1.show(e.getComponent(), e.getX(), e.getY());
            }
        });
        //open view students window when clicked
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewStudentsSecretaryGUI window = new ViewStudentsSecretaryGUI(email);
                frame.setVisible(false);
            }
        });
        //open add student window when clicked
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddStudentSecretaryGUI window = new AddStudentSecretaryGUI(email);
                frame.setVisible(false);
            }
        });
        //open edit student window when clicked
        item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditStudentSecretaryGUI window = new EditStudentSecretaryGUI(email);
                frame.setVisible(false);
            }
        });
        //open remove student window when clicked
        item4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveStudentSecretaryGUI window = new RemoveStudentSecretaryGUI(email);
                frame.setVisible(false);
            }
        });
        //open submenu for marks-based operations
        note.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                popupMenu2.show(e.getComponent(), e.getX(), e.getY());
            }
        });
        //open view marks window when clicked
        item5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewMarksSecretaryGUI window = new ViewMarksSecretaryGUI(email);
                frame.setVisible(false);
            }
        });
        //open add mark window when clicked
        item6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddMarkSecretaryGUI window = new AddMarkSecretaryGUI(email);
                frame.setVisible(false);
            }
        });
        //open edit mark window when clicked
        item7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditMarkSecretaryGUI window = new EditMarkSecretaryGUI(email);
                frame.setVisible(false);
            }
        });
        //open remove mark window when clicked
        item8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveMarkSecretaryGUI window = new RemoveMarkSecretaryGUI(email);
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
