package org.example.myapp.pages;


import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.example.myapp.entities.Employee;
import org.example.myapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

public class IndividualEmployeeDetails {

    @Inject
    private EmployeeService employeeService;

    @PageActivationContext
    private Long employeeId;

    private Employee employee;

    void setupRender() {
        // Check if the employeeId is not null before retrieving employee details
        if (employeeId != null) {
            System.out.println("Here");
            System.out.println(employeeId);
            // Fetch employee details from the database based on the provided employeeId
            employee = employeeService.getEmployeeById(employeeId);
        }
    }

    public Employee getEmployee() {
        return employee;
    }
}

