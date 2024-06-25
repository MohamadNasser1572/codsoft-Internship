package com.mycompany.atminterface;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}

public class StudentManagementSys {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();

        while (true) {
            System.out.println("Student Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search for Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStudent(sc, system);
                    break;
                case 2:
                    removeStudent(sc, system);
                    break;
                case 3:
                    searchStudent(sc, system);
                    break;
                case 4:
                    system.displayAllStudents();
                    break;
                case 5:
                    System.out.println("\nExiting Student Management System. Thank you for choosing the Student Management System!");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addStudent(Scanner sc, StudentManagementSystem system) {
        System.out.print("\nEnter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter student roll number: ");
        int rollNumber = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter student grade: ");
        String grade = sc.nextLine();

        Student newStudent = new Student(name, rollNumber, grade);
        system.addStudent(newStudent);
        System.out.println("Student added successfully!\n");
    }

    private static void removeStudent(Scanner sc, StudentManagementSystem system) {
        System.out.print("Enter roll number of the student to remove: ");
        int rollNumber = sc.nextInt();
        sc.nextLine();

        system.removeStudent(rollNumber);
        System.out.println("Student removed successfully!\n");
    }

    private static void searchStudent(Scanner sc, StudentManagementSystem system) {
        System.out.print("Enter roll number of the student to search: ");
        int rollNumber = sc.nextInt();
        sc.nextLine();

        Student foundStudent = system.searchStudent(rollNumber);
        if (foundStudent != null) {
            System.out.println("Student found: " + foundStudent);
        } else {
            System.out.println("Student not found with roll number " + rollNumber + ".");
        }
    }
}
