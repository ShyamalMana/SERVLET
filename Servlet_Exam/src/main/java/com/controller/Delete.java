package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
@WebServlet("/delete")
public class Delete  extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		int id=Integer.parseInt(req.getParameter("id"));
		StudentDao dao=new StudentDao();
		Student s=dao.findStudentById(id);
		if (s!=null) 
		{
			dao.deleteStudent(s);
			resp.getWriter().print("<h1>ID "+id+" Student Deleted</h1>");
			req.getRequestDispatcher("studentdetails.jsp").include(req,resp);

	    }
	}

}
