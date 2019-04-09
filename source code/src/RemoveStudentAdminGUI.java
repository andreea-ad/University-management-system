import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

public class RemoveStudentAdminGUI {
    private JFrame frame;
    private JLabel labelFacultate, labelStudent;
    private JComboBox<String> facultate, student;
    private JButton eliminare;
    private HashSet<Faculty> facultati;
    private HashSet<Student> studenti;
    private String facultateSelectata, emailStudent;
    private String[] numeStudent;
    public RemoveStudentAdminGUI(){
        frame = new JFrame("Eliminare student");

        labelFacultate = new JLabel("Facultate: ");
        labelStudent = new JLabel("Student: ");

        facultate = new JComboBox<>();
        student = new JComboBox<>();

        eliminare = new JButton("Eliminare student");

        ManagerGUI mng = new ManagerGUI();
        facultati = mng.getInstance().getSetFacultati();
        studenti = mng.getInstance().getSetStudenti();

        for(Faculty f:facultati){
            facultate.addItem(f.toString());
        }

        facultateSelectata = String.valueOf(facultate.getSelectedItem());
        for(Student s:studenti){
            if(s.getFaculty().equals(facultateSelectata)){
                student.addItem(s.getLastName()+" "+s.getFirstName());
            }
        }

        facultate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                student.removeAllItems();
                facultateSelectata = String.valueOf(facultate.getSelectedItem());
                for(Student s:studenti){
                    if(s.getFaculty().equals(facultateSelectata)){
                        student.addItem(s.getLastName()+" "+s.getFirstName());
                    }
                }
            }
        });

        eliminare.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                numeStudent = String.valueOf(student.getSelectedItem()).split(" ");
                for(Student s:studenti){
                    if(s.getFirstName().equals(numeStudent[1])&&s.getLastName().equals(numeStudent[0])){
                        emailStudent = s.getEmailAddress();
                    }
                }
                mng.getInstance().removeStudentFromDB(numeStudent[0], numeStudent[1], emailStudent);
            }
        });

        labelFacultate.setBounds(150,50,120,25);
        facultate.setBounds(270,50,250,25);
        labelStudent.setBounds(150,80,120,25);
        student.setBounds(270,80,250,25);
        eliminare.setBounds(250,130,200,25);

        frame.add(labelFacultate);
        frame.add(facultate);
        frame.add(labelStudent);
        frame.add(student);
        frame.add(eliminare);

        frame.setLayout(null);
        //set frame size
        frame.setPreferredSize(new Dimension(700,250));
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
