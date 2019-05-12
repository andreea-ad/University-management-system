import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.*;
public class PDViewProfessorGUI {
    private HashSet<Professor> prof;
    private JFrame frame;
    private JLabel welcome, labelNume, labelPrenume, labelCnp, labelDataNasterii, labelNrTelefon, labelAdresa, labelAdresaEmail, labelFacultate, labelMateriePredata, labelDataAngajarii, labelSalariu;
    private JTextField nume, prenume, cnp, dataNasterii, nrTelefon, adresa, adresaEmail, facultate, materiePredata, dataAngajarii, salariu;
    private JButton inapoi;
    public PDViewProfessorGUI(String email){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Vizualizare date personale");
        welcome = new JLabel("Bun venit!");
        labelNume = new JLabel("Nume: ");
        labelPrenume = new JLabel("Prenume: ");
        labelCnp = new JLabel("CNP: ");
        labelDataNasterii = new JLabel("Data nașterii: ");
        labelNrTelefon = new JLabel("Număr de telefon: ");
        labelAdresa = new JLabel("Adresă: ");
        labelAdresaEmail = new JLabel("Adresă de email: ");
        labelFacultate = new JLabel("Facultate: ");
        labelMateriePredata = new JLabel("Materie predată: ");
        labelDataAngajarii = new JLabel("Data angajării: ");
        labelSalariu = new JLabel("Salariu: ");
        inapoi = new JButton("Înapoi");
        ManagerGUI mng = new ManagerGUI();
        prof = mng.getSetProfesori();
        String welcomeName = "";
        for(Professor p:prof){
            if(p.getEmailAddress().equals(email)) {
                welcomeName += p.getLastName() + " " + p.getFirstName();
                frame = new JFrame("Vizualizare date personale: " + welcomeName);
                nume = new JTextField(p.getLastName());
                prenume = new JTextField(p.getFirstName());
                cnp = new JTextField(p.getCnp());
                dataNasterii =  new JTextField(String.valueOf(p.getDob()));
                nrTelefon = new JTextField(p.getPhoneNumber());
                adresa = new JTextField(p.getAddress());
                adresaEmail = new JTextField(p.getEmailAddress());
                facultate = new JTextField(p.getFaculty());
                materiePredata = new JTextField(p.getTeachingSubject());
                dataAngajarii = new JTextField(String.valueOf(p.getHireDate()));
                salariu = new JTextField(p.getSalary() + " RON");
                break;
            }
        }
        //add elements to the frame
        frame.add(welcome);
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
        frame.add(labelMateriePredata);
        frame.add(materiePredata);
        frame.add(labelDataAngajarii);
        frame.add(dataAngajarii);
        frame.add(labelSalariu);
        frame.add(salariu);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        //set increased font size
        welcome.setFont(new Font(String.valueOf(welcome.getFont().getName()),Font.PLAIN,20));
        //set fields not editable so the user cannot modify any data
        nume.setEditable(false);
        prenume.setEditable(false);
        cnp.setEditable(false);
        dataNasterii.setEditable(false);
        nrTelefon.setEditable(false);
        adresa.setEditable(false);
        adresaEmail.setEditable(false);
        facultate.setEditable(false);
        materiePredata.setEditable(false);
        dataAngajarii.setEditable(false);
        salariu.setEditable(false);
        //set bounds for elements
        welcome.setBounds(290,13,300,100);
        labelNume.setBounds(150,110,120,25);
        nume.setBounds(270,110,270,25);
        labelPrenume.setBounds(150,140,120,25);
        prenume.setBounds(270,140,270,25);
        labelCnp.setBounds(150,170,120,25);
        cnp.setBounds(270,170,270,25);
        labelDataNasterii.setBounds(150,200,120,25);
        dataNasterii.setBounds(270,200,270,25);
        labelNrTelefon.setBounds(150,230,120,25);
        nrTelefon.setBounds(270,230,270,25);
        labelAdresa.setBounds(150,260,120,25);
        adresa.setBounds(270,260,270,25);
        labelAdresaEmail.setBounds(150,290,120,25);
        adresaEmail.setBounds(270,290,270,25);
        labelFacultate.setBounds(150,320,120,25);
        facultate.setBounds(270,320,270,25);
        labelMateriePredata.setBounds(150,350,120,25);
        materiePredata.setBounds(270,350,270,25);
        labelDataAngajarii.setBounds(150,380,120,25);
        dataAngajarii.setBounds(270,380,270,25);
        labelSalariu.setBounds(150,410,120,25);
        salariu.setBounds(270,410,270,25);
        inapoi.setBounds(270,475,145,25);
        //button design
        inapoi.setBorderPainted(false);
        inapoi.setBackground(new Color(233,233,233));
        inapoi.setForeground(new Color(100,100,100));
        //labels design
        labelNume.setForeground(new Color(100,100,100));
        labelPrenume.setForeground(new Color(100,100,100));
        labelCnp.setForeground(new Color(100,100,100));
        labelDataNasterii.setForeground(new Color(100,100,100));
        labelNrTelefon.setForeground(new Color(100,100,100));
        labelAdresa.setForeground(new Color(100,100,100));
        labelAdresaEmail.setForeground(new Color(100,100,100));
        labelFacultate.setForeground(new Color(100,100,100));
        labelMateriePredata.setForeground(new Color(100,100,100));
        labelDataAngajarii.setForeground(new Color(100,100,100));
        labelSalariu.setForeground(new Color(100,100,100));
        //set frame icon
        try {
            frame.setIconImage(ImageIO.read(getClass().getResource("resources/1.png")));
        }catch(IOException ie){
            ie.printStackTrace();
        }
        //set frame size
        frame.setPreferredSize(new Dimension(700,600));
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
}
