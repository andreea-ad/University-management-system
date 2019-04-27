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

        //1st button
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

        //2nd button
        final JPopupMenu popupMenu2 = new JPopupMenu();

        JMenuItem item12 = new JMenuItem("Vizualizare");
        JMenuItem item13 = new JMenuItem("Adăugare");
        JMenuItem item14 = new JMenuItem("Editare");
        JMenuItem item15 = new JMenuItem("Eliminare");

        //3rd button
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
        frame.add(label);
        frame.add(facultati);
        frame.add(profesori);
        frame.add(studenti);
        frame.add(inapoi);
        label.setFont(new Font(String.valueOf(label.getFont().getName()),Font.PLAIN,20));
        label.setBounds(230, 30, 200, 30);
        facultati.setBounds(180, 90, 200, 30);
        profesori.setBounds(180, 130, 200, 30);
        studenti.setBounds(180,170,200,30);
        inapoi.setBounds(180,220,200,30);
        facultati.setAlignmentX(RIGHT_ALIGNMENT);
        profesori.setAlignmentX(RIGHT_ALIGNMENT);
        studenti.setAlignmentX(RIGHT_ALIGNMENT);
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
}

