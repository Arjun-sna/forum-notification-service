package com.forum.notification.mailer;

public interface EmailService {
    void send(String toEMail, String subject, String mailContent);
}
