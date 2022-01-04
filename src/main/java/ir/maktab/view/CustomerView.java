package ir.maktab.view;

import ir.maktab.config.ServiceConfig;
import ir.maktab.exception.InvalidPasswordException;
import ir.maktab.model.entity.users.Customer;
import ir.maktab.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class CustomerView {
    final static Scanner scanner = new Scanner(System.in);
    ApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class);
    CustomerService customerService = context.getBean(CustomerService.class);

    public void customerLogin() {
        try {
            System.out.println("enter your emailAddress:");
            String emailAddress = scanner.nextLine();
            Customer customer = customerService.findByEmailAddress(emailAddress);
            System.out.println("enter your password");
            String password = scanner.nextLine();
            if (password.equals(customer.getPassword())) {
                //TODO
                System.out.println("1)\n2)");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        break;
                    case 2:
                }
            } else {
                throw new InvalidPasswordException("wrong password!");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
