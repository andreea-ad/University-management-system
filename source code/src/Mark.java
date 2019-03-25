import java.util.*;
public class Mark {
    private int id;
    private String studentFirstName;
    private String studentLastName;
    private int mark;
    private String subject;
    private String teacherFirstName;
    private String teacherLastName;
    private Date dateAdded;
    public Mark(int id, String studentFirstName, String studentLastName, int mark, String subject, String teacherFirstName, String teacherLastName, Date date){
        setID(id);
        setStudentFirstName(studentFirstName);
        setStudentLastName(studentLastName);
        setMark(mark);
        setSubject(subject);
        setTeacherFirstName(teacherFirstName);
        setTeacherLastName(teacherLastName);
        setDateAdded(date);
    }
    public int getID(){
        return id;
    }
    public void setID(int id){
        this.id = id;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }
    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName(){ return studentLastName;}
    public void setStudentLastName(String studentLastName){ this.studentLastName = studentLastName; }

    public int getMark() {
        return mark;
    }
    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTeacherFirstName(){ return teacherFirstName; }
    public void setTeacherFirstName(String teacherFirstName){
        this.teacherFirstName=teacherFirstName;
    }

    public String getTeacherLastName(){
        return teacherLastName;
    }
    public void setTeacherLastName(String teacherLastName){ this.teacherLastName=teacherLastName; }

    public Date getDateAdded() {
        return dateAdded;
    }
    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String toString(){
        return "Cod: " + id + " Nume student: " + studentLastName + " " + studentFirstName + " Nota: " + mark + " Materie " + subject + " Nume profesor: " + teacherLastName + " " + teacherFirstName + " Data adaugarii: " + dateAdded;
    }
}
