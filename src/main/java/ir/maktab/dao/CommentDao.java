package ir.maktab.dao;

import ir.maktab.model.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CommentDao {
    private final SessionFactory sessionFactory;

    public void save(Comment comment) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(comment);
        transaction.commit();
        session.close();
    }

    public void delete(Comment comment) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(comment);
        transaction.commit();
        session.close();
    }

    public void update(Comment comment) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(comment);
        transaction.commit();
        session.close();
    }

    public Comment findById(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Comment comment = session.get(Comment.class, id);
        transaction.commit();
        session.close();
        return comment;
    }
}
