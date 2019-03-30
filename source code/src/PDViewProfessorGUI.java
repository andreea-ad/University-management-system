import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class PDViewProfessorGUI {
    private HashSet<Professor> prof;
    private JFrame frame;
    private JLabel welcome, labelNume, labelPrenume, labelCnp, labelDataNasterii, labelNrTelefon, labelAdresa, labelAdresaEmail, labelFacultate, labelMateriePredata, labelDataAngajarii, labelSalariu;
    private JTextField nume, prenume, cnp, dataNasterii, nrTelefon, adresa, adresaEmail, facultate, materiePredata, dataAngajarii, salariu;
    public PDViewProfessorGUI(String email){
        frame = new JFrame("Vizualizare date personale");

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

        ManagerGUI mng = new ManagerGUI();
        prof = mng.getInstance().getSetProfesori();
        String welcomeName;
        for(Professor p:prof){
            if(p.getEmailAddress().equals(email)) {
                welcomeName = p.getLastName() + " " + p.getFirstName();
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
                salariu = new JTextField(Integer.toString(p.getSalary()) + " RON");
                welcome = new JLabel("Bun venit, " + welcomeName + "!");
            }
        }
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

        //set bounds for JLabels
        //welcome line
        welcome.setFont(new Font(String.valueOf(welcome.getFont().getName()),Font.PLAIN,20)); //set increased font size
        welcome.setBounds(240,15,300,100);
        //row 1
        labelNume.setBounds(150,130,120,25);
        nume.setBounds(270,130,270,25);
        //row 2
        labelPrenume.setBounds(150,160,120,25);
        prenume.setBounds(270,160,270,25);
        //row 3
        labelCnp.setBounds(150,190,120,25);
        cnp.setBounds(270,190,270,25);
        //row 4
        labelDataNasterii.setBounds(150,220,120,25);
        dataNasterii.setBounds(270,220,270,25);
        //row 5
        labelNrTelefon.setBounds(150,250,120,25);
        nrTelefon.setBounds(270,250,270,25);
        //row 6
        labelAdresa.setBounds(150,280,120,25);
        adresa.setBounds(270,280,270,25);
        //row 7
        labelAdresaEmail.setBounds(150,310,120,25);
        adresaEmail.setBounds(270,310,270,25);
        //row 8
        labelFacultate.setBounds(150,340,120,25);
        facultate.setBounds(270,340,270,25);
        //row 9
        labelMateriePredata.setBounds(150,370,120,25);
        materiePredata.setBounds(270,370,270,25);
        //row 10
        labelDataAngajarii.setBounds(150,400,120,25);
        dataAngajarii.setBounds(270,400,270,25);
        //row 11
        labelSalariu.setBounds(150,430,120,25);
        salariu.setBounds(270,430,270,25);


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

        frame.setLayout(null);
        //set frame size
        frame.setPreferredSize(new Dimension(700,620));
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
