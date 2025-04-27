package com.hust.datn.service.impl;

import com.hust.datn.dto.request.QuestionReq;
import com.hust.datn.dto.response.AnswerRes;
import com.hust.datn.dto.response.QuestionRes;
import com.hust.datn.dto.response.QuestionUpdateRes;
import com.hust.datn.entity.Answer;
import com.hust.datn.entity.Question;
import com.hust.datn.mapper.AnswerMapper;
import com.hust.datn.mapper.QuestionMapper;
import com.hust.datn.repository.AnswerRepository;
import com.hust.datn.repository.QuestionRepository;
import com.hust.datn.service.QuestionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    @Transactional
    @Override
    public void add(QuestionReq questionReq) {
        Question question = QuestionMapper.toEntity(questionReq);
        Question savedQuestion = questionRepository.save(question);

        List<Answer> answers = questionReq.getAnswerReqs()
                .stream()
                .map(answerReq -> {
                    Answer answer = AnswerMapper.toEntity(answerReq);
                    answer.setQuestionId(savedQuestion.getId());
                    return answer;
                })
                .toList();
        answerRepository.saveAll(answers);
    }

    @Override
    public Page<QuestionRes> getAll(String type, Integer age, Pageable pageable) {
        // Lấy ra questions
        List<Question> questions;
        if (type != null && age != null) {
            questions = questionRepository.findAllByTypeAndAge(type, age, pageable);
        } else if (type != null) {
            questions = questionRepository.findAllByType(type, pageable);
        } else if (age != null) {
            questions = questionRepository.findAllByAge(age, pageable);
        } else {
            questions = questionRepository.findAll();
        }
        List<QuestionRes> questionReses = questions
                .stream()
                .map(QuestionMapper::toDto)
                .toList();

        // Lấy ra answers của question
        for (QuestionRes questionRes : questionReses) {
            List<Answer> answers = answerRepository.findAllByQuestionId(questionRes.getId());
            List<AnswerRes> answerReses = answers
                    .stream()
                    .map(AnswerMapper::toDto)
                    .toList();
            questionRes.setAnswers(answerReses);
        }

        return new PageImpl<>(questionReses, pageable, questions.size());
    }

    @Override
    public List<QuestionRes> getRandomQuestions() {
        // Lấy ra questions
        List<Question> questions = questionRepository.findRandomQuestions();
        List<QuestionRes> questionReses = questions
                .stream()
                .map(QuestionMapper::toDto)
                .toList();

        // Lấy ra answers của question
        for (QuestionRes questionRes : questionReses) {
            List<Answer> answers = answerRepository.findAllByQuestionId(questionRes.getId());
            List<AnswerRes> answerReses = answers
                    .stream()
                    .map(AnswerMapper::toDto)
                    .toList();
            questionRes.setAnswers(answerReses);
        }

        return questionReses;
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        List<Answer> answers = answerRepository.findAllByQuestionId(id);
        questionRepository.deleteById(id);
        answerRepository.deleteAll(answers);
    }

    @Override
    public void update(QuestionUpdateRes questionUpdateRes) {
        Question question = questionRepository.findById(questionUpdateRes.getId()).orElse(null);

        if (question != null) {
            if (questionUpdateRes.getType() != null) {
                question.setTitle(questionUpdateRes.getType());
            }
            if (questionUpdateRes.getContent() != null) {
                question.setContent(questionUpdateRes.getContent());
            }
            if (questionUpdateRes.getImageUrl() != null) {
                question.setImageUrl(questionUpdateRes.getImageUrl());
            }
            if (questionUpdateRes.getType() != null) {
                question.setType(questionUpdateRes.getType());
            }
            if (questionUpdateRes.getAge() != null) {
                question.setAge(questionUpdateRes.getAge());
            }
            questionRepository.save(question);
        }
    }

}
