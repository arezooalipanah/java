package org.example.behavioral.iterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        StationList stations = new StationList();
        RadioStation station1 = new RadioStation(89);
        stations.add(station1);

        RadioStation station2 = new RadioStation(101);
        stations.add(station2);

        RadioStation station3 = new RadioStation(102);
        stations.add(station3);

        Iterator<RadioStation> stationIterator = stations.iterator();
        while (stationIterator.hasNext()) {
            RadioStation radioStation = stationIterator.next();
            System.out.println(radioStation.getFrequency());
        }
    }
}

