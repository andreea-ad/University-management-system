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
    private static HashSet<MarkByDepartment> noteDupaSpecializare = new HashSet<>();
    private static Connection conn;

    public ManagerGUI() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitate1", "root", "");
            //retrieve data from DB to create hashsets
            String faculties = "select * from faculties where flag=1";
            String departments = "select * from departments where flag=1";
            String subjects = "select * from subjects where flag=1";
            String professors = "select * from professors where flag=1";
            String students = "select * from students where flag=1";
            String marks = "select * from marks where flag=1";

            String marksByEmail = "select * from marks, students, subjects where marks.student_first_name=students.first_name and marks.student_last_name=students.last_name and marks.subject=subjects.title and subjects.department=students.department and marks.flag=1 and subjects.flag=1 and students.flag=1";
            String marksByDepartment = "select * from marks, students, subjects where marks.student_first_name=students.first_name and marks.student_last_name=students.last_name and marks.subject=subjects.title and marks.flag=1 and subjects.flag=1 and students.flag=1";

            PreparedStatement ps = conn.prepareStatement(faculties);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Faculty faculty = new Faculty(rs.getInt("id"),rs.getString("title"));
                facultati.add(faculty);
            }

            ps = conn.prepareStatement(departments);
            rs = ps.executeQuery();
            while(rs.next()) {
                Department department = new Department(rs.getInt("id"),rs.getString("title"),rs.getString("faculty"),rs.getString("degree"));
                specializari.add(department);
            }

            ps = conn.prepareStatement(subjects);
            rs = ps.executeQuery();
            while(rs.next()) {
                Subject subject = new Subject(rs.getInt("id"),rs.getString("title"),rs.getString("faculty"),rs.getString("department"),rs.getString("degree"),rs.getInt("semester"),rs.getInt("number_of_credits"),rs.getString("teacher_first_name"),rs.getString("teacher_last_name"));
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
                Student student = new Student(rs.getInt("id"),rs.getString("first_name"),rs.getString("last_name"),rs.getBigDecimal("cnp").toString(),rs.getDate("dob"),rs.getString("phone_number"),rs.getString("address"),rs.getString("email_address"),rs.getString("faculty"),rs.getString("department"),rs.getString("degree"),rs.getInt("year"),rs.getInt("number_of_credits"));
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
                MarkByEmail mark = new MarkByEmail(rs.getInt("marks.mark"),rs.getString("marks.student_first_name"),rs.getString("marks.student_last_name"),rs.getString("students.email_address"),rs.getString("marks.subject"),rs.getInt("subjects.semester"),rs.getString("marks.teacher_last_name")+" "+rs.getString("marks.teacher_first_name"),rs.getDate("marks.date_added"),rs.getInt("subjects.number_of_credits"));
                noteDupaEmail.add(mark);
            }

            ps = conn.prepareStatement(marksByDepartment);
            rs = ps.executeQuery();
            while(rs.next()){
                MarkByDepartment mark = new MarkByDepartment(rs.getInt("marks.mark"),rs.getString("marks.student_first_name"),rs.getString("marks.student_last_name"),rs.getString("marks.subject"),rs.getString("marks.teacher_last_name")+" "+rs.getString("marks.teacher_first_name"),rs.getString("students.faculty"),rs.getString("subjects.department"),rs.getDate("marks.date_added"),rs.getInt("subjects.number_of_credits"));
                noteDupaSpecializare.add(mark);
            }

            conn.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static int addMarkInDB(String prenume, String nume, int nota, String materie, String prenumeProfesor, String numeProfesor, Date dataAdaugarii){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitate1", "root", "");
            String insertQuery = "insert into marks(`student_first_name`,`student_last_name`,`mark`,`subject`,`teacher_first_name`,`teacher_last_name`,`date_added`,`flag`) VALUES (?,?,?,?,?,?,?,1)";
            for(Mark m:note){
                if(m.getStudentLastName().equals(nume) && m.getStudentFirstName().equals(prenume) && m.getSubject().equals(materie)){
                    JOptionPane.showMessageDialog(null,"Studentul are notă!","Operație refuzată",JOptionPane.WARNING_MESSAGE);
                    return -1;
                }
            }
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
        }catch(Exception e){
            e.printStackTrace();
        }
        return 1;
    }
    public static void removeMarkFromDB(String prenume, String nume, String materie){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitate1", "root", "");
            String deleteQuery = "update marks set flag=0 where `student_first_name`=? and `student_last_name`=? and `subject`=?";
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
    public static void removeMarkFromDB(String nume, String prenume){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitate1", "root", "");
            String deleteQuery = "update marks set flag=0 where `student_first_name`=? and `student_last_name`=?";
            PreparedStatement ps = conn.prepareStatement(deleteQuery);
            ps.setString(1,prenume);
            ps.setString(2,nume);
            ps.execute();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static int updateMarkFromDB(String prenume, String nume, int nota, String materie, Date dataEditarii) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitate1", "root", "");
            String updateQuery = "update marks set mark=?, date_added=? where student_first_name=? and student_last_name=? and subject=?";
            for(Mark m:note){
                if(m.getStudentFirstName().equals(prenume) && m.getStudentLastName().equals(nume) && m.getSubject().equals(materie)){
                    JOptionPane.showMessageDialog(null,"O notă există deja în baza de date pentru acest student!", "Operație refuzată", JOptionPane.WARNING_MESSAGE);
                    return -1;
                }
            }
            PreparedStatement ps = conn.prepareStatement(updateQuery);
            ps.setInt(1, nota);
            ps.setDate(2, dataEditarii);
            ps.setString(3, prenume);
            ps.setString(4, nume);
            ps.setString(5, materie);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }
    public static int addTeacherInDB(String prenume, String nume, String cnp, Date dataNasterii, String numarTelefon, String adresa, String adresaEmail, String facultate, String materiePredata, Date dataAngajarii, int salariu){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitate1", "root", "");
            String insertQuery = "insert into professors(`first_name`,`last_name`,`cnp`,`dob`,`phone_number`,`address`,`email_address`,`faculty`,`teaching_subject`, `hire_date`,`salary`,`flag`) values (?,?,?,?,?,?,?,?,?,?,?,1)";
            String insertUserQuery = "insert into userprofesor(`email_address`,`pass`,`flag`) values (?,?,1)";
            for(Professor p:profesori){
                if(p.getCnp().equals(cnp)){
                    JOptionPane.showMessageDialog(null,"Profesorul există deja în baza de date!","Operație refuzată",JOptionPane.WARNING_MESSAGE);
                    return -1;
                }
            }
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
            ps.setString(2,facultate + "" + ThreadLocalRandom.current().nextInt(10, 500));
            ps.execute();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return 1;
    }
    public static void removeTeacherFromDB(String prenume, String nume, String email){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitate1", "root", "");
            String deleteQuery = "update professors set flag=0 where `first_name`=? and `last_name`=?";
            String deleteUserQuery = "update userprofesor set flag=0 where `email_address`=?";
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
    public static int updateTeacherFromDB(String cnp1, String prenume, String nume, String cnp, Date dataNasterii, String nrTelefon, String adresa, String email, String facultate, String materie, Date dataAngajarii, int salariu){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitate1", "root", "");
            String updateQuery = "update professors set first_name=?, last_name=?, cnp=?, dob=?, phone_number=?, address=?, email_address=?, faculty=?, teaching_subject=?, hire_date=?, salary=? where cnp=?";
            for(Professor p:profesori){
                if(p.getCnp().equals(cnp)){
                    JOptionPane.showMessageDialog(null,"Profesorul există deja în baza de date!", "Operație refuzată",JOptionPane.WARNING_MESSAGE);
                    return -1;
                }
            }
            PreparedStatement ps = conn.prepareStatement(updateQuery);
            ps.setString(1,prenume);
            ps.setString(2,nume);
            ps.setString(3,cnp);
            ps.setDate(4,dataNasterii);
            ps.setString(5,nrTelefon);
            ps.setString(6,adresa);
            ps.setString(7,email);
            ps.setString(8,facultate);
            ps.setString(9,materie);
            ps.setDate(10,dataAngajarii);
            ps.setInt(11,salariu);
            ps.setString(12,cnp1);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }
    public static int addStudentInDB(String prenume, String nume, String cnp, Date dataNasterii, String nrTelefon, String adresa, String adresaEmail, String facultate, String specializare, String cicluUniversitar, int anUniversitar, int nrCredite){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitate1", "root", "");
            String insertQuery = "insert into students(`first_name`,`last_name`,`cnp`,`dob`,`phone_number`,`address`,`email_address`,`faculty`,`department`, `degree`,`year`,`number_of_credits`,`flag`)values(?,?,?,?,?,?,?,?,?,?,?,?,1)";
            String insertUserQuery = "insert into userstudent(`email_address`,`pass`,`flag`) values (?,?,1)";
            for(Student s:studenti){
                if(s.getCnp().equals(cnp)){
                    JOptionPane.showMessageDialog(null,"Studentul există deja în baza de date!","Operație refuzată",JOptionPane.WARNING_MESSAGE);
                    return -1;
                }
            }
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
            ps.setString(2,facultate + "" + ThreadLocalRandom.current().nextInt(10, 500));
            ps.execute();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return 1;
    }
    public static void removeStudentFromDB(String nume, String prenume, String email){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitate1", "root", "");
            String deleteQuery = "update students set flag=0 where `first_name`=? and `last_name`=?";
            String deleteUserQuery = "update userstudent set flag=0 where `email_address`=?";
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
    public static int updateStudentFromDB(String cnp1, String prenume, String nume, String cnp, Date dataNasterii, String nrTelefon, String adresa, String email, String facultate, String specializare, String cicluUniversitar, int an, int nrCredite){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitate1", "root", "");
            String updateQuery = "update students set first_name=?, last_name=?, cnp=?, dob=?, phone_number=?, address=?, email_address=?, faculty=?, department=?, degree=?, year=?, number_of_credits=? where cnp=?";
            for(Student s:studenti){
                if(s.getCnp().equals(cnp)){
                    JOptionPane.showMessageDialog(null,"Studentul există deja în baza de date!", "Operație refuzată", JOptionPane.WARNING_MESSAGE);
                    return -1;
                }
            }
            PreparedStatement ps = conn.prepareStatement(updateQuery);
            ps.setString(1,prenume);
            ps.setString(2,nume);
            ps.setString(3,cnp);
            ps.setDate(4,dataNasterii);
            ps.setString(5,nrTelefon);
            ps.setString(6,adresa);
            ps.setString(7,email);
            ps.setString(8,facultate);
            ps.setString(9,specializare);
            ps.setString(10,cicluUniversitar);
            ps.setInt(11,an);
            ps.setInt(12,nrCredite);
            ps.setString(13,cnp1);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }
    public static int addDepartmentInDB(String titlu, String facultate, String cicluUniversitar){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitate1", "root", "");
            String insertQuery = "insert into departments(`title`,`faculty`,`degree`,`flag`)values(?,?,?,1)";
            for (Department d:specializari) {
                if (d.getTitle().equals(titlu)) {
                    JOptionPane.showMessageDialog(null, "Specializarea există deja în baza de date!", "Operație refuzată", JOptionPane.WARNING_MESSAGE);
                    return -1;
                }
            }
            PreparedStatement ps = conn.prepareStatement(insertQuery);
            ps.setString(1,titlu);
            ps.setString(2,facultate);
            ps.setString(3,cicluUniversitar);
            ps.execute();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }
    public static int addFacultyInDB(String titlu){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitate1", "root", "");
            String insertQuery = "insert into faculties(`title`,`flag`)values(?,1)";
            String insertUserQuery = "insert into usersecretariat(`faculty`,`email_address`,`pass`,`flag`)values(?,?,?,1)";
            for (Faculty f:facultati) {
                if (f.getTitle().equals(titlu)) {
                    JOptionPane.showMessageDialog(null, "Facultatea există deja în baza de date!", "Operație refuzată", JOptionPane.WARNING_MESSAGE);
                    return -1;
                }
            }
            PreparedStatement ps = conn.prepareStatement(insertQuery);
            ps.setString(1,titlu);
            ps.execute();
            ps = conn.prepareStatement(insertUserQuery);
            ps.setString(1,titlu);
            String[] titluSplit = titlu.split("de",2);
            String email = titluSplit[1].replaceAll("\\s+","") + "@gmail.com";
            String pass = titluSplit[1].replaceAll("\\s+","") + ThreadLocalRandom.current().nextInt(10, 500);
            ps.setString(2,email);
            ps.setString(3,pass);
            ps.execute();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }
    public static int updateFacultyFromDB(String titlu1, String titlu){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitate1", "root", "");
            String updateQuery = "update faculties set title=? where title=?";
            String updateQuery2 = "update departments set faculty=? where faculty=?";
            String updateQuery3 = "update professors set faculty=? where faculty=?";
            String updateQuery4 = "update students set faculty=? where faculty=?";
            String updateQuery5 = "update subjects set faculty=? where faculty=?";
            String updateQuery6 = "update usersecretariat set faculty=?, email_address=?, pass=? where faculty=?";
            for(Faculty f:facultati){
                if(f.getTitle().equals(titlu)){
                    JOptionPane.showMessageDialog(null,"Facultatea aceasta există deja în baza de date!","Operație refuzată",JOptionPane.WARNING_MESSAGE);
                    return -1;
                }
            }
            PreparedStatement ps = conn.prepareStatement(updateQuery);
            ps.setString(1,titlu);
            ps.setString(2,titlu1);
            ps.executeUpdate();
            ps = conn.prepareStatement(updateQuery2);
            ps.setString(1,titlu);
            ps.setString(2,titlu1);
            ps.executeUpdate();
            ps = conn.prepareStatement(updateQuery3);
            ps.setString(1,titlu);
            ps.setString(2,titlu1);
            ps.executeUpdate();
            ps = conn.prepareStatement(updateQuery4);
            ps.setString(1,titlu);
            ps.setString(2,titlu1);
            ps.executeUpdate();
            ps = conn.prepareStatement(updateQuery5);
            ps.setString(1,titlu);
            ps.setString(2,titlu1);
            ps.executeUpdate();
            ps = conn.prepareStatement(updateQuery6);
            String[] titluSplit = titlu.split("de",2);
            String email = titluSplit[1].replaceAll("\\s+","") + "@gmail.com";
            String pass = titluSplit[1].replaceAll("\\s+","") + ThreadLocalRandom.current().nextInt(10, 500);
            ps.setString(1,titlu);
            ps.setString(2,email);
            ps.setString(3,pass);
            ps.setString(4,titlu1);
            ps.executeUpdate();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }
    public static int removeFacultyFromDB(String titlu){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitate1", "root", "");
            String deleteQuery = "update faculties set flag=0 where title=?";
            String deleteQuery2 = "update usersecretariat set flag=0 where faculty=?";
            String deleteQuery3 = "update professors set faculty='' where faculty=?";
            String deleteQuery4 = "update students set faculty='' where faculty=?";
            String deleteQuery5 = "update departments set faculty='' where faculty=?";
            String deleteQuery6 = "update subjects set faculty='' where faculty=?";
            PreparedStatement ps = conn.prepareStatement(deleteQuery);
            ps.setString(1,titlu);
            ps.executeUpdate();
            ps = conn.prepareStatement(deleteQuery2);
            ps.setString(1,titlu);
            ps.executeUpdate();
            ps = conn.prepareStatement(deleteQuery3);
            ps.setString(1,titlu);
            ps.executeUpdate();
            ps = conn.prepareStatement(deleteQuery4);
            ps.setString(1,titlu);
            ps.executeUpdate();
            ps = conn.prepareStatement(deleteQuery5);
            ps.setString(1,titlu);
            ps.executeUpdate();
            ps = conn.prepareStatement(deleteQuery6);
            ps.setString(1,titlu);
            ps.executeUpdate();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return 1;
    }
    public static int addSubjectInDB(String titlu, String facultate, String specializare, String cicluUniversitar, int semestru, int nrCredite, String profesor){
        String[] prof;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitate1", "root", "");
            String insertQuery = "insert into subjects(`title`,`faculty`,`department`,`degree`,`semester`,`number_of_credits`,`teacher_first_name`,`teacher_last_name`,`flag`)values(?,?,?,?,?,?,?,?,1)";
            for(Subject s:materii){
                if(s.getTitle().equals(titlu) && s.getDepartment().equals(specializare)){
                    JOptionPane.showMessageDialog(null, "Materia există deja în baza de date!", "Operație refuzată", JOptionPane.WARNING_MESSAGE);
                    return -1;
                }
            }
            prof = profesor.split(" ");
            PreparedStatement ps = conn.prepareStatement(insertQuery);
            ps.setString(1,titlu);
            ps.setString(2,facultate);
            ps.setString(3,specializare);
            ps.setString(4,cicluUniversitar);
            ps.setInt(5,semestru);
            ps.setInt(6,nrCredite);
            ps.setString(7,prof[1]);
            ps.setString(8,prof[0]);
            ps.execute();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }
    public static int removeSubjectFromDB(String titlu){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitate1", "root", "");
            String deleteQuery = "update subjects set flag=0 where title=?";
            String deleteQuery2 = "update professors set teaching_subject='' where teaching_subject=?";
            String deleteQuery3 = "update marks set subject='' where subject=?";
            PreparedStatement ps = conn.prepareStatement(deleteQuery);
            ps.setString(1,titlu);
            ps.executeUpdate();
            ps = conn.prepareStatement(deleteQuery2);
            ps.setString(1,titlu);
            ps.executeUpdate();
            ps = conn.prepareStatement(deleteQuery3);
            ps.setString(1,titlu);
            ps.executeUpdate();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }
    public static int updateSubjectFromDB(String titlu1, String titlu, String facultate, String specializare, String cicluUniversitar, int semestru, int nrCredite, String prenumeProfesor, String numeProfesor){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitate1", "root", "");
            String updateQuery = "update subjects set title=?, faculty=?, department=?, degree=?, semester=?, credits=?, teacher_first_name=?, teacher_last_name=? where title=?";
            String updateQuery1 = "update marks set subject=? where subject=?";
            String updateQuery2 = "update professors set teaching_subject=? where teaching_subject=?";
            for(Subject s:materii){
                if(s.getTitle().equals(titlu)){
                    JOptionPane.showMessageDialog(null,"Materia aceasta există deja în baza de date!","Operație refuzată",JOptionPane.WARNING_MESSAGE);
                    return -1;
                }
            }
            PreparedStatement ps = conn.prepareStatement(updateQuery);
            ps.setString(1,titlu);
            ps.setString(2,facultate);
            ps.setString(3,specializare);
            ps.setString(4,cicluUniversitar);
            ps.setInt(5,semestru);
            ps.setInt(6,nrCredite);
            ps.setString(7,prenumeProfesor);
            ps.setString(8,numeProfesor);
            ps.setString(9,titlu1);
            ps.executeUpdate();
            ps = conn.prepareStatement(updateQuery1);
            ps.setString(1,titlu);
            ps.setString(2,titlu1);
            ps.executeUpdate();
            ps = conn.prepareStatement(updateQuery2);
            ps.setString(1,titlu);
            ps.setString(2,titlu1);
            ps.executeUpdate();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }
    public static int removeDepartmentFromDB(String titlu){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitate1", "root", "");
            String deleteQuery = "update departments set flag=0 where title=?";
            String deleteQuery2 = "update subjects set department='' where department=?";
            String deleteQuery3 = "update students set department='' where department=?";
            PreparedStatement ps = conn.prepareStatement(deleteQuery);
            ps.setString(1,titlu);
            ps.executeUpdate();
            ps = conn.prepareStatement(deleteQuery2);
            ps.setString(1,titlu);
            ps.executeUpdate();
            ps = conn.prepareStatement(deleteQuery3);
            ps.setString(1,titlu);
            ps.executeUpdate();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }
    public static int updateDepartmentFromDB(String titlu1, String titlu, String facultate, String cicluUniversitar){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitate1", "root", "");
            String updateQuery = "update departments set title=?, degree=? where title=? and faculty=?";
            String updateQuery2 = "update students set department=? where department=?";
            String updateQuery3 = "update subjects set department=? where department=?";
            for(Department d:specializari){
                if(!titlu1.equals(titlu) && d.getTitle().equals(titlu) && d.getFaculty().equals(facultate)){
                    JOptionPane.showMessageDialog(null, "Specializarea există deja în baza de date!","Operație refuzată",JOptionPane.WARNING_MESSAGE);
                    return -1;
                }
            }
            PreparedStatement ps = conn.prepareStatement(updateQuery);
            ps.setString(1,titlu);
            ps.setString(2,cicluUniversitar);
            ps.setString(3,titlu1);
            ps.setString(4,facultate);
            ps.executeUpdate();
            ps = conn.prepareStatement(updateQuery2);
            ps.setString(1,titlu);
            ps.setString(2,titlu1);
            ps.executeUpdate();
            ps = conn.prepareStatement(updateQuery3);
            ps.setString(1,titlu);
            ps.setString(2,titlu1);
            ps.executeUpdate();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return 1;
    }
    public static String getFacultateDupaEmail(String email){
        String facultate = "", emailDB;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitate1", "root", "");
            String selectQuery = "select * from usersecretariat where flag=1";
            PreparedStatement ps = conn.prepareStatement(selectQuery);
            ResultSet rs = ps.executeQuery(selectQuery);
            while(rs.next()){
                emailDB = rs.getString("email_address");
                if(email.equals(emailDB)) {
                    facultate += rs.getString("faculty");
                    break;
                }
            }
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return facultate;
    }
    public static String[] getProfesorDupaEmail(String email){
        String[] profesor = {"",""};
        String emailDB;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitate1", "root", "");
            String selectQuery = "select * from professors where flag=1";
            PreparedStatement ps = conn.prepareStatement(selectQuery);
            ResultSet rs = ps.executeQuery(selectQuery);
            while(rs.next()){
                emailDB = rs.getString("email_address");
                if(email.equals(emailDB)) {
                    profesor[0] += rs.getString("first_name");
                    profesor[1] += rs.getString("last_name");
                    break;
                }
            }
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return profesor;
    }
    public static HashSet<Student> getSetStudenti(){ return studenti; }
    public static HashSet<Faculty> getSetFacultati(){ return facultati; }
    public static HashSet<Professor> getSetProfesori(){ return profesori; }
    public static HashSet<Mark> getSetNote(){ return note; }
    public static HashSet<MarkByEmail> getSetNoteDupaEmail(){ return noteDupaEmail; }
    public static HashSet<Subject> getSetMaterii(){ return materii; }
    public static HashSet<Department> getSetSpecializari(){ return specializari; }
    public static HashSet<MarkByDepartment> getSetNoteDupaSpecializare(){ return noteDupaSpecializare; }
}
