package sg.edu.nus.comp.cs3219.model;

public class JSONContent {
  private String confidence;
  private String content;

  public String getContent() {
    return content;
  }

  public double getConfidence() {
    if (this.confidence == null || this.confidence.isEmpty()) {
      return 1;
    }
    return Double.parseDouble(confidence);
  }
}
