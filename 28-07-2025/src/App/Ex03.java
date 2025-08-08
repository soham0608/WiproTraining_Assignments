package App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex03 {
	
	public static void main(String[] args) 
	{
		try 
		{			
			Scanner sc = new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			String jdbcUrl = "jdbc:mysql://localhost:3306/cdac?useSSL=false";
			Connection con = DriverManager.getConnection(jdbcUrl, "root", "Soham@4625");
	            System.out.println("Connected Successfully");

	            System.out.print("Enter employee name: ");
	            String empName = sc.nextLine();

	            System.out.print("Enter department: ");
	            String department = sc.nextLine();

	            String sql = "INSERT INTO employee (emp_name, department) VALUES (?, ?)";
	            PreparedStatement pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, empName);
	            pstmt.setString(2, department);

	            int rowsInserted = pstmt.executeUpdate();

	            if (rowsInserted > 0) {
	                System.out.println("Employee inserted successfully.");
	            }

	            pstmt.close();
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            sc.close();
	        }
		
	}
}
