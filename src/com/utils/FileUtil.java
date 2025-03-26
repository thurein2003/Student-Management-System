package com.utils;

import com.models.Student;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    private static final String FILE_NAME = "students.txt";

    public static void saveToFile(List<Student> studentList){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student student : studentList) {
                writer.write(student.getId() + "," + student.getName() + "," + student.getAge() );
                writer.newLine();
            }
        } catch (IOException e){
            System.out.println("Error saying data : " + e.getMessage());
        }
    }

    public static List<Student> loadFromFile(){
        List<Student> studentList = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] data = line.split(",");
                if (data.length == 3){
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    studentList.add(new Student(id, name, age));
                }
            }

        } catch (IOException e){
            System.out.println("No existing data found");
        }
        return studentList;
    }
}
