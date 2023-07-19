package org.example.behavioral.command;

public class TurnOn implements Command{
    private Bulb bulb;

    public TurnOn(Bulb bulb) {
        if (bulb == null)
            throw new IllegalArgumentException("Bulb cannot be null");
        this.bulb = bulb;
    }

    @Override
    public void execute() {
        bulb.turnOn();
    }

    @Override
    public void undo() {
        bulb.turnOff();
    }

    @Override
    public void redo() {
        execute();
    }
}
