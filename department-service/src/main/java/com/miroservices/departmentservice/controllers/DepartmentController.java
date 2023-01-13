package com.miroservices.departmentservice.controllers;

import com.miroservices.departmentservice.models.Department;
import com.miroservices.departmentservice.service.impl.DepartmentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    private final DepartmentServiceImpl departmentService;

    @Autowired
    public DepartmentController(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department) {
        log.info("Saving new Department in saveDepartment method of DepartmentController class.");
        return this.departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId) {
        log.info("Inside findDepartmentById method of DepartmentController class.");
        return this.departmentService.findDepartmentById(departmentId);
    }

}
