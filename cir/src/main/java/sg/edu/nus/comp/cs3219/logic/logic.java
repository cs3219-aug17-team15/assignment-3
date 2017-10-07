package sg.edu.nus.comp.cs3219.logic;

import java.io.File;
import java.util.Vector;

import sg.edu.nus.comp.cs3219.parser.Parser;
import sg.edu.nus.comp.cs3219.storage.Storage;

public class logic {
  private Storage storage;
  private Parser parser;

  public logic() {
    this.storage = new Storage();
    this.parser = new Parser();
  }

  // Q1: How many documents are there in all datasets put together?
  public int getNumBasePaper() {
    return storage.getDocumentCount();
  }

  // Q2: How many citations are there in all datasets put together?
  public int getNumReferencePaper() {
    File baseDir = storage.getAssetBaseDir();

    return 0;
  }

  // Q3: How many unique citations are there in all datasets put together?
  public int getNumUniqueReferencePaper() {
    return 0;
  }

  // Q4: How many author are mentioned in the citations in all datasets put together?
  public int getNumAuthorReferencePaper() {
    return 0;
  }

  // Q5: What is the range of the years of the cited documents in all datasets put together?
  public int getYearRangeReferencePaper() {
    return 0;
  }

  // Q6: For the conference D12 give number of cited documents published in each of the years 2000
  // to 2015.
  // Answer Format: <year> <integer>
  public Vector<String> getNumReferencePaper(String conference, int from, int to) {
    Vector<String> result = new Vector<String>();
    for (int i = from; i <= to; i++) {
      result.add(i + " " + getNumReferencePaper(conference, i));
    }
    return result;
  }

  public int getNumReferencePaper(String conference, int year) {
    return 0;
  }

  // Q7: Repeat the above step for conferences ‘EMNLP’ and ‘CoNLL’ (instead of years) for the
  // con-ference D13.
  // Answer Format: <conference> <integer>
  public Vector<String> getNumReferencePaper(String conference,
      Vector<String> referencingConference) {
    Vector<String> result = new Vector<String>();
    for (String s : referencingConference) {
      result.add(s + " " + getNumReferencePaper(conference, s));
    }
    return result;
  }

  public int getNumReferencePaper(String conference, String referencingConference) {
    return 0;
  }

  // Q8: For an author ‘Yoshua Bengio’ (also check for Y. Bengio) the number of times he is cited
  // for his work authored in each of the years 2000 to 2015.
  // Answer Format: <year> <integer>
  public Vector<String> getNumReferencePaperByAuthor(Vector<String> conference, String author,
      int from, int to) {
    Vector<String> result = new Vector<String>();
    for (int i = from; i <= to; i++) {
      result.add(i + " " + getNumReferencePaperByAuthor(conference, author, i));
    }
    return result;
  }

  public int getNumReferencePaperByAuthor(Vector<String> conference, String author, int year) {
    int result = 0;
    for (String s : conference) {
      result += getNumReferencePaperByAuthor(s, author, year);
    }
    return result;
  }

  public int getNumReferencePaperByAuthor(String conference, String author, int year) {
    String[] s = author.split(" ");
    String name = "";
    for (int i = 0; i < s.length - 1; i++) {
      name += s[i].charAt(0) + ". ";
    }
    name += s[s.length - 1];
    return 0;
  }

  // Q9: For the conference J14,W14 find number of cited documents published in each of the years
  // from 2010 to 2015.
  // Answer Format: <conference> <year> <integer>
  public Vector<String> getNumReferencePaper(Vector<String> conference, int from, int to) {
    Vector<String> result = new Vector<String>();
    for (String s1 : conference) {
      for (String s2 : getNumReferencePaper(s1, from, to)) {
        result.add(s1 + " " + s2);
      }
    }
    return result;
  }

  // Q10: Repeat the above step for conference ‘NAACL’ for conference Q14,D14
  // Answer Format: <conference> <integer>
  public Vector<String> getNumReferencePaper(Vector<String> conference,
      String referencingConference) {
    Vector<String> result = new Vector<String>();
    for (String s : conference) {
      result.add(s + " " + getNumReferencePaper(s, referencingConference));
    }
    return result;
  }

}
