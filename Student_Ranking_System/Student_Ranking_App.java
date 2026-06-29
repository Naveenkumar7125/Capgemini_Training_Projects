package Projects.Student_Ranking_System;

import java.util.ArrayList;

import java.util.*;
public class Student_Ranking_App {
    public static List<Student> lst = new ArrayList<>();
    public static void main(String[] args) {
        lst.add(new Student(1, "Abi", 82, "CSE"));
        lst.add(new Student(2, "Akil", 92, "CSE"));
        lst.add(new Student(3, "Ram", 100, "CSE"));
        lst.add(new Student(4, "Raj", 72, "CSE"));
        lst.add(new Student(5, "Naveen", 100, "ECE"));
        lst.add(new Student(5, "Kavishna", 100, "ECE"));
        lst.add(new Student(6, "AKilesh", 80, "CSE"));
        lst.add(new Student(7, "Logesh", 82, "ECE"));
        lst.add(new Student(8, "Kavi", 52, "CSE"));
        lst.add(new Student(9, "Kumar", 62, "ECE"));
        lst.add(new Student(9, "Kumar", 40, "IOT"));


        System.out.println("Before Sorting");
        for(Student s : lst) System.out.println(s);

        Collections.sort(lst);


        System.out.println("After Sorting");
        for(Student s : lst) System.out.println(s);


        displayTop5();

        deptTopper();

        countMorethan80();


    }
    public static void displayTop5()
    {
        System.out.println("TOP 5");
        int c = 0;
        for(Student s : lst)
        {
            System.out.println(s);
            if(c == 5)break;
            c++;
        }
    }

    public static void deptTopper()
    {

        Map<String, List<Student>> map = new HashMap<>();

//        List<Student> topper = new ArrayList<>();
        System.out.println("Department Wise Toppers");
//        int max = lst.get(0).marks;

        for(Student st : lst)
        {
            if(!map.containsKey(st.dept))
            {
                map.put(st.dept, new ArrayList<>());
                map.get(st.dept).add(st);
            }
            else
            {
                if(st.marks == map.get(st.dept).get(0).marks)
                {
                    map.get(st.dept).add(st);
                }
            }
        }

        System.out.println(map);

//        for(String st : topper)
    }
    public static void countMorethan80()
    {
        System.out.println();
        int c = 0;

        for(Student st : lst)
        {
            if(st.marks >= 80)c++;
        }

        System.out.println("Students More than 80% : " + c);

    }
}
