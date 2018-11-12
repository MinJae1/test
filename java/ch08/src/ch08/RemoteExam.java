package ch08;

public class RemoteExam {
	public static void main(String[] args) {
		RemoteControl rc;
		RemoteControl.changeBattery();

		System.out.println();

		rc = new SmartTV();
		rc.turnOn();
		rc.setVolume(5);
		Searchable scAble = new SmartTV();
		scAble.search("https://www.naver.com/");
		rc.turnOff();

		System.out.println();

		rc = new Television();
		rc.turnOn();
		rc.setVolume(8);
		rc.setMute(true);
		rc.setMute(false);
		rc.turnOff();

		System.out.println();

		rc = new Audio();
		rc.turnOn();
		rc.setVolume(2);
		rc.setMute(true);
		rc.turnOff();
	}
}
