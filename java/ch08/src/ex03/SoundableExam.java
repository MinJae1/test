package ex03;

public class SoundableExam {
	private static void printSound(Soundable soundable) {
		// TODO Auto-generated method stub
		System.out.println(soundable.Sound());
	}

	public static void main(String[] args) {
		printSound(new Cat());
		printSound(new Dog());
	}
}
