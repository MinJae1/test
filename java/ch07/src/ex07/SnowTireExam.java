package ex07;

public class SnowTireExam {
	public static void main(String[] args) {
		SnowTire snowT = new SnowTire();
		Tire T = snowT;

		snowT.run();
		T.run();
	}
}
