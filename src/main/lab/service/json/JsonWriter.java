package service.json;


import entity.Currency;
import org.json.simple.JSONArray;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonWriter {

    public void writeJson(List<Currency> courses, String filePath) {
        try (FileWriter file = new FileWriter(filePath)) {
            JSONArray.writeJSONString(courses, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
