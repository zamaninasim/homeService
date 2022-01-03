package ir.maktab.config;

import ir.maktab.dao.CommentDao;
import ir.maktab.service.CommentService;
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
}
