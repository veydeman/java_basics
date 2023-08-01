package core;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final String number;
    private final String name;
    public List<Station> stations;

    public Line(String number, String name) {
        this.number = number;
        this.name = name;
        stations = new ArrayList<>();
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public List<Station> getStations() {
        return stations;
    }

    @Override
    public String toString() {
        return "Line{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", stations=" + stations +
                '}';
    }
}
