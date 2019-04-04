import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

public class AddTeachersAdminGUI {
    private JFrame frame;
    private JLabel labelNume, labelPrenume, labelCnp, labelDataNasterii, labelNrTelefon, labelAdresa, labelAdresaEmail, labelFacultate, labelMaterie, labelDataAngajarii, labelSalariu;
    private JTextField nume, prenume, cnp, nrTelefon, adresa, adresaEmail, salariu;
    private JComboBox<String> facultate, materie;
    private JXDatePicker dataNasterii, dataAngajarii;
    private Calendar calendarData1, calendarData2;
    private JButton adaugare, anulare;
    private HashSet<Faculty> facultati;
    private HashSet<Subject> materii;
    public AddTeachersAdminGUI(){
        frame = new JFrame("Adăugare profesor");

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

        nume = new JTextField();
        prenume = new JTextField();
        cnp = new JTextField();
        nrTelefon = new JTextField();
        adresa = new JTextField();
        adresaEmail = new JTextField();
        salariu = new JTextField();

        facultate = new JComboBox<>();
        materie = new JComboBox<>();

        dataNasterii = new JXDatePicker();
        dataAngajarii = new JXDatePicker();

        ManagerGUI mng = new ManagerGUI();
        facultati = mng.getInstance().getSetFacultati();
        materii = mng.getInstance().getSetMaterii();

        for(Faculty f:facultati){
            facultate.addItem(f.getTitle());
        }

        String facultateSelectata = String.valueOf(facultate.getSelectedItem());

        for(Subject s:materii){
            if(s.getFaculty().equals(facultateSelectata)){
                materie.addItem(s.getTitle());
            }
        }



        calendarData1 = dataNasterii.getMonthView().getCalendar();
        calendarData1.setTime(new Date());
        dataNasterii.getMonthView().setLowerBound(calendarData1.getTime());

        calendarData2 = dataAngajarii.getMonthView().getCalendar();
        calendarData2.setTime(new Date());
        dataAngajarii.getMonthView().setLowerBound(calendarData2.getTime());

        adaugare = new JButton("Adăugare profesor");
        anulare = new JButton("Anulare");

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
        adaugare.setBounds(150,410,180,25);
        anulare.setBounds(340,410,180,25);

        anulare.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                nume.setText("");
                prenume.setText("");
                cnp.setText("");
                //dataNasterii.setDate();
                nrTelefon.setText("");
                adresa.setText("");
                adresaEmail.setText("");
                facultate.setSelectedItem("Selectați o facultate");
                materie.setSelectedItem("Selectați o materie");
                //dataAngajarii.setDate();
                salariu.setText("");
            }
        });

        adaugare.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

            }
        });








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
        frame.add(adaugare);
        frame.add(anulare);

        frame.setLayout(null);
        //set frame size
        frame.setPreferredSize(new Dimension(680,525));
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
    public static void main(String[] args){
        AddTeachersAdminGUI window = new AddTeachersAdminGUI();
    }
}
