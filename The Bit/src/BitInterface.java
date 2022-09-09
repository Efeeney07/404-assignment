
public interface BitInterface {

	void set(boolean v);
	void toggle();
	void set();
	void clear();
	boolean getValue();
	Bit bitAnd(Bit b);
	Bit bitOr(Bit b);
	Bit bitXor(Bit b);
	Bit bitNot();
}
