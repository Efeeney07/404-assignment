
public class Memory{
    public Bit[] mem=new Bit[8192];

    public Memory(){
        for(int i=0;i<8192;i++){
            mem[i]=new Bit(false);
        }
    }

    public Bit getBit(int i){
        return new Bit(mem[i].getValue());
    }

    public longword read(longword address){
        longword temp=new longword();
        int length=(address.getSigned()*2)+16;
        for(int i=address.getSigned();i<length;i++){
            temp.setBit(i,new Bit(mem[i].getValue()) );
        }
        return temp;
    }

    public void write(longword address,longword value){
        for(int i=0;i<8;i++){
            mem[i+address.getSigned()]=value.getBit(i);
        }
    }

    public void print(){
        for(int i=0; i<8192;i++){
            if(mem[i].getValue()){
                System.out.print("| 1 |");
            }else{
                System.out.print("| 0 |");
            }
            if(i%8==0){
                System.out.println();
            }
        }
    }

}