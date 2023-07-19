package org.example.creational.factorymethod;

public class SMSNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("sms");
    }
}
