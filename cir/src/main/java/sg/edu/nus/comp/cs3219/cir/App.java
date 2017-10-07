package sg.edu.nus.comp.cs3219.cir;

import java.util.Vector;

import sg.edu.nus.comp.cs3219.logic.logic;

public class App {
  public static void main(String[] args) throws Exception {
    logic l = new logic();
//    System.out.print("Q1: ");
//    System.out.println(l.getNumBasePaper()); // 1961

//    System.out.print("Q2: ");
//    System.out.println(l.getNumReferencePaper()); // 46801

//    System.out.print("Q3: ");
//    System.out.println(l.getNumUniqueReferencePaper()); // 29118

//    System.out.print("Q4: ");
//    System.out.println(l.getNumAuthorReferencePaper()); // 128872

//    System.out.print("Q5: ");
//    System.out.println(l.getYearRangeReferencePaper()); // 109

//    System.out.print("Q6: ");
//    Vector<String> q6result = l.getNumReferencePaper("D12", 2000, 2015);
//    printVector(q6result); // 2000 105, 2001 88, 2002 165, 2003 217, 2004 223, 2005 246, 2006 306, 2007 361, 2008 358, 2009 385, 2010 458, 2011 480, 2012 84, 2013 0, 2014 0, 2015 0

    System.out.print("Q7: ");
    Vector<String> referencingConference = new Vector<String>();
    referencingConference.add("EMNLP");
    referencingConference.add("CoNLL");
    Vector<String> q7result = l.getNumReferencePaper("D13", referencingConference);
    printVector(q7result);

    System.out.print("Q8: ");
    Vector<String> conference = new Vector<String>();
    conference.add("D12");
    conference.add("D13");
    conference.add("D14");
    conference.add("D15");
    Vector<String> q8result = l.getNumReferencePaperByAuthor(conference, "Yoshua Bengio", 2000, 2015);
    printVector(q8result);

    System.out.print("Q9: ");
    conference = new Vector<String>();
    conference.add("J14");
    conference.add("W14");
    Vector<String> q9result = l.getNumReferencePaper(conference, 2000, 2015);
    printVector(q9result);

    System.out.print("Q10: ");
    conference = new Vector<String>();
    conference.add("Q14");
    conference.add("D14");
    Vector<String> q10result = l.getNumReferencePaper(conference, "NAACL");
    printVector(q10result);
  }

  private static void printVector(Vector<?> vector) {
    for (int i = 0; i < vector.size(); i++) {
      if (i == vector.size() - 1) {
        System.out.println(vector.get(i));
      } else {
        System.out.print(vector.get(i) + ", ");
      }
    }
  }

}
