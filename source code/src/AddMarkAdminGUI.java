import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.*;

public class AddMarkAdminGUI {
    private JFrame frame;
    private JLabel labelFacultate, labelSpecializare, labelMaterie, labelNota, labelStudent, labelDataAdaugarii;
    private SpinnerNumberModel spinnerModelNota;
    private JSpinner nota;
    private JTextField dataAdaugarii;
    private HashSet<Faculty> facultati;
    private HashSet<Student> studenti;
    private HashSet<Department> specializari;
    private HashSet<Subject> materii;
    private JComboBox<Faculty> faculties;
    private JComboBox<Department> departments;
    private JComboBox<Subject> subjects;
    private JComboBox<Student> students;
    private JButton adaugare, inapoi;
    public AddMarkAdminGUI(){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Adăugare note");
        faculties = new JComboBox<>();
        departments = new JComboBox<>();
        subjects = new JComboBox<>();
        students = new JComboBox<>();
        adaugare = new JButton("Adaugă notă");
        inapoi = new JButton("Înapoi");
        labelFacultate = new JLabel("Facultate: ");
        labelSpecializare = new JLabel("Specializare: ");
        labelMaterie = new JLabel("Materie: ");
        labelStudent = new JLabel("Studenți: ");
        labelNota = new JLabel("Notă: ");
        labelDataAdaugarii = new JLabel("Data adăugării: ");
        spinnerModelNota = new SpinnerNumberModel(1,1,10,1);
        nota = new JSpinner(spinnerModelNota);
        dataAdaugarii = new JTextField(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now()));
        ManagerGUI mng = new ManagerGUI();
        facultati = mng.getInstance().getSetFacultati();
        studenti = mng.getInstance().getSetStudenti();
        specializari = mng.getInstance().getSetSpecializari();
        materii = mng.getInstance().getSetMaterii();
        //add all faculties into combobox
        for(Faculty f:facultati){
            faculties.addItem(f);
        }
        //add elements to the frame
        frame.add(labelFacultate);
        frame.add(faculties);
        frame.add(labelSpecializare);
        frame.add(labelMaterie);
        frame.add(labelStudent);
        frame.add(labelNota);
        frame.add(nota);
        frame.add(labelDataAdaugarii);
        frame.add(dataAdaugarii);
        frame.add(adaugare);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        //set textfield not editable
        dataAdaugarii.setEditable(false);
        //set bounds for elements
        labelFacultate.setBounds(190,50,120,25);
        faculties.setBounds(300,50,300,25);
        labelSpecializare.setBounds(190,80,120,25);
        labelMaterie.setBounds(190,110,120,25);
        labelStudent.setBounds(190,140,120,25);
        labelNota.setBounds(190,170,120,25);
        nota.setBounds(300,170,300,25);
        labelDataAdaugarii.setBounds(190,200,120,25);
        dataAdaugarii.setBounds(300,200,300,25);
        adaugare.setBounds(245,250,150,25);
        inapoi.setBounds(405,250,150,25);
        //buttons design
        adaugare.setBorderPainted(false);
        adaugare.setBackground(new Color(233,233,233));
        adaugare.setForeground(new Color(100,100,100));
        inapoi.setBorderPainted(false);
        inapoi.setBackground(new Color(233,233,233));
        inapoi.setForeground(new Color(100,100,100));
        //labels design
        labelFacultate.setForeground(new Color(100,100,100));
        labelSpecializare.setForeground(new Color(100,100,100));
        labelMaterie.setForeground(new Color(100,100,100));
        labelStudent.setForeground(new Color(100,100,100));
        labelNota.setForeground(new Color(100,100,100));
        labelDataAdaugarii.setForeground(new Color(100,100,100));
        //set frame icon
        try {
            frame.setIconImage(ImageIO.read(getClass().getResource("resources/1.png")));
        }catch(IOException ie){
            ie.printStackTrace();
        }
        //set frame size
        frame.setPreferredSize(new Dimension(800,380));
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
        //add departments into combobox when selecting a faculty
        faculties.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                departments.removeAllItems();
                subjects.removeAllItems();
                students.removeAllItems();
                for(Department d:specializari){
                    if(d.getFaculty().equals(faculties.getSelectedItem().toString())){
                        departments.addItem(d);
                    }
                }
                frame.add(departments);
                departments.setBounds(300,80,300,25);
            }
        });
        //add subjects and students into comboboxes when selecting a department
        departments.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                subjects.removeAllItems();
                students.removeAllItems();
                if(departments.getItemCount() > 0){
                    for(Subject s:materii){
                        if(s.getDepartment().equals(departments.getSelectedItem().toString())){
                            subjects.addItem(s);
                        }
                    }
                    for(Student s:studenti){
                        if(s.getDepartment().equals(departments.getSelectedItem().toString())){
                            students.addItem(s);
                        }
                    }
                }
                frame.add(subjects);
                subjects.setBounds(300,110,300,25);
                frame.add(students);
                students.setBounds(300,140,300,25);
            }
        });
        //insert mark into DB
        adaugare.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String[] student = String.valueOf(students.getSelectedItem().toString()).split("\\s+");
                String[] profesor = {"", ""};
                for (Subject s : materii) {
                    if (s.getTitle().equals(subjects.getSelectedItem().toString())) {
                        profesor[0] += s.getTeacherLastName();
                        profesor[1] += s.getTeacherFirstName();
                        break;
                    }
                }
                if(mng.addMarkInDB(student[1], student[0], (int) spinnerModelNota.getValue(), subjects.getSelectedItem().toString(), profesor[1], profesor[0], java.sql.Date.valueOf(dataAdaugarii.getText())) == 1){
                    JOptionPane.showMessageDialog(null, "Nota a fost adăugată în baza de date!");
                }
            }
        });
        //go back to user menu
        inapoi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setVisible(false);
                AdminMenuGUI window = new AdminMenuGUI();
            }
        });
    }
    public static void main(String[] args){
        AddMarkAdminGUI window = new AddMarkAdminGUI();
    }
}
