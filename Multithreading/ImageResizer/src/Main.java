import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String srcFolder = "C:\\Users\\jenny\\Desktop\\src";
        String dstFolder = "C:\\Users\\jenny\\Desktop\\dst";

        File srcDir = new File(srcFolder);
        int threads = Runtime.getRuntime().availableProcessors();

        File[] files1 = srcDir.listFiles();
        int middle = files1.length / threads;
        ArrayList<File[]> list = new ArrayList<>();
        if (files1.length % threads != 0) {
            for (int i = 0; i < threads; i++) {
                if (i < threads - 1) {
                    File[] files = new File[files1.length / threads];
                    System.arraycopy(files1, i > 0 ? i + 2 : i, files, 0,
                            i < threads - 1 ? files1.length / threads : files1.length / threads + 1);
                    list.add(files);
                } else {
                    File[] files = new File[files1.length / threads + 1];
                    System.arraycopy(files1, 13, files, 0,
                            files1.length / threads + 1);
                    list.add(files);
                }
            }
        }
        for(int i = 0; i < threads; i++){
            ImageResizer imageResizer = new ImageResizer(list.get(i), dstFolder);
            imageResizer.start();
        }
    }
}
