package ir.maktab.config;

import ir.maktab.dao.CommentDao;
import ir.maktab.dao.CustomerDao;
import ir.maktab.dao.ExpertDao;
import ir.maktab.dao.MainServiceDao;
import ir.maktab.service.CommentService;
import ir.maktab.service.CustomerService;
import ir.maktab.service.ExpertService;
import ir.maktab.service.MainServiceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = DaoConfig.class)
public class ServiceConfig {
    @Bean
    public CommentService commentService(CommentDao commentDao) {
        CommentService commentService = new CommentService();
        commentService.setCommentDao(commentDao);
        return commentService;
    }

    @Bean
    public CustomerService customerService(CustomerDao customerDao) {
        CustomerService customerService = new CustomerService();
        customerService.setCustomerDao(customerDao);
        return customerService;
    }

    @Bean
    public ExpertService expertService(ExpertDao expertDao) {
        ExpertService expertService = new ExpertService();
        expertService.setExpertDao(expertDao);
        return expertService;
    }

    @Bean
    public MainServiceService mainServiceService(MainServiceDao mainServiceDao) {
        MainServiceService mainServiceService = new MainServiceService();
        mainServiceService.setMainServiceDao(mainServiceDao);
        return mainServiceService;
    }

}
