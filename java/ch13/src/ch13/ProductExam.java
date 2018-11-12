package ch13;

public class ProductExam {
	public static void main(String[] args) {
		Product<Tv, String> pro1 = new Product<Tv, String>();
		pro1.setKind(new Tv());
		pro1.setModel("Smart TV");
		Tv tv = pro1.getKind();
		String tvmodel = pro1.getModel();
		System.out.println("TV Model : " + tvmodel);

		Product<Car, String> pro2 = new Product<Car, String>();
		pro2.setKind(new Car());
		pro2.setModel("Diesel");
		Car car = pro2.getKind();
		String carmodel = pro2.getModel();
		System.out.println("Car Model : " + carmodel);
	}
}
