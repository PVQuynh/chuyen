package com.hust.datn.dto.request;

import com.hust.datn.entity.Answer;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class AnswerReq {
    private String content;

    private Boolean isCorrect;
}
