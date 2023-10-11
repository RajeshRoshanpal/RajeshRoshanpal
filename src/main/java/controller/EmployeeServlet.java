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


@WebServlet("/abc")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//informing to browser ,we r sending html type text
		response.setContentType("text/html");
		//carrying data  servlet to browser
		PrintWriter out=response.getWriter();
		
		//System.out.println("Employee Servlet called");
		
		 //catching data 
		// request.request.getParameter() always  returns string type data
		 String name = request.getParameter("aaa");
		 String email= request.getParameter("email");
		 String password=request.getParameter("pass");
		 //data loading
		 Employee e=new Employee();
		 e.setEmpEmail(email);
		 e.setEmpName(name);
		 e.setEmpPass(password);
		 
		 EmployeeDao ed=new EmployeeDao();
		 int status=ed.saveEmployee(e);
		 if(status==0) {
			out.print("<h1> Data Not Inserted</h1>"); 
		 }
		 else {
			 out.print("<h1> Data  Inserted</h1>"); 
		 }
	}

}
