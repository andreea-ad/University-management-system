import java.sql.*;

public class DBConnect {
    public static void main(String[] args) throws SQLException {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Get a DB connection
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root" , "");

            System.out.println("Database connection successful!\n");

            // Create a statement
            myStmt = myConn.createStatement();

            // Execute SQL query
            myRs = myStmt.executeQuery("select * from employees");

            // Process the result set
            while (myRs.next()) {
                System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name"));
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
    }
}

