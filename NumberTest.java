package testy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

class NumberTest {

	Number a = new Number(3);
	@Test
	void testNumber() {
		Number a = new Number(3);
		assertNotNull(a);
	}
	@After
	void change() {
		a.num = 0;
	}
	
	@Test
	void test0(){
		assertEquals(0,a);
	}

	@Before
	void test1()
	{
		a.num = 1;
	}
	@Test
	void testSign() {
		assertTrue(a.sign() == 1);
	}
	
	@Test
	void testFalseSign() {
		assertFalse(a.sign()<0);
	}
}
