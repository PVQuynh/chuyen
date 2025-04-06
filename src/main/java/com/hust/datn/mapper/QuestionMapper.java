package com.hust.datn.mapper;

import com.hust.datn.dto.request.QuestionReq;
import com.hust.datn.dto.response.QuestionRes;
import com.hust.datn.entity.Question;

import java.sql.Timestamp;

public class QuestionMapper {

    public static Question toEntity(QuestionReq questionReq) {
        Question question = new Question();
        question.setTitle(questionReq.getTitle());
        question.setContent(questionReq.getContent());
        question.setImageUrl(questionReq.getImageUrl());
        question.setType(questionReq.getType());
        question.setAge(questionReq.getAge());
        question.setCreateTime(new Timestamp(System.currentTimeMillis()));
        question.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        return question;
    }

    public static QuestionRes toDto(Question question) {
        QuestionRes questionRes = new QuestionRes();
        questionRes.setId(question.getId());
        questionRes.setTitle(question.getTitle());
        questionRes.setContent(question.getContent());
        questionRes.setImageUrl(question.getImageUrl());
        questionRes.setType(question.getType());
        questionRes.setAge(question.getAge());
        questionRes.setCreateTime(question.getCreateTime());
        questionRes.setUpdateTime(question.getUpdateTime());
        return questionRes;
    }
}
