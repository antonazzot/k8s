package com.epam.mentoring.UserService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.mentoring.UserService.model.Usser;

public interface UserRepository extends JpaRepository<Usser, Long> {
}
