package ir.maktab.util;

import ir.maktab.model.entity.Comment;
import ir.maktab.model.entity.Suggestion;
import ir.maktab.model.entity.services.MainService;
import ir.maktab.model.entity.services.SubService;
import ir.maktab.model.entity.users.Customer;
import ir.maktab.model.entity.users.Expert;
import ir.maktab.model.entity.users.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    static SessionFactory sessionFactory = null;

    public static SessionFactory buildSessionFactory() {
        Configuration config = new Configuration();
        config.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/home_service");
        config.setProperty("hibernate.connection.username", "root");
        config.setProperty("hibernate.connection.password", "Nasim1374");
        config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");

        config.addAnnotatedClass(MainService.class);
        config.addAnnotatedClass(SubService.class);
        config.addAnnotatedClass(User.class);
        config.addAnnotatedClass(Customer.class);
        config.addAnnotatedClass(Expert.class);
        config.addAnnotatedClass(Comment.class);
        config.addAnnotatedClass(Suggestion.class);

        if (sessionFactory == null) {
            sessionFactory = config.buildSessionFactory();
        }
        return sessionFactory;
    }
}
