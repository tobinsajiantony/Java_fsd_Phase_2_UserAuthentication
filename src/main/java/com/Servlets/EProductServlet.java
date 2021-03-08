package com.Servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Entity.EProduct;
import com.Entity.EUser;
import com.Entity.HibernateUtil;

/**
 * Servlet implementation class EProductServlet
 */
public class EProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EProductServlet() {
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
			if(request.getParameter("pname")!="" && request.getParameter("pprice")!="") {
				String ProductName = request.getParameter("pname");
				int ProductPrice = Integer.parseInt(request.getParameter("pprice"));
				EProduct eProduct = new EProduct(ProductName, ProductPrice, new Date());
				SessionFactory factory = HibernateUtil.getSessionFactory();

				Session session = factory.openSession();
				// using HQL
				session.save(eProduct);
				response.getWriter().append("Product Entered Successfully");
				session.close();
			}
			else if(request.getParameter("pname")=="" && request.getParameter("pprice")!="") {
				response.getWriter().append("Please Enter Product Name");
			}
			else if(request.getParameter("pname")!="" && request.getParameter("pprice")=="") {
				response.getWriter().append("Please Enter Product Price");
			}
			else
			{
				response.getWriter().append("Please Enter Product Name and Product Price");
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
