package com.hust.datn.dto.response;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserRes {
    private String deviceId;

    private String username;

    private Integer age;

    private Integer coin;

    private String gameName;

    private Timestamp createTime;

    private Timestamp updateTime;
}
