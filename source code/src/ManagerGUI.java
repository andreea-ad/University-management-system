import javax.swing.*;
import java.sql.*;
import java.util.*;

public class ManagerGUI {
    static List<Faculty>facultati = new ArrayList<>();
    static List<Department>specializari = new ArrayList<>();
    static List<Mark>note = new ArrayList<>();
    static List<Professor>profesori = new ArrayList<>();
    static List<Student>studenti = new ArrayList<>();
    static List<Subject>materii = new ArrayList<>();
    static Connection conn;

    public static ManagerGUI instance = null;
    public static ManagerGUI getInstance(){
        if(instance == null)
            instance = new ManagerGUI();
        return instance;
    }

    public ManagerGUI() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitate", "root", "");
            //retrieve data from DB to create arraylists
            String faculties = "select * from faculties";
            String departments = "select * from departments";
            String subjects = "select * from subjects";
            String professors = "select * from professors";
            String students = "select * from students";
            String marks = "select * from marks";

            PreparedStatement ps = conn.prepareStatement(faculties);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Faculty faculty = new Faculty(rs.getInt("id"),rs.getString("title"));
                facultati.add(faculty);
            }

            ps = conn.prepareStatement(departments);
            rs = ps.executeQuery();
            while(rs.next()) {
                Department department = new Department(rs.getInt("id"),rs.getString("title"),rs.getString("faculty"),Degree.valueOf(rs.getString("degree")));
                specializari.add(department);
            }

            ps = conn.prepareStatement(subjects);
            rs = ps.executeQuery();
            while(rs.next()) {
                Subject subject = new Subject(rs.getInt("id"),rs.getString("title"),rs.getString("faculty"),rs.getString("department"),Degree.valueOf(rs.getString("degree")),rs.getInt("semester"),rs.getInt("number_of_credits"),rs.getString("teacher_first_name"),rs.getString("teacher_last_name"));
                materii.add(subject);
            }

            ps = conn.prepareStatement(professors);
            rs = ps.executeQuery();
            while(rs.next()){
                Professor professor = new Professor(rs.getInt("id"),rs.getString("first_name"),rs.getString("last_name"),rs.getBigDecimal("cnp").toString(),rs.getDate("dob"),rs.getString("phone_number"),rs.getString("address"),rs.getString("email_address"),rs.getString("faculty"),rs.getString("teaching_subject"),rs.getDate("hire_date"),rs.getInt("salary"));
                profesori.add(professor);
            }

            ps = conn.prepareStatement(students);
            rs = ps.executeQuery();
            while(rs.next()) {
                Student student = new Student(rs.getInt("id"),rs.getString("first_name"),rs.getString("last_name"),rs.getBigDecimal("cnp").toString(),rs.getDate("dob"),rs.getString("phone_number"),rs.getString("address"),rs.getString("email_address"),rs.getString("faculty"),rs.getString("department"),Degree.valueOf(rs.getString("degree")),rs.getInt("year"),rs.getInt("number_of_credits"));
                studenti.add(student);
            }

            ps = conn.prepareStatement(marks);
            rs = ps.executeQuery();
            while(rs.next()) {
                Mark mark = new Mark(rs.getInt("id"),rs.getString("student_first_name"),rs.getString("student_last_name"),rs.getInt("mark"),rs.getString("subject"),rs.getString("teacher_first_name"),rs.getString("teacher_last_name"),rs.getDate("date_added"));
                note.add(mark);
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void main(String[] args){

    }
}
