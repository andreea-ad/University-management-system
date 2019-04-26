import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.HashSet;
import java.text.SimpleDateFormat;

public class AddTeacherAdminGUI {
    private JFrame frame;
    private JLabel labelNume, labelPrenume, labelCnp, labelDataNasterii, labelNrTelefon, labelAdresa, labelAdresaEmail, labelFacultate, labelMaterie, labelDataAngajarii, labelSalariu;
    private JTextField nume, prenume, cnp, nrTelefon, adresa, adresaEmail, salariu;
    private JComboBox<String> facultate, materie, lunaNastere, lunaAngajare;
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
        frame = new JFrame("Adăugare profesor");
        frame.getContentPane().setBackground(Color.WHITE);

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

        ManagerGUI mng = new ManagerGUI();
        facultati = mng.getInstance().getSetFacultati();
        materii = mng.getInstance().getSetMaterii();

        for(Faculty f:facultati){
            facultate.addItem(f.getTitle());
        }

        facultateSelectata = String.valueOf(facultate.getSelectedItem());

        for(Subject s:materii){
            if(s.getFaculty().equals(facultateSelectata)){
                materie.addItem(s.getTitle());
            }
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

        adaugare = new JButton("Adăugare profesor");
        anulare = new JButton("Anulare");
        inapoi = new JButton("Înapoi");

        labelNume.setBounds(150,50,120,25);
        nume.setBounds(270,50,250,25);
        labelPrenume.setBounds(150,80,120,25);
        prenume.setBounds(270,80,250,25);
        labelCnp.setBounds(150,110,120,25);
        cnp.setBounds(270,110,250,25);
        labelDataNasterii.setBounds(150,140,120,25);
        anNastere.setBounds(270,140,55,25);
        lunaNastere.setBounds(330,140,110,25);
        ziNastere.setBounds(445,140,40,25);
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
        anAngajare.setBounds(270,320,55,25);
        lunaAngajare.setBounds(330,320,110,25);
        ziAngajare.setBounds(445,320,40,25);
        labelSalariu.setBounds(150,350,120,25);
        salariu.setBounds(270,350,250,25);
        adaugare.setBounds(110,410,145,25);
        anulare.setBounds(265,410,145,25);
        inapoi.setBounds(420,410,145,25);

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

        adaugare.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                prenumeIntrodus = prenume.getText();
                numeIntrodus = nume.getText();
                cnpIntrodus = cnp.getText();

                anNastereIntrodus = (int)anNastere.getSelectedItem();
                lunaNastereIntrodusa = String.valueOf(lunaNastere.getSelectedItem());
                ziNastereIntrodusa = (int)ziNastere.getSelectedItem();
                dataNasteriiSelectata = Date.valueOf(LocalDate.of(anNastereIntrodus,getMonthNumber(lunaNastereIntrodusa),ziNastereIntrodusa));

                nrTelefonIntrodus = nrTelefon.getText();
                adresaIntrodusa = adresa.getText();
                emailIntrodus = adresaEmail.getText();
                facultateSelectata = String.valueOf(facultate.getSelectedItem());
                materieSelectata = String.valueOf(materie.getSelectedItem());

                anAngajareIntrodus = (int)anAngajare.getSelectedItem();
                lunaAngajareIntrodusa = String.valueOf(lunaAngajare.getSelectedItem());
                ziAngajareIntrodusa = (int)ziAngajare.getSelectedItem();
                dataAngajariiSelectata = Date.valueOf(LocalDate.of(anAngajareIntrodus,getMonthNumber(lunaAngajareIntrodusa),ziAngajareIntrodusa));

                salariuIntrodus = Integer.valueOf(salariu.getText());
                mng.getInstance().addTeacherInDB(prenumeIntrodus,numeIntrodus,cnpIntrodus, dataNasteriiSelectata, nrTelefonIntrodus,adresaIntrodusa,emailIntrodus,facultateSelectata,materieSelectata,dataAngajariiSelectata,salariuIntrodus);

            }
        });
        inapoi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setVisible(false);
                AdminMenuGUI window = new AdminMenuGUI();
            }
        });

        facultate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                facultateSelectata = String.valueOf(facultate.getSelectedItem());
                materie.removeAllItems();
                for(Subject s:materii){
                    if(s.getFaculty().equals(facultateSelectata)){
                        materie.addItem(s.getTitle());
                    }
                }
            }
        });
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
}
