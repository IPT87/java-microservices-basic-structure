package com.miroservices.departmentservice.service.impl;

import com.miroservices.departmentservice.models.Department;
import com.miroservices.departmentservice.repository.DepartmentRepository;
import com.miroservices.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department saveDepartment(Department department) {
        log.info("Inside saveDepartment method of DepartmentServiceImpl class.");
        return this.departmentRepository.save(department);
    }

    @Override
    public Department findDepartmentById(Long departmentId) {
        return this.departmentRepository.findDepartmentById(departmentId);
    }
}
