import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class AddStudentAdminGUI {
    private JFrame frame;
    private JLabel labelNume, labelPrenume, labelCnp, labelDataNasterii, labelNrTelefon, labelAdresa, labelAdresaEmail, labelFacultate, labelSpecializare, labelCicluUniversitar, labelAn, labelNrCredite;
    private JTextField nume, prenume, cnp, nrTelefon, adresa, adresaEmail, cicluUniversitar, nrCredite;
    private JComboBox<Faculty> facultate;
    private JComboBox<Department>specializare;
    private JComboBox<String> lunaNastere;
    private JComboBox<Integer> ziNastere, anNastere;
    private SpinnerModel spinnerModelAn;
    private JSpinner anUniversitar;
    private JButton adaugare, anulare, inapoi;
    private HashSet<Faculty> facultati;
    private HashSet<Department> specializari;
    private String[] lunileAnului = {"IANUARIE", "FEBRUARIE", "MARTIE", "APRILIE", "MAI", "IUNIE", "IULIE", "AUGUST", "SEPTEMBRIE", "OCTOMBRIE", "NOIEMBRIE", "DECEMBRIE"};
    private String numeIntrodus, prenumeIntrodus, cnpIntrodus, nrTelefonIntrodus, adresaIntrodusa, emailIntrodus, facultateSelectata, specializareSelectata, cicluUniversitarSelectat, lunaNastereIntrodusa;
    private int ziNastereIntrodusa, anNastereIntrodus, anUniversitarIntrodus, nrCrediteIntroduse;
    private java.sql.Date dataNasteriiSelectata;
    public AddStudentAdminGUI(){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Adăugare student");
        labelNume = new JLabel("Nume student: ");
        labelPrenume = new JLabel("Prenume student: ");
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
        nume = new JTextField();
        prenume = new JTextField();
        cnp = new JTextField();
        nrTelefon = new JTextField();
        adresa = new JTextField();
        adresaEmail = new JTextField();
        cicluUniversitar = new JTextField();
        nrCredite = new JTextField();
        facultate = new JComboBox<>();
        specializare = new JComboBox<>();
        anNastere = new JComboBox<>();
        lunaNastere = new JComboBox<>();
        ziNastere = new JComboBox<>();
        spinnerModelAn = new SpinnerNumberModel(1,1,3,1);
        anUniversitar = new JSpinner(spinnerModelAn);
        adaugare = new JButton("Adaugă student");
        anulare = new JButton("Anulează");
        inapoi = new JButton("Înapoi");
        ManagerGUI mng = new ManagerGUI();
        facultati = mng.getSetFacultati();
        specializari = mng.getSetSpecializari();
        for(Faculty f:facultati){
            facultate.addItem(f);
        }
        //add departments into combobox
        for(Department d:specializari){
            if(d.getFaculty().equals(facultate.getSelectedItem().toString())){
                specializare.addItem(d);
            }
        }
        for(Department d:specializari){
            if(d.getTitle().equals(specializare.getSelectedItem().toString())){
                cicluUniversitar.setText(d.getDegree().toString());
                break;
            }
        }
        for(int i=1920;i<=2000;i++){
            anNastere.addItem(i);
        }
        for(String luna:lunileAnului){
            lunaNastere.addItem(luna);
        }
        for(int i=1;i<=31;i++){
            ziNastere.addItem(i);
        }
        //add elements to the frame
        frame.add(labelNume);
        frame.add(nume);
        frame.add(labelPrenume);
        frame.add(prenume);
        frame.add(labelCnp);
        frame.add(cnp);
        frame.add(labelDataNasterii);
        frame.add(anNastere);
        frame.add(lunaNastere);
        frame.add(ziNastere);
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
        frame.add(anUniversitar);
        frame.add(labelNrCredite);
        frame.add(nrCredite);
        frame.add(adaugare);
        frame.add(anulare);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        //set textfield not editable
        cicluUniversitar.setEditable(false);
        //set bounds for elements
        labelNume.setBounds(190,70,120,25);
        nume.setBounds(300,70,250,25);
        labelPrenume.setBounds(190,100,120,25);
        prenume.setBounds(300,100,250,25);
        labelCnp.setBounds(190,130,120,25);
        cnp.setBounds(300,130,250,25);
        labelDataNasterii.setBounds(190,160,120,25);
        anNastere.setBounds(300,160,60,25);
        lunaNastere.setBounds(370,160,120,25);
        ziNastere.setBounds(500,160,50,25);
        labelNrTelefon.setBounds(190,190,120,25);
        nrTelefon.setBounds(300,190,250,25);
        labelAdresa.setBounds(190,220,120,25);
        adresa.setBounds(300,220,250,25);
        labelAdresaEmail.setBounds(190,250,120,25);
        adresaEmail.setBounds(300,250,250,25);
        labelFacultate.setBounds(190,280,120,25);
        facultate.setBounds(300,280,250,25);
        labelSpecializare.setBounds(190,310,120,25);
        specializare.setBounds(300,310,250,25);
        labelCicluUniversitar.setBounds(190,340,120,25);
        cicluUniversitar.setBounds(300,340,250,25);
        labelAn.setBounds(190,370,120,25);
        anUniversitar.setBounds(300,370,250,25);
        labelNrCredite.setBounds(190,400,120,25);
        nrCredite.setBounds(300,400,250,25);
        adaugare.setBounds(140,450,150,25);
        anulare.setBounds(295,450,150,25);
        inapoi.setBounds(450,450,150,25);
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
        facultate.setBackground(new Color(233,233,233));
        facultate.setForeground(new Color(100,100,100));
        specializare.setBackground(new Color(233,233,233));
        specializare.setForeground(new Color(100,100,100));
        cicluUniversitar.setBackground(new Color(233,233,233));
        cicluUniversitar.setForeground(new Color(100,100,100));
        anNastere.setBackground(new Color(233,233,233));
        anNastere.setForeground(new Color(100,100,100));
        lunaNastere.setBackground(new Color(233,233,233));
        lunaNastere.setForeground(new Color(100,100,100));
        ziNastere.setBackground(new Color(233,233,233));
        ziNastere.setForeground(new Color(100,100,100));
        //labels design
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
        //set frame icon
        try {
            frame.setIconImage(ImageIO.read(getClass().getResource("resources/1.png")));
        }catch(IOException ie){
            ie.printStackTrace();
        }
        //set frame size
        frame.setPreferredSize(new Dimension(755,600));
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
        //add departments into combobox when selecting a faculty
        facultate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                specializare.removeAllItems();
                for(Department d:specializari){
                    if(d.getFaculty().equals(facultate.getSelectedItem().toString())){
                        specializare.addItem(d);
                    }
                }
            }
        });
        //set degree when selecting a department
        specializare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(specializare.getItemCount() > 0) {
                    for (Department d : specializari) {
                        if (d.getTitle().equals(specializare.getSelectedItem().toString())) {
                            cicluUniversitar.setText(d.getDegree().toString());
                            break;
                        }
                    }
                }
            }
        });
        //add days into the combobox
        lunaNastere.addActionListener(e -> {
            String luna = String.valueOf(lunaNastere.getSelectedItem());
            int an = (int)anNastere.getSelectedItem();
            ziNastere.removeAllItems();
            if((luna.equals("IANUARIE"))||(luna.equals("MARTIE"))||(luna.equals("MAI"))||(luna.equals("IULIE"))||(luna.equals("AUGUST"))||(luna.equals("OCTOMBRIE"))||(luna.equals("DECEMBRIE"))){
                for(int i=1;i<=31;i++){
                    ziNastere.addItem(i);
                }
            }else if((luna.equals("APRILIE"))||(luna.equals("IUNIE"))||(luna.equals("SEPTEMBRIE"))||(luna.equals("NOIEMBRIE"))){
                for(int i=1;i<=30;i++){
                    ziNastere.addItem(i);
                }
            }else{
                if(isLeapYear(an)){
                    for(int i=1;i<=29;i++){
                        ziNastere.addItem(i);
                    }
                }else{
                    for(int i=1;i<=28;i++){
                        ziNastere.addItem(i);
                    }
                }
            }
        });
        //add days into combobox
        anNastere.addActionListener(e -> {
            lunaNastere.setSelectedItem("IANUARIE");
            ziNastere.removeAllItems();
            for(int i=1;i<=31;i++){
                ziNastere.addItem(i);
            }
        });
        //add student into DB
        adaugare.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                numeIntrodus = nume.getText();
                prenumeIntrodus = prenume.getText();
                cnpIntrodus = cnp.getText();
                anNastereIntrodus = (int)anNastere.getSelectedItem();
                lunaNastereIntrodusa = String.valueOf(lunaNastere.getSelectedItem());
                ziNastereIntrodusa = (int)ziNastere.getSelectedItem();
                dataNasteriiSelectata = Date.valueOf(LocalDate.of(anNastereIntrodus,getMonthNumber(lunaNastereIntrodusa),ziNastereIntrodusa));
                nrTelefonIntrodus = nrTelefon.getText();
                adresaIntrodusa = adresa.getText();
                emailIntrodus = adresaEmail.getText();
                facultateSelectata = String.valueOf(facultate.getSelectedItem());
                specializareSelectata = String.valueOf(specializare.getSelectedItem());
                cicluUniversitarSelectat = String.valueOf(cicluUniversitar.getText());
                anUniversitarIntrodus = (int)anUniversitar.getValue();
                nrCrediteIntroduse = Integer.valueOf(nrCredite.getText());
                if(mng.addStudentInDB(prenumeIntrodus,numeIntrodus,cnpIntrodus,dataNasteriiSelectata,nrTelefonIntrodus,adresaIntrodusa,emailIntrodus,facultateSelectata,specializareSelectata,cicluUniversitarSelectat,anUniversitarIntrodus,nrCrediteIntroduse) == 1){
                    JOptionPane.showMessageDialog(null, "Studentul a fost adăugat în baza de date!");
                }
            }
        });
        //empty the input fields
        anulare.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                nume.setText("");
                prenume.setText("");
                cnp.setText("");
                anNastere.setSelectedIndex(0);
                lunaNastere.setSelectedIndex(0);
                ziNastere.removeAllItems();
                for(int i=1;i<=31;i++){
                    ziNastere.addItem(i);
                }
                nrTelefon.setText("");
                adresa.setText("");
                adresaEmail.setText("");
                facultate.setSelectedIndex(0);
                specializare.setSelectedIndex(0);
                for(Department d:specializari){
                    if(d.getTitle().equals(specializare.getSelectedItem().toString())){
                        cicluUniversitar.setText(d.getDegree().toString());
                        break;
                    }
                }
                anUniversitar.setValue(1);
                nrCredite.setText("");
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
    //check if the input year(birth year) is a leap year
    private boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return true;
        }
    }
    //return the number of the input month
    private int getMonthNumber(String month){
        switch(month){
            case "IANUARIE": return 1;
            case "FEBRUARIE": return 2;
            case "MARTIE": return 3;
            case "APRILIE": return 4;
            case "MAI": return 5;
            case "IUNIE": return 6;
            case "IULIE": return 7;
            case "AUGUST": return 8;
            case "SEPTEMBRIE": return 9;
            case "OCTOMBRIE": return 10;
            case "NOIEMBRIE": return 11;
            case "DECEMBRIE": return 12;
        }
        return -1;
    }
    public static void main(String[] args){
        AddStudentAdminGUI window = new AddStudentAdminGUI();
    }
}
