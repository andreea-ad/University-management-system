import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminMenuGUI extends JFrame{
    private JFrame frame;
    private JButton facultati, profesori, studenti, inapoi;
    private JLabel label;
    public AdminMenuGUI(){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Administrator");
        label = new JLabel("Bun venit!");
        facultati = new JButton("Facultăți");
        profesori = new JButton("Profesori");
        studenti = new JButton("Studenți");
        inapoi = new JButton("Înapoi");
        final JPopupMenu popupMenu1 = new JPopupMenu();
        JMenu menu1 = new JMenu("Vizualizare");
        JMenuItem item1 = new JMenuItem("Facultăți și specializări");
        JMenuItem item2 = new JMenuItem("Materii");
        JMenu menu2 = new JMenu("Adăugare");
        JMenuItem item3 = new JMenuItem("Facultăți");
        JMenuItem item4 = new JMenuItem("Specializări");
        JMenuItem item5 = new JMenuItem("Materii");
        JMenu menu3 = new JMenu("Editare");
        JMenuItem item6 = new JMenuItem("Facultăți");
        JMenuItem item7 = new JMenuItem("Specializări");
        JMenuItem item8 = new JMenuItem("Materii");
        JMenu menu4 = new JMenu("Eliminare");
        JMenuItem item9 = new JMenuItem("Facultăți");
        JMenuItem item10 = new JMenuItem("Specializări");
        JMenuItem item11 = new JMenuItem("Materii");
        final JPopupMenu popupMenu2 = new JPopupMenu();
        JMenuItem item12 = new JMenuItem("Vizualizare");
        JMenuItem item13 = new JMenuItem("Adăugare");
        JMenuItem item14 = new JMenuItem("Editare");
        JMenuItem item15 = new JMenuItem("Eliminare");
        final JPopupMenu popupMenu3 = new JPopupMenu();
        JMenu menu5 = new JMenu("Vizualizare");
        JMenuItem item16 = new JMenuItem("Studenți");
        JMenuItem item17 = new JMenuItem("Note");
        JMenu menu6 = new JMenu("Adăugare");
        JMenuItem item18 = new JMenuItem("Studenți");
        JMenuItem item19 = new JMenuItem("Note");
        JMenu menu7 = new JMenu("Editare");
        JMenuItem item20 = new JMenuItem("Studenți");
        JMenuItem item21 = new JMenuItem("Note");
        JMenu menu8 = new JMenu("Eliminare");
        JMenuItem item22 = new JMenuItem("Studenți");
        JMenuItem item23 = new JMenuItem("Note");
        //add buttons in submenu
        menu1.add(item1);
        menu1.add(item2);
        menu2.add(item3);
        menu2.add(item4);
        menu2.add(item5);
        menu3.add(item6);
        menu3.add(item7);
        menu3.add(item8);
        menu4.add(item9);
        menu4.add(item10);
        menu4.add(item11);
        popupMenu1.add(menu1);
        popupMenu1.add(menu2);
        popupMenu1.add(menu3);
        popupMenu1.add(menu4);
        popupMenu2.add(item12);
        popupMenu2.add(item13);
        popupMenu2.add(item14);
        popupMenu2.add(item15);
        menu5.add(item16);
        menu5.add(item17);
        menu6.add(item18);
        menu6.add(item19);
        menu7.add(item20);
        menu7.add(item21);
        menu8.add(item22);
        menu8.add(item23);
        popupMenu3.add(menu5);
        popupMenu3.add(menu6);
        popupMenu3.add(menu7);
        popupMenu3.add(menu8);
        //add elements in frame
        frame.add(label);
        frame.add(facultati);
        frame.add(profesori);
        frame.add(studenti);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        //set larger size for the font
        label.setFont(new Font(String.valueOf(label.getFont().getName()),Font.PLAIN,20));
        //set bounds for elements
        label.setBounds(233, 30, 200, 30);
        facultati.setBounds(180, 90, 200, 30);
        profesori.setBounds(180, 130, 200, 30);
        studenti.setBounds(180,170,200,30);
        inapoi.setBounds(180,210,200,30);
        //buttons design
        facultati.setBorderPainted(false);
        facultati.setBackground(new Color(233,233,233));
        facultati.setForeground(new Color(100,100,100));
        profesori.setBorderPainted(false);
        profesori.setBackground(new Color(233,233,233));
        profesori.setForeground(new Color(100,100,100));
        studenti.setBorderPainted(false);
        studenti.setBackground(new Color(233,233,233));
        studenti.setForeground(new Color(100,100,100));
        inapoi.setBorderPainted(false);
        inapoi.setBackground(new Color(233,233,233));
        inapoi.setForeground(new Color(100,100,100));
        //submenu items design
        popupMenu1.setBorderPainted(false);
        menu1.setBorderPainted(false);
        menu1.setBackground(Color.white);
        menu1.setForeground(new Color(100,100,100));
        item1.setBorderPainted(false);
        item1.setBackground(Color.white);
        item1.setForeground(new Color(100,100,100));
        item2.setBorderPainted(false);
        item2.setBackground(Color.white);
        item2.setForeground(new Color(100,100,100));
        menu2.setBorderPainted(false);
        menu2.setBackground(Color.white);
        menu2.setForeground(new Color(100,100,100));
        item3.setBorderPainted(false);
        item3.setBackground(Color.white);
        item3.setForeground(new Color(100,100,100));
        item4.setBorderPainted(false);
        item4.setBackground(Color.white);
        item4.setForeground(new Color(100,100,100));
        item5.setBorderPainted(false);
        item5.setBackground(Color.white);
        item5.setForeground(new Color(100,100,100));
        menu3.setBorderPainted(false);
        menu3.setBackground(Color.white);
        menu3.setForeground(new Color(100,100,100));
        item6.setBorderPainted(false);
        item6.setBackground(Color.white);
        item6.setForeground(new Color(100,100,100));
        item7.setBorderPainted(false);
        item7.setBackground(Color.white);
        item7.setForeground(new Color(100,100,100));
        item8.setBorderPainted(false);
        item8.setBackground(Color.white);
        item8.setForeground(new Color(100,100,100));
        menu4.setBorderPainted(false);
        menu4.setBackground(Color.white);
        menu4.setForeground(new Color(100,100,100));
        item9.setBorderPainted(false);
        item9.setBackground(Color.white);
        item9.setForeground(new Color(100,100,100));
        item10.setBorderPainted(false);
        item10.setBackground(Color.white);
        item10.setForeground(new Color(100,100,100));
        item11.setBorderPainted(false);
        item11.setBackground(Color.white);
        item11.setForeground(new Color(100,100,100));
        popupMenu2.setBorderPainted(false);
        item12.setBorderPainted(false);
        item12.setBackground(Color.white);
        item12.setForeground(new Color(100,100,100));
        item13.setBorderPainted(false);
        item13.setBackground(Color.white);
        item13.setForeground(new Color(100,100,100));
        item14.setBorderPainted(false);
        item14.setBackground(Color.white);
        item14.setForeground(new Color(100,100,100));
        item15.setBorderPainted(false);
        item15.setBackground(Color.white);
        item15.setForeground(new Color(100,100,100));
        popupMenu3.setBorderPainted(false);
        menu5.setBorderPainted(false);
        menu5.setBackground(Color.white);
        menu5.setForeground(new Color(100,100,100));
        item16.setBorderPainted(false);
        item16.setBackground(Color.white);
        item16.setForeground(new Color(100,100,100));
        item17.setBorderPainted(false);
        item17.setBackground(Color.white);
        item17.setForeground(new Color(100,100,100));
        menu6.setBorderPainted(false);
        menu6.setBackground(Color.white);
        menu6.setForeground(new Color(100,100,100));
        item18.setBorderPainted(false);
        item18.setBackground(Color.white);
        item18.setForeground(new Color(100,100,100));
        item19.setBorderPainted(false);
        item19.setBackground(Color.white);
        item19.setForeground(new Color(100,100,100));
        menu7.setBorderPainted(false);
        menu7.setBackground(Color.white);
        menu7.setForeground(new Color(100,100,100));
        item20.setBorderPainted(false);
        item20.setBackground(Color.white);
        item20.setForeground(new Color(100,100,100));
        item21.setBorderPainted(false);
        item21.setBackground(Color.white);
        item21.setForeground(new Color(100,100,100));
        menu8.setBorderPainted(false);
        menu8.setBackground(Color.white);
        menu8.setForeground(new Color(100,100,100));
        item22.setBorderPainted(false);
        item22.setBackground(Color.white);
        item22.setForeground(new Color(100,100,100));
        item23.setBorderPainted(false);
        item23.setBackground(Color.white);
        item23.setForeground(new Color(100,100,100));
        //set alignment for submenus
        facultati.setAlignmentX(RIGHT_ALIGNMENT);
        profesori.setAlignmentX(RIGHT_ALIGNMENT);
        studenti.setAlignmentX(RIGHT_ALIGNMENT);
        //set frame size
        frame.setPreferredSize(new Dimension(600, 350));
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
        //open submenu for faculties-based operations
        facultati.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                popupMenu1.show(e.getComponent(),e.getX(),e.getY());
            }
        });
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewFacultiesAndDepartmentsAdminGUI window = new ViewFacultiesAndDepartmentsAdminGUI();
                frame.setVisible(false);
            }
        });
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewSubjectsAdminGUI window = new ViewSubjectsAdminGUI();
                frame.setVisible(false);
            }
        });
        item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddFacultyAdminGUI window = new AddFacultyAdminGUI();
                frame.setVisible(false);
            }
        });
        item4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddDepartmentAdminGUI window = new AddDepartmentAdminGUI();
                frame.setVisible(false);
            }
        });
        item5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddSubjectAdminGUI window = new AddSubjectAdminGUI();
                frame.setVisible(false);
            }
        });
        item6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditFacultyAdminGUI window = new EditFacultyAdminGUI();
                frame.setVisible(false);
            }
        });
        item7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditDepartmentAdminGUI window = new EditDepartmentAdminGUI();
                frame.setVisible(false);
            }
        });
        item8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditSubjectAdminGUI window = new EditSubjectAdminGUI();
                frame.setVisible(false);
            }
        });
        item9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveFacultyAdminGUI window = new RemoveFacultyAdminGUI();
                frame.setVisible(false);
            }
        });
        item10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveDepartmentAdminGUI window = new RemoveDepartmentAdminGUI();
                frame.setVisible(false);
            }
        });
        item11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveSubjectAdminGUI window = new RemoveSubjectAdminGUI();
                frame.setVisible(false);
            }
        });
        profesori.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                popupMenu2.show(e.getComponent(),e.getX(),e.getY());
            }
        });
        item12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewTeachersAdminGUI window = new ViewTeachersAdminGUI();
                frame.setVisible(false);
            }
        });
        item13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddTeacherAdminGUI window = new AddTeacherAdminGUI();
                frame.setVisible(false);
            }
        });
        item14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditTeacherAdminGUI window = new EditTeacherAdminGUI();
                frame.setVisible(false);
            }
        });
        item15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveTeacherAdminGUI window = new RemoveTeacherAdminGUI();
                frame.setVisible(false);
            }
        });
        studenti.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                popupMenu3.show(e.getComponent(),e.getX(),e.getY());
            }
        });
        item16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewStudentsAdminGUI window = new ViewStudentsAdminGUI();
                frame.setVisible(false);
            }
        });
        item17.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewMarksAdminGUI window = new ViewMarksAdminGUI();
                frame.setVisible(false);
            }
        });
        item18.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddStudentAdminGUI window = new AddStudentAdminGUI();
                frame.setVisible(false);
            }
        });
        item19.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddMarkAdminGUI window = new AddMarkAdminGUI();
                frame.setVisible(false);
            }
        });
        item20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditStudentAdminGUI window = new EditStudentAdminGUI();
                frame.setVisible(false);
            }
        });
        item21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditMarkAdminGUI window = new EditMarkAdminGUI();
                frame.setVisible(false);
            }
        });
        item22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveStudentAdminGUI window = new RemoveStudentAdminGUI();
                frame.setVisible(false);
            }
        });
        item23.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveMarkAdminGUI window = new RemoveMarkAdminGUI();
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
    public static void main(String[] args){
        AdminMenuGUI window = new AdminMenuGUI();
    }
}

