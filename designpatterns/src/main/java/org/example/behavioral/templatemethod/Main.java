package org.example.behavioral.templatemethod;

public class Main {
    public static void main(String[] args) {
        AndroidBuilder androidBuilder = new AndroidBuilder();
        androidBuilder.build();
// Running android tests
// Linting android code
// Assembling android build
// Deploying android build

        IOSBuilder iOSBuilder = new IOSBuilder();
        iOSBuilder.build();
// Running iOS tests
// Linting iOS code
// Assembling iOS build
// Deploying iOS build
    }
}
