package com.fuyangyi;

public class DaoEncodingTest {
    public static void main(String[] args) throws Exception {
        StudentDao dao = new StudentDao();
        for (Student s : dao.findAll()) {
            System.out.println("name = " + s.getName());
            System.out.println("name bytes = " + java.util.Arrays.toString(s.getName().getBytes("UTF-8")));
        }
    }
}