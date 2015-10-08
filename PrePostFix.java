
public class PrePostFix {

	public static void main(String[] args) {
		
		int countPre = 10, countPost = 10;
		System.out.println("At the beginning: ");
		System.out.println("countPre: " + countPre + "\ncountPost: " + countPost + "\n");
		System.out.println("And now we increment:");
		System.out.println("countPre: " + ++countPre + "\ncountPost: " + countPost++ +"\n");
		
		for (countPre = 1; countPre < 5; countPre++){
			System.out.println("countPre: " + countPre);
		}
		
		System.out.println();
		
		for (countPost = 1; countPost < 5; ++countPost){
			System.out.println("countPost: " +  countPost);
		}
	}

}
