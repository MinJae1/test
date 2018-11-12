package ex04;

public class UtilExam {
	public static void main(String[] args) {
		Pair<String, Integer> pair = new Pair<String, Integer>("user1", 35);
		Integer age = Util.getValue(pair, "user1");
		System.out.println(age);
		
		ChildPair<String, Integer> childPair = new ChildPair<String, Integer>("user2", 35);
		Integer childAge = Util.getValue(childPair, "user3");
		System.out.println(childAge);
		
		/*OtherPair<String, Integer> otherPair = new OtherPair<String, Integer>("user2", 35);
		Integer otherAge = Util.getValue(otherPair, "user3");
		System.out.println(otherAge);*/
	}
}
