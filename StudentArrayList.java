/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanager;

/**
 *
 * @author sambo
 */
public class StudentArrayList {

    private Student[] students;
    private int size;

    public StudentArrayList(int capacity) {
        students = new Student[capacity];
        size = 0;
    }

    
    public boolean insert(Student student) {

        if (search(student.studentID) != null) {
            System.out.println("Student ID already exists.");
            return false;
        }

        if (size == students.length) {
            System.out.println("Array is full.");
            return false;
        }

        int position = 0;

        while (position < size &&
               students[position].gpa <= student.gpa) {
            position++;
        }

        for (int i = size; i > position; i--) {
            students[i] = students[i - 1];
        }

        students[position] = student;
        size++;

        return true;
    }

    
    public Student search(int studentID) {

        for (int i = 0; i < size; i++) {

            if (students[i].studentID == studentID) {
                return students[i];
            }
        }

        return null;
    }

  
    public boolean remove(int studentID) {

        if (size == 0) {
            System.out.println("Array is empty.");
            return false;
        }

        int index = -1;

        for (int i = 0; i < size; i++) {

            if (students[i].studentID == studentID) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Student not found.");
            return false;
        }

        for (int i = index; i < size - 1; i++) {
            students[i] = students[i + 1];
        }

        size--;
        return true;
    }

   
    public int size() {
        return size;
    }

    
    public void displayAll() {

        if (size == 0) {
            System.out.println("No students available.");
            return;
        }

        for (int i = 0; i < size; i++) {
            System.out.println(students[i]);
        }
    }

    
    public void top10ByGPA() {

        if (size == 0) {
            System.out.println("No students available.");
            return;
        }

        for (int i = size - 1;
             i >= 0 && i >= size - 10;
             i--) {

            System.out.println(students[i]);
        }
    }

    
    public void top5ByID() {

        if (size == 0) {
            System.out.println("No students available.");
            return;
        }

        Student[] temp = new Student[size];

        for (int i = 0; i < size; i++) {
            temp[i] = students[i];
        }

        for (int a = 0; a < size - 1; a++) {

            for (int b = 0; b < size - a - 1; b++) {

                if (temp[b].studentID <
                    temp[b + 1].studentID) {

                    Student swap = temp[b];
                    temp[b] = temp[b + 1];
                    temp[b + 1] = swap;
                }
            }
        }

        for (int i = 0; i < 5 && i < size; i++) {
            System.out.println(temp[i]);
        }
    }

    
    public void isolateLowGPA(double threshold) {

        if (size == 0) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("Students below GPA " +
                           threshold + ":");

        for (int i = 0; i < size; i++) {

            if (students[i].gpa < threshold) {
                System.out.println(students[i]);
            }
        }
    }
}
