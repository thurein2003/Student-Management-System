package com;

import com.models.Student;
import com.services.tudentServices;
import com.utils.FileUtil;

import java.util.List;
import java.util.Scanner;

import javax.swing.text.StyleConstants;

public class Main {
    private static final tudentServices studentService = new tudentServices();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        List<Student> loadedStudents = FileUtil.loadFromFile();
        loadedStudents.forEach(studentService::addStudent);

        while (true){
            System.out.println("\n===== Student Management System ======");
            System.out.println("1. Add Student");
            System.out.println("2. List Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.println("Choose an option");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1 -> addStudent();
                case 2 -> listStudent();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                                case 5 -> {
                                    System.out.println("Exiting ...");
                                    FileUtil.saveToFile(studentService.getAllStudent());
                                    System.exit(0);
                                }
                                default -> System.out.println("Invalid choice! Please try again");
                            }
                        }
                    }
                
                    private static Object deleteStudent() {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'deleteStudent'");
                    }
                
                    private static void addStudent(){
        System.out.println("Enter Student ID : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Student Name : ");
        String name = scanner.nextLine();
        System.out.println("Enter Student Age : ");
        int age = scanner.nextInt();

        Student student = new Student(id, name, age);
        studentService.addStudent(student);
        System.out.println("Student added successfully!");
    }

    private static void listStudent(){
        List<Student> students = studentService.getAllStudent();
        if (students.isEmpty()){
            System.out.println("No students found");
        } else {
            students.forEach(System.out::println);
        }
    }

    private static void updateStudent(){
        System.out.println("Enter Student ID to delete");
        int id = scanner.nextInt();

        if(studentService.deleteStudent(id)){
            System.out.println("Student deleted successful");
        } else {
            System.out.println("Student not found");
        }
    }

}
