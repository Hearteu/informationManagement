// students
private void ShowStudRec(){
        DefaultTableModel tblmodel = (DefaultTableModel) table_students.getModel();
        tblmodel.setRowCount(0);
        MyDBConn a = new MyDBConn();
        try {
            String query = "select * from students";
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
// ilagay mo sya sa save and formwindowopened

// teachers
private void ShowTeachRec(){
        DefaultTableModel tblmodel = (DefaultTableModel) table_teachers.getModel();
        tblmodel.setRowCount(0);
        MyDBConn a = new MyDBConn();
        try {
            String query = "select * from teachers";
            a.rs = a.st.executeQuery(query);
            while (a.rs.next())
                {
                    String id = a.rs.getString("teacherID");
                    String name = a.rs.getString("teacherName");
                    String addr = a.rs.getString("Department");
                    String course = a.rs.getString("teacherAdd");
                    String gender = a.rs.getString("teacherContact");
                    String yearlevel = a.rs.getString("teacherStatus");
                    String[] item = {id,name,addr, course,gender,yearlevel};
                    tblmodel.addRow(item);
                }
        } catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

// subjects
 private void ShowSubjRec(){
        DefaultTableModel tblmodel = (DefaultTableModel) table_subjects.getModel();
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
