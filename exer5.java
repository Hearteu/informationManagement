select * from customers inner join orders on customers.cid = orders.cid;
// compare cid of orders and cid of customers

select * from customers right outer join orders on customers.cid = orders.cid;

select * from (customers left outer join orders on customers.cid = orders.cid) left outer join products on products.pid = orders.pid;


//STUDENTS 
//createdb
String enroll = "create table enroll(eid int not null auto_increment, studid int null default null, subjid int null default null,  primary key(eid), foreign key(studid) references students(studid), foreign key(subjid) references subjects(subjid))";
String grades = "create table grades(gid int not null auto_increment, prelim text null default null, midterm text null default null, prefinal text null default null, final text null default null, foreign key(gid) references enroll(eid))";
// enrollbutton
String grade = "insert into grades(prelim,midterm,prefinal,final) values(null,null,null,null)";
        
//GRADES
public String tid,aa, studid;
public static String subjID;
String currentdb;
MyDBConn a;
    /**
     * Creates new form teachers
     */
    public grades2() {
        initComponents();
    }
    public grades2(String db, String un, String pass) {
        currentdb = db;
        initComponents();
        a = new MyDBConn(db,un,pass);
    }
//formwindowopened
ShowSubjRec();
//1sttable
int[] selectRow = table_subjectstud.getSelectedRows();
        subjID = (String) table_subjectstud.getValueAt(selectRow[0],0);
        ShowStudRec();
//2ndtable
int[] selectRow = table_studgrade.getSelectedRows();
        studid = (String) table_studgrade.getValueAt(selectRow[0],0);
        String studname = (String) table_studgrade.getValueAt(selectRow[0],1);
        String prelim = (String) table_studgrade.getValueAt(selectRow[0],2);
        String midterm = (String) table_studgrade.getValueAt(selectRow[0],3);
        String prefi = (String) table_studgrade.getValueAt(selectRow[0],4);
        String fin = (String) table_studgrade.getValueAt(selectRow[0],5);
        
        txt_studidgrade.setText(studid);
        txt_studnamegrade.setText(studname);
        
        cbox_prelim.getModel().setSelectedItem(prelim);
        cbox_midterm.getModel().setSelectedItem(midterm);
        cbox_prefinal.getModel().setSelectedItem(prefi);
        cbox_final.getModel().setSelectedItem(fin);
        
//savebutton
 String prelim = String.valueOf(cbox_prelim.getSelectedItem());
        String midterm = String.valueOf(cbox_midterm.getSelectedItem());
        String prefi = String.valueOf(cbox_prefinal.getSelectedItem());
        String fin = String.valueOf(cbox_final.getSelectedItem());

        System.out.print("insert grade");
        String saveDB = "update grades inner join enroll on enroll.eid=grades.gid set prelim='"+prelim+"',midterm='"+midterm+"',prefinal='"+prefi+"',final='"+fin+"' where studid="+txt_studidgrade.getText()+" and subjid="+subjID;
        try{   
          a.st.executeUpdate(saveDB);
        }catch(Exception ex){
            System.out.print("Unable to assign grade!!" + ex);
        }
        ShowStudRec();
        ShowSubjRec();
//////
private void ShowStudRec(){
        DefaultTableModel tblmodel = (DefaultTableModel) table_studgrade.getModel();
        tblmodel.setRowCount(0);

        try {
            String query = "select students.studid,studname,prelim,midterm,prefinal,final from ((students left outer join enroll on students.studid=enroll.studid) left outer join grades on grades.gid = enroll.eid) left outer join subjects on subjects.subjid=enroll.subjid where subjects.subjid =" + subjID;
            a.rs = a.st.executeQuery(query);
            while (a.rs.next())
                {
                    String id = a.rs.getString("studid");
                    String name = a.rs.getString("studname");
                    String addr = a.rs.getString("prelim");
                    String course = a.rs.getString("midterm");
                    String gender = a.rs.getString("prefinal");
                    String yearlevel = a.rs.getString("final");
                  
                    String[] item = {id,name,addr, course,gender,yearlevel};
                    tblmodel.addRow(item);
                }
        } catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    private void ShowSubjRec(){
        DefaultTableModel tblmodel = (DefaultTableModel) table_subjectstud.getModel();
        tblmodel.setRowCount(0);
        try {
            //outerjoin
            String query = "select subjects.subjid, subjcode, subjdesc, subjunits, subjsched, subjects.subjID as x, (select count(enroll.subjID) from students,subjects,enroll where students.studid = enroll.studid and enroll.subjid = subjects.subjid and subjects.subjID=x) as totalStud from subjects ";
            String query2 = "select subjects.subjID, subjCode, subjDesc, subjUnits, subjSched, subjects.subjID as x, (select count(enroll.subjID) from students,subjects,enroll where students.studid = enroll.studid and enroll.subjid = subjects.subjid and subjects.subjID=x) as totalStud from subjects right outer join assign on subjects.subjid=assign.subjid where assign.tid="+Login.tid;
            a.rs = a.st.executeQuery(query2);
            while (a.rs.next())
                {
                    String id = a.rs.getString("subjID");
                    String name = a.rs.getString("subjCode");
                    String addr = a.rs.getString("subjDesc");
                    String course = a.rs.getString("subjUnits");
                    String gender = a.rs.getString("subjSched");
                    String hatdog = a.rs.getString("totalStud");
                    String[] item = {id,name,addr, course,gender,hatdog};
                    tblmodel.addRow(item);
                }
        } catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
