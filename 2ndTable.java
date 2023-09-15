// students
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

// subjects
public String subjID;
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
