package com.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Flightdao;
import com.dto.Flight;

@WebServlet("/update_x")
public class Update extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		int id=Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String number = req.getParameter("fn");
		String formdest = req.getParameter("fp");
		String todest = req.getParameter("dp");
		String date = req.getParameter("dob");
		int price=Integer.parseInt(req.getParameter("price"));
		Date d=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			d=sdf.parse(date);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		Flight f=new Flight();
		f.setFid(id);
		f.setFname(name);
		f.setFnum(number);
		f.setFromdest(formdest);
		f.setTodest(todest);
		f.setPrice(price);
		f.setDate(d);
		  
		Flightdao fd=new Flightdao();
		fd.update_flight(f);
		
		resp.getWriter().print("<h1>update SUCCESSFUL</h1>");
		req.getRequestDispatcher("dashboard.jsp").include(req, resp);
		
	}
	

}
