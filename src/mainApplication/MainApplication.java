

package mainApplication;
import java.util.ArrayList;
import java.util.Collection;

import java.util.Scanner;

import employeePackage.*;
import StudentPackage.*;
 class MainApplication {
	 public static void main(String[] args) {
			
			// TODO Auto-generated method stub
			Collection<Employee> c = new ArrayList<Employee>();
			Collection<Student> s = new ArrayList<Student>();
			Scanner sc=new Scanner(System.in);
			int choice;
			 System.out.println("enter number of students:");
			 int n=sc.nextInt();
				for (int i = 0; i < n; i ++)
				   {
						Student student=new Student();
						student.setStudentDetails();
						student.getStudentDetails();
						s.add(student);
					   
				   }
			System.out.println("enter number of employee:");
				int n1=sc.nextInt();
	            for (int i = 0; i < n1; i ++)
				   {
	         	   	Employee employee=new Employee();
	    				employee.setEmployeeDetails();
	    				employee.getEmployeeDetails();
					    employee.calculateSalary();
					    c.add(employee);
				   }  
			
			do
			{
				
				
				 System.out.println("University Details");
			     System.out.println("Menu");
				 System.out.println("enter 1  for display student details");
				 System.out.println("enter 2 for display Employee details");
			
				 System.out.println("Please enter your choice:");
				   //Get user's choice
				 
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("student details are::");
				s.stream().forEach(System.out::println); 
					break;
				
			case 2:
				System.out.println("enter number of Employees:");
				c.stream().forEach(System.out::println);
				
				break;
			
			
			   default: System.out.println("exit");
			   }
				} while(choice<=2);
				
			 }
			 }




		  