package pl.sda.wsumiedrogo.service.checkout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class CheckoutEmailServiceImpl implements CheckoutEmailService {

    @Autowired
    JavaMailSender javaMailSender;


    @Override
    public void sendEmail(String to, String subject, String content) {

        MimeMessage mail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail,true);
            helper.setTo(to);
            helper.setReplyTo("wojciech.klups@gmail.com");
            helper.setFrom("java13poz@gmail.com");
            helper.setSubject(subject);
            helper.setText(content, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(mail);
    }
}
