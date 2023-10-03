import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String srcFolder = "C:\\Users\\jenny\\Desktop\\src";
        String dstFolder = "C:\\Users\\jenny\\Desktop\\dst";

        File srcDir = new File(srcFolder);
        int threads = Runtime.getRuntime().availableProcessors();
        File[] srcFiles = srcDir.listFiles();

        ArrayList<File[]> arraysList = new ArrayList<>();
        if (srcFiles == null) throw new AssertionError();
        if (srcFiles.length % threads != 0) {
            for (int i = 0; i < threads; i++) {
                if (i < threads - 1) {
                    File[] filesThreadArray = new File[srcFiles.length / threads];
                    System.arraycopy(srcFiles, i > 0 ? i + i : i, filesThreadArray, 0,
                            i < threads - 1 ? srcFiles.length / threads : srcFiles.length / threads + 1);
                    arraysList.add(filesThreadArray);
                } else {
                    File[] files = new File[srcFiles.length - (i + i)];
                    System.arraycopy(srcFiles, i + i, files, 0,
                            srcFiles.length - (i + i));
                    arraysList.add(files);
                }
            }
            for (int i = 0; i < threads; i++) {
                ImageResizer imageResizer = new ImageResizer(arraysList.get(i), dstFolder);
                imageResizer.start();
            }
        }

    }
}

