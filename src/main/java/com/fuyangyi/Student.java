package com.fuyangyi;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

    @Id
    private String id;
    private String name;
    private int age;
    private int score;

    public Student() {}

    public Student(String id, String name, int age, int score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public void introduce() {
        System.out.println("学号：" + id + "，姓名：" + name + "，年龄：" + age + "，成绩：" + score);
    }
}