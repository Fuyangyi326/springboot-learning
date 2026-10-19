package com.fuyangyi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public List<Student> findAll() {
        return repo.findAll();
    }

    public Student findById(String id) {
        return repo.findById(id).orElse(null);
    }

    public boolean existsById(String id) {
        return repo.existsById(id);
    }

    public Student save(Student student) {
        return repo.save(student);
    }

    public void deleteById(String id) {
        repo.deleteById(id);
    }
}