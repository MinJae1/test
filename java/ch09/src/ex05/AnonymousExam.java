package ex05;

public class AnonymousExam {
	public static void main(String[] args) {
		Anonymous anony = new Anonymous();
		anony.field.run();
		anony.method();
		anony.method2(new Vehicle() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("truck");
			}
		});
	}
}
