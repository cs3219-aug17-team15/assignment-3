package sg.edu.nus.comp.cs3219.model;

import java.util.List;

public class Label {
  private List<JSONContent> title;
  private List<JSONContent> author;

  public List<String> getAuthors() {
    return Doc.getFilteredResults(author);
  }

  public List<String> getTitle() {
    return Doc.getFilteredResults(title);
  }
}
