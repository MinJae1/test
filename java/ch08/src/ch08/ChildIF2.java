package ch08;

public interface ChildIF2 extends ParentTF {
	@Override
	public default void method2() {
		// TODO Auto-generated method stub
		System.out.println();
	}

	public void method3();
}
