package sg.edu.nus.comp.cs3219.logic;

import java.util.Vector;

public class logic {
	//Q1: How many documents are there in all datasets put together? 
	int getNumBasePaper() {
		return 0;
	}
	//Q2: How many citations are there in all datasets put together? 
	int getNumReferencePaper() {
		return 0;
	}

	//Q3: How many unique citations are there in all datasets put together?
	int getNumUniqueReferencePaper() {
		return 0;
	}
	
	//Q4: How many author are mentioned in the citations in all datasets put together? 
	int getNumAuthorReferencePaper() {
		return 0;
	}

	//Q5: What is the range of the years of the cited documents in all datasets put together? 
	int getYearRangeReferencePaper() {
		return 0;
	}

	//Q6: For the conference D12 give number of cited documents published in each of the years 2000 to 2015.
	//Answer Format: <year> <integer>
	Vector<String> getNumReferencePaper(String conference, int From, int to) {
		Vector<String> result = new Vector<String>();
		return result;
	}

	//Q7: Repeat the above step for conferences ‘EMNLP’ and ‘CoNLL’ (instead of years) for the con-ference D13.
	//Answer Format: <conference> <integer>
	Vector<String> getNumReferencePaper(String conference, Vector<String> referencingConference) {
		Vector<String> result = new Vector<String>();
		return result;
	}

	//Q8: For an author ‘Yoshua Bengio’ (also check for Y. Bengio) the number of times he is cited for his work authored in each of the years 2000 to 2015.
	//Answer Format: <year> <integer>
	Vector<String> getNumReferencePaperByAuthor(String author, int From, int to) {
		Vector<String> result = new Vector<String>();
		return result;
	}

	//Q9: For the conference J14,W14 find number of cited documents published in each of the years from 2010 to 2015.
	//Answer Format: <conference> <year> <integer>
	Vector<String> getNumReferencePaper(Vector<String> conference, int From, int to) {
		Vector<String> result = new Vector<String>();
		return result;
	}

	//Q10: Repeat the above step for conference ‘NAACL’ for conference Q14,D14
	//Answer Format: <conference> <integer>
	Vector<String> getNumReferencePaper(Vector<String> conference, String referencingConference) {
		Vector<String> result = new Vector<String>();
		return result;
	}

}
