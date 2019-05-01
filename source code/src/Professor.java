import java.util.*;
public class Professor {
    private int id;
    private String firstName;
    private String lastName;
    private String cnp;
    private Date dob;
    private String phoneNumber;
    private String address;
    private String emailAddress;
    private String faculty;
    private String teachingSubject;
    private Date hireDate;
    private int salary;
    public Professor(int id, String first, String last, String cnp, Date dob, String number, String address, String email, String faculty, String subject, Date hireDate, int salary){
        setID(id);
        setFirstName(first);
        setLastName(last);
        setCnp(cnp);
        setDob(dob);
        setPhoneNumber(number);
        setAddress(address);
        setEmailAddress(email);
        setFaculty(faculty);
        setTeachingSubject(subject);
        setHireDate(hireDate);
        setSalary(salary);
    }

    public int getID(){
        return id;
    }
    public void setID(int id){
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCnp() {
        return cnp;
    }
    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFaculty() {
        return faculty;
    }
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getTeachingSubject() {
        return teachingSubject;
    }
    public void setTeachingSubject(String teachingSubject) { this.teachingSubject = teachingSubject; }

    public Date getHireDate() {
        return hireDate;
    }
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String toString(){
        return "Nume: " + lastName + " Prenume: " + firstName + " CNP: " + cnp + " Data nasterii: " + dob + " Numar de telefon: " + phoneNumber + " Adresa: " + address + " Adresa de email: " + emailAddress + " Facultate: " + faculty + " Materie predata: " + teachingSubject + " Data angajarii: " + hireDate + " Salariu: " + salary;
    }
    @Override
    public boolean equals(Object o){
        if (o instanceof Professor) {
            Professor other = (Professor) o;
            return cnp.equals(((Professor) o).getCnp());
        }
        return false;
    }
    @Override
    public int hashCode(){
        return cnp.hashCode();
    }

}
