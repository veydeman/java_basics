import core.*;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        File file = new File("C:\\Users\\jenny\\java_basics\\FilesAndNetwork\\DataCollector\\data\\data");
        FileSearch f = new FileSearch();
        f.fileSearch(file);
        System.out.println(file);
//        WebParsing webParsing =new WebParsing();
//        StationIndex stationIndex = webParsing.createStationIndex();
//        webParsing.parseHtml();
//        ArrayList<StationDate> csvDates = ParseCsv.parseCSVdates();
//        ArrayList<StationDepth> csvDepths = ParseCsv.parseCSVdepth();
//        ArrayList<StationDate> jsonDates = ParseJson.parseJsonDates();
//        ArrayList<StationDepth> jsonDepths = ParseJson.parseJsonDepths();
//        ArrayList<StationDate> dates = WriteJson.CompareDates(jsonDates,csvDates);
//        ArrayList<StationDepth> depths = WriteJson.CompareDepths(jsonDepths,csvDepths);
//        ArrayList<DataIndex> objects = WriteJson.compareDatesAndDepths(dates,depths);
//        WriteJson writeJson = new WriteJson();
//        writeJson.writeJsonFile(objects);
//        System.out.println(stationIndex);
    }
}