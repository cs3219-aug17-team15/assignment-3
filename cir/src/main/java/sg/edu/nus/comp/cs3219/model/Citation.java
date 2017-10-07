package sg.edu.nus.comp.cs3219.model;

import java.util.ArrayList;
import java.util.List;

public class Citation {
  private boolean valid;

  // numbers represented as string for serialization
  private String date;
  private String issue;
  private String volume;
  private String number; // no idea

  private String booktitle;
  private String editor;
  private String institution;
  private String journal;
  private String location;
  private String marker;
  private String note;
  private String pages;
  private String publisher;
  private String tech;
  private String title;

  private CitationAuthors authors;

  public class CitationAuthors {
    private List<String> author;
  }

  public List<String> getAuthors() {
    if (authors == null || authors.author == null) {
      return new ArrayList<String>();
    }
    return authors.author;
  }

  // Boolean
  public boolean hasAuthors() {
    return authors != null && authors.author != null;
  }

  public boolean hasBookTitle() {
    return booktitle != null && !booktitle.isEmpty();
  }

  public boolean hasDate() {
    return date != null && !date.isEmpty();
  }

  public boolean isValid() {
    return valid;
  }

  // Integers
  public int getDate() {
    return Integer.parseInt(date);
  }

  public int getIssue() {
    return Integer.parseInt(issue);
  }

  public int getNumber() {
    return Integer.parseInt(number);
  }

  public int getVolume() {
    return Integer.parseInt(volume);
  }

  // Strings
  public String getBooktitle() {
    return booktitle;
  }

  public String getEditor() {
    return editor;
  }

  public String getInstitution() {
    return institution;
  }

  public String getJournal() {
    return journal;
  }

  public String getLocation() {
    return location;
  }

  public String getMarker() {
    return marker;
  }

  public String getNote() {
    return note;
  }

  public String getPages() {
    return pages;
  }

  public String getPublisher() {
    return publisher;
  }

  public String getTech() {
    return tech;
  }

  public String getTitle() {
    return title;
  }

}
