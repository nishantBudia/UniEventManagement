package com.nishant.UniEventManagement.repo;

import com.nishant.UniEventManagement.model.Department;
import com.nishant.UniEventManagement.model.Student;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    @Modifying
    @Query("update Student s set s.department = ?1 where s.studentId = ?2")
    void updateDepartmentByStudentId(Department department, Integer studentId);
}
