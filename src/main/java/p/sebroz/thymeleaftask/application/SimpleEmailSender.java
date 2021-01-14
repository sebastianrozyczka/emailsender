package p.sebroz.thymeleaftask.application;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SimpleEmailSender implements EmailSender {
    private JavaMailSender mailSender;

    public SimpleEmailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(String name, String email, String content) {
        String subject = name + " asked for something";

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom("liquorstoremailsender@gmail.com");
        mailMessage.setTo("sebastian.konta@gmail.com");
        mailMessage.setReplyTo(email);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);

        mailSender.send(mailMessage);
    }
}
