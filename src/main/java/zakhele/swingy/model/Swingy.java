package zakhele.swingy.model;

import zakhele.swingy.control.ConsoleInput;

import java.io.IOException;
import java.sql.SQLException;

public class Swingy {

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	public static final String ANSI_RESET = "\u001B[0m";


	public static void main(String[] args) throws IOException, SQLException {
		

//		CreateConnection conn = new CreateConnection();
//		String sql = "CREATE DATABASE IF NOT EXISTS HEROES";
//		conn.connection(sql);
//		
//		
//		conn.createUserTable();
//		
//		boolean user = conn.checkUser("zakhele");
		
//		if(user == false)
//			conn.insertUser("zakhele");
//		else
//			System.out.println("Please choose a different username that one is already taken!!!!!");
		
		
//		conn.createHeroTable();
//		if(user == false)
//			conn.insetIntoDataBase("zakhele", "viper", 1, 0, 0, 0, 0, 0, 0, 0);
		
		if(args.length != 1) {
			if(args.length < 1){
				

				System.out.println("You did not enter any argument, please select gui or console");

			}
			else{
				System.out.println("Only one argument is required you have entered more than one!");
			}
		} else if (args[0].toLowerCase().equals("console")){

			
			
			System.out.println("Select your prefared OPTION! ");
			System.out.println(ANSI_CYAN_BACKGROUND+"+++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
			System.out.println( ANSI_CYAN_BACKGROUND+"+++++                                       +++++"+ANSI_RESET);
			System.out.println( ANSI_CYAN_BACKGROUND+"+++++       Welcome To Swingy               +++++"+ANSI_RESET);
			System.out.println( ANSI_CYAN_BACKGROUND+"+++++               OPTIONS                 +++++"+ANSI_RESET);
			System.out.println( ANSI_CYAN_BACKGROUND+"+++++          'create-user' | 'load save'| 'gui'+++++"+ANSI_RESET);
			System.out.println( ANSI_CYAN_BACKGROUND+"+++++                                       +++++"+ANSI_RESET);
			System.out.println( ANSI_CYAN_BACKGROUND+"+++++++++++++++++++++++++++++++++++++++++++++++++"+ANSI_RESET);
			System.out.println("Welcome to the console swingy game,select your OPTION:");
			ConsoleInput.consoleOutput();

		}else if (args[0].toLowerCase().equals("gui")){

		}else {
			System.out.println("You have entered invalid argument you should choose betweeen 'console' or 'gui'");
		}

	}

}
