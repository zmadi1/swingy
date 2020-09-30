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
	
	
	public static void VillanCreation() throws IOException, SQLException {
		
		Scanner scanner = new Scanner(System.in);
		String str ;
		CreateConnection conn = new CreateConnection();
		conn.connect();
		
		
		int playerHp = ConsoleInput.hp;
		int villanHp = 20;
		
		String name = "Wu-Tang";
//		int level = 1;
//		int hp = 2900;
		Random rand = new Random();
		
		
		int attack = rand.nextInt(8);
		int playerAttack = rand.nextInt(50);
//		playerHp = playerHp - attack;
		
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
						conn.updateUserHP(10,ConsoleInput.name, ConsoleInput.str);
						System.exit(1);
						work=false;
						break;
					}
					if(villanHp <= 0) {
						System.out.println("Congratulation you have killed the "+name);
						++attacknum;
						System.out.println(attacknum);
						if(attacknum <= ConsoleInput.attack)
						{
							attacknum  = ConsoleInput.attack;
							conn.updateAttack(attacknum, ConsoleInput.name, ConsoleInput.str);
						}else
						{
							conn.updateAttack(attacknum, ConsoleInput.name, ConsoleInput.str);
						}
						
						conn.updateUserHP(playerHp,ConsoleInput.name, ConsoleInput.str);
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
			}if(str.toLowerCase().equals("run")) {
				
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
				
				
			}
				
		}
		
		
	}
}
