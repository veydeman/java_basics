package core;
import java.time.LocalDate;

public class StationDate {
    private String station;
    private LocalDate date;

    public StationDate(String station, LocalDate date) {
        this.station = station;
        this.date = date;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "StationDate{" +
                "station='" + station + '\'' +
                ", date=" + date +
                '}';
    }
}
