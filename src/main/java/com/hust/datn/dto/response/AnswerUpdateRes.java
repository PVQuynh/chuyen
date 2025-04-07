package com.hust.datn.dto.response;

import lombok.Data;

@Data
public class AnswerUpdateRes {
    private Integer id;

    private String content;

    private Boolean isCorrect;
}
