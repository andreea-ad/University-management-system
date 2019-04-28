import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import org.jdesktop.swingx.prompt.*;
import java.sql.*;

public class LoginGUI{
    private JFrame frame;
    private JLabel lUser, lPass;
    private JTextField username;
    private JPasswordField password;
    private JButton login;
    static Connection conn = null;
    public LoginGUI(){
        frame = new JFrame("Conectare platformă");
        frame.getContentPane().setBackground(Color.WHITE);
        //create input elements
        lUser = new JLabel("Utilizator:");
        lPass = new JLabel("Parolă:");
        username = new JTextField(80);
        //add default text
        PromptSupport.setPrompt("Introduceti adresa dvs. de email", username);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, username);
        password = new JPasswordField(100);
        //add default text
        PromptSupport.setPrompt("******", password);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, password);
        //login button
        login = new JButton("Autentificare");
        //set size and position for the elements
        lUser.setBounds(80, 70, 200, 30);
        lPass.setBounds(80, 110, 200, 30);
        username.setBounds(300, 70, 200, 30);
        password.setBounds(300, 110, 200, 30);
        login.setBounds(200, 160, 150, 30);
        //add actions
        username.addMouseListener(new MouseListener() {
            boolean enabled = true;
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!enabled)
                    return;
                username.setText("");
                enabled = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        password.addMouseListener(new MouseListener() {
            boolean enabled = true;
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!enabled)
                    return;
                password.setText("");
                enabled = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginActionPerformed();
            }
        });
        //add the elements to the frame
        frame.add(lUser);
        frame.add(username);
        frame.add(lPass);
        frame.add(password);
        frame.add(login);
        //set frame size
        frame.setPreferredSize(new Dimension(600,300));
        frame.setLayout(null);
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

    public void loginActionPerformed(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitate", "root", "");

            String sqlAdmin = "select email_address, pass from useradmin where email_address=? and pass=?";
            String sqlSecretary = "select email_address, pass from usersecretariat where email_address=? and pass=?";
            String sqlProfessor = "select email_address, pass from userprofesor where email_address=? and pass=?";
            String sqlStudent = "select email_address, pass from userstudent where email_address=? and pass=?";

            PreparedStatement ps1 = conn.prepareStatement(sqlAdmin);
            ps1.setString(1, username.getText());
            ps1.setString(2, password.getText());
            ResultSet rs1 = ps1.executeQuery();

            PreparedStatement ps2 = conn.prepareStatement(sqlSecretary);
            ps2.setString(1,username.getText());
            ps2.setString(2,password.getText());
            ResultSet rs2 = ps2.executeQuery();

            PreparedStatement ps3 = conn.prepareStatement(sqlProfessor);
            ps3.setString(1,username.getText());
            ps3.setString(2,password.getText());
            ResultSet rs3 = ps3.executeQuery();

            PreparedStatement ps4 = conn.prepareStatement(sqlStudent);
            ps4.setString(1,username.getText());
            ps4.setString(2,password.getText());
            ResultSet rs4 = ps4.executeQuery();
            if(username.getText().isEmpty() && password.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Introduceți o adresă de email și o parolă","Câmpuri incomplete",JOptionPane.WARNING_MESSAGE);
            }else if(username.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Introduceți o adresă de email","Câmpuri incomplete",JOptionPane.WARNING_MESSAGE);
            }else if(password.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Introduceți o parolă","Câmpuri incomplete",JOptionPane.WARNING_MESSAGE);
            }else{
                if(rs1.next()){
                    AdminMenuGUI adminMenu = new AdminMenuGUI();
                    frame.setVisible(false);
                    username.setText("");
                    password.setText("");
                    //display admin menu
                }else if(rs2.next()){
                    SecretaryMenuGUI secretaryMenu = new SecretaryMenuGUI(username.getText());
                    frame.setVisible(false);
                    username.setText("");
                    password.setText("");
                    //display secretary menu
                }else if(rs3.next()) {
                    ProfessorMenuGUI professorMenu = new ProfessorMenuGUI(username.getText());
                    frame.setVisible(false);
                    username.setText("");
                    password.setText("");
                    //display professor menu
                }else if(rs4.next()) {
                    StudentMenuGUI studentMenu = new StudentMenuGUI(username.getText());
                    frame.setVisible(false);
                    username.setText("");
                    password.setText("");
                    //display student menu
                }else{
                    JOptionPane.showMessageDialog(null,"Datele introduse nu sunt valide!","Eroare",JOptionPane.ERROR_MESSAGE);
                    username.setText("");
                    password.setText("");
                }
            }
            conn.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            username.setText("");
            password.setText("");
        }
    }
    public static void main(String[] args){
        LoginGUI login = new LoginGUI();
    }
}
