import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashSet;

public class PDViewStudentGUI{
    private JFrame frame;
    private JLabel welcome, labelNrMatricol, labelNume, labelPrenume, labelCnp, labelDataNasterii, labelNrTelefon, labelAdresa, labelAdresaEmail, labelFacultate, labelSpecializare, labelCicluUniversitar, labelAn, labelNrCredite;
    private JTextField nrMatricol, nume, prenume, cnp, dataNasterii, nrTelefon, adresa, adresaEmail, facultate, specializare, cicluUniversitar, an, nrCredite;
    private HashSet<Student> studenti;
    private JButton inapoi;
    public PDViewStudentGUI(String email){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Vizualizare date personale");
        welcome = new JLabel("Bun venit!");
        labelNrMatricol = new JLabel("Număr matricol: ");
        labelNume = new JLabel("Nume: ");
        labelPrenume = new JLabel("Prenume: ");
        labelCnp = new JLabel("CNP: ");
        labelDataNasterii = new JLabel("Data nașterii: ");
        labelNrTelefon = new JLabel("Număr de telefon: ");
        labelAdresa = new JLabel("Adresă: ");
        labelAdresaEmail = new JLabel("Adresă de email: ");
        labelFacultate = new JLabel("Facultate: ");
        labelSpecializare = new JLabel("Specializare: ");
        labelCicluUniversitar = new JLabel("Ciclu universitar: ");
        labelAn = new JLabel("An universitar: ");
        labelNrCredite = new JLabel("Număr de credite: ");
        inapoi = new JButton("Înapoi");
        ManagerGUI mng = new ManagerGUI();
        studenti = mng.getSetStudenti();
        String welcomeName = "";
        for(Student s:studenti){
            if(s.getEmailAddress().equals(email)) {
                welcomeName += s.getLastName() + " " + s.getFirstName();
                frame = new JFrame("Vizualizare date personale: " + welcomeName);
                nrMatricol = new JTextField(String.valueOf(s.getID()));
                nume = new JTextField(s.getLastName());
                prenume = new JTextField(s.getFirstName());
                cnp = new JTextField(s.getCnp());
                dataNasterii =  new JTextField(String.valueOf(s.getDob()));
                nrTelefon = new JTextField(s.getPhoneNumber());
                adresa = new JTextField(s.getAddress());
                adresaEmail = new JTextField(s.getEmailAddress());
                facultate = new JTextField(s.getFaculty());
                specializare = new JTextField(s.getDepartment());
                cicluUniversitar = new JTextField(s.getDegree().toString());
                an = new JTextField(String.valueOf(s.getYear()));
                nrCredite = new JTextField(String.valueOf(s.getNumberOfCredits()));
                break;
            }
        }
        //add elements to the frame
        frame.add(welcome);
        frame.add(labelNrMatricol);
        frame.add(nrMatricol);
        frame.add(labelNume);
        frame.add(nume);
        frame.add(labelPrenume);
        frame.add(prenume);
        frame.add(labelCnp);
        frame.add(cnp);
        frame.add(labelDataNasterii);
        frame.add(dataNasterii);
        frame.add(labelNrTelefon);
        frame.add(nrTelefon);
        frame.add(labelAdresa);
        frame.add(adresa);
        frame.add(labelAdresaEmail);
        frame.add(adresaEmail);
        frame.add(labelFacultate);
        frame.add(facultate);
        frame.add(labelSpecializare);
        frame.add(specializare);
        frame.add(labelCicluUniversitar);
        frame.add(cicluUniversitar);
        frame.add(labelAn);
        frame.add(an);
        frame.add(labelNrCredite);
        frame.add(nrCredite);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        //set increased font size for welcome label
        welcome.setFont(new Font(String.valueOf(welcome.getFont().getName()),Font.PLAIN,20));
        //set fields not editable
        nrMatricol.setEditable(false);
        nume.setEditable(false);
        prenume.setEditable(false);
        cnp.setEditable(false);
        dataNasterii.setEditable(false);
        nrTelefon.setEditable(false);
        adresa.setEditable(false);
        adresaEmail.setEditable(false);
        facultate.setEditable(false);
        specializare.setEditable(false);
        cicluUniversitar.setEditable(false);
        an.setEditable(false);
        nrCredite.setEditable(false);
        //set bounds for elements
        welcome.setBounds(300,13,300,100);
        labelNrMatricol.setBounds(150,100,120,25);
        nrMatricol.setBounds(270,100,270,25);
        labelNume.setBounds(150,130,120,25);
        nume.setBounds(270,130,270,25);
        labelPrenume.setBounds(150,160,120,25);
        prenume.setBounds(270,160,270,25);
        labelCnp.setBounds(150,190,120,25);
        cnp.setBounds(270,190,270,25);
        labelDataNasterii.setBounds(150,220,120,25);
        dataNasterii.setBounds(270,220,270,25);
        labelNrTelefon.setBounds(150,250,120,25);
        nrTelefon.setBounds(270,250,270,25);
        labelAdresa.setBounds(150,280,120,25);
        adresa.setBounds(270,280,270,25);
        labelAdresaEmail.setBounds(150,310,120,25);
        adresaEmail.setBounds(270,310,270,25);
        labelFacultate.setBounds(150,340,120,25);
        facultate.setBounds(270,340,270,25);
        labelSpecializare.setBounds(150,370,120,25);
        specializare.setBounds(270,370,270,25);
        labelCicluUniversitar.setBounds(150,400,120,25);
        cicluUniversitar.setBounds(270,400,270,25);
        labelAn.setBounds(150,430,120,25);
        an.setBounds(270,430,270,25);
        labelNrCredite.setBounds(150,460,120,25);
        nrCredite.setBounds(270,460,270,25);
        inapoi.setBounds(275,520,160,25);
        //labels design
        labelNrMatricol.setForeground(new Color(100,100,100));
        labelNume.setForeground(new Color(100,100,100));
        labelPrenume.setForeground(new Color(100,100,100));
        labelCnp.setForeground(new Color(100,100,100));
        labelDataNasterii.setForeground(new Color(100,100,100));
        labelNrTelefon.setForeground(new Color(100,100,100));
        labelAdresa.setForeground(new Color(100,100,100));
        labelAdresaEmail.setForeground(new Color(100,100,100));
        labelFacultate.setForeground(new Color(100,100,100));
        labelSpecializare.setForeground(new Color(100,100,100));
        labelCicluUniversitar.setForeground(new Color(100,100,100));
        labelAn.setForeground(new Color(100,100,100));
        labelNrCredite.setForeground(new Color(100,100,100));
        //button design
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
        frame.setPreferredSize(new Dimension(700,660));
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
        //go back to user menu
        inapoi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setVisible(false);
                StudentMenuGUI window = new StudentMenuGUI(email);
            }
        });
    }
}
