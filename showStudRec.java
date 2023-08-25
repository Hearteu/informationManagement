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
