package org.example.creational.factorymethod;

public class NotificationFactory {
    public static Notification createNotification(NotificationType channel) {
        if (channel == null) {
            return null;
        }
        switch (channel) {
            case SMS:
                return new SMSNotification();
            case PUSH:
                return new PushNotification();
            default:
                throw new IllegalArgumentException("unknown channel");
        }
    }
}

class Test {
    public static void main(String[] args) {
        Notification sms = NotificationFactory.createNotification(NotificationType.SMS);
        sms.notifyUser();
    }
}
