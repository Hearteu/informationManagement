// LOGIN
        // LOGINACTIONPERFORMED
                MyDBConn db = new MyDBConn();
                db.username = txt_username.getText();
                db.password = txt_password.getText();
                cbox_sy.removeAllItems();
                ShowDB();
        ///
    private void ShowDB(){
        MyDBConn a = new MyDBConn();
        try {
            String query = "Show databases";
            a.rs = a.st.executeQuery(query);
            while (a.rs.next())
                {
                    String db = a.rs.getString("Database");
                    
                    if(!db.equals("information_schema")){
                        cbox_sy.addItem(db);
                    }
                }
        } catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

// MyDBConn Update
public class MyDBConn {
    public Connection con;
    public Statement st;
    public ResultSet rs;
    String db, username, password;
    public MyDBConn(){
        username = "root";
        password = "root";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://10.4.40.70:3306/information_schema?zeroDateTimeBehavior=convertToNull",username,password); 
            st = con.createStatement();  
            System.out.println("Connected");
        }catch (Exception ex) {
          System.out.print(ex);
        }
    }
    
    public MyDBConn(String db, String username, String password){     
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://10.4.40.70:3306/" + db + "?zeroDateTimeBehavior=convertToNull",username,password); 
            st = con.createStatement();  
            System.out.println("Connected");
        }catch (Exception ex) {
          System.out.print(ex);
        }
    }
}

//students 
String createuser = "create user 'username'@localhost identified by 'passowrd'";
String grant = "grant select on *.* to 'user'@localhost identified by 'password'";
