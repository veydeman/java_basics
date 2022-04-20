import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String htmlFile = parseFile("C:\\Users\\jenny\\java_basics\\FilesAndNetwork\\HtmlParsing\\data\\code.html");
        Document document = Jsoup.parse(htmlFile);
        Elements elements = document.select("img");
        Path images = Path.of("C:/Users/jenny/java_basics/FilesAndNetwork/HtmlParsing/Images");
        File folder = new File(String.valueOf(images));
        for (Element e : elements
        ) {
            System.out.println(e.attr("src"));
            String regex = "(//)(.+)";
            if (e.attr("src").matches(regex)) {
                continue;
            }
            URL url = new URL(e.attr("src"));
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            Files.copy(inputStream, new File("C:\\Users\\jenny\\java_basics\\FilesAndNetwork\\HtmlParsing" +
                    "\\Images\\" + e.attr("src")
                    .replaceAll("[/:]", "")).toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
        File[] files = folder.listFiles();
        for (
                File file : files
        ) {
            System.out.println(file.getName());
        }
    }

    public static String parseFile(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            for (String line : lines
            ) {
                builder.append(line + "\n");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return builder.toString();
    }
}
