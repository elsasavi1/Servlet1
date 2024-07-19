package jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCUpdate {

	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfirstschema","root","");
		Statement st = con.createStatement();
		int result = st.executeUpdate("update employee set name = 'Tom' where id = 1");
		System.out.println(result +" row updated");
		con.close();

	}

}
