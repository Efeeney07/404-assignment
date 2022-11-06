

public class Assembler {
    
    public static String[] assemble(String[] instruction){
        String operation="";
        String R1="";
        String R2="";
        String result="";
        for(int i=0;i<4;i++){
            operation.concat(instruction[i]);
        }
     
        longword R1Word=new longword();
        longword R2Word=new longword();
        longword resultWord=new longword();
        for(int i=4;i>=0;i--){
            if(instruction[i+4]=="1"){
                rippleAdder.add(R1Word,new longword((int)Math.pow(2,i)));
            }
            if(instruction[i+8]=="1"){
                rippleAdder.add(R1Word,new longword((int)Math.pow(2,i)));
            }
            if(instruction[i+12]=="1"){
                rippleAdder.add(R1Word,new longword((int)Math.pow(2,i)));
            }
        }
        R1=String.valueOf(R1Word.getSigned());
        R2=String.valueOf(R2Word.getSigned());
        result=String.valueOf(resultWord.getSigned());
        switch (operation){
            case "1000":operation="and";break;
            case "1001":operation="or";break;
            case "1010":operation="xor";break;
            case "1011":operation="not";break;
            case "1100":operation="left shift";break;
            case "1101":operation="right shift";break;
            case "1110":operation="add";break;
            case "1111":operation="subtract";break;
            case "0111":operation="multiply";break;
            case "0000":operation="halt";break;
            case "0001":operation="move";break;
            case "0010":operation="interupt";break;
        }
        
        if(operation=="move"){
            R2=String.valueOf(rippleAdder.add(R2Word,resultWord).getSigned());
            String instrucString="";
            instrucString.concat(operation);
            instrucString.concat(" "+R1);
            instrucString.concat(" "+R2);
            String[] returnString=new String[instrucString.length()];
            returnString[0]=instrucString;
            return returnString;
        }else{
            String instrucString="";
            instrucString.concat(operation);
            instrucString.concat(" "+R1);
            instrucString.concat(" "+R2);
            instrucString.concat(result);
            String[] returnString=new String[instrucString.length()];
            returnString[0]=instrucString;
            return returnString;
        }
        
    }
}
