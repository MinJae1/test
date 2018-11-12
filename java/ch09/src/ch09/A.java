package ch09;

class A {
	A() {
		// TODO Auto-generated constructor stub
		System.out.println("object A create");
	}

	class B {
		B() {
			// TODO Auto-generated constructor stub
			System.out.println("object B create");
		}

		int field1;

//		static int field2;
		void method() {
			// TODO Auto-generated method stub

		}
		/*
		 * static void method2() { // TODO Auto-generated method stub
		 * 
		 * }
		 */
	}

	static class C {
		public C() {
			// TODO Auto-generated constructor stub
			System.out.println("object C create");
		}

		int field1;
		static int field2;

		void method() {
			// TODO Auto-generated method stub

		}

		static void method2() {
			// TODO Auto-generated method stub

		}
	}

	void method() {
		// TODO Auto-generated method stub
		class D {
			D() {
				// TODO Auto-generated constructor stub
				System.out.println("object D create");
			}

			int field1;

//			static int field2;
			void method() {
				// TODO Auto-generated method stub

			}
			/*
			 * static void method2() { // TODO Auto-generated method stub
			 * 
			 * }
			 */
		}
		D d = new D();
		d.field1 = 3;
		d.method();
	}
}
