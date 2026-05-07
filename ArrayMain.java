/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanager;

/**
 *
 * @author sambo
 */
import java.util.Scanner;

public class ArrayMain {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        StudentArrayList system =
                new StudentArrayList(100);

        int choice;

        do {

            System.out.println("ARRAY STUDENT SYSTEM");
            System.out.println("1. Insert Student");
            System.out.println("2. Search Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Display Size");
            System.out.println("6. TOP10 by GPA");
            System.out.println("7. TOP5 by ID");
            System.out.println("8. Low GPA Students");
            System.out.println("9. Exit");

            System.out.print("Enter choice: ");
            choice = input.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter ID: ");
                    int id = input.nextInt();

                    input.nextLine();

                    System.out.print("Enter Name: ");
                    String name = input.nextLine();

                    System.out.print("Enter GPA: ");
                    double gpa = input.nextDouble();

                    if (gpa < 0 || gpa > 4) {
                        System.out.println("Invalid GPA.");
                        break;
                    }

                    system.insert(
                        new Student(id, name, gpa)
                    );

                    break;

                case 2:

                    System.out.print("Enter Student ID: ");
                    int searchID = input.nextInt();

                    Student found =
                            system.search(searchID);

                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                case 3:

                    System.out.print("Enter Student ID: ");
                    int removeID = input.nextInt();

                    if (system.remove(removeID)) {
                        System.out.println(
                            "Student removed successfully."
                        );
                    }

                    break;

                case 4:
                    system.displayAll();
                    break;

                case 5:
                    System.out.println(
                        "Size = " + system.size()
                    );
                    break;

                case 6:
                    system.top10ByGPA();
                    break;

                case 7:
                    system.top5ByID();
                    break;

                case 8:

                    System.out.print(
                        "Enter threshold GPA: "
                    );

                    double threshold =
                            input.nextDouble();

                    system.isolateLowGPA(threshold);

                    break;

                case 9:
                    System.out.println(
                        "Program terminated."
                    );
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 9);

        input.close();
    }
}