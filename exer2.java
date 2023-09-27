// Students

// global var sa students form
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
// Drop
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

private void ShowAssignedSubjRec(){
        DefaultTableModel tblmodel = (DefaultTableModel) table_EteachSubj.getModel();
        tblmodel.setRowCount(0);
        MyDBConn a = new MyDBConn();
        try {
            String query = "select * from Subjects where subjID in(select subjID from assign where tid ="+tid+")"; //inlucde total units
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

// FINAL SA SHOWSTUDENTS
private void ShowStudRec(){
        DefaultTableModel tblmodel = (DefaultTableModel) table_students.getModel();
        tblmodel.setRowCount(0);
        MyDBConn a = new MyDBConn();
        try {
            String query = "select StudID, Studname, StudAdd, StudCourse, StudGender, StudYL, studid as x, (select sum(subjUnits) from students,Subjects,enroll where students.studid = enroll.studid and enroll.subjid = Subjects.subjid and students.studid=x) as totalUnits from students";
            a.rs = a.st.executeQuery(query);
            while (a.rs.next())
                {
                    String id = a.rs.getString("StudID");
                    String name = a.rs.getString("Studname");
                    String addr = a.rs.getString("StudAdd");
                    String course = a.rs.getString("StudCourse");
                    String gender = a.rs.getString("StudGender");
                    String yearlevel = a.rs.getString("StudYL");
                    String totUnits = a.rs.getString("totalUnits");
                    String[] item = {id,name,addr, course,gender,yearlevel,totalUnits};
                    tblmodel.addRow(item);
                }
        } catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

// FINAL SA SHOWSUBJ
private void ShowSubjRec(){
        DefaultTableModel tblmodel = (DefaultTableModel) table_studsubjects.getModel();
        tblmodel.setRowCount(0);
        MyDBConn a = new MyDBConn();
        try {
            String query = "select subjID, subjCode, subjDesc, subjUnits, subjSched, subjID as x, (select count(enroll.subjID) from students,Subjects,enroll where students.studid = enroll.studid and enroll.subjid = Subjects.subjid and Subjects.subjID=x) as totalStud from Subjects";
            a.rs = a.st.executeQuery(query);
            while (a.rs.next())
                {
                    String id = a.rs.getString("subjID");
                    String name = a.rs.getString("subjCode");
                    String addr = a.rs.getString("subjDesc");
                    String course = a.rs.getString("subjUnits");
                    String gender = a.rs.getString("subjSched");
                    String gender = a.rs.getString("totalStud");
                    String[] item = {id,name,addr, course,gender,totalStud};
                    tblmodel.addRow(item);
                }
        } catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

// FINAL SA SHOWTEACH
private void ShowTeachRec(){
        DefaultTableModel tblmodel = (DefaultTableModel) table_teachers.getModel();
        tblmodel.setRowCount(0);
        MyDBConn a = new MyDBConn();
        try {
            String query = "select teacherID, teacherName, Department, teacherAdd, teacherContact, teacherStatus, teacherID as x, (select count(assign.subjid) from teachers,Subjects,assign where teachers.teacherID = assign.tid and assign.subjid = Subjects.subjid and teachers.teacherID=x) as totalUnits from teachers";
            a.rs = a.st.executeQuery(query);
            while (a.rs.next())
                {
                    String id = a.rs.getString("teacherID");
                    String name = a.rs.getString("teacherName");
                    String addr = a.rs.getString("Department");
                    String course = a.rs.getString("teacherAdd");
                    String gender = a.rs.getString("teacherContact");
                    String yearlevel = a.rs.getString("teacherStatus");
                    String totUnits = a.rs.getString("totalUnits");
                    String[] item = {id,name,addr, course,gender,yearlevel,totUnits};
                    tblmodel.addRow(item);
                }
        } catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

//sa subjects

private void ShowStudRec(){
        DefaultTableModel tblmodel = (DefaultTableModel) table_subjStud.getModel();
        tblmodel.setRowCount(0);
        MyDBConn a = new MyDBConn();
        try {
            String query = "select * from students where studID in(select studID from enroll where subjID ="+subjID+")"; //inlucde total units
            a.rs = a.st.executeQuery(query);
            while (a.rs.next())
                {
                    String id = a.rs.getString("StudID");
                    String name = a.rs.getString("Studname");
                    String addr = a.rs.getString("StudAdd");
                    String course = a.rs.getString("StudCourse");
                    String gender = a.rs.getString("StudGender");
                    String yearlevel = a.rs.getString("StudYL");
                    String[] item = {id,name,addr, course,gender,yearlevel};
                    tblmodel.addRow(item);
                }
        } catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
