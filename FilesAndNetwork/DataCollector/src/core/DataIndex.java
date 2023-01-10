package core;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataIndex {

    private final String station;
    private final LocalDate date;
    private final String depth;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public DataIndex(String station, LocalDate date, String depth) {
        this.station = station;
        this.date = date;
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "DataIndex{" +
                "station='" + station + '\'' +
                ", date=" + date +
                ", depth='" + depth + '\'' +
                '}';
    }

    public String getStation() {
        return station;
    }

    public String getDate() {
        if(date==null){
            return "null";
        }
        return date.format(formatter);
    }

    public String getDepth() {
        if(depth==null){
            return "null";
        }
        return depth;
    }
}
