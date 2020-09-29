package zakhele.swingy.model;

import java.sql.Connection;
import zakhele.swingy.control.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.sql.*;

public class VillanCreation {
	
	public static void VillanCreation() {
		ConsoleInput cons = new ConsoleInput();
		int playerHp= ConsoleInput.hp;
		
		String name = "Wu-Tang";
		int level = 1;
		int hp = 2900;
		Random rand = new Random();
		
		int attack = rand.nextInt(4);
		playerHp = playerHp - attack;
		
		System.out.println(playerHp);
		
		
			
		
		
	}
}
