package ch06;

public class Car_return {
	int gas;

	void setGas(int gas) {
		this.gas = gas;
	}

	boolean isLeft() {
		if (gas == 0) {
			System.out.println("gas����");
			return false;
		}
		System.out.println("gas ����");
		return true;
	}

	void run() {
		while (true) {
			if (gas > 0) {
				System.out.println("run (left gas : " + gas + ")");
				gas -= 1;
			} else {
				System.out.println("stop (left gas : " + gas + ")");
				return;
			}

		}
	}
}
