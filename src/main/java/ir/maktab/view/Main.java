package ir.maktab.view;

import java.util.Scanner;

public class Main {
    final static ManagerView managerView = new ManagerView();
    final static CustomerView customerView = new CustomerView();
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("choose your role:\n1)manager\n2)Customer\n3)expert");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    managerView.managerLogin();
                    break;
                case 2:
                    System.out.println("1)login\n2)signUp");
                    choice = Integer.parseInt(scanner.nextLine());
                    switch (choice){
                        case 1:
                            customerView.customerLogin();
                            break;
                        case 2:
                            break;
                    }
                    break;
                case 3:
                    break;
                default:
                    break;
            }
        }
    }
}
