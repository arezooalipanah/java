package creational.factory;

public class NotificationFactory {

    public static Notification createNotification(NotificationType channel) {
        if (channel == null) {
            return null;
        }
        switch (channel) {
            case SMS:
                return new SMSNotification();
            case EMAIL:
                return new EmailNotification();
            case PUSH:
                return new PushNotification();
            default:
                throw new IllegalArgumentException("unknown channel " + channel);
        }

    }
}
