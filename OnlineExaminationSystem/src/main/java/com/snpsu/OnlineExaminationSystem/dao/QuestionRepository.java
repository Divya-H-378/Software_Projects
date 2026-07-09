package com.snpsu.OnlineExaminationSystem.dao;

import com.snpsu.OnlineExaminationSystem.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByTestId(Long testId);
}