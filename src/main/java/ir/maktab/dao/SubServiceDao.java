package ir.maktab.dao;

import ir.maktab.model.entity.services.SubService;
import lombok.RequiredArgsConstructor;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SubServiceDao {
    private final SessionFactory sessionFactory;

    public void save(SubService subService) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(subService);
        transaction.commit();
        session.close();
    }

    public void update(SubService subService) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(subService);
        transaction.commit();
        session.close();
    }

    public Optional<SubService> findByName(String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<SubService> query = session.createQuery("FROM SubService s WHERE s.name=:nameValue");
        query.setParameter("nameValue", name);
        Optional<SubService> subService = Optional.ofNullable(query.uniqueResult());
        transaction.commit();
        session.close();
        return subService;
    }

    public List<SubService> findAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<SubService> query = session.createQuery("FROM SubService");
        List<SubService> subServices = query.list();
        transaction.commit();
        session.close();
        return subServices;
    }
}
