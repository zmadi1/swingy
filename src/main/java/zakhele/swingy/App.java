package zakhele.swingy;

/**
 * Hello world!
 *
 */

import java.sql.*;
public class App 
{
    public static void main( String[] args )
    {
        try{
            //1.get a connection to the database
            Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","");
            //2.create a statement
            Statement  myStat = mycon.createStatement();
            //3.execute SQL query
            ResultSet myRs = myStat.executeQuery("select * from employee");
            //4.process  the result set
            while(myRs.next()){
                System.out.println(myRs.getString("last_name") +", "+ myRs.getString("first_name"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
