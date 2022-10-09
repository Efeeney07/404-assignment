

public class ALU {

    public static longword doOP(Bit[] op, longword a, longword b){
        //true
        if(op[0].getValue()){
            //true
            if(op[1].getValue()){
                //true
                if(op[2].getValue()){
                    //true
                    if(op[3].getValue()){
                       return rippleAdder.add(a, b);
                    //false
                    }else{
                        return rippleAdder.add(a,b);
                    }
                //false
                }else{
                    //true
                    if(op[3].getValue()){
                        return a.rightShift(b.getSigned());
                    //false
                    }else{
                        return a.leftShift(b.getSigned());
                    }
                }
            //false
            }else{
                //true
                if(op[2].getValue()){
                    //true
                    if(op[3].getValue()){
                        return a.not();
                    //false
                    }else{
                        return a.xor(b);
                    }
                //false
                }else{
                    //true
                    if(op[3].getValue()){
                        return a.or(b);
                    //false
                    }else{
                        return a.and(b);
                    }
                }
            }
        }else{
            return multiplier.multiply(a, b);        
        }

    }
}