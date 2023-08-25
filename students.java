private void btn_studentsActionPerformed(java.awt.event.ActionEvent evt) {                                             
        System.out.print("Save");
        String saveDB = "insert into students values(1,'aa','bb','cc','dd','ee')";
        try{
          MyDBConn a = new MyDBConn();    
          a.st.executeUpdate(saveDB);
        }catch(Exception ex){
            System.out.print("Unable to Save!!");
        } 
    }          
