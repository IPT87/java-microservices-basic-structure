package com.miroservices.departmentservice.repository;

import com.miroservices.departmentservice.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findDepartmentById(Long departmentId);
}
