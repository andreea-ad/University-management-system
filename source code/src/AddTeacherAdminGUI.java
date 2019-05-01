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
import java.util.Calendar;
import java.util.HashSet;

public class AddTeacherAdminGUI {
    private JFrame frame;
    private JLabel labelNume, labelPrenume, labelCnp, labelDataNasterii, labelNrTelefon, labelAdresa, labelAdresaEmail, labelFacultate, labelMaterie, labelDataAngajarii, labelSalariu;
    private JTextField nume, prenume, cnp, nrTelefon, adresa, adresaEmail, salariu;
    private JComboBox<Faculty> facultate;
    private JComboBox<Subject> materie;
    private JComboBox<String> lunaNastere, lunaAngajare;
    private JComboBox<Integer> ziNastere, ziAngajare, anNastere, anAngajare;
    private JButton adaugare, anulare, inapoi;
    private HashSet<Faculty> facultati;
    private HashSet<Subject> materii;
    private String[] lunileAnului = {"IANUARIE", "FEBRUARIE", "MARTIE", "APRILIE", "MAI", "IUNIE", "IULIE", "AUGUST", "SEPTEMBRIE", "OCTOMBRIE", "NOIEMBRIE", "DECEMBRIE"};
    private String numeIntrodus, prenumeIntrodus, cnpIntrodus, nrTelefonIntrodus, adresaIntrodusa, emailIntrodus, facultateSelectata, materieSelectata, lunaNastereIntrodusa, lunaAngajareIntrodusa;
    private int ziNastereIntrodusa, ziAngajareIntrodusa, anNastereIntrodus, anAngajareIntrodus;
    private java.sql.Date  dataAngajariiSelectata, dataNasteriiSelectata;
    private int salariuIntrodus;
    public AddTeacherAdminGUI(){
        /*
        ====================
        initialize variables
        ====================
        */
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
        ziNastere = new JComboBox<>();
        ziAngajare = new JComboBox<>();
        lunaNastere = new JComboBox<>();
        lunaAngajare = new JComboBox<>();
        anNastere = new JComboBox<>();
        anAngajare = new JComboBox<>();
        adaugare = new JButton("Adaugă profesor");
        anulare = new JButton("Anulare");
        inapoi = new JButton("Înapoi");
        ManagerGUI mng = new ManagerGUI();
        facultati = mng.getInstance().getSetFacultati();
        materii = mng.getInstance().getSetMaterii();
        for(Faculty f:facultati){
            facultate.addItem(f);
        }
        for(int i=1920;i<=2000;i++){
            anNastere.addItem(i);
        }
        for(int i=1980;i<=Calendar.getInstance().get(Calendar.YEAR);i++){
            anAngajare.addItem(i);
        }
        for(int i=0;i<12;i++){
            lunaNastere.addItem(lunileAnului[i]);
            lunaAngajare.addItem(lunileAnului[i]);
        }
        for(int i=1;i<=31;i++){
            ziNastere.addItem(i);
            ziAngajare.addItem(i);
        }
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
        frame.add(labelMaterie);
        frame.add(materie);
        frame.add(labelDataAngajarii);
        frame.add(anAngajare);
        frame.add(lunaAngajare);
        frame.add(ziAngajare);
        frame.add(labelSalariu);
        frame.add(salariu);
        frame.add(adaugare);
        frame.add(anulare);
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
        anNastere.setBounds(270,140,60,25);
        lunaNastere.setBounds(340,140,120,25);
        ziNastere.setBounds(469,140,50,25);
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
        anAngajare.setBounds(270,320,60,25);
        lunaAngajare.setBounds(340,320,120,25);
        ziAngajare.setBounds(469,320,50,25);
        labelSalariu.setBounds(150,350,120,25);
        salariu.setBounds(270,350,250,25);
        adaugare.setBounds(110,400,145,25);
        anulare.setBounds(265,400,145,25);
        inapoi.setBounds(420,400,145,25);
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
        frame.setPreferredSize(new Dimension(685,550));
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
        //add subjects into combobox when selecting a faculty
        facultate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                materie.removeAllItems();
                for(Subject s:materii){
                    if(s.getFaculty().equals(facultate.getSelectedItem().toString())){
                        materie.addItem(s);
                    }
                }
            }
        });
        //add days to the combobox
        lunaNastere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String luna = String.valueOf(lunaNastere.getSelectedItem());
                int an = (int)anNastere.getSelectedItem();
                ziNastere.removeAllItems();
                if((luna.equals("IANURIE"))||(luna.equals("MARTIE"))||(luna.equals("MAI"))||(luna.equals("IULIE"))||(luna.equals("AUGUST"))||(luna.equals("OCTOMBRIE"))||(luna.equals("DECEMBRIE"))){
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
            }
        });
        //add days to the combobox
        lunaAngajare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String luna = String.valueOf(lunaAngajare.getSelectedItem());
                int an = (int)anAngajare.getSelectedItem();
                ziAngajare.removeAllItems();
                if((luna.equals("IANUARIE"))||(luna.equals("MARTIE"))||(luna.equals("MAI"))||(luna.equals("IULIE"))||(luna.equals("AUGUST"))||(luna.equals("OCTOMBRIE"))||(luna.equals("DECEMBRIE"))){
                    for(int i=1;i<=31;i++){
                        ziAngajare.addItem(i);
                    }
                }else if((luna.equals("APRILIE"))||(luna.equals("IUNIE"))||(luna.equals("SEPTEMBRIE"))||(luna.equals("NOIEMBRIE"))){
                    for(int i=1;i<=30;i++){
                        ziAngajare.addItem(i);
                    }
                }else{
                    if(isLeapYear(an)){
                        for(int i=1;i<=29;i++){
                            ziAngajare.addItem(i);
                        }
                    }else{
                        for(int i=1;i<=28;i++){
                            ziAngajare.addItem(i);
                        }
                    }
                }
            }
        });
        //add days to the combobox
        anNastere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lunaNastere.setSelectedItem("IANUARIE");
                ziNastere.removeAllItems();
                for(int i=1;i<=31;i++){
                    ziNastere.addItem(i);
                }
            }
        });
        //add days to the combobox
        anAngajare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lunaAngajare.setSelectedItem("IANUARIE");
                ziAngajare.removeAllItems();
                for(int i=1;i<=31;i++){
                    ziAngajare.addItem(i);
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
                anNastere.setSelectedItem(1920);
                lunaNastere.setSelectedItem("IANUARIE");
                ziNastere.removeAllItems();
                for(int i=1;i<=31;i++){
                    ziNastere.addItem(i);
                }
                nrTelefon.setText("");
                adresa.setText("");
                adresaEmail.setText("");
                facultate.setSelectedItem("Facultatea de Chimie și Biologie");
                materie.setSelectedItem("Biologie moleculară");
                anAngajare.setSelectedItem(1980);
                lunaAngajare.setSelectedItem("IANUARIE");
                ziAngajare.removeAllItems();
                for(int i=1;i<=31;i++){
                    ziAngajare.addItem(i);
                }
                salariu.setText("");
            }
        });
        //add teacher into DB
        adaugare.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                prenumeIntrodus = prenume.getText();
                numeIntrodus = nume.getText();
                cnpIntrodus = cnp.getText();
                anNastereIntrodus = (int) anNastere.getSelectedItem();
                lunaNastereIntrodusa = String.valueOf(lunaNastere.getSelectedItem());
                ziNastereIntrodusa = (int) ziNastere.getSelectedItem();
                dataNasteriiSelectata = Date.valueOf(LocalDate.of(anNastereIntrodus, getMonthNumber(lunaNastereIntrodusa), ziNastereIntrodusa));
                nrTelefonIntrodus = nrTelefon.getText();
                adresaIntrodusa = adresa.getText();
                emailIntrodus = adresaEmail.getText();
                facultateSelectata = String.valueOf(facultate.getSelectedItem());
                materieSelectata = String.valueOf(materie.getSelectedItem());
                anAngajareIntrodus = (int) anAngajare.getSelectedItem();
                lunaAngajareIntrodusa = String.valueOf(lunaAngajare.getSelectedItem());
                ziAngajareIntrodusa = (int) ziAngajare.getSelectedItem();
                dataAngajariiSelectata = Date.valueOf(LocalDate.of(anAngajareIntrodus, getMonthNumber(lunaAngajareIntrodusa), ziAngajareIntrodusa));
                salariuIntrodus = Integer.valueOf(salariu.getText());
                if (mng.getInstance().addTeacherInDB(prenumeIntrodus, numeIntrodus, cnpIntrodus, dataNasteriiSelectata, nrTelefonIntrodus, adresaIntrodusa, emailIntrodus, facultateSelectata, materieSelectata, dataAngajariiSelectata, salariuIntrodus) == 1) {
                    JOptionPane.showMessageDialog(null, "Profesorul a fost adăugat în baza de date!");
                }
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
        AddTeacherAdminGUI window = new AddTeacherAdminGUI();
    }
}
