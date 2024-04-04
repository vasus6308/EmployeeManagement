package org.example.myapp.repositories;

import org.example.myapp.entities.Employee;
import org.example.myapp.entities.Role;

import java.util.List;

public interface RoleRepository {

    Role findById(Long id);

    // Find all roles
    List<Role> findAll();

    // Find roles associated with a specific employee
    List<Role> findRolesByEmployee(Employee employee);

    // Save or update a role
    Role save(Role role);

    // Delete a role
    void delete(Role role);
}
