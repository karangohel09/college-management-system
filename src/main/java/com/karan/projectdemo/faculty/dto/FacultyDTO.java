package com.karan.projectdemo.faculty.dto;

public class FacultyDTO {
    private int id;
    private String name;
    private String subject;
    private int age;
    private int salary;

    public FacultyDTO(int id, String name, String subject, int age, int salary) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.age = age;
        this.salary = salary;
    }

    public FacultyDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
