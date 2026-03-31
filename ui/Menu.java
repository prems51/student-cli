package ui;

import java.util.Scanner;
import service.StudentService;

public class Menu {

    private final Scanner sc = new Scanner(System.in);

    private void exitMsg(int status) {
        if (status == -1) {
            System.out.println("______________THANKS FOR USING______________");
        } else {
            System.out.println("Continuing....");
        }
    }

    // Single reusable method to read any integer safely
    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                int val = sc.nextInt();
                sc.nextLine(); // consume trailing newline
                return val;
            }
            System.out.println("Invalid input. Please enter a number.");
            sc.nextLine(); // discard bad input
        }
    }

    // Read continuation choice (-1 to exit, anything else to continue)
    private int readContinuation() {
        int choice = readInt("ENTER 0 to continue or -1 to exit: ");
        exitMsg(choice);
        return choice;
    }

    public void run() {
        // Pass the shared Scanner into StudentService to avoid multiple Scanner conflicts on System.in
        StudentService s = new StudentService(sc);

        System.out.println("___________________________STUDENT MANAGEMENT CLI___________________________\n");

        int status = 0;
        while (status != -1) {
            System.out.println("\n1: View All students");
            System.out.println("2: Add student");
            System.out.println("3: Search student");
            System.out.println("4: Update student");
            System.out.println("5: Delete student");
            System.out.println("-1: Exit");

            int ch = readInt("\nENTER YOUR CHOICE: ");

            switch (ch) {
                case 1:
                    s.viewAllStudents();
                    status = readContinuation();
                    break;

                case 2:
                    if (s.addStudent())
                        System.out.println("Student added successfully");
                    status = readContinuation();
                    break;

                case 3:
                    int a = readInt("\tEnter 1: Search by Name\n\tEnter 2: Search by ID\n\tYour choice: ");
                    if (a == 1) {
                        System.out.print("\n\t\tEnter Name: ");
                        String name = sc.nextLine(); // safe: no leftover newline after readInt
                        s.searchStudent(name);
                    } else if (a == 2) {
                        int id = readInt("\n\t\tEnter ID: ");
                        s.searchStudent(id);
                    } else {
                        System.out.println("Invalid search option.");
                    }
                    status = readContinuation();
                    break;

                case 4:
                    System.out.println("Functionality under development");
                    status = readContinuation();
                    break;

                case 5:
                    int id = readInt("Enter Student ID: ");
                    s.deleteStudent(id);
                    status = readContinuation();
                    break;

                case -1:
                    status = -1;
                    exitMsg(status);
                    break;

                default:
                    System.out.println("Enter a valid choice.");
                    break;
            }
        }
        
    }
}