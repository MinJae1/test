package ex03;

public class ContainerExam {
	public static void main(String[] args) {
		Container<String, String> cont1 = new Container<String, String>();
		cont1.set("name1", "job");
		String name1 = cont1.getKey();
		String job = cont1.getValue();

		Container<String, Integer> cont2 = new Container<String, Integer>();
		cont2.set("name2", 35);
		String name2 = cont2.getKey();
		int age = cont2.getValue();

	}
}
