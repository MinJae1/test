package ch07;

public class SuperAirplane extends Airplane {
	public static final int NORMAL = 1;
	public static final int SUPERSONIC = 2;

	public int flyMode = NORMAL;

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		if (flyMode == SUPERSONIC) {
			System.out.println("supersonic fly");
		} else {
			super.fly();
		}
	}

}
