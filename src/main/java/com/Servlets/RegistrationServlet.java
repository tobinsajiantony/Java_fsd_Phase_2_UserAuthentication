package com.Servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Entity.EUser;
import com.Entity.HibernateUtil;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			if(request.getParameter("uname")!="" && request.getParameter("password")!="" && request.getParameter("passwordre")!="") {
				if(request.getParameter("password").equals(request.getParameter("passwordre"))) {
					String UserName = request.getParameter("uname");
					String Password = request.getParameter("password");
					EUser eUser = new EUser(UserName, Password);
					SessionFactory factory = HibernateUtil.getSessionFactory();

					Session session = factory.openSession();
					// using HQL
					session.save(eUser);
					response.getWriter().append("User Added Successfully");
					session.close();
				}
				else {
					response.getWriter().append("The passwords entered does not match! Try again.");
				}
				
			}
			else if(request.getParameter("uname")=="") {
				response.getWriter().append("Please Enter User Name");
			}
			else if(request.getParameter("password")=="") {
				response.getWriter().append("Please Enter Password");
			}
			else if(request.getParameter("passwordre")=="") {
				response.getWriter().append("Please Re-Enter Password");
			}
		} catch(NumberFormatException nfe)
		{
			response.getWriter().append("Enter Valid Input");
		}
		catch(Exception ex) {
			response.getWriter().append(ex.getLocalizedMessage());
		}
	}

}
