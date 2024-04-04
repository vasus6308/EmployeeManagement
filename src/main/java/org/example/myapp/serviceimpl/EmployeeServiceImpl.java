package org.example.myapp.serviceimpl;

import org.example.myapp.entities.Employee;
import org.example.myapp.repositories.EmployeeDao;
import org.example.myapp.services.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
    @Override
    public List<Employee> getAllEmployees() {
        System.out.println("Employee Service Impl");
        return employeeDao.getAllEmployees();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeDao.save(employee);

    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        System.out.println("IMPL");
        return employeeDao.getEmployeeById(employeeId);
    }
}
