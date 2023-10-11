package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.EmployeeDao;
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");		
		PrintWriter out=response.getWriter();
		
		int empId=Integer.parseInt(request.getParameter("id"));
		
		EmployeeDao ed=new EmployeeDao();
		int status=ed.deleteEmployee(empId);
		if(status==0) {
			out.print("<h1>Employee Not delete</h1>");
		}else {
			out.print("<h1>Employee  Deleted</h1>");
			out.print("");
			out.print("");
			out.print("<h1><a href='viewServlet'>Back</a></h1>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
