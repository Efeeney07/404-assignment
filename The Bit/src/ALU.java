

public class ALU {

    public static longword doOP(Bit[] op, longword a, longword b){
        //true 1000
        if(op[0].getValue()){
            //true 1100
            if(op[1].getValue()){
                //true 1110
                if(op[2].getValue()){
                    //true 1111 subtract
                    if(op[3].getValue()){
                       return rippleAdder.subtract(b, a);
                    //false 1110 add
                    }else{
                        return rippleAdder.add(a,b);
                    }
                //false 1100
                }else{
                    //true 1101 rightshift
                    if(op[3].getValue()){
                        return a.rightShift(b.getSigned());
                    //false 1100 leftshift
                    }else{
                        return a.leftShift(b.getSigned());
                    }
                }
            //false 1000
            }else{
                //true 1010
                if(op[2].getValue()){
                    //true 1011 not
                    if(op[3].getValue()){
                        return a.not();
                    //false 1010 xor
                    }else{
                        return a.xor(b);
                    }
                //false 1000
                }else{
                    //true 1001 or
                    if(op[3].getValue()){
                        return a.or(b);
                    //false 1000 and
                    }else{
                        return a.and(b);
                    }
                }
            }
        //false 0000
        }else{
            //true 0111 multiply
            if(op[1].getValue()){
                return multiplier.multiply(a, b); 
            
            //false 0000 halt
            }else{
                return new longword(0);
            }
                       
        }

    }
}