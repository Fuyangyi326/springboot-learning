package com.fuyangyi;
public class Student {
    private String id;
    private String name;
    private int age;
    private int score;

    public Student(String id, String name, int age, int score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public int getScore() { return score; }

    public void setName(String name) { this.name = name; }

    public void setAge(int age) {
        if (age < 0 || age > 150) {
            System.out.println("年龄不合法：" + age);
            return;
        }
        this.age = age;
    }

    public void setScore(int score) {
        if (score < 0 || score > 100) {
            System.out.println("成绩不合法：" + score);
            return;
        }
        this.score = score;
    }

    public void introduce() {
        System.out.println("学号：" + id + "，姓名：" + name + "，年龄：" + age + "，成绩：" + score);
    }
}