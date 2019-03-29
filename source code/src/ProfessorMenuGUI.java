import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class ProfessorMenuGUI extends JFrame {
	JFrame  frame;
    JButton button1, button2;
    JLabel label;
    public ProfessorMenuGUI(){
        frame = new JFrame("Profesor");

        button1 = new JButton("Vizualizare date personale");
        button2 = new JButton("Note");
        button1.setBounds(180,90,200,30);
        button2.setBounds(180,130,200,30);

        label = new JLabel("Bun venit!");
        label.setBounds(213, 30, 200, 30);
        label.setFont(new Font(String.valueOf(label.getFont().getName()),Font.PLAIN,20));

    
        final JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem item1 = new JMenuItem("Vizualizare");
        JMenuItem item2 = new JMenuItem("Adaugare");
        JMenuItem item3 = new JMenuItem("Editare");
        popupMenu.add(item1);
        popupMenu.add(item2);
        popupMenu.add(item3);
        button2.setAlignmentX(RIGHT_ALIGNMENT);
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                popupMenu.show(e.getComponent(),e.getX(),e.getY());
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
