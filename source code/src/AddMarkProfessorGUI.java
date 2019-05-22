import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.synth.SynthTableUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.*;

public class AddMarkProfessorGUI {
    private JFrame frame;
    private String[] profesor;
    private String facultate = "", specializare = "";
    private JLabel labelStudent, labelNota, labelMaterie, labelDataAdaugarii;
    private JTextField dataAdaugarii, materie;
    private SpinnerModel spinnerModelNota;
    private JSpinner nota;
    private JComboBox<Student> students;
    private JButton adaugare, inapoi;
    private HashSet<Student> studenti;
    private HashSet<Subject> materii;
    private HashSet<Professor> profesori;
    public AddMarkProfessorGUI(String email){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Adăugare note");
        labelStudent = new JLabel("Student: ");
        labelNota = new JLabel("Notă: ");
        labelMaterie = new JLabel("Materie: ");
        labelDataAdaugarii = new JLabel("Data adăugării: ");
        //set current date for dateAdded
        dataAdaugarii = new JTextField(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now()));
        materie = new JTextField();
        //create spinner for mark
        spinnerModelNota = new SpinnerNumberModel(1,1,10,1);
        nota = new JSpinner(spinnerModelNota);
        students = new JComboBox<>();
        adaugare = new JButton("Adaugă notă");
        inapoi = new JButton("Înapoi");
        ManagerGUI mng = new ManagerGUI();
        profesor = mng.getProfesorDupaEmail(email);
        studenti = mng.getSetStudenti();
        profesori = mng.getSetProfesori();
        materii = mng.getSetMaterii();
        //set teacher's subject and get department
        for(Subject s:materii){
            if(s.getTeacherFirstName().equals(profesor[0]) && s.getTeacherLastName().equals(profesor[1])){
                materie.setText(s.getTitle());
                specializare += s.getDepartment();
                break;
            }
        }
        //get teacher's faculty
        for(Professor p:profesori){
            if(p.getFirstName().equals(profesor[0]) && p.getLastName().equals(profesor[1])){
                facultate += p.getFaculty();
            }
        }
        //create combobox with students which study at the same faculty as the current teacher
        for(Student s:studenti){
            if(s.getFaculty().equals(facultate) && s.getDepartment().equals(specializare)){
                students.addItem(s);
            }
        }
        //add elements to the frame
        frame.add(labelMaterie);
        frame.add(materie);
        frame.add(labelStudent);
        frame.add(students);
        frame.add(labelNota);
        frame.add(nota);
        frame.add(labelDataAdaugarii);
        frame.add(dataAdaugarii);
        frame.add(adaugare);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        //set textfields not editable
        dataAdaugarii.setEditable(false);
        materie.setEditable(false);
        //set bounds for elements
        labelMaterie.setBounds(150,100,120,25);
        materie.setBounds(280,100,300,25);
        labelStudent.setBounds(150,130,120,25);
        students.setBounds(280,130,300,25);
        labelNota.setBounds(150,160,120,25);
        nota.setBounds(280,160,300,25);
        labelDataAdaugarii.setBounds(150,190,120,25);
        dataAdaugarii.setBounds(280,190,300,25);
        adaugare.setBounds(215,240,145,25);
        inapoi.setBounds(365,240,145,25);
        //buttons design
        adaugare.setBorderPainted(false);
        adaugare.setBackground(new Color(233,233,233));
        adaugare.setForeground(new Color(100,100,100));
        inapoi.setBorderPainted(false);
        inapoi.setBackground(new Color(233,233,233));
        inapoi.setForeground(new Color(100,100,100));
        students.setBackground(new Color(233,233,233));
        students.setForeground(new Color(100,100,100));
        //labels design
        labelStudent.setForeground(new Color(100,100,100));
        labelMaterie.setForeground(new Color(100,100,100));
        labelNota.setForeground(new Color(100,100,100));
        labelDataAdaugarii.setForeground(new Color(100,100,100));
        //set frame icon
        try {
            frame.setIconImage(ImageIO.read(getClass().getResource("resources/1.png")));
        }catch(IOException ie){
            ie.printStackTrace();
        }
        //set frame size
        frame.setPreferredSize(new Dimension(740,400));
        frame.setLayout(null);
        frame.pack();
        //set window in the middle of the screen
        frame.setLocationRelativeTo(null);
        //set the default close button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set frame visible
        frame.setVisible(true);
        /*
        ==============
        define actions
        ==============
        */
        //insert mark into DB
        adaugare.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String[] student = String.valueOf(students.getSelectedItem().toString()).split("\\s+");
                if(mng.addMarkInDB(student[1], student[0], (int)nota.getValue(), materie.getText(), profesor[0], profesor[1],java.sql.Date.valueOf(dataAdaugarii.getText())) == 1) {
                    JOptionPane.showMessageDialog(null, "Nota a fost introdusă în baza de date!");
                }
            }
        });
        //go back to user menu
        inapoi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setVisible(false);
                ProfessorMenuGUI window = new ProfessorMenuGUI(email);
            }
        });
    }
    public static void main(String[] args){
        AddMarkProfessorGUI window = new AddMarkProfessorGUI("maria.ionescu@gmail.com");
    }
}
