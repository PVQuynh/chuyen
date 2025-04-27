package com.hust.datn.dto.request;

import lombok.Data;

@Data
public class UserReq {
    private String deviceId;

    private String username;

    private Integer age;

    private Integer coin;

    private String gameName;
}
