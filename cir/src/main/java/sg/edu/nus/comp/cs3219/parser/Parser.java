package sg.edu.nus.comp.cs3219.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

import com.google.gson.JsonObject;

public class Parser {
  private JSONParser jsonParser;
  private XMLToJSONConverter xmlToJSONConverter;

  public Parser() {
    this.jsonParser = new JSONParser();
    this.xmlToJSONConverter = new XMLToJSONConverter();
  }

  public JsonObject parseFile(String filePath) {
    try {
      File file = new File(filePath);
      String contentType = Files.probeContentType(file.toPath());
      switch (contentType) {
        case "text/xml":
          return parseXML(file);
        case "application/json":
          return parseJSON(file);
        default:
          System.out.println("File of type '" +  contentType + "' is not supported");
          break;
      };
    } catch (IOException e) {
      System.err.println("IO error on probing content type of file at: " + filePath);
      e.printStackTrace();
    }
    return null;
  }

  private JsonObject parseJSON(File file) throws FileNotFoundException {
    return jsonParser.parseJSONFile(file);
  }

  private JsonObject parseXML(File file) throws IOException {
    String JSONString = xmlToJSONConverter.convertToJsonString(file);
    return jsonParser.parseJSONString(JSONString);
  }

  private void convertJsonObject(JsonObject jsonObject) {
    // convert jsonobject to our own class with fields we want
  }
}
