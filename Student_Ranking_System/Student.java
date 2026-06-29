package Projects.Student_Ranking_System;

public class Student implements Comparable<Student>{
    int rollno;
    String name;
    int marks;
    String dept;

    public Student(int rollno, String name, int marks, String dept)
    {
        this.rollno = rollno;
        this.name = name;
        this.marks = marks;
        this.dept = dept;
    }

    public int compareTo(Student st)
    {
        if(this.marks == st.marks)
        {
            if(this.name.compareTo(st.name) == 0)
            {
                return this.rollno - st.rollno;
            }
            return this.name.compareTo(st.name);
        }

        return st.marks - this.marks;


    }
    public String toString()
    {
        return "Name : " + this.name + "\tRoll No : " + this.rollno + "\tMarks : " + this.marks + "\tDepartment : " +this.dept;
    }
}
