package jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCOptions {

	public static void main(String[] args) throws Exception{
		int n = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfirstschema","root","");
		Statement st = con.createStatement();
		do {
			System.out.println("\nEnter your option:\n1.Insert\n2.Update\n3.Delete\n4.Display\n5.Exit");
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			if (n==1) {
				System.out.println("Enter id:");
				int id = sc.nextInt();
				System.out.println("Enter name");
				String name = sc.next();
				System.out.println("Enter sal:");
				int sal = sc.nextInt();
				int success = st.executeUpdate("insert into employee values("+id+",'"+name+"',"+sal+")");
				System.out.println(success +" record inserted");
			}
			if(n==2) {
				System.out.println("Enter the id to be updated:");
				int id = sc.nextInt();
				System.out.println("Enter the new salary:");
				int sal = sc.nextInt();
				int success = st.executeUpdate("update employee set salary = "+sal+" where id = "+id);
				System.out.println(success +" record updated");
			}
			if (n==3) {
				System.out.println("Enter the id of the row to be deleted:");
				int id = sc.nextInt();
				int success = st.executeUpdate("delete from employee where id = "+id);
				System.out.println(success +" record deleted");
			}
			if(n==4) {
				ResultSet rs = st.executeQuery("select * from employee");
				while(rs.next()) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
				}
			}
		} while (n !=5 );
	}
}
