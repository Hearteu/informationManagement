// Students

// global var 
public String studid, subjID;

// Enroll
 System.out.print("Enroll");
        String saveDB = "insert into enroll(studID,subjID) values("+studid+","+subjID+")";
        try{
          MyDBConn a = new MyDBConn();    
          a.st.executeUpdate(saveDB);
        }catch(Exception ex){
            System.out.print("Unable to Enroll!!");
        }
        ShowEnrolledSubjRec();
// table_studSubjMouseClicked
 int[] selectRow = table_studSubj.getSelectedRows();
        subjID=(String) table_studSubj.getValueAt(selectRow[0],0);
// table_studsubjectsMouseClicked
int[] selectRow = table_studsubjects.getSelectedRows();
        subjID=(String) table_studsubjects.getValueAt(selectRow[0],0);
// Deop
System.out.print("Drop");
        String deleteDB = "delete from enroll where studID=" + studid+ " and subjid =" +subjID;
        try{
          MyDBConn a = new MyDBConn();    
          a.st.executeUpdate(deleteDB);
        }catch(Exception ex){
            System.out.print("Unable to Drop!!");
        }
        ShowEnrolledSubjRec();

// showSubjRec
private void ShowSubjRec(){
        DefaultTableModel tblmodel = (DefaultTableModel) table_studsubjects.getModel();
        tblmodel.setRowCount(0);
        MyDBConn a = new MyDBConn();
        try {
            String query = "select * from Subjects";
            a.rs = a.st.executeQuery(query);
            while (a.rs.next())
                {
                    String id = a.rs.getString("subjID");
                    String name = a.rs.getString("subjCode");
                    String addr = a.rs.getString("subjDesc");
                    String course = a.rs.getString("subjUnits");
                    String gender = a.rs.getString("subjSched");
                    String[] item = {id,name,addr, course,gender};
                    tblmodel.addRow(item);
                }
        } catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

// show EnrolleSUbj();
private void ShowEnrolledSubjRec(){
        DefaultTableModel tblmodel = (DefaultTableModel) table_studSubj.getModel();
        tblmodel.setRowCount(0);
        MyDBConn a = new MyDBConn();
        try {
            String query = "select * from Subjects where subjID in(select subjID from enroll where StudID ="+studid+")"; //inlucde total units
            a.rs = a.st.executeQuery(query);
            while (a.rs.next())
                {
                    String id = a.rs.getString("subjID");
                    String name = a.rs.getString("subjCode");
                    String addr = a.rs.getString("subjDesc");
                    String course = a.rs.getString("subjUnits");
                    String gender = a.rs.getString("subjSched");
                    String[] item = {id,name,addr, course,gender};
                    tblmodel.addRow(item);
                }
        } catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
