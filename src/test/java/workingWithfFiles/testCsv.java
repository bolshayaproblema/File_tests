package workingWithfFiles;

import com.opencsv.CSVReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class testCsv {
    public ClassLoader cl = testCsv.class.getClassLoader();

    @DisplayName("Чтение и проверка содержимого csv")
    @Test
    void testFileCsv() throws Exception {
        ZipFile zf = new ZipFile(new File("zip.zip"));
        ZipInputStream is = new ZipInputStream(cl.getResourceAsStream("zip.zip"));
        ZipEntry entry;
        while ((entry = is.getNextEntry()) != null) {
            if (entry.getName().contains("csvTest.csv")) {
                try (InputStream inputStream = zf.getInputStream(entry)) {
                    CSVReader csvReader = new CSVReader(new InputStreamReader(inputStream));
                    List<String[]> content = csvReader.readAll();
                    assertArrayEquals(new String[]{"город Москва", "Ходынский бульвар", "дом 4"}, content.get(1));
                }
            }
        }
    }
}