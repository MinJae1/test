package ex02;

public class ContainerExam {
	public static void main(String[] args) {
		Container<String> cont1 = new Container<String>();
		cont1.set("name");
		String str = cont1.get();

		Container<Integer> cont2 = new Container<Integer>();
		cont2.set(6);
		int val = cont2.get();
	}
}
