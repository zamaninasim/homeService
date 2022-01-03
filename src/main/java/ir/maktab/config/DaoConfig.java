package ir.maktab.config;

import ir.maktab.dao.*;
import ir.maktab.model.entity.services.SubService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfig {

    @Bean
    public CommentDao commentDao() {
        return new CommentDao();
    }

    @Bean
    public CustomerDao customerDao() {
        return new CustomerDao();
    }

    @Bean
    public ExpertDao expertDao() {
        return new ExpertDao();
    }

    @Bean
    public MainServiceDao mainServiceDao() {
        return new MainServiceDao();
    }

    @Bean
    public OrderDao orderDao() {
        return new OrderDao();
    }

    @Bean
    public SubServiceDao subServiceDao() {
        return new SubServiceDao();
    }

    @Bean
    public SuggestionDao suggestionDao() {
        return new SuggestionDao();
    }
}
