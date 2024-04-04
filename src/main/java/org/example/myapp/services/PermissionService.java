package org.example.myapp.services;

import org.example.myapp.entities.Employee;

public interface PermissionService {

    boolean hasEditPermission(Employee employee);
}
