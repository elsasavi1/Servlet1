package com.nt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.entity.Employee;

public class SelectServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfirstschema","root","");
			PreparedStatement ps = con.prepareStatement("select * from employee where id =?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			res.setContentType( "text/html" );
			PrintWriter pw = res.getWriter();
			if(rs.next()) {
				id = rs.getInt("id");
				String name = rs.getString("name");
				int sal = rs.getInt("salary");
				//pw.write(id+" "+name+" "+sal);
				RequestDispatcher rd = req.getRequestDispatcher("displayobject.jsp");
				
				Employee emp = new Employee();
				emp.setId(id);
				emp.setName(name);
				emp.setSal(sal);
				req.setAttribute("e", emp);
				//req.setAttribute("empid", id);
				//req.setAttribute("empname", name);
				//req.setAttribute("empsal", sal);
				rd.forward(req, res);
				
			} else {
				pw.write("No records selected.");
			}
			pw.close();
			
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	

}
