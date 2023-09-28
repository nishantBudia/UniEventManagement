package com.nishant.UniEventManagement.controller;

import com.nishant.UniEventManagement.model.Department;
import com.nishant.UniEventManagement.model.Student;
import com.nishant.UniEventManagement.repo.StudentRepo;
import com.nishant.UniEventManagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentService service;

    /*
    POST
     */

    @PostMapping()
    public String addStudent(@RequestBody @Valid Student student){
        return service.addStudent(student);
    }

    /*
    GET
     */

    @GetMapping()
    public List<Student> getAllStudents(){
        return service.getAllStudents();
    }

    @GetMapping("{id}")
    public Student getStudent(@PathVariable Integer id){
        return service.getStudent(id);
    }

    /*
    PUT
     */

    @PutMapping("{id}/department")
    public String updateStudentDepartment(@RequestParam Department department, @PathVariable Integer id){
        return service.updateStudentDepartment(department,id);
    }

    /*
    DELETE
     */

    @DeleteMapping("{id}")
    public String deleteStudent(@PathVariable Integer id){
        return service.deleteStudent(id);
    }
}
