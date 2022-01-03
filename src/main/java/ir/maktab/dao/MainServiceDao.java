package ir.maktab.dao;

import ir.maktab.model.entity.services.MainService;
import ir.maktab.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MainServiceDao {
    private SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();

    public void save(MainService mainService) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(mainService);
        transaction.commit();
        session.close();
    }
}
