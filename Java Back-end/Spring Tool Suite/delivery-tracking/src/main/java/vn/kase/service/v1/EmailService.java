package vn.kase.service.v1;

import javax.mail.MessagingException;

public interface EmailService {
    String sendEmail(String recipientEmail);

    String sendEmailWithAttachments(String recipientEmail) throws MessagingException;

    String sendEmailWithHtmlContent(String recipientEmail) throws MessagingException;
}