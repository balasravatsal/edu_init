package factory;

import product.EmailNotification;
import product.Notification;

// Concrete Factory: Email product.Notification Factory
public class EmailNotificationFactory implements NotificationFactory {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
