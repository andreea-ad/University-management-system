import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

public class EditMarkProfessorGUI {
    private JFrame frame;
    private JLabel labelStudent, labelNota, labelMaterie, labelDataAdaugarii;
    private JTextField dataAdaugarii, materie;
    private SpinnerModel spinnerModel;
    private JSpinner spinner;
    private JComboBox <String> studenti;
    private JButton editare, inapoi;
    private HashSet<Student> studentiFacultate;
    private HashSet<Professor> profesori;
    private HashSet<Mark> note;
    private LocalDate date;
    public EditMarkProfessorGUI(String email){
        frame = new JFrame("Modificare notă");
        frame.getContentPane().setBackground(Color.WHITE);

        labelStudent = new JLabel("Student: ");
        labelNota = new JLabel("Notă: ");
        labelMaterie = new JLabel("Materie: ");
        labelDataAdaugarii = new JLabel("Ultima modificare: ");

        ManagerGUI mng = new ManagerGUI();

        studenti = new JComboBox<>();

        studentiFacultate = mng.getInstance().getSetStudenti();  //all students
        profesori = mng.getInstance().getSetProfesori();   //all teachers

        String facultateProfesor="";

        //get faculty, first name, last name and set subject of current teacher
        for(Professor p:profesori){
            if(p.getEmailAddress().equals(email)){
                facultateProfesor+=p.getFaculty();
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
        note = mng.getInstance().getSetNote();

        //show data on select from combobox
        studenti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentSelectat = String.valueOf(studenti.getSelectedItem());
                for(Mark m:note) {
                    String s = m.getStudentLastName() + " " + m.getStudentFirstName();
                    if (studentSelectat.equals(s)) {
                        spinner.setValue(m.getMark());
                        dataAdaugarii = new JTextField(String.valueOf(m.getDateAdded()));
                    }
                }
            }
        });

        //default values
        String studentSelectat = String.valueOf(studenti.getSelectedItem());
        for(Mark m:note){
            String s = m.getStudentLastName() + " " + m.getStudentFirstName();
            if (studentSelectat.equals(s)) {
                spinner.setValue(m.getMark());
                dataAdaugarii = new JTextField(String.valueOf(m.getDateAdded()));
            }
        }

        date = LocalDate.now();
        dataAdaugarii = new JTextField(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(date));
        dataAdaugarii.setEditable(false);

        editare = new JButton("Editare notă");
        inapoi = new JButton("Înapoi");

        //update mark into DB
        editare.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String[] student = String.valueOf(studenti.getSelectedItem()).split("\\s+");
                String prenumeStudent = student[1];
                String numeStudent = student[0];
                int notaStudent = (Integer)spinner.getValue();
                String materieNota = materie.getText();
                Date dataEditarii = Date.valueOf(date);
                mng.getInstance().updateMarkFromDB(prenumeStudent,numeStudent,notaStudent,materieNota,dataEditarii);
                JOptionPane.showMessageDialog(null,"Nota a fost modificată în baza de date!");
                frame.setVisible(false);
            }
        });
        inapoi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setVisible(false);
                ProfessorMenuGUI window = new ProfessorMenuGUI(email);
            }
        });

        materie.setEditable(false);

        labelMaterie.setBounds(150,40,120,25);
        materie.setBounds(280,40,120,25);
        labelStudent.setBounds(150,70,120,25);
        studenti.setBounds(280,70,120,25);
        labelNota.setBounds(150,100,120,25);
        spinner.setBounds(280,100,120,25);
        labelDataAdaugarii.setBounds(150,130,120,25);
        dataAdaugarii.setBounds(280,130,120,25);
        editare.setBounds(125,180,145,25);
        inapoi.setBounds(280,180,145,25);

        frame.add(labelMaterie);
        frame.add(materie);
        frame.add(labelStudent);
        frame.add(studenti);
        frame.add(labelNota);
        frame.add(spinner);
        frame.add(labelDataAdaugarii);
        frame.add(dataAdaugarii);
        frame.add(editare);
        frame.add(inapoi);

        frame.setLayout(null);
        //set frame size
        frame.setPreferredSize(new Dimension(570,300));
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
