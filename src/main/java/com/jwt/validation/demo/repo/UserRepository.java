package com.jwt.validation.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.validation.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
