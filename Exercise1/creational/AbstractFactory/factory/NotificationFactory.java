package factory;

import product.Notification;

// Abstract Factory: product.Notification Factory
public interface NotificationFactory {
    Notification createNotification();
}
