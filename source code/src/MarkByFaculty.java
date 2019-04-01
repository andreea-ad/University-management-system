import java.util.Date;
import java.util.Objects;

public class MarkByFaculty {
    private int mark;
    private String studentFirstName;
    private String studentLastName;;
    private String subject;
    private String professor;
    private String faculty;
    private Date dateAdded;
    private int credits;
    public MarkByFaculty(int mark, String firstName, String lastName, String subject, String professor, String faculty, Date date, int credits){
        this.mark=mark;
        this.studentFirstName=firstName;
        this.studentLastName=lastName;
        this.subject=subject;
        this.professor=professor;
        this.faculty=faculty;
        this.dateAdded=date;
        this.credits=credits;
    }
    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }
    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof MarkByFaculty) {
            MarkByFaculty other = (MarkByFaculty) o;
            return mark == other.mark && studentFirstName.equals(other.studentFirstName) &&
                    studentLastName.equals(other.studentLastName);
        }
        return false;
    }


    @Override
    public int hashCode() {
        return Objects.hash(mark, studentFirstName, studentLastName, subject, professor, faculty, dateAdded);
    }
}
