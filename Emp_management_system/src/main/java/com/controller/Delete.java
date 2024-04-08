package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Employee_dao;
import com.dto.Employee;
@WebServlet("/delete")
public class Delete extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		int id=Integer.parseInt(req.getParameter("id"));
		Employee_dao ed=new Employee_dao();
		Employee e = ed.FindEmployeeById(id);
		if(e!=null)
		{
			ed.Delete_Employee(e);
			resp.getWriter().print("<h1 style=\\\"color: white;\\\">ID"+id+"Employee Deleted..</h1>");
			req.getRequestDispatcher("employeedetails.jsp").include(req, resp);
		}
		
	}

}
