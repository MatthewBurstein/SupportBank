package training.supportbank;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JSONParser {

    private final String filePath;
    private final ArrayList<Transaction> data;

    public JSONParser(String filePath) {
        this.filePath = filePath;
        this.data = new ArrayList<>();
        this.data.addAll(parseJson());
    }

    public List<Transaction> getTransactions() {
        return data;
    }

    public Set<String> getAccountNames() {
        Set<String> accountNames = data
                .stream()
                .map(Transaction::getFromAccount)
                .collect(Collectors.toSet());
        Set<String> otherAccountNames = data
                .stream()
                .map(Transaction::getToAccount)
                .collect(Collectors.toSet());
        accountNames.addAll(otherAccountNames);
        return accountNames;
    }

    private List<Transaction> parseJson() {
        FileReader fileReader = null;
        Type collectionType = new TypeToken<ArrayList<Transaction>>(){}.getType();
        try {
            fileReader = new FileReader(filePath);

        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        JsonReader jsonReader = new JsonReader(fileReader);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (jsonElement, type, jsonDeserializationContext) -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(jsonElement.getAsString(), formatter);
        });
        Gson gson = gsonBuilder.create();
        return  gson.fromJson(jsonReader, collectionType);
    }
}
