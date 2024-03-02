package edu.uptc.swii.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.uptc.swii.service.DividerService;
import edu.uptc.swii.service.MultiplierService;
import edu.uptc.swii.service.PowService;

@Configuration
public class AppConfig {

    @Bean(name = { "multiplierService" }, initMethod = "init", destroyMethod = "destroy")
    public MultiplierService multiplier() {
        return new MultiplierService(2);
    }

    @ConditionalOnProperty(name = "sender.sms", havingValue = "true", matchIfMissing = true)
    @Bean(name = "senderMessagesSms")
    public SenderMessages senderMessagesSms() {
        return new SenderMessagesSms();
    }

    @ConditionalOnProperty(name = "sender.sms", havingValue = "false")
    @Bean(name = "senderMessagesEmail")
    public SenderMessages senderMessagesEmail() {
        return new SenderMessagesEmail();
    }

    @Bean(name = { "DividerService" }, initMethod = "init", destroyMethod = "destroy")
    public DividerService divider() {
        return new DividerService();
    }

    @Bean(name = { "PowService" }, initMethod = "init", destroyMethod = "destroy")
    public PowService power() {
        return new PowService();
    }

}
