package test_pack1;

public class B {
	public B() {
		// TODO Auto-generated constructor stub
		A a = new A();
		a.field1 = 1;
		a.field2 = 1;
//	a.field3 = 1; 컴파일에러

		a.method1();
		a.method2();
//	a.method3();//컴파일 에러

	}
}
