import java.util.*;
public class MarkByEmail{
    private int mark;
    private String studentFirstName;
    private String studentLastName;
    private String email;
    private String subject;
    private int semester;
    private String professor;
    private Date dateAdded;
    private int credits;
    public MarkByEmail(int mark, String firstName, String lastName, String email, String subject, int sem, String prof, Date date,int credits){
        this.mark = mark;
        this.studentFirstName = firstName;
        this.studentLastName = lastName;
        this.email = email;
        this.subject = subject;
        this.semester = sem;
        this.professor = prof;
        this.dateAdded = date;
        this.credits = credits;
    }
    public int getMark(){
        return mark;
    }
    public String getEmail(){
        return email;
    }
    public String getStudentFirstName(){
        return studentFirstName;
    }
    public String getStudentLastName(){
        return studentLastName;
    }
    public String getSubject(){
        return subject;
    }
    public int getSemester() { return semester; }
    public String getProfessor(){
        return professor;
    }
    public String getDateAdded(){
        return String.valueOf(dateAdded);
    }
    public int getCredits(){
        return credits;
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof MarkByEmail) {
            MarkByEmail other = (MarkByEmail) o;
            return email.equals(other.getEmail()) && subject.equals(other.getSubject());
        }
        return false;
    }

    @Override
    public int hashCode(){
        return email.hashCode();
    }
}
