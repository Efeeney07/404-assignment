import org.junit.Test;

public class ALU_Test {

    @Test
    void test() throws Exception{

    }
    
    public void test_ALU() throws Exception{
        Bit[] op=new Bit[4];
        op[0].set(true);
        op[1].set();
        op[2].set();
        op[3].set();
        if(ALU.doOP(op, new longword(12),new longword(5)).getSigned()==4) throw new Exception("it doesnt work");
    }
}
