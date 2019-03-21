public class Subject {
    int id;
    String title;
    Faculty faculty;
    Department department;
    Degree degree;
    int semester;
    int numberOfCredits;
    Professor professor;
    public Subject(int id, String title, Faculty faculty, Department department, Degree degree, int semester, int credits, Professor professor){
        setID(id);
        setTitle(title);
        setFaculty(faculty);
        setDepartment(department);
        setDegree(degree);
        setSemester(semester);
        setNumberOfCredits(credits);
        setProfessor(professor);
    }
    public int getID(){
        return id;
    }

    public void setID(int id){
        this.id=id;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    public Professor getProfessor(){
        return professor;
    }

    public void setProfessor(Professor professor){
        this.professor=professor;
    }
    public String toString(){
        return "Cod: " + id + " Denumire: " + title + " Facultate: " + faculty + " Specializare: " + department.getTitle() + " Ciclu universitar: " + degree + " Semestru: " + semester
                + " Numar de credite: " + numberOfCredits + " Nume profesor: " + professor.getLastName() + " " + professor.getFirstName();
    }
}
