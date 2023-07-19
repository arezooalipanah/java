package org.example.behavioral.command;

public class Main {
    public static void main(String[] args) {
        Bulb bulb = new Bulb();
        TurnOn turnOnCmd = new TurnOn(bulb);
        TurnOff turnOffCmd = new TurnOff(bulb);

        RemoteControl remote = new RemoteControl();
        remote.submit(turnOnCmd);       // Bulb is turned ON
        remote.submit(turnOffCmd); // Bulb is turned OFF
    }
}
