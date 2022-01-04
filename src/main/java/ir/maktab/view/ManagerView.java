package ir.maktab.view;

import ir.maktab.config.ServiceConfig;
import ir.maktab.exception.InvalidPasswordException;
import ir.maktab.model.builder.MainServiceBuilder;
import ir.maktab.model.builder.SubServiceBuilder;
import ir.maktab.model.entity.services.MainService;
import ir.maktab.model.entity.services.SubService;
import ir.maktab.model.entity.users.Manager;
import ir.maktab.service.MainServiceService;
import ir.maktab.service.ManagerService;
import ir.maktab.service.SubServiceService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class ManagerView {
    final static Scanner scanner = new Scanner(System.in);
    ApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class);
    ManagerService managerService = context.getBean(ManagerService.class);
    MainServiceService mainServiceService = context.getBean(MainServiceService.class);
    SubServiceService subServiceService = context.getBean(SubServiceService.class);

    public void managerLogin() {
        try {
            System.out.println("enter your username");
            String username = scanner.nextLine();
            Manager manager = managerService.findByUsername(username);
            System.out.println("enter your password");
            String password = scanner.nextLine();
            if (password.equals(manager.getPassword())) {
                //TODO
                System.out.println("1)add maniService\n2)addSubService");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addMainService();
                        break;
                    case 2:
                        addSubService();
                }
            } else {
                throw new InvalidPasswordException("wrong password!");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private void addMainService() {
        System.out.println("enter main service name:");
        String mainServiceName = scanner.nextLine();
        try {
            mainServiceService.isMainServiceExist(mainServiceName);
            System.out.println("this main service is exist");
        } catch (RuntimeException e) {
            MainService mainService = MainServiceBuilder.aMainService().withName(mainServiceName).build();
            mainServiceService.save(mainService);
        }
    }

    private void addSubService() {
        System.out.println("enter main service name:");
        String mainServiceName = scanner.nextLine();
        try {
            MainService mainService = mainServiceService.isMainServiceExist(mainServiceName);
            System.out.println("enter sub service name:");
            String name = scanner.nextLine();
            subServiceService.isSubServiceExist(name);
            System.out.println("basePrice:");
            long basePrice = Long.parseLong(scanner.nextLine());
            System.out.println("description:");
            String description = scanner.nextLine();
            SubService subService = SubServiceBuilder
                    .aSubService()
                    .withName(name)
                    .withBasePrice(basePrice)
                    .withDescription(description)
                    .withMainService(mainService)
                    .build();
            subServiceService.save(subService);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
