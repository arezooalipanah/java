package org.example.creational.factorymethod;

public class PushNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("push");
    }
}
