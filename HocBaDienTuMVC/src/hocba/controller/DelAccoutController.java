package hocba.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hocba.dao.ConnectionPool;
import hocba.model.AccoutModel;
import hocba.model.object.AccoutObject;
import hocba.util.Utilities;

/**
 * Servlet implementation class DelAccoutController
 */

public class DelAccoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelAccoutController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AccoutObject accout = (AccoutObject)request.getSession().getAttribute("UserLogin");
		if(accout == null) {
			response.sendRedirect("login");
		}else {
			int idDel = Utilities.getIntParameter(request, "id");
			if(idDel != -1) {
				ConnectionPool cp = (ConnectionPool)request.getSession().getAttribute("CPool");
				if(cp == null) {
					cp = new ConnectionPool();
					request.getSession().setAttribute("CPool", cp);
				}
				boolean isDel = AccoutModel.delAccout(idDel, accout, cp);
				
				if(isDel) {
					response.sendRedirect("accoutview?del=1");
				}else {
					response.sendRedirect("accoutview?del=0");
				}
			}else {
				response.sendRedirect("accoutview?err=del");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("home");
	}

}
