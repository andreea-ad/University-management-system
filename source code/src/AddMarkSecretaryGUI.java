import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

public class AddMarkSecretaryGUI {
    private JFrame frame;
    private String facultate;
    private JLabel labelSpecializare, labelMaterie, labelNota, labelStudent, labelDataAdaugarii;
    private SpinnerNumberModel spinnerModelNota;
    private JSpinner nota;
    private JTextField dataAdaugarii;
    private HashSet<Student> studenti;
    private HashSet<Department> specializari;
    private HashSet<Subject> materii;
    private JComboBox<Department> departments;
    private JComboBox<Subject> subjects;
    private JComboBox<Student> students;
    private JButton adaugare, inapoi;
    public AddMarkSecretaryGUI(String email){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Adăugare note");
        departments = new JComboBox<>();
        subjects = new JComboBox<>();
        students = new JComboBox<>();
        adaugare = new JButton("Adaugă notă");
        inapoi = new JButton("Înapoi");
        labelSpecializare = new JLabel("Specializare: ");
        labelMaterie = new JLabel("Materie: ");
        labelStudent = new JLabel("Studenți: ");
        labelNota = new JLabel("Notă: ");
        labelDataAdaugarii = new JLabel("Data adăugării: ");
        spinnerModelNota = new SpinnerNumberModel(1,1,10,1);
        nota = new JSpinner(spinnerModelNota);
        dataAdaugarii = new JTextField(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now()));
        ManagerGUI mng = new ManagerGUI();
        studenti = mng.getSetStudenti();
        specializari = mng.getSetSpecializari();
        materii = mng.getSetMaterii();
        facultate = mng.getFacultateDupaEmail(email);
        //add all departments from this faculty into combobox
        departments.addItem(new Department("Toate specializările"));
        for(Department d:specializari){
            if(d.getFaculty().equals(facultate)){
                departments.addItem(d);
            }
        }
        //add all subjects from this faculty into combobox
        for(Subject s:materii){
            if(s.getFaculty().equals(facultate)){
                subjects.addItem(s);
            }
        }
        //add all students from this faculty into combobox
        for(Student s:studenti){
            if(s.getFaculty().equals(facultate)){
                students.addItem(s);
            }
        }
        //add elements to the frame
        frame.add(labelSpecializare);
        frame.add(departments);
        frame.add(labelMaterie);
        frame.add(subjects);
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
        //set textfield not editable
        dataAdaugarii.setEditable(false);
        //set bounds for elements
        labelSpecializare.setBounds(140,50,120,25);
        departments.setBounds(260,50,170,25);
        labelMaterie.setBounds(140,80,120,25);
        subjects.setBounds(260,80,170,25);
        labelStudent.setBounds(140,110,120,25);
        students.setBounds(260,110,170,25);
        labelNota.setBounds(140,140,120,25);
        nota.setBounds(260,140,170,25);
        labelDataAdaugarii.setBounds(140,170,120,25);
        dataAdaugarii.setBounds(260,170,170,25);
        adaugare.setBounds(130,220,150,25);
        inapoi.setBounds(293,220,150,25);
        //buttons design
        adaugare.setBorderPainted(false);
        adaugare.setBackground(new Color(233,233,233));
        adaugare.setForeground(new Color(100,100,100));
        inapoi.setBorderPainted(false);
        inapoi.setBackground(new Color(233,233,233));
        inapoi.setForeground(new Color(100,100,100));
        //labels design
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
        frame.setPreferredSize(new Dimension(600,350));
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
        //add subjects and students into comboboxes when selecting a department
        departments.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                subjects.removeAllItems();
                students.removeAllItems();
                if(departments.getItemCount() > 0){
                    for(Subject s:materii){
                        if(departments.getSelectedItem().toString().equals("Toate specializările")){
                            subjects.addItem(s);
                        }else if(s.getDepartment().equals(departments.getSelectedItem().toString())){
                            subjects.addItem(s);
                        }
                    }
                    for(Student s:studenti){
                        if(departments.getSelectedItem().toString().equals("Toate specializările")){
                            students.addItem(s);
                        }else if(s.getDepartment().equals(departments.getSelectedItem().toString())){
                            students.addItem(s);
                        }
                    }
                }
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
                SecretaryMenuGUI window = new SecretaryMenuGUI(email);
            }
        });
    }
    public static void main(String[] args){
        AddMarkSecretaryGUI window = new AddMarkSecretaryGUI("fizica@gmail.com");
    }
}
