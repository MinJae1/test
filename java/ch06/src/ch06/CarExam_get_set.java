package ch06;

public class CarExam_get_set {
public static void main(String[] args) {
	Car_get_set carGS = new Car_get_set();
	
	carGS.setSpeed(-50);
	
	System.out.println("rate : "+carGS.getSpeed());
	
	carGS.setSpeed(60);
	
	if (!carGS.isStop()) {
		carGS.setStop(true);
	}
	
	System.out.println("rate : "+carGS.getSpeed());
}
}
