package org.example.myapp.repositories;
import org.example.myapp.entities.Employee;
import java.util.*;
public interface EmployeeDao {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long employeeId); // New method
    void save(Employee employee);
}
