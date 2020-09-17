package zakhele.swingy.control;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import zakhele.swingy.model.*;;

public class ConsoleInput {

    private  static String str;


    public  static void consoleOutput() throws IOException, SQLException{
    	

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
        	
            str = scanner.nextLine();
            
            if (str.toLowerCase().equals("create")) {
                System.out.println("Please enter your username: ");
                Username(str);

                //character();
            } else if (str.toLowerCase().equals("load save")) {
            	
            } else if (str.toLowerCase().equals("gui")) {
            	
            }

        }
    }
    
    public  static void Username(String name) throws IOException, SQLException{
    	
    	CreateConnection conn = new CreateConnection();
    	
		String sql = "CREATE DATABASE IF NOT EXISTS HEROES";
		conn.connection(sql);
		
		
		conn.createUserTable();
		conn.createHeroTable();
		
		
//		boolean user = conn.checkUser("zakhele");

        Scanner scanner = new Scanner(System.in);
        
//        String next = null;
        
        while (scanner.hasNext()){
        	
            str = scanner.nextLine();
            
            ResultSet myRs = conn.checkUser(str);
            
            
            if(!myRs.next()) {
            	conn.insertUser(str);
            	conn.insetIntoDataBase(str, "viper", 1, 0, 0, 0, 0, 0, 0, 0);
            	
            }else {
            	System.out.println("The username aready exist!");
            }
        }
            
        
            
       
        		
//        	if(str.equals(myRs)) {
//            if(myRs.next()) {
//            	System.out.println("Hello------");
//            	System.out.println(myRs.getString(1));
//            	System.out.println("World-----");
//            	next = myRs.getString(1);
//            	if( myRs.getString(1) == null) {
//            		System.out.println("we're here!");
//            	conn.insertUser(str);
//            	conn.insetIntoDataBase(str, "viper", 1, 0, 0, 0, 0, 0, 0, 0);
//            	}else{
//            		System.out.println("Sorry the username is taken!");
            		
//            		}
//            	}
            }
            
        

    public static void character(){
    	
        System.out.println("Select your Hero OPTIONS: 'Hunter' | 'moowalker' | 'night-crawler' | 'viper' ");

        Scanner scanner = new Scanner(System.in);
        String str;


        while(scanner.hasNext()){
            str = scanner.nextLine();

            if (str.toLowerCase().equals("hunter")){
           

            }else if(str.toLowerCase().equals("moonwalker")){

            }else if(str.toLowerCase().equals("night-crawler")){

            }else if(str.toLowerCase().equals("viper")){

            }else {
                System.out.println("Invalid input choose between the given option");
            }
        }
    }
}

