import javax.swing.*;
import java.sql.*;

public class ManagerGUI {
    static Connection myConn = null;
    static String user, pass;
    public static int matchLoginInput(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Get a DB connection
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "");

            System.out.println("Database connection successful!\n");
            // Create a statement
            Statement myStmt = myConn.createStatement();

            // Execute SQL query
            ResultSet rSet1 = myStmt.executeQuery("select email_address, password from __");
            ResultSet rSet2 = myStmt.executeQuery("select email_address, password from __");
            ResultSet rSet3 = myStmt.executeQuery("select email_address, password from __");
            ResultSet rSet4 = myStmt.executeQuery("select email_address, password from __");
            ResultSet rSet5 = myStmt.executeQuery("select email_address, password from __");

            if (user.equals(rSet1.getString("email_address") && pass.equals(rSet1.getString("password"))))
                return 1;
            else if (user.equals(rSet2.getString("email_address") && pass.equals(rSet2.getString("password"))))
                return 2;
            else if (user.equals(rSet3.getString("email_address") && pass.equals(rSet3.getString("password"))))
                return 3;
            else if (user.equals(rSet4.getString("email_address") && pass.equals(rSet4.getString("password"))))
                return 4;
            else if (user.equals(rSet5.getString("email_address") && pass.equals(rSet5.getString("password"))))
                return 5;
            return 0;
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        LoginGUI window1 = new LoginGUI();
        user = window1.getInputUser();
        pass = window1.getInputPass();
        int returnValue = matchLoginInput();
        switch(returnValue){
            case 0: break;
            case 1: break;
            case 2: break;
            case 3: break;
            case 4: break;
            case 5: break;
        }

    }
}
