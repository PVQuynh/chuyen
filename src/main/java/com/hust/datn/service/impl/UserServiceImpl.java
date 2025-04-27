package com.hust.datn.service.impl;

import com.hust.datn.dto.request.UpdateUserCoinReq;
import com.hust.datn.dto.request.UserReq;
import com.hust.datn.dto.response.UserRes;
import com.hust.datn.entity.User;
import com.hust.datn.mapper.UserMapper;
import com.hust.datn.repository.UserRepository;
import com.hust.datn.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void add(UserReq userReq) {
        User user = UserMapper.toEntity(userReq);
        userRepository.save(user);
    }

    @Override
    public UserRes getByDeviceId(String deviceId) {
        User user = userRepository.findByDeviceId(deviceId)
                .orElseThrow(() -> new RuntimeException("User not found with deviceId: " + deviceId));
        return UserMapper.toDto(user);
    }

    @Override
    public void updateUserCoinReq(UpdateUserCoinReq updateUserCoinReq) {
        if (updateUserCoinReq.getDeviceId() == null || updateUserCoinReq.getDeviceId().isEmpty()) {
            throw new RuntimeException("deviceId is empty");
        }
        if (updateUserCoinReq.getCoin() == null) {
            throw new RuntimeException("coin is empty");
        }
        User user = userRepository.findByDeviceId(updateUserCoinReq.getDeviceId())
                .orElseThrow(() -> new RuntimeException("User not found with deviceId: " + updateUserCoinReq.getDeviceId()));
        user.setCoin(updateUserCoinReq.getCoin());
        userRepository.save(user);
    }
}
