package com.forum.notification.kafka.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmailNotification {
    private EmailNotificationType type;
    private String payload;
}
