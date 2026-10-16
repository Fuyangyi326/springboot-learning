package com.fuyangyi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students", produces = "application/json;charset=UTF-8")
public class StudentController {

    @Autowired
    private StudentRepository repo;

    @GetMapping
    public List<Student> list() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable String id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public String add(@RequestBody Student student) {
        if (repo.existsById(student.getId())) {
            return "学号已存在";
        }
        repo.save(student);
        return "添加成功";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable String id, @RequestBody Student student) {
        if (!repo.existsById(id)) {
            return "未找到";
        }
        student.setId(id);
        repo.save(student);
        return "修改成功";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        if (!repo.existsById(id)) {
            return "未找到";
        }
        repo.deleteById(id);
        return "删除成功";
    }
}