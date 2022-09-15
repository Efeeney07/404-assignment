

public class multiplier {

	public static longword multiply(longword l,longword w) {
		longword result=new longword();
		for(int i=31;i>=0;i--) {
			longword temp=new longword();
			for(int j=31;j>=0;j--) {
				if(l.getBit(j).bitAnd(w.getBit(i)).getValue()) {
					temp.setBit(j,new Bit(true));
				}else {
					temp.setBit(j,new Bit(false));
				}
			}
			temp.rightShift(31-i);
			rippleAdder.add(result, temp);
		}
		return result;
	}
	
	
}
