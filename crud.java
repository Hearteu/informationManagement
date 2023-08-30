 System.out.print("Delete");
        String deleteDB = "delete from students where studid=" + txt_studID.getText();
        try{
          MyDBConn a = new MyDBConn();    
          a.st.executeUpdate(deleteDB);
        }catch(Exception ex){
            System.out.print("Unable to Delete!!");
        }
        ShowStudRec();

System.out.print("Update");
        String updateDB = "update students set StudName='"+txt_studName.getText()+"',StudAdd='"+txt_studAdd.getText()+"',StudCourse='"+txt_studCourse.getText()+"',StudYL='"+txt_studYear.getText()+"' where studid=" + txt_studID.getText();
        try{
          MyDBConn a = new MyDBConn();    
          a.st.executeUpdate(updateDB);
        }catch(Exception ex){
            System.out.print("Unable to Update!!" + ex);
        }
        ShowStudRec();

   System.out.print("Save");
        String saveDB = "insert into students values("+txt_studID.getText()+",'"+txt_studName.getText()+"','"+txt_studAdd.getText()+"','"+txt_studCourse.getText()+"','"+txt_studGender.getText()+"','"+txt_studYear.getText()+"')";
        try{
          MyDBConn a = new MyDBConn();    
          a.st.executeUpdate(saveDB);
        }catch(Exception ex){
            System.out.print("Unable to Save!!");
        }
        ShowStudRec();
