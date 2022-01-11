package ir.maktab.service;

import ir.maktab.config.Config;
import ir.maktab.data.model.entity.services.SubService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SubServiceServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    SubServiceService subServiceService = context.getBean(SubServiceService.class);
    SubService subService;
}
