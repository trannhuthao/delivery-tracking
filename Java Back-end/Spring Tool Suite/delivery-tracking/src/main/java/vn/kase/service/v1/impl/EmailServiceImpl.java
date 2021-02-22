package vn.kase.service.v1.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import vn.kase.service.v1.EmailService;
import vn.kase.util.email.EmailConstants;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public String sendEmail(String recepientEmail) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(recepientEmail);
        simpleMailMessage.setSubject("Order Placed.");
        simpleMailMessage.setText("Order Successfully Placed.");

        try {
            this.javaMailSender.send(simpleMailMessage);
            return "E-mail successfully sent.";
        } catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    public String sendEmailWithAttachments(String recepientEmail) throws MessagingException {
        MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
        boolean multiPart = true;

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, multiPart);
        mimeMessageHelper.setTo(recepientEmail);
        mimeMessageHelper.setSubject("Order Placed.");
        mimeMessageHelper.setText("Order Successfully Placed.");

        String pathToFile0 = "/D:/Testing Spring E-Mail/HelloWorldInJava.txt";
        String pathToFile1 = "/D:/Testing Spring E-Mail/HelloWorldInC#.txt";

        FileSystemResource file0 = new FileSystemResource(new File(pathToFile0));
        mimeMessageHelper.addAttachment("How to say Hello, world! in Java.", file0);
        FileSystemResource file1 = new FileSystemResource(new File(pathToFile1));
        mimeMessageHelper.addAttachment("How to say Hello, world! in C#.", file1);

        try {
            this.javaMailSender.send(mimeMessage);
            return "E-mail successfully sent.";
        } catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    public String sendEmailWithHtmlContent(String recepientEmail) throws MessagingException {
        MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
        boolean multiPart = true;
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, multiPart, "utf-8");

        String htmlMessage = "<h1 style=\"font-family: monospace; text-align: center;\">Order Successfully Placed.</h1>";
        mimeMessage.setContent(htmlMessage, "text/html");

        mimeMessageHelper.setTo(recepientEmail);
        mimeMessageHelper.setSubject("Order Placed.");

        try {
            this.javaMailSender.send(mimeMessage);
            return "E-mail successfully sent.";
        } catch (Exception exception) {
            return exception.getMessage();
        }
    }
}