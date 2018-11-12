package ch07;

public class DmbCellphoneEx {
	public static void main(String[] args) {
		DnbCellPhone dmbphone = new DnbCellPhone("apple", "black", 10);

		System.out.println("model : " + dmbphone.model);
		System.out.println("color : " + dmbphone.color);

		System.out.println("channel : " + dmbphone.channel);

		dmbphone.powerOn();
		dmbphone.bell();
		dmbphone.Send("hi");
		dmbphone.Receive("hi");
		dmbphone.Send("bye");
		dmbphone.Hangup();

		dmbphone.turnon();
		dmbphone.change(12);
		dmbphone.turnOff();
	}
}
