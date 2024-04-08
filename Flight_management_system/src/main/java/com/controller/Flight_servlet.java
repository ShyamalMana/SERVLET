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

@WebServlet("/signup")
public class Flight_servlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String name = req.getParameter("flightName");
		String number = req.getParameter("flightNumber");
		String formdest = req.getParameter("fromDestination");
		String todest = req.getParameter("toDestination");
		String date = req.getParameter("date");
		int price=Integer.parseInt(req.getParameter("price"));
		Date d=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		try {
			d=sdf.parse(date);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		Flight f=new Flight();
		f.setFname(name);
		f.setFnum(number);
		f.setFromdest( formdest);
		f.setTodest(todest);
		f.setDate(d);
		f.setPrice(price);
		
		Flightdao fd=new Flightdao();
		fd.save_flight(f);
		resp.getWriter().print("<h1>SIGNUP SUCCESSFUL</h1>");
		req.getRequestDispatcher("dashboard.jsp").include(req, resp);
		
		
	}

}
