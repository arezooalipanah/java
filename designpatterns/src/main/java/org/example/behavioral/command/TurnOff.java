package org.example.behavioral.command;

public class TurnOff implements Command {
    private Bulb bulb;

    public TurnOff(Bulb bulb) {
        if (bulb == null)
            throw new IllegalArgumentException("Bulb cannot be null");
        this.bulb = bulb;
    }

    @Override
    public void execute() {
        bulb.turnOff();
    }

    @Override
    public void undo() {
        bulb.turnOn();
    }

    @Override
    public void redo() {
        execute();
    }

}
