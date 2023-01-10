package core;

public class StationDepth {
    String station;
    String depth;

    public StationDepth(String station, String depth) {
        this.station = station;
        this.depth = depth;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "StationDepth{" +
                "station='" + station + '\'' +
                ", depth='" + depth + '\'' +
                '}';
    }
}
