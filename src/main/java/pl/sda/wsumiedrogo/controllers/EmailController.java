package pl.sda.wsumiedrogo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import pl.sda.wsumiedrogo.service.checkout.CheckoutEmailService;

@Controller
public class EmailController {

    private final CheckoutEmailService emailSender;
    private final TemplateEngine templateEngine;

    @Autowired
    public EmailController(CheckoutEmailService emailSender, TemplateEngine templateEngine) {
        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
    }

    @GetMapping("/successcheckout")
    public String send() {
        Context context = new Context();
        context.setVariable("header", "W_Sumie_Drogo order details");
        context.setVariable("title", "Thank you for your order!");
        context.setVariable("description", "You have to pay price below");
        String body = templateEngine.process("order-confirmation", context);
        emailSender.sendEmail("wojciech.klups@gmail.com", "W_Sumie_Drogo Order confirmation", body);
        return "successcheckout";
    }
}
