package com.forum.notification.kafka;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmailNotification {
    private EmailNotificationType type;
    private String payload;
}
