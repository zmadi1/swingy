package zakhele.swingy.control;
import zakhele.swingy.model.CreateConnection;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
 
//@interface MyAnnotation{
//	String str = "Sorry the database is not created yet";
//} 



public class ConsoleInput {
	
    public  int hp =12 ;
    public  int attack;
    
    @Valid
    @NotBlank(message = "Name cannot be blank")
    @NotNull(message = "Name cannot be null")
    @Size(min = 5, max = 16, message = "Name length should not be less than 2 or greater than 16")
	public String str="";
	
    @NotBlank(message = "Name cannot be blank")
    @NotNull(message = "Name cannot be null")
    @Size(min = 5, max = 16, message = "Name length should not be less than 2 or greater than 16")
    public   String hero;
    
    
    @NotBlank(message = "Name cannot be blank")
    @NotNull(message = "Name cannot be null")
    @Size(min = 5, max = 16, message = "Name length should not be less than 2 or greater than 16")
    public  String name;
    
	public String getStr() {
		return this.str;
	}
    

    public  ResultSet myRs;


    public   void consoleOutput() throws IOException, SQLException{
    	
		Scanner scanner;
		scanner = new Scanner(System.in);
//		String str;
		
        while (scanner.hasNext()){
        	
            str = scanner.nextLine();
            if (str.toLowerCase().equals("create-user")) {
                Username();
            } else if (str.toLowerCase().equals("load save")) {
            	loadUser();
            } else if (str.toLowerCase().equals("gui")) {
            	
            }else {
            	System.out.println("Invalid option");
            	
            }

        }
    }
    
    public   void Username() throws IOException, SQLException{
    	
    	CreateConnection conn = new CreateConnection();
 
    	
		String sql = "CREATE DATABASE IF NOT EXISTS HEROES";
		conn.connection(sql);
		conn.connect();
		
		
//		conn.createHeroTable();
		
//		System.out.println(str);
		

        Scanner scanner = new Scanner(System.in);
//        System.out.println(scanner.nextLine());
        System.out.print("Please enter your username: ");
        
        while (scanner.hasNext()){
        	
            str = scanner.nextLine();
           
          
         
            
      
            
            if(!str.isBlank()) {
            	if(str.length() >=2) {
            		
                    ResultSet myRs = conn.checkUser(str);
                    
                    
                    if(!myRs.next()) {
                    	
                    	conn.insertUser(str);
                    	conn.createHeroTable();
                    	System.out.println(str);
                    	character(str);
                    	conn.createUserTable();
                    	
                    	
                 
                    	
                    }else {
                    	System.out.println("it can't be null!");
                    	Username();
                    }
            		
            	}else {
            		System.out.println("The length should be greater or equal to 2");
            		
            	}
            	
            }else {
            	System.out.println("The username cannot be null;");
            	System.exit(1);
            }
            

        }
        conn.close();
    }
    
    
    public  void loadUser() throws IOException, SQLException{
    	
    	CreateConnection conn = new CreateConnection();
		
    	
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Please provide your username:");
        while (scanner.hasNext()){
        	
            str = scanner.nextLine();

            conn.connect();
            
            myRs = conn.checkUserHero(str);
            name = str;
            

            if(myRs.isBeforeFirst()) { 
            	int i = 1;


            	while(myRs.next()) {
            		System.out.println("["+i+".]"+myRs.getString("class"));
            		i++;
            		}
          
            	choose();
            }else {
            	System.out.println("Sorry the username of that name does not exist please try again!");
            	System.out.println();
            	System.out.println();
            	loadUser();
            	
            }

        }
        conn.close();
    }
            
