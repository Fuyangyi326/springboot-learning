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
        Student s = repo.findById(id).orElse(null);
        if (s == null) {
            throw new BusinessException("学号不存在：" + id);
        }
        return s;
    }

    public void add(Student student) {
        if (repo.existsById(student.getId())) {
            throw new BusinessException("学号已存在：" + student.getId());
        }
        repo.save(student);
    }

    public void update(String id, Student student) {
        if (!repo.existsById(id)) {
            throw new BusinessException("未找到：" + id);
        }
        student.setId(id);
        repo.save(student);
    }

    public void delete(String id) {
        if (!repo.existsById(id)) {
            throw new BusinessException("未找到：" + id);
        }
        repo.deleteById(id);
    }
}