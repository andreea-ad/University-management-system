import javax.swing.*;
import java.sql.*;
import java.util.*;

public class ManagerGUI {
    List<Faculty>facultati = new ArrayList<>();
    List<Department>specializari = new ArrayList<>();
    List<Mark>note = new ArrayList<>();
    List<Professor>profesori = new ArrayList<>();
    List<Student>studenti = new ArrayList<>();
    List<Subject>materii = new ArrayList<>();
    static Connection conn;

    public static ManagerGUI instance = null;
    public static ManagerGUI getInstance(){
        if(instance == null)
            instance = new ManagerGUI();
        return instance;
    }
    public static void connectToDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitate", "root", "");
            System.out.println("Database connection successful!\n");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public ManagerGUI(){
        connectToDB();
        try{
            Statement stm = conn.createStatement();
            ResultSet rSet1 = stm.executeQuery("select * from faculties");
            facultati.add(new Faculty(rSet1.getInt("id"),
                                      rSet1.getString("title")));
            ResultSet rSet2 = stm.executeQuery("select * from departments");
            specializari.add(new Department(rSet2.getInt("id"),
                                            rSet2.getString("title"),
                                            rSet2.getString("faculty"),
                                            Degree.valueOf(rSet2.getString("degree"))));
            ResultSet rSet3 = stm.executeQuery("select * from marks");
            note.add(new Mark(rSet3.getInt("id"),
                              rSet3.getString("student_first_name"),
                              rSet3.getString("student_last_name"),
                              rSet3.getInt("mark"),
                              rSet3.getString("subject"),
                              rSet3.getString("teacher_first_name"),
                              rSet3.getString("teacher_last_name"),
                              rSet3.getDate("date_added")));
            ResultSet rSet4 = stm.executeQuery("select * from subjects");
            materii.add(new Subject(rSet4.getInt("id"),
                                    rSet4.getString("title"),
                                    rSet4.getString("faculty"),
                                    rSet4.getString("department"),
                                    Degree.valueOf(rSet4.getString("degree")),
                                    rSet4.getInt("semester"),
                                    rSet4.getInt("number_of_credits"),
                                    rSet4.getString("teacher_first_name"),
                                    rSet4.getString("teacher_last_name")));
            ResultSet rSet5 = stm.executeQuery("select * from students");
            studenti.add(new Student(rSet5.getInt("id"),
                                     rSet5.getString("first_name"),
                                     rSet5.getString("last_name"),
                                     rSet5.getString("cnp"),
                                     rSet5.getDate("dob"),
                                     rSet5.getString("phone_number"),
                                     rSet5.getString("address"),
                                     rSet5.getString("email_address"),
                                     rSet5.getString("faculty"),
                                     rSet5.getString("department"),
                                     Degree.valueOf(rSet5.getString("degree")),
                                     rSet5.getInt("year"),
                                     rSet5.getInt("number_of_credits")));
            ResultSet rSet6 = stm.executeQuery("select * from professors");
            profesori.add(new Professor(rSet6.getInt("id"),
                                        rSet6.getString("first_name"),
                                        rSet6.getString("last_name"),
                                        rSet6.getString("cnp"),
                                        rSet6.getDate("dob"),
                                        rSet6.getString("phone_number"),
                                        rSet6.getString("address"),
                                        rSet6.getString("email_address"),
                                        rSet6.getString("faculty"),
                                        rSet6.getString("teaching_subject"),
                                        rSet6.getDate("hire_date"),
                                        rSet6.getInt("salary")));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /*public static void main(String[] args){
        login = new LoginGUI();
        user = login.getInputUser();
        pass = login.getInputPass();
        int returnValue = matchLoginInput();
        switch(returnValue){
            case 0: JOptionPane error = new JOptionPane();
                    Object[] options = { "Reincearca", "Anuleaza"};
                    int input = error.showOptionDialog(login.getFrame(), "Autentificare esuata. Datele introduse sunt gresite.", "Eroare", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
                    if(input == JOptionPane.YES_OPTION){
                        new ManagerGUI();
                        break;
                    }
                    else
                        System.exit(0);
            case 1: AdminMenuGUI adminMenu = new AdminMenuGUI();
                    break;
            case 2: SecretaryMenuGUI secretaryMenu = new SecretaryMenuGUI();
                    break;
            case 5: ProfessorMenuGUI professorMenu = new ProfessorMenuGUI();
                    break;
            case 4: StudentMenuGUI studentMenu = new StudentMenuGUI();
                    break;
            default: System.exit(0);

        }

    }
*/}
