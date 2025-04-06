package com.hust.datn.dto.response;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class QuestionRes {
    private Integer id;

    private String title;

    private String content;

    private String imageUrl;

    private String type;

    private Integer age;

    private Timestamp createTime;

    private Timestamp updateTime;

    private List<AnswerRes> answers;
}
