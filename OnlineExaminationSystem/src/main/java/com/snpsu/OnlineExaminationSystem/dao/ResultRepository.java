package com.snpsu.OnlineExaminationSystem.dao;

import com.snpsu.OnlineExaminationSystem.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {
    List<Result> findByStudentUsername(String studentUsername);
}