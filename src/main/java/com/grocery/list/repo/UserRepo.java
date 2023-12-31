package com.grocery.list.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grocery.list.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
    void deleteUserById(Long id);

    Optional<User> findUserById(Long id);
}
