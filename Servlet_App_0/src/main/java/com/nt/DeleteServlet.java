package com.nt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
		int id = Integer.parseInt(req.getParameter("id"));
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfirstschema","root","");
		PreparedStatement ps = con.prepareStatement("delete from employee where id =?");
		ps.setInt(1, id);
		ps.executeUpdate();
		res.setContentType( "text/html" );
		PrintWriter pw = res.getWriter();
		pw.write("<h1 style = 'color:green'>Delete successful.</h1>");
		pw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
