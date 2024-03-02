package edu.uptc.swii.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    @Autowired
    private DividerService dividerService;

    @Autowired
    private PowService powService;

    private final MultiplierService multiplierService;

    public AppService(@Autowired @Qualifier("multiplierService") MultiplierService multiplierService) {
        this.multiplierService = multiplierService;
    }

    public int calculate(int aValue) {
        return multiplierService.multiply(aValue);
    }

    public double divide(double dividend, double divisor) {
        return dividerService.divide(dividend, divisor);
    }

    public double power(double base, double exponent) {
        return powService.power(base, exponent);
    }

}
