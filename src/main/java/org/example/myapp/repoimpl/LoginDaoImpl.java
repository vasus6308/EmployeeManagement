package org.example.myapp.repoimpl;

import org.example.myapp.entities.Employee;
import org.example.myapp.entities.Login;
import org.example.myapp.repositories.LoginDao;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(propagation = Propagation.REQUIRED,transactionManager = "transactionManager")
public class LoginDaoImpl implements LoginDao {

    private final SessionFactory sessionFactory;

    public LoginDaoImpl(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    @Override
    public Login findByUsername(String username) {
        Transaction tx = null;
        Login login = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            tx = session.beginTransaction();
            System.out.println("Here under validating " + username);

            Criteria criteria = session.createCriteria(Login.class);
            criteria.add(Restrictions.eq("username", username)); // Add a restriction to filter by username
            login = (Login) criteria.uniqueResult(); // Since we're filtering by username, use uniqueResult
            System.out.println(login);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return login;
    }


}
