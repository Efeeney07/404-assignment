
public class longword implements LongWordInterface {
	//stores bits of the word
	private Bit[] bits = new Bit[32];
	
	//constructor for bit array
	//@param bit array
	public longword(Bit[] b) {
		bits = b;
	}
	
	public longword(int value) {
		for (int i = 0; i < 32; i++) {
			bits[i] = new Bit(false);
		}
		set(value);
	}


	//empty constructor
	public longword() {
		//sets all bits in the list to false
		for (int i = 0; i < 32; i++) {
			Bit b = new Bit(false);
			bits[i] = b;
		}
	}

	@Override
	//gets bit at index
	//@param index
	public Bit getBit(int i) {
		return bits[i];
	}

	@Override
	//sets bit at an index
	//@param index, value to set
	public void setBit(int i, Bit value) {
		bits[i].set(value.getValue());
	}

	@Override
	//does bitwise AND to all bits in 2 longwords
	//@param longword to compare
	//@return new longword with AND value
	public longword and(longword other) {
		//
		Bit[] andValue = new Bit[32];
		for (int i = 0; i < 32; i++) {
			if ((bits[i].bitAnd(other.getBit(i))).getValue()) {
				andValue[i] = new Bit(true);
			} else {
				andValue[i] = new Bit(false);
			}
		}
		return new longword(andValue);
	}

	@Override
	//does bitwise OR to all bits in 2 longwords
	//@param longword to compare
	//@return new longword with OR value
	public longword or(longword other) {
		//stores value of bitwise or
		Bit[] orValue = new Bit[32];
		//compares each bit in both longwords
		for (int i = 0; i < 32; i++) {
			if ((bits[i].bitOr(other.getBit(i))).getValue()) {
				//if OR is true sets current bit to true
				orValue[i] = new Bit(true);
			} else {
				//if OR is false sets current bit to false
				orValue[i] = new Bit(false);
			}
		}
		return new longword(orValue);
	}

	@Override
	//does bitwise XOR to all bits in 2 longwords
	//@param longword to compare
	//@return new longword with XOR value
	public longword xor(longword other) {
		//stores value of bitwise xor
		Bit[] xorValue = new Bit[32];
		//compares each bit in both longwords
		for (int i = 0; i < 32; i++) {
			if ((bits[i].bitXor(other.getBit(i))).getValue()) {
				//if XOR is true sets current bit to true
				xorValue[i] = new Bit(true);
			} else {
				//if XOR is false sets current bit to false
				xorValue[i] = new Bit(false);
			}
		}
		return new longword(xorValue);
	}

	@Override
	//nots each bit in longword and returns as new longword
	//@return longword of flipped bits
	public longword not() {
		Bit[] b = new Bit[32];
		//nots each bit and stores in new bit array
		for (int i = 0; i < 32; i++) {
			b[i] = bits[i].bitNot();
		}
		return new longword(b);
	}

	@Override
	//right shifts longword by x amount of bits
	//@param amount of bits to shift
	public longword rightShift(int amount) {
		//stores value of new longword
		Bit[] b = new Bit[32];
		//fills in x 0s in the front of the longword
		for (int i = 0; i < amount; i++) {
			b[i] = new Bit(false);
		}
		//fills in the rest of the longword from the original
		for (int i = 0; i < (32 - amount); i++) {
			b[amount+i] = bits[i];
		}

		return new longword(b);
	}

	@Override
	//left shifts longword by x amount of bits
	//@param amount of bits to shift
	public longword leftShift(int amount) {
		//stores value of new longword
		Bit[] b = new Bit[32];
		//fills in the front with bits from the original longword
		for (int i =0;i <(32-amount); i++) {
			b[i] = bits[amount+i];
		}
		//fills the rest of the longword in with 0s
		for (int i = (32-amount); i<32; i++) {
			b[i] = new Bit(false);
		}
		return new longword(b);
	}

	@Override
	//gets an unsigned number from the longword
	//@return unsigned long from longword
	public long getUnsigned() {
		long sum = 0L;
		//multiplies each bit value by its power of 2
		for (int i = 0; i < 32; i++) {
			if (bits[31 - i].getValue()) {
				sum = (long) (sum + (1 * Math.pow(2, i)));
			}
		}
		System.out.println(sum);
		return sum;
	}

	@Override
	//gets signed integer from longword
	//@return signed int from longword
	public int getSigned() {
		//checks if first bit is true
		if(bits[0].getValue()) {
			//if true 2s compliment the longword
			int sum=0;
			Bit[] b=new Bit[32];
			//flips each bit in the longword
			for(int i=0;i<32;i++) {
				b[i].set(bits[i].bitNot().getValue());
				sum=(int) (sum+(1*Math.pow(2, i)));
			}
			System.out.println(sum);
			return sum+1;
		}else {
			//if false multiplies each bit by its power of 2
			int sum = 0;
			for (int i = 0; i < 32; i++) {
				if (bits[31 - i].getValue()) {
					sum = (int) (sum + (1 * Math.pow(2, i)));
				}
			}
			System.out.println(sum);
			return sum;
		}
	}

	@Override
	//copies longword to another longword
	//@param longword to copy to
	public void copy(longword other) {
		for (int i = 0; i < 32; i++) {
			other.setBit(i, bits[i]);
		}
	}

	@Override
	//sets a longword given an int value
	public void set(int value) {
		//converts int to binary and stores in bit array
		for (int i = 0; i < 32; i++) {
			if (value % 2 == 0) {
				bits[31 - i].set(false);
			} else {
				bits[31 - i].set(true);
			}
			value = value / 2;
		}
	}
	
	public String toString(){
		String str="";
		for(int i=0;i<32;i++) {
			str+=bits[i].toString()+", ";
		}
		return str;
	}
}
