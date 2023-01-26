package com.epam.mentoring.UserService.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.epam.mentoring.UserService.model.web.request.UserCreateRequest;
import com.epam.mentoring.UserService.model.web.request.UserUpdateRequest;
import com.epam.mentoring.UserService.model.web.request.feign.CreateUserPost;
import com.epam.mentoring.UserService.model.web.response.UserResponse;

@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public interface UserRestController {

    @PostMapping
    ResponseEntity<UserResponse> createUser (@RequestBody UserCreateRequest userCreateRequest);
    @PostMapping(value = "/createpost")
    void createPost (@RequestBody CreateUserPost createUserPost);
    @PostMapping(value = "/deletepost")
    void deletePost (@RequestBody CreateUserPost createUserPost);
    @GetMapping
    ResponseEntity<UserResponse> getUser (@RequestParam(name = "id") Long id);
    @GetMapping("/all")
    ResponseEntity<List<UserResponse>> getAllUser ();
    @DeleteMapping
    ResponseEntity<Void> deleteUser (@RequestParam(name = "id") Long id);
    @PutMapping
    ResponseEntity<UserResponse> updateUser (@RequestParam(name = "id") Long id, @RequestBody UserUpdateRequest userUpdateRequest);
}
