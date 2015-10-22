package arrays;
public class ArrayElementRemoval {

	public static void main(String[] args) {

		String sentence = new String("The quick brown fox jumps over the lazy dog");
		String [] sentenceSplit = sentence.split(" ");
		int position = 7;
		
		System.out.println("Original sentence:");
		for (int i = 0; i < sentenceSplit.length; i++){
			System.out.print(sentenceSplit[i] + "\t");
		}
		
		System.out.println();
		System.out.println("New sentence:");
		String [] newSentence = removeElement(sentenceSplit, position); 
		
		for (int i = 0; i < newSentence.length; i++){
			System.out.print(newSentence[i] + "\t");
		}

	}
	
	public static String[] removeElement(String[] sentenceSplit, int position){
		
		String[] newSentence = new String[sentenceSplit.length - 1]; // Reference: https://moodle.ucl.ac.uk/pluginfile.php/3082019/mod_resource/content/1/Tutorial%202.pdf
		
		int i = 0, j = 0;
		
		while (i < sentenceSplit.length){
			if (i == position){
				i++;
			} else {
				newSentence[j] = sentenceSplit[i];
				i++;
				j++;
			}
		}
		
		return newSentence;
	}
	
	
}
