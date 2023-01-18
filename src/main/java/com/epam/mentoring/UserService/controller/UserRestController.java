package com.epam.mentoring.UserService.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.mentoring.UserService.model.web.request.UserCreateRequest;
import com.epam.mentoring.UserService.model.web.response.UserResponse;

@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public interface UserRestController {

    @PostMapping
    ResponseEntity<UserResponse> createUser (@RequestBody UserCreateRequest userCreateRequest);
}
