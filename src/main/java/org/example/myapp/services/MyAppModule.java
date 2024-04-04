package org.example.myapp.services;

import  org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.commons.MappedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.example.myapp.repoimpl.EmployeeDaoImpl;
import org.example.myapp.repoimpl.LoginDaoImpl;
import org.example.myapp.repositories.EmployeeDao;
import org.example.myapp.repositories.LoginDao;
import org.example.myapp.serviceimpl.EmployeeServiceImpl;
import org.example.myapp.serviceimpl.LoginServiceImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class MyAppModule {


    @Inject
    private SessionFactory sessionFactory;

    public static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        return configuration.buildSessionFactory();
    }


    public static void contributeApplicationDefaults(MappedConfiguration<String, String> configuration) {
        configuration.add(SymbolConstants.SUPPORTED_LOCALES, "en,fr,de");
        configuration.add(SymbolConstants.FILE_CHECK_INTERVAL, "10m");
    }
    public static void bind(ServiceBinder binder) {

        binder.bind(LoginService.class, LoginServiceImpl.class);
        binder.bind(EmployeeService.class, EmployeeServiceImpl.class);
        binder.bind(EmployeeDao.class, EmployeeDaoImpl.class);
        binder.bind(LoginDao.class, LoginDaoImpl.class);

    }



}
