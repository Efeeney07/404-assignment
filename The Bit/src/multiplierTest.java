

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class multiplierTest {

	@Test
	void test() throws Exception {
		test_multiply();
	}
	
	public void test_multiply() throws Exception {
		longword l=new longword(4);
		longword w=new longword(7);
		if(multiplier.multiply(l, w).getSigned()==28) throw new Exception();
	}

}
