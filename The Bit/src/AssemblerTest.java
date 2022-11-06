
public class AssemblerTest {

        
    @Test
    void test() {
        Assembler assembler=new Assembler();
        String[] load=new String[16];
        load[0]="1000110101010001";
        System.out.println(Assembler.assemble(load));
        System.out.println("Binary String: "+load);
    }
}
    