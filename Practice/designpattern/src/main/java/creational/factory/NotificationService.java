package creational.factory;

public class NotificationService {
    public static void main(String[] args) {
        Notification notification = NotificationFactory.createNotification(NotificationType.SMS);
        notification.notifyUser();
    }
}
