package com.forum.notification.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.forum.notification.dto.PwResetNotification;
import com.forum.notification.mailer.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class NotificationConsumer {
    private final EmailService eMailService;

    @KafkaListener(
            id = "pw_reset_notification_listener",
            topics = "${spring.kafka.topics.pw_reset_notification}")
    public void listenOnEMailNotificationTopic(PwResetNotification pwResetNotification) {
        log.info("Received pw reset notification");
        eMailService.send(
                pwResetNotification.getEmail(), "Password Reset", pwResetNotification.getToken());
    }
}
