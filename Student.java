
/**
 * Write a description of class Student here.
 * 
 * @author ZARIN HOMAYRA 
 * @version 20.10.2016
 */

import java.util.*;
import java.io.*;

public class Student
{
Scanner input = new Scanner(System.in);
    
    int id;
    String name;
    String Dept ;
    String Versity ;
    double[] GPA = new double[8];
    double[][] CAndG = new double[10][2];
    double CGPA;
    
    public Student(int Id, String Name, String dept, String versity)
    {
        id = Id;
        name = Name;
        Dept = dept;
        Versity = versity;
    }
    
    public void set()
    {
        for (int j=0; j<5; j++)
        {
            System.out.print ("Enter credit : ");
            CAndG [j][0] = input.nextDouble();
            System.out.print ("Enter grade : ");
            CAndG [j][1] = input.nextDouble();
        }
    }
    
    public double ComputeGPAbyId ()
    {
        double gpa = 0;
        double total = 0;
        
        for (int j=0; j<5; j++)
        {
            gpa = gpa + CAndG [j][0] * CAndG [j][1];
            total = total + CAndG [j][0];
        }
        gpa = gpa / total;
        
        return gpa;
    }
    
    public double ComputeCGPAbyId (int x)
    {
        double cgpa = 0;
        
        for (int i=0; i<x; i++)
        {
            cgpa = cgpa + GPA [i];
        }
        cgpa = cgpa*1.0 / x*1.0;
        CGPA = cgpa;
        
        return cgpa;
    }
    
    public void StudentDetailsbyId ()
    {
        System.out.println ("Name : " + name);
        System.out.println ("ID : " + id);
        System.out.println ("Dept : " + Dept);
        System.out.println ("Versity : " + Versity);
        System.out.println ("1st Semister GPA : " + GPA[0]);
        System.out.println ("2nd Semister GPA : " + GPA[1]);
        System.out.println ("Current CGPA : " + CGPA);
    }
    
    public void UpdateStudentbyId ()
    {
        set();
        
        GPA [2] = ComputeGPAbyId();
        ComputeCGPAbyId (3);
        
        System.out.println ("3rd semister GPA : " + GPA[2]);
        System.out.println ("Current CGPA : " + CGPA);
    }
    
    public void SaveStudent()
    {
        try
        {
            File outputFile = new File ("information.txt");
            PrintWriter writer = new PrintWriter (outputFile);
            
            writer.println ("Name : " + name);
            writer.println ("ID : " + id);
            writer.println ("Dept : " + Dept);
            writer.println ("Versity : " + Versity);
            writer.println ("Current CGPA : " + CGPA);
            
            writer.close();
        }
        catch (Exception e)
        {
            System.out.print (e);
        }
    }
    
    
    public static void main (String args[])
    {
        Student students [] = new Student [10];
        
        students [0] = new Student (1407006, "ZARIN HOMAYRA", "CSE", "KUET");
        System.out.println ("Input Credits and Grades of 5 subjects of 1st Semister : ");
        students [0].set();
        students [0].GPA [0] = students [0].ComputeGPAbyId ();
        
        System.out.println ("Input Credits and Grades of 5 subjects of 2nd Semister : ");
        students [0].set();
        students [0].GPA [1] = students [0].ComputeGPAbyId ();
        students [0].ComputeCGPAbyId (2);
        students [0]. StudentDetailsbyId();
        students [0]. SaveStudent();
        
        Scanner in = new Scanner (System.in);
        System.out.println ("update ? yes = 1, no = 0");
        double b = in.nextDouble ();
        if (b == 1.0)
        {
        	System.out.println ("Input Credits and Grades of 5 subjects of 3rd Semister : ");
            students [0].UpdateStudentbyId ();
        }
    }  
}
