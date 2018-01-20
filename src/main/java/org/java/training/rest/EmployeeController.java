package org.java.training.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RESTful implementation of the employee microservice
 *
 * @author Solange U. Gasengayire
 */
@CrossOrigin
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeDAO employeeDAO = new EmployeeListDAO();

    /**
     * Get all employees
     * @return all employees
     */
    @RequestMapping(method = RequestMethod.GET)
    public Employee[] getAll() {
        return employeeDAO.getAllEmployees().toArray(new Employee[0]);
    }

    /**
     * Get an employee by their ID
     * @param id employee id
     * @return the corresponding employee
     */
    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public ResponseEntity get(@PathVariable long id) {

        Employee match = employeeDAO.getEmployee(id);

        if (match != null) {
            return new ResponseEntity<>(match, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Get employees by their lastname
     * @param name employee lastname
     * @return the corresponding list of employees
     */
    @RequestMapping(method = RequestMethod.GET, value = "/lastname/{name}")
    public ResponseEntity getByLastName(@PathVariable String name) {

        List<Employee> matchList = employeeDAO.getByLastName(name);

        if (matchList.size() > 0) {
            return new ResponseEntity<>(matchList.toArray(new Employee[0]), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    /**
     * Get employees by their title
     * @param title employee title
     * @return the corresponding list of employees
     */
    @RequestMapping(method = RequestMethod.GET, value = "/title/{title}")
    public ResponseEntity getByTitle(@PathVariable String title) {

        List<Employee> matchList = employeeDAO.getByTitle(title);

        if (matchList.size() > 0) {
            return new ResponseEntity<>(matchList.toArray(new Employee[0]), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Get employees by their department
     * @param dept employee department
     * @return the corresponding list of employees
     */
    @RequestMapping(method = RequestMethod.GET, value = "/department/{dept}")
    public ResponseEntity getByDept(@PathVariable String dept) {

        List<Employee> matchList = employeeDAO.getByDept(dept);

        if (matchList.size() > 0) {
            return new ResponseEntity<>(matchList.toArray(new Employee[0]), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    /**
     * Add an employee
     * @param employee the new employee to add
     * @return true if the operation succeeds
     *         false otherwise
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody Employee employee) {
        if (employeeDAO.add(employee)) {
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Update an employee information
     * @param id employee id
     * @param employee the new information
     * @return true if the operation succeeds
     *         false otherwise
     */
    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody Employee employee) {

        if (employeeDAO.update(id, employee)) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // TODO: Delete an employees
}
