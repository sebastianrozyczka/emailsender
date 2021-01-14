package p.sebroz.thymeleaftask.application;

public interface EmailSender {
    void sendEmail(String name, String email, String content);
}
