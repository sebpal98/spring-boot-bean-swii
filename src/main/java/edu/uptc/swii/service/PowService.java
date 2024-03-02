package edu.uptc.swii.service;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
public class PowService {

    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public PowService() {
        System.out.println("PowService ha sido creado");
    }

    @PostConstruct
    public void init() {
        System.out.println("PowService Bean ha iniciado");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PowService bean ha terminado");
    }

}
