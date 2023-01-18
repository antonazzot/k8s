package com.epam.mentoring.UserService.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.epam.mentoring.UserService.model.web.request.UserCreateRequest;
import com.epam.mentoring.UserService.model.web.request.UserUpdateRequest;
import com.epam.mentoring.UserService.model.web.response.UserResponse;

@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public interface UserRestController {

    @PostMapping
    ResponseEntity<UserResponse> createUser (@RequestBody UserCreateRequest userCreateRequest);
    @GetMapping
    ResponseEntity<UserResponse> getUser (@RequestParam(name = "id") Long id);
    @DeleteMapping
    ResponseEntity<Void> deleteUser (@RequestParam(name = "id") Long id);
    @PutMapping
    ResponseEntity<UserResponse> updateUser (@RequestParam(name = "id") Long id, @RequestBody UserUpdateRequest userUpdateRequest);
}
