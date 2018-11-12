package exercise;

public class ShopServiceExam {
	public static void main(String[] args) {
		ShopService obj1 = ShopService.getInstance();
		ShopService obj2 = ShopService.getInstance();

		if (obj1 == obj2) {
			System.out.println("°°Àº °´Ã¼");
		} else {
			System.out.println("´Ù¸¥ °´Ã¼");
		}
	}
}
