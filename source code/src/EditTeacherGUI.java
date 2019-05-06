import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Date;

public class EditTeacherGUI {
    private JFrame frame;
    private JLabel labelPrenume, labelNume, labelCnp, labelDataNasterii, labelNrTelefon, labelAdresa, labelAdresaEmail, labelFacultate, labelMaterie, labelDataAngajarii, labelSalariu;
    private JTextField prenume, nume, cnp, dataNasterii, nrTelefon, adresa, adresaEmail, facultate, materie, dataAngajarii, salariu;
    private JButton editeaza, inapoi;
    public EditTeacherGUI(String lastName, String firstName, String CNP, Date dob, String phoneNo, String address, String emailAddress, String faculty, String subject, Date hireDate, int salary){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Modificare date profesor");
        labelNume = new JLabel("Nume profesor: ");
        labelPrenume = new JLabel("Prenume profesor: ");
        labelCnp = new JLabel("CNP: ");
        labelDataNasterii = new JLabel("Data nașterii: ");
        labelNrTelefon = new JLabel("Număr de telefon: ");
        labelAdresa = new JLabel("Adresă: ");
        labelAdresaEmail = new JLabel("Adresă de email: ");
        labelFacultate = new JLabel("Facultate: ");
        labelMaterie = new JLabel("Materie predată: ");
        labelDataAngajarii = new JLabel("Data angajării: ");
        labelSalariu = new JLabel("Salariu(RON): ");
        editeaza = new JButton("Editează");
        inapoi = new JButton("Înapoi");
        nume = new JTextField(lastName);
        prenume = new JTextField(firstName);
        cnp = new JTextField(CNP);
        dataNasterii = new JTextField(dob.toString());
        nrTelefon = new JTextField(phoneNo);
        adresa = new JTextField(address);
        adresaEmail = new JTextField(emailAddress);
        facultate = new JTextField(faculty);
        materie = new JTextField(subject);
        dataAngajarii = new JTextField(hireDate.toString());
        salariu = new JTextField(String.valueOf(salary));
        //add elements to the frame
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
        frame.add(labelMaterie);
        frame.add(materie);
        frame.add(labelDataAngajarii);
        frame.add(dataAngajarii);
        frame.add(labelSalariu);
        frame.add(salariu);
        frame.add(editeaza);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        //set bounds for elements
        labelNume.setBounds(150,50,120,25);
        nume.setBounds(270,50,250,25);
        labelPrenume.setBounds(150,80,120,25);
        prenume.setBounds(270,80,250,25);
        labelCnp.setBounds(150,110,120,25);
        cnp.setBounds(270,110,250,25);
        labelDataNasterii.setBounds(150,140,120,25);
        dataNasterii.setBounds(270,140,250,25);
        labelNrTelefon.setBounds(150,170,120,25);
        nrTelefon.setBounds(270,170,250,25);
        labelAdresa.setBounds(150,200,120,25);
        adresa.setBounds(270,200,250,25);
        labelAdresaEmail.setBounds(150,230,120,25);
        adresaEmail.setBounds(270,230,250,25);
        labelFacultate.setBounds(150,260,120,25);
        facultate.setBounds(270,260,250,25);
        labelMaterie.setBounds(150,290,120,25);
        materie.setBounds(270,290,250,25);
        labelDataAngajarii.setBounds(150,320,120,25);
        dataAngajarii.setBounds(270,320,250,25);
        labelSalariu.setBounds(150,350,120,25);
        salariu.setBounds(270,350,250,25);
        editeaza.setBounds(180,390,150,25);
        inapoi.setBounds(340,390,150,25);
        //buttons design
        editeaza.setBorderPainted(false);
        editeaza.setBackground(new Color(233,233,233));
        editeaza.setForeground(new Color(100,100,100));
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
        labelMaterie.setForeground(new Color(100,100,100));
        labelDataAngajarii.setForeground(new Color(100,100,100));
        labelSalariu.setForeground(new Color(100,100,100));
        //set frame icon
        try {
            frame.setIconImage(ImageIO.read(getClass().getResource("resources/1.png")));
        }catch(IOException ie){
            ie.printStackTrace();
        }
        //set frame size
        frame.setPreferredSize(new Dimension(700, 500));
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
        //update the database with the new data
        editeaza.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(ManagerGUI.updateTeacherFromDB(CNP,prenume.getText(),nume.getText(),cnp.getText(), java.sql.Date.valueOf(dataNasterii.getText()),nrTelefon.getText(),adresa.getText(),adresaEmail.getText(),facultate.getText(),materie.getText(),java.sql.Date.valueOf(dataAngajarii.getText()), Integer.valueOf(salariu.getText())) == 1) {
                    JOptionPane.showMessageDialog(null, "Datele profesorului au fost modificate în baza de date!");
                }
            }
        });
        //go back to select teacher to edit window
        inapoi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setVisible(false);
                EditTeacherAdminGUI window = new EditTeacherAdminGUI();
            }
        });
    }
}
