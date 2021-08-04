package utilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.Conection.*;

public class Education {
	public int id;
	public  String course;
	public  String university;
	public String place;
	public  float marks;
	public int yop;
	
	Connection con = DBconnection.getConnection();
	ResultSet rs=null;
	PreparedStatement stmt=null;

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		this.course = course;
	}


	public String getUniversity() {
		return university;
	}


	public void setUniversity(String university) {
		this.university = university;
	}


	public String getPlace() {
		return place;
	}


	public void setPlace(String place) {
		this.place = place;
	}


	public float getMarks() {
		return marks;
	}


	public void setMarks(float marks) {
		this.marks = marks;
	}


	public int getYop() {
		return yop;
	}


	public void setYop(int yop) {
		this.yop = yop;
	}


	public void setEducationDetails()
	{
		Scanner sc=new Scanner(System.in);
        Scanner sc1=new Scanner(System.in);
    	
        System.out.println("enter education id");
        int id=sc.nextInt();
		System.out.print("enter course:");
		String course=sc1.nextLine();
		
		System.out.println("enter university:");
		String university=sc1.nextLine();
		System.out.println("enter place:");
		String place=sc1.nextLine();
		System.out.println("enter marks:");
		Float marks=sc.nextFloat();
		System.out.println("enter year of passing:");
		int yop=sc.nextInt();
		try {
			 stmt = con.prepareStatement("insert into education values(?,?,?,?,?,?)");
			 stmt.setInt(1, id);
			 stmt.setString(2, course);
			 stmt.setString(3,university);
			 stmt.setString(4,place);
			 stmt.setFloat(5, marks);
			 stmt.setInt(6,yop);
			 stmt.executeUpdate();
			 
		 System.out.println("Values Inserted successfully in education");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}

	public void getEducation()
	{
		

	    try {
		
		String sql = "select * from Education"
				+ "";
		stmt = con.prepareStatement(sql);		
		rs = stmt.executeQuery(sql);
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getFloat(5)+"\t\t"+rs.getInt(6));
		}
	}
	catch(SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		  
	}




	
}




	