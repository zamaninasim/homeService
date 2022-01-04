package ir.maktab.view;

import ir.maktab.exception.InvalidPasswordException;
import ir.maktab.model.entity.users.Manager;
import ir.maktab.service.ManagerService;

import java.util.Scanner;

public class ManagerView {
    final static Scanner scanner = new Scanner(System.in);

    public void managerLogin(ManagerService managerService) {
        try {
            System.out.println("enter your username");
            String username = scanner.nextLine();
            Manager manager = managerService.findByUsername(username);
            System.out.println("enter your password");
            String password = scanner.nextLine();
            if (password.equals(manager.getPassword())) {
                //TODO
            } else {
                throw new InvalidPasswordException("wrong password!");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
