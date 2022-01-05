package ir.maktab.dao;

import ir.maktab.model.entity.users.Customer;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@RequiredArgsConstructor
public class CustomerDao {
    private final SessionFactory sessionFactory;

    public void save(Customer customer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
    }

    public Optional<Customer> findByEmailAddress(String email) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Customer> query = session.createQuery("FROM Customer customer WHERE customer.emailAddress=:emailValue");
        query.setParameter("emailValue", email);
        Optional<Customer> customer = Optional.ofNullable(query.uniqueResult());
        transaction.commit();
        session.close();
        return customer;
    }
}
