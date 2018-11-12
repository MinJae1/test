package ch11;

public class MemberCloneExam {
	public static void main(String[] args) {
		Member_clon ori = new Member_clon("ID", "NAME", "12345", 25, true);

		Member_clon cloned = ori.getMember_clon();
		cloned.password = "67890";

		System.out.println("[복제 객체의 필드값]");
		System.out.println("id : " + cloned.id);
		System.out.println("name : " + cloned.name);
		System.out.println("password : " + cloned.password);
		System.out.println("age : " + cloned.age);
		System.out.println("adult : " + cloned.adult);

		System.out.println();

		System.out.println("[원본 객체의 필드값]");
		System.out.println("id : " + ori.id);
		System.out.println("name : " + ori.name);
		System.out.println("password : " + ori.password);
		System.out.println("age : " + ori.age);
		System.out.println("adult : " + ori.adult);
	}
}
