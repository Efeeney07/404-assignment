import org.junit.jupiter.api.Test;

class Mem_Test {

    @Test
    void test() throws Exception{
        Memory mem= new Memory();
        longword l=new longword(15);
        mem.write(new longword(0), l);
        longword readTest=mem.read(new longword(0));
        if(readTest==new longword(15)) throw new Exception("doesnt work");
        System.out.println("it worked");

        for(int i=0; i<8192;i++){
            Bit temp=mem.getBit(i);
            if(temp.getValue()){
                System.out.print("| 1 |");
            }else{
                System.out.print("| 0 |");
            }
            if(i%8!=0){
                System.out.println();
            }
        }

    }


}