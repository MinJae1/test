package ch08;

public class Audio implements RemoteControl {

	private int volume;
	private boolean mute;

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("turn on Audio");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("Turn Off Audio");
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
		System.out.println("Audio Volume : " + volume);
	}

	@Override
	public void setMute(boolean mute) {
		// TODO Auto-generated method stub
		this.mute = mute;

		if (mute) {
			System.out.println("Audio Mute On");
		} else {
			System.out.println("Audio Mute Off");
		}
	}

}
