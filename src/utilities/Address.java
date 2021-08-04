package utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.Conection.DBconnection;
	public class Address {


		int houseNo;
		String street,locality,area,state,country;
		int pin;
		

		
		
	    public int getHouseNo() {
			return houseNo;
		}

		public void setHouseNo(int houseNo) {
			this.houseNo = houseNo;
		}

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getLocality() {
			return locality;
		}

		public void setLocality(String locality) {
			this.locality = locality;
		}

		public String getArea() {
			return area;
		}

		public void setArea(String area) {
			this.area = area;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public int getPin() {
			return pin;
		}

		public void setPin(int pin) {
			this.pin = pin;
		}
		Connection con = DBconnection.getConnection();
		ResultSet rs=null;
		PreparedStatement stmt=null;
		public void setAddress()
	    {
	    	Scanner sc=new Scanner(System.in);
	    	Scanner sc1=new Scanner(System.in);
	    	System.out.println("enter houseno:");
	    	int houseNo=sc1.nextInt();
	    	System.out.println("enter street:");
	    	String street=sc.nextLine();
	    	System.out.println("enter locality:");
	    	String locality=sc.nextLine();
	    	System.out.println("enter area:");
	    	String area=sc.nextLine();
	    	System.out.println("enter state:");
	    	String state=sc.nextLine();
	    	System.out.println("enter country:");
	    	String country=sc.nextLine();
	    	System.out.println("enter pin:");
	    	int pin=sc1.nextInt();

			try {
			 stmt = con.prepareStatement("insert into address values(?,?,?,?,?,?,?)");
			 stmt.setInt(1, houseNo);
			 stmt.setString(2, street);
			 stmt.setString(3,locality);
			 stmt.setString(4,area);
			 stmt.setString(5, state);
			 stmt.setString(6,country);
			 stmt.setInt(7,pin);
			 stmt.executeUpdate();
			 
		 System.out.println("Values Inserted successfully in address");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	        
	    }
		
		public void getAddress()
		{
		
			try {
				
				String sql = "select * from address";
				stmt = con.prepareStatement(sql);		
				rs = stmt.executeQuery(sql);
				
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5)+"\t\t"+rs.getString(6)+"\t\t"+rs.getInt(7));
				}
			}
			catch(SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		}
		



							