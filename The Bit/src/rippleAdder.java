

public class rippleAdder {

	//adds two long words together
	//@param longword 1, longword 2
	//@return resulting longword
	public static longword add(longword l, longword w) {
		//creates new longword to store result
		longword result = new longword();
		//creates carry bit
		Bit carry=new Bit(false);
		for (int i = 31; i >=0; i--) {
			//sets the current bit of the result to the ( l xor w ) xor carry
			result.setBit(i,(l.getBit(i).bitXor(w.getBit(i))).bitXor(carry));
			//sets carry to (l and w) or (carry and ( l or w)
			carry=(l.getBit(i).bitAnd(w.getBit(i)).bitOr(carry.bitAnd(l.getBit(i).bitOr(w.getBit(i)))));
		}
		return result;
	}

	//subtracts two long words
	//@param longword 1, longword 2
	//@return resulting longword
	public static longword subtract(longword l, longword w) {
		//adds l and the 2s compliment of w
		longword result=add(l,add(w.not(),new longword(1)));
		return result;
	}
	
}
