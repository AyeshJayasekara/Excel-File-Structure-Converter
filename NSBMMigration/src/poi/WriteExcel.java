package poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class WriteExcel 
{
    static FileInputStream file;
    static FileOutputStream out;
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    static String[] FullName = null;  
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
        sheet = null;
        //Create Workbook instance holding reference to .xlsx file
	workbook = null;
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
    public void Write(String arr[],int x,int rownum) 
	{
 
                sheet = getSheet(openFile("Book1.xlsx"));
		//This data needs to be written (Object[])
		Map<String, Object[]> data = new TreeMap<String, Object[]>();
                Object n[];
                n = (Object[])arr;
		data.put(""+x,arr);	 
		//Iterate over data and write to sheet
		Set<String> keyset = data.keySet();
		//int rownum = 0;
		for (String key : keyset)
		{
		    Row row = sheet.createRow(rownum++);
		    Object [] objArr = data.get(key);
		    int cellnum = 0;
		    for (Object obj : objArr)
		    {
		       Cell cell = row.createCell(cellnum++);
		       if(obj instanceof String)
		            cell.setCellValue((String)obj);
		        else if(obj instanceof Integer)
		            cell.setCellValue((Integer)obj);
		    }
		}
		Finalize(openOutFile("Book1.xlsx"));
	}

        
        public void Finalize(FileOutputStream out){
            try 
		{
                    //Write the workbook in file system
		    workbook.write(out);
		    //out.close();
                    CloseOutFile();
		    System.out.println("Book1.xlsx written successfully on disk.");
		     
		} 
		catch (Exception e) 
		{
                    System.out.println("Error Writing to file!");
		    e.printStackTrace();
		}
            
        }
      static void CloseOutFile(){
        try {
            out.close();
        } catch (IOException ex) {
            System.out.println("Couldn't close file!");
            Logger.getLogger(ReadExcelDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    static FileOutputStream openOutFile (String FileName){
        out=null;
        try {
            out = new FileOutputStream(new File(FileName));
        } catch (FileNotFoundException ex) {
            System.out.println("Couldn't open File!");
            Logger.getLogger(ReadExcelDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return out;
    }  
}
