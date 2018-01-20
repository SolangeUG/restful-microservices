package org.java.training.rest;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * Employee Data Access Object implementation
 *
 * @author Solange U. Gasengayire
 */
public class EmployeeListDAO implements EmployeeDAO {

    private final CopyOnWriteArrayList<Employee> employees = MockEmployeeList.getInstance();

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployee(long id) {
        Employee match = null;

        match = employees
                .stream()
                .filter(e -> e.getId() == id)
                .findFirst().orElse(match);
        return match;
    }

    @Override
    public List<Employee> getByLastName(String name) {
        return employees
                .stream()
                .filter((e) -> (e.getLastName().contains(name)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getByTitle(String title) {
        return employees
                .stream()
                .filter((e) -> (e.getTitle().contains(title)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getByDept(String dept) {
        return employees
                .stream()
                .filter((e) -> (e.getDept().contains(dept)))
                .collect(Collectors.toList());
    }

    @Override
    public boolean add(Employee employee) {
        long next = employees.size() + 100;

        Employee nextEmployee =
                new Employee(next, employee.getFirstName(), employee.getLastName(),
                             employee.getEmail(), employee.getPhone(), employee.getBirthDate(),
                             employee.getTitle(), employee.getDept());
        employees.add(nextEmployee);
        return true;
    }

    @Override
    public boolean update(long id, Employee employee) {
        int matchIndex = -1;

        matchIndex = employees.stream()
                        .filter(e -> e.getId() == id)
                        .findFirst()
                        .map(employees::indexOf)
                        .orElse(matchIndex);

        if (matchIndex > -1) {
            employees.set(matchIndex, employee);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(long id) {
        int matchIndex = -1;

        matchIndex = employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .map(employees::indexOf)
                .orElse(matchIndex);

        if (matchIndex > -1) {
            employees.remove(matchIndex);
            return true;
        } else {
            return false;
        }
    }
}
