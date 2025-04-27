package com.hust.datn.service;

import com.hust.datn.dto.request.UpdateUserCoinReq;
import com.hust.datn.dto.request.UserReq;
import com.hust.datn.dto.response.UserRes;

public interface UserService {

    void add(UserReq userReq);

    UserRes getByDeviceId(String deviceId);

    void updateUserCoinReq(UpdateUserCoinReq updateUserCoinReq);
}
