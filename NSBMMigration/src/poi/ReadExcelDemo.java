package poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDemo 
{
    static FileInputStream file;
    static String[] FullName = null;
    
    static void FindNames(String Name){
        WordSeperate a = new WordSeperate();
        FullName=a.WordSeperator(Name);
    }
    
    static void CloseFile(){
        try {
            file.close();
        } catch (IOException ex) {
            System.out.println("Couldn't close file!");
            Logger.getLogger(ReadExcelDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static FileInputStream openFile (String FileName){
        file=null;
        try {
            file = new FileInputStream(new File(FileName));
        } catch (FileNotFoundException ex) {
            System.out.println("Couldn't open File!");
            Logger.getLogger(ReadExcelDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return file;
    }
    
    static XSSFSheet getSheet(FileInputStream F){
        XSSFSheet sheet = null;
        //Create Workbook instance holding reference to .xlsx file
	XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(F);
        } catch (IOException ex) {
            System.out.println("Couldn't open sheet!");
            Logger.getLogger(ReadExcelDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
	//Get first/desired sheet from the workbook
	sheet = workbook.getSheetAt(0);
        //Iterate through each rows one by one
        return sheet;
    }
    
    public static void main(String[] args) 
	{
            WriteExcel write = new WriteExcel();
            XSSFSheet sheet = getSheet(openFile("Student Master-MM-15.1.xlsx"));
            ReadExcel read = new ReadExcel(sheet);
            read.StartRead();
            CloseFile();
            System.out.println("Process Complete!!!!");
	}
        
        static String[] Corrections(String arr[]){
            String newArr[] = arr;
            String temp;
            temp = arr[0];
            newArr[0]=arr[0].substring(0,temp.length()-2);
            newArr[1]=arr[2];
            newArr[2]=getLastName(arr[4]);
            newArr[3]=getFirstName(arr[4]);
            newArr[4]=getMiddleName(arr[4]);
            return newArr;
        }
        
        static String getFirstName(String FullName){
            String finalName = null;
            String temp = null;
            int x;
            do{
            x=FullName.indexOf(" ");
            temp=FullName;
            FullName=FullName.substring(x+1);
            }while(FullName.indexOf(" ")!=-1);
            x=temp.indexOf(" ");
            FullName = temp.substring(0, x);
            return FullName;
        }
        static String getMiddleName(String FullName){
            return FullName;
        }
        static String getLastName(String FullName){
            String finalName = null;
            String temp = null;
            int x;
            do{
            x=FullName.indexOf(" ");
            FullName=FullName.substring(x+1);
            }while(FullName.indexOf(" ")!=-1);
            finalName=FullName;
            return FullName;
        }
}
