package com.epam.mentoring.UserService.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.epam.mentoring.UserService.convertor.UserMapper;
import com.epam.mentoring.UserService.model.Usser;
import com.epam.mentoring.UserService.model.web.request.UserCreateRequest;
import com.epam.mentoring.UserService.model.web.response.UserResponse;
import com.epam.mentoring.UserService.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserRestControllerImp implements UserRestController{

    private final UserService userService;
    private final UserMapper userMapper;

    @Override
    public ResponseEntity<UserResponse> createUser(UserCreateRequest userCreateRequest) {
        Usser usser = userMapper.convert(userCreateRequest);
        Usser user = userService.createUser(usser);
        UserResponse userResponse = userMapper.convert(user);
        return ResponseEntity.ok(userResponse);
    }
}
