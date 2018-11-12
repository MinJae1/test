package ch08;

public class SmartTV implements RemoteControl, Searchable {

	@Override
	public void search(String url) {
		// TODO Auto-generated method stub
		System.out.println("Search " + url);
	}

	private int volume;

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("turn on SmartTV");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("Turn Off SmartTV");
	}

	@Override
	public void setVolume(int volume) {
		// TODO Auto-generated method stub
		if (volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if (volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("SmartTV Volume : " + volume);
	}

}
