package service.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entity.Currency;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JsonParser {

    public List<Currency> parseToCollection(String jsonMessage, Set<String> requiredCurrencies) {
        List<Currency> currencyList = new ArrayList<>();
        try {
            Gson gson = new Gson();
            Type collectionType = new TypeToken<Collection<Currency>>() {
            }.getType();
            Collection<Currency> enums = gson.fromJson(jsonMessage, collectionType);

            currencyList.addAll(enums.stream().filter(p -> requiredCurrencies.contains(p.getCc()))
                    .distinct().collect(Collectors.toList()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return currencyList;
    }
}