package com.forum.notification.mailer;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGridAPI;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class SendGridEMailService implements EmailService {
    private final SendGridAPI sg;
    @Value("${spring.sendgrid.sender-email}")
    public String senderEmail;
    @Value("${spring.sendgrid.sender-name}")
    public String senderName;

    @Override
    public void send(String toEMail, String subject, String mailContent) {
        Email from = new Email(senderEmail, senderName);
        Email to = new Email(toEMail);
        Content content = new Content("text/plain", mailContent);
        Mail mail = new Mail(from, subject, to, content);
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            log.info(String.valueOf(response.getStatusCode()));
            log.info(response.getBody());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
