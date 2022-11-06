import org.junit.jupiter;

class cpu_test {

    @Test
    void test() throws Exception{
        run_test();
    }



    void run_test(){
        Computer CPU=new Computer();
        String[] str=new String[32];

        //and
        str[0]="10000101001101111011010100110111";
        CPU.preload(str);
        //leftshift
        str[0]="11000101001101111011010100110111";
        CPU.preload(str);
        //or
        str[0]="10010101001101111011010100110111";
        CPU.preload(str);
        //rightshift
        str[0]="11010101001101111011010100110111";
        CPU.preload(str);
        //add
        str[0]="11100101001101111011010100110111";
        CPU.preload(str);
        //xor
        str[0]="10100101001101111011010100110111";
        CPU.preload(str);
        //not
        str[0]="10110101001101111011010100110111";
        CPU.preload(str);
        //multiply
        str[0]="01110101001101111011010100110111";
        CPU.preload(str);
        //interupt
        str[0]="0010000000000000000100000000000001";
        CPU.preload(str);
        //halt
        str[0]="00000000000000000000000000000000";
        CPU.preload(str);
        CPU.run();
        
    }
}
