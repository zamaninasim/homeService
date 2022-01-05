package ir.maktab.dao;

import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CommentDao {
    private final SessionFactory sessionFactory;
}
