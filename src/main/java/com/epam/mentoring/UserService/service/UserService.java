package com.epam.mentoring.UserService.service;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.epam.mentoring.UserService.model.Usser;
import com.epam.mentoring.UserService.model.web.response.UserResponse;
import com.epam.mentoring.UserService.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Usser createUser(Usser usser) {
        return userRepository.save(usser);
    }

    public Usser getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found"));
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public Usser saveUser(Usser usser) {
      return   userRepository.save(usser);
    }

    public List<Usser> getAllUsers() {
        return userRepository.findAll();
    }
}
