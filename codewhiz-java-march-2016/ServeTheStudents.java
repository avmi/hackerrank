import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Student{
    private int token;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
        super();
        this.token = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getToken() {
        return token;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int totalEvents = Integer.parseInt(in.nextLine());

        PriorityQueue<Student> pq = new PriorityQueue<Student>(5, new Comparator<Student>() {
            public int compare(Student student1, Student student2) {
                if (student1.getCgpa() < student2.getCgpa()) return 1;
                if (student1.getCgpa() > student2.getCgpa()) return -1;

                int res = student1.getFname().compareTo(student2.getFname());
                if (res != 0) return res;

                if (student1.getToken() < student2.getToken()) return 1;
                if (student1.getToken() > student2.getToken()) return -1;

                return 0;
            }
        });

        while(totalEvents>0){
            String event = in.next();

            //Complete your code
            if (event.startsWith("ENTER")) {
                String name = in.next();
                Double cgpa = in.nextDouble();
                int token = in.nextInt();

                pq.add(new Student(token, name, cgpa));
            }
            else if (event.startsWith("SERVED")) {
                Student stud = pq.poll();
            }

            totalEvents--;
        }

        if (pq.peek() == null) {
            System.out.println("EMPTY");
        }
        else {
            while (true) {
                Student stud = pq.poll();
                if (stud == null) {
                    break;
                }

                System.out.println(stud.getFname());
            }
        }
    }
}
