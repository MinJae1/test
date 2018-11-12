package ch11;

public class MemberExam {
	public static void main(String[] args) {
		Member obj1 = new Member("blue");
		Member obj2 = new Member("blue");
		Member obj3 = new Member("red");

		if (obj1.equal(obj2)) {
			System.out.println("obj1, obj2 is same");
		} else {
			System.out.println("obj1, obj2 is not same");
		}

		if (obj1.equal(obj3)) {
			System.out.println("obj1, obj3 is same");
		} else {
			System.out.println("obj1, obj3 is not same");
		}

		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		System.out.println(obj3.hashCode());

		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
		System.out.println(obj3.toString());
	}
}
