/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poi;


import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 *
 * @author Lab01_pcBackup
 */
public class ReadExcel {
    XSSFSheet sheet= null;
    String FullName;
    String FName;
    String LName;
    String MName;
    WordSeperate Seperate;
    Corrections Correct;
    public ReadExcel(XSSFSheet s) {
        sheet = s;
        Seperate = new WordSeperate();
        Correct = new Corrections();      
    }
    
    public void StartRead(){
            int p=1,l=1;
            WriteExcel write = new WriteExcel();
            WriteExcel write1 = new WriteExcel();
            String arr[] = new String[55];
            String g[];
            String temp[];
            //write.Write(arr);
            int cellnum=0;
            int rownum=0;
            //FileInputStream file = new FileInputStream(new File("Student Master-MM-15.1.xlsx"));
                Iterator<Row> rowIterator = sheet.iterator();
                int i=0;
                while(rowIterator.hasNext()){
                    if(i==9) break;
                    i++;
                    Row row = rowIterator.next();
                }
                
                while (rowIterator.hasNext()) 
                {
                        cellnum=0;

                        Row row = rowIterator.next();
                        //For each row, iterate through all the columns
                        Iterator<Cell> cellIterator = row.cellIterator();

                        while (cellIterator.hasNext()) 
                        {
                                Cell cell = cellIterator.next();
                                //Check the cell type and format accordingly
                                switch (cell.getCellType()) 
                                {
                                        case Cell.CELL_TYPE_NUMERIC:
                                                //System.out.print(cell.getNumericCellValue() + "\t");
                                                arr[cellnum]=""+cell.getNumericCellValue();                                                       
                                                break;
                                        case Cell.CELL_TYPE_STRING:
                                                //System.out.print(cell.getStringCellValue() + "\t");
                                                arr[cellnum]=cell.getStringCellValue();
                                                break;
                                }                            
                                cellnum++;
                        }
                        l++;
                        System.out.println(" "+l);
                        String a = arr[8];
                        String o = arr[0];
                        arr = Correct.correct(arr);
                        write.Write(arr,p++,rownum++);
                        //write.Write(arr,p++,rownum++);
                        a = Correct.CorrectPhone(a);
                        g=Correct.getGuard();
                        if(a != null && a.indexOf(' ') == -1){
                            for(int t = 0;t<arr.length;t++){
                                arr[t] = " ";
                            }
                            temp=arr;
                            arr[0] = o.substring(0,o.length()-2);
                            arr[49]=a;
                            arr[50]="Home";
                            write.Write(arr,p++,rownum++);
                            temp[0]= o.substring(0,o.length()-2);
                            temp[1]= g[0];
                            temp[2]= g[1];
                            temp[3]= g[2];
                            write.Write(temp,p++,rownum++);
                            
                        }
                        System.out.println(""+g[0]);
                        System.out.println(""+g[1]);
                        System.out.println(""+g[2]);
                        System.out.println(""+g[3]);
//                        if(!g[0].equals("")){
//                            for(int t = 0;t<arr.length;t++){
//                                arr[t] = " ";
//                            }
//                        }
                        //Guardian data insertion
//                        for(int t = 0;t<arr.length;t++)
//                                arr[t] = " ";
//                        }// Reset array for employees
//                        String[] Temp = Correct.getGuard();
                          //arr[1]="";
//                        arr[2]=Temp[1];
                        //write1.Write(arr,p++,rownum++);
                        
                        
                }	
    }
    
    public void SolveName(String Name){
        String[] arr = Seperate.WordSeperator(Name);
        for(String a : arr)
            System.out.println(""+a);
    }
    
}
