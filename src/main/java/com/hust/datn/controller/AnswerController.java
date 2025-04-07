package com.hust.datn.controller;


import com.hust.datn.dto.response.MessageResponse;
import com.hust.datn.dto.response.AnswerUpdateRes;
import com.hust.datn.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/answer")
public class AnswerController {
    private final AnswerService answerService;

    @PutMapping
    public ResponseEntity<MessageResponse> updateAnswer(@RequestBody AnswerUpdateRes answerUpdateRes) {
        MessageResponse messageResponse = new MessageResponse();
        try {
            answerService.update(answerUpdateRes);
            messageResponse.setCode(HttpStatus.OK.value());
            messageResponse.setMessage(HttpStatus.OK.getReasonPhrase());
            return ResponseEntity.ok().body(messageResponse);
        } catch (Exception e) {
            messageResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            messageResponse.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageResponse);
        }
    }
}
