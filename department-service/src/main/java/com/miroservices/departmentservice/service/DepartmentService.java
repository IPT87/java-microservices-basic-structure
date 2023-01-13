package com.miroservices.departmentservice.service;

import com.miroservices.departmentservice.models.Department;

public interface DepartmentService {
    Department saveDepartment(Department department);
    Department findDepartmentById(Long departmentId);
}
