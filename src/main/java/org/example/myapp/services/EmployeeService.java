package org.example.myapp.services;


import org.example.myapp.entities.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);

    Employee getEmployeeById(Long employeeId);
}
