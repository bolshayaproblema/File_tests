package workingwithfiles;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.TestJsonPokemon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;

public class TestJson {
    public ClassLoader cl = TestJson.class.getClassLoader();

    @DisplayName("Чтение и проверка содержимого файла json")
    @Test
    void jsonParseTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream is = cl.getResourceAsStream("test.json");
             InputStreamReader isr = new InputStreamReader(is)) {
            TestJsonPokemon testJson = objectMapper.readValue(isr, TestJsonPokemon.class);
            Assertions.assertEquals("Pikachu", testJson.getName());
            Assertions.assertEquals(6, testJson.getWeight());
            Assertions.assertEquals("paralysis", testJson.getTalents());
            Assertions.assertEquals("mouse", testJson.getView());
            Assertions.assertEquals("the first", testJson.getEvolution().get(0).getStage());
            Assertions.assertEquals("Sandshru", testJson.getEvolution().get(1).getTitle());
        }
    }
}