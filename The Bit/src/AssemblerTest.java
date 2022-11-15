import org.junit.jupiter.api.Test;

public class AssemblerTest {

        
    @Test
    void test() throws Exception {
        String[] load=new String[16];
        load[0]="1000110101010001";
        System.out.println(Assembler.assemble(load)[0]);
        System.out.println("Binary String: "+load);
        load[0]="1001110101010001";
        System.out.println(Assembler.assemble(load)[0]);
        System.out.println("Binary String: "+load);
        load[0]="1010110101010001";
        System.out.println(Assembler.assemble(load)[0]);
        System.out.println("Binary String: "+load);
        load[0]="1011110101010001";
        System.out.println(Assembler.assemble(load)[0]);
        System.out.println("Binary String: "+load);
        load[0]="1100110101010001";
        System.out.println(Assembler.assemble(load)[0]);
        System.out.println("Binary String: "+load);
        load[0]="1101110101010001";
        System.out.println(Assembler.assemble(load)[0]);
        System.out.println("Binary String: "+load);
        load[0]="1110110101010001";
        System.out.println(Assembler.assemble(load)[0]);
        System.out.println("Binary String: "+load);
        load[0]="1111110101010001";
        System.out.println(Assembler.assemble(load)[0]);
        System.out.println("Binary String: "+load);
        load[0]="0111110101010001";
        System.out.println(Assembler.assemble(load)[0]);
        System.out.println("Binary String: "+load);
        load[0]="0000110101010001";
        System.out.println(Assembler.assemble(load)[0]);
        System.out.println("Binary String: "+load);
        load[0]="0001110101010001";
        System.out.println(Assembler.assemble(load)[0]);
        System.out.println("Binary String: "+load);
        load[0]="0010110101010001";
        System.out.println(Assembler.assemble(load)[0]);
        System.out.println("Binary String: "+load);

    }
}
    