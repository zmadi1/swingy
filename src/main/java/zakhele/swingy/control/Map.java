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
		
		Scanner start = new Scanner(System.in);
		String startLoop;
		
    	int position = (level-1)*5+10-(level % 2);
    	
    	String map[][] = new String[position][position];
    	
    	int t,i;
    	
    	for(t=0;t < position;++t) {
    		for(i = 0; i < position;++i) {
    			map[t][i] = "*";
    			if(i == t)
    				map[position/2][position/2] = "@";
    			System.out.print(map[t][i] + "   ");
    		}
    		System.out.println();
    	}
//    	while(start.hasNext()) {
    	
    		startLoop = start.nextLine();
    		
    		if(startLoop.toLowerCase().equals("n")) {
    			System.out.println("You are about to move one unit north");
    			north();
    		}else if(startLoop.toLowerCase().equals("e")){
    			east();
    		}else if (startLoop.toLowerCase().equals("s")) {
    			south("s");
    		}else if (startLoop.toLowerCase().equals("w")) {
    			west();
    			
    		}else {
    			System.out.println("invalid input , you can ony move using: ");
    			System.out.println();
    			System.out.println("S - is for moving SOUTHWARDS");
    			System.out.println("N - is for moving NORTH");
    			System.out.println("W - is for moving WEST");
    			System.out.println("E - is for moving EAST");
    	    	System.out.println();
    		}
    			
    		
//    	}
		
	}
	
	public void east() {
    	int position = (level-1)*5+10-(level % 2);
    	
    	int k = 1;
    	int l = 1;
    	int j= 0;
    	Scanner scanner = new Scanner(System.in);
    	String str;
    	String map[][] = new String[position][position];
    	
    	int row,col;
    	
    	
    	while(scanner.hasNext()) {
    		str = scanner.nextLine();
    		
    		if(str.toLowerCase().equals("e")) {
    			System.out.println("You have moved one unit south");

    	    	for(row=0;row < position;++row) {
    	    		for(col = 0; col < position;++col) {
    	    			map[row][col] = "*";
    	    			if(row ==(position/2) && col == (position/2)-k ){
    	    				map[row][col] = "@";
    	    				k++;
    	    			}
    	    			System.out.print(map[row][col] + "   ");
    	    		}
    	    		System.out.println();
    	    	}
    	    	
    		}
    	}
    }

	
	public void south(String str) {
    	
		int position = (level-1)*5+10-(level % 2);
    	
    	int k = 1;
    	int col1 = 1;
    	int row1 = 1;
    	int j= 0;
    	int l=0;
    	int m =1;
    	Scanner scanner = new Scanner(System.in);
    	String input;
    	String map[][] = new String[position][position];
    	int row,col;
    	k= (position/2)-j;
    	
		if(str == "s") {
			for(row=0;row < position;++row) {
				for(col = 0; col < position;++col) {
					if(row ==(position - k) && col == position/2 ) {
						map[row][col] = "@";
						col1 = col;
						row1 = row;
						j++;
					}else {
						map[row][col] = "*";
					}
					System.out.print(map[row][col] + "   ");
				}
				System.out.println();
    			}
		}
		l = 1;
		while(scanner.hasNext()) {
			input = scanner.nextLine();
			k= (position/2)-j;
			
			
			if(input.toLowerCase().equals("s")) {
				l = 1;
//				System.out.println("This is l in south"+l);
//				System.out.println("This is k in south"+k);
				for(row=0;row < position;++row) {
					for(col = 0; col < position;++col) {
						if(row ==(position - k) && col == position/2 ) {
							map[row][col] = "@";
							col1 = col;
							row1 = row;
							j++;
						}else {
							map[row][col] = "*";
						}
						System.out.print(map[row][col] + "   ");
					}
					System.out.println();
	    		}
//				k = 1;
			}else if(input.toLowerCase().equals("n")) {
				k = 1;

		    	for(row=0;row < position;++row) {
		    		for(col = 0; col < position;++col) {
		    			map[row][col] = "*";			
		    			if(row ==row1-l && col == col1 ){
		    				map[row][col] = "@";
		    				l++;
		    			}
		    		System.out.print(map[row][col] + "   ");
		    		}
		    	System.out.println();

//				System.out.println("This is row "+row);
//				System.out.println("This is col "+col);
		    	}
		    	col = col1;
				row = row1;
		    	

				
		    }else if(input.toLowerCase().equals("e")) {
		    	System.out.println("You have moved one unit east");
//		    	k = 1;
		    	
//		    	while(scanner.hasNext()) {
//		    		str = scanner.nextLine();
		    		
//		    		if(str.toLowerCase().equals("e")) {
		    			

		    	    	for(row=0;row < position;++row) {
		    	    		for(col = 0; col < position;++col) {
		    	    			map[row][col] = "*";
				    			if(row ==row1 && col == col1-m ){
				    				map[row][col] = "@";
				    				m++;
				    			}
		    	    			System.out.print(map[row][col] + "   ");
		    	    		}
		    	    		System.out.println();
		    	    	}
		    	    	
//		    		}
//		    	}
//		    	east();
		    	
		    }else if(str.toLowerCase().equals("w"))
		    	west();
			}
		}
	
	public void west() {
    	int position = (level-1)*5+10-(level % 2);
    	
    	int k = 1;
    	int l = 1;
    	int j= 0;
    	Scanner scanner = new Scanner(System.in);
    	String str;
    	int map[][] = new int[position][position];
    	int row,col;
		
		while(scanner.hasNext()) {
			str = scanner.nextLine();
			k= (position/2)-j;
	    	for(row=0;row < position;++row) {
	    		for(col = 0; col < position;++col) {
	    			if(row ==(position/2) && col == (position-k) ) {
	    				map[row][col] = 8;
	    				j++;
	    			}else {
	    				map[row][col] = 1;
	    			}
	    			System.out.print(map[row][col] + "   ");
	    		}
	    		System.out.println();
	    	}
			
		}
		
	}

	
	
    public void north() {
    	
    	int position = (level-1)*5+10-(level % 2);
    	
    	int k = 1;
    	int l = 1;
    	int j= 0;
    	Scanner scanner = new Scanner(System.in);
    	String str;
    	int map[][] = new int[position][position];
    	
    	int row,col;
    	
    	
//    	System.out.println(position);
    	while(scanner.hasNext()) {
    		str = scanner.nextLine();
    		
    		if(str.toLowerCase().equals("n")) {
    			System.out.println("You have moved one unit south");

    	    	for(row=0;row < position;++row) {
    	    		for(col = 0; col < position;++col) {
    	    			map[row][col] = 1;
    	    			if(row ==(position/2)-k && col == position/2 ){
    	    				map[row][col] = 8;
    	    				k++;
    	    			}
    	    			System.out.print(map[row][col] + "   ");
    	    		}
    	    		System.out.println();
    	    	}
    		}
    	}
    }
}
