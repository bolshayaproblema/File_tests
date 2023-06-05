package workingWithfFiles;


import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class testXlsx {
    public ClassLoader cl = testCsv.class.getClassLoader();

    @DisplayName("Чтение и проверка содержимого Xlsx")
    @Test
    void testFileXlsx () throws Exception{
        try (InputStream is = cl.getResourceAsStream("test.zip");
             ZipInputStream zs = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zs.getNextEntry()) != null) {
                if (entry.getName().contains("xlsxTest.xlsx")) {
                    XLS xls = new XLS(zs);
                    Assertions.assertTrue(
                            xls.excel.getSheetAt(0).getRow((0)).getCell(1)
                                    .getStringCellValue().contains("Международная классификация болезней Десятого пересмотра"));
                }
            }
        }
    }
}