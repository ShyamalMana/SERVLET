package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Studentdao;
import com.dto.Studentdto;
@WebServlet("/delete")
public class Delete extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{ 
		int id=Integer.parseInt(req.getParameter("id"));
		Studentdao sd=new Studentdao();
		Studentdto st=sd.findStudentbyId(id);
		if(st!=null)
		{
			sd.deleteStudent(st);
			resp.getWriter().print("<h1>"+ id+"POSITION  STUDENT DATA DELETED</h1>");
			req.getRequestDispatcher("Student.jsp").include(req, resp);
		}
	}

}
