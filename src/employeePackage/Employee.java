package employeePackage;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;

import  com.Conection.*;
import utilities.Address;
import utilities.Education;
import utilities.Experience;
public class Employee {
	
		public int id;
		public String name;
		public double salary;
		public String department;
		public  int dojYear;
		public String dob;
		public String designation;
		public double bonus=0;
		
		Address empAddress=new Address();

	    Experience empExperience=new Experience();
		Education empEducation=new Education();
		
		Connection con = DBconnection.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		public int getDojYear() {
			return dojYear;
		}
		public void setDojYear(int dojYear) {
			this.dojYear = dojYear;
		}
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
		}
		public String getDesignation() {
			return designation;
		}
		public void setDesignation(String designation) {
			this.designation = designation;
		}
		
		
		public double getBonus() {
			return bonus;
		}
		public void setBonus(double bonus) {
			this.bonus = bonus;
		}
		public Address getEmpAddress() {
			return empAddress;
		}
		public void setEmpAddress(Address empAddress) {
			this.empAddress = empAddress;
		}
		public Experience getEmpExperience() {
			return empExperience;
		}
		public void setEmpExperience(Experience empExperience) {
			this.empExperience = empExperience;
		}
		public Education getEmpEducation() {
			return empEducation;
		}
		public void setEmpEducation(Education empEducation) {
			this.empEducation = empEducation;
		}
		public void calculateSalary()
		 {
			 if(salary<10000)
			 {
			 bonus=salary*20/100;
			 }
		 }
		public void setEmployeeDetails() {
			Scanner sc=new Scanner(System.in);
			Scanner sc1=new Scanner(System.in);
			System.out.println("Enter Employee ID");
			int id=sc.nextInt();
			System.out.println("Enter Employee Name");
			String name=sc1.nextLine();
			System.out.println("Enter Employee salary");
			double salary=sc.nextInt();
			System.out.println("Enter department");
			String department=sc1.nextLine();
			System.out.println("Enter date of joining year");
			int dojYear=sc1.nextInt();
			System.out.println("Enter dob");
			String dob=sc1.nextLine();
			System.out.println("Enter designation");
			String designation=sc1.nextLine();
			System.out.println("Enter Employee Education details :");
			empEducation.setEducationDetails();
			  
			System.out.println("Enter Employee Address details :");
			empAddress.setAddress();
			 
			System.out.println("Enter Employee Experience details :");
			empExperience.setExperience();
			
			try {
			 ps = con.prepareStatement("insert into employee values(?,?,?,?,?,?,?)");
			 ps.setInt(1, id);
			 ps.setString(2, name);
			 ps.setDouble(3,salary);
			 ps.setString(4,department);
			 ps.setInt(5, dojYear);
			 ps.setString(6,dob);
			 ps.setString(7,designation);
			 ps.executeUpdate();
			 
		 System.out.println("Values Inserted successfully");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		public void getEmployeeDetails()
			{
	
				empEducation.getEducation();
			 
				empAddress.getAddress();
		     
				empExperience.getExperience();
		    try {
	
			String sql = "select * from employee";
			ps = con.prepareStatement(sql);		
			rs = ps.executeQuery(sql);
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getDouble(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5)+"\t\t"+rs.getString(6)+"\t\t"+rs.getString(7));
			}
		}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}

	
		
}
