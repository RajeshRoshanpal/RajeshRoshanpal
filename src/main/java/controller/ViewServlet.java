package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.EmployeeDao;
import Entity.Employee;

@WebServlet("/viewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		EmployeeDao ed=new EmployeeDao();
		List<Employee> empList=ed.getAllEmployee();
		
		out.print("<table style='border:2px solid green; text-align:center; width:100%'>");
		out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Update</th><th>Delete</th></tr>");
		for(Employee e:empList) {
			out.print("<tr>");
			out.print("<td>"+e.getEmpid()+"</td>");
			out.print("<td>"+e.getEmpName()+"</td>");
			out.print("<td>"+e.getEmpEmail()+"</td>");
			out.print("<td>"+e.getEmpPass()+"</td>");
			out.print("<td><a href='edit1?id="+e.getEmpid()+"'>Update</a></td>");
			out.print("<td><a href='delete?id="+e.getEmpid()+"'>Delete</a></td>");
			out.print("</tr>");
		}
		out.print("</table>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
