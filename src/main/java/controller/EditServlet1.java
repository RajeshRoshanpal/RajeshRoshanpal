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
@WebServlet("/edit1")
public class EditServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");		
		PrintWriter out=response.getWriter();
		
		int empId=Integer.parseInt(request.getParameter("id"));
		EmployeeDao ed=new EmployeeDao();
		Employee ob=ed.fatchEmpById(empId);
		
		out.print("<fieldset>");
		out.print("<form id='survey-form' method='post' action='update'><h2>Your information</h2>");
		out.print("<label for='name' id='name-label'>Name ");
		out.print("<input id='name' name='empName' type='text'  value="+ob.getEmpName()+" required /><br>");
		out.print("<input id='empid' name='empid' type='hidden' value="+ob.getEmpid()+" />");
		out.print("</label> ");
		out.print("<label for='email' id='email-label'>Email ");
		out.print("<input id='email'  value="+ob.getEmpEmail()+"	name='email' type='email' required /><br>");
		out.print("</label>");
		out.print("<label for='new-password'>Password ");
		out.print("<input name='pass' value="+ob.getEmpPass()+" type='text'  required /><br>");
		out.print("</label>");
		
		out.print("<input id='submit' type='submit' value='Update' />");
		out.print("</form>");
		out.print("</fieldset>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
