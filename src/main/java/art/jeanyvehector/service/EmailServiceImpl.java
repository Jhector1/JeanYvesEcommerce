package art.jeanyvehector.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Properties;

@Service
public class EmailServiceImpl  {
    private final JavaMailSenderImpl emailSender;
    public EmailServiceImpl(JavaMailSenderImpl emailSender) {
        this.emailSender = emailSender;
    }

    public void sendSimpleMessage(String to,
            String from, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        emailSender.setJavaMailProperties(properties);
        emailSender.send(message);
        System.out.println("...send");
    }
    
    public void sendMessageWithAttachment(
            String to,String from, String subject, String text, String pathToAttachment) {
        // ...

        try {
            MimeMessage message = emailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true);


            helper.setFrom(from);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);

            FileSystemResource file
                    = new FileSystemResource(new File(pathToAttachment));
            helper.addAttachment("invoice"+file.getFilename(), file);
            Properties properties = new Properties();
            properties.setProperty("mail.smtp.auth", "true");
            properties.setProperty("mail.smtp.starttls.enable", "true");

            emailSender.setJavaMailProperties(properties);
            emailSender.send(message);

            // ...
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}