// LOGIN
MyDBConn a;
        // LOGINACTIONPERFORMED
                db.username = txt_username.getText();
                db.password = txt_password.getText();
                
                ShowDB();
        ///
    private void ShowDB(){
        try {
            String query = "Show databases";
            a.rs = a.st.executeQuery(query);
            while (a.rs.next())
                {
                    String db = a.rs.getString("Database");
                    cbox_sy.removeAllItems();
                    if(!db.equals("information_schema")){
                        cbox_sy.addItem(db);
                    }
                }
        } catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
//SUBMIT
if (a.st == null){
        
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
//teachers
String user = "T" + txt_teacherName.getText();
String createuser = "create user '"+user+"'@'10.4.40.174' identified by '"+txt_studName.getText()+txt_studID.getText()+"'";
String grant = "grant select on "+currentdb+".* to '"+txt_teacherName.getText()+"'@'10.4.40.174'";
//students 
String user = "S" + txt_teacherName.getText();
String createuser = "create user '"+txt_studName.getText()+"'@'10.4.40.174' identified by '"+txt_studName.getText()+"s"+txt_studID.getText()+"'";
String grant = "grant select on "+db+".* to '"+txt_studName.getText()+"'@'10.4.40.174'";

//aljdhaskjd

   private void btn_saveStudentsActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        String password = txt_studName.getText()+txt_studID.getText();
        String user = "S" + txt_studName.getText();
           
        String saveDB = "insert into students values("+txt_studID.getText()+",'"+txt_studName.getText()+"','"+txt_studAdd.getText()+"','"+txt_studCourse.getText()+"','"+txt_studGender.getText()+"','"+txt_studYear.getText()+"')"; // insert total units
        String createuser = "create user '"+user+"'@'10.4.40.174' identified by '"+password+"'";
        String grant = "grant select on "+currentdb+".* to '"+txt_studName.getText()+"'@'10.4.40.174'";
        
        try{
          a.st.executeUpdate(saveDB);
          a.st.executeUpdate(createuser);
          a.st.executeUpdate(grant);
        }catch(Exception ex){
            System.out.print("Unable to Save!!" + ex);
        }
        ShowStudRec();
