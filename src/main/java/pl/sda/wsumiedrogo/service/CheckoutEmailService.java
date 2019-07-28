package pl.sda.wsumiedrogo.service;


public interface CheckoutEmailService {
    void sendEmail(String to, String subject, String content);
}
