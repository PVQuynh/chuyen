package com.hust.datn.service;

import com.hust.datn.dto.request.QuestionReq;
import com.hust.datn.dto.response.QuestionRes;
import com.hust.datn.dto.response.QuestionUpdateRes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuestionService {
    void add(QuestionReq questionReq);

    Page<QuestionRes> getAll(String type, Integer age, Pageable pageable);

    List<QuestionRes> getRandomQuestions();

    void delete(Integer id);

    void update(QuestionUpdateRes questionUpdateRes);

}
