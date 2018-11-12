package ch07;

public class DnbCellPhone extends Cellphone {
	int channel;

	public DnbCellPhone(String model, String color, int channel) {
		// TODO Auto-generated constructor stub
		this.model = model;
		this.color = color;
		this.channel = channel;
	}

	 void turnon() {
		// TODO Auto-generated method stub
		System.out.println("channel - " + channel + " play");
	}

	 void change(int channel) {
		// TODO Auto-generated method stub
		System.out.println("channel - " + channel + " change");
	}

	 void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("Turn off DMB");
	}

}
