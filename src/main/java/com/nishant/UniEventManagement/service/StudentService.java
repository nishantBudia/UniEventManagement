package com.nishant.UniEventManagement.service;


import com.nishant.UniEventManagement.model.Department;
import com.nishant.UniEventManagement.model.Student;
import com.nishant.UniEventManagement.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo repo;

    public String addStudent(Student student){
        return repo.save(student).toString();
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student getStudent(Integer id) {
        return repo.findById(id).get();
    }

    @Transactional
    public String updateStudentDepartment(Department department, Integer id) {
        repo.updateDepartmentByStudentId(department, id);
        return "Success";
    }

    public String deleteStudent(Integer id) {
        repo.deleteById(id);
        return "Success";
    }
}
