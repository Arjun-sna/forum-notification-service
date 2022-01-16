package com.forum.notification.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.forum.notification.kafka.dto.EmailNotification;
import com.forum.notification.kafka.dto.PwResetNotification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationConsumer {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(id = "email_notification_listener", topics = "forum_app_sample")
    public void listenOnEMailNotificationTopic(EmailNotification emailNotification) {
         log.info("Received mail " + emailNotification.getPayload());
         switch (emailNotification.getType()) {
             case PW_RESET:
                 this.handlePwResetNotification(emailNotification.getPayload());
                 break;
             case ACCOUNT_ACTIVATION:
                 log.info("Account activation mail");
             default:
                 log.info("Unknown operation");
         }
    }

    private void handlePwResetNotification(String payload) {
        try {
            PwResetNotification pwResetNotification = objectMapper.readValue(payload, PwResetNotification.class);
            log.info("Received not " + pwResetNotification.getEmail());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
