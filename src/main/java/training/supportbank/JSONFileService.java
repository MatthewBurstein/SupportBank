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

public class JSONFileService {

    private final String filePath;

    public JSONFileService(String filePath) {
        this.filePath = filePath;
    }

    public List<Transaction> parse() {
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
