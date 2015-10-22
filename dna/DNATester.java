package dna;

public class DNATester {
	
	public static void main(String[] args){
		
		System.out.println("DNA strand 1");
		DNAStrand dna1 = new DNAStrand("AGTGCA");
		summarise(dna1);
		System.out.println("Contains subsequence 'TGC': " + dna1.containsSubsequence("TGC"));
		
		System.out.println();
		
		System.out.println("DNA strand 2");
		DNAStrand dna2 = new DNAStrand("AGTBCA");
		summarise(dna2);
		System.out.println("Contains subsequence 'TGC': " + dna2.containsSubsequence("TGC"));
	}
	
	public static void summarise(DNAStrand dnaStrand){
		
		System.out.println("Original DNA sequence: " + dnaStrand.toString());
		System.out.println("This DNA sequence is valid: " + dnaStrand.isValidDNA());
		if (dnaStrand.isValidDNA()){
			System.out.println("The Watson Crick complement is: " + dnaStrand.complementWC());
			System.out.println("The Watson Crick palindrome is: " + dnaStrand.palindromeWC());
		}
	}

}
