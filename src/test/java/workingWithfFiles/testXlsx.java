package workingWithfFiles;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testXlsx {
    public ClassLoader cl = testCsv.class.getClassLoader();

    @DisplayName("Чтение и проверка содержимого Xlsx")
    @Test
    void testFileXlsx () throws Exception{
        ZipFile zf = new ZipFile(new File("zip.zip"));
        ZipInputStream is = new ZipInputStream(cl.getResourceAsStream("zip.zip"));
        ZipEntry entry;
        while ((entry= is.getNextEntry())!=null) {
            if (entry.getName().contains("xlsxTest.xlsx")){
                try (InputStream inputStream = zf.getInputStream(entry)){
                    XLS xls = new XLS(inputStream);
                    assertTrue(xls.excel.getSheetAt(0).getRow(6).getCell(2).getStringCellValue().startsWith("Кишечная палочка"));
                }
            }
        }
    }
}
