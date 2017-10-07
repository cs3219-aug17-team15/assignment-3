package sg.edu.nus.comp.cs3219.cir;

import java.util.Vector;

import sg.edu.nus.comp.cs3219.logic.logic;

public class App {
  public static void main(String[] args) throws Exception {
    logic l = new logic();
    System.out.print("Q1: ");
    System.out.println(l.getNumBasePaper()); // 1961

    System.out.print("Q2: ");
    System.out.println(l.getNumReferencePaper()); // 46801

    System.out.print("Q3: ");
    System.out.println(l.getNumUniqueReferencePaper()); // 29118

    System.out.print("Q4: ");
    System.out.println(l.getNumAuthorReferencePaper()); // 128872

    System.out.print("Q5: ");
    System.out.println(l.getYearRangeReferencePaper()); // 109

    System.out.print("Q6: ");
    Vector<String> q6result = l.getNumReferencePaperMultiYear("D12", 2000, 2015);
    printVector(q6result);
    // 2000 105, 2001 88, 2002 165, 2003 217, 2004 223, 2005 246, 2006 306, 2007 361,
    // 2008 358, 2009 385, 2010 458, 2011 480, 2012 84, 2013 0, 2014 0, 2015 0

    System.out.print("Q7: ");
    Vector<String> referencingConference = new Vector<String>();
    referencingConference.add("EMNLP");
    referencingConference.add("CoNLL");
    Vector<String> q7result = l.getNumReferencePaperMultiReference("D13", referencingConference);
    printVector(q7result); // EMNLP 347, CoNLL 118

    System.out.print("Q8: ");
    Vector<String> conference = new Vector<String>();
    conference.add("D12");
    conference.add("D13");
    conference.add("D14");
    conference.add("D15");
    Vector<String> q8result = l.getNumReferencePaperByAuthor(conference, "Yoshua Bengio", 2000, 2015);
    printVector(q8result); // 2000 0, 2001 2, 2002 0, 2003 51, 2004 0, 2005 8, 2006 10, 2007 1, 2008 2, 2009 7, 2010 57, 2011 20, 2012 18, 2013 15, 2014 25, 2015 11

    System.out.print("Q9: ");
    conference = new Vector<String>();
    conference.add("J14");
    conference.add("W14");
    Vector<String> q9result = l.getNumReferencePaperMultiConferenceWithYear(conference, 2000, 2015);
    printVector(q9result);
    // J14 2000 36, J14 2001 33, J14 2002 68, J14 2003 90, J14 2004 101, J14 2005 113, J14 2006 97, J14 2007 151,
    // J14 2008 136, J14 2009 157, J14 2010 160, J14 2011 115, J14 2012 108, J14 2013 40, J14 2014 7, J14 2015 0,
    // W14 2000 356, W14 2001 373, W14 2002 627, W14 2003 810, W14 2004 695, W14 2005 782, W14 2006 918, W14 2007 982,
    // W14 2008 1164, W14 2009 1118, W14 2010 1555, W14 2011 1551, W14 2012 1836, W14 2013 2214, W14 2014 979, W14 2015 1

    System.out.print("Q10: ");
    conference = new Vector<String>();
    conference.add("Q14");
    conference.add("D14");
    Vector<String> q10result = l.getNumReferencePaperMultiConference(conference, "NAACL");
    printVector(q10result); // Q14 78, D14 334
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
