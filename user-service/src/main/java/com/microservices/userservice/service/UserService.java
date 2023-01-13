package com.microservices.userservice.service;

import com.microservices.userservice.model.User;
import com.microservices.userservice.vo.ResponseTemplateVO;

public interface UserService {
    User saveUser(User user);
    ResponseTemplateVO getUserWithDepartment(Long userId);
}
