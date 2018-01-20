package org.java.training.rest;

import java.util.List;

/**
 * Data Access Object for an Employee
 *
 * @author Solange U. Gasengayire
 */
public interface EmployeeDAO {

    /**
     * Return a list of all employees
     * @return all employees
     */
    List<Employee> getAllEmployees();

    /**
     * Return an employee given their id
     * @param id employee id
     * @return the employee
     */
    Employee getEmployee(long id);

    /**
     * Return a list of employees filtered on their lastname
     * @param name the employee lastname
     * @return the corresponding list of employees
     */
    List<Employee> getByLastName(String name);

    /**
     * Return a list of employees filtered on their title
     * @param title the employee title
     * @return the corresponding list of employees
     */
    List<Employee> getByTitle(String title);

    /**
     * Return a list of employees filtered on their department
     * @param dept the employee department
     * @return the corresponding list of employees
     */
    List<Employee> getByDept(String dept);

    /**
     * Add an employee to the list of employees
     * @param employee the new employee to be added
     * @return true if the operation succeeds
     *         false if it fails
     */
    boolean add(Employee employee);

    /**
     * Update a given employee with new information
     * @param id the employee id
     * @param employee the new data
     * @return true if the operation succeeds
     *         false if it fails
     */
    boolean update(long id, Employee employee);

    /**
     * Delete a given entry id
     * @param id the employee id to delete
     * @return true if the operation succeeds
     *         false if it fails
     */
    boolean delete(long id);
}
