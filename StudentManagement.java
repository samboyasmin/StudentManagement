/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentmanagement;

/**
 *
 * @author sambo
 */
import java.util.Scanner;

public class StudentManagement {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        StudentLinkedList system = new StudentLinkedList();

        int choice;

        do {
            System.out.println("\nSTUDENT SYSTEM");
            System.out.println("1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Remove");
            System.out.println("4. Display");
            System.out.println("5. Size");
            System.out.println("6. TOP10 GPA");
            System.out.println("7. TOP5 ID");
            System.out.println("8. Low GPA");
            System.out.println("9. Exit");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("ID: ");
                    int id = input.nextInt();

                    input.nextLine();

                    System.out.print("Name: ");
                    String name = input.nextLine();

                    System.out.print("GPA: ");
                    double gpa = input.nextDouble();

                    system.insert(new Student(id, name, gpa));
                    break;

                case 2:
                    System.out.print("ID: ");
                    int sid = input.nextInt();

                    System.out.println(system.search(sid));
                    break;

                case 3:
                    System.out.print("ID: ");
                    int rid = input.nextInt();

                    system.remove(rid);
                    break;

                case 4:
                    system.displayAll();
                    break;

                case 5:
                    System.out.println(system.size());
                    break;

                case 6:
                    system.top10ByGPA();
                    break;

                case 7:
                    system.top5ByID();
                    break;

                case 8:
                    System.out.print("Threshold: ");
                    double t = input.nextDouble();

                    system.isolateLowGPA(t);
                    break;

                case 9:
                    System.out.println("Exit");
                    break;
            }

        } while (choice != 9);

        input.close();
    }
}
