package org.example.myapp.serviceimpl;

import org.example.myapp.entities.Login;
import org.example.myapp.repositories.LoginDao;
import org.example.myapp.services.LoginService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginServiceImpl implements LoginService {

    private final LoginDao loginDao;

    public LoginServiceImpl(LoginDao loginDao) {

        this.loginDao = loginDao;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean validateLogin(String username, String password) {
        Login login = loginDao.findByUsername(username);
        return login != null && login.getPassword().equals(password);
    }
}
