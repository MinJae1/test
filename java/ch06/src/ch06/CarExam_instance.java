package ch06;

public class CarExam_instance {
public static void main(String[] args) {
	Car_instance myCarI = new Car_instance("Porsche");
	Car_instance yourCarI = new Car_instance("Benz");
	
	myCarI.run();
	yourCarI.run();
}
}
