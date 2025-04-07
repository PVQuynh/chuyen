package com.hust.datn.dto.response;

import lombok.Data;

@Data
public class QuestionUpdateRes {
    private Integer id;

    private String title;

    private String content;

    private String imageUrl;

    private String type;

    private Integer age;
}
