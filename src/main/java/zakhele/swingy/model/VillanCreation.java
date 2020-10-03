package zakhele.swingy.model;

import zakhele.swingy.control.*;

import java.util.Random;
import java.util.Scanner;
import java.io.IOException;
import java.sql.*;

public class VillanCreation {
	public static int attacknum =1;
	
	public VillanCreation() {
		
	}
	
	public String str= "Wu-Tang";
	public String str1 = "Pop-Smoke";
	public String str2 = "Meet-The-Woo";
	
	
public  void villanCreation(String name,String vname,String str1) throws IOException, SQLException {
		
		Scanner scanner = new Scanner(System.in);

		CreateConnection conn = new CreateConnection();
		conn.connect();
		ConsoleInput consoleInput = new ConsoleInput();
		ResultSet myRs = conn.UserStats(vname,str1);
		
		int hp=0 ;
		int attack1 = 0;
		
		if(myRs.next()) {
			hp = myRs.getInt("hp");
			attack1 = myRs.getInt("attack");

		}

		
		
		int playerHp = hp;
		
		int villanHp = 2;

		Random rand = new Random();
		
		
		int attack = 1;
		int playerAttack = 1 + rand.nextInt(attack1);

		
		System.out.println("You have came across a  "+name+" with "+villanHp+" HP do you want to fight or run");
		
		if(scanner.hasNext()) {
			str = scanner.nextLine();
			boolean work = true;
			if(str.toLowerCase().equals("fight")) {
				while(work) {
					playerHp = playerHp - attack;
					villanHp = villanHp - playerAttack;
					System.out.println("The "+name+"  attacked you and gave you "+ attack +" damage");
					System.out.println("Your HP level now is   "+playerHp);
					
					System.out.println();
					System.out.println();
					
					System.out.println("You attacked the "+name+" and you gave it "+playerAttack+ " damage");
					System.out.println("The "+name+" HP level now is "+villanHp);
					System.out.println();
					System.out.println();
					
					if(playerHp <= 0) {
						

						
						System.out.println("GAME OVER the  - "+name+" has killed you");
						conn.updateUserHP(10,vname, str1);
						System.exit(1);
						work=false;
					}
					if(villanHp <= 0) {
						System.out.println("Congratulation you have killed the "+name);
						attacknum = attack1;
						++attacknum;
//						System.out.println(attacknum);
//						System.out.println(vname);
	
						if(attacknum >= attack1)
						{
//							
							conn.updateAttack(attacknum,vname,str1);
						}
						
						conn.updateUserHP(playerHp,vname, str1);
						System.out.println();
						System.out.println();
		    			System.out.println("THESE ARE YOUR MOVEMENTS");
		    			System.out.println("S - is for moving SOUTHWARDS");
		    			System.out.println("N - is for moving NORTH");
		    			System.out.println("W - is for moving WEST");
		    			System.out.println("E - is for moving EAST");
		    	    	System.out.println();
		    	    	System.out.println();
		    	    	work=false;
						break;
					}
				}
			}else if(str.toLowerCase().equals("run")) {
				
				System.out.println();
				System.out.println();
    			System.out.println("THESE ARE YOUR MOVEMENTS");
    			System.out.println("S - is for moving SOUTHWARDS");
    			System.out.println("N - is for moving NORTH");
    			System.out.println("W - is for moving WEST");
    			System.out.println("E - is for moving EAST");
    	    	System.out.println();
    	    	System.out.println();
//    	    	break;
				
				
			}else {
				System.out.println("Invalid input only run or fight is allowed");
    	    	System.out.println();
    	    	System.out.println();
				villanCreation(str,vname,str1) ;
			}
				
		}
		
		
	}
	
public  void VillanCreation1(String name,String vname,String str1) throws IOException, SQLException {
		
		Scanner scanner = new Scanner(System.in);

		CreateConnection conn = new CreateConnection();
		conn.connect();
		ConsoleInput consoleInput = new ConsoleInput();
		ResultSet myRs = conn.UserStats(vname,str1);
		
		int hp=0 ;
		int attack1 = 0;
		
		if(myRs.next()) {
			hp = myRs.getInt("hp");
			attack1 = myRs.getInt("attack");

		}

		
		
		int playerHp = hp;
		
		int villanHp = 2;

		Random rand = new Random();
		
		
		int attack = 1;
		int playerAttack = 1 + rand.nextInt(attack1);

		
		System.out.println("You have came across a  "+name+" with "+villanHp+" HP do you want to fight or run");
		
		if(scanner.hasNext()) {
			str = scanner.nextLine();
			boolean work = true;
			if(str.toLowerCase().equals("fight")) {
				while(work) {
					playerHp = playerHp - attack;
					villanHp = villanHp - playerAttack;
					System.out.println("The "+name+"  attacked you and gave you "+ attack +" damage");
					System.out.println("Your HP level now is   "+playerHp);
					
					System.out.println();
					System.out.println();
					
					System.out.println("You attacked the "+name+" and you gave it "+playerAttack+ " damage");
					System.out.println("The "+name+" HP level now is "+villanHp);
					System.out.println();
					System.out.println();
					
					if(playerHp <= 0) {
						

						
						System.out.println("GAME OVER the  - "+name+" has killed you");
						conn.updateUserHP(10,vname, str1);
						System.exit(1);
						work=false;
					}
					if(villanHp <= 0) {
						System.out.println("Congratulation you have killed the "+name);
						attacknum = attack1;
						++attacknum;
//						System.out.println(attacknum);
//						System.out.println(vname);
	
						if(attacknum >= attack1)
						{
//							
							conn.updateAttack(attacknum,vname,str1);
						}
						
						conn.updateUserHP(playerHp,vname, str1);
						System.out.println();
						System.out.println();
		    			System.out.println("THESE ARE YOUR MOVEMENTS");
		    			System.out.println("S - is for moving SOUTHWARDS");
		    			System.out.println("N - is for moving NORTH");
		    			System.out.println("W - is for moving WEST");
		    			System.out.println("E - is for moving EAST");
		    	    	System.out.println();
		    	    	System.out.println();
		    	    	work=false;
						break;
					}
				}
			}else if(str.toLowerCase().equals("run")) {
				
				System.out.println();
				System.out.println();
    			System.out.println("THESE ARE YOUR MOVEMENTS");
    			System.out.println("S - is for moving SOUTHWARDS");
    			System.out.println("N - is for moving NORTH");
    			System.out.println("W - is for moving WEST");
    			System.out.println("E - is for moving EAST");
    	    	System.out.println();
    	    	System.out.println();
//    	    	break;
				
				
			}else {
				System.out.println("Invalid input only run or fight is allowed");
    	    	System.out.println();
    	    	System.out.println();
    	    	villanCreation(str,vname,str1);
			}
				
		}
		
		
	}
}
