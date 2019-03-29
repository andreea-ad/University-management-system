import java.util.*;
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String cnp;
    private Date dob;
    private String phoneNumber;
    private String address;
    private String emailAddress;
    private String faculty;
    private String department;
    private Degree degree;
    private int year;
    private int numberOfCredits;
    public Student(int id, String first, String last, String cnp, Date dob, String number, String address, String email, String faculty, String dept, Degree degree, int year, int credits){
        setID(id);
        setFirstName(first);
        setLastName(last);
        setCnp(cnp);
        setDob(dob);
        setPhoneNumber(number);
        setAddress(address);
        setEmailAddress(email);
        setFaculty(faculty);
        setDepartment(dept);
        setDegree(degree);
        setYear(year);
        setNumberOfCredits(credits);
    }

    public int getID(){
        return id;
    }

    public void setID(int id) {
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

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }
    /*public void increaseYear(){
        this.year++;
    }
    public void increaseCredits(){
        this.numberOfCredits++;
    }*/
    public String toString(){
        return "Numar matricol: " + id + " Nume: " + lastName + " Prenume: " + firstName + " CNP: " + cnp + " Data nasterii: " + dob + " Numar de telefon: "
                + " Adresa: " + address + " Adresa de email: " + emailAddress + " Facultate: " + faculty + " Specializare: " + department + " Ciclu universitar: "
                + degree + " An de studiu: " + year + " Numar de credite: " + numberOfCredits;
    }
}
