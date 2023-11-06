// LOGIN form
   MyDBConn a;
   String login;
   public static String user,pass;
        // loginactionperformed
        pass = new String(txt_password.getPassword());
        a = new MyDBConn("information_schema", txt_username.getText(), pass);
                                                
        if(a.st == null){
            messagebox("Access Denied!!", "Error");
        }else{
            login = "logged";
            if (!txt_username.getText().equals("root")){
                ShowDBstud();
            }else{
                ShowDB();
            }
            
        }
        // comboboxactionperformed
         String x = String.valueOf(cbox_sy.getSelectedItem());
         MyDBConn.db = x;

        // button submit actionperformed
        pass = new String(txt_password.getPassword());
        user = txt_username.getText();
        students b = new students(MyDBConn.db, txt_username.getText(), pass);
        teachers c = new teachers(MyDBConn.db, txt_username.getText(), pass);
        if (login.equals("logged")){
            b.show();
        }
//messagebox
private void messagebox(String message, String titlebar){
        JOptionPane.showMessageDialog(null,message,titlebar,JOptionPane.INFORMATION_MESSAGE);
    }
// showdb
    private void ShowDB(){
        cbox_sy.removeAllItems();
        try {
            String query = "Show databases";
            a.rs = a.st.executeQuery(query);
            while (a.rs.next())
                {
                    String db = a.rs.getString("Database");
                    
                    if(!db.equals("information_schema") && !db.equals("performance_schema") && !db.equals("mysql") && !db.equals("progexer1")){
                        cbox_sy.addItem(db);
                    }
                }
        } catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
//  
private void ShowDBstud(){
        cbox_sy.removeAllItems();
        try {
            String query = "Show databases";
            a.rs = a.st.executeQuery(query);
            while (a.rs.next())
                {
                    String db = a.rs.getString("Database");
                    
                     if(!db.equals("information_schema") && !db.equals("performance_schema") && !db.equals("mysql") && !db.equals("progexer1")){
                        cbox_sy.addItem(db);
                    }
                    
                }
        } catch(Exception ex)
        {
            System.out.println(ex);
        }
    }


// MyDBConn final
public class MyDBConn {
    public Connection con;
    public Statement st;
    public ResultSet rs;
    public static String db;
    String username, password;
    
    
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
String createuser = "create user '"+user+"'@'10.4.40.174' identified by '"+txt_teacherName.getText()+txt_teacherID.getText()+"'";
String grant = "grant select,insert,update on "+currentdb+".* to '"+user+"'@'10.4.40.174'";
String saveDB = "insert into teachers values("+txt_teacherID.getText()+",'"+txt_teacherName.getText()+"','"+txt_department.getText()+"','"+txt_teacherAdd.getText()+"','"+txt_teacherContact.getText()+"','"+txt_teacherStatus.getText()+"')";
try{
        a.st.executeUpdate(saveDB);
        System.out.println("SAVED");
        checkuser();
        System.out.println("checked");
        if (!aa.equals("exists")){
                a.st.executeUpdate(createuser);
                System.out.println("CREATED USER");
          }
          a.st.executeUpdate(grant);
          System.out.println("Granted to: " + currentdb);
        }catch(Exception ex){
            System.out.print("Unable to Save!!" + ex);
        }
        ShowTeachRec();
    }                       
//students 
public String studid, subjID, currentdb,aa;
MyDBConn a;
    /**
     * Creates new form students
     */
    public students() {
        initComponents();
    }
    public students(String db, String un, String pass) {
        currentdb = db;
        initComponents();
        a = new MyDBConn(db,un,pass);
        
    }
// save button
      String saveDB = "insert into students values("+txt_studID.getText()+",'"+txt_studName.getText()+"','"+txt_studAdd.getText()+"','"+txt_studCourse.getText()+"','"+txt_studGender.getText()+"','"+txt_studYear.getText()+"')";
        String createuser = "create user 'S"+txt_studName.getText()+"'@'10.4.40.174' identified by '"+txt_studName.getText()+txt_studID.getText()+"'";
        String grant = "grant select on "+currentdb+".* to 'S"+txt_studName.getText()+"'@'10.4.40.174'";
        
        System.out.println(grant);
        
        try{
          a.st.executeUpdate(saveDB);
          System.out.println("SAVED");
          checkuser();
          System.out.println("checked");
          if (!aa.equals("exists")){
              a.st.executeUpdate(createuser);
              System.out.println("CREATED USER");
          }
          a.st.executeUpdate(grant);
          System.out.println("Granted to: " + currentdb);
        }catch(Exception ex){
            System.out.print("Unable to Save!!" + ex);
        }
        ShowStudRec();

                    
//checkuser
 public void checkuser(){
        try {
            String count = "select count(*) as a from mysql.user where user='T"+txt_teacherName.getText()+"'";
            a.rs = a.st.executeQuery(count);
            while (a.rs.next()){
                String users = a.rs.getString("a");
                if (users.equals("1")){
                    aa = "exists";
                }
                else{
                    aa ="";
                }
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
        
    }
