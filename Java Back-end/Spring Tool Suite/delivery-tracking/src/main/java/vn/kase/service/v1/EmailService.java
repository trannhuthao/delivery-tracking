package vn.kase.service.v1;

import javax.mail.MessagingException;

public interface EmailService {
    String sendEmail(String recepientEmail);

    String sendEmailWithAttachments(String recepientEmail) throws MessagingException;

    String sendEmailWithHtmlContent(String recepientEmail) throws MessagingException;
}