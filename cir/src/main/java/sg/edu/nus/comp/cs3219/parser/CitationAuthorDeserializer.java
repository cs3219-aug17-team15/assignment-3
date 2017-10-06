package sg.edu.nus.comp.cs3219.parser;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

public class CitationAuthorDeserializer implements JsonDeserializer<List<String>> {
  public List<String> deserialize(JsonElement json, Type typeOfT,
      JsonDeserializationContext ctx) {
    List<String> vals = new ArrayList<String>();
    if (json.isJsonArray()) {
      for (JsonElement e : json.getAsJsonArray()) {
        vals.add(e.getAsString());
      }
    } else if (json.isJsonObject() || json.isJsonPrimitive()) {
      vals.add(json.getAsString());
    } else {
      throw new RuntimeException("Unexpected JSON type: " + json.getClass());
    }
    return vals;
  }
}
