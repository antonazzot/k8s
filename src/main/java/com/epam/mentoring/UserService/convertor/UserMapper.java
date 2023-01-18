package com.epam.mentoring.UserService.convertor;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.epam.mentoring.UserService.model.Usser;
import com.epam.mentoring.UserService.model.web.request.UserCreateRequest;
import com.epam.mentoring.UserService.model.web.request.UserUpdateRequest;
import com.epam.mentoring.UserService.model.web.response.UserResponse;

@Mapper(componentModel = "spring")
public interface UserMapper {
    Usser convert (UserCreateRequest userCreateRequest);
    UserResponse convert (Usser usser);
    Usser updateUser(UserUpdateRequest userUpdateRequest, @MappingTarget Usser usser);
}
