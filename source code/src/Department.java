public class Department {
    int id;
    String title;
    Faculty faculty;
    Degree degree;
    public Department(int id, String title, Faculty faculty, Degree degree){
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

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }
    public String toString(){
        return "Cod: " + id + " Denumire: " + title + " Facultate: " + faculty.getTitle() + " Ciclu universitar: " + degree;
    }
}
