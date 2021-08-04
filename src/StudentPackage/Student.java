package StudentPackage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;

import com.Conection.*;
import utilities.Address;
import utilities.Education;

public class Student {
	public int id;
	public String name;
	public String dob;
	public int percentage;
	public int phy,che,math;
	Education studentEducation=new Education();
	Address studentAddress=new Address();
	
	Connection con = DBconnection.getConnection();
	ResultSet rs=null;
	PreparedStatement stmt=null;
	
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	public int getPhy() {
		return phy;
	}
	public void setPhy(int phy) {
		this.phy = phy;
	}
	public int getChe() {
		return che;
	}
	public void setChe(int che) {
		this.che = che;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	

	public Education getStudentEducation() {
		return studentEducation;
	}
	public void setStudentEducation(Education studentEducation) {
		this.studentEducation = studentEducation;
	}
	public Address getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}
	public void setStudentDetails() {
		Scanner sc=new Scanner(System.in);
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("enter student roll number :");
		int id=sc.nextInt();
	    System.out.println("enter Student name :");
	    String name=sc1.nextLine();
		System.out.println("enter student date of birth :");
		String dob=sc1.nextLine();
		System.out.println("enter   percentage :");
		int percentage=sc.nextInt();
		System.out.println("enter  physics marks :");
		int phy=sc.nextInt();
		System.out.println("enter  chemistry marks :");
		int che=sc.nextInt();
		System.out.println("enter  maths marks:");
		int math=sc.nextInt();
		System.out.println(" Enter Student Education details :");
	    studentEducation.setEducationDetails();
	    
	    System.out.println("Student Address Details :");
	    studentAddress.setAddress();
	
		try {
		 stmt = con.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
		 stmt.setInt(1, id);
		 stmt.setString(2, name);
		 stmt.setString(3,dob);
		 stmt.setInt(4,percentage);
		 stmt.setInt(5, phy);
		 stmt.setInt(6,che);
		 stmt.setInt(7,math);
		 stmt.executeUpdate();
		 
	 System.out.println("Values Inserted successfully in student");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void getStudentDetails()
		{
         
		studentEducation.getEducation();
		studentAddress.getAddress();
	    try {
		
		String sql = "select * from student";
		stmt = con.prepareStatement(sql);		
		rs = stmt.executeQuery(sql);
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getInt(4)+"\t\t"+rs.getInt(5)+"\t\t"+rs.getInt(6)+"\t\t"+rs.getInt(7));
		}
	}
	catch(SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	
}
