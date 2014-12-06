package cs4240_team1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;


public class Naive{
    
    private List<IRInstruction> codeList;
    
    public Naive(List<IRInstruction> codeList) {
        this.codeList = codeList;
    }
    
    //for convien
    public static final String newLine = "\n";
    public static final String he = " ";
    public static final String empty = "	";
    public static final String tempW = "$t";
    public static final String tempF = "$f";
    public static final String w = ".word";
    public static final String s = ".space";
    public static final String f = ".float";
    
    public static String dataSegment = "	.data\n";
    public static String textSegment = empty + ".text\n" + empty +  "\n";
    public static String temp = "";
    
    public boolean dataSegmentContains(String check){
        return dataSegment.contains(he +check + ":");
    }
    
    private Op op;
    private IRCodeArgument[] args;
    private String[] indexedArgs;
    
    int count = 0 ;
    public void generateAssembly() {
        int commasLeft = 3;
        for (IRInstruction eachInstruction : codeList) {
            this.op = eachInstruction.op;
            this.args = eachInstruction.args;
            System.out.println("instruction count : " + count + "op : " + this.op);
            count++;
            //System.out.println(dataSegment+textSegment);
            
            /** CASE 1: when op is LABEL (main, labels) */
            if(op == op.LABEL){
                for (IRCodeArgument codeArg : args) {
                    textSegment += codeArg.getTextForIR();
                    textSegment += ":";
                    textSegment += newLine;
                }
            }
            /** CASE 2: assignVar */
            else if(op == op.ASSIGNARR){
                System.out.println("assgin arr");
                int wC = 0;
                int fC = 0;
                int i = 0;
                String[] eachArgText = new String[3];
                TigerType[] eachArgData = new TigerType[3];
                
                for (IRCodeArgument codeArg : args) {
                    eachArgText[i] = codeArg.getTextForIR();
                    eachArgData[i] = codeArg.getTigerType();
                    i++;
                }
                temp = tempW + wC;
                textSegment += "la" + empty + temp + ", " + eachArgText[0] + newLine;

                if((eachArgText[1].matches("\\d+")) && (eachArgText[1].matches("[0-9]*\\.?[0-9]+"))){
//
                    if(!(dataSegmentContains(eachArgText[0]))){
                        if(eachArgData[0].isEquivalentToINT())  dataSegment += he + eachArgText[0] + ":" + empty + w + "   0" + newLine;
                        else if(eachArgData[0].isEquivalentToFloat())   dataSegment += he + eachArgText[0] + ":" + empty + f + "   0.0" + newLine;
                        else    System.out.println("why");
                    }
                    if(eachArgData[1].isEquivalentToINT())  temp = tempW + wC;
                    else if(eachArgData[1].isEquivalentToFloat())   temp = tempF + fC;
                    else    System.out.println("sad");
                    textSegment += "li" + empty + temp + ", " + eachArgText[1] + newLine;
                    textSegment += "sw" + empty + temp + ", " + eachArgText[0] + newLine;
                }
                else{
                    for(i =0; i < 2; i ++){
                        if(!(dataSegmentContains(eachArgText[i]))){
                            if(eachArgData[i].isEquivalentToINT())  dataSegment += he + eachArgText[i] + ":" + empty + w + "   0" + newLine;
                            else if(eachArgData[i].isEquivalentToFloat())   dataSegment += he + eachArgText[i] + ":" + empty + f + "   0.0" + newLine;
                            else    System.out.println("why");
                        }
                    }
                    if(eachArgData[1].isEquivalentToINT())    temp = tempW +wC;
                    else    temp = tempF +fC;
                    textSegment += "lw" + empty + temp + ", " + eachArgText[1] + newLine;
                    textSegment += "sw" + empty + temp + ", " + eachArgText[0] + newLine;
                }
            }
            
            /** CASE 3: assignVar */
            else if(op == op.ASSIGNVAR){
                System.out.println("assgin var");

                int wC = 0;
                int fC = 0;
                int i = 0;
                String[] eachArgText = new String[2];
                TigerType[] eachArgData = new TigerType[2];
                
                for (IRCodeArgument codeArg : args) {
                    eachArgText[i] = codeArg.getTextForIR();
                    eachArgData[i] = codeArg.getTigerType();
                    i++;
                }
                
                if((eachArgText[1].matches("\\d+")) && (eachArgText[1].matches("[0-9]*\\.?[0-9]+"))){

                if(!(dataSegmentContains(eachArgText[0]))){
                    if(eachArgData[0].isEquivalentToINT())  dataSegment += he + eachArgText[0] + ":" + empty + w + "   0" + newLine;
                    else if(eachArgData[0].isEquivalentToFloat())   dataSegment += he + eachArgText[0] + ":" + empty + f + "   0.0" + newLine;
                    else    System.out.println("why");
                }
                if(eachArgData[1].isEquivalentToINT())  temp = tempW + wC;
                else if(eachArgData[1].isEquivalentToFloat())   temp = tempF + fC;
                else    System.out.println("sad");
                textSegment += "li" + empty + temp + ", " + eachArgText[1] + newLine;
                textSegment += "sw" + empty + temp + ", " + eachArgText[0] + newLine;
                }
                else{
                    for(i =0; i < 2; i ++){
                        if(!(dataSegmentContains(eachArgText[i]))){
                            if(eachArgData[i].isEquivalentToINT())  dataSegment += he + eachArgText[i] + ":" + empty + w + "   0" + newLine;
                            else if(eachArgData[i].isEquivalentToFloat())   dataSegment += he + eachArgText[i] + ":" + empty + f + "   0.0" + newLine;
                            else    System.out.println("why");
                        }
                    }
                    if(eachArgData[1].isEquivalentToINT())    temp = tempW +wC;
                    else    temp = tempF +fC;
                    textSegment += "lw" + empty + temp + ", " + eachArgText[1] + newLine;
                    textSegment += "sw" + empty + temp + ", " + eachArgText[0] + newLine;
                }
            }
            /** CASE 2: assignLIT
            else if(op == op.ASSIGNLIT){
                int wC = 0;
                int fC = 0;
                int i = 0;
                String[] eachArgText = new String[2];
                TigerType[] eachArgData = new TigerType[2];
                
                for (IRCodeArgument codeArg : args) {
                    eachArgText[i] = codeArg.getTextForIR();
                    eachArgData[i] = codeArg.getTigerType();
                    i++;
                }
                for(i =0; i < 2; i ++){
                    if(!(dataSegmentContains(eachArgText[i]))){
                        if(eachArgData[i].isEquivalentToINT())  dataSegment += he + eachArgText[i] + ":" + empty + w + "   0" + newLine;
                        else if(eachArgData[i].isEquivalentToFloat())   dataSegment += he + eachArgText[i] + ":" + empty + f + "   0.0" + newLine;
                        else    System.out.println("why");
                    }
                }
                if(eachArgData[1].isEquivalentToINT())    temp = tempW +wC;
                else    temp = tempF +fC;
                textSegment += "lw, " + temp + ", " + eachArgText[1] + newLine;
                textSegment += "sw, " + temp + ", " + eachArgText[0] + newLine;
            }
            */
            
            /** CASE 4: Arithmatic (add, sub, mult, div, and, or)*/
            else if((op == op.ADD) || (op == op.SUB) || (op == op.MULT) || (op == op.DIV) || (op == op.AND) || (op == op.OR)){
                int wC = 0;
                int fC = 0;
                int i = 0;
                String[] tempArr = new String[2];
                String[] eachArgText = new String[3];
                TigerType[] eachArgData = new TigerType[3];
                for (IRCodeArgument codeArg : args) {
                    eachArgText[i] = codeArg.getTextForIR();
                    eachArgData[i] = codeArg.getTigerType();
                    i++;
                }
                if(!(dataSegmentContains(eachArgText[2]))){
                    if(eachArgData[2].isEquivalentToINT())  dataSegment += he + eachArgText[2] + ":" + empty + w + "   0" + newLine;
                    else if(eachArgData[2].isEquivalentToFloat())   dataSegment += he + eachArgText[2] + ":" + empty + f + "   0.0" + newLine;
                    else    System.out.println("why");
                }
                if ((op == op.ADD) && (eachArgText[0].matches("\\d+") ^ eachArgText[1].matches("\\d+"))){
                    /** CASE 2_1: Special Arithmatic (addi)*/
                    for(i = 0; i < 2; i++){
                        if((!eachArgText[i].matches("\\d+")) && (!eachArgText[i].matches("[0-9]*\\.?[0-9]+"))){
                            if(!(dataSegmentContains(eachArgText[i]))){
                                if(eachArgData[i].isEquivalentToINT())  dataSegment += he + eachArgText[i] + ":" + empty + w + "   0" + newLine;
                                else if(eachArgData[i].isEquivalentToFloat())   dataSegment += he + eachArgText[i] + ":" + empty + f + "   0.0" + newLine;
                                else    System.out.println("no");
                            }if(eachArgData[i].isEquivalentToINT()){
                                tempArr[i] = tempW +wC;
                                wC++;
                            }else{
                                tempArr[i] = tempF +fC;
                                fC++;
                            }
                            textSegment += "lw, " + tempArr[i] + ", " + eachArgText[i] + newLine;
                            eachArgText[i] = tempArr[i];
                        }
                    }
                    if(eachArgData[0].isEquivalentToINT())  temp = tempW + wC;
                    else if(eachArgData[0].isEquivalentToFloat())  temp = tempF + fC;
                    else    System.out.println("why");
                    textSegment += "addi, " + temp + ", " + tempArr[0] + ", " + tempArr[1] + newLine;
                    textSegment += "sw, " + temp + ", " + eachArgText[1] + newLine;
                }
                else{
                for(i = 0; i < 2; i++){
                    if((!eachArgText[i].matches("\\d+")) && (!eachArgText[i].matches("[0-9]*\\.?[0-9]+"))){
                        if(!(dataSegmentContains(eachArgText[i]))){
                            if(eachArgData[i].isEquivalentToINT())  dataSegment += he + eachArgText[i] + ":" + empty + w + "   0" + newLine;
                            else if(eachArgData[i].isEquivalentToFloat())   dataSegment += he + eachArgText[i] + ":" + empty + f + "   0.0" + newLine;
                            else    System.out.println("no");
                        }if(eachArgData[i].isEquivalentToINT()){
                            tempArr[i] = tempW +wC;
                            wC++;
                        }else{
                            tempArr[i] = tempF + fC;
                            fC++;
                        }
                        textSegment += "lw" + empty + tempArr[i] + ", " + eachArgText[i] + newLine;
                    }
                    else{
                        if(eachArgData[i].isEquivalentToINT()){
                            tempArr[i] = tempW + wC;
                            wC++;
                        }else if(eachArgData[i].isEquivalentToFloat()){
                            tempArr[i] = tempF + fC;
                            fC++;
                        }else    System.out.println("dead lock");
                        textSegment += "li" + empty + tempArr[i] + ", " + eachArgText[i] + newLine;

                    }
                }
                if(eachArgData[0].isEquivalentToINT())  temp = tempW + wC;
                else if(eachArgData[0].isEquivalentToFloat()) temp = tempF + fC;
                else    System.out.println("why");
                
                if(op == op.ADD)  textSegment += "add" + empty + temp + ", " + tempArr[0] + ", " + tempArr[1] + newLine;
                else if(op == op.SUB)  textSegment += "sub"+ empty + temp + ", " + tempArr[0] + ", " + tempArr[1] + newLine;
                else if(op == op.MULT)  textSegment += "div" + empty + temp + ", " + tempArr[0] + ", " + tempArr[1] + newLine;
                else if(op == op.DIV)  textSegment += "mul" + empty + temp + ", " + tempArr[0] + ", " + tempArr[1] + newLine;
                else if(op == op.AND)  textSegment += "and" + empty + temp + ", " + tempArr[0] + ", " + tempArr[1] + newLine;
                else if (op == op.OR)  textSegment += "or" + empty + temp + ", " + tempArr[0] + ", " + tempArr[1] + newLine;
                
                textSegment += "sw" + empty + temp + ", " + eachArgText[2] + newLine;
                
            }
            }
            
            /** CASE 5: branch */
            else if((op == op.BREQ) || (op == op.BRNEQ) || (op == op.BRLT) || (op == op.BRGT) || (op == op.BRGEQ) || (op == op.BRLEQ)){
                int wC = 0;
                int fC = 0;
                int i = 0;
                String[] tempArr = new String[2];
                String[] eachArgText = new String[3];
                TigerType[] eachArgData = new TigerType[3];
                for (IRCodeArgument codeArg : args) {
                    eachArgText[i] = codeArg.getTextForIR();
                    eachArgData[i] = codeArg.getTigerType();
                    i++;
                }
                
                for(i = 0; i < 2; i++){
                    if((!eachArgText[i].matches("\\d+")) && (!eachArgText[i].matches("[0-9]*\\.?[0-9]+"))){
                        if(!(dataSegmentContains(eachArgText[i]))){
                            if(eachArgData[i].isEquivalentToINT())  dataSegment += he + eachArgText[i] + ":" + empty + w + "   0" + newLine;
                            else if(eachArgData[i].isEquivalentToFloat())   dataSegment += he + eachArgText[i] + ":" + empty + f + "   0.0" + newLine;
                            else    System.out.println("no");
                        }if(eachArgData[i].isEquivalentToINT()){
                            tempArr[i] = tempW +wC;
                            wC++;
                        }else{
                            tempArr[i] = tempF + fC;
                            fC++;
                        }
                        textSegment += "lw" + empty + tempArr[i] + ", " + eachArgText[i] + newLine;
                    }
                    else{
                        if(eachArgData[i].isEquivalentToINT()){
                            tempArr[i] = tempW + wC;
                            wC++;
                        }else if(eachArgData[i].isEquivalentToFloat()){
                            tempArr[i] = tempF + fC;
                            fC++;
                        }else    System.out.println("dead lock");
                        textSegment += "li" + empty + tempArr[i] + ", " + eachArgText[i] + newLine;
                        
                    }
                }
                if(eachArgData[0].isEquivalentToINT())  temp = tempW + wC;
                else if(eachArgData[0].isEquivalentToFloat()) temp = tempF + fC;
                else    System.out.println("why");
                
                if(op == op.BREQ)  textSegment += "beq" + empty + tempArr[0] + ", " + tempArr[1] + ", " + tempArr[2] + newLine;
                else if(op == op.BRNEQ)  textSegment += "bne" + empty + temp + ", " + tempArr[0] + ", " + tempArr[1] + newLine;
                else if(op == op.BRLT)  textSegment += "bge" + empty + temp + ", " + tempArr[0] + ", " + tempArr[1] + newLine;
                else if(op == op.BRGT)  textSegment += "ble" + empty + temp + ", " + tempArr[0] + ", " + tempArr[1] + newLine;
                else if(op == op.BRGEQ)  textSegment += "blt" + empty + temp + ", " + tempArr[0] + ", " + tempArr[1] + newLine;
                else if (op == op.BRLEQ)  textSegment += "bgt" + empty + temp + ", " + tempArr[0] + ", " + tempArr[1] + newLine;
                
                textSegment += "sw" + empty + temp + ", " + eachArgText[2] + newLine;
                
                
            }
            
            /** CASE 6: array store */
            /** CASE 7: array load */
            /** CASE 8: return */
            /** CASE 9: goto */


            
            else {}
        }
        return;

    }
}