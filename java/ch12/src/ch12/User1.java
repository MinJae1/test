package ch12;

public class User1 extends Thread {
	private Calculator calc;

	public void setCalculator(Calculator calc) {
		// TODO Auto-generated method stub
		this.setName("User1");
		this.calc = calc;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		calc.setMemory(100);
	}
}
