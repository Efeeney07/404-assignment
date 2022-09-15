
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class testAdder {

	@Test
	void test() throws Exception {
		testAdder();
		testSub();
	}
	
	public void testAdder() throws Exception {
		
		if(rippleAdder.add(new longword(14), new longword(325)).getSigned()!=339)throw new Exception("addiition not equal");
		if(rippleAdder.add(new longword(325), new longword(325)).getSigned()!=650)throw new Exception("addiition not equal");
		if(rippleAdder.add(new longword(81), new longword(19)).getSigned()!=100)throw new Exception("addiition not equal");
		if(rippleAdder.add(new longword(3232), new longword(4)).getSigned()!=3236)throw new Exception("addiition not equal");
	}

	public void testSub() throws Exception {
		if(rippleAdder.subtract(new longword(325), new longword(14)).getSigned()!=311) throw new Exception("subtraction not equal");
		if(rippleAdder.subtract(new longword(14), new longword(325)).getUnsigned()!=4294966985L) throw new Exception("subtraction not equal");
		if(rippleAdder.subtract(new longword(40000), new longword(4325)).getSigned()!=35675) throw new Exception("subtraction not equal");
		if(rippleAdder.subtract(new longword(8), new longword(5)).getSigned()!=3) throw new Exception("subtraction not equal");
	}
}
