package com.microservices.userservice.service.impl;

import com.microservices.userservice.model.User;
import com.microservices.userservice.repository.UserRepository;
import com.microservices.userservice.service.UserService;
import com.microservices.userservice.vo.Department;
import com.microservices.userservice.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public User saveUser(User user) {
        log.info("Inside saveUser method of UserServiceImpl class.");
        return this.userRepository.save(user);
    }

    @Override
    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment method of UserServiceImpl class.");

        User user = this.userRepository.getUserById(userId);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);

        ResponseTemplateVO vo = new ResponseTemplateVO();
        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }

}
