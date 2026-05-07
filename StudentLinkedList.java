/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagement;

/**
 *
 * @author sambo
 */
public class StudentLinkedList {

    private Node head;
    private int size;

    public StudentLinkedList() {
        head = null;
        size = 0;
    }

    
    public boolean insert(Student student) {

        if (search(student.studentID) != null) {
            System.out.println("Student ID already exists.");
            return false;
        }

        Node newNode = new Node(student);

        if (head == null || student.gpa < head.data.gpa) {
            newNode.next = head;
            head = newNode;
            size++;
            return true;
        }

        Node current = head;

        while (current.next != null &&
               current.next.data.gpa <= student.gpa) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;

        size++;
        return true;
    }

    
    public Student search(int studentID) {

        Node current = head;

        while (current != null) {
            if (current.data.studentID == studentID) {
                return current.data;
            }
            current = current.next;
        }

        return null;
    }

   
    public boolean remove(int studentID) {

        if (head == null) {
            System.out.println("List is empty.");
            return false;
        }

        if (head.data.studentID == studentID) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;

        while (current.next != null &&
               current.next.data.studentID != studentID) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Student not found.");
            return false;
        }

        current.next = current.next.next;
        size--;
        return true;
    }

    
    public int size() {
        return size;
    }

    
    public void displayAll() {

        if (head == null) {
            System.out.println("No students available.");
            return;
        }

        Node current = head;

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

   
    public void top10ByGPA() {

        if (head == null) {
            System.out.println("No students available.");
            return;
        }

        Student[] arr = new Student[size];
        Node current = head;

        int i = 0;
        while (current != null) {
            arr[i++] = current.data;
            current = current.next;
        }

        for (int j = size - 1; j >= 0 && j >= size - 10; j--) {
            System.out.println(arr[j]);
        }
    }

   
    public void top5ByID() {

        if (head == null) {
            System.out.println("No students available.");
            return;
        }

        Student[] arr = new Student[size];
        Node current = head;

        int i = 0;
        while (current != null) {
            arr[i++] = current.data;
            current = current.next;
        }

        for (int a = 0; a < arr.length - 1; a++) {
            for (int b = 0; b < arr.length - a - 1; b++) {
                if (arr[b].studentID < arr[b + 1].studentID) {
                    Student temp = arr[b];
                    arr[b] = arr[b + 1];
                    arr[b + 1] = temp;
                }
            }
        }

        for (int j = 0; j < 5 && j < arr.length; j++) {
            System.out.println(arr[j]);
        }
    }

    
    public void isolateLowGPA(double threshold) {

        if (head == null) {
            System.out.println("No students available.");
            return;
        }

        Node current = head;

        while (current != null) {
            if (current.data.gpa < threshold) {
                System.out.println(current.data);
            }
            current = current.next;
        }
    }
}