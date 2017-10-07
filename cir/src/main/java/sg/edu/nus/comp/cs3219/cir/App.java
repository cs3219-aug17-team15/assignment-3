package sg.edu.nus.comp.cs3219.cir;

import java.util.Vector;

import sg.edu.nus.comp.cs3219.logic.logic;

public class App {
  public static void main(String[] args) throws Exception {
    logic l = new logic();
    System.out.print("Q1: ");
    System.out.println(l.getNumBasePaper()); // 1961
//    System.out.print("Q2: ");
//    System.out.println(l.getNumReferencePaper()); // 46801
//    System.out.print("Q3: ");
//    System.out.println(l.getNumUniqueReferencePaper()); // 29118
//    System.out.print("Q4: ");
//    System.out.println(l.getNumAuthorReferencePaper()); // 128872
//    System.out.print("Q5: ");
//    System.out.println(l.getYearRangeReferencePaper()); // 109
    System.out.print("Q6: ");
    Vector<String> result = l.getNumReferencePaper("D12", 2000, 2015);
    for (String s : result) {
      System.out.print(s + ", ");
    }
    System.out.println();
    System.out.print("Q7: ");
    Vector<String> referencingConference = new Vector<String>();
    referencingConference.add("EMNLP");
    referencingConference.add("CoNLL");
    result = l.getNumReferencePaper("D13", referencingConference);
    for (String s : result) {
      System.out.print(s + ", ");
    }
    System.out.println("");
    System.out.print("Q8: ");
    Vector<String> conference = new Vector<String>();
    conference.add("D12");
    conference.add("D13");
    conference.add("D14");
    conference.add("D15");
    result = l.getNumReferencePaperByAuthor(conference, "Yoshua Bengio", 2000, 2015);
    for (String s : result) {
      System.out.print(s + ", ");
    }
    System.out.println("");
    System.out.print("Q9: ");
    conference = new Vector<String>();
    conference.add("J14");
    conference.add("W14");
    result = l.getNumReferencePaper(conference, 2000, 2015);
    for (String s : result) {
      System.out.print(s + ", ");
    }
    System.out.println("");
    System.out.print("Q10: ");
    conference = new Vector<String>();
    conference.add("Q14");
    conference.add("D14");
    result = l.getNumReferencePaper(conference, "NAACL");
    for (String s : result) {
      System.out.print(s + ", ");
    }
    System.out.println("");
  }

}
