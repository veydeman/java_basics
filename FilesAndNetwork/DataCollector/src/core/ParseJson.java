package core;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ParseJson {

    public static JSONArray jsonData = new JSONArray();
    public static ArrayList<DataIndex> objects = new ArrayList<>();
    public static ArrayList<StationDate> stationDatesList = new ArrayList<>();
    public static ArrayList<StationDepth> stationDepthsList = new ArrayList<>();

    public static String getJsonFile(File file) {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(String.valueOf(file)));
            lines.forEach(line -> builder.append(line));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }

    public static ArrayList parseJsonDates() throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        JSONParser parser = new JSONParser();
        for (File file : FileSearch.filesJSON) {
            jsonData = (JSONArray) parser.parse(getJsonFile(file));
            for (Object object : jsonData) {
                JSONObject jsonObject = (JSONObject) object;
                if (jsonObject.containsKey("date")) {
                    int flag = 0;
                    for (StationDate stationDate : stationDatesList) {
                        if (stationDate.getStation()
                                .equalsIgnoreCase((String) jsonObject.get("name"))
                                && stationDate.getDate().equals
                                (LocalDate.parse(jsonObject.get("date").toString(), formatter))) {
                            flag = 1;
                        }
                    }
                    if (flag == 0) {
                        stationDatesList.add(new StationDate(jsonObject.get("name").toString(),
                                LocalDate.parse((String) jsonObject.get("date"), formatter)));
                    }
                }
            }
        }
        return stationDatesList;
    }

    public static ArrayList parseJsonDepths() throws ParseException {
        JSONParser parser = new JSONParser();
        for (File file : FileSearch.filesJSON) {
            jsonData = (JSONArray) parser.parse(getJsonFile(file));
            for (Object object : jsonData) {
                JSONObject jsonObject = (JSONObject) object;
                if (jsonObject.containsKey("depth_meters")) {
                    int flag = 0;
                    String depth = jsonObject.get("depth_meters").toString().replace("−", "-").replace(",", ".");
                    if (jsonObject.get("depth_meters").toString().contains("?")) {
                        stationDepthsList.add(new StationDepth(jsonObject.get("station_name").toString(),
                                depth));
                        continue;
                    }
                    for (StationDepth stationDepth : stationDepthsList) {
                        if (stationDepth.getStation()
                                .equalsIgnoreCase((String) jsonObject.get("station_name"))) {
                            flag = 1;

                            if (Double.parseDouble(depth) < Double.parseDouble(stationDepth
                                    .getDepth())) {
                                stationDepth.setDepth(depth);
                            }
                        }
                    }
                    if (flag == 0) {
                        stationDepthsList.add(new StationDepth(jsonObject.get("station_name").toString(),
                                depth));
                    }
                } else if (jsonObject.containsKey("depth")) {
                    int flag = 0;
                    String depth = jsonObject.get("depth").toString().replace("−", "-").replace(",", ".");
                    if (depth.equals("?")) {
                        stationDepthsList.add(new StationDepth(jsonObject.get("name").toString(),
                                depth));
                        continue;
                    }
                    for (StationDepth stationDepth : stationDepthsList) {
                        if (stationDepth.getStation()
                                .equalsIgnoreCase((String) jsonObject.get("name"))) {
                            flag = 1;
                            if (Double.parseDouble(depth) < Double.parseDouble(stationDepth.getDepth())) {
                                stationDepth.setDepth(depth);
                            }
                        }
                    }
                    if (flag == 0) {
                        stationDepthsList.add(new StationDepth(jsonObject.get("name").toString(),
                                depth));
                    }
                }
            }
        }
        return stationDepthsList;
    }
}
