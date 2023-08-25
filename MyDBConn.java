package progexer1;

import java.sql.*;

/**
 *
 * @author Hearteu
 */
public class MyDBConn {
    public Connection con;
    public Statement st;
    public ResultSet rs;
    
    public MyDBConn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://10.4.40.70:3306/progexer1?zeroDateTimeBehavior=convertToNull","root","root");
            st = con.createStatement();  
            System.out.println("Connected");
        }catch (Exception ex) {
          System.out.print(ex);
        }
    }
}
