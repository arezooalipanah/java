package org.example.behavioral.mediator;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatRoom implements ChatRoomMediator{
    SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, HH:mm");

    @Override
    public void showMessage(User user, String message) {
        System.out.println(sdf.format(new Date())+ " [" + user.getName() + "]: " + message);
    }
}
