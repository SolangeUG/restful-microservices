package org.java.training.rest;

/**
 * Employee data class
 *
 * @author Solange U. Gasengayire
 */
public class Employee {

    private final long id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;
    private final String birthDate;
    private final String title;
    private final String dept;

    /**
     * Default constructor
     */
    public Employee() {
        super();
        id = 0;
        firstName = "";
        lastName = "";
        email = "";
        phone = "";
        birthDate = "";
        title = "";
        dept = "";
    }

    /**
     * Constructor
     * @param id employee id
     * @param firstName employee firstname
     * @param lastName employee lastname
     * @param email employee email address
     * @param phone employee phone number
     * @param birthDate employee birthdate
     * @param title employee title
     * @param dept employee dept
     */
    Employee(long id, String firstName, String lastName,
                    String email, String phone, String birthDate, String title, String dept) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.title = title;
        this.dept = dept;
    }

    /**
     * Return employee id
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * Return employee firstname
     * @return firstname
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * return employee lastname
     * @return lastname
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Return employee email address
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Return employee phone number
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Return employee birth date
     * @return birthdate
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Return employee title
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Return employee department
     * @return dept
     */
    public String getDept() {
        return dept;
    }

    /**
     * Return a string representation of an employee's information
     * @return this object as a string
     */
    @Override
    public String toString() {
        return "ID: " + id
                + " First Name: " + firstName
                + " Last Name: " + lastName
                + " EMail: " + email
                + " Phone: " + phone
                + " Birth Date: " + birthDate
                + " Title: " + title
                + " Department: " + dept;
    }
}
