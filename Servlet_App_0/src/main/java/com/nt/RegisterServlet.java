package com.nt;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{
	
	protected void service(HttpServletRequest req, HttpServletResponse res) {
		try {
		int id = Integer.parseInt(req.getParameter("t1"));
		String name = req.getParameter("t2");
		int sal  = Integer.parseInt(req.getParameter("t3"));
		
		System.out.println(id+ " "+name+" "+sal);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfirstschema","root","");
		PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3, sal);
		ps.executeUpdate();
		res.setContentType( "text/html" );
		PrintWriter pw = res.getWriter();
		pw.write("<h1 style = 'color:green'>Registration process success</h1>");
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
