package hocba.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hocba.dao.ConnectionPool;
import hocba.model.AccoutModel;
import hocba.model.StudentModel;
import hocba.model.TeacherModel;
import hocba.model.object.AccoutObject;
import hocba.model.object.TeacherObject;

/**
 * Servlet implementation class InfoUserController
 */

public class InfoUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html;charset=utf-8";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AccoutObject accout = (AccoutObject)request.getSession().getAttribute("UserLogin");
		request.setCharacterEncoding("UTF-8");
		if(accout != null) {
			
			request.getSession().setAttribute("infoAccout", AccoutModel.infoAccoutHTML(accout, 1));
			
			ConnectionPool cp = (ConnectionPool)request.getSession().getAttribute("CPool");
			if(cp == null) {
				cp = new ConnectionPool();
				request.getSession().setAttribute("CPool", cp);
			}
			TeacherObject teacher = TeacherModel.getTeacherByAccout(accout, cp);
			
			if(teacher != null) {
				request.getSession().setAttribute("infoTeacher", TeacherModel.infoAccoutHTML(teacher, 1));
			}
			
			request.getRequestDispatcher("/view/info-user.jsp").forward(request, response);		
		}else {
			response.sendRedirect("login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType(CONTENT_TYPE);
	}

}
