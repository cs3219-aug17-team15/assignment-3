package sg.edu.nus.comp.cs3219.parser;

import junit.framework.TestCase;

public class XMLToJSONConverterTest extends TestCase {
  private XMLToJSONConverter parser1 = null;
  private XMLToJSONConverter parser2 = null;

  protected void setUp() throws Exception {
    super.setUp();
    parser1 = XMLToJSONConverter.getInstance();
    parser2 = XMLToJSONConverter.getInstance();
  }

  public void testUnique() {
    assertEquals(true, parser1 == parser2);
  }

  public void testXMLStringToJSON() {
    String input = "<note>\n" +
        "<heading>Reminder</heading>\n" +
        "<body>Do assignment!</body>\n" +
        "</note>";
    String expected = "{\"note\": {\n" +
        "    \"heading\": \"Reminder\",\n" +
        "    \"body\": \"Do assignment!\"\n" +
        "}}";
    assertEquals(expected, parser1.convertToJsonString(input));
  }
}
