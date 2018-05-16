package com.attapong.testDb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestDbServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = "root";
		String pass = "root";
		
		String jdbcUrl =  "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String jdbcDriver = "com.mysql.jdbc.Driver";
		
		
		try {
			PrintWriter out = response.getWriter();
			out.print("Connecting to database :"+jdbcUrl);
			
			Class.forName(jdbcDriver);
			
			Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);
		
			out.println("SYCCESS!!!!");
			
			conn.close();
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
