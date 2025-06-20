package com.karan.projectdemo.student.dto;

public class StudentDTO {
    private int id;
    private int roll_no;
    private String name;
    private int age;
    private int marks;

    public StudentDTO(int id, int roll_no, String name, int age, int marks) {
        this.id = id;
        this.roll_no = roll_no;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public StudentDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
