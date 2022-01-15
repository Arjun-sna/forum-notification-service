package com.forum.notification.kafka.emailNotification;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmailNotification {
    private String channel;
    private String type;
    private String token;
    private int userId;
    private String username;
    private String email;
}
