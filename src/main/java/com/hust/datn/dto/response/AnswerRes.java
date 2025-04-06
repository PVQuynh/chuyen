package com.hust.datn.dto.response;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class AnswerRes {

    private Integer id;

    private String content;

    private Boolean isCorrect;

    private Timestamp createTime;

    private Timestamp updateTime;

    private int questionId;
}
