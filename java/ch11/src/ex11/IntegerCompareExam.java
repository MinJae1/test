package ex11;

public class IntegerCompareExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer obj1 = 100;
		Integer obj2 = 100;
		Integer obj3 = 300;
		Integer obj4 = 300;

		System.out.println(obj1 == obj2);
		System.out.println(obj3 == obj4); // 언박싱 하여 내부값을 비교해야함
//		-> obj3.intValue() == obj4.intValue() 해야 true
	}

}
