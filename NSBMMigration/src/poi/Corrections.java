/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poi;

import java.io.BufferedReader;
import migration.DatabaseSearch;

/**
 *
 * @author ejkpac Ayesh Jayasekara
 */

public class Corrections {
    DatabaseSearch Address;
    String[] DataArray;
    String[] NewOrder = null;
    String FullName;
    String FName;
    String LName;
    String MName;
    String[] temp;
    String[] Location;
    WordSeperate Seperate;
    String[] PhoneType; 
    boolean found;
    boolean isOtherPresent = false;
    String otherNum = null;
    BufferedReader br = null;
    private String[] Guard;
    public Corrections() {
        Seperate = new WordSeperate();
        temp = new String[7];
        PhoneType = new String[2];
        PhoneType[0]="Mobile";
        PhoneType[0]="Home";
        Location = new String[3];
        Address = new DatabaseSearch();
        Guard = new String[6];
    }
    
    
    public String[] correct(String[] arr){
        DataArray = arr;
        isOtherPresent = false;
        NewOrder = new String[DataArray.length];
        init();
        //ID Field
        NewOrder[0]=DataArray[0].substring(0,DataArray[0].length()-2); // ID
        NewOrder[1]=DataArray[2]; //Title
        SolveName(DataArray[3]+" "+DataArray[4]);
        NewOrder[2] = FName; //Names
        NewOrder[3] = LName; //Names
        NewOrder[4] = MName; //Names
        NewOrder[5] = FName; //Names
        NewOrder[6]=DataArray[6]; //DOB
        NewOrder[49]=CorrectPhone(DataArray[7]); //phone
        NewOrder[50]=CheckPhoneType(DataArray[7]); //phone type
        
        if(DataArray[8] != null){
            isOtherPresent=true;
            otherNum = DataArray[8];
        }
        
        NewOrder[7]=setGender(DataArray[2]); //Gender
        SetLocality(DataArray[5]);
        NewOrder[8]=temp[0];
        NewOrder[9]=temp[1];
        NewOrder[10]=temp[2];
        NewOrder[13]=temp[3];
        NewOrder[16]=temp[4];
        NewOrder[17]=temp[5];
        NewOrder[21]=temp[6];
        NewOrder[42]="Other";
        
//        if(DataArray[12] != null){
//            getDistrict(DataArray[12]);
//            //NewOrder[44] = "dfgd";//Location[2];
//                    if(found){
//                        NewOrder[44] = Location[2];
//        }
//        }
//        
//        
//        
        NewOrder[44]= Address.getPostalCode(DataArray[12]);
        NewOrder[43]= Address.getPro();
        //System.out.println(""+DataArray[12]);
        NewOrder[41]= Address.getDistric();
        
        NewOrder[45]="Sri Lanka"; //country
        NewOrder[46]="Home";
        NewOrder[47]=DataArray[9];
        if(NewOrder[47] != null)
        NewOrder[47] =NewOrder[47].toLowerCase();
        NewOrder[48]="Personal";
        
        
        NewOrder[33]=DataArray[10];
        NewOrder[34]=DataArray[11];
        NewOrder[35]=DataArray[12];
        
//        if(Location[2]!=null){
//            NewOrder[44] = Location[2];
//        }
        
        setGuardian(DataArray);
        return NewOrder;
    }
    
    public void init(){
        for(int i = 0 ; i< NewOrder.length ; i++)
            NewOrder[i] = " ";
    }
    public void SolveName(String Name){
        System.out.println("Name :" +Name);
        String[] arr = Seperate.WordSeperator(Name);
        LName = arr[0];
        FName = arr[1];
        MName = arr[2];
    }
    
    public String setGender(String Title){
        Title = Title.toUpperCase();
        if(Title.equals("MR"))
            return "Male";
        else if(Title.equals("MRS")  || Title.equals("MS"))
            return "Female";
        return "Other";
    }
    
    public void SetLocality(String NIC){
        //String[] arr = new String[7];
        NIC = NIC.toUpperCase();
        if(NIC.indexOf('V')!=-1){
            temp[0]="Sri Lanka";
            temp[1]="Sri Lankan";
            temp[2]="Domestic";
            temp[3]="Yes";
            temp[4]="No";
            temp[5]="No";
            temp[6]="Sinhalese";
            
        }
        else{
            temp[0]="Sri Lanka";
            temp[1]="Other";
            temp[2]="Domestic";
            temp[3]="Yes";
            temp[4]="No";
            temp[5]="No";
            temp[6]="Sinhalese";
        }
    }
    
    
    public String CheckPhoneType(String num){
       char[] n = num.toCharArray();
       String temp=PhoneType[0];
       if(n[0]== '0' && n[1] != '7'){
        temp=PhoneType[1];
        }
       return "Mobile";
    }
    public String CorrectPhone(String num){
        String temp =null;
        int x = num.indexOf("E");
        if(x != -1)
            num= num.substring(0, x);
        x=num.indexOf('.');
        temp = num;
        if(x!=-1){
        temp = num.substring(0, x);
        temp = temp + num.substring(x+1, num.length());
        }
        if(temp.length()== 8)
            temp = temp +"0";
        return temp;
    }
    public String GetHomeNum(){
        if(!isOtherPresent)
        return CorrectPhone(otherNum);
        return null;
    }
    
//    public void getDistrict(String AddLine3){
//        String[] arr =null,Search = null;
//        String City,foundCity=null;
//        int[] ee;
//        String sCurrentLine;
//        found =false;
//        if(AddLine3.length()>0){
//        arr= AddLine3.split("\\+s");
//        City = arr[arr.length-1];
//           // System.out.println("CCCCCCCCCCCCCC "+City);
//        City = City.toUpperCase();
//        try{
//            br = new BufferedReader(new FileReader("testing.txt"));
//        while ((sCurrentLine = br.readLine()) != null) {
//                                //Search = sCurrentLine.split("\\s+");
//                                Search = sCurrentLine.split("\\t");
//                                //Search = Seperate.WordSeperator(sCurrentLine);
//                                //System.out.println("DDDDDDDDDDD "+Search[0]);
//                                foundCity = Search[0];
//                                foundCity = foundCity.toUpperCase();
//                                foundCity = foundCity.substring(0, foundCity.length()-1);
//                                if(foundCity.length()>0){
//                                    if(foundCity.equals(City)){
//                                        System.out.println("FounDDDDDDSSSSSSS "+foundCity);
//                                        found = true;
//                                        break;
//                                    }                                       
//                                }
//				//System.out.println(sCurrentLine);
//	}
//        }catch(Exception e){
//            System.out.println("Read Error : "+e.toString());
//        }
//        }
//        try {
//            br.close();
//        } catch (IOException ex) {
//            Logger.getLogger(Corrections.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        if(found){
//            System.out.println(""+Search.length);
//            System.out.println(""+Search[0]);
//            Location[2] =Search[0];
//            System.out.println(""+Location[2]);
//        }
//    }
    
    public void setGuardian(String[] ARR){
        String Fname,Lname = "",Stat = "Other",Mob,Tel,Rel;
        int x = ARR[21].indexOf('.');
        if(x!=-1)
            Stat = ARR[21].substring(0, x);
        Fname = ARR[21].substring(x+1);
        Mob = ARR[24];
        Tel = ARR[25];
        Rel = ARR[22];
        Guard[0]=Stat;
        Guard[1]=Fname;
        Guard[2]=Lname;
        Guard[3]=Rel;
        Guard[4]=Mob;
        Guard[5]=Tel;
    }

    public String[] getGuard() {
        return Guard;
    }
}
