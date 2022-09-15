import java.util.Arrays;

public class ALU {

    public static longword doOP(Bit[] op, longword a, longword b){
        switch(Arrays.toString(op)){
            case "[true, false, false, false]":
                return a.and(b);
            case "[true, false, false, true]":
                return a.or(b);
            case "[true, false, true, false]":
                return a.xor(b);
            case "[true, false, true, true]":
                return a.not();
            case "[true, true, false, false]":
                return a.leftShift(b.getSigned());
            case "[true, true, false, true]":
                return a.rightShift(b.getSigned());
            case "[true, true, true, false]":
                return rippleAdder.add(a, b);
            case "[true, true, true, true]":
                return rippleAdder.subtract(a,b);
            case "[false, true, true, true]":
                return multiplier.multiply(a, b);
        }
        return b;
    }


}