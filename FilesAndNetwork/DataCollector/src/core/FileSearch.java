package core;
import java.io.File;
import java.util.ArrayList;

public class FileSearch {
    static ArrayList<File> filesJSON = new ArrayList<>();
    static ArrayList<File> filesCSV = new ArrayList<>();
    static ArrayList<File> csvAndJson = new ArrayList<>();

    public static void fileSearch(File folder) {
        for (File f : folder.listFiles()) {
            if ((f.isFile() && f.getName().contains(".json"))) {
                filesJSON.add(f);
                csvAndJson.add(f);
            }
            if (f.isFile() && f.getName().contains(".csv")) {
                filesCSV.add(f);
                csvAndJson.add(f);
            }
            if (f.isDirectory()) {
                fileSearch(f);
            }
        }
    }

    @Override
    public String toString() {
        return csvAndJson.toString();
    }
}