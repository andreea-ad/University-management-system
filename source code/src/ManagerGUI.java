import javax.swing.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class ManagerGUI {
    private static HashSet<Faculty> facultati = new HashSet<>();
    private static HashSet<Department> specializari = new HashSet<>();
    private static HashSet<Mark> note = new HashSet<>();
    private static HashSet<Professor> profesori = new HashSet<>();
    private static HashSet<Student> studenti = new HashSet<>();
    private static HashSet<Subject> materii = new HashSet<>();
    private static HashSet<MarkByEmail> noteDupaEmail = new HashSet<>();
    private static HashSet<MarkByFaculty> noteDupaFacultate = new HashSet<>();
    private static Connection conn;

    private static ManagerGUI instance = null;
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

            String marksByEmail = "select * from marks, students, subjects where marks.student_first_name=students.first_name and marks.student_last_name=students.last_name and marks.subject=subjects.title";
            String marksByFaculty ="select * from marks, students, subjects where marks.student_first_name=students.first_name and marks.student_last_name=students.last_name";

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

            ps = conn.prepareStatement(marksByEmail);
            rs = ps.executeQuery();
            while(rs.next()){
                MarkByEmail mark = new MarkByEmail(rs.getInt("marks.mark"),rs.getString("marks.student_first_name"),rs.getString("marks.student_last_name"),rs.getString("students.email_address"),rs.getString("marks.subject"),rs.getString("marks.teacher_last_name")+" "+rs.getString("marks.teacher_first_name"),rs.getDate("marks.date_added"),rs.getInt("subjects.number_of_credits"));
                noteDupaEmail.add(mark);
            }

            ps = conn.prepareStatement(marksByFaculty);
            rs = ps.executeQuery();
            while(rs.next()){
                MarkByFaculty mark = new MarkByFaculty(rs.getInt("marks.mark"),rs.getString("marks.student_first_name"),rs.getString("marks.student_last_name"),rs.getString("marks.subject"),rs.getString("marks.teacher_last_name")+" "+rs.getString("marks.teacher_first_name"),rs.getString("students.faculty"),rs.getDate("marks.date_added"),rs.getInt("subjects.number_of_credits"));
                noteDupaFacultate.add(mark);
            }

            conn.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void addMarkInDB(String prenume, String nume, int nota, String materie, String prenumeProfesor, String numeProfesor, Date dataAdaugarii){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitate", "root", "");
            String insertQuery = "insert into marks(`student_first_name`,`student_last_name`,`mark`,`subject`,`teacher_first_name`,`teacher_last_name`,`date_added`) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(insertQuery);
            ps.setString(1,prenume);
            ps.setString(2,nume);
            ps.setInt(3,nota);
            ps.setString(4,materie);
            ps.setString(5,prenumeProfesor);
            ps.setString(6,numeProfesor);
            ps.setDate(7,dataAdaugarii);

            ps.execute();

            conn.close();
            System.exit(0);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void removeMarkFromDB(String prenume, String nume, String materie){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitate", "root", "");
            String deleteQuery = "delete from marks where `student_first_name`=? and `student_last_name`=? and `subject`=?";
            PreparedStatement ps = conn.prepareStatement(deleteQuery);
            ps.setString(1,prenume);
            ps.setString(2,nume);
            ps.setString(3,materie);
            ps.execute();
            conn.close();


        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void updateMarkFromDB(String prenume, String nume, int nota, String materie, Date dataEditarii) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitate", "root", "");
            String updateQuery = "update marks set mark=?, date_added=? where student_first_name=? and student_last_name=? and subject=?";
            PreparedStatement ps = conn.prepareStatement(updateQuery);
            ps.setInt(1, nota);
            ps.setDate(2, dataEditarii);
            ps.setString(3, prenume);
            ps.setString(4, nume);
            ps.setString(5, materie);
            ps.executeUpdate();
            ps.close();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addTeacherInDB(String prenume, String nume, String cnp, Date dataNasterii, String numarTelefon, String adresa, String adresaEmail, String facultate, String materiePredata, Date dataAngajarii, int salariu){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitate", "root", "");
            String insertQuery = "insert into professors(`first_name`,`last_name`,`cnp`,`dob`,`phone_number`,`address`,`email_address`,`faculty`,`teaching_subject`, `hire_date`,`salary`) values (?,?,?,?,?,?,?,?,?,?,?)";
            String insertUserQuery = "insert into userprofesor(`email_address`,`pass`) values (?,?)";
            PreparedStatement ps = conn.prepareStatement(insertQuery);
            ps.setString(1,prenume);
            ps.setString(2,nume);
            ps.setString(3,cnp);
            ps.setDate(4,dataNasterii);
            ps.setString(5,numarTelefon);
            ps.setString(6,adresa);
            ps.setString(7,adresaEmail);
            ps.setString(8,facultate);
            ps.setString(9,materiePredata);
            ps.setDate(10,dataAngajarii);
            ps.setInt(11,salariu);
            ps.execute();

            ps = conn.prepareStatement(insertUserQuery);
            ps.setString(1,adresaEmail);
            ps.setString(2,facultate+""+ThreadLocalRandom.current().nextInt(10, 500));
            ps.execute();

            conn.close();
            System.exit(0);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void removeTeacherFromDB(String prenume, String nume, String email){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitate", "root", "");
            String deleteQuery = "delete from professors where `first_name`=? and `last_name`=?";
            String deleteUserQuery = "delete from userprofesor where `email_address`=?";
            PreparedStatement ps = conn.prepareStatement(deleteQuery);
            ps.setString(1,prenume);
            ps.setString(2,nume);
            ps.execute();
            ps = conn.prepareStatement(deleteUserQuery);
            ps.setString(1,email);
            ps.execute();

            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void addStudentInDB(String prenume, String nume, String cnp, Date dataNasterii, String nrTelefon, String adresa, String adresaEmail, String facultate, String specializare, String cicluUniversitar, int anUniversitar, int nrCredite){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitate", "root", "");
            String insertQuery = "insert into students(`first_name`,`last_name`,`cnp`,`dob`,`phone_number`,`address`,`email_address`,`faculty`,`department`, `degree`,`year`,`number_of_credits`)values(?,?,?,?,?,?,?,?,?,?,?,?)";
            String insertUserQuery = "insert into userstudent(`email_address`,`pass`) values (?,?)";
            PreparedStatement ps = conn.prepareStatement(insertQuery);
            ps.setString(1,prenume);
            ps.setString(2,nume);
            ps.setString(3,cnp);
            ps.setDate(4,dataNasterii);
            ps.setString(5,nrTelefon);
            ps.setString(6,adresa);
            ps.setString(7,adresaEmail);
            ps.setString(8,facultate);
            ps.setString(9,specializare);
            ps.setString(10,cicluUniversitar);
            ps.setInt(11,anUniversitar);
            ps.setInt(12,nrCredite);
            ps.execute();

            ps = conn.prepareStatement(insertUserQuery);
            ps.setString(1,adresaEmail);
            ps.setString(2,facultate+""+ThreadLocalRandom.current().nextInt(10, 500));
            ps.execute();

            conn.close();
            System.exit(0);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void removeStudentFromDB(String nume, String prenume, String email){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitate", "root", "");
            String deleteQuery = "delete from students where `first_name`=? and `last_name`=?";
            String deleteUserQuery = "delete from userprofesor where `email_address`=?";
            PreparedStatement ps = conn.prepareStatement(deleteQuery);
            ps.setString(1,prenume);
            ps.setString(2,nume);
            ps.execute();
            ps = conn.prepareStatement(deleteUserQuery);
            ps.setString(1,email);
            ps.execute();

            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public String getFacultateDupaEmail(String email){
        String facultate = "";
        String emailDB = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitate", "root", "");
            String selectQuery = "select * from usersecretariat";
            PreparedStatement ps = conn.prepareStatement(selectQuery);
            ResultSet rs = ps.executeQuery(selectQuery);
            while(rs.next()){
                emailDB += rs.getString("email_address");
                if(email.equals(emailDB)) {
                    facultate += rs.getString("faculty");
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return facultate;
    }

    public static HashSet<Student> getSetStudenti(){ return studenti; }
    public static HashSet<Faculty> getSetFacultati(){ return facultati; }
    public static HashSet<Professor> getSetProfesori(){ return profesori; }
    public static HashSet<Mark> getSetNote(){ return note; }
    public static HashSet<MarkByEmail> getSetNoteDupaEmail(){ return noteDupaEmail; }
    public static HashSet<Subject> getSetMaterii(){ return materii; }
    public static HashSet<MarkByFaculty> getSetNoteDupaFacultate(){ return noteDupaFacultate; }
    public static HashSet<Department> getSetSpecializari(){ return specializari; }

}
