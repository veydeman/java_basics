import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.Line;
import core.Station;
import core.StationIndex;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static StationIndex stationIndex;
    public static int a = 0;
    static ArrayList<File> filesJSON = new ArrayList<>();
    static ArrayList<File> filesCSV = new ArrayList<>();

    public static void main(String[] args) throws IOException, ParseException, Exception {


        final String URL = "https://skillbox-java.github.io/";
        String folderPath = "C:\\Users\\jenny\\Desktop\\файлы для мосметро\\data\\data";
        File file = new File(folderPath);
        Document document = Jsoup.connect(URL).get();
        createStationIndex();
        stationIndex = new StationIndex();

        Elements lines = document.select("span[class=data-line]");
        Elements metroStations = document.select("span[class=name]"); // это станции
        Elements lineNames = document.select("span[data-line]"); // это названия линий
        Elements elements2 = document.select("span[class^='js-metro-line t-metrostation-list-header t-icon-metroln']");  // это названия линий
        Elements divLines = document.select("div.js-toggle-depend");


        for (Element divline : divLines) {
            Element spanLine = divline.child(0);
            String lineNumber = spanLine.attr("data-line");
            String lineName = spanLine.text();
            Line newLine = new Line(lineNumber, lineName);
            stationIndex.addLine(newLine);
            Elements pStations = divline.nextElementSibling().child(0).children();
            for (Element pStation : pStations) {
                Station newStation = new Station(pStation.child(1).text(), newLine);
                newLine.addStation(newStation);
            }
        }


        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject1 = new JSONObject();
        jsonObject.put("stations", jsonObject1);

        JSONArray jsonArray = new JSONArray();  // создаю массив для списка объектов линий и их номеров
        for (String s : StationIndex.number2line.keySet()) {   // итерация по номерам линий
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


        try (FileWriter file1 = new FileWriter("C:\\Users\\jenny\\java_basics\\FilesAndNetwork\\DataCollector\\data\\metro.json")) {
            file1.write(jsonObject.toJSONString());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
//        stationsOnLine();
        createJSONdata();
        parseData(file);
        getJSONdata();
        parseJSON();


//        List<String> lines1 = Files.readAllLines(Path.of(filesJSON.get(0).getPath()));
//        StringBuilder builder = new StringBuilder();
//        lines1.forEach(line -> builder.append(line));
//        System.out.println(builder);
    }


    // ========================================================================= //


    private static void createStationIndex() {
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
            List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\jenny\\java_basics\\FilesAndNetwork\\DataCollector\\data\\metro.json"));
            lines.forEach(line -> builder.append(line));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }

    private static void stationsOnLine() {
        for (Line line : StationIndex.number2line.values()
        ) {
            System.out.println(line.getName() + " - " + line.getStations().size() + " станций");
        }
    }

    private static void parseData(File folder) {
        for (File f : folder.listFiles()) {
            if ((f.isFile() && f.getName().contains(".json"))) {
                filesJSON.add(f);
            }
//            if (f.isFile() && f.getName().contains(".csv")) {
//                filesCSV.add(f);
//            }
            else if (f.isDirectory()) {
                parseData(f);
            }
        }
    }

    private static void parseJSON() throws IOException {
        String jsonFile = getJSONdata();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonData = objectMapper.readTree(jsonFile);
        jsonData.forEach(jsonNode -> System.out.println(jsonNode.get("name")));
        jsonData.forEach(jsonNode -> System.out.println(jsonNode.get("date")));


    }

    private static String getJSONdata() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> lines = Files.readAllLines(Paths.get(filesJSON.get(0).toString()));
        lines.forEach(line -> stringBuilder.append(line));
        return stringBuilder.toString();
    }

    public static void createJSONdata(){

    }

    private static void parseCSV(){

    }

}

