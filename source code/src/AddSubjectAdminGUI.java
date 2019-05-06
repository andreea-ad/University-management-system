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
    private JTextField titlu;
    private JComboBox<Faculty> faculties;
    private JComboBox<Department> departments;
    private JComboBox<String> degrees;
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
        faculties = new JComboBox<>();
        departments = new JComboBox<>();
        degrees = new JComboBox<>();
        professors = new JComboBox<>();
        spinnerSemestru = new SpinnerNumberModel(1,1,6,1);
        semestru = new JSpinner(spinnerSemestru);
        spinnerCredite = new SpinnerNumberModel(1,1,15,1);
        credite = new JSpinner(spinnerCredite);
        adaugare = new JButton("Adaugă materie");
        anulare = new JButton("Anulează");
        inapoi = new JButton("Înapoi");
        ManagerGUI mng = new ManagerGUI();
        facultati = mng.getInstance().getSetFacultati();
        specializari = mng.getInstance().getSetSpecializari();
        profesori = mng.getInstance().getSetProfesori();
        //add faculties into combobox
        for(Faculty f:facultati){
            faculties.addItem(f);
        }
        //add degrees into combobox
        degrees.addItem("LICENTA");
        degrees.addItem("MASTER");
        degrees.addItem("DOCTORAT");
        //add elements to the frame
        frame.add(labelTitlu);
        frame.add(titlu);
        frame.add(labelFacultate);
        frame.add(faculties);
        frame.add(labelSpecializare);
        frame.add(departments);
        frame.add(labelCicluUniversitar);
        frame.add(degrees);
        frame.add(labelProfesor);
        frame.add(professors);
        frame.add(labelSemestru);
        frame.add(semestru);
        frame.add(labelCredite);
        frame.add(credite);
        frame.add(adaugare);
        frame.add(anulare);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        //set bounds for elements
        labelTitlu.setBounds(150,60,150,25);
        titlu.setBounds(300,60,300,25);
        labelFacultate.setBounds(150,90,150,25);
        faculties.setBounds(300,90,300,25);
        labelSpecializare.setBounds(150,120,150,25);
        departments.setBounds(300,120,300,25);
        labelCicluUniversitar.setBounds(150,150,150,25);
        degrees.setBounds(300,150,300,25);
        labelProfesor.setBounds(150,180,150,25);
        professors.setBounds(300,180,300,25);
        labelSemestru.setBounds(150,210,150,25);
        semestru.setBounds(300,210,300,25);
        labelCredite.setBounds(150,240,150,25);
        credite.setBounds(300,240,300,25);
        adaugare.setBounds(140,280,150,25);
        anulare.setBounds(300,280,150,25);
        inapoi.setBounds(460,280,150,25);
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
        frame.setPreferredSize(new Dimension(765,400));
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
                    if(p.getFaculty().equals(faculties.getSelectedItem().toString())){
                        professors.addItem(p);
                    }
                }
            }
        });
        //add subject into DB
        adaugare.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(mng.addSubjectInDB(titlu.getText(),faculties.getSelectedItem().toString(),departments.getSelectedItem().toString(),degrees.getSelectedItem().toString(),(int)semestru.getValue(),(int)credite.getValue(),professors.getSelectedItem().toString()) == 1){
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
                degrees.setSelectedIndex(0);
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
