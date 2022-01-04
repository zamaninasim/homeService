package ir.maktab.dao;

import ir.maktab.model.entity.services.SubService;
import ir.maktab.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Optional;

public class SubServiceDao {
    private SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();

    public void save(SubService subService) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(subService);
        transaction.commit();
        session.close();
    }

    public Optional<SubService> findByName(String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<SubService> query = session.createQuery("FROM SubService subService WHERE subService.name=:nameValue");
        query.setParameter("nameValue", name);
        Optional<SubService> subService = Optional.ofNullable(query.uniqueResult());
        transaction.commit();
        session.close();
        return subService;
    }
}
