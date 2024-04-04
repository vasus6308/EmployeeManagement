package org.example.myapp.pages;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.example.myapp.services.LoginService;

public class Login {

    @Property
    private String username;

    @Property
    private String password;

    @Property
    private String loginError;

    @Inject
    private LoginService loginService;

    @InjectPage
    private EmployeeDetailsPage employeeDetailsPage;

    Object onSuccess() {
        boolean isValidLogin = loginService.validateLogin(username, password);

        if (isValidLogin) {
            return employeeDetailsPage;
        } else {
            loginError = "Invalid username or password."; // Set the error message
            return null;
        }
    }
}
