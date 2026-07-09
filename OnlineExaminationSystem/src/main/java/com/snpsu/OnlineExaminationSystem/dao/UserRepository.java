package com.snpsu.OnlineExaminationSystem.dao;

import com.snpsu.OnlineExaminationSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);
}