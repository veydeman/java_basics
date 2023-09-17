import core.*;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        File file = new File("C:\\Users\\Jenya\\java_basics\\FilesAndNetwork\\DataCollector\\data\\data");
        FileSearch f = new FileSearch();
        f.fileSearch(file);
        WebParsing webParsing = new WebParsing();
        webParsing.parseHtml();
        StationIndex stationIndex = webParsing.createStationIndex();
        ArrayList<StationDate> csvDates = ParseCsv.parseCSVdates();
        ArrayList<StationDepth> csvDepths = ParseCsv.parseCSVdepth();
        ArrayList<StationDate> jsonDates = ParseJson.parseJsonDates();
        ArrayList<StationDepth> jsonDepths = ParseJson.parseJsonDepths();
        ArrayList<StationDate> dates = WriteJson.CompareDates(jsonDates,csvDates);
        ArrayList<StationDepth> depths = WriteJson.CompareDepths(jsonDepths,csvDepths);
        ArrayList<DataIndex> objects = WriteJson.compareDatesAndDepths(dates,depths);
        WriteJson writeJson = new WriteJson();
        writeJson.writeJsonFile(objects);

    }
}