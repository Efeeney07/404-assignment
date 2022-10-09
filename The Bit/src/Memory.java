
public class Memory{
    public Bit[] mem=new Bit[8192];

    public Bit getBit(int i){
        return new Bit(mem[i].getValue());
    }

    public Memory(){
        for(int i=0;i<8192;i++){
            mem[i]=new Bit(false);
        }
    }

    public longword read(longword address){
        longword temp=new longword();
        int length=address.getSigned()+32;
        for(int i=address.getSigned();i<length;i++){
            temp.setBit(i,new Bit(mem[i].getValue()) );
        }
        return temp;
    }

    public void write(longword address,longword value){
        for(int i=0;i<32;i++){
            mem[i+address.getSigned()]=value.getBit(i);
        }
    }

}