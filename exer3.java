private void createDB(String sem){
        int curyear;
        curyear = 2023; //solve this by getting the system year
        String dbname = sem+"SemSY"+curyear+"_"+(curyear+1);
        System.out.print("Create a database");
        String createDB = "create database if not exists " +dbname;
        String useDB = "use 1stSemSY2023_2024"; // use dbname
        String students = "create table students(studid int primary key, studname text, studadd text, studcourse text, studgender text, studyl text)";
        String subjects = "create table subjects(subjid int primary key, subjcode text, subjdesc text, subjunits text, subjsched text)";
        String enroll = "create table enroll(eid int primary key, studid int foreign key(studid) references students(studid), subjid int foreign key(subjid) references subjects(subjid))";
        
        try{
          MyDBConn a = new MyDBConn();    
          a.st.executeUpdate(createDB);
          a.st.executeUpdate(useDB);
          a.st.executeUpdate(students);
          a.st.executeUpdate(subjects);
          a.st.executeUpdate(enroll);
        }catch(Exception ex){
            System.out.print("Unable to create database!!" + ex);
        }
    }
