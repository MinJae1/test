package cal;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class CalculatorTest {
	Calculator cal = new Calculator();

	@Before
	private void beforeTest() {
		// TODO Auto-generated method stub
		Calculator cal2 = new Calculator();
		System.out.println("beforeTest");
	}
	
	@Test
	void addtest() {
		assertEquals(5, cal.add(2, 3));
		System.out.println("addtest");
	}

	@Test
	void subtest() {
		System.out.println("subtest");
		assertEquals(1, cal.sub(2, 1));
	}

	@Test
	void multest() {
		System.out.println("multest");
		assertEquals(24, cal.mul(4, 6));
	}
	
	@After
	private void afterTest() {
		// TODO Auto-generated method stub
		System.out.println("afterTest");
	}

}
