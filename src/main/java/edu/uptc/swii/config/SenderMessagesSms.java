package edu.uptc.swii.config;

public class SenderMessagesSms implements SenderMessages {
    @Override
    public void send(String message) {
        System.out.println("Sending by sms " + message);
    }
}
