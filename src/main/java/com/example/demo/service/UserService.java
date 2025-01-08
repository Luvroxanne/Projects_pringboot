package com.example.demo.service;

import com.example.demo.model.LoginRequest;
import com.example.demo.model.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public LoginResponse login(LoginRequest request) {
        LoginResponse response = new LoginResponse();

        // 这里添加基本的登录逻辑
        if ("admin".equals(request.getUsername()) && "password".equals(request.getPassword())) {
            response.setCode(200);
            response.setMessage("登录成功");
            response.setToken("dummy-token");
            response.setUsername(request.getUsername());
        } else {
            response.setCode(401);
            response.setMessage("用户名或密码错误");
        }

        return response;
    }
}