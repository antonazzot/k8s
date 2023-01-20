package com.epam.mentoring.UserService.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.epam.mentoring.UserService.convertor.UserMapper;
import com.epam.mentoring.UserService.model.Usser;
import com.epam.mentoring.UserService.model.web.request.UserCreateRequest;
import com.epam.mentoring.UserService.model.web.request.UserUpdateRequest;
import com.epam.mentoring.UserService.model.web.request.feign.CreateUserPost;
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

    @Override
    public void createPost(CreateUserPost createUserPost) {
        Usser userById = userService.getUserById(createUserPost.getAuthorId());
        if (userById.getAmountOfPosts() == null) {
            userById.setAmountOfPosts(String.valueOf(1L));
        } else {
            userById.setAmountOfPosts(String.valueOf(Long.parseLong(userById.getAmountOfPosts()) + 1L));
        }
        userService.saveUser(userById);
    }

    @Override
    public void deletePost(CreateUserPost createUserPost) {
        Usser userById = userService.getUserById(createUserPost.getAuthorId());
        if (userById.getAmountOfPosts() != null) {
            userById.setAmountOfPosts(String.valueOf(Long.parseLong(userById.getAmountOfPosts()) - 1L));
        }
        userService.saveUser(userById);
    }

    @Override
    public ResponseEntity<UserResponse> getUser(Long id) {
        UserResponse userResponse = userMapper.convert(userService.getUserById(id));
        return ResponseEntity.ok(userResponse);
    }

    @Override
    public ResponseEntity<Void> deleteUser(Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<UserResponse> updateUser(Long id, UserUpdateRequest userUpdateRequest) {
        Usser user = userService.getUserById(id);
        Usser usser = userMapper.updateUser(userUpdateRequest, user);
        return ResponseEntity.ok(userMapper.convert(userService.saveUser(usser)));
    }
}
