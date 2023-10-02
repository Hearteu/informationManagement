private void createDB(String sem){
        int curyear;
        curyear = 2023; //solve this by getting the system year
        String dbname = sem+"SemSY"+curyear+"_"+(curyear+1);
        System.out.print("Create a database");
        String createDB = "create database if not exists " +dbname;
        String useDB = "use 1stSemSY2023_2024"; // use dbname
        String students = "create table students(studid int primary key, studname text, studadd text, studcourse text, studgender text, studyl text)";
        String subjects = "create table subjects(subjid int primary key, subjcode text, subjdesc text, subjunits text, subjsched text)";
        String enroll = "create table enroll(eid int, studid int, subjid int,  primary key(eid), foreign key(studid) references students(studid), foreign key(subjid) references subjects(subjid))";
        //add assign subjid (add UNIQUE keyword) references subjects(subjid) and tid references teachers(tid) are foreign keys
        // teachers table primary key tid
        String teachers = "create table students(studid int UNIQUE primary key, studname text, studadd text, studcourse text, studgender text, studyl text)";
        //Grade table foreign key(gid) unique references enroll(eid), prelim text,midterm text,prefinal text
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

// UPDATE
private void createDB(String sem){
        int curyear;
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        String year = dateFormat.format(date);
        curyear = Integer.parseInt(year); //solve this by getting the system year
        String dbname = sem+curyear+"_"+(curyear+1);
        System.out.print("Create a database");
        String createDB = "create database if not exists " +dbname;
        String useDB = "use " + dbname; // use dbname
        String students = "create table students(studid int primary key, studname text, studadd text, studcourse text, studgender text, studyl text)";
        String subjects = "create table subjects(subjid int primary key, subjcode text, subjdesc text, subjunits text, subjsched text)";
        String enroll = "create table enroll(eid int, studid int, subjid int,  primary key(eid), foreign key(studid) references students(studid), foreign key(subjid) references subjects(subjid))";
        String teachers = "create table teachers(teacherid int UNIQUE, teachername text, department text, teacheradd text, teachercontact text, teacherstatus text, primary key(teacherid))";
        String assign = "create table assign(tid int, subjid int unique)";
        String grades = "create table grades(gid int unique, prelim text, midterm text, prefinal text, foreign key(gid) references enroll(eid))";
        try{
          MyDBConn a = new MyDBConn();    
          a.st.executeUpdate(createDB);
          a.st.executeUpdate(useDB);
          a.st.executeUpdate(students);
          a.st.executeUpdate(subjects);
          a.st.executeUpdate(enroll);
          a.st.executeUpdate(teachers);
          a.st.executeUpdate(assign);
          a.st.executeUpdate(grades);
        }catch(Exception ex){
            System.out.print("Unable to create database!!" + ex);
        }
    }
