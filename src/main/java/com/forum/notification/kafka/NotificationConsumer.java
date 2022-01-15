package com.forum.notification.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationConsumer {
    @KafkaListener(id = "email_notification_listener", topics = "forum_app_sample")
    public void listenOnEMailNotificationTopic(EmailNotification emailNotification) {
        log.info("Received mail " + emailNotification.getPayload());
    }
}
