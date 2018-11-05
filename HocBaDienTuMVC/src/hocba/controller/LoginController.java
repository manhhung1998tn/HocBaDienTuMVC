package hocba.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hocba.dao.ConnectionPool;
import hocba.model.UserModel;
import hocba.model.object.AccoutObject;


/**
 * Servlet implementation class Login
 */

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession().invalidate();
		
		
		RequestDispatcher dispatcher  = request.getRequestDispatcher("/view/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession().invalidate();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username != null && password != null ) {
			username = username.trim();
			password = password.trim();
			
			if(!"".equalsIgnoreCase(username) && !"".equalsIgnoreCase(password)){
				
				ConnectionPool cp = (ConnectionPool)request.getSession().getAttribute("CPool");
				if(cp == null) {
					cp = new ConnectionPool();
					request.getSession().setAttribute("CPool", cp);
				}
				AccoutObject accoutLogin = UserModel.checkLogin(username, password, cp);
				if(accoutLogin != null) {
					request.getSession(true).setAttribute("UserLogin", accoutLogin);
					response.sendRedirect("home");
				}else {
					response.sendRedirect("login?err=notok");
				}
				
				
			}else {
				//username == "" OR pass == ""
				response.sendRedirect("login?err=notthing");
			}
		}else {
			// username == null OR pass == nul
			response.sendRedirect("login?err=null");
		}
	}

}
