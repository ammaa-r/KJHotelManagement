package Catering;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class database {

   
    
 
    
    protected static String tableName = "Employee_Table";
    protected static String tableName1 = "ORDER_TABLE";
    protected static String tableName2 = "Price_TABLE";
    protected static String WelcomeDrinkTable = "welcomedrink";
    protected static String MainMealTable = "mainmeal";
    protected static String DessertTable = "dessert";
    protected static Connection conn = null;
    protected static Statement stmt = null;

    protected static void createConnection()
    {
       
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ppakj_db","root",""); 
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
    }
    
     protected static void shutdown()
    {
        try
        {
            
            if (stmt != null)
            {
                stmt.close();
            }
            if (conn != null)
            {
                DriverManager.getConnection(conn + ";shutdown=true");
                conn.close();
            }           
        }
        catch (SQLException sqlExcept)
        {
            
        }

    }
     
    
   
   
}
