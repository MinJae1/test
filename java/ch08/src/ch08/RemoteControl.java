package ch08;

public interface RemoteControl {
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;

	void turnOn();

	void turnOff();

	void setVolume(int volume);

	default void setMute(boolean mute) {
		if (mute) {
			System.out.println("mute on");
		} else {
			System.out.println("mute off");
		}
	}

	static void changeBattery() {
		System.out.println("Battery Change");
	}
}
