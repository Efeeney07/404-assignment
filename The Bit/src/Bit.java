
public class Bit implements BitInterface {
	//stores the value of the bit
	private boolean value;

	Bit(boolean v) {
		value = v;
	}

	@Override
	//sets the value of the bit
	//@param value
	public void set(boolean v) {
		value = v;
	}

	@Override
	//sets bit to the opposite value
	public void toggle() {
		if(value==true) {
			value=false;
		}else
			value=true;
	}

	@Override
	//sets bit to true
	public void set() {
		value = true;
	}

	@Override
	//sets bit to false
	public void clear() {
		value = false;
	}

	@Override
	//gets value of bit
	//@return value of bit
	public boolean getValue() {
		return value;
	}

	@Override
	//compares this bit and another bit and returns and value
	//@param bit to compare
	//@return and value
	public Bit bitAnd(Bit b) {
		if(value==b.getValue()) {
			if(value==false) {
				return new Bit(false);
			}
			return new Bit(true);
		}
		else {
			return new Bit(false);
		}
	}

	@Override
	//compares this bit and another bit and returns or value
	//@param bit to compare
	//@return or value
	public Bit bitOr(Bit b) {
		if(value==true) {
			return new Bit(true);
		}else if(b.getValue()==true) {
			return new Bit(true);
		}else {
			return new Bit(false);
		}
	}

	@Override
	//compares this bit and another bit and returns xor value
	//@param bit to compare
	//@return xor value
	public Bit bitXor(Bit b) {
		boolean xorValue=false;
		if(value==true) {
			if(b.getValue()==true) {
				xorValue=false;
			}else {
				xorValue=true;
			}
		}else if(b.getValue()==true) {
			if(value==true) {
				xorValue=false;
			}else {
				xorValue=true;
			}
		}
		return new Bit(xorValue);
	}

	@Override
	//compares this bit and another bit and returns not value
	//@param bit to compare
	//@return not value
	public Bit bitNot() {
		return new Bit(!value);
	}
	
	public String toString() {
		if(value) {
			return "t";
		}else {
			return "f";
		}
	}
}
