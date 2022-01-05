package ir.maktab.dao;

import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SuggestionDao {
    private final SessionFactory sessionFactory;
}
