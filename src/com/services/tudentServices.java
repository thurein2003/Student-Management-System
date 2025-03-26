package com.services;

import com.models.Student;
import java.util.ArrayList;
import java.util.List;

public class tudentServices {
    private List<Student> studentList = new ArrayList<>();

    public void addStudent(Student student){
        studentList.add(student);
    }

    public List<Student> getAllStudent(){
        return studentList;
    }

    public boolean updateStudent(int id, String name, int age){
        for (Student student : studentList){
            if (student.getId() == id){
                student.setName(name);
                student.setAge(age);
                return true;
            }
        }
        return false;
    }

    public boolean deleteStudent(int id){
        return studentList.removeIf(student -> student.getId() == id);
    }
}
