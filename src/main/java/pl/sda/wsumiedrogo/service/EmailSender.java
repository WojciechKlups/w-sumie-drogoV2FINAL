package pl.sda.wsumiedrogo.service;

public interface EmailSender {
    void sendEmail(String to, String subject, String content);
}
