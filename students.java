private void btn_studentsActionPerformed(java.awt.event.ActionEvent evt) {                                             
        System.out.print("Save");
        String saveDB = "insert into students values("+txt_studID.getText()+",'"+txt_studName.getText()+"','"+txt_studAdd.getText()+"','"+txt_studCourse.getText()+"','"+txt_studGender.getText()+"','"+txt_studYear.getText()+"')";
        try{
          MyDBConn a = new MyDBConn();    
          a.st.executeUpdate(saveDB);
        }catch(Exception ex){
            System.out.print("Unable to Save!!");
        } 
    }          
