package sg.edu.nus.comp.cs3219.parser;

import java.io.File;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import com.jcabi.xml.XMLDocument;

public class XMLToJSONConverter {
  public static String XMLAssetBasePath = "/assets/XML";

  private static XMLToJSONConverter instance = null;
  private int PRETTY_PRINT_INDENT_FACTOR = 4;

  protected XMLToJSONConverter() {
    // For instantiation
  }

  public static XMLToJSONConverter getInstance() {
    if(instance == null) {
      instance = new XMLToJSONConverter();
   }
   return instance;
  }

  public String convertToJsonString(File xmlFile) {
    try {
      String xmlString = getXMLFileContentsAsString(xmlFile);
      String jsonString = getJSONString(xmlString);
      return jsonString;
    } catch (IOException e) {
      System.err.println(e);
    }
    return null;
  }

  public String convertToJsonString(String xmlString) {
    try {
      return getJSONString(xmlString);
    } catch (JSONException e) {
      System.err.println(e);
    }
    return null;
  }

  private String getXMLFileContentsAsString(File file) throws IOException {
    return new XMLDocument(file).toString();
  }

  private String getJSONString(String xmlString) throws JSONException {
    JSONObject xmlJSONObj = XML.toJSONObject(xmlString);
    return xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
  }
}
