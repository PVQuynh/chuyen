package com.hust.datn.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class QuestionReq {
    private String title;

    private String content;

    private String imageUrl;

    private String type;

    private Integer age;

    private List<AnswerReq> answerReqs;
}
