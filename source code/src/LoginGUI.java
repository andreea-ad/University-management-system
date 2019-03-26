import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import org.jdesktop.swingx.prompt.*;
import java.sql.*;

public class LoginGUI extends JFrame{
    static JFrame frame;
    JLabel lUser, lPass;
    JTextField username;
    JPasswordField password;
    JButton login;
    public String inputUser;
    public String inputPass;
    static Connection conn = null;
    static String user, pass;
    public LoginGUI(){
        frame = new JFrame("Conectare platformă");
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
                if(enabled == false)
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
                if(enabled == false)
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
            /**
             * take input data from textfields after login button pressed
             */
            public void actionPerformed(ActionEvent e) {
                setInputUser(username.getText());
                setInputPass(new String(password.getPassword()));
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

    /**
     * show error message when the input data was not found in DB
     */
    public static void showErrorMessage(){
        JOptionPane error = new JOptionPane();
        Object[] options = { "Reincearca", "Anuleaza"};
        int input = error.showOptionDialog(frame, "Autentificare esuata. Datele introduse sunt gresite.", "Eroare", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
        if(input == JOptionPane.YES_OPTION){
            new LoginGUI();
        }
    }
    /**
     * set and get operations for input
     */
    public void setInputUser(String user){
        this.inputUser = user;
    }
    public void setInputPass(String pass){
        this.inputPass = pass;
    }
    public String getInputUser(){
        return inputUser;
    }
    public String getInputPass(){
        return inputPass;
    }
    /**
     * connect to DB and search for the data taken from the input into DB
     */
    public static void main(String[] args){
        LoginGUI login = new LoginGUI();
        user = login.getInputUser();
        pass = login.getInputPass();
        try{
            ManagerGUI.getInstance().connectToDB();
            Statement stm = conn.createStatement();
            ResultSet rSet1 = stm.executeQuery("select email_address, pass from useradmin");
            ResultSet rSet2 = stm.executeQuery("select email_address, pass from usersecretariat");
            ResultSet rSet3 = stm.executeQuery("select email_address, pass from userprofesor");
            ResultSet rSet4 = stm.executeQuery("select email_address, pass from userstudent");
            rSet1.beforeFirst();
            rSet1.next();
            rSet2.beforeFirst();
            rSet2.next();
            rSet3.beforeFirst();
            rSet3.next();
            rSet4.beforeFirst();
            rSet4.next();
            while(rSet1.next()&&rSet2.next()&&rSet3.next()&&rSet4.next()){
                if(user.equals(rSet1.getString("email_address"))&&pass.equals(rSet1.getString("pass"))){
                    //afiseaza meniu admin
                    break;
                }else if(user.equals(rSet2.getString("email_address"))&&pass.equals(rSet2.getString("pass"))){
                    //afiseaza meniu secretariat
                    break;
                }else if(user.equals(rSet3.getString("email_address"))&&pass.equals(rSet3.getString("pass"))) {
                    //afiseaza meniu profesor
                    break;
                }else if(user.equals(rSet4.getString("email_address"))&&pass.equals(rSet4.getString("pass"))){
                    //afiseaza meniu student
                    break;
                }else
                    showErrorMessage();
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
