package ch11;

public class Counter {
	private int no;

	public Counter(int no) {
		// TODO Auto-generated constructor stub
		this.no = no;
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("No." + no + "\'s finalize()");
	}
}
