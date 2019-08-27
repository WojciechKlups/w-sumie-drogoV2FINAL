package pl.sda.wsumiedrogo.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ValidatorMessagesConfig {

    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource rb = new ReloadableResourceBundleMessageSource();
        rb.setBasenames("classpath:messages");

        return rb;
    }

    @Bean
    public LocalValidatorFactoryBean getValidator(){
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
}
