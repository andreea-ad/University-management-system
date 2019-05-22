import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashSet;

public class AddSubjectAdminGUI {
    private JFrame frame;
    private JLabel labelTitlu, labelFacultate, labelSpecializare, labelCicluUniversitar, labelProfesor, labelSemestru, labelCredite;
    private JTextField titlu, cicluUniversitar;
    private JComboBox<Faculty> faculties;
    private JComboBox<Department> departments;
    private JComboBox<Professor> professors;
    private SpinnerNumberModel spinnerSemestru;
    private JSpinner semestru;
    private SpinnerNumberModel spinnerCredite;
    private JSpinner credite;
    private HashSet<Faculty> facultati;
    private HashSet<Department> specializari;
    private HashSet<Professor> profesori;
    private JButton adaugare, anulare, inapoi;
    public AddSubjectAdminGUI(){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Adăugare materie");
        labelTitlu = new JLabel("Denumire materie: ");
        labelFacultate = new JLabel("Facultate: ");
        labelSpecializare = new JLabel("Specializare: ");
        labelCicluUniversitar = new JLabel("Ciclu universitar: ");
        labelProfesor = new JLabel("Profesor: ");
        labelSemestru = new JLabel("Semestru: ");
        labelCredite = new JLabel("Număr de credite: ");
        titlu = new JTextField();
        cicluUniversitar = new JTextField();
        faculties = new JComboBox<>();
        departments = new JComboBox<>();
        professors = new JComboBox<>();
        spinnerSemestru = new SpinnerNumberModel(1,1,6,1);
        semestru = new JSpinner(spinnerSemestru);
        spinnerCredite = new SpinnerNumberModel(1,1,15,1);
        credite = new JSpinner(spinnerCredite);
        adaugare = new JButton("Adaugă materie");
        anulare = new JButton("Anulează");
        inapoi = new JButton("Înapoi");
        ManagerGUI mng = new ManagerGUI();
        facultati = mng.getSetFacultati();
        specializari = mng.getSetSpecializari();
        profesori = mng.getSetProfesori();
        //add faculties into combobox
        for(Faculty f:facultati){
            faculties.addItem(f);
        }
        //add departments into combobox
        for(Department d:specializari){
            if(d.getFaculty().equals(faculties.getSelectedItem().toString())){
                departments.addItem(d);
            }
        }
        //set degree for current department
        for(Department d:specializari){
            if(d.getTitle().equals(departments.getSelectedItem().toString())){
                cicluUniversitar.setText(d.getDegree().toString());
                break;
            }
        }
        //add teachers into combobox when selecting a faculty
        for(Professor p:profesori){
            if(p.getFaculty().equals(faculties.getSelectedItem().toString()) && p.getTeachingSubject().isEmpty()){
                professors.addItem(p);
            }
        }
        //add elements to the frame
        frame.add(labelTitlu);
        frame.add(titlu);
        frame.add(labelFacultate);
        frame.add(faculties);
        frame.add(labelSpecializare);
        frame.add(departments);
        frame.add(labelCicluUniversitar);
        frame.add(cicluUniversitar);
        frame.add(labelProfesor);
        frame.add(professors);
        frame.add(labelSemestru);
        frame.add(semestru);
        frame.add(labelCredite);
        frame.add(credite);
        frame.add(adaugare);
        frame.add(anulare);
        frame.add(inapoi);
        //set textfield not editable
        cicluUniversitar.setEditable(false);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        //set bounds for elements
        labelTitlu.setBounds(160,100,150,25);
        titlu.setBounds(330,100,300,25);
        labelFacultate.setBounds(160,130,150,25);
        faculties.setBounds(330,130,300,25);
        labelSpecializare.setBounds(160,160,150,25);
        departments.setBounds(330,160,300,25);
        labelCicluUniversitar.setBounds(160,190,150,25);
        cicluUniversitar.setBounds(330,190,300,25);
        labelProfesor.setBounds(160,220,150,25);
        professors.setBounds(330,220,300,25);
        labelSemestru.setBounds(160,250,150,25);
        semestru.setBounds(330,250,300,25);
        labelCredite.setBounds(160,280,150,25);
        credite.setBounds(330,280,300,25);
        adaugare.setBounds(165,330,145,25);
        anulare.setBounds(320,330,145,25);
        inapoi.setBounds(475,330,145,25);
        //buttons design
        adaugare.setBorderPainted(false);
        adaugare.setBackground(new Color(233,233,233));
        adaugare.setForeground(new Color(100,100,100));
        anulare.setBorderPainted(false);
        anulare.setBackground(new Color(233,233,233));
        anulare.setForeground(new Color(100,100,100));
        inapoi.setBorderPainted(false);
        inapoi.setBackground(new Color(233,233,233));
        inapoi.setForeground(new Color(100,100,100));
        faculties.setBackground(new Color(233,233,233));
        faculties.setForeground(new Color(100,100,100));
        departments.setBackground(new Color(233,233,233));
        departments.setForeground(new Color(100,100,100));
        professors.setBackground(new Color(233,233,233));
        professors.setForeground(new Color(100,100,100));
        //labels design
        labelTitlu.setForeground(new Color(100,100,100));
        labelFacultate.setForeground(new Color(100,100,100));
        labelSpecializare.setForeground(new Color(100,100,100));
        labelCicluUniversitar.setForeground(new Color(100,100,100));
        labelSemestru.setForeground(new Color(100,100,100));
        labelCredite.setForeground(new Color(100,100,100));
        labelProfesor.setForeground(new Color(100,100,100));
        //set frame icon
        try {
            frame.setIconImage(ImageIO.read(getClass().getResource("resources/1.png")));
        }catch(IOException ie){
            ie.printStackTrace();
        }
        //set frame size
        frame.setPreferredSize(new Dimension(800,500));
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
        //add departments and teachers when selecting a faculty
        faculties.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                departments.removeAllItems();
                for(Department d:specializari){
                    if(d.getFaculty().equals(faculties.getSelectedItem().toString())){
                        departments.addItem(d);
                    }
                }
                professors.removeAllItems();
                for(Professor p:profesori){
                    if(p.getFaculty().equals(faculties.getSelectedItem().toString()) && p.getTeachingSubject().isEmpty()){
                        professors.addItem(p);
                    }
                }
            }
        });
        //set degree when selecting a department
        departments.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(departments.getItemCount() > 0) {
                    for (Department d : specializari) {
                        if (d.getTitle().equals(departments.getSelectedItem().toString())) {
                            cicluUniversitar.setText(d.getDegree());
                            break;
                        }
                    }
                }
            }
        });
        //add subject into DB
        adaugare.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(mng.addSubjectInDB(titlu.getText(),faculties.getSelectedItem().toString(),departments.getSelectedItem().toString(),cicluUniversitar.getText(),(int)semestru.getValue(),(int)credite.getValue(),professors.getSelectedItem().toString()) == 1){
                    JOptionPane.showMessageDialog(null, "Materia a fost adăugată în baza de date!");
                }
            }
        });
        //empty the input fields
        anulare.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                titlu.setText("");
                faculties.setSelectedIndex(0);
                departments.setSelectedIndex(0);
                cicluUniversitar.setText("");
                semestru.setValue(1);
                credite.setValue(0);
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
        AddSubjectAdminGUI window = new AddSubjectAdminGUI();
    }
}
