package com.zhoma.websocket_practice.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "socket_user")
public class User {
    @Id
    private String nickName;

    private String fullName;
    private Status status;
}