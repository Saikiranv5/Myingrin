package utilities;
import java.sql.Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.Conection.*;
public class Experience {


	public int id;
    public String organisationName;
	public String designation;
	public int exp;
	
	Connection con = DBconnection.getConnection();
	ResultSet rs=null;
	PreparedStatement stmt=null;
	
public Experience()
{
	
}

	public Experience(int id,String organisationName,String designation,int experience)
	{
		this.id=id;
		this.organisationName=organisationName;
		this.designation=designation;
		this.exp=experience;	
	}
	
	

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getExp() 
	{
		return exp;
	}

	public void setExp(int exp) 
	{
		this.exp = exp;
	}

	public String getOrganisationName() 
	{
		
		return organisationName;
	}
	public void setOrganisationName(String organisationName) 
	{
		this.organisationName = organisationName;
	}
	public String getDesignation() 
	{
	
		return designation;
	}
	public void setDesignation(String designation) 
	{
		this.designation = designation;
	}
	
	public void setExperience()
	{
		Scanner s=new Scanner(System.in);
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter Experience Details :");
		System.out.println();
		
		System.out.println("enter experience id");
		int id=sc.nextInt();
		
		System.out.println("Enter organisation Name :");
		String organisationName=sc.nextLine();
			
	    System.out.println("Enter Designation :");
		String designation=sc.nextLine();
		
		System.out.println("Enter employee experience :");
		int exp=s.nextInt();
		try {
			 stmt = con.prepareStatement("insert into experience values(?,?,?,?)");
			 stmt.setInt(1, id);
			 stmt.setString(2, organisationName);
			 stmt.setString(3,designation);
			 stmt.setInt(4,exp);
			 	 
		 System.out.println("Values Inserted successfully in experience");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}public void getExperience()
	 {
		 
		 try {
				
				String sql = "select * from experience";
				stmt = con.prepareStatement(sql);		
				rs = stmt.executeQuery(sql);
				
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getInt(4));
				}
			}
			catch(SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	 }

	 
	 
	}


		
 