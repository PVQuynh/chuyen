package com.hust.datn.dto.request;

import lombok.Data;

@Data
public class UpdateUserCoinReq {
    private String deviceId;

    private Integer coin;
}
