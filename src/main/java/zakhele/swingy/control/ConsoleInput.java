package zakhele.swingy.control;

import zakhele.swingy.model.CreateConnection;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ConsoleInput {

    private  static String str;
    private static  String hero;


    public  static void consoleOutput() throws IOException, SQLException{
    	

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
        	
            str = scanner.nextLine();
            
            if (str.toLowerCase().equals("create-user")) {
                System.out.println("Please enter your username: ");
                Username(str);

                //character();
            } else if (str.toLowerCase().equals("load save")) {
            	System.out.println("Please provide your username:");
            	loadUser(str);
            	
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
		

        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNext()){
        	
            str = scanner.nextLine();
            
            ResultSet myRs = conn.checkUser(str);
            
            
            if(!myRs.next()) {
            	conn.insertUser(str);
            	character();
         
            	
            }else {
            	System.out.println("The username aready exist!");
            }
        }
    }
    
    
    public  static void loadUser(String name) throws IOException, SQLException{
    	
    	CreateConnection conn = new CreateConnection();
		
		
//		conn.createUserTable();
//		conn.createHeroTable();
		

        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNext()){
        	
            str = scanner.nextLine();
//            System.out.println(str);
            conn.connect();
            ResultSet myRs = conn.checkUserHero(str);
            
//            System.out.println(myRs.getRow());
            if(myRs.next()) { 
            	int i = 1;
//            	myRs.beforeFirst();
//            	System.out.println(myRs.getString(1));
            	System.out.println("These are your exsisting heroes :");

//            	while(myRs.next()) {
            		System.out.println("["+i+".]"+myRs.getString("class"));
//            		i++;
//            		}
            	choose();
            }else {
            	System.out.println("Sorry the username of that name does not exist!");
            }
//            choose();
        }
    }
            
    public  static void choose() throws IOException, SQLException{
    	
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("To create a new Hero type new or choose your existing heroes type new: ");
        
        while (scanner.hasNext()){
        	
            str = scanner.nextLine();
            
            if (str.toLowerCase().equals("Hunter")) {
                System.out.println("You have chosen the hunter");

                //character();
            } else if (str.toLowerCase().equals("viper")) {
            	System.out.println("Please provide your username:");
            
            	
            } else if (str.toLowerCase().equals("new")) {
            	System.out.println("you are about to create a new hero");
            	
            }

        }
    }

    public static void character() throws IOException, SQLException {
    	CreateConnection conn = new CreateConnection();
    	
        System.out.println("Select your Hero OPTIONS: 'Hunter' | 'moowalker' | 'night-crawler' | 'viper' ");

        Scanner scanner = new Scanner(System.in);



        while(scanner.hasNext()){
            hero = scanner.nextLine();

            if (hero.toLowerCase().equals("hunter")){
               	 conn.insetIntoDataBase(str, "Hunter", 1, 0, 0, 0, 0, 0, 0, 0);

            }else if(hero.toLowerCase().equals("moonwalker")){
            	conn.insetIntoDataBase(str, "moonwalker", 1, 0, 0, 0, 0, 0, 0, 0);

            }else if(hero.toLowerCase().equals("night-crawler")){
            	conn.insetIntoDataBase(str, "night-crawler", 1, 0, 0, 0, 0, 0, 0, 0);

            }else if(hero.toLowerCase().equals("viper")){
            	conn.insetIntoDataBase(str, "viper", 1, 0, 0, 0, 0, 0, 0, 0);

            }else {
                System.out.println("Invalid input choose between the given option: ");
            }
        }
    }
}

