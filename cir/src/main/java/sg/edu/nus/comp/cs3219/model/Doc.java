package sg.edu.nus.comp.cs3219.model;

import java.util.List;
import java.util.stream.Collectors;

public class Doc {
  protected static final double BASE_CONFIDENCE = 0.80;
  protected static List<String> getFilteredResults(List<JSONContent> list) {
    return list.stream().filter(elm -> elm.getConfidence() > BASE_CONFIDENCE)
        .map(elm -> elm.getContent()).collect(Collectors.toList());
  }

  private Label label;
  private List<Citation> citationList;

  public Doc(Label label, List<Citation> citationList) {
    this.label = label;
    this.citationList = citationList;
  }

  public List<Citation> getValidCitations() {
    return this.citationList.stream().filter(cit -> cit.isValid()).collect(Collectors.toList());
  }

  public int getValidCitationCount() {
    return Math.toIntExact(this.citationList.stream().filter(cit -> cit.isValid()).count());
  }

  public List<String> getCitationAuthors() {
    return this.citationList.stream().map(cit -> cit.getAuthors()).flatMap(List::stream).collect(Collectors.toList());
  }

  public List<String> getTitle() {
    return this.label.getTitle();
  }
}
