package factory;

import factory.NotificationFactory;
import product.Notification;
import product.PushNotification;

// Concrete Factory: Push product.Notification Factory
public class PushNotificationFactory implements NotificationFactory {
    @Override
    public Notification createNotification() {
        return new PushNotification();
    }
}
