
public class Assembler {
    
    //assembles binary instruction into readible commands
    //@param String[] of instruction bits
    //@param String[] of readible words
    public static String[] assemble(String[] instruction) throws Exception{
        //creates new String[] to store each instruction
        String[] operation=new String[4];
        String[] R1=new String[4];
        String[] R2=new String[4];
        String[] result=new String[4];
        //gets the first 4 bits of the instruction for operator
        for(int i=0;i<4;i++){
            operation[i]=(instruction[i]);
        }
        
        //creates longwords to store binary value of instruction
        longword R1Word=new longword();
        longword R2Word=new longword();
        longword resultWord=new longword();
        //copies each instruction into its own String[]
        for(int i=4;i>=0;i--){
            if(instruction[i+4]=="1"){
                rippleAdder.add(R1Word,new longword((int)Math.pow(2,i)));
            }
            if(instruction[i+8]=="1"){
                rippleAdder.add(R2Word,new longword((int)Math.pow(2,i)));
            }
            if(instruction[i+12]=="1"){
                rippleAdder.add(resultWord,new longword((int)Math.pow(2,i)));
            }
        }
        //creates string from longword signed value
        R1[0]=String.valueOf(R1Word.getSigned());
        R2[0]=String.valueOf(R2Word.getSigned());
        result[0]=String.valueOf(resultWord.getSigned());
        //translates each op code from binary to english
        switch (operation[0]){
            case "1000":operation[0]="and";break;
            case "1001":operation[0]="or";break;
            case "1010":operation[0]="xor";break;
            case "1011":operation[0]="not";break;
            case "1100":operation[0]="left shift";break;
            case "1101":operation[0]="right shift";break;
            case "1110":operation[0]="add";break;
            case "1111":operation[0]="subtract";break;
            case "0111":operation[0]="multiply";break;
            case "0000":operation[0]="halt";break;
            case "0001":operation[0]="move";break;
            case "0010":operation[0]="interupt";break;
            case "0011":operation[0]="jump";break;
            default: throw new Exception();
        }

        

        //checks if operator is move
        if(operation[0]=="move"){
            //sets R2 to the value of R2 and result
            for(int i=8;i<16;i++){
                if(instruction[i+8]=="1"){
                    rippleAdder.add(R2Word,new longword((int)Math.pow(2,i-8)));
                }
            }
            String instrucString="";
            instrucString.concat(operation[0]);
            instrucString.concat(" "+R1[0]);
            instrucString.concat(" "+R2[0]);
            String[] returnString=new String[instrucString.length()];
            returnString[0]=instrucString;
            return returnString;
        }else if(operation[0]=="jump"){
            
        }else{
            String instrucString="";
            instrucString.concat(operation[0]);
            instrucString.concat(" "+R1[0]);
            instrucString.concat(" "+R2[0]);
            instrucString.concat(result[0]);
            String[] returnString=new String[instrucString.length()];
            returnString[0]=instrucString;
            return returnString;
        }
        
    }
}
