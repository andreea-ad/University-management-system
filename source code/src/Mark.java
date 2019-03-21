import java.util.*;
public class Mark {
    int id;
    Student student;
    int mark;
    Subject subject;
    Professor professor;
    Date dateAdded;
    public Mark(int id, Student student, int mark, Subject subject, Professor professor, Date date){
        setID(id);
        setStudent(student);
        setMark(mark);
        setSubject(subject);
        setProfessor(professor);
        setDateAdded(date);
    }

    public int getID(){
        return id;
    }

    public void setID(int id){
        this.id = id;
    }
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }
    public String toString(){
        return "Cod: " + id + " Nume student: " + student.getLastName() + " " + student.getFirstName() + " Nota: " + mark + " Materie " + subject.getTitle() + " Nume profesor: " + professor.getLastName() + " " + professor.getFirstName() + " Data adaugarii: " + dateAdded;
    }
}
