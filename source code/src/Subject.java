public class Subject {
    private int id;
    private String title;
    private String faculty;
    private String department;
    private Degree degree;
    private int semester;
    private int numberOfCredits;
    private String teacherFirstName;
    private String teacherLastName;
    public Subject(int id, String title, String faculty, String department, Degree degree, int semester, int credits, String teacherFirstName, String teacherLastName){
        setID(id);
        setTitle(title);
        setFaculty(faculty);
        setDepartment(department);
        setDegree(degree);
        setSemester(semester);
        setNumberOfCredits(credits);
        setTeacherFirstName(teacherFirstName);
        setTeacherLastName(teacherLastName);
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

    public String getFaculty() {
        return faculty;
    }
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
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

    public String getTeacherFirstName(){ return teacherFirstName; }
    public void setTeacherFirstName(String teacherFirstName){
        this.teacherFirstName=teacherFirstName;
    }

    public String getTeacherLastName(){
        return teacherLastName;
    }
    public void setTeacherLastName(String teacherLastName){
        this.teacherLastName=teacherLastName;
    }

    public String toString(){
        return "Cod: " + id + " Denumire: " + title + " Facultate: " + faculty + " Specializare: " + department + " Ciclu universitar: " + degree + " Semestru: " + semester
                + " Numar de credite: " + numberOfCredits + " Nume profesor: " + teacherLastName + " " + teacherLastName;
    }
    @Override
    public boolean equals(Object o){
        if (o instanceof Subject) {
            Subject other = (Subject) o;
            return title.equals(((Subject) o).getTitle());
        }
        return false;
    }
    @Override
    public int hashCode(){
        return title.hashCode();
    }
}
