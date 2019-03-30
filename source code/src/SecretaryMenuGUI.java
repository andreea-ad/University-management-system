import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SecretaryMenuGUI extends JFrame{
	private JFrame  frame;
    private JButton button1, button2;
    private JLabel label;
    public SecretaryMenuGUI() {
        frame = new JFrame("Secretariat");

        label = new JLabel("Bun venit!");
        label.setBounds(235, 35, 200, 30);
        label.setFont(new Font(String.valueOf(label.getFont().getName()),Font.PLAIN,20));

        button1 = new JButton("Studenti");
        button2 = new JButton("Note");
        button1.setBounds(180, 90, 200, 30);
        button2.setBounds(180, 130, 200, 30);

        final JPopupMenu popupMenu1 = new JPopupMenu();
        JMenuItem item1 = new JMenuItem("Vizualizare");
        JMenuItem item2 = new JMenuItem("Adaugare");
        JMenuItem item3 = new JMenuItem("Editare");
        JMenuItem item4 = new JMenuItem("Eliminare");
        popupMenu1.add(item1);
        popupMenu1.add(item2);
        popupMenu1.add(item3);
        popupMenu1.add(item4);
        button1.setAlignmentX(RIGHT_ALIGNMENT);
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                popupMenu1.show(e.getComponent(), e.getX(), e.getY());
            }
        });

        final JPopupMenu popupMenu2 = new JPopupMenu();
        JMenuItem item5 = new JMenuItem("Vizualizare");
        JMenuItem item6 = new JMenuItem("Adaugare");
        JMenuItem item7 = new JMenuItem("Editare");
        JMenuItem item8 = new JMenuItem("Eliminare");
        popupMenu2.add(item5);
        popupMenu2.add(item6);
        popupMenu2.add(item7);
        popupMenu2.add(item8);
        button2.setAlignmentX(RIGHT_ALIGNMENT);
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                popupMenu2.show(e.getComponent(), e.getX(), e.getY());
            }
        });

        frame.add(label);
        frame.add(button1);
        frame.add(button2);

        frame.setPreferredSize(new Dimension(600, 300));
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
    public static void main(String[] args){
        SecretaryMenuGUI window = new SecretaryMenuGUI();
    }
}
