/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package migration;

/**
 *
 * @author ejkpa
 */
public class Migration {

    /**
     * @param args the command line arguments
     */
    
    public static void mainm(String[] args) {
        // TODO code application logic here
        DatabaseSearch obj = new DatabaseSearch();
        System.out.println(obj.getPostalCode("Matale"));
        System.out.println(obj.getDistric());
        System.out.println(obj.getPro());
    }
    
}
