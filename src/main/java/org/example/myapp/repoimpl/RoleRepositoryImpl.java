package org.example.myapp.repoimpl;


import org.example.myapp.entities.Role;
import org.example.myapp.entities.Employee;
import org.example.myapp.repositories.RoleRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Role findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Role.class, id);
    }

    @Override
    public List<Role> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Role> cq = cb.createQuery(Role.class);
        Root<Role> root = cq.from(Role.class);
        cq.select(root);
        return session.createQuery(cq).getResultList();
    }

    @Override
    public List<Role> findRolesByEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Role> cq = cb.createQuery(Role.class);
        Root<Role> root = cq.from(Role.class);
        cq.select(root);
        cq.where(cb.isMember(employee, root.get("employees")));
        return session.createQuery(cq).getResultList();
    }

    @Override
    public Role save(Role role) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(role);
        return role;
    }

    @Override
    public void delete(Role role) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(role);
    }
}

