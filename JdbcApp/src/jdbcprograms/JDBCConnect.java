package jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCConnect {

	public static void main(String[] args) throws Exception{
		//register driver manager
		Class.forName("com.mysql.cj.jdbc.Driver");
		//create connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfirstschema","root","");
		//create statement
		Statement st = con.createStatement();
		//add query
		int result = st.executeUpdate("insert into employee values(1,'Sam',1000)");
		System.out.println(result + " success");
		result = st.executeUpdate("insert into employee values(2,'Ram',2000)");
		System.out.println(result + " success");
		//close connection
		con.close();
	}

}
