package com.hust.datn.repository;

import com.hust.datn.entity.Question;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findAllByType(String type, Pageable pageable);

    List<Question> findAllByAge(Integer age, Pageable pageable);

    List<Question> findAllByTypeAndAge(String type, Integer age, Pageable pageable);
}
