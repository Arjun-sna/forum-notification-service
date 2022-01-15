package com.forum.notification.kafka.emailNotification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmailNotificationConsumer {
    @KafkaListener(id = "mail_notification_listeners", topics = "forum_app_sample")
    public void listenOnMailNotificationTopic(EmailNotification emailNotification) {
        log.info("Received mail " + emailNotification.getEmail());
    }
}
