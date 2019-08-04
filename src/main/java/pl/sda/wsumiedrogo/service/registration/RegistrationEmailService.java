package pl.sda.wsumiedrogo.service.registration;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;
import pl.sda.wsumiedrogo.model.User;


@Service
public class RegistrationEmailService {
    private String username="java13poz@gmail.com";
    private String password="JAV13sda";

    public void sendAuthenticationEmail(User user) throws EmailException {
        try {
            Email email = new SimpleEmail();
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(465);
            email.setAuthentication(username, password);
            email.setSSLOnConnect(true);
            email.setStartTLSEnabled(true);
            email.setFrom("java13poz@gmail.com", "W_Sumie_Drogo" +
                    "");
            email.setSubject("W_Sumie_Drogo activation link");
            email.setMsg("Click here to activate your account on W_Sumie_Drogo:"
                    + "\n\n http://localhost:8080/activate?code=" + user.getActivationCode());
            email.addTo(user.getEmail());
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
