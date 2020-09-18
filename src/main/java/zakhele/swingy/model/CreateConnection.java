package zakhele.swingy.model;

import java.io.IOException;
import java.sql.*;

public class CreateConnection {
	
	private static String url="jdbc:mysql://localhost:3306";
	private static String user = "root";
	private static String password = "";
	private static  Connection conn;
	private static  Statement statement;


	public CreateConnection() throws IOException, SQLException {

		//1.get a connection to the database
		conn = DriverManager.getConnection(url,user,password);
		//2.create a statement
		statement= conn.createStatement();


	}
	public ResultSet checkUser(String name) throws SQLException {
		String str = "SELECT `name` FROM user WHERE name = '"+name+"';";
		
		ResultSet res =  statement.executeQuery(str);
		
		return res;
		
	}
	
	public ResultSet checkUserHero(String name) throws SQLException {
		String str = "SELECT `class` FROM `HEROES` WHERE name = '"+name+"';";
		
		ResultSet res =  statement.executeQuery(str);
		
		return res;
		
	}
	
	public void createUserTable() throws SQLException {
		String str;
		
		str = "create table IF NOT EXISTS user(name varchar(255) not null,primary key (name) )";
		statement.execute(str);
		
	}
	
	public void insertUser(String name) throws SQLException {
		String sql;
		sql = "INSERT INTO user(name) VALUES('"+name+"')";
		statement.execute(sql);
	}

	public void createHeroTable() throws SQLException {

		String str;
		str = "create table IF NOT EXISTS HEROES(" +
				"name varchar(255) not null  unique," +
				"class varchar(255) not null," +
				"level integer default 0 not null," +
				"exp integer default 0 not null," +
				"hp integer not null ," +
				"attack integer," +
				"defence integer," +
				"weapon integer," +
				"armor integer," +
				"helm integer ," +
				"primary key (name),"+
				"FOREIGN KEY(name) REFERENCES `user`(name))";
		
//		System.out.println("we're checking on what is happening with regards to this!.");
		statement.execute(str);
	}
	
	public void insetIntoDataBase(String name,String hero_class,int level,int exp,int hp,int attack,int defence,int weapon,int armor,int helm) throws SQLException {
		
		String sql;
		
		sql = "INSERT INTO HEROES.HEROES (name, class, level, exp, hp, attack, defence, weapon, armor, helm) VALUES ('"+name+"', '"+hero_class+"','"+ level +"','"+ exp + "','"+hp+"','"+attack+"','"+ defence+"','"+weapon+"','"+armor+"','"+helm+"')";
		statement.execute(sql);
	}
	
	public void connect() throws SQLException {
		statement.execute("USE HEROES");
	
	}
	
	public void  connection( String sql) throws SQLException {

		statement.execute(sql);
		statement.execute("USE HEROES");
	}
	public void close() throws IOException, SQLException {
		conn.close();
	}
	public void addSubject(String last_name,String firstname) throws SQLException {
		statement.executeUpdate("INSERT INTO `employee`(`first_name`,`last_name`) VALUES('"+ last_name + "','"+firstname+"')");
	}

}
