package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.EmployeeDao;
import Entity.Employee;

@WebServlet("/update")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");		
		PrintWriter out=response.getWriter();
		String empName=request.getParameter("empName");
		String empEmail=request.getParameter("email");
		String empPass=request.getParameter("pass");
		int empId=Integer.parseInt(request.getParameter("empid"));
		
		Employee emp=new Employee();
		emp.setEmpEmail(empEmail);
		emp.setEmpid(empId);
		emp.setEmpName(empName);
		emp.setEmpPass(empPass);
		
		EmployeeDao ed=new EmployeeDao();
		int status=ed.updateEmployee(emp);
		 if(status==0) {
				out.print("<h1> Data Not Updated!</h1>"); 
				 out.print("");
				 out.print("");
				 out.print("<h1><a href='viewServlet'>Back</a></h1>");
			 }
			 else {
				 out.print("<h1> Data  Updated!</h1>"); 
				 out.print("");
				 out.print("");
				 out.print("<h1><a href='viewServlet'>Back</a></h1>");
					/* response.sendRedirect("index.jsp"); */
			 }
	}

}
