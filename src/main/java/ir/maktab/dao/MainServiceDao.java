package ir.maktab.dao;

import ir.maktab.model.entity.services.MainService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@RequiredArgsConstructor
public class MainServiceDao {
    private final SessionFactory sessionFactory;

    public void save(MainService mainService) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(mainService);
        transaction.commit();
        session.close();
    }
    public Optional<MainService> findByName(String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<MainService> query = session.createQuery("FROM MainService mainService WHERE mainService.name=:nameValue");
        query.setParameter("nameValue", name);
        Optional<MainService> mainService = Optional.ofNullable(query.uniqueResult());
        transaction.commit();
        session.close();
        return mainService;
    }
}
