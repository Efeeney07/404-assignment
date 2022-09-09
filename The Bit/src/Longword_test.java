import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Longword_test {

	@Test
	void test() throws Exception {
		test_getBit();
		test_setBit();
		test_and();
		test_or();
		test_xor();
		test_not();
		test_right();
		test_left();
		test_copy();
		test_toString();
	}
	
	public void test_getBit() throws Exception {
		longword l=new longword();
		l.set(10);
		if(l.getBit(31).getValue()!=false) throw new Exception("Bit 31 is not false");
		if(l.getBit(30).getValue()!=true) throw new Exception("Bit 30 is not true");
		if(l.getBit(29).getValue()!=false) throw new Exception("Bit 29 is not false");
		if(l.getBit(28).getValue()!=true) throw new Exception("Bit 28 is not true");
	}
	
	public void test_setBit() throws Exception {
		longword l=new longword();
		l.set(10);
		l.setBit(31,new Bit(true));
		l.setBit(30,new Bit(false));
		l.setBit(29,new Bit(true));
		l.setBit(28,new Bit(false));
		
		if(l.getBit(31).getValue()!=true) throw new Exception("Bit 31 is not true");
		if(l.getBit(30).getValue()!=false) throw new Exception("Bit 30 is not false");
		if(l.getBit(29).getValue()!=true) throw new Exception("Bit 29 is not true");
		if(l.getBit(28).getValue()!=false) throw new Exception("Bit 28 is not false");
	}
	
	public void test_and() throws Exception {
		longword l1=new longword();
		longword l2=new longword();
		l1.set(12);
		l2.set(10);
		if(l1.and(l2).getSigned()!=8) throw new Exception("12 AND 10 does not equal 8");
			System.out.println("12 AND 10 equals 8");
		l1.set(43);
		l2.set(8);
		if(l1.and(l2).getSigned()!=8) throw new Exception("43 AND 8 does not equal 8");
			
	}
	
	public void test_or() throws Exception{
		longword l1=new longword();
		longword l2=new longword();
		l1.set(12);
		l2.set(10);
		if(l1.or(l2).getSigned()!=14) throw new Exception("12 OR 10 does not equal 14");	
			System.out.println("12 OR 10 equals 14");
		l1.set(43);
		l2.set(8);
		if(l1.or(l2).getSigned()!=43) throw new Exception("43 AND 8 does not equal 8");
	}
	
	public void test_xor() throws Exception{
		longword l1=new longword();
		longword l2=new longword();
		l1.set(12);
		l2.set(10);
		if(l1.xor(l2).getSigned()!=6) throw new Exception("12 XOR 10 does not equal 6");
			System.out.println("12 XOR 10 equals 6");
		l1.set(43);
		l2.set(8);
		if(l1.xor(l2).getSigned()!=35) throw new Exception("43 AND 8 does not equal 8");
	}
	
	public void test_not() throws Exception{
		longword l1=new longword();
		long w=4294967279L;
		l1.set(16);
		if(l1.not().getUnsigned()!=w) throw new Exception("not 16 is not equal to 4294967279");
			System.out.println("not 16 is equal to 4294967279");
		l1.set(34);
		w=4294967261L;
		if(l1.not().getUnsigned()!=w) throw new Exception("not 34 is not equal to 4294967261");
			
	}
	
	public void test_right() throws Exception{
		longword l1=new longword();
		l1.set(2147483647);
		if(l1.rightShift(4).getUnsigned()!=134217727L) throw new Exception("it doesnt work");
			System.out.println("it works");
		l1.set(42);
		if(l1.rightShift(6).getUnsigned()!=0L) throw new Exception("it doesnt work");
	}
	
	public void test_left() throws Exception{
		longword l1=new longword();
		l1.set(300);
		if(l1.leftShift(4).getUnsigned()!=4800L) throw new Exception("it doesnt work");
			System.out.println("it works");
		l1.set(42);
		if(l1.leftShift(2).getUnsigned()!=168L) throw new Exception("it doesnt work");
	}
	
	public void test_copy() throws Exception{
		longword l1=new longword();
		longword l2=new longword();
		l1.set(10);
		l1.copy(l2);
		if(l2.getUnsigned()!=10L) throw new Exception("copy doesnt work");
		l1.set(425);
		l1.copy(l2);
		if(l2.getUnsigned()!=425L) throw new Exception("copy doesnt work");
	}
	
	public void test_toString() {
		longword l=new longword();
		l.set(10);
		System.out.println(l);
	}

}
