package com.epam.mentoring.UserService.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.epam.mentoring.UserService.model.Usser;
import com.epam.mentoring.UserService.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Usser createUser(Usser usser) {
        return userRepository.save(usser);
    }
}
