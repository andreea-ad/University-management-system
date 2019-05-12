import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashSet;

public class EditSubjectGUI {
    private JFrame frame;
    private JLabel labelDenumire, labelFacultate, labelSpecializare, labelCicluUniversitar, labelSemestru, labelCredite, labelProfesor;
    private JTextField denumire;
    private SpinnerNumberModel semestru, nrCredite;
    private JSpinner sem, cred;
    private JComboBox<Faculty> faculties;
    private JComboBox<Department> departments;
    private JComboBox<String> degrees, professors;
    private HashSet<Faculty> facultati;
    private HashSet<Department> specializari;
    private HashSet<Professor> profesori;
    private JButton editare, inapoi;
    public EditSubjectGUI(String title, String faculty, String department, String degree, int semester, int credits, String professor){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Modificare date materie");
        labelDenumire = new JLabel("Denumire materie: ");
        labelFacultate = new JLabel("Facultate: ");
        labelSpecializare = new JLabel("Specializare: ");
        labelCicluUniversitar = new JLabel("Ciclu universitar: ");
        labelSemestru = new JLabel("Semestru: ");
        labelCredite = new JLabel("Număr de credite: ");
        labelProfesor = new JLabel("Profesor: ");
        faculties = new JComboBox<>();
        departments = new JComboBox<>();
        degrees = new JComboBox<>();
        professors = new JComboBox<>();
        editare = new JButton("Editează materie");
        inapoi = new JButton("Înapoi");
        denumire = new JTextField(title);
        semestru = new SpinnerNumberModel(semester,1,6,1);
        sem = new JSpinner(semestru);
        nrCredite = new SpinnerNumberModel(credits,1,10,1);
        cred = new JSpinner(nrCredite);
        ManagerGUI mng = new ManagerGUI();
        facultati = mng.getSetFacultati();
        specializari = mng.getSetSpecializari();
        profesori = mng.getSetProfesori();
        //add faculties into combobox
        for(Faculty f:facultati){
            faculties.addItem(f);
        }
        if(faculty.isEmpty()){
            faculties.addItem(new Faculty(""));
            faculties.setSelectedItem(new Faculty(""));
        }else {
            faculties.setSelectedItem(new Faculty(faculty));
        }
        for(Department d:specializari){
            if(d.getFaculty().equals(faculties.getSelectedItem().toString())){
                departments.addItem(d);
            }
        }
        departments.setSelectedItem(new Department(department));
        for(Professor p:profesori){
            if((p.getFaculty().equals(faculties.getSelectedItem().toString()) && p.getTeachingSubject().isEmpty()) ||
                    (p.getFaculty().isEmpty() && p.getTeachingSubject().isEmpty())){
                professors.addItem(p.getLastName() + " " + p.getFirstName());
            }
        }
        professors.addItem(professor);
        professors.setSelectedItem(professor);
        degrees.addItem("LICENTA");
        degrees.addItem("MASTER");
        degrees.addItem("DOCTORAT");
        degrees.setSelectedItem(degree);
        //add elements to the frame
        frame.add(labelDenumire);
        frame.add(denumire);
        frame.add(labelFacultate);
        frame.add(faculties);
        frame.add(labelSpecializare);
        frame.add(departments);
        frame.add(labelCicluUniversitar);
        frame.add(degrees);
        frame.add(labelSemestru);
        frame.add(sem);
        frame.add(labelCredite);
        frame.add(cred);
        frame.add(labelProfesor);
        frame.add(professors);
        frame.add(editare);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        //set bounds for elements
        labelDenumire.setBounds(150,70,120,25);
        denumire.setBounds(270,70,310,25);
        labelFacultate.setBounds(150,100,120,25);
        faculties.setBounds(270,100,310,25);
        labelSpecializare.setBounds(150,130,120,25);
        departments.setBounds(270,130,310,25);
        labelCicluUniversitar.setBounds(150,160,120,25);
        degrees.setBounds(270,160,310,25);
        labelSemestru.setBounds(150,190,120,25);
        sem.setBounds(270,190,310,25);
        labelCredite.setBounds(150,220,120,25);
        cred.setBounds(270,220,310,25);
        labelProfesor.setBounds(150,250,120,25);
        professors.setBounds(270,250,310,25);
        editare.setBounds(200,320,145,25);
        inapoi.setBounds(360,320,150,25);
        //button design
        editare.setBorderPainted(false);
        editare.setBackground(new Color(233,233,233));
        editare.setForeground(new Color(100,100,100));
        inapoi.setBorderPainted(false);
        inapoi.setBackground(new Color(233,233,233));
        inapoi.setForeground(new Color(100,100,100));
        //set frame icon
        try {
            frame.setIconImage(ImageIO.read(getClass().getResource("resources/1.png")));
        }catch(IOException ie){
            ie.printStackTrace();
        }
        //set frame size
        frame.setPreferredSize(new Dimension(750, 500));
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
        //add professors and departments when selecting a faculty
        faculties.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                faculties.removeItem("");
                professors.removeAllItems();
                for(Professor p:profesori){
                    if((p.getFaculty().equals(faculties.getSelectedItem().toString()) && p.getTeachingSubject().isEmpty()) ||
                        (p.getFaculty().isEmpty() && p.getTeachingSubject().isEmpty())){
                        professors.addItem(p.getLastName() + " " + p.getFirstName());
                    }
                }
                departments.removeAllItems();
                for(Department d:specializari){
                    if(d.getFaculty().equals(faculties.getSelectedItem().toString())){
                        departments.addItem(d);
                    }
                }
            }
        });
        //set degree when selecting a department
        departments.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Department d:specializari){
                    if(d.getTitle().equals(departments.getSelectedItem().toString())){
                        degrees.setSelectedItem(d.getDegree().toString());
                    }
                }
            }
        });
        //update the subject into DB
        editare.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //if(mng.updateSubjectFromDB(title, faculties.getSelectedItem().toString(),departments.getSelectedItem().toString(),degrees.getSelectedItem(),sem.getValue(),cred.getValue(),professors.getSelectedItem().toString().split(" ")[1],professors.getSelectedItem().toString().split(" ")[0]) ==1){
                //    JOptionPane.showMessageDialog(null,"Datele materiei au fost actualizate!");
                //}
            }
        });
    }
}
