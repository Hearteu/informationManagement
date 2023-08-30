 int[] selectRow = table_students.getSelectedRows();
       String studid,studname,studadd,studcourse,studgender,studyear;
       studid=(String) table_students.getValueAt(selectRow[0],0);
       studname=(String) table_students.getValueAt(selectRow[0],1);
       studadd=(String) table_students.getValueAt(selectRow[0],2);
       studcourse=(String) table_students.getValueAt(selectRow[0],3);
       studgender=(String) table_students.getValueAt(selectRow[0],4);
       studyear=(String) table_students.getValueAt(selectRow[0],5);

       txt_studID.setText(studid);
       txt_studName.setText(studname);
       txt_studAdd.setText(studadd);
       txt_studCourse.setText(studcourse);
       txt_studGender.setText(studgender);
       txt_studYear.setText(studyear);

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
