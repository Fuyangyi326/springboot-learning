package com.fuyangyi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    private static final String URL = "jdbc:mysql://localhost:3306/students_db?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // 获取连接
    private Connection getConnection() throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        conn.createStatement().execute("SET NAMES utf8mb4");
        return conn;
    }

    // 查询所有学生
    public List<Student> findAll() throws Exception {
        List<Student> list = new ArrayList<>();
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM student");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            list.add(new Student(
                    rs.getString("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getInt("score")
            ));
        }

        rs.close();
        ps.close();
        conn.close();
        return list;
    }

    // 按学号查询
    public Student findById(String id) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM student WHERE id = ?");
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();

        Student s = null;
        if (rs.next()) {
            s = new Student(
                    rs.getString("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getInt("score")
            );
        }

        rs.close();
        ps.close();
        conn.close();
        return s;
    }

    // 添加学生
    public void add(Student s) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO student (id, name, age, score) VALUES (?, ?, ?, ?)"
        );
        ps.setString(1, s.getId());
        ps.setString(2, s.getName());
        ps.setInt(3, s.getAge());
        ps.setInt(4, s.getScore());
        ps.executeUpdate();

        ps.close();
        conn.close();
    }

    // 删除学生
    public void deleteById(String id) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM student WHERE id = ?");
        ps.setString(1, id);
        ps.executeUpdate();

        ps.close();
        conn.close();
    }

    // 判断学号是否存在
    public boolean existsById(String id) throws Exception {
        return findById(id) != null;
    }
}