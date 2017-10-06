package sg.edu.nus.comp.cs3219.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class JSONParser {
  private Gson gson;

  protected JSONParser() {
    this.gson = new GsonBuilder().create();
  }

  protected JsonObject parseJSONFile(File jsonFile) throws FileNotFoundException {
    BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonFile));
    return gson.fromJson(bufferedReader, JsonObject.class);
  }

  protected JsonObject parseJSONString(String jsonString) {
    return gson.fromJson(jsonString, JsonObject.class);
  }
}
