package ir.maktab.view;

import ir.maktab.config.ServiceConfig;
import ir.maktab.model.builder.MainServiceBuilder;
import ir.maktab.model.entity.services.MainService;
import ir.maktab.service.MainServiceService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class);
        MainServiceService mainServiceService = context.getBean(MainServiceService.class);
        MainService mainService = MainServiceBuilder.aMainService().withName("Building decoration").build();
        mainServiceService.save(mainService);
    }
}
