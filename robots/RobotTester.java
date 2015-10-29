package robots;

public class RobotTester {

	public static void main(String[] args) {
		
		Robot robot = new Robot();
		
		robot.move(11);
		robot.checkBattery();
		robot.recharge(2.5);
		robot.recharge(0.5);
		robot.move(5);
		robot.checkBattery();
		
		int repetitions = 10;
		
		TalkingRobot neuroticBot = new TalkingRobot("neuroticBot");
		String[] evilSayings = {"Exterminate, exterminate!", "I obey!", "You cannot escape!", "Robots do not feel fear.", "The Robots must survive!"};
		neuroticBot.setRepertoire(evilSayings);
		neuroticBot.identifySelf();
		neuroticBot.sayRandomThings(repetitions);
		
		System.out.println();
		
		TalkingRobot goodBot = new TalkingRobot("goodBot");
		String[] goodSayings = {"I obey!"};
		goodBot.setRepertoire(goodSayings);
		goodBot.identifySelf();
		goodBot.sayRandomThings(repetitions);
		
	}

}
