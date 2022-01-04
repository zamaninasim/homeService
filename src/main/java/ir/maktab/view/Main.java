package ir.maktab.view;

import java.util.Scanner;

public class Main {
    final static ManagerView managerView = new ManagerView();
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("choose your role:\n1)manager\n2)user\nexpert");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    managerView.managerLogin();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    break;
            }
        }
    }
}
