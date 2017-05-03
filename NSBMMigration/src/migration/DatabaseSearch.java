/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package migration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ejkpa
 */

public class DatabaseSearch {
    Connection con;
    private String D = " ";
    public void InitConnection(){
        
        con = null;
        try {
            Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:AddressResolve.db");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
    int x=0;
    public String getPostalCode(String city){
        
  
      String CODE = "";
      String CITY = "";
      city = city.toUpperCase();
      try{
      Statement stmt = con.createStatement();
      String query = "SELECT * FROM postal_codes where PlaceName  LIKE \"";
      query = query + city;
      query = query + "\";";
      ResultSet rs = stmt.executeQuery(query);
      while ( rs.next() ) {
         CODE = rs.getString("PostalCodes");
         CITY = rs.getString("PlaceName");
         D = rs.getString("State");
//         System.out.print( "Code = " + CODE );
//         System.out.println( "NAME = " + CITY );
//         System.out.println();
         CITY = CITY.toUpperCase();
         if(CITY.equals(city))
             break;
         
    }
         //System.out.print( "Code = " + CODE );

      }
      catch(Exception e){
          System.out.println(""+e.toString());
      }
      return CODE;
    }
    
    public String getProvince(String city){
      //System.out.println("asdasdadaddsddsadasdsadadadadaddsad");
      String PROVINCE = "";
      String CITY = "";
      city = city.toUpperCase();
      try{
      Statement stmt = con.createStatement();
      String query = "SELECT * FROM towns where NameofTown  LIKE \"";
      query = query + city;
      query = query + "\";";
      ResultSet rs = stmt.executeQuery(query);
      while ( rs.next() ) {
         PROVINCE = rs.getString("Province");
         CITY = rs.getString("NameofTown");
         System.out.print( "Code = " + PROVINCE);
//       System.out.println( "NAME = " + CITY );
//       System.out.println();
         CITY = CITY.toUpperCase();
         if(CITY.equals(city)){
             break;
//             if(rs.next()){
//                PROVINCE = rs.getString("Province");
//                CITY = rs.getString("NameofTown");
//             }

         }
    }
         //System.out.print( "Province = " + PROVINCE );
         //System.out.println( " NAME = " + CITY );

      }
      catch(Exception e){
          System.out.println(""+e.toString());
      }
      return PROVINCE;
    }
    
    public String getDistric(){
  
        for(Districts d : Districts.values()){
            if(d.name().equals(D))
                return d.getDis();
                //System.out.println("District : "+d.getDis());
        }
        return " ";
    }
    
    public String getPro(){
  
        for(Districts d : Districts.values()){
            if(d.name().equals(D))
                return d.getProv();
                //System.out.println("District : "+d.getDis());
        }
        return " ";
    }


    public DatabaseSearch() {
        InitConnection();
    }
    
    
}
