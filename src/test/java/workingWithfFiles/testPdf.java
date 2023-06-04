package workingWithfFiles;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testPdf {
    public ClassLoader cl = testCsv.class.getClassLoader();
    @DisplayName("Чтение и проверка содержимого pdf")
    @Test
    void testFilePdf() throws Exception{
        ZipFile zf = new ZipFile(new File("zip.zip"));
        ZipInputStream is = new ZipInputStream(cl.getResourceAsStream("zip.zip"));
        ZipEntry entry;
        while ((entry = is.getNextEntry()) != null) {
            if (entry.getName().contains("pdfTest.pdf")){
                try (InputStream inputStream = zf.getInputStream(entry)){
                    PDF pdf = new PDF(inputStream);
                    assertEquals("П А М Я Т К А", pdf.text);
                }
            }
        }
    }
}
