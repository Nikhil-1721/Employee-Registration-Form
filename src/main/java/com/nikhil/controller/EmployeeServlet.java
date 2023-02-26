package com.nikhil.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nikhil.dao.EmployeeDAO;
import com.nikhil.model.Employee;

public class EmployeeServlet extends HttpServlet{

		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String id = req.getParameter("Id");
			String name = req.getParameter("name");

			Employee emp = new Employee(id, name);
			
			EmployeeDAO dao = new EmployeeDAO();
			Employee employee = dao.insert(emp);
			
			RequestDispatcher rDispatcher = req.getRequestDispatcher("Success.jsp");
			rDispatcher.forward(req, resp);
		}
}
