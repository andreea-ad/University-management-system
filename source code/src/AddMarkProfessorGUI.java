import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.*;
import java.text.*;
import java.sql.Date;
import java.util.List;

public class AddMarkProfessorGUI {
    private JFrame frame;
    private JLabel labelStudent, labelNota, labelMaterie, labelDataAdaugarii;
    private JTextField dataAdaugarii, materie;
    private SpinnerModel spinnerModel;
    private JSpinner spinner;
    private JComboBox <String> studenti;
    private JButton adaugare;
    private HashSet<Student> studentiFacultate;
    private HashSet<Professor> profesori;
    private String prenumeProfesor="";
    private String numeProfesor="";
    private LocalDate date;
    public AddMarkProfessorGUI(String email){
        frame = new JFrame("Adăugare note");

        labelStudent = new JLabel("Student: ");
        labelNota = new JLabel("Notă: ");
        labelMaterie = new JLabel("Materie: ");
        labelDataAdaugarii = new JLabel("Data adăugării: ");

        ManagerGUI mng = new ManagerGUI();

        studenti = new JComboBox<>();

        studentiFacultate = mng.getInstance().getSetStudenti();  //all students
        profesori = mng.getInstance().getSetProfesori();   //all teachers


        String facultateProfesor="";

        //get faculty, first name, last name and set subject of current teacher
        for(Professor p:profesori){
            if(p.getEmailAddress().equals(email)){
                facultateProfesor+=p.getFaculty();
                prenumeProfesor+=p.getFirstName();
                numeProfesor+=p.getLastName();
                materie = new JTextField(p.getTeachingSubject());
                break;
            }
        }

        //create combobox with students which study at the same faculty as the current teacher
        for(Student s:studentiFacultate){
            if(s.getFaculty().equals(facultateProfesor)){
                studenti.addItem(s.getLastName() + " " + s.getFirstName());
            }
        }

        //create spinner for mark
        spinnerModel = new SpinnerNumberModel(1,1,10,1);
        spinner = new JSpinner(spinnerModel);

        //set current date for dateAdded
        date = LocalDate.now();
        dataAdaugarii = new JTextField(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(date));
        dataAdaugarii.setEditable(false);

        adaugare = new JButton("Adăugare notă");

        //insert mark into DB
        adaugare.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String[] student = String.valueOf(studenti.getSelectedItem()).split("\\s+");
                String prenumeStudent = student[1];
                String numeStudent = student[0];
                int notaStudent = (Integer)spinner.getValue();
                String materieNota = materie.getText();
                Date dataAdaugarii = Date.valueOf(date);
                mng.getInstance().addMarkInDB(prenumeStudent,numeStudent,notaStudent,materieNota,prenumeProfesor,numeProfesor,dataAdaugarii);
                JOptionPane.showMessageDialog(null,"Nota a fost introdusă în baza de date!");
                frame.setVisible(false);
            }
        });


        materie.setEditable(false);

        labelMaterie.setBounds(150,40,120,35);
        materie.setBounds(280,40,120,35);
        labelStudent.setBounds(150,90,120,35);
        studenti.setBounds(280,90,120,35);
        labelNota.setBounds(150,140,120,35);
        spinner.setBounds(280,140,120,35);
        labelDataAdaugarii.setBounds(150,180,120,35);
        dataAdaugarii.setBounds(280,180,120,35);
        adaugare.setBounds(215,250,120,30);

        frame.add(labelMaterie);
        frame.add(materie);
        frame.add(labelStudent);
        frame.add(studenti);
        frame.add(labelNota);
        frame.add(spinner);
        frame.add(labelDataAdaugarii);
        frame.add(dataAdaugarii);
        frame.add(adaugare);

        frame.setLayout(null);
        //set frame size
        frame.setPreferredSize(new Dimension(570,380));
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
