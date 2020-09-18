package zakhele.swingy.control;

import zakhele.swingy.model.CreateConnection;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ConsoleInput {

    private  static String str;
    private static  String hero;
    private static String name;


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
            	loadUser();
            	
            } else if (str.toLowerCase().equals("gui")) {
            	
            }

        }
    }
    
    public  static void Username(String name) throws IOException, SQLException{
    	
    	CreateConnection conn = new CreateConnection();
 
    	
		String sql = "CREATE DATABASE IF NOT EXISTS HEROES";
		conn.connection(sql);
		conn.connect();
		
		conn.createUserTable();
//		conn.createHeroTable();
		

        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNext()){
        	
            str = scanner.nextLine();
            
            ResultSet myRs = conn.checkUser(str);
            
            
            if(!myRs.next()) {
            	
            	conn.insertUser(str);
            	conn.createHeroTable();
            	character(str);
         
            	
            }else {
            	System.out.println("The username aready exist!");
            }
        }
    }
    
    
    public  static void loadUser() throws IOException, SQLException{
    	
    	CreateConnection conn = new CreateConnection();
		
		
//		conn.createUserTable();
//		conn.createHeroTable();
		
    	
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNext()){
        	
            str = scanner.nextLine();

            conn.connect();
            ResultSet myRs = conn.checkUserHero(str);
            name = str;
            

            if(myRs.isBeforeFirst()) { 
            	int i = 1;


            	while(myRs.next()) {
            		System.out.println("["+i+".]"+myRs.getString("class"));
            		i++;
            		}
            	choose();
            }else {
            	System.out.println("Sorry the username of that name does not exist!");
            }

        }
    }
            
    public  static void choose() throws IOException, SQLException{
    	
        Scanner scanner = new Scanner(System.in);
        CreateConnection conn = new CreateConnection();
        ResultSet myRs ;
        
        
        System.out.print("To create a new Hero type new or choose your existing heroes type new: ");
        conn.connect();
        while (scanner.hasNext()){
        	
        	
            str = scanner.nextLine();
            myRs = conn.findHero(name, str);
            
            
            if (str.toLowerCase().equals("hunter")) {
                System.out.println("You have chosen the hunter these are your heroes stats");
                if(myRs.isBeforeFirst()) { 
                	int i = 1;


                	if(myRs.next()) {
                		System.out.println("["+i+".]"+
                	myRs.getString("class"));
                	System.out.println("level   "+myRs.getString("level"));
                	System.out.println("exp     "+myRs.getString("exp"));
                	System.out.println("hp      "+myRs.getString("hp"));
                	System.out.println("attack  "+myRs.getString("attack"));
                	System.out.println("defence "+myRs.getString("defence"));
                	System.out.println("weapon  "+myRs.getString("weapon"));
                	System.out.println("armor   "+myRs.getString("armor"));
                	System.out.println("helm    "+myRs.getString("helm"));
                		i++;
                		}
                	choose();
                }else {
                	System.out.println("Sorry the username of that name does not exist!");
                }

                
                
                System.out.println(name);

                //character();
            } else if (str.toLowerCase().equals("viper")) {
            	System.out.println("Please provide your username:");
            
            	
            } else if (str.toLowerCase().equals("new")) {
            	System.out.println("you are about to create a new hero");
            	ExistingUsername(name);
            	
            }

        }
    }
    
    
    public  static void ExistingUsername(String name) throws IOException, SQLException{
    	
    	CreateConnection conn = new CreateConnection();
 
    	
//		String sql = "CREATE DATABASE IF NOT EXISTS HEROES";
//		conn.connection(sql);
		
		conn.connect();
//		conn.createUserTable();
		conn.createHeroTable();
//		conn.insertUser(name);
         characterUpdate(name);
		

//        Scanner scanner = new Scanner(System.in);
        
//        while (scanner.hasNext()){
        	
//            str = scanner.nextLine();
            
           
//            }
    }
    
    
    public static void characterUpdate(String name) throws IOException, SQLException {
    	CreateConnection conn = new CreateConnection();
    	
        System.out.println("Select your Hero OPTIONS: 'Hunter' | 'moowalker' | 'night-crawler' | 'viper' ");

        Scanner scanner = new Scanner(System.in);
        conn.connect();


        while(scanner.hasNext()){
            hero = scanner.nextLine();

            if (hero.toLowerCase().equals("hunter")){
               	 conn.insetIntoDataBase(name, "Hunter", 1, 0, 0, 0, 0, 0, 0, 0);

            }else if(hero.toLowerCase().equals("moonwalker")){
            	conn.insetIntoDataBase(name, "moonwalker", 1, 0, 0, 0, 0, 0, 0, 0);

            }else if(hero.toLowerCase().equals("night-crawler")){
            	conn.insetIntoDataBase(name, "night-crawler", 1, 0, 0, 0, 0, 0, 0, 0);

            }else if(hero.toLowerCase().equals("viper")){
            	conn.insetIntoDataBase(name, "viper", 1, 0, 0, 0, 0, 0, 0, 0);

            }else {
                System.out.println("Invalid input choose between the given option: ");
            }
        }
    }

    public static void character(String name) throws IOException, SQLException {
    	CreateConnection conn = new CreateConnection();
    	
        System.out.println("Select your Hero OPTIONS: 'Hunter' | 'moowalker' | 'night-crawler' | 'viper' ");

        Scanner scanner = new Scanner(System.in);
        conn.connect();



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

