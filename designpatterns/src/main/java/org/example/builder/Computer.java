package org.example.builder;

public class Computer {
    private String hdd;
    private String ram;
    private boolean isGraphicsCardEnabled;
    private boolean isBluetoothEnabled;

    public Computer(ComputerBuilder builder) {
        this.hdd = builder.HDD;
        this.ram = builder.RAM;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
    }

    public String getHdd() {
        return hdd;
    }

    public String getRam() {
        return ram;
    }

    public boolean isGraphicsCardEnabled() {
        return isGraphicsCardEnabled;
    }

    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }

    public static class ComputerBuilder {
        private String HDD;
        private String RAM;
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;

        public ComputerBuilder(String hdd, String ram) {
            this.HDD = hdd;
            this.RAM = ram;
        }

        public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }

        public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}


class Test {
    public static void main(String[] args) {
        Computer build = new Computer.ComputerBuilder("Maxtor", "Kingston")
                .setBluetoothEnabled(false)
                .setGraphicsCardEnabled(true).build();
    }
}