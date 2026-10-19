package com.fuyangyi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students", produces = "application/json;charset=UTF-8")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    public Result<List<Student>> list() {
        return Result.success(service.findAll());
    }

    @GetMapping("/{id}")
    public Result<Student> getById(@PathVariable String id) {
        return Result.success(service.findById(id));
    }

    @PostMapping
    public Result<Void> add(@RequestBody Student student) {
        service.add(student);
        return Result.success("添加成功", null);
    }

    @PutMapping("/{id}")
    public Result<Void> update(@PathVariable String id, @RequestBody Student student) {
        service.update(id, student);
        return Result.success("修改成功", null);
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable String id) {
        service.delete(id);
        return Result.success("删除成功", null);
    }
}