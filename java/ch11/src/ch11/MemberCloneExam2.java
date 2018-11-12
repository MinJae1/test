package ch11;

public class MemberCloneExam2 {
	public static void main(String[] args) {
		Member_clon2 ori = new Member_clon2("NAME", 25, new int[] { 90, 90 }, new Car("Benz"));

		Member_clon2 cloned = ori.getMember_clon2();
		cloned.score[0] = 100;
		cloned.car.model = "Porsche";

		System.out.println("[복제 객체의 필드값]");
		System.out.println(cloned.toString());

//		System.out.println("name : " + cloned.name);
//		System.out.println("age : " + cloned.age);
//		System.out.print("score : {");
//		for (int i = 0; i < cloned.score.length; i++) {
//			System.out.print(cloned.score[i]);
//			System.out.print((i == (cloned.score.length - 1)) ? "" : ",");
//		}
//		System.out.println("}");
//		System.out.println("Car : " + cloned.car.model);

		System.out.println();

		System.out.println("[원본 객체의 필드값]");
		System.out.println(ori.toString());

//		System.out.println("name : " + ori.name);
//		System.out.println("age : " + ori.age);
//		System.out.print("score : {");
//		for (int i = 0; i < ori.score.length; i++) {
//			System.out.print(ori.score[i]);
//			System.out.print((i == (ori.score.length - 1)) ? "" : ",");
//		}
//		System.out.println("}");
//		System.out.println("Car : " + ori.car.model);

	}
}
