package core;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WebParsing {


    static final String URL = "https://skillbox-java.github.io/";
    static StationIndex stationIndex = new StationIndex();

    public WebParsing() throws IOException {
    }

    public static StationIndex parseHtml() throws IOException {
        Document document = Jsoup.connect(URL).get();
        Elements divLines = document.select("div.js-toggle-depend");
        for (Element divline : divLines) {              // заполнение stationindex
            Element spanLine = divline.child(0);
            String lineNumber = spanLine.attr("data-line");
            String lineName = spanLine.text();
            Line newLine = new Line(lineNumber, lineName);
            Elements pStations = divline.nextElementSibling().child(0).children();
            stationIndex.addLine(newLine);
            for (Element pStation : pStations) {
                Station newStation = new Station(pStation.child(1).text(), newLine);
                String connection = pStation.select("span").attr("title");
                newStation.setConnection(!connection.isEmpty());
                newLine.addStation(newStation);
            }
        }

        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject1 = new JSONObject();
        jsonObject.put("stations", jsonObject1);

        JSONArray jsonArray = new JSONArray();  // создаю массив для списка объектов линий и их номеров
        for (String s : stationIndex.number2line.keySet()) {   // итерация по номерам линий
            JSONArray jsonArray1 = new JSONArray();   // создаю массив для станций по линиям
            JSONObject jsonObject2 = new JSONObject();  // создаю объект для списка объектов линий и их номеров
            jsonObject2.put("number", s);  //
            jsonObject2.put("name", stationIndex.getLine(s).getName());
            jsonArray.add(jsonObject2);
            for (Station station : stationIndex.getLine(s).getStations()) {
                jsonArray1.add(station.toString());
                jsonObject1.put(s, jsonArray1);
            }
        }
        jsonObject.put("lines", jsonArray);

        try (FileWriter file1 = new FileWriter("C:\\Users\\jenny\\Desktop\\METRO\\data\\metro.json")) {
            file1.write(jsonObject.toJSONString());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return stationIndex;
    }

    public static StationIndex createStationIndex() {
        stationIndex = new StationIndex();
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonData = (JSONObject) parser.parse(getJsonFile());

            JSONArray linesArray = (JSONArray) jsonData.get("lines");
            parseLines(linesArray);

            JSONObject stationsObject = (JSONObject) jsonData.get("stations");
            parseStations(stationsObject);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return stationIndex;
    }

    private static void parseLines(JSONArray linesArray) {
        linesArray.forEach(lineObject -> {
            JSONObject lineJsonObject = (JSONObject) lineObject;
            Line line = new Line(
                    lineJsonObject.get("number").toString(),
                    (String) lineJsonObject.get("name")
            );
            stationIndex.addLine(line);
        });
    }

    private static void parseStations(JSONObject stationsObject) {
        stationsObject.keySet().forEach(lineNumberObject ->
        {
            String lineNumber = lineNumberObject.toString();
            Line line = stationIndex.getLine(lineNumber);
            JSONArray stationsArray = (JSONArray) stationsObject.get(lineNumberObject);
            stationsArray.forEach(stationObject ->
            {
                Station station = new Station(stationObject.toString(), line);
                stationIndex.addStation(station);
                line.addStation(station);
            });
        });
    }

    private static String getJsonFile() {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\jenny\\java_basics" +
                    "\\FilesAndNetwork\\DataCollector\\data\\metro.json"));
            lines.forEach(line -> builder.append(line));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }

    public static void stationsOnLine() {
        for (Line line : stationIndex.number2line.values()
        ) {
            System.out.println(line.getName() + " - " + line.getStations().size() + " станций");
        }
    }
}
