package robots;

public class Robot {

	protected String name;
	protected double batteryCharge;
	
	public Robot (){
		batteryCharge = 5;
		name = "Unknown";
	}

	public void checkBattery() {
		System.out.println("Battery charge is now " + batteryCharge);
	}
	
	public void recharge(double additionalCharge){
		batteryCharge += additionalCharge;
		checkBattery();
	}
	
	public void move(int steps){
		System.out.print("Robot commanded to move " + steps + " steps:");
		for (int i = 1; i < steps + 1; i++){
			if (batteryCharge !=0){
				System.out.print("[" + i + "]\t");
				batteryCharge -= 0.5;
			} else {
				System.out.print("Battery flat! Move command not completed.\n");
			}
		}
	}
	
}


