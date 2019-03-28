import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminMenuGUI extends JFrame{
    JFrame frame;
    JButton button1, button2, button3;
    JLabel label;
    public AdminMenuGUI(){
        frame = new JFrame("Administrator");

        label = new JLabel("Bun venit!");
        label.setBounds(213, 30, 200, 30);
        Font labelFont = label.getFont();
        String labelText = label.getText();
        int stringWidth = label.getFontMetrics(labelFont).stringWidth(labelText);
        int componentWidth = label.getWidth();
        // find out how much the font can grow in width.
        double widthRatio = (double) componentWidth / (double) stringWidth;
        int newFontSize = (int) (labelFont.getSize() * widthRatio);
        int componentHeight = label.getHeight();
        // pick a new font size so it will not be larger than the height of label.
        int fontSizeToUse = Math.min(newFontSize, componentHeight);
        // set the label's font size to the newly determined size.
        label.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));

        button1 = new JButton("Facultati");
        button2 = new JButton("Profesori");
        button3 = new JButton("Studenti");
        button1.setBounds(180, 90, 200, 30);
        button2.setBounds(180, 130, 200, 30);
        button3.setBounds(180,170,200,30);


        //1st button
        final JPopupMenu popupMenu1 = new JPopupMenu();

        JMenu menu1 = new JMenu("Vizualizare");
        JMenuItem item1 = new JMenuItem("Facultati si specializari");
        JMenuItem item2 = new JMenuItem("Materii");
        menu1.add(item1);
        menu1.add(item2);

        JMenu menu2 = new JMenu("Adaugare");
        JMenuItem item3 = new JMenuItem("Facultati");
        JMenuItem item4 = new JMenuItem("Specializari");
        JMenuItem item5 = new JMenuItem("Materii");
        menu2.add(item3);
        menu2.add(item4);
        menu2.add(item5);

        JMenu menu3 = new JMenu("Editare");
        JMenuItem item6 = new JMenuItem("Facultati");
        JMenuItem item7 = new JMenuItem("Specializari");
        JMenuItem item8 = new JMenuItem("Materii");
        menu3.add(item6);
        menu3.add(item7);
        menu3.add(item8);

        JMenu menu4 = new JMenu("Eliminare");
        JMenuItem item9 = new JMenuItem("Facultati");
        JMenuItem item10 = new JMenuItem("Specializari");
        JMenuItem item11 = new JMenuItem("Materii");
        menu4.add(item9);
        menu4.add(item10);
        menu4.add(item11);

        popupMenu1.add(menu1);
        popupMenu1.add(menu2);
        popupMenu1.add(menu3);
        popupMenu1.add(menu4);

        button1.setAlignmentX(RIGHT_ALIGNMENT);
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                popupMenu1.show(e.getComponent(),e.getX(),e.getY());
            }
        });

        //2nd button

        final JPopupMenu popupMenu2 = new JPopupMenu();

        JMenuItem item12 = new JMenuItem("Vizualizare");
        JMenuItem item13 = new JMenuItem("Adaugare");
        JMenuItem item14 = new JMenuItem("Editare");
        JMenuItem item15 = new JMenuItem("Eliminare");
        popupMenu2.add(item12);
        popupMenu2.add(item13);
        popupMenu2.add(item14);
        popupMenu2.add(item15);

        button2.setAlignmentX(RIGHT_ALIGNMENT);
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                popupMenu2.show(e.getComponent(),e.getX(),e.getY());
            }
        });



        //3rd button
        final JPopupMenu popupMenu3 = new JPopupMenu();

        JMenu menu5 = new JMenu("Vizualizare");
        JMenuItem item16 = new JMenuItem("Studenti");
        JMenuItem item17 = new JMenuItem("Note");
        menu5.add(item16);
        menu5.add(item17);

        JMenu menu6 = new JMenu("Adaugare");
        JMenuItem item18 = new JMenuItem("Studenti");
        JMenuItem item19 = new JMenuItem("Note");
        menu6.add(item18);
        menu6.add(item19);

        JMenu menu7 = new JMenu("Editare");
        JMenuItem item20 = new JMenuItem("Studenti");
        JMenuItem item21 = new JMenuItem("Note");
        menu7.add(item20);
        menu7.add(item21);

        JMenu menu8 = new JMenu("Eliminare");
        JMenuItem item22 = new JMenuItem("Studenti");
        JMenuItem item23 = new JMenuItem("Note");
        menu8.add(item22);
        menu8.add(item23);

        popupMenu3.add(menu5);
        popupMenu3.add(menu6);
        popupMenu3.add(menu7);
        popupMenu3.add(menu8);

        button3.setAlignmentX(RIGHT_ALIGNMENT);
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                popupMenu3.show(e.getComponent(),e.getX(),e.getY());
            }
        });

        frame.add(label);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
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
}

