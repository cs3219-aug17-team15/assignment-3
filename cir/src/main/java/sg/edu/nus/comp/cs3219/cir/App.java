package sg.edu.nus.comp.cs3219.cir;

import java.io.File;

import sg.edu.nus.comp.cs3219.parser.XMLToJSONConverter;

/**
 * Hello world!
 *
 */
public class App {
  private static XMLToJSONConverter xmlToJSONConverter;

  public static void main(String[] args) {
    xmlToJSONConverter = XMLToJSONConverter.getInstance();

    String cwd = System.getProperty("user.dir");
    File xmlFile = new File(cwd + XMLToJSONConverter.XMLAssetBasePath + "/D/D12/D12-1004-parscit.130908.xml");
    System.out.println(xmlToJSONConverter.convertToJsonString(xmlFile));
  }

}
