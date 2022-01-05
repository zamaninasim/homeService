package ir.maktab.view;

import ir.maktab.config.ServiceConfig;
import ir.maktab.validation.exception.InvalidPasswordException;
import ir.maktab.model.builder.ExpertBuilder;
import ir.maktab.model.entity.users.Expert;
import ir.maktab.model.enumeration.UserStatus;
import ir.maktab.service.ExpertService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class ExpertView {
    final static Scanner scanner = new Scanner(System.in);
    ApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class);
    ExpertService expertService = context.getBean(ExpertService.class);

    public void expertLogin() {
        try {
            System.out.println("enter your emailAddress:");
            String emailAddress = scanner.nextLine();
            Expert expert = expertService.findByEmailAddress(emailAddress);
            UserStatus userStatus = expert.getUserStatus();
            if (userStatus.equals(UserStatus.WAITING)) {
                System.out.println("Your account is awaiting approval.");
            } else {
                System.out.println("enter your password");
                String password = scanner.nextLine();
                if (password.equals(expert.getPassword())) {
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
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void expertSignUp() {
        try {
            System.out.println("enter your info :(firstname,lastname,emailAddress,password):");
            String info = scanner.nextLine();
            String[] splitInfo = info.split(",");
            String firstname = splitInfo[0];
            String lastname = splitInfo[1];
            String emailAddress = splitInfo[2];
            String password = splitInfo[3];
            expertService.isExist(emailAddress);
            //TODO upload Photo
            Expert expert = ExpertBuilder.anExpert()
                    .withFirstname(firstname)
                    .withLastname(lastname)
                    .withEmailAddress(emailAddress)
                    .withPassword(password)
                    .withCredit(0L)
                    .withUserStatus(UserStatus.NEW)
                    .withScore(5.0)
                    .build();
            expertService.save(expert);

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
