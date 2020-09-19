package zakhele.swingy.control;

import java.util.Scanner;

public class Map {
	
	private int level;
	private int exp;
	private int hp;
	private int attack;
	private int defence;
	private int weapon;
	private int armor;
	private int helm;
	
	
	Map(int level,int exp,int hp,int attack,int defence ,int weapon, int armor, int helm){
		this.level = level;
		this.exp = exp;
		this.hp = hp;
		this.attack =attack ;
		this.defence = defence;
		this.weapon = weapon;
		this.armor = armor;
		this.helm = helm;
		
	}
	
	public void map() {
    	int position = (level-1)*5+10-(level % 2);
    	
    	int map[][] = new int[position][position];
    	
    	int t,i;
    	
    	for(t=0;t < position;++t) {
    		for(i = 0; i < position;++i) {
    			map[t][i] = 1;
    			if(i == t)
    				map[position/2][position/2] = 8;
    			System.out.print(map[t][i] + "   ");
    		}
    		System.out.println();
    	}
    	
		
	}

	
	
    public void south() {
    	
    	int position = (level-1)*5+10-(level % 2);
    	
    	int k = 1;
    	Scanner scanner = new Scanner(System.in);
    	String str;
    	int map[][] = new int[position][position];
    	
    	int t,i;
    	
    	
//    	System.out.println(position);
    	while(scanner.hasNext()) {
    		str = scanner.nextLine();
    		
    		if(str.toLowerCase().equals("s")) {
    			System.out.println("You have moved one unit south");

    	    	for(t=0;t < position;++t) {
    	    		for(i = 0; i < position;++i) {
    	    			map[t][i] = 1;
    	    			if(t ==(position/2)-k && i == position/2 ){
    	    				map[t][i] = 8;
    	    				k++;
    	    			}
    	    			System.out.print(map[t][i] + "   ");
    	    		}
    	    		System.out.println();
    	    	}
    			
    		}else if(str.toLowerCase().equals("n")) {
    			System.out.println("You have moved one unit north");
    			
        	    	for(t=0;t < position;++t) {
        	    		for(i = 0; i < position;++i) {
        	    			map[t][i] = 1;
        	    			if(t ==(position/2)+k && i == position/2 ){
        	    				map[t][i] = 8;
        	    				k++;
        	    			}
        	    			System.out.print(map[t][i] + "   ");
        	    		}
        	    		System.out.println();
        	    		}
        	    	}
    		}
    	}
    }
