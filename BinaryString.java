/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarystring;
import java.util.ArrayList;
/**
 *
 * @author DoyleS
 */
public class BinaryString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //String sentence = "I love numbers.";
        NumberConverter nc = new NumberConverter();
        nc.setVisible(true);
    }
    
    public static String[] run(String sentence){
        char[] characters = makeArray();
        
        int[] numSentence = new int[sentence.length()];
        String[] binarySentence = new String[sentence.length()];
        String allBinary = "";
        String binaryAndSpaces = "";
        int count = 0;
        
        for(int i = 0; i < sentence.length(); i++){
            for(int j = 0; j < characters.length; j++){
                //if character is found, then number is index value in character array
                if(sentence.charAt(i)==characters[j]){
                    numSentence[i] = j;
                    //System.out.print(j+" ");
                    binarySentence[count] = intToBinary(j);
                    allBinary += binarySentence[count];
                    binaryAndSpaces+= binarySentence[count]+" ";
                    count++;
                }
            }
        }
        //System.out.println("\n" + binaryAndSpaces+"\n");
        return binarySentence;
    }
    
    public static String intToBinary(int i){
        ArrayList<Integer> binaryList = new ArrayList<Integer>();
        String s="";
        //int ans = i;
        for(int n = 0; n < 8; n++){
            if(i<1)
                binaryList.add(0, 0);
            else{
                int r = i%2;
                i = i/2;
                binaryList.add(0, r);
            }
            
        }
        
        for(int n = 0; n < binaryList.size(); n++){
            s+= binaryList.get(n);
        }
        
        return s;
    }
    
    public static String binaryToString(String b){
        int n = 0;
        int exp = 0;
        
        for (int i = b.length()-1; i > -1; i--){
            if(b.charAt(i)=='1'){
                String temp = b.charAt(i)+"";
                n += (Integer.parseInt(temp) * Math.pow(2, exp));
            }
            exp++;    
        }
        
        char[] characters = makeArray();
        int[] restoredInts = new int[b.length()];
        String restored = characters[n]+"";
        
        return restored;
    }
    
    public static char[] makeArray(){
        char[] characters = new char[127];
        char letter = ' ';
        for(int i = 33; i < 127; i++){ 
            characters[i] = letter;
            letter++;
//            if(i==25)
//                letter = 'a';   
        }
//        characters[52] = '.';
//        characters[53] = ' ';
        return characters;
    }
    
    public static ArrayList<String> recSplit(String b, ArrayList<String> list){
        String first = b.substring(0,8);
        list.add(first);
        if(b.length()>9){
            String remaining = b.substring(9);
            recSplit(remaining, list);
        }

        return list;
    }
    
    public static ArrayList<String> binaryToHex(String b, ArrayList<String> list){
        String first = b.substring(0,4);
        int temp = 0;
        for(int i = 3; i > -1; i--){
            //if i is 3
            switch(i){
                case 3:{
                    temp+=Integer.parseInt(first.charAt(i)+"");
                    break;
                }
                case 2:{
                    temp+=(Integer.parseInt(first.charAt(i)+"")*2);
                    break;
                }
                case 1:{
                    temp+=(Integer.parseInt(first.charAt(i)+"")*4);
                    break;
                }
                case 0:{
                    temp+=(Integer.parseInt(first.charAt(i)+"")*8);
                    break;
                }
            }
        }
        
        String listVar="";
        //if temp>9
        switch(temp){
            case 10:{
                listVar = "A";
                break;
            }
            case 11:{
                listVar = "B";
                break;
            }
            case 12:{
                listVar = "C";
                break;
            }
            case 13:{
                listVar = "D";
                break;
            }
            case 14:{
                listVar = "E";
                break;
            }
            case 15:{
                listVar = "E";
                break;
            }
            default:{
                listVar = temp+"";
                break;
            }
        }
        list.add(listVar);
        if(b.length()>4){
            String remaining = b.substring(4);
            binaryToHex(remaining, list);
        }
        
        return list;
    }
    
    public static ArrayList<String> hexToBinary(String hexS){
        ArrayList<String> binList = new ArrayList<String>();
        String newValue = "";
        boolean space1 = false;
        boolean space2 = false;
        for (int i = 0; i < hexS.length(); i++){
            char current = hexS.charAt(i);
            switch(current){
                case'0':{
                    newValue+="0000";
                    break;
                }
                case'1':{
                    newValue+="0001";
                    break;
                }
                case'2':{
                    newValue+="0010";
                    break;
                }
                case'3':{
                    newValue+="0011";
                    break;
                }
                case'4':{
                    newValue+="0100";
                    break;
                }
                case'5':{
                    newValue+="0101";
                    break;
                }
                case'6':{
                    newValue+="0110";
                    break;
                }
                case'7':{
                    newValue+="0111";
                    break;
                }
                case'8':{
                    newValue+="1000";
                    break;
                }
                case'9':{
                    newValue+="1001";
                    break;
                }
                case'A':{
                    newValue+="1010";
                    break;
                }
                case'B':{
                    newValue+="1011";
                    break;
                }
                case'C':{
                    newValue+="1100";
                    break;
                }
                case'D':{
                    newValue+="1101";
                    break;
                }
                case'E':{
                    newValue+="1110";
                    break;
                }
                case'F':{
                    newValue+="1111";
                    break;
                }
                case ' ':{
                    binList.add(newValue);
                    newValue = "";
                    break;
                }
                default:{
                    break;
                }
            }//switch
        }//for
        return binList;
    }
}
