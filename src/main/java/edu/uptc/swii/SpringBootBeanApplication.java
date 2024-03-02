package edu.uptc.swii;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import edu.uptc.swii.config.SenderMessages;
import edu.uptc.swii.service.AppService;

@SpringBootApplication
@ComponentScan(basePackages = "edu.uptc.swii.service.*")
public class SpringBootBeanApplication {

    private final AppService appService;

    private final SenderMessages senderMessages;

    public SpringBootBeanApplication(AppService appService, SenderMessages senderMessages) {
        this.appService = appService;
        this.senderMessages = senderMessages;
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootBeanApplication.class, args);

        // Llamar a los métodos de los nuevos servicios
        AppService appService = context.getBean(AppService.class);
        System.out.println("Resultado de la división: " + appService.divide(10, 2));
        System.out.println("Resultado de la potencia: " + appService.power(2, 3));
    }

    @PostConstruct
    public void doExamples() {
        System.out.println("Calling bean method with this result: " + appService.calculate(123));

        System.out.println("Calling SenderMessages: ");
        senderMessages.send("hello universe");
    }
}
