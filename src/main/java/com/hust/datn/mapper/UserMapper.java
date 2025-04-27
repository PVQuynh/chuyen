package com.hust.datn.mapper;

import com.hust.datn.dto.request.UserReq;
import com.hust.datn.dto.response.UserRes;
import com.hust.datn.entity.User;

import java.sql.Timestamp;

public class UserMapper {
    public static User toEntity(UserReq userReq) {
        User user = new User();
        user.setDeviceId(userReq.getDeviceId());
        user.setUsername(userReq.getUsername());
        user.setAge(userReq.getAge());
        user.setCoin(userReq.getCoin());
        user.setGameName(userReq.getGameName());
        user.setCreateTime(new Timestamp(System.currentTimeMillis()));
        user.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        return user;
    }

    public static UserRes toDto(User user) {
        UserRes userRes = new UserRes();
        userRes.setDeviceId(user.getDeviceId());
        userRes.setUsername(user.getUsername());
        userRes.setAge(user.getAge());
        userRes.setCoin(user.getCoin());
        userRes.setGameName(user.getGameName());
        userRes.setCreateTime(user.getCreateTime());
        userRes.setUpdateTime(user.getUpdateTime());
        return userRes;
    }
}
