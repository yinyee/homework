package robots;

import java.util.Random;

public class TalkingRobot extends Robot {
	
	private String[] repertoire = { };
	
	public TalkingRobot(String name){
		this.name = name;
	}
	
	public void identifySelf(){
		System.out.println("I am " + name);
	}
	
	public void setRepertoire(String[] repertoire){
		this.repertoire = repertoire;
	}

	public void sayRandomThings(int repetitions){
		Random random = new Random(); // Reference: https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
		int randomIndex;
		for (int i = 0; i < repetitions; i++){
			randomIndex = random.nextInt(repertoire.length);
			System.out.println(repertoire[randomIndex]);
		}
	}
}
