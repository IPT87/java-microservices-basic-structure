package com.microservices.userservice.controller;

import com.microservices.userservice.model.User;
import com.microservices.userservice.service.impl.UserServiceImpl;
import com.microservices.userservice.vo.Department;
import com.microservices.userservice.vo.ResponseTemplateVO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser method of UserController class.");
        return this.userService.saveUser(user);
    }

    @GetMapping("/{id}")
    @CircuitBreaker(name = "callDepartmentService", fallbackMethod = "departmentServiceFallBack")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("Inside getUserWithDepartment method of UserController class.");
        return this.userService.getUserWithDepartment(userId);
    }

    public ResponseTemplateVO departmentServiceFallBack(Exception e) {
        System.out.println("Department Service is taking longer than expected. Please try again later.");
        User user = new User(0L, "", "", "", 0L);
        Department department = new Department(0L, "", "", "");
        return new ResponseTemplateVO(user, department);
    }

}
