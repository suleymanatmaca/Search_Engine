package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import utils.pojo.AllContents;
import utils.pojo.Contents;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataHelper extends Initialize {

    @DataProvider
    public AllContents readJsonFile() {
        AllContents allContents = new AllContents();
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;

        //Read JSON File
        Object obj = null;
        try {
            obj = parser.parse(new FileReader(getTestDataPF("ResultTestURL")));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        jsonObject = (JSONObject) obj;

        //Extract array data from JSONObject
        assert jsonObject != null;

        allContents.setGoogleContents(
                getJsonContents(
                        (JSONArray) jsonObject.get("googleContents")
                )
        );
        allContents.setYandexContents(
                getJsonContents(
                        (JSONArray) jsonObject.get("yandexContents")
                )
        );

        return allContents;
    }

    public void writeJsonFile(AllContents allContents) {
        // Convert contentsArrayList to JSON array
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(allContents);

        //Write JSON file
        try (FileWriter file = new FileWriter(getTestDataPF("ResultTestURL"))) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(json);
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Contents> getJsonContents(JSONArray jsonArray) {
        List<Contents> contentsList = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject contentJson = (JSONObject) jsonArray.get(i);
            String title = contentJson.get("title").toString();
            String url = contentJson.get("url").toString();
            String header = contentJson.get("header").toString();

            Contents content = new Contents();
            content.setTitle(title);
            content.setUrl(url);
            content.setHeader(header);

            contentsList.add(content);
        }
        return contentsList;
    }

    public static List<String> getAllContentsHeader(List<Contents> contentsList) {
        return contentsList.stream()
                .map(Contents::getHeader)
                .collect(Collectors.toList());
    }

    public static List<String> getAllContentsUrl(List<Contents> contentsList) {
        return contentsList.stream()
                .map(Contents::getUrl)
                .collect(Collectors.toList());
    }

    public static List<String> getAllContentsTitle(List<Contents> contentsList) {
        return contentsList.stream()
                .map(Contents::getTitle)
                .collect(Collectors.toList());
    }
}