    public   void choose() throws IOException, SQLException{
    	
        Scanner scanner = new Scanner(System.in);
        CreateConnection conn = new CreateConnection();
        ResultSet myRs ;
        
        
        System.out.print("To create a new Hero type new or choose your existing heroes type new: ");
        conn.connect();
    	System.out.println();
    	System.out.println();
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
                }else if(str.toLowerCase().equals("new")) {
                	System.out.println("Whats up man, you wanna fight????");
                	ExistingUsername(name);
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
                	System.out.println("Sorry the username of that name does not exist please try again!");
//                	choose();
                }
            	
            }

        }
        conn.close();
    }
    

    public void heroSetup(String name,String str) throws SQLException, IOException {
    	CreateConnection conn = new CreateConnection();
    	conn.connect();
    	Scanner scanner = new Scanner(System.in);
    	
    	ResultSet myRs = conn.UserStats(name, str);
    	
    	
    	int level = 1;
//    	int attack = 1;
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
    			
    		
    		
    		}else if(input.toLowerCase().equals("w"))
				map.west(str, Map.x);
    		else if(input.toLowerCase().equals("e"))
    			map.east(str, Map.x);
    		else if(input.toLowerCase().equals("s"))
    			map.south(str, Map.y);
    		else if(input.toLowerCase().equals("n"))
    			map.north(str, Map.y);
    		else {
    			System.out.println("Invalid Input ");
    		}
    		conn.close();
    		
    	}
    	System.out.println("Now that yout have selected your hero, you can type in start to start the game:");
    }
    

    
    public  void ExistingUsername(String name) throws IOException, SQLException{
    	
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
//         conn.close();
    }
    
    
    public void characterUpdate(String name) throws IOException, SQLException {
    	CreateConnection conn = new CreateConnection();
    	
        System.out.println("Select your Hero OPTIONS: 'Hunter' | 'moowalker' | 'night-crawler' | 'viper' ");
        int i=0;
        Scanner scanner = new Scanner(System.in);
        
        conn.connect();

        while(scanner.hasNext()){
            hero = scanner.nextLine();

            if (hero.toLowerCase().equals("hunter")){
               	 conn.insetIntoDataBase(name, "Hunter", 1, 1000, 10, 1, 0, 0, 0, 0);

               	heroSetup(name,str);
               	loadUser();

            }else if(hero.toLowerCase().equals("moonwalker")){
            	conn.insetIntoDataBase(name, "moonwalker", 1,1000, 10, 1, 0, 0, 0, 0);

            	loadUser();

            }else if(hero.toLowerCase().equals("night-crawler")){
            	conn.insetIntoDataBase(name, "night-crawler", 1, 1000, 10, 1, 0, 0, 0, 0);

            	loadUser();

            }else if(hero.toLowerCase().equals("viper")){
            	conn.insetIntoDataBase(name, "viper", 1, 1000, 10, 1, 0, 0, 0, 0);
         
            	loadUser();

            }else {
                System.out.println("Invalid input choose between the given option: ");
            }
        }
        conn.close();
    }

    public  void character(String name) throws IOException, SQLException {
    	CreateConnection conn = new CreateConnection();
    	
        System.out.println("Select your Hero OPTIONS: 'Hunter' | 'moowalker' | 'night-crawler' | 'viper' ");

        Scanner scanner = new Scanner(System.in);
        conn.connect();



        while(scanner.hasNext()){
            hero = scanner.nextLine();

            if (hero.toLowerCase().equals("hunter")){
               	 conn.insetIntoDataBase(name, "Hunter", 1, 1000, 10, 1, 0, 0, 0, 0);
               	 System.out.println("Start your game");
               	 heroSetup(name,"Hunter");

            }else if(hero.toLowerCase().equals("moonwalker")){
            	conn.insetIntoDataBase(name, "moonwalker", 1, 1000, 10, 1, 0, 0, 0, 0);
              	 System.out.println("Start your game");
              	 heroSetup(name,"moonwalker");
            }else if(hero.toLowerCase().equals("night-crawler")){
            	conn.insetIntoDataBase(name, "night-crawler", 1, 1000, 10, 1, 0, 0, 0, 0);
              	 System.out.println("Start your game");
              	 heroSetup(name,"night-crawler");
            }else if(hero.toLowerCase().equals("viper")){
            	conn.insetIntoDataBase(name, "viper", 1, 1000, 10, 1, 0, 0, 0, 0);
              	 System.out.println("Start your game");
              	 heroSetup(name,"viper");

            }else {
                System.out.println("Invalid input choose between the given option: ");
            }
        }
        conn.close();
    }
    
    
}

