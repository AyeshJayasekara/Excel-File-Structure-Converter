/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poi;

/**
 *
 * @author Lab01_pcBackup
 */
public class WordSeperate {
    String[] FinalWordSet;
    int spaces[];
    int Wordcount = 1;
    public String[] WordSeperator(String sentence){
        FinalWordSet = new String[20];
        FinalWordSet = sentence.split("\\s+");
        String[] temp = new String[FinalWordSet.length];
        FinalWordSet = FindNames(FinalWordSet);
        
//        String[] a = sentence.split("\\s+");
//        for(String d : a)
//            System.out.println("11 "+d);
//        int beginIndex=0,endIndex=0,p=0,i;
//        spaces = new int[20];
//        spaces = assignZero(spaces);
//        spaces = findSpaces(sentence,spaces);
//        for(i=0;i<Wordcount-2;i++){
//            if(i==0){
//                beginIndex=0;
//                endIndex=spaces[0];
//            }else{
//                beginIndex=endIndex+1;
//                endIndex=spaces[i+1];
//            }
//            
//            //beginIndex=spaces[p];
//            if(endIndex>=sentence.length())
//                endIndex = sentence.length()-1;
//            if(beginIndex >= sentence.length())
//                break;
//            FinalWordSet[i]=sentence.substring(beginIndex,endIndex);
//            System.out.print("W "+FinalWordSet[i]);

            //beginIndex=endIndex+1;
            //endIndex=spaces[1];
            //p++;
        //}
        //beginIndex=endIndex+1;
        //endIndex=sentence.length();
        
        //FinalWordSet[i]=sentence.substring(beginIndex,endIndex);
        //FinalWordSet = FindNames(FinalWordSet);
        //print(FinalWordSet);
        return FinalWordSet;
    }
    
    public int[] assignZero(int[] arr){
        for(int i=0;i<arr.length;i++)
            arr[i]=0;
        return arr;
    }
    
    public int[] findSpaces(String sentence,int arr[]){
        String temp=sentence;
        int x=0,p=0,l=sentence.length();
        for(int i=0;i<temp.length();i++){
            if(temp.charAt(i)== ' '){
                if(i<temp.length()-1){
                arr[x++]=i;
                Wordcount++;
                }
            }
        }
        for(int c : arr){
            System.out.println(""+c);
        }
        return arr;
    }
    
    void print(String[] a){
        for(String x: a)
            System.out.println(""+x);
            //System.out.println(""+x);
    }
    public String[] FindNames(String[] NameList){
        String[] Temp = new String[15];
        int x=0;
        for(String name : NameList){
            if(name==null)
                continue;
            name = cleanUp(name);
            //System.out.println("asdasdsa "+name);
            if(name.length()>1)
                Temp[x++]=name;
        }
            
        return Temp;
    }
    
    public String cleanUp(String word){
        String temp="";
       if(word != null){
       char[] arr = word.toCharArray();
       int length = word.length();
       for(char a : arr){
           if(Character.isAlphabetic(a))
               temp = temp + a;
               //System.out.println(""+a);
       }
        //return temp;
    }
       return temp;
    }
    
    
}
