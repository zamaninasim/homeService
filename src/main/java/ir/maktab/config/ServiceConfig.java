package ir.maktab.config;

import ir.maktab.dao.*;
import ir.maktab.service.*;
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

    @Bean
    public ManagerService managerService(ManagerDao managerDao) {
        ManagerService managerService = new ManagerService();
        managerService.setManagerDao(managerDao);
        return managerService;
    }

    @Bean
    public OrderService orderService(OrderDao orderDao) {
        OrderService orderService = new OrderService();
        orderService.setOrderDao(orderDao);
        return orderService;
    }

    @Bean
    public SubServiceService subServiceService(SubServiceDao subServiceDao) {
        SubServiceService subServiceService = new SubServiceService();
        subServiceService.setSubServiceDao(subServiceDao);
        return subServiceService;
    }

    @Bean
    public SuggestionService suggestionService(SuggestionDao suggestionDao) {
        SuggestionService suggestionService = new SuggestionService();
        suggestionService.setSuggestionDao(suggestionDao);
        return suggestionService;
    }

}
