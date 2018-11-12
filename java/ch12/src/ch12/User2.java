package ch12;

public class User2 extends Thread {
	private Calculator calc;

	public void setCalculator(Calculator calc) {
		// TODO Auto-generated method stub
		this.setName("User2");
		this.calc = calc;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		calc.setMemory(50);
	}
}
