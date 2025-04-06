package com.hust.datn.controller;


import com.hust.datn.dto.request.QuestionReq;
import com.hust.datn.dto.response.MessageResponse;
import com.hust.datn.dto.response.QuestionRes;
import com.hust.datn.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping
    public ResponseEntity<MessageResponse> addQuestion(@RequestBody QuestionReq questionReq) {
        MessageResponse messageResponse = new MessageResponse();
        questionService.add(questionReq);
        messageResponse.setCode(HttpStatus.OK.value());
        messageResponse.setMessage(HttpStatus.OK.getReasonPhrase());
        return ResponseEntity.ok().body(messageResponse);
    }

    @GetMapping
    public ResponseEntity<MessageResponse> getQuestion(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size) {
        MessageResponse messageResponse = new MessageResponse();
        Pageable pageable =  PageRequest.of(page, size);
        Page<QuestionRes> questionRes = questionService.getAll(type, age, pageable);
        messageResponse.setCode(HttpStatus.OK.value());
        messageResponse.setMessage(HttpStatus.OK.getReasonPhrase());
        messageResponse.setData(questionRes);
        return ResponseEntity.ok().body(messageResponse);
    }
}
