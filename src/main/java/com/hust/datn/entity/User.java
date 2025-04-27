package com.hust.datn.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    private String deviceId;

    private String username;

    private Integer  age;

    private Integer coin;

    private String gameName;

    private Timestamp createTime;

    private Timestamp updateTime;
}
