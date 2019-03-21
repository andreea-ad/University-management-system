import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LoginGUI extends JFrame{
    JLabel lUser, lPass;
    JTextField username;
    JPasswordField password;
    JButton login;
    public String inputUser;
    public String inputPass;
    public LoginGUI(){
        JFrame frame = new JFrame("Conectare platformă");
        //creating input elements
        lUser = new JLabel("Utilizator:");
        lPass = new JLabel("Parolă:");
        username = new JTextField("Introduceți adresa dvs. de email");
        password = new JPasswordField("**********");
        login = new JButton("Autentificare");
        //setting size and position
        lUser.setBounds(80, 70, 200, 30);
        lPass.setBounds(80, 110, 200, 30);
        username.setBounds(300, 70, 200, 30);
        password.setBounds(300, 110, 200, 30);
        login.setBounds(200, 160, 150, 30);
        //adding actions
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
            public void actionPerformed(ActionEvent e) {
                setInputUser(username.getText());
                setInputPass(new String(password.getPassword()));
            }
        });
        frame.add(lUser);
        frame.add(username);
        frame.add(lPass);
        frame.add(password);
        frame.add(login);
        frame.setPreferredSize(new Dimension(600,300));
        frame.setLayout(null);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
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
}
