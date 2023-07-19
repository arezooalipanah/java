package org.example.behavioral.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StationList implements Iterable<RadioStation>{
    private List<RadioStation> stations;

    public StationList() {
        stations = new ArrayList<>();
    }

    public List<RadioStation> getStations() {
        return stations;
    }

    public void add(RadioStation station) {
        stations.add(station);
    }

    public void remove(RadioStation station) {
        stations.remove(station);
    }

    @Override
    public Iterator<RadioStation> iterator() {
        return this.getStations().iterator();
    }
}
