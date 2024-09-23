import factory.EmailNotificationFactory;
import factory.NotificationFactory;
import factory.PushNotificationFactory;
import factory.SMSNotificationFactory;
import notificationSender.NotificationSender;

public class client {
    public static void main(String[] args) {
        // Create Email Notification Sender
        NotificationSender emailSender = new NotificationSender(new EmailNotificationFactory());
        emailSender.send("You have a new email message!");

        // Create SMS Notification Sender
        NotificationSender smsSender = new NotificationSender(new SMSNotificationFactory());
        smsSender.send("You have a new SMS message!");

        // Create Push Notification Sender
        NotificationSender pushSender = new NotificationSender(new PushNotificationFactory());
        pushSender.send("You have a new Push product.Notification!");

        // Extend functionality: Use factories dynamically based on input
        sendNotification("Email", "Your invoice is ready.");
        sendNotification("SMS", "Your delivery is arriving soon.");
        sendNotification("Push", "Your friend has just logged in.");
    }

    // Helper method to dynamically choose factory based on type
    public static void sendNotification(String type, String message) {
        NotificationFactory factory = null;

        switch (type) {
            case "Email" -> factory = new EmailNotificationFactory();
            case "SMS" -> factory = new SMSNotificationFactory();
            case "Push" -> factory = new PushNotificationFactory();
            default -> {
                System.out.println("Invalid notification type.");
                return;
            }
        }

        NotificationSender sender = new NotificationSender(factory);
        sender.send(message);
    }
}
