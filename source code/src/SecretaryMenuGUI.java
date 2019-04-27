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

        popupMenu1.add(item1);
        popupMenu1.add(item2);
        popupMenu1.add(item3);
        popupMenu1.add(item4);
        popupMenu2.add(item5);
        popupMenu2.add(item6);
        popupMenu2.add(item7);
        popupMenu2.add(item8);
        frame.add(label);
        frame.add(studenti);
        frame.add(note);
        frame.add(inapoi);
        label.setBounds(235, 35, 200, 30);
        studenti.setBounds(180, 90, 200, 30);
        note.setBounds(180, 130, 200, 30);
        inapoi.setBounds(180,170,200,30);
        label.setFont(new Font(String.valueOf(label.getFont().getName()),Font.PLAIN,20));
        frame.getContentPane().setBackground(Color.WHITE);
        studenti.setAlignmentX(RIGHT_ALIGNMENT);
        note.setAlignmentX(RIGHT_ALIGNMENT);
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
        studenti.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                popupMenu1.show(e.getComponent(), e.getX(), e.getY());
            }
        });
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewStudentsSecretaryGUI window = new ViewStudentsSecretaryGUI(email);
                frame.setVisible(false);
            }
        });
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddStudentSecretaryGUI window = new AddStudentSecretaryGUI(email);
                frame.setVisible(false);
            }
        });
        item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditStudentSecretaryGUI window = new EditStudentSecretaryGUI(email);
                frame.setVisible(false);
            }
        });
        item4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveStudentSecretaryGUI window = new RemoveStudentSecretaryGUI(email);
                frame.setVisible(false);
            }
        });
        note.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                popupMenu2.show(e.getComponent(), e.getX(), e.getY());
            }
        });
        item5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewMarksSecretaryGUI window = new ViewMarksSecretaryGUI(email);
                frame.setVisible(false);
            }
        });
        item6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddMarkSecretaryGUI window = new AddMarkSecretaryGUI(email);
                frame.setVisible(false);
            }
        });
        item7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditMarkSecretaryGUI window = new EditMarkSecretaryGUI(email);
                frame.setVisible(false);
            }
        });
        item8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveMarkSecretaryGUI window = new RemoveMarkSecretaryGUI(email);
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
