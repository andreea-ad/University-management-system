import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class EditTeacherAdminGUI {
    private JFrame frame;
    private JLabel labelPrenume, labelNume, labelCnp, labelDataNasterii, labelNrTelefon, labelAdresa, labelAdresaEmail, labelFacultate, labelMaterie, labelDataAngajarii, labelSalariu;
    private JTextField prenume, nume, cnp, nrTelefon, adresa, adresaEmail, facultate, salariu;
    private JComboBox<Integer> anNastere, ziNastere, anAngajare, ziAngajare;
    private JComboBox<String> lunaNastere, lunaAngajare;
    private JComboBox<String> subjects, professors;
    private JComboBox<Faculty> faculties;
    private HashSet<Subject> materii;
    private HashSet<Faculty> facultati;
    private HashSet<Professor> profesori;
    public EditTeacherAdminGUI(){
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

        anNastere = new JComboBox<>();
        lunaNastere = new JComboBox<>();
        ziNastere = new JComboBox<>();
        anAngajare = new JComboBox<>();
        lunaAngajare = new JComboBox<>();
        ziAngajare = new JComboBox<>();
        subjects = new JComboBox<>();
        professors = new JComboBox<>();
        faculties = new JComboBox<>();

        ManagerGUI mng = new ManagerGUI();
        facultati = mng.getInstance().getSetFacultati();
        profesori = mng.getInstance().getSetProfesori();
        materii = mng.getInstance().getSetMaterii();


        for(Faculty f:facultati){
            faculties.addItem(f);
        }

        /*for(Subject s:materii){
            if(s.getFaculty().equals("Facultatea de Chimie si Biologie")){
                subjects.addItem(s.getTitle());
            }
        }*/
        for(Professor p:profesori){
            if(p.getFaculty().equals("Facultatea de Chimie si Biologie")){
                professors.addItem(p.getLastName()+" "+p.getFirstName());
            }
        }

        professors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Professor p:profesori){
                    if((p.getLastName()+" "+p.getFirstName()).equals(professors.getSelectedItem())){
                            nume = new JTextField(p.getLastName());
                            prenume = new JTextField(p.getFirstName());
                            cnp = new JTextField(p.getCnp());
                            LocalDate date = p.getDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                            int year = date.getYear();
                            int month = date.getMonthValue();
                            int day = date.getDayOfMonth();
                            anNastere.setSelectedItem(year);
                            lunaNastere.setSelectedItem(getMonthByNumber(month));
                            ziNastere.setSelectedItem(day);
                            nrTelefon = new JTextField(p.getPhoneNumber());
                            adresa = new JTextField(p.getAddress());
                            adresaEmail = new JTextField(p.getEmailAddress());
                            facultate = new JTextField(p.getFaculty());

                            salariu = new JTextField(p.getSalary());
                    }
                }
            }
        });



    }
    private String getMonthByNumber(int month){
        switch(month){
            case 1: return "IANUARIE";
            case 2: return "FEBRUARIE";
            case 3: return "MARTIE";
            case 4: return "APRILIE";
            case 5: return "MAI";
            case 6: return "IUNIE";
            case 7: return "IULIE";
            case 8: return "AUGUST";
            case 9: return "SEPTEMBRIE";
            case 10: return "OCTOMBRIE";
            case 11:  return "NOIEMBRIE";
            case 12: return "DECEMBRIE";
        }
        return "";
    }
}
