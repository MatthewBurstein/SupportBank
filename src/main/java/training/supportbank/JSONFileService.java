package training.supportbank;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

import java.time.LocalDate;
import java.util.stream.Stream;

public class JSONFileService {

    private final String filePath;

    public JSONFileService(String filePath) {
        this.filePath = filePath;
    }

//    public void parseJSON() {
//        GsonBuilder gsonBuilder = new GsonBuilder();
//        gsonBuilder.registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (jsonElement, type, jsonDeserializationContext) -> {
//                System.out.println(jsonElement);
//    });
//        Gson gson = gsonBuilder.create();
//        System.out.println(gson);
//    }

}
