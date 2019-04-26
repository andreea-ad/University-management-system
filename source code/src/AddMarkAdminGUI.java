import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.*;
import java.time.*;


public class AddMarkAdminGUI {
    private JFrame frame;
    private JLabel labelStudent, labelNota, labelMaterie, labelProfesor, labelFacultate;
    private JTextField numeStudent, prenumeStudent, numeProfesor, prenumeProfesor;
    private JComboBox<Faculty> facultate;
    private JComboBox<String> student, materie;
    private JButton adaugare, anulare, inapoi;
    private JSpinner spinner;
    private SpinnerModel spinnerModel;
    private String numeStudentSelectat, prenumeStudentSelectat, materieSelectata, numeProfesorSelectat, prenumeProfesorSelectat, facultateSelectata;
    private int notaSelectata;
    private HashSet<Faculty> facultati;
    private HashSet<Subject> materii;
    private HashSet<Student> studenti;

    public AddMarkAdminGUI(){
        frame = new JFrame("Adăugare notă");

        labelStudent = new JLabel("Student: ");
        labelNota = new JLabel("Notă: ");
        labelMaterie = new JLabel("Materie: ");
        labelProfesor = new JLabel("Profesor: ");
        labelFacultate = new JLabel("Facultate: ");

        facultate = new JComboBox<>();
        student = new JComboBox<>();
        materie = new JComboBox<>();

        spinnerModel = new SpinnerNumberModel(1,1,10,1);
        spinner = new JSpinner(spinnerModel);

        adaugare = new JButton("Adăugare notă");
        anulare = new JButton("Anulare");
        inapoi = new JButton("Înapoi");

        numeStudent = new JTextField();
        prenumeStudent = new JTextField();
        numeProfesor = new JTextField();
        prenumeProfesor = new JTextField();

        numeStudent.setEditable(false);
        prenumeStudent.setEditable(false);
        numeProfesor.setEditable(false);
        prenumeProfesor.setEditable(false);

        ManagerGUI mng = new ManagerGUI();
        facultati = mng.getInstance().getSetFacultati();
        materii = mng.getInstance().getSetMaterii();
        studenti = mng.getInstance().getSetStudenti();

        for(Faculty f:facultati){
            facultate.addItem(f);
        }
        for(Student s:studenti){
            if(s.getFaculty().equals("Facultatea de Chimie și Biologie")){
                student.addItem(s.getLastName()+" "+s.getFirstName());
            }
        }
        for(Subject s:materii){
            if(s.getFaculty().equals("Facultatea de Chimie și Biologie")){
                materie.addItem(s.getTitle());
            }
        }
        facultate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                facultateSelectata=String.valueOf(facultate.getSelectedItem());
                student.removeAllItems();
                materie.removeAllItems();
                for(Student s:studenti){
                    if(s.getFaculty().equals(facultateSelectata)){
                        student.addItem(s.getLastName()+" "+s.getFirstName());
                    }
                }
                for(Subject s:materii){
                    if(s.getFaculty().equals(facultateSelectata)){
                        materie.addItem(s.getTitle());
                    }
                }
            }
        });
        materie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Subject s:materii){
                    if(s.getTitle().equals(materie.getSelectedItem())){
                        numeProfesor.setText(s.getTeacherLastName());
                        prenumeProfesor.setText(s.getTeacherFirstName());
                        break;
                    }
                }
            }
        });
        student.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Student s:studenti){
                    if((s.getLastName()+" "+s.getFirstName()).equals(student.getSelectedItem())){
                        numeStudent.setText(s.getLastName());
                        prenumeStudent.setText(s.getFirstName());
                    }
                }
            }
        });
        adaugare.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                numeStudentSelectat = numeStudent.getText();
                prenumeStudentSelectat = prenumeStudent.getText();
                notaSelectata = (int)spinner.getValue();
                materieSelectata = String.valueOf(materie.getSelectedItem());
                numeProfesorSelectat = numeProfesor.getText();
                prenumeProfesorSelectat = prenumeProfesor.getText();
                LocalDate date = LocalDate.now();
                Date dataModificarii = Date.valueOf(date);
                mng.getInstance().addMarkInDB(prenumeStudentSelectat,numeStudentSelectat,notaSelectata,materieSelectata,prenumeProfesorSelectat,numeProfesorSelectat,dataModificarii);
            }
        });
        anulare.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                numeStudent.setText("");
                prenumeStudent.setText("");
                spinner.setValue(1);
                materie.removeAllItems();
                numeProfesor.setText("");
                prenumeProfesor.setText("");
                facultate.setSelectedItem("Facultatea de Chimie și Biologie");
                student.removeAllItems();
            }
        });
        inapoi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setVisible(false);
                AdminMenuGUI window = new AdminMenuGUI();
            }
        });

        labelFacultate.setBounds(150,60,120,25);
        facultate.setBounds(220,60,310,25);
        labelStudent.setBounds(150,90,120,25);
        student.setBounds(220,90,310,25);
        numeStudent.setBounds(220,120,150,25);
        prenumeStudent.setBounds(380,120,150,25);
        labelMaterie.setBounds(150,150,120,25);
        materie.setBounds(220,150,310,25);
        labelNota.setBounds(150,180,120,25);
        spinner.setBounds(220,180,310,25);
        labelProfesor.setBounds(150,210,120,25);
        numeProfesor.setBounds(220,210,150,25);
        prenumeProfesor.setBounds(380,210,150,25);
        adaugare.setBounds(130,265,130,25);
        anulare.setBounds(275,265,130,25);
        inapoi.setBounds(420,265,130,25);

        frame.add(labelFacultate);
        frame.add(facultate);
        frame.add(labelStudent);
        frame.add(student);
        frame.add(numeStudent);
        frame.add(prenumeStudent);
        frame.add(labelMaterie);
        frame.add(materie);
        frame.add(labelNota);
        frame.add(spinner);
        frame.add(labelProfesor);
        frame.add(numeProfesor);
        frame.add(prenumeProfesor);
        frame.add(adaugare);
        frame.add(anulare);
        frame.add(inapoi);


        frame.setLayout(null);
        //set frame size
        frame.setPreferredSize(new Dimension(700,400));
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
