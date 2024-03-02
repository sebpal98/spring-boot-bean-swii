package edu.uptc.swii.service;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
public class DividerService {

    public double divide(double dividend, double divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("No se puede dividir sobre cero");
        }
        return dividend / divisor;
    }

    public DividerService() {
        System.out.println("DividerService bean Creado");
    }

    @PostConstruct
    public void init() {
        System.out.println("DividerService bean ha iniciado");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("DividerService bean ha terminado");
    }

}
