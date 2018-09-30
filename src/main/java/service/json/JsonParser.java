package service.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entity.ExchangeCourse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JsonParser {

    public List<ExchangeCourse> parseToCollection(String jsonMessage) {
        List<ExchangeCourse> currencyList = new ArrayList<>();
        try {
            Gson gson = new Gson();
            Type collectionType = new TypeToken<Collection<ExchangeCourse>>(){}.getType();
            Collection<ExchangeCourse> enums = gson.fromJson(jsonMessage, collectionType);

            currencyList.addAll(enums);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return currencyList;
    }
}