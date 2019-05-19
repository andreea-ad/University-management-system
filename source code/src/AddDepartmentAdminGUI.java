import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashSet;

public class AddDepartmentAdminGUI {
    private JFrame frame;
    private JLabel denumire, facultate, cicluUniversitar;
    private JTextField titlu;
    private JComboBox<Faculty> faculties;
    private JComboBox<String> degrees;
    private HashSet<Faculty> facultati;
    private JButton adaugare, anulare, inapoi;
    public AddDepartmentAdminGUI(){
        /*
        ====================
        initialize variables
        ====================
        */
        frame = new JFrame("Adăugare specializare");
        denumire = new JLabel("Denumire specializare: ");
        facultate = new JLabel("Facultate: ");
        cicluUniversitar = new JLabel("Ciclu universitar: ");
        titlu = new JTextField();
        faculties = new JComboBox<>();
        degrees = new JComboBox<>();
        adaugare = new JButton("Adaugă specializare");
        anulare = new JButton("Anulează");
        inapoi = new JButton("Înapoi");
        ManagerGUI mng = new ManagerGUI();
        facultati = mng.getSetFacultati();
        //add all faculties into combobox
        for(Faculty f:facultati){
            faculties.addItem(f);
        }
        //add degrees into combobox
        degrees.addItem("LICENTA");
        degrees.addItem("MASTER");
        degrees.addItem("DOCTORAT");
        //add elements to the frame
        frame.add(denumire);
        frame.add(titlu);
        frame.add(facultate);
        frame.add(faculties);
        frame.add(cicluUniversitar);
        frame.add(degrees);
        frame.add(adaugare);
        frame.add(anulare);
        frame.add(inapoi);
        //set white background
        frame.getContentPane().setBackground(Color.WHITE);
        //set bounds for elements
        denumire.setBounds(100,90,150,25);
        titlu.setBounds(290,90,300,25);
        facultate.setBounds(100,120,150,25);
        faculties.setBounds(290,120,300,25);
        cicluUniversitar.setBounds(100,150,150,25);
        degrees.setBounds(290,150,300,25);
        adaugare.setBounds(110,200,150,25);
        anulare.setBounds(270,200,150,25);
        inapoi.setBounds(430,200,150,25);
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
        faculties.setBackground(new Color(233,233,233));
        faculties.setForeground(new Color(100,100,100));
        degrees.setBackground(new Color(233,233,233));
        degrees.setForeground(new Color(100,100,100));
        //labels design
        denumire.setForeground(new Color(100,100,100));
        facultate.setForeground(new Color(100,100,100));
        cicluUniversitar.setForeground(new Color(100,100,100));
        //set frame icon
        try {
            frame.setIconImage(ImageIO.read(getClass().getResource("resources/1.png")));
        }catch(IOException ie){
            ie.printStackTrace();
        }
        //set frame size
        frame.setPreferredSize(new Dimension(710,350));
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
        //add department into DB
        adaugare.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(mng.addDepartmentInDB(titlu.getText(),faculties.getSelectedItem().toString(),degrees.getSelectedItem().toString()) == 1){
                    JOptionPane.showMessageDialog(null, "Specializarea a fost adăugată în baza de date!");
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
                degrees.setSelectedIndex(0);
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
        AddDepartmentAdminGUI window = new AddDepartmentAdminGUI();
    }
}
