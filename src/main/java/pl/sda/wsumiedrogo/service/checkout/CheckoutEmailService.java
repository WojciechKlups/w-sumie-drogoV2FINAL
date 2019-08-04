package pl.sda.wsumiedrogo.service.checkout;


public interface CheckoutEmailService {
    void sendEmail(String to, String subject, String content);
}
