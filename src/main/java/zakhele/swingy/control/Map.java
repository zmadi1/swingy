package zakhele.swingy.control;

import java.io.IOException;
import java.lang.Math;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import zakhele.swingy.model.*;
import java.util.*;

public class Map {
	
	private static Random rand = new Random();
	
	private String name1;
	private String str1;
	private int level;
	private int number=1;
	VillanCreation villanCreation = new VillanCreation();

	
	private int exp;
//	private int hp;
//	private int attack;
//	private int defence;
//	private int weapon;
//	private int armor;
//	private int helm;
//	int j=1;
//	int k=1;
	public static int y=0;
	public static int x=0;
	
	
	
	Map(int level,int exp,int hp,int attack,int defence ,int weapon, int armor, int helm){
		this.level = level;
		this.exp = exp;
//		this.hp = hp;
//		this.attack =attack ;
//		this.defence = defence;
//		this.weapon = weapon;
//		this.armor = armor;
//		this.helm = helm;
		
	}
//	int rand1 = 2;
//	int rand2 = 2;
	int i = 0;
	int j=0;
	VillanCreation villan = new VillanCreation();
	
	public  void map(String name,String str,int x,int y) throws IOException, SQLException {
		
		
//		sSystem.out.println(str+""+name);

		Scanner start = new Scanner(System.in);
		String startLoop;
		name1 = name;
		str1 = str;		
    	int dimension = (level-1)*5+10-(level % 2);
    	int rand1 = 3;
		int rand2 = 1;
		int rand5 = rand.nextInt(dimension-1);
		int rand6 = rand.nextInt(dimension-1);
		int rand7 = rand.nextInt(dimension-1);
		int rand8 = rand.nextInt(dimension-1);
		
    	int rand3 = rand.nextInt(dimension-1);
		int rand4 = rand.nextInt(dimension-1);
    	String map[][] = new String[dimension][dimension];

    	
    	for(int row=0;row < dimension; ++row) {
    		for(int col= 0; col < dimension;++col) {

    			map[row][col] = "*";
    			if((row == rand1 && col == rand2) || (row ==rand5 && col == rand6) || (row ==rand7 && col == rand8)) {
    				map[rand1][rand2]= "P";
    				map[rand5][rand6]= "H";
    				map[rand7][rand8]= "M";
    			}
    			
    			if(row == rand3 && col == rand4)
    				map[rand3][rand4]= "W";
    			
    			if(row == (dimension/2)+y && col ==(dimension/2)+x) {
    				map[row][col] = "@";
    				
    				i = col;
    				j = row;
    			}
    			
    			
    			System.out.print(map[row][col] + "   ");

    			}
    		
    		System.out.println();
    		
    		}
		if(j == (dimension/2)+y && i ==(dimension/2)+x) {
			if(rand1==j && rand2 == i || rand3 == j && rand4 == i) {
				villan.VillanCreation1(villanCreation.str1,name,str);	
			}
			if(rand5 == j && rand6 == i)
				villan.VillanCreation(villanCreation.str1,name,str);
			
			if(j ==rand7 && i == rand8)
				villan.VillanCreation1(villanCreation.str1,name,str);
		}
//		System.out.println("Hello on the other side");
    	}
		
	
	public void south(String str,int move) throws IOException, SQLException {
		++y;
		

//		if(rand1==y && rand2 == x) {
//			villan.VillanCreation();
//				
//		}
		
		
		map(name1,str,x,y);
		CreateConnection conn = new CreateConnection();
		int dimension = (level-1)*5+10-(level % 2);
		
//		System.out.println((y)+" "+(x));
//		System.out.println(rand1+" "+rand2);
		
		if(x >= (dimension/2) || y >= (dimension/2)) {
			y=0;
			x=0;
			conn.connect();

			if(number <= level) {
				number = level;
				++number;
	
				conn.updateLevel(number,name1,str1);
				int numb = (level-1)*450;
				
				System.out.println(name1);
				System.out.println(str1);
				int exp = (int) (level*1000+ Math.pow(numb, 2));
				conn.updateExp(exp,name1,str1);
				
			}
			conn.connect();
			ResultSet myRs = conn.findHero(name1, str1);
			if(myRs.isBeforeFirst())
				if(myRs.next())
					level = myRs.getInt("level");
			dimension = (level-1)*5+10-(level % 2);
			exp = level*1000+(level-1)*2 *450;
			conn.updateExp(exp,name1,str1);
			conn.close();
			System.out.println();
			System.out.println("Congratulation you have move to level: "+number);

			map(name1,str,x,y);
			}
	}
	public void north(String str,int move) throws IOException, SQLException {
		--y;
		map(name1,str,x,y);
		CreateConnection conn = new CreateConnection();
		int dimension = (level-1)*5+10-(level % 2);
		if(x >= (dimension/2) || -(y) >= (dimension/2)) {
			y=0;
			x=0;
			conn.connect();

			if(number <= level) {
				number = level;
				++number;
	
				conn.updateLevel(number,name1,str1);
			}
			conn.connect();
			
			ResultSet myRs = conn.findHero(name1, str1);
			
			
			if(myRs.isBeforeFirst())
				if(myRs.next())
					level = myRs.getInt("level");
			exp = level*1000+(level-1)*2 *450;
			conn.updateExp(exp,name1,str1);
			conn.close();
			dimension = (level-1)*5+10-(level % 2);
			System.out.println();
			System.out.println("Congratulation you have move to level: "+number);

			map(name1,str,x,y);
			}
	}
	public void east(String str,int move) throws IOException, SQLException {
		x++;
		map(name1,str,x,y);
		
		CreateConnection conn = new CreateConnection();
		int dimension = (level-1)*5+10-(level % 2);
		if(x >= (dimension/2) || y >= (dimension/2)) {
			y=0;
			x=0;
			conn.connect();

			if(number <= level) {
				number = level;
				++number;
	
				conn.updateLevel(number,name1,str1);
			}
			conn.connect();
			ResultSet myRs = conn.findHero(name1, str1);
			if(myRs.isBeforeFirst())
				if(myRs.next())
					level = myRs.getInt("level");
			exp = level*1000+(level-1)*2 *450;
			conn.updateExp(exp,name1,str1);
			conn.close();
			dimension = (level-1)*5+10-(level % 2);
			System.out.println();
			System.out.println("Congratulation you have move to level: "+number);

			map(name1,str,x,y);
			}
	}
	
	public void west(String str,int move) throws IOException, SQLException {
		System.out.println("This is west");
		--x;
		map(name1,str,x,y);
		
		CreateConnection conn = new CreateConnection();
		int dimension = (level-1)*5+10-(level % 2);
		if((-x) >= (dimension/2) || y >= (dimension/2)) {
			y=0;
			x=0;
			conn.connect();

			if(number <= level) {
				number = level;
				++number;
	
				conn.updateLevel(number,name1,str1);
			}
			conn.connect();
			ResultSet myRs = conn.findHero(name1, str1);
			if(myRs.isBeforeFirst())
				if(myRs.next())
					level = myRs.getInt("level");
			exp = level*1000+(level-1)*2 *450;
			conn.updateExp(exp,name1,str1);
			conn.close();
			dimension = (level-1)*5+10-(level % 2);
			System.out.println();
			System.out.println("Congratulation you have move to level: "+number);

			map(name1,str,x,y);
			}
		}
	}
    