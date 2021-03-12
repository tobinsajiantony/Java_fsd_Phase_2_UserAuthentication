package com.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.Entity.EUser;
import com.Entity.HibernateUtil;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
			if(request.getParameter("uname")!="" && request.getParameter("password")!="") {
				String userName = request.getParameter("uname");
				String password = request.getParameter("password");
				SessionFactory factory = HibernateUtil.getSessionFactory();

				Session session = factory.openSession();
				// using HQL
				String hql = "from EUser where UserName = :user_Name";
				Query query = session.createQuery(hql);
				query.setParameter("user_Name", userName);
				EUser user = (EUser) query.list().stream().findFirst().orElse(null);
				if(user != null) {
					if(user.getPassword().equals(password)) {
						//response.sendRedirect("LandingPage.jsp");
						request.getRequestDispatcher("LandingPage.jsp").forward(request, response);
					}
					else {
						response.getWriter().append("Password is incorrect");
					}
				}
				else {
					response.getWriter().append("Invalid User Name");
				}
			}
			else if(request.getParameter("uname")=="") {
				response.getWriter().append("Enter User Name");
			}
			else if(request.getParameter("password")=="") {
				response.getWriter().append("Enter Password");
			}
		}catch(Exception ex) {

		}
	}

}
