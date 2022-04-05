import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) throws IOException {
        File folder = new File(sourceDirectory);
        File newFolder = new File(destinationDirectory);
        if (folder.isDirectory()) {
            File[] f = folder.listFiles();
            for (File file1 : f) {
                Files.copy(Path.of(file1.getAbsolutePath()), newFolder.toPath().resolve(file1.toPath().getFileName()));
                if (file1.isDirectory()) {
                    copyFolder(file1.getAbsolutePath(),
                            newFolder.getAbsolutePath() + "\\" + file1.getName());
                }
            }
        } else System.out.println("Укажите правильный путь к папке");
    }
}
