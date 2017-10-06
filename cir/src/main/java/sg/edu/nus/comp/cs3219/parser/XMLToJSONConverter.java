package sg.edu.nus.comp.cs3219.parser;

import java.io.File;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import com.jcabi.xml.XMLDocument;

public class XMLToJSONConverter {
  private int PRETTY_PRINT_INDENT_FACTOR = 4;

  protected XMLToJSONConverter() {
    // For instantiation
  }

  protected String convertToJsonString(File xmlFile) throws IOException {
    String xmlString = getXMLFileContentsAsString(xmlFile);
    String jsonString = getJSONString(xmlString);
    return jsonString;
  }

  protected String convertToJsonString(String xmlString) throws JSONException {
    return getJSONString(xmlString);
  }

  private String getXMLFileContentsAsString(File file) throws IOException {
    return new XMLDocument(file).toString();
  }

  private String getJSONString(String xmlString) throws JSONException {
    JSONObject xmlJSONObj = XML.toJSONObject(xmlString);
    return xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
  }
}
