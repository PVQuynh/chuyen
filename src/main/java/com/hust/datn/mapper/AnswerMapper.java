package com.hust.datn.mapper;

import com.hust.datn.dto.request.AnswerReq;
import com.hust.datn.dto.response.AnswerRes;
import com.hust.datn.entity.Answer;

import java.sql.Timestamp;

public class AnswerMapper {
    public static Answer toEntity(AnswerReq answerReq) {
        Answer answer = new Answer();
        answer.setContent(answerReq.getContent());
        answer.setIsCorrect(answerReq.getIsCorrect());
        answer.setCreateTime(new Timestamp(System.currentTimeMillis()));
        answer.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        return answer;
    }

    public static AnswerRes toDto(Answer answer) {
        AnswerRes answerRes = new AnswerRes();
        answerRes.setId(answer.getId());
        answerRes.setContent(answer.getContent());
        answerRes.setIsCorrect(answer.getIsCorrect());
        answerRes.setCreateTime(answer.getCreateTime());
        answerRes.setUpdateTime(answer.getUpdateTime());
        answerRes.setQuestionId(answer.getQuestionId());
        return answerRes;
    }
}
