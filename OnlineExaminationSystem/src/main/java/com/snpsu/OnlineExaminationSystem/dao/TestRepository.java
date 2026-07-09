package com.snpsu.OnlineExaminationSystem.dao;

import com.snpsu.OnlineExaminationSystem.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}