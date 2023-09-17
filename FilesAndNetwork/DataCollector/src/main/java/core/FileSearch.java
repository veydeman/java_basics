package core;
import java.io.File;
import java.util.ArrayList;

public class FileSearch {
    static ArrayList<File> filesJSON = new ArrayList<>();
    static ArrayList<File> filesCSV = new ArrayList<>();
    static ArrayList<File> csvAndJson = new ArrayList<>();

    public static void fileSearch(File folder) {
        for (File file : folder.listFiles()) {
            if ((file.isFile() && file.getName().contains(".json"))) {
                filesJSON.add(file);
                csvAndJson.add(file);
            }
            if (file.isFile() && file.getName().contains(".csv")) {
                filesCSV.add(file);
                csvAndJson.add(file);
            }
            if (file.isDirectory()) {
                fileSearch(file);
            }
        }
    }

    @Override
    public String toString() {
        return csvAndJson.toString();
    }
}