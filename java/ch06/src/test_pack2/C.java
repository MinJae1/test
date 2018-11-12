package test_pack2;

import test_pack1.A;

public class C {
	public C() {
		// TODO Auto-generated constructor stub
		A a = new A();
		a.field1 = 1;
//		a.field2 = 1;//컴파일 에러
//	a.field3 = 1;//컴파일 에러

		a.method1();
//		a.method2();//컴파일 에러
//	a.method3();//컴파일 에러

	}
}
