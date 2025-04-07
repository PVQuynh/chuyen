package com.hust.datn.service.impl;

import com.hust.datn.dto.response.AnswerUpdateRes;
import com.hust.datn.entity.Answer;
import com.hust.datn.repository.AnswerRepository;
import com.hust.datn.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;
    
    @Override
    public void update(AnswerUpdateRes answerUpdateRes) {
        Answer answer = answerRepository.findById(answerUpdateRes.getId()).orElse(null);

        if (answer != null) {
            if (answerUpdateRes.getContent() != null) {
                answer.setContent(answerUpdateRes.getContent());
            }
            if (answerUpdateRes.getIsCorrect() != null) {
                answer.setIsCorrect(answerUpdateRes.getIsCorrect());
            }
            answerRepository.save(answer);
        }
    }
}
