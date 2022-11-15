

public class Computer{
    private Memory mem=new Memory();
    private longword PC=new longword(0);
    private longword[] registers=new longword[16];
    private longword currentInstruction=new longword();
    private longword Operator1=new longword();
    private longword Operator2=new longword();
    private longword ResultRegister=new longword();
    private longword result=new longword();
    private Bit[] opcode=new Bit[4];
    private Bit[] branch=new Bit[2];

    public void run(){
        boolean loop=true;
        do{
            fetch();
            decode();
            loop=execute();
            store();
        }while(loop);
    }

    public void fetch(){
        //reads the program counter to the instruction
        currentInstruction=mem.read(PC);
        //increments PC by 2
        rippleAdder.add(PC, new longword(2));
    }

    //fragments the instruction into the opcode, first register index, second register index, and the index to insert the result of the operation 
    public void decode(){
        //takes the first 4 bits as the op code
        for(int i=0;i<4;i++){
            opcode[i]=currentInstruction.getBit(i);
        }
        //checks if the opcode is 0001, the move operation
        if(opcode[0]==new Bit(false)&&opcode[0]==new Bit(false)&&opcode[0]==new Bit(false)&&opcode[0]==new Bit(true)){
            longword moveDest=new longword();
            longword newValue=new longword();
            //sets the move destination to the second byte cluster in the instruction
            for(int i=4;i<8;i++){
                moveDest.setBit(i+8,currentInstruction.getBit(i));
            }
            //sets the move value to the third and fourth in the instruction
            for(int i=8;i<16;i++){
                newValue.setBit(i, currentInstruction.getBit(i));
            }
            //sets the new value to the register address of the move destination
            registers[moveDest.getSigned()]=newValue;
        }else{
            //masks the instruction
            op_mask(currentInstruction);
            registers[Operator1.getSigned()]=mem.read(Operator1);
            registers[Operator2.getSigned()]=mem.read(Operator2);
        }
        
    }

    //executes the given operation with the given addresses as parameters 
    public boolean execute(){
        //checks if the opcode is 0000, the halt operation, and returns false statement to continue loop
        if(opcode[0]==new Bit(false)&&opcode[1]==new Bit(false)&&opcode[2]==new Bit(false)&&opcode[3]==new Bit(false)){
            return false;
        //checks if the opcode is 0010, the interupt operation
        }else if(opcode[0]==new Bit(false)&&opcode[1]==new Bit(false)&&opcode[2]==new Bit(true)&&opcode[3]==new Bit(false)){
            //checks which of the interupts is prompted
            if(currentInstruction.getBit(15).getValue()){
                //prints memory dump
                mem.print();
            }else{
                //prints registers
                for(int i=0;i<16;i++){
                    registers[i].toString();
                }
            }
            return true;
            //checks if opcode is 0011, jumps to register at given address
        }else if(opcode[0]==new Bit(false)&&opcode[1]==new Bit(false)&&opcode[2]==new Bit(true)&&opcode[3]==new Bit(true)){
            currentInstruction=registers[result.getSigned()];
            store();
            return true;
            //subtracts 2 registers
        }else if(opcode[0]==new Bit(false)&&opcode[1]==new Bit(true)&&opcode[2]==new Bit(false)&&opcode[3]==new Bit(false)){
            longword Rx=registers[Operator2.getSigned()];
            longword Ry=registers[result.getSigned()];
            Bit[] op=new Bit[4];
            op[0]=new Bit(true);
            op[1]=new Bit(true);
            op[2]=new Bit(true);
            op[3]=new Bit(true);
            if(ALU.doOP(op,Rx,Ry).getSigned()==0){
                branch[1]=new Bit(true);
            }else if(ALU.doOP(op,Rx,Ry).getSigned()>0){
                branch[0]=new Bit(true);
            }else if(ALU.doOP(op,Rx,Ry).getSigned()<0){
                branch[0]=new Bit(false);
            }

            return true;
            //jumps
        }else if(opcode[0]==new Bit(false)&&opcode[1]==new Bit(true)&&opcode[2]==new Bit(false)&&opcode[3]==new Bit(true)){
            
            longword branchValue=new longword();
            Bit sign=currentInstruction.getBit(6)
            
            for(int i=7;i<16;i++){
                branchValue.setBit(i,currentInstruction.getBit(i));
            }
            


        }else{
            //gets ALU result from opcode and registers of the ops
            result=ALU.doOP(opcode, registers[Operator1.getSigned()], registers[Operator2.getSigned()]);
            return true;
        }
        
        
        
    }

    public void store(){
        //stores result in the op from the instruction
        registers[ResultRegister.getSigned()]=result;
        //writes the result back to the memory
        mem.write(ResultRegister, result);
    }

    //writes to the memory
    //@param instruction to write to memory
    public void memStore(longword instruction){
        //writes the entire longword into the memory
        for(int i=0;i<4;i++){
            mem.write(PC, instruction);
        }
    }

    //masks the instruction and shifts
    //@param instruction
    //@return mask of instruction
    public void op_mask(longword instruction){
        //shifts current instruction so that op1 is in 0000 0000 0000 XXXX format
        Operator1=instruction.rightShift(8);
        //shifts current instruction so that op1 is in 0000 0000 0000 XXXX format
        Operator2=instruction.rightShift(4);
        
        ResultRegister=currentInstruction;
        //creates 0000 0000 0000 XXXX mask
        longword mask=new longword(15);
        //masks op1
        Operator1=Operator1.and(mask);
        //masks op2
        Operator2=Operator2.and(mask);
        //masks result register
        ResultRegister=ResultRegister.and(mask);
    }


    //preloads the memory with bits from a String[]
    //@param String[] made of 2 instruction
    public void preload(String[] newBits){
        char[] instructions=newBits[0].toCharArray();
        longword instructionLongword=new longword();
        //sets each bit of the longword to store the new instructions
        for(int i=0;i<32;i++){
            if(instructions[i]=='1'){
                instructionLongword.setBit(i,new Bit(true));
            }else{
                instructionLongword.setBit(i,new Bit(false));
            }
        }
        memStore(instructionLongword);
    }

    
}