package hocba.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hocba.dao.ConnectionPool;
import hocba.model.AccoutModel;
import hocba.model.LibraryModel;
import hocba.model.object.AccoutObject;
import hocba.util.Utilities;

/**
 * Servlet implementation class AccoutController
 */

public class AccoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final int max = 10;
    /**
     * @see HttpServlet#HttpServlet()
     */
	private ArrayList<AccoutObject> listAccout;
    public AccoutController() {
        super();
        // TODO Auto-generated constructor stub
        listAccout = null;
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
			if(accout.getAccout_permission() < (byte)2) {
				response.sendRedirect("home");
			}else {
				int page = Utilities.getIntParameter(request, "page");
				ConnectionPool cp = (ConnectionPool)request.getSession().getAttribute("CPool");
				
				if(page == -1) {
					page = 1;
				}
				if(cp == null) {
					cp = new ConnectionPool();
					request.getSession().setAttribute("CPool", cp);
				}
				listAccout = AccoutModel.getListAccout(accout, page, max, cp);
				request.getSession().setAttribute("tbListAccout", AccoutModel.listAccoutHTML(listAccout, (page-1)*max));
				
				request.getSession().setAttribute("pageHTML", LibraryModel.pageHTML("accoutview", 4, page));
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/view/accout/accout-view.jsp");
				dispatcher.forward(request, response);
			} // end if permission < 2;
			
		} // end if accout == null;
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
