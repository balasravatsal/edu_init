package product;

import product.Notification;

// Concrete Product: Email
public class EmailNotification implements Notification {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending Email: " + message);
    }
}
