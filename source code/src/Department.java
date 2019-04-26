import java.util.Objects;

public class Department {
    private int id;
    private String title;
    private String faculty;
    private Degree degree;
    public Department(String title){
        setTitle(title);
        setFaculty(null);
        setDegree(null);
    }
    public Department(int id, String title, String faculty, Degree degree){
        setID(id);
        setTitle(title);
        setFaculty(faculty);
        setDegree(degree);
    }
    public int getID(){
        return id;
    }
    public void setID(int id){
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }
    public String toString(){ return title; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id &&
                Objects.equals(title, that.title) &&
                Objects.equals(faculty, that.faculty) &&
                degree == that.degree;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, faculty, degree);
    }
}
