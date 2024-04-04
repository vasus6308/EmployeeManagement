package org.example.myapp.pages;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.example.myapp.entities.Employee;
import org.example.myapp.services.EmployeeService;

public class AddEmployeePage {

    @Property
    @Validate("required")
    private String name;

    @Property
    @Validate("required, min=18, max=100")
    private Integer age;

    @Property
    @Validate("required")
    private String address;

    @Inject
    private EmployeeService employeeService; // Inject the service to perform database operations

    @InjectComponent
    private Form addEmployeeForm;

    @Property
    private boolean savedSuccessfully; // Flag to indicate if employee is saved successfully

    void onValidateFromAddEmployeeForm() {
        if (addEmployeeForm.getHasErrors()) {
            return;
        }

        // Save the employee data in the database
        Employee newEmployee = new Employee();
        newEmployee.setName(name);
        newEmployee.setAge(age);
        newEmployee.setAddress(address);
        employeeService.saveEmployee(newEmployee);

        savedSuccessfully = true; // Set the flag to true if employee is saved successfully
    }

    Object onSuccess() {
        // Redirect to the employee details page
        return EmployeeDetailsPage.class;
    }
}
