package org.example.adapter;

public class MovableAdapterImpl implements MovableAdapter {
    private Movable car;
    public MovableAdapterImpl(Movable car) {
        this.car = car;
    }
    @Override
    public double convertSpeed() {
        double speed = car.getSpeed();
        return convertMPHtoKMPH(speed);
    }

    private double convertMPHtoKMPH(double mph) {
        return mph * 1.60934;
    }
}

class Test {
    public static void main(String[] args) {
        BugattiVeyron bugattiVeyron = new BugattiVeyron();
        MovableAdapterImpl movableAdapter = new MovableAdapterImpl(bugattiVeyron);
        movableAdapter.convertSpeed();
    }
}
