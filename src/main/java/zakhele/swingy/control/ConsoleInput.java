package zakhele.swingy.control;
import zakhele.swingy.model.CreateConnection;

import static org.junit.Assert.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class ConsoleInput {
	
    public static int hp ;
    
//    @NotEmpty(message="This can never be empty.")
//	@NotNull(message="Sorry the username cant be null")
	@NotBlank(message ="Please enter the correct username---------------------------------------------")
	@Size(min=2, message="You should have atleast two characters")
	public static String str;
	
    private static  String hero;
    

    private static String name;


    public  static void consoleOutput() throws IOException, SQLException{
    	
//    	@NotEmpty(message="This can never be empty.")
		Scanner scanner;
		scanner = new Scanner(System.in);
//        while (scanner.hasNext()){
        	
            str = scanner.nextLine();
//            System.out.println(str.getClass().getName());
            
            if (str.toLowerCase().equals("create-user")) {
                System.out.println("Please enter your username: ");
                Username(str);

                //character();
            } else if (str.toLowerCase().equals("load save")) {
            	System.out.println("Please provide your username:");
            	loadUser();
            	
            } else if (str.toLowerCase().equals("gui")) {
            	
            }

//        }
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
        conn.close();
    }
    
    
    public  static void loadUser() throws IOException, SQLException{
    	
    	CreateConnection conn = new CreateConnection();
		
    	
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
        conn.close();
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
                	}
                heroSetup(name,str);
                }else if(str.toLowerCase().equals("viper")) {
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
                         }
                         heroSetup(name,str);
                    }else if(str.toLowerCase().equals("moonwalker")) {
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
                            }
                           heroSetup(name,str);
                 	}else if(str.toLowerCase().equals("night-crawler")) {
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
                        	heroSetup(name,str);
                }else {
                	System.out.println("Sorry the username of that name does not exist!");
                }

                
                
//                System.out.println(name);
                heroSetup(name,str);

                //character();
//            } else if (str.toLowerCase().equals("viper")) {
//            	System.out.println("Please provide your username:");
            
            	
//            } else if (str.toLowerCase().equals("new")) {
//            	System.out.println("you are about to create a new hero");
            	ExistingUsername(name);
            	
            }

        }
        conn.close();
    }
    

    public static void heroSetup(String name,String str) throws SQLException, IOException {
    	CreateConnection conn = new CreateConnection();
    	conn.connect();
    	Scanner scanner = new Scanner(System.in);
    	
    	ResultSet myRs = conn.UserStats(name, str);
    	
    	int hp = 1;
    	int level = 1;
    	int attack = 1;
    	int weapon = 1;
    	int armor = 1;
    	int helm = 1;
    	int defence = 1;
    	int exp = 1;
    	
    	if(myRs.next()) {
    		
    		hp = myRs.getInt("hp");
    		level= myRs.getInt("level");
    		attack =  myRs.getInt("attack");
    		weapon =  myRs.getInt("weapon");
    		armor =  myRs.getInt("armor");
    		helm =  myRs.getInt("helm");
    		defence = myRs.getInt("defence");
    		exp = myRs.getInt("exp");
    	}
    	System.out.println();
    	System.out.println();
    	Map map = new Map(level,exp,hp,attack,defence ,weapon,armor,helm);
    	System.out.println("Please type START to start the game");
    	while(scanner.hasNext()) {
    		String input = scanner.nextLine();
    		
    		if(input.toLowerCase().equals("start")) {
    			System.out.println("WELCOME TO SWIGNY THIS ARE YOUR MOVEMENTS");
    			System.out.println("S - is for moving SOUTHWARDS");
    			System.out.println("N - is for moving NORTH");
    			System.out.println("W - is for moving WEST");
    			System.out.println("E - is for moving EAST");
    	    	System.out.println();
    	    	System.out.println();

    	    	
    			map.map(name,str,Map.x,Map.y);
    			
    		
    		
    		}
    		if(input.toLowerCase().equals("w"))
				map.west(str, Map.x);
    		else if(input.toLowerCase().equals("e"))
    			map.east(str, Map.x);
    		else if(input.toLowerCase().equals("s"))
    			map.south(str, Map.y);
    		else if(input.toLowerCase().equals("n"))
    			map.north(str, Map.y);
    		conn.close();
    		
    	}
    	System.out.println("Now that yout have selected your hero, you can type in start to start the game:");
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
         conn.close();
    }
    
    
    public static void characterUpdate(String name) throws IOException, SQLException {
    	CreateConnection conn = new CreateConnection();
    	
        System.out.println("Select your Hero OPTIONS: 'Hunter' | 'moowalker' | 'night-crawler' | 'viper' ");

        Scanner scanner = new Scanner(System.in);
        conn.connect();


        while(scanner.hasNext()){
            hero = scanner.nextLine();

            if (hero.toLowerCase().equals("hunter")){
               	 conn.insetIntoDataBase(name, "Hunter", 1, 1000, 10, 0, 0, 0, 0, 0);

            }else if(hero.toLowerCase().equals("moonwalker")){
            	conn.insetIntoDataBase(name, "moonwalker", 1,1000, 10, 0, 0, 0, 0, 0);

            }else if(hero.toLowerCase().equals("night-crawler")){
            	conn.insetIntoDataBase(name, "night-crawler", 1, 1000, 10, 0, 0, 0, 0, 0);

            }else if(hero.toLowerCase().equals("viper")){
            	conn.insetIntoDataBase(name, "viper", 1, 1000, 10, 0, 0, 0, 0, 0);

            }else {
                System.out.println("Invalid input choose between the given option: ");
            }
        }
        conn.close();
    }

    public static void character(String name) throws IOException, SQLException {
    	CreateConnection conn = new CreateConnection();
    	
        System.out.println("Select your Hero OPTIONS: 'Hunter' | 'moowalker' | 'night-crawler' | 'viper' ");

        Scanner scanner = new Scanner(System.in);
        conn.connect();



        while(scanner.hasNext()){
            hero = scanner.nextLine();

            if (hero.toLowerCase().equals("hunter")){
               	 conn.insetIntoDataBase(str, "Hunter", 1, 1000, 10, 0, 0, 0, 0, 0);
               	 System.out.println("Start your game");
               	 heroSetup(str,"Hunter");

            }else if(hero.toLowerCase().equals("moonwalker")){
            	conn.insetIntoDataBase(str, "moonwalker", 1, 1000, 10, 0, 0, 0, 0, 0);
              	 System.out.println("Start your game");
              	 heroSetup(str,"moonwalker");
            }else if(hero.toLowerCase().equals("night-crawler")){
            	conn.insetIntoDataBase(str, "night-crawler", 1, 1000, 10, 0, 0, 0, 0, 0);
              	 System.out.println("Start your game");
              	 heroSetup(str,"night-crawler");
            }else if(hero.toLowerCase().equals("viper")){
            	conn.insetIntoDataBase(str, "viper", 1, 1000, 10, 0, 0, 0, 0, 0);
              	 System.out.println("Start your game");
              	 heroSetup(str,"viper");

            }else {
                System.out.println("Invalid input choose between the given option: ");
            }
        }
        conn.close();
    }
    
    
}

