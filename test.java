String query = "select StudID, Studname, StudAdd, StudCourse, StudGender, StudYL, studid as x, (select sum(subjUnits) from students,Subjects,enroll where students.studid = enroll.studid and enroll.subjid = Subjects.subjid and students.studid=x) as totalUnits from students";
            
