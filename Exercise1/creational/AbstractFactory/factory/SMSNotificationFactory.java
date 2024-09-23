package factory;

import factory.NotificationFactory;
import product.Notification;
import product.SMSNotification;

// Concrete Factory: SMS product.Notification Factory
public class SMSNotificationFactory implements NotificationFactory {
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}
