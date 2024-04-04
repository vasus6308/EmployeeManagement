package org.example.myapp.pages;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.example.myapp.entities.Employee;
import org.example.myapp.services.EmployeeService;

import java.util.List;

public class EmployeeDetailsPage {

    @Inject
    private EmployeeService employeeService;

    @Property
    private List<Employee> employeeList;

    @Property
    private Employee currentEmployee;

    @SetupRender
    void setupRender() {
        employeeList = employeeService.getAllEmployees();
        System.out.println(employeeList);
    }
}
