package ir.maktab.dao;

import ir.maktab.model.entity.services.SubService;
import lombok.RequiredArgsConstructor;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List<SubService> findAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<SubService> query = session.createQuery("FROM SubService");
        List<SubService> subServices = query.list();
        transaction.commit();
        session.close();
        return subServices;
    }

    public List<SubService> findByName(String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(SubService.class, "s");
        criteria.setFetchMode("experts", FetchMode.EAGER);
        criteria.add(Restrictions.eq("s.name", name));
        List<SubService> subServiceList = criteria.list();
        transaction.commit();
        session.close();
        return subServiceList;
    }

    public void delete(SubService subService) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(subService);
        transaction.commit();
        session.close();
    }

    public SubService findById(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        SubService subService = session.get(SubService.class, id);
        transaction.commit();
        session.close();
        return subService;
    }
}
