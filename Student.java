/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagement;

/**
 *
 * @author sambo
 */
public class Student {
    int studentID;
    String studentName;
    double gpa;

    public Student(int studentID, String studentName, double gpa) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return studentID + " " + studentName + " " + gpa;
    }
}
