package org.example.myapp.repositories;

import org.example.myapp.entities.Login;

public interface LoginDao {
    Login findByUsername(String username);
}
