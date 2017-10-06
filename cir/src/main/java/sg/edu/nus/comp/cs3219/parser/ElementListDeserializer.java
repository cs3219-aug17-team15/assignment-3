package sg.edu.nus.comp.cs3219.parser;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

import sg.edu.nus.comp.cs3219.model.JSONContent;

public class ElementListDeserializer implements JsonDeserializer<List<JSONContent>> {
  public List<JSONContent> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext ctx) {
      List<JSONContent> vals = new ArrayList<JSONContent>();
      if (json.isJsonArray()) {
          for (JsonElement e : json.getAsJsonArray()) {
              vals.add((JSONContent) ctx.deserialize(e, JSONContent.class));
          }
      } else if (json.isJsonObject()) {
          vals.add((JSONContent) ctx.deserialize(json, JSONContent.class));
      } else {
          throw new RuntimeException("Unexpected JSON type: " + json.getClass());
      }
      return vals;
  }
}