package com.hust.datn.controller;

import com.hust.datn.dto.response.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/index")
public class IndexController {

    @GetMapping
    public ResponseEntity<MessageResponse> index() {
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setCode(HttpStatus.OK.value());
        messageResponse.setMessage(HttpStatus.OK.getReasonPhrase());
        messageResponse.setData("Đồ án của Chuyên");

        return new ResponseEntity<>(messageResponse, HttpStatus.OK);
    }
}

