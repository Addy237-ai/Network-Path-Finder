import java.io.File;

/*
 * CheckFile validates the input file before loading.
 */
public class CheckFile {

    public static boolean isValidCsv(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            return false;
        }

        File file = new File(filePath);

        return file.exists()
                && file.isFile()
                && filePath.toLowerCase().endsWith(".csv");
    }
}
