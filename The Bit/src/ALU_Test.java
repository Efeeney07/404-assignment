import org.junit.jupiter.api.Test;

class ALU_Test {

	@Test
	void test() throws Exception {
		Bit[] op=new Bit[4];
        op[0]=new Bit(true);
        op[1]=new Bit(false);
        op[2]=new Bit(false);
        op[3]=new Bit(false);
        longword a=new longword(15);
        longword b=new longword(4);
        if(ALU.doOP(op,a,b).getSigned()!=4) throw new Exception("yo");
        op[3].set(true);
        if(ALU.doOP(op,a,b).getSigned()!=15) throw new Exception("doesnt work");
        op[2]=new Bit(true);
        if(ALU.doOP(op,a,b).getUnsigned()!=4294967280L) throw new Exception("no worky");   
        op[3]=new Bit(false);
        if(ALU.doOP(op,a,b).getSigned()!=11) throw new Exception("it stinks");
	}

}

