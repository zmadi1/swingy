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
	
	public ResultSet UserHp(String name,String hero) throws SQLException {
		String str = "SELECT `hp` FROM `HEROES` WHERE name = '"+name+"' and class = '"+hero+"'";
		
		ResultSet res =  statement.executeQuery(str);
		
		return res;
		
	}
	
	public ResultSet UserExp(String name,String hero) throws SQLException {
		String str = "SELECT `exp` FROM `HEROES` WHERE name = '"+name+"' and class = '"+hero+"'";
		
		ResultSet res =  statement.executeQuery(str);
		
		return res;
		
	}
	
	public ResultSet UserLevel(String name,String hero) throws SQLException {
		String str = "SELECT `level` FROM `HEROES` WHERE name = '"+name+"' and class = '"+hero+"'";
		
		ResultSet res =  statement.executeQuery(str);
		
		return res;
		
	}
	
	public ResultSet UserAttack(String name,String hero) throws SQLException {
		String str = "SELECT `attack` FROM `HEROES` WHERE name = '"+name+"' and class = '"+hero+"'";
		
		ResultSet res =  statement.executeQuery(str);
		
		return res;
		
	}
	
	public ResultSet UserStats(String name,String hero) throws SQLException {
		String str = "SELECT * FROM `HEROES` WHERE name = '"+name+"' and class = '"+hero+"'";
		
		ResultSet res =  statement.executeQuery(str);
		
		return res;
		
	}
	
	public ResultSet UserWeapon(String name,String hero) throws SQLException {
		String str = "SELECT `weapon` FROM `HEROES` WHERE name = '"+name+"' and class = '"+hero+"'";
		
		ResultSet res =  statement.executeQuery(str);
		
		return res;
		
	}
	public ResultSet UserArmor(String name,String hero) throws SQLException {
		String str = "SELECT `hp` FROM `HEROES` WHERE name = '"+name+"' and class = '"+hero+"'";
		
		ResultSet res =  statement.executeQuery(str);
		
		return res;
		
	}
	
	public ResultSet checkUser(String name) throws SQLException {
		String str = "SELECT `name` FROM user WHERE name = '"+name+"';";
		
		ResultSet res =  statement.executeQuery(str);
		
		return res;
		
	}
	
	public ResultSet checkUserHero(String name) throws SQLException {
		String str = "SELECT * FROM `HEROES` WHERE name = '"+name+"';";
		
		ResultSet res =  statement.executeQuery(str);
		
		return res;
		
	}
	
	public ResultSet findHero(String name, String hero) throws SQLException {
		String str = "SELECT * FROM `HEROES` WHERE name = '"+name+"' and class = '"+hero+"'";
//		select * from HEROES where name = "zakhele" and class = "viper";
		ResultSet res = statement.executeQuery(str);
		return res;
	}
	
	public void createUserTable() throws SQLException {
		String str;
		
		str = "create table IF NOT EXISTS user(id integer not null AUTO_INCREMENT,name varchar(255) ,primary key (id) )";
		statement.execute(str);
		
	}
	
	public void insertUser(String name) throws SQLException {
		String sql;
		sql = "INSERT INTO user(name) VALUES('"+name+"')";
		statement.execute(sql);
	}
	
	public void updateLevel(int level,String name,String str) throws SQLException {
		String sql = "update HEROES SET level='"+level+"' where `name`= '"+name+"' and `class`= '"+str+"'";
		statement.execute(sql);
	}
	
	public void updateUserHP(int hp,String name,String str) throws SQLException {
		String sql = "update HEROES SET hp='"+hp+"' where `name`= '"+name+"' and `class`= '"+str+"'";
		statement.execute(sql);
	}
	
	public void updateAttack(int attack,String name,String str) throws SQLException {
		String sql = "update HEROES SET attack='"+attack+"' where `name`= '"+name+"' and `class`= '"+str+"'";
		statement.execute(sql);
	}
	
	
	
//	public ResultSet UserHp(String name,String hero) throws SQLException {
//		String str = "SELECT `hp` FROM `HEROES` WHERE name = '"+name+"' and class = '"+hero+"'";
//		
//		ResultSet res =  statement.executeQuery(str);
//		
//		return res;
//		
//	}
	
	public void updateExp(int exp,String name,String str) throws SQLException {
		String sql = "update HEROES SET exp='"+exp+"' where `name`= '"+name+"' and `class`= '"+str+"'";
		statement.execute(sql);
	}

	public void createHeroTable() throws SQLException {

		String str;
		str = "create table if not exists HEROES("
				+ "id integer not null ,"
				+ "name varchar(255) not null,"
				+ " class varchar(255),"
				+ "level integer default 0 not null,"
				+ "exp integer default 0 not null,"
				+ "hp integer not null,"
				+ "attack  integer,"
				+ " defence integer,"
				+ "weapon integer,"
				+ " armor integer ,"
				+ " helm integer,"
				+ "foreign key(id) references `user`(id));";
		
//		System.out.println("we're checking on what is happening with regards to this!.");
		statement.execute(str);
	}
	
	public void insetIntoDataBase(String name,String hero_class,int level,int exp,int hp,int attack,int defence,int weapon,int armor,int helm) throws SQLException {
		
		String sql;
		
		sql = "INSERT INTO HEROES.HEROES (id, name, class, level, exp, hp, attack, defence, weapon, armor, helm) VALUES ((select `id` from `user` where name ='"+name+"') ,'"+name+"', '"+hero_class+"','"+ level +"','"+ exp + "','"+hp+"','"+attack+"','"+ defence+"','"+weapon+"','"+armor+"','"+helm+"')";
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
//	public void addSubject(String last_name,String firstname) throws SQLException {
//		statement.executeUpdate("INSERT INTO `employee`(`first_name`,`last_name`) VALUES('"+ last_name + "','"+firstname+"')");
//	}

}
