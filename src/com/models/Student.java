package com.models;

public class Student{
    private int id;
    private String name;
    private int age;


    public Student(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    //Getter Method
    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }
     
    public int getAge(){
        return age;
    }

    //Setter
    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    @Override
    public String toString(){
        return "ID : " + id + ", Name : " + name + ", Age : " + age;
    }


    
}