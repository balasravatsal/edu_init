package product;

import product.Notification;

// Concrete Product: Push
public class PushNotification implements Notification {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending Push: " + message);
    }
}
