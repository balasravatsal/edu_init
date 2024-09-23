package notificationSender;

import factory.NotificationFactory;
import product.Notification;

// Notification Sender - Sends notification
public class NotificationSender {
    private NotificationFactory notificationFactory;

    // Constructor to set the notification factory
    public NotificationSender(NotificationFactory notificationFactory) {
        this.notificationFactory = notificationFactory;
    }

    // Sends notification using the appropriate factory
    public void send(String message) {
        Notification notification = notificationFactory.createNotification();
        notification.sendNotification(message);
    }
}
