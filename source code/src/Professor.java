import java.util.*;
public class Professor {
    int id;
    String firstName;
    String lastName;
    String cnp;
    Date dob;
    String phoneNumber;
    String address;
    String emailAddress;
    String faculty;
    Subject teachingSubject;
    Date hireDate;
    int salary;
    public Professor(int id, String first, String last, String cnp, Date dob, String number, String address, String email, String faculty, Subject subject, Date hireDate, int salary){
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

    public Subject getTeachingSubject() {
        return teachingSubject;
    }

    public void setTeachingSubject(Subject teachingSubject) {
        this.teachingSubject = teachingSubject;
    }

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
}
