package workingWithfFiles;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.testJsonPokemon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;

public class testJson {
    public ClassLoader cl = testJson.class.getClassLoader();

    @DisplayName("Чтение и проверка содержимого файла json")
    @Test
    void jsonParseTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream is = cl.getResourceAsStream("test.json");
             InputStreamReader isr = new InputStreamReader(is)) {
            testJsonPokemon testJson = objectMapper.readValue(isr, testJsonPokemon.class);
            Assertions.assertEquals("Pikachu", testJson.getName());
            Assertions.assertEquals(6, testJson.getWeight());
            Assertions.assertEquals("paralysis", testJson.getTalents());
            Assertions.assertEquals("mouse", testJson.getView());
            Assertions.assertEquals("the first", testJson.getEvolution().get(0).getStage());
            Assertions.assertEquals("Sandshru", testJson.getEvolution().get(1).getTitle());
        }
    }
}