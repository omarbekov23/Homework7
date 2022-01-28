package peaksoft;

import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;

import java.util.Scanner;

public class Main {
    static UserServiceImpl userService = new UserServiceImpl();
    static Scanner scanner = new Scanner(System.in);
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                sout();
                System.out.println();
                int num = sc.nextInt();
                if (num == 1) {
                    userService.createUsersTable();
                }
                if (num == 2) {
                    userService.dropUsersTable();
                }
                if (num == 3) {
                    System.out.println("Enter information");
                    System.out.print("name:");
                    String name = scanner.nextLine();
                    System.out.print("last_Name:");
                    String last_Name = scanner.nextLine();
                    System.out.print("age:");
                    byte age = sc.nextByte();
                    System.out.println("");
                    userService.saveUser(name, last_Name, age);
                }
                if (num == 4) {
                    System.out.print("Enter id to delete via id:");
                    long id = sc.nextLong();
                    userService.removeUserById(id);
                }
                if (num == 5) {
                    System.out.println(userService.getAllUsers());
                }
                if (num == 6) {
                    userService.cleanUsersTable();
                } else {
                    System.out.println("");
                }
            }catch (ArithmeticException a){
                System.out.println("Sorry, you entered the wrong number, please try again!!!\n");
                sout();
            }
        }
    }
    public static void sout(){
        System.out.println("Press 1 to create table:");
        System.out.println("Press 2 to delete table:");
        System.out.println("Press 3 to save the table:");
        System.out.println("Press 4 to delete table by id:");
        System.out.println("Press 5 to show the table:");
        System.out.println("Press 5 to clear the table:");
    }
}
