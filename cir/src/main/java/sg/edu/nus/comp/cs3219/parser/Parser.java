package sg.edu.nus.comp.cs3219.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import sg.edu.nus.comp.cs3219.model.Citation;
import sg.edu.nus.comp.cs3219.model.Doc;
import sg.edu.nus.comp.cs3219.model.JSONContent;
import sg.edu.nus.comp.cs3219.model.Label;

public class Parser {
  private JSONParser jsonParser;
  private XMLToJSONConverter xmlToJSONConverter;
  private Gson gson;

  private static final int POS_LABEL = 0;
  // private static final int POS_HEAD = 1;
  private static final int POS_CIT = 2;

  private static final String TOKEN_ALGORITHM = "algorithm";
  private static final String TOKEN_ALGORITHMS = "algorithms";
  private static final String TOKEN_CITATIONS = "citationList";
  private static final String TOKEN_CITATION = "citation";
  private static final String TOKEN_VARIANT = "variant";

  public Parser() {
    this.jsonParser = new JSONParser();
    this.xmlToJSONConverter = new XMLToJSONConverter();

    Type jsonContentListType = new TypeToken<List<JSONContent>>() {}.getType();
    this.gson =
        new GsonBuilder().registerTypeAdapter(jsonContentListType, new ElementListDeserializer())
            .registerTypeAdapter(new TypeToken<List<String>>() {}.getType(),
                new CitationAuthorDeserializer())
            .setPrettyPrinting().create();
  }

  public Doc parseFile(String filePath) {
    try {
      File file = new File(filePath);
      String contentType = Files.probeContentType(file.toPath());
      switch (contentType) {
        case "text/xml":
          return parseXML(file);
        case "application/json":
          return parseJSON(file);
        default:
          System.out.println("File of type '" + contentType + "' is not supported");
          break;
      };
    } catch (IOException e) {
      System.err.println("IO error on probing content type of file at: " + filePath);
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      System.err.println("IllegalArgumentException at :" + filePath);
      // System.err.println(e.getLocalizedMessage());
      return null;
    } catch (Exception e) {
      System.err.println("Error occurred at: " + filePath);
      // e.printStackTrace();
    }
    return null;
  }

  public String convertDocToJSONString(Doc doc) {
    return gson.toJson(doc);
  }

  private Doc parseJSON(File file) throws FileNotFoundException {
    JsonObject jsonObject = jsonParser.parseJSONFile(file);
    return convertToDoc(jsonObject);
  }

  private Doc parseXML(File file) throws IOException {
    String JSONString = xmlToJSONConverter.convertToJsonString(file);
    JsonObject jsonObject = jsonParser.parseJSONString(JSONString);
    return convertToDoc(jsonObject);
  }

  private Doc convertToDoc(JsonObject jsonObject) {
    // convert jsonobject to our own class with fields we want
    JsonArray jsonArray = getMainData(jsonObject);
    Label labelData = getLabel(jsonArray);
    // Head headData = getHead(jsonArray);
    List<Citation> citData = getCitations(jsonArray);

    return new Doc(labelData, citData);
  }

  private JsonArray getMainData(JsonObject jsonObject) {
    return jsonObject.getAsJsonObject(TOKEN_ALGORITHMS).getAsJsonArray(TOKEN_ALGORITHM);
  }

  private JsonObject getData(int dataType, JsonArray jsonArray) {
    return jsonArray.get(dataType).getAsJsonObject().getAsJsonObject(TOKEN_VARIANT);
  }

  private Label getLabel(JsonArray jsonArray) {
    JsonObject data = getData(POS_LABEL, jsonArray);
    return gson.fromJson(data, Label.class);
  }

  // private Head getHead(JsonArray jsonArray) {
  // JsonObject data = getData(POS_HEAD, jsonArray);
  // return gson.fromJson(data, Head.class);
  // }

  private List<Citation> getCitations(JsonArray jsonArray) {
    int pos = POS_CIT;
    if (jsonArray.size() == POS_CIT) {
      // for cases where POS_HEAD is missing
      pos--;
    }
    JsonObject citationObject = jsonArray.get(pos).getAsJsonObject();
    if (!citationObject.has(TOKEN_CITATIONS)
        || citationObject.get(TOKEN_CITATIONS).isJsonPrimitive()) {
      return new ArrayList<>();
    }

    JsonObject citations = citationObject.getAsJsonObject(TOKEN_CITATIONS);
    if (!citations.has(TOKEN_CITATION) || citations.get(TOKEN_CITATION).isJsonNull()
        || citations.get(TOKEN_CITATION).isJsonPrimitive()) {
      return new ArrayList<Citation>();
    } else if (citations.get(TOKEN_CITATION).isJsonArray()) {
      return gson.fromJson(citations.getAsJsonArray(TOKEN_CITATION),
          new TypeToken<List<Citation>>() {}.getType());
    }
    JsonObject data = citations.getAsJsonObject(TOKEN_CITATION);
    JsonArray array = new JsonArray();
    array.add(data);
    return gson.fromJson(array, new TypeToken<List<Citation>>() {}.getType());
  }
}
