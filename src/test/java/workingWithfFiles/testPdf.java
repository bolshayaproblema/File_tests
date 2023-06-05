package workingWithfFiles;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class testPdf {
    public ClassLoader cl = testCsv.class.getClassLoader();
    @DisplayName("Чтение и проверка содержимого pdf")
    @Test
    void testFilePdf() throws Exception{
        try (InputStream is = cl.getResourceAsStream("test.zip");
             ZipInputStream zs = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zs.getNextEntry()) != null) {
                if (entry.getName().contains("pdfTest.pdf")) {
                    PDF pdf = new PDF(zs);
                    Assertions.assertTrue(pdf.text.contains("П А М Я Т К А"));
                }
            }
        }
    }
}
