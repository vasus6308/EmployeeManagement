package org.example.myapp.serviceimpl;


import org.example.myapp.entities.Employee;
import org.example.myapp.entities.Permission;
import org.example.myapp.entities.Role;
import org.example.myapp.repositories.RoleRepository;
import org.example.myapp.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    private final RoleRepository roleRepository;

    @Autowired
    public PermissionServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public boolean hasEditPermission(Employee employee) {
        List<Role> roles = roleRepository.findRolesByEmployee(employee);

        // Check if any of the roles grant edit permission
        for (Role role : roles) {
            // Assuming getPermissions() returns a List<String> or a collection of permission objects
            for (Permission permission : role.getPermissions()) {
                // Check if the permission is "EDIT"
                if ("EDIT".equals(permission.getName())) {
                    return true; // Grant edit permission if any role has the required permission
                }
            }
        }

        return false; // Default to false if no role grants edit permission
    }

}

