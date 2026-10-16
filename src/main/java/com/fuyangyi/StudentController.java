package com.fuyangyi;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentDao dao = new StudentDao();

    // 查所有学生
    @GetMapping
    public List<Student> list() throws Exception {
        return dao.findAll();
    }

    // 按学号查
    @GetMapping("/{id}")
    public Student getById(@PathVariable String id) throws Exception {
        return dao.findById(id);
    }

    // 添加
    @PostMapping
    public String add(@RequestBody Student student) throws Exception {
        if (dao.existsById(student.getId())) {
            return "学号已存在";
        }
        dao.add(student);
        return "添加成功";
    }

    // 删除
    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) throws Exception {
        if (!dao.existsById(id)) {
            return "未找到";
        }
        dao.deleteById(id);
        return "删除成功";
    }
}
