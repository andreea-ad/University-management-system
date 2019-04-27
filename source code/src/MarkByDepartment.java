import java.util.Date;
import java.util.Objects;

public class MarkByDepartment {
    private int mark;
    private String studentFirstName;
    private String studentLastName;
    private String subject;
    private String professor;
    private String faculty;
    private String department;
    private Date dateAdded;
    private int credits;
    public MarkByDepartment(int mark, String firstName, String lastName, String subject, String professor, String faculty, String department, Date date, int credits){
        setMark(mark);
        setStudentFirstName(firstName);
        setStudentLastName(lastName);
        setSubject(subject);
        setProfessor(professor);
        setFaculty(faculty);
        setDepartment(department);
        setDateAdded(date);
        setCredits(credits);
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

    public void setDepartment(String department){ this.department = department; }

    public String getDepartment(){ return department; }

    public void setDateAdded(Date dateAdded) { this.dateAdded = dateAdded; }

    public int getCredits() { return credits; }

    public void setCredits(int credits) { this.credits = credits; }

    @Override
    public boolean equals(Object o) {
        if (o instanceof MarkByDepartment) {
            MarkByDepartment other = (MarkByDepartment) o;
            return mark == other.getMark() && studentFirstName.equals(other.getStudentFirstName()) &&
                    studentLastName.equals(other.getStudentLastName()) && department.equals(other.getDepartment());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mark, studentFirstName, studentLastName, subject, professor, department, faculty, dateAdded);
    }
}

