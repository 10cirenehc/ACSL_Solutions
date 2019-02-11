import java.util.*;

/* Solution by Eric Chen, 9th grade 

Basis International School Guangzhou 
ACSL CONTEST 2 2018-2019 Junior Division
January 26, 2018
*/

/* This program analyzes a sentence. The first stat returns the number of different 
 * letters in the sentence [1,26]. The second stat returns the number of vowels 
 * in the sentence. The third stat returns the number of capitalized letters. 
 * The fourth stat returns the number of times the most frequent letter appears. 
 * The fifth stat returns the longest word in the sentence. If there's a tie, then 
 * it returns the first one by alphabetical order. 
 */

public class ERIC_CHEN_CONTEST2 {
	
	public static Scanner scanner = new Scanner( System.in );
	
	public static void main (String [] args) {
		System.out.println("Please enter the sentence");
		String input = scanner.nextLine();
		
		String inStr = input.replaceAll("[^A-Za-z]+", "");	
			  
		//System.out.println (inStr);
		
		
		int numVow = 0;
		int diffLett = 0;
		int numUp = 0;
		int freqNum = 0;
		int maxWord = 0;
		int [] charCount = new int[27];
		String longestWord; 
		
		//main for loop for statistics 1-4 
		for (int i = 0; i< inStr.length() ; i++) {
			//stat 1 
			boolean duplicate = hasAppeared(inStr, inStr.charAt(i), i);
			if(duplicate == false) {
				diffLett +=1; 
			}
			
			//stat2 
			if (Character.toString(inStr.charAt(i)).matches("[aeiou]")) {
				numVow++;
			}
			
			//stat3
			if (Character.toString(inStr.charAt(i)).matches("[A-Z]")){
				numUp++;
			}
			
			//stat4
			charCount[charToInt(Character.toLowerCase((inStr.charAt(i))))]++;
				
		}
		//stat4 continued
		for (int j=1; j<= 26; j++) {
			if(charCount[j] > freqNum) {
				freqNum = charCount[j];
			}
		}
		
		//stat5 
		int maxWordPos =0;
		
		String [] words = input.split("[\\p{Punct}\\s]+");
		//System.out.println (words[1]);
		int [] wordLengths = new int[words.length];
		
		for (int k=0; k<words.length; k++) {
			wordLengths[k] += words[k].length();
		}
		for (int l=0; l<wordLengths.length; l++) {
			if (wordLengths[l] > maxWord) {
				maxWord = wordLengths[l];
				maxWordPos = l;
			}
		}
		
		ArrayList <Boolean> mark = new ArrayList <Boolean>();
		int [] sameLengthPos = new int [wordLengths.length];

		
		int counter = 0;
		for (int m=0; m<wordLengths.length; m++) {
			if (wordLengths[m] == maxWord) {
				mark.add(true);
				sameLengthPos [counter] = m;
				counter++; 
			}
		}
		
		String [] potentialAns = new String[mark.size()];
		if(mark.size() == 1) {
			longestWord = words[maxWordPos];
		}
		
		else {
			for (int n=0; n<mark.size(); n++) {
				potentialAns[n] = words[sameLengthPos[n]];
			}
			
			longestWord = potentialAns[0];
			for (int p = 1; p<potentialAns.length; p++) {
				if ((potentialAns[p].toLowerCase()).compareTo(longestWord.toLowerCase())<0) {
					longestWord = potentialAns[p];
				}
			}
		
		
		//print output
		System.out.println(diffLett); //stat1 
		System.out.println(numVow); //stat2
		System.out.println(numUp); //stat3
		System.out.println(freqNum);//stat4
		System.out.println(longestWord);//stat5
		}
	}
	
	//function to determine whether or not the letter has already appeared previously.
	public static boolean hasAppeared(String in, char now, int loop ) {
		for (int i = 0; i< loop ; i++) {
			if (Character.toLowerCase(now) == Character.toLowerCase(in.charAt(i))) {
				return true;
			}
		}
		return false;
	}
	
	//function to determine numeric value of char, from 1-26. Used in indexing arrays.
	public static int charToInt (char in) {
		int charValue = 0;
		
		switch(in) {
		case 'a': 
			charValue = 1;
			break;
		case 'b': 
			charValue = 2;
			break;
		case 'c': 
			charValue = 3;
			break;
		case 'd':  
			charValue= 4;
			break;
		case 'e':
			charValue = 5;
			break;
		case 'f':
			charValue = 6;
			break;
		case 'g': 
			charValue = 7;
			break;
		case 'h':
			charValue = 8;
			break;
		case 'i':
			charValue = 9;
			break;
		case 'j':
			charValue = 10;
			break;
		case 'k' :
			charValue = 11; 
			break;
		case 'l':
			charValue = 12;
			break;
		case 'm':
			charValue = 13;
			break;
		case 'n' :
			charValue = 14;
			break;
		case 'o':
			charValue = 15; 
			break;
		case 'p':
			charValue = 16;
			break;
		case 'q':
			charValue = 17;
			break;
		case 'r' :
			charValue = 18;
			break;
		case 's':
			charValue = 19;
			break;
		case 't':
			charValue = 20;
			break;
		case 'u' :
			charValue = 21;
			break;
		case 'v':
			charValue = 22;
			break;
		case 'w' : 
			charValue = 23;
			break;
		case 'x': 
			charValue = 24; 
			break;
		case 'y':
			charValue = 25;
			break;
		case 'z':
			charValue= 26;
			break;
		}
		return charValue;
	}
	
}
