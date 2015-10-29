package dna;

import java.util.Arrays;

public class DNAStrand {
	
	private String sequence;
	private char[] dnaArray;
	private char[] complementArray;
	
	public DNAStrand (String sequence){
		this.sequence = sequence;
		dnaArray = sequence.toCharArray();
		complementArray = new char[sequence.length()];
	}

	public String toString(){
		return sequence;
	}
	
	public boolean isValidDNA(){	
		boolean valid = false;
		if (sequence.length() > 0) {
			for (int i = 0; i < sequence.length(); i++){
				switch (dnaArray[i]){
					case 'A': case 'C': case 'G': case 'T':
						valid = true;
						break;
					default:
						return false;
				}
			}
		}
		return valid;
	}
	
	public String complementWC(){
		
		for (int i = 0; i < sequence.length(); i++){
			switch(dnaArray[i]){
				case 'A': 
					complementArray[i] = 'T';
					break;
				case 'C': 
					complementArray[i] = 'G';
					break;
				case 'G':
					complementArray[i] = 'C';
					break;
				case 'T':
					complementArray[i] = 'A';
					break;
			}
		}	
		String complement = Arrays.toString(complementArray);
		return complement;
	}
	
	public String palindromeWC(){
		
		char[] palindromeArray = new char[sequence.length()];
		for (int i = 0; i < sequence.length(); i++){
			palindromeArray[i] = complementArray[sequence.length() - (i + 1)];
		}
		String palindrome = Arrays.toString(palindromeArray);
		return palindrome;
	}
	
	public boolean containsSubsequence(String subsequence){
		return sequence.contains(subsequence);
	}
		
}
