package com.forum.notification.kafka.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PwResetNotification {
    private String token;
    private int userId;
    private String username;
    private String email;
}