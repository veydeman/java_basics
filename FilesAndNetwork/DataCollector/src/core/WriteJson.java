package core;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class WriteJson {

    StationIndex stationIndex = WebParsing.parseHtml();

    public WriteJson() throws IOException {
    }

    public static ArrayList CompareDates(ArrayList<StationDate> jsonDates, ArrayList<StationDate> csvDates) {
        for (StationDate stationDate1 : csvDates) {
            int flag = 0;
            for (StationDate stationDate : jsonDates) {
                if (stationDate.getStation().equalsIgnoreCase(stationDate1.getStation()) &&
                        stationDate.getDate().isEqual(stationDate1.getDate())) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                jsonDates.add(stationDate1);
            }
        }
        return jsonDates;
    }

    public static ArrayList CompareDepths(ArrayList<StationDepth> jsonDepths, ArrayList<StationDepth> csvDepths) {
        for (StationDepth stationDepth : csvDepths) {
            int flag = 0;
            for (StationDepth stationDepth1 : jsonDepths) {
                if (stationDepth.getStation().equalsIgnoreCase(stationDepth1.getStation())) {
                    flag = 1;
                    if (stationDepth1.getDepth().contains("?")) {
                        stationDepth1.setDepth(stationDepth.getDepth());
                    }
                    if (stationDepth.getDepth().contains("?")) {
                        stationDepth.setDepth(stationDepth1.getDepth());
                    }
                    if (!stationDepth.getDepth().equals("?")) {
                        if (Double.parseDouble(stationDepth.getDepth())
                                < Double.parseDouble(stationDepth1.getDepth())) {
                            stationDepth1.setDepth(stationDepth.getDepth());
                        }
                    }
                }
            }
            if (flag == 0) {
                jsonDepths.add(stationDepth);
            }
        }
        return jsonDepths;
    }

    public static ArrayList compareDatesAndDepths(ArrayList<StationDate> dates, ArrayList<StationDepth> depths){
        ArrayList<DataIndex> objects = new ArrayList<>();
        for(StationDepth stationDepth :depths){
            for (StationDate stationDate : dates) {
                if (stationDepth.getStation().equalsIgnoreCase(stationDate.getStation())) {
                    objects.add(new DataIndex(stationDepth.getStation(), stationDate.getDate(),
                            stationDepth.getDepth()));
                }
            }
        }
        return objects;
    }

    public JSONObject writeJsonFile(ArrayList<DataIndex> objects) {
        JSONObject jsonObject = new JSONObject();
        JSONArray stationsArray = new JSONArray();
        jsonObject.put("stations", stationsArray);
        for (DataIndex item : objects) {
            JSONObject stationObject = new JSONObject();
            stationObject.put("name", item.getStation());
            stationObject.put("date", item.getDate());
            stationObject.put("depth", item.getDepth());
            for (Map.Entry<String, Line> item3 : stationIndex.number2line.entrySet()) {
                for (Station station : item3.getValue().getStations()) {
                    if (item.getStation().equalsIgnoreCase(station.getName())) {
                        stationObject.put("line", item3.getValue().getName());
                        stationObject.put("hasConnection", station.getConnection());
                    }
                }
            }
            stationsArray.add(stationObject);
        }

        try (FileWriter fileWriter = new FileWriter("C:\\Users\\jenny\\java_basics\\FilesAndNetwork" +
                "\\DataCollector\\data\\stations.json")) {
            fileWriter.write(jsonObject.toJSONString());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return jsonObject;
    }
}