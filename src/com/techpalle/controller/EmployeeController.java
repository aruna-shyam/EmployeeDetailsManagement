package com.techpalle.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.dao.EmployeeDao;
import com.techpalle.model.Employee;

@WebServlet("/")
public class EmployeeController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
String path=request.getServletPath();
		
		switch(path)
		{
		case "/redirect":
			redirectEmployee(request,response);
			break;
		case "/delete":
			deleteEmployee(request,response);
			break;
		case "/edit":
			editEmployee(request,response);
			break;
		case "/editForm":
			getEditForm(request,response);
			break;
		  case "/insertform":
			getInsertForm(request,response);
			break;
		  case "/add":
		      addEmployee(request,response);
		      break;
		
		  default:
			  getStartUpPage(request,response);
			  break;
		}
		 
	}

  private void redirectEmployee	(HttpServletRequest request, HttpServletResponse response) 
  {
	  try 
		{
			RequestDispatcher rd=request.getRequestDispatcher("employee-form.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
		   e.printStackTrace();
		}
		
  }

private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) 
	{
		//read id from url
		int i=Integer.parseInt(request.getParameter("eid"));
		
		//call the dao method to delete the row in db
		EmployeeDao.deleteEmployee(i);
		
		//redirected to customer-list page
		getStartUpPage(request,response);
	}


	private void editEmployee(HttpServletRequest request, HttpServletResponse response)
	{
		int i=Integer.parseInt(request.getParameter("tbId"));
		String n=request.getParameter("tbName");
		String g=request.getParameter("rdGender");
		
		String d=request.getParameter("tbBirth");
		String de=request.getParameter("tbDesign");
		
	
		//store in customer obj
		Employee e1=new Employee(i,n,g,d,de);
		
		//calling function in dao
		EmployeeDao.editEmployee(e1);
		
		/*redirected user to customer-list page(other approach)
		try 
		{
			response.sendRedirect("list");
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}*/
		
		getStartUpPage(request,response);
				
		
		
	}




	private void getEditForm(HttpServletRequest request, HttpServletResponse response) 
	{
		//fetch id from url
		int i=Integer.parseInt(request.getParameter("eid"));
		
		//get that customer obj from dao
		Employee e1=EmployeeDao.getOneEmployee(i);
		
		//cus obj send to jsp
	    try 
		{
			RequestDispatcher rd=request.getRequestDispatcher("employee-form.jsp");
			request.setAttribute("employee", e1);
			rd.forward(request, response);
		} 
		catch (ServletException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}




	private void getInsertForm(HttpServletRequest request, HttpServletResponse response) 
	{
		
		try 
		{
			RequestDispatcher rd=request.getRequestDispatcher("employee-form.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
		   e.printStackTrace();
		}
		
	}




	private void addEmployee(HttpServletRequest request, HttpServletResponse response) 
	{
		//Reading data from customer-form page
		String n=request.getParameter("tbName");
		String g=request.getParameter("rdGender");
		String d=request.getParameter("tbBirth");
		String de=request.getParameter("tbDesign");
		
		
		//Store the admin given data into model/object
		Employee e1=new Employee(n,g,d,de);
		
		//insert customer data to db
		EmployeeDao.addEmployee(e1);
		
		//redirected admin to homepage(customer list page)
		getStartUpPage(request,response);
		
	}


    private void getStartUpPage(HttpServletRequest request, HttpServletResponse response) 
	{
		
		try 
		{
			ArrayList<Employee> alEmployee=EmployeeDao.getAllEmployee();
			
			RequestDispatcher rd=request.getRequestDispatcher("employee-list.jsp");
			request.setAttribute("al", alEmployee);
			rd.forward(request, response);
		} 
		catch (ServletException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
