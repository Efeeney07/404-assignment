import org.junit.jupiter.api.Test;

class bit_test {

	@Test
	void runTest() throws Exception {
		testVarSet();
		testSet();
		testClear();
		testToggle();
		testAnd();
		testOr();
		testXor();
		testNot();
	}
	
	public void testVarSet() throws Exception {
		System.out.println("TESTING VAR SET:");
		Bit t=new Bit(true);
		Bit f=new Bit(false);
		t.set(false);
		f.set(true);
		if(t.getValue()!=false) throw new Exception("1 failed");
		else System.out.println("1 passed");
		if(f.getValue()!=true)throw new Exception("0 failed");
		else System.out.println("0 passed");
	}
	
	
	public void testSet() throws Exception {
		System.out.println("TESTING SET:");
		Bit t=new Bit(true);
		Bit f=new Bit(false);
		t.set();
		f.set();
		if(t.getValue()!=true) throw new Exception("1 failed");
		else System.out.println("1 passed");
		if(f.getValue()!=true)throw new Exception("0 failed");
		else System.out.println("0 passed");
	}
	
	public void testClear() throws Exception {
		System.out.println("TESTING CLEAR:");
		Bit t=new Bit(true);
		Bit f=new Bit(false);
		t.clear();
		f.clear();
		if(t.getValue()!=false) throw new Exception("1 failed");
		else System.out.println("1 passed");
		if(f.getValue()!=false)throw new Exception("0 failed");
		else System.out.println("0 passed");
	}
	

	public void testToggle() throws Exception{
		Bit t=new Bit(true);
		Bit f=new Bit(false);
		t.toggle();
		f.toggle();
		System.out.println("TESTING TOGGLE:");
		if(t.getValue()!=false) throw new Exception("1 failed");
		else 
			System.out.println("1 passed");
		if(f.getValue()!=true)throw new Exception("0 failed");
		else
			System.out.println("0 passed");
	}
	
	public void testAnd() throws Exception {
		System.out.println("TESTING AND:");
		if (new Bit(false).bitAnd(new Bit(false)).getValue() !=false) throw new Exception("0 AND 0 failed");
		else System.out.println("0 and 0 passed");
		if (new Bit(false).bitAnd(new Bit(true)).getValue() !=false) throw new Exception("0 AND 1 failed");
		else System.out.println("0 and 1 passed");
		if (new Bit(true).bitAnd(new Bit(false)).getValue() !=false) throw new Exception("1 AND 0 failed");
		else System.out.println("1 and 0 passed");
		if (new Bit(true).bitAnd(new Bit(true)).getValue() !=true) throw new Exception("1 AND 1 failed");
		else System.out.println("1 and 1 passed");
	}
	
	public void testOr() throws Exception {
		System.out.println("TESTING OR:");
		if (new Bit(false).bitOr(new Bit(false)).getValue() !=false) throw new Exception("0 AND 0 failed");
		else System.out.println("0 and 0 passed");
		if (new Bit(false).bitOr(new Bit(true)).getValue() !=true) throw new Exception("0 AND 1 failed");
		else System.out.println("0 and 1 passed");
		if (new Bit(true).bitOr(new Bit(false)).getValue() !=true) throw new Exception("1 AND 0 failed");
		else System.out.println("1 and 0 passed");
		if (new Bit(true).bitOr(new Bit(true)).getValue() !=true) throw new Exception("1 AND 1 failed");
		else System.out.println("1 and 1 passed");
	}
	
	public void testXor() throws Exception {
		System.out.println("TESTING XOR:");
		if (new Bit(false).bitXor(new Bit(false)).getValue() !=false) throw new Exception("0 AND 0 failed");
		else System.out.println("0 and 0 passed");
		if (new Bit(false).bitXor(new Bit(true)).getValue() !=true) throw new Exception("0 AND 1 failed");
		else System.out.println("0 and 1 passed");
		if (new Bit(true).bitXor(new Bit(false)).getValue() !=true) throw new Exception("1 AND 0 failed");
		else System.out.println("1 and 0 passed");
		if (new Bit(true).bitXor(new Bit(true)).getValue() !=false) throw new Exception("1 AND 1 failed");
		else System.out.println("1 and 1 passed");
	}
	
	public void testNot() throws Exception{
		System.out.println("TESTING NOT:");
		if(new Bit(true).bitNot().getValue()!=false) throw new Exception("1 failed");
		else System.out.println("1 passed");
		if(new Bit(false).bitNot().getValue()!=true) throw new Exception("0 failed");
		else System.out.println("0 passed");
	}
}
