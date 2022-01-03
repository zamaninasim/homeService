package ir.maktab.config;

import ir.maktab.dao.MainServiceDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfig {
    @Bean
    public MainServiceDao mainServiceDao() {
        return new MainServiceDao();
    }
}
