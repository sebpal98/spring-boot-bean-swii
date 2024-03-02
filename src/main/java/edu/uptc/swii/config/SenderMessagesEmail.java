package edu.uptc.swii.config;

public class SenderMessagesEmail implements SenderMessages {
    @Override
    public void send(String message) {
        System.out.println("Sending by email " + message);
    }
}
