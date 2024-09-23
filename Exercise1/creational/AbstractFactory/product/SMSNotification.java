package product;

import product.Notification;

// Concrete Product: SMS
public class SMSNotification implements Notification {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS: " + message);
    }
}
