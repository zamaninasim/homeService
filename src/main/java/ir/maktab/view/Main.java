package ir.maktab.view;

import ir.maktab.config.ServiceConfig;
import ir.maktab.model.builder.MainServiceBuilder;
import ir.maktab.model.entity.services.MainService;
import ir.maktab.service.MainServiceService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    final static ManagerView managerView = new ManagerView();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("choose your role:\n1)manager\n2)user\nexpert");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("enter your username");
                    String username = scanner.nextLine();
                    System.out.println("enter your password");
                    String password = scanner.nextLine();
                    if (username.equals(username) && password.equals(password))
                        break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    break;
            }
        }
        ApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class);
        MainServiceService mainServiceService = context.getBean(MainServiceService.class);
        MainService mainService = MainServiceBuilder.aMainService().withName("Building decoration").build();
        mainServiceService.save(mainService);
        try {
            Boolean building_decoration = mainServiceService.isMainServiceExist("bnkljn");
            System.out.println(building_decoration);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
