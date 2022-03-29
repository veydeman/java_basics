import java.io.File;

public class FileUtils {

    private static final int ONE = 1;
    private static final int STEP = 1024;

    public static long calculateFolderSize(String path) {
        File folder = new File(path);
        long sum = 0;
        if (folder.isFile()) {
            return folder.length();
        }
        File[] files = folder.listFiles();
        for (File f : files) {
            sum += calculateFolderSize(f.getPath());
        }
        return sum;
    }

    public static String getHumanReadableSize(long size) {
        long kb = size / STEP;
        long mb = kb / STEP;
        long gb = mb / STEP;
        long tb = gb / STEP;

        if (tb > ONE) {
            return tb + " Tb";
        }

        if (gb > ONE) {
            return gb + " Gb";
        }

        if (mb > ONE) {
            return mb + " Mb";
        }

        if (kb > ONE) {
            return kb + " Kb";
        }
        return Long.toString(size);
    }
}
