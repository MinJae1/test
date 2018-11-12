package ch12;

public class ThreadNameEx {
	public static void main(String[] args) {
		Thread mainTh = Thread.currentThread();
		System.out.println("Main Thread : " + mainTh);

		Thread threadA = new ThreadA();
		System.out.println("Thread Name : " + threadA.getName());
		threadA.start();

		Thread threadB = new ThreadB();
		System.out.println("Thread Name : " + threadB.getName());
		threadB.start();
	}
}
