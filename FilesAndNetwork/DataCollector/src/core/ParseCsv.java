package core;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ParseCsv {

    private static ArrayList<DataIndex> objects = new ArrayList<>();
    public static ArrayList<StationDate> stationDatesList = new ArrayList<>();
    public static ArrayList<StationDepth> stationDepthsList = new ArrayList<>();

    public static ArrayList parseCSVdates() throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        for (File file : FileSearch.filesCSV) {
            if (String.valueOf(file.toPath().getFileName()).contains("dates")) {
                List<String> lines = Files.readAllLines(Paths.get(String.valueOf(file)));
                for (String line : lines) {
                    if (line.equals(lines.get(0))) {
                        continue;
                    }
                    String[] fragments = line
                            .split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                    if (fragments.length != 2) {
                        for (String fragment : fragments) {
                            System.out.println(fragment);
                        }
                        System.out.println("WRONG LINE: " + line);
                        continue;
                    }
                    int flag = 0;
                    for (StationDate stationDate : stationDatesList) {
                        if (stationDate.getStation().equalsIgnoreCase(fragments[0])
                                && stationDate.getDate().equals(LocalDate.parse(fragments[1], formatter))) {
                            flag = 1;
                        }
                    }
                    if (flag == 0) {
                        stationDatesList.add(new StationDate(fragments[0], LocalDate.parse(fragments[1], formatter)));
                    }
                }
            }
        }
        return stationDatesList;
    }

    public static ArrayList parseCSVdepth() throws IOException {
        for (File file : FileSearch.filesCSV) {
            if (String.valueOf(file.toPath().getFileName()).contains("depth")) {
                List<String> lines = Files.readAllLines(Paths.get(String.valueOf(file)));
                for (
                        String line : lines) {
                    if (line.equals(lines.get(0))) {
                        continue;
                    }
                    String[] fragments = line
                            .split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                    if (fragments.length != 2) {
                        for (String fragment : fragments) {
                            System.out.println(fragment);
                        }
                        System.out.println("WRONG LINE: " + line);
                        continue;
                    }
                    int flag = 0;
                    String depth = fragments[1].replace("−", "-").replace(",", ".")
                            .replace("\"", "");
                    if (fragments[1].contains("?")) {
                        stationDepthsList.add(new StationDepth(fragments[0], fragments[1]));
                        continue;
                    }
                    for (StationDepth stationDepth : stationDepthsList) {
                        if (stationDepth.getStation()
                                .equalsIgnoreCase(fragments[0])) {
                            flag = 1;

                            if (Double.parseDouble(depth) < Double.parseDouble(stationDepth
                                    .getDepth())) {
                                stationDepth.setDepth(depth);
                            }
                        }
                    }
                    if (flag == 0) {
                        stationDepthsList.add(new StationDepth(fragments[0],
                                depth));
                    }
                }
            }
        }
        return stationDepthsList;
    }
}
