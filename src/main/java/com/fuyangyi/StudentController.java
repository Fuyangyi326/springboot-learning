package com.fuyangyi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students", produces = "application/json;charset=UTF-8")
public class StudentController {

    @Autowired
    private StudentService service;          // ← 改成 service

    @GetMapping
    public List<Student> list() {
        return service.findAll();            // ← repo 改成 service
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable String id) {
        return service.findById(id);         // ← repo 改成 service
    }

    @PostMapping
    public String add(@RequestBody Student student) {
        if (service.existsById(student.getId())) {   // ← repo 改成 service
            return "学号已存在";
        }
        service.save(student);                       // ← repo 改成 service
        return "添加成功";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable String id, @RequestBody Student student) {
        if (!service.existsById(id)) {               // ← repo 改成 service
            return "未找到";
        }
        student.setId(id);
        service.save(student);                       // ← repo 改成 service
        return "修改成功";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        if (!service.existsById(id)) {               // ← repo 改成 service
            return "未找到";
        }
        service.deleteById(id);                      // ← repo 改成 service
        return "删除成功";
    }
}