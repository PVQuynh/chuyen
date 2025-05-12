package com.hust.datn.controller;

import com.hust.datn.dto.request.UpdateUserCoinReq;
import com.hust.datn.dto.request.UserReq;
import com.hust.datn.dto.response.MessageResponse;
import com.hust.datn.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<MessageResponse> addUser(@RequestBody UserReq userReq) {
        MessageResponse messageResponse = new MessageResponse();
        try {
            userService.add(userReq);
            messageResponse.setCode(HttpStatus.OK.value());
            messageResponse.setMessage(HttpStatus.OK.getReasonPhrase());
            return ResponseEntity.ok().body(messageResponse);
        } catch (Exception e) {
            messageResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            messageResponse.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageResponse);
        }
    }

    @PutMapping("update-coin")
    public ResponseEntity<MessageResponse> updateUserCoinReq(@RequestBody UpdateUserCoinReq updateUserCoinReq) {
        MessageResponse messageResponse = new MessageResponse();
        try {
            userService.updateUserCoinReq(updateUserCoinReq);
            messageResponse.setCode(HttpStatus.OK.value());
            messageResponse.setMessage(HttpStatus.OK.getReasonPhrase());
            return ResponseEntity.ok().body(messageResponse);
        } catch (Exception e) {
            messageResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            messageResponse.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageResponse);
        }
    }

    @GetMapping("{deviceId}")
    public ResponseEntity<MessageResponse> getUser(@PathVariable String deviceId) {
        MessageResponse messageResponse = new MessageResponse();
        try {
            messageResponse.setCode(HttpStatus.OK.value());
            messageResponse.setMessage(HttpStatus.OK.getReasonPhrase());
            messageResponse.setData(userService.getByDeviceId(deviceId));
            return ResponseEntity.ok().body(messageResponse);
        } catch (Exception e) {
            messageResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            messageResponse.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageResponse);
        }
    }

    @GetMapping("get-all")
    public ResponseEntity<MessageResponse> getUsers() {
        MessageResponse messageResponse = new MessageResponse();
        try {
            messageResponse.setCode(HttpStatus.OK.value());
            messageResponse.setMessage(HttpStatus.OK.getReasonPhrase());
            messageResponse.setData(userService.getAll());
            return ResponseEntity.ok().body(messageResponse);
        } catch (Exception e) {
            messageResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            messageResponse.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageResponse);
        }
    }

    @PutMapping("{deviceId}")
    public ResponseEntity<MessageResponse> updateUser(
            @PathVariable String deviceId,
            @RequestBody UserReq userReq) {
        MessageResponse messageResponse = new MessageResponse();
        try {
            messageResponse.setCode(HttpStatus.OK.value());
            messageResponse.setMessage(HttpStatus.OK.getReasonPhrase());
            userReq.setDeviceId(deviceId);
            userService.update(userReq);
            return ResponseEntity.ok().body(messageResponse);
        } catch (Exception e) {
            messageResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            messageResponse.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageResponse);
        }
    }

}
