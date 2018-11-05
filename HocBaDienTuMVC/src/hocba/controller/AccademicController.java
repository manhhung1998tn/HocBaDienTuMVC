package hocba.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import hocba.dao.ConnectionPool;
import hocba.model.AccademicModel;
import hocba.model.ClassesModel;
import hocba.model.TeacherModel;
import hocba.model.object.Accademic_YearObject;
import hocba.model.object.AccoutObject;
import hocba.model.object.ClassesObject;
import hocba.model.object.TeacherObject;
import hocba.util.Utilities;

/**
 * Servlet implementation class AcademicController
 */

public class AccademicController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static TeacherObject teacherMain;
    private ArrayList<ClassesObject> listClass;
    private int indexClass;
    private int indexTerm;
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccademicController() {
        super();
        // TODO Auto-generated constructor stub
        teacherMain = null;
        listClass = null;
        indexClass = -1;
        indexTerm = -1;
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AccoutObject accout = (AccoutObject)request.getSession().getAttribute("UserLogin");
		if(accout == null) {
			response.sendRedirect("login");
		}else {
			ConnectionPool cp = (ConnectionPool)request.getSession().getAttribute("CPool");
			if(cp == null) {
				cp = new ConnectionPool();
				request.getSession().setAttribute("CPool", cp);
			}
			
			teacherMain = TeacherModel.getTeacherByAccout(accout, cp);
			
			
			// kiem tra danh 
			if(teacherMain != null) {
				
				listClass = ClassesModel.getClassByTeacher(teacherMain, cp);
				String htmlSelectClass = ClassesModel.classNameHTML(listClass, indexClass);
				request.getSession().setAttribute("slClassName", htmlSelectClass);
				
				System.out.println("list class size : " + listClass.size());
				
				
				
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/view/accademic/accademic.jsp");
				dispatcher.forward(request, response);
				
				if(listClass.size() == 0) {
					response.sendRedirect("accademic?err=noclass");
				}
					
			}else {
				
				response.sendRedirect("home?err=notteacher");
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AccoutObject accout = (AccoutObject)request.getSession().getAttribute("UserLogin");
		if(accout == null) {
			response.sendRedirect("login");
		}else {
			ConnectionPool cp = (ConnectionPool)request.getSession().getAttribute("CPool");
			
			indexClass = Utilities.getIntParameter(request, "classSubject"); 
			if(indexClass != -1 && listClass != null) {
				int term = Utilities.getIntParameter(request, "termSubject");
				
				if(term != 1 && term != 2 && term != 3) {
					
				}else {
					if(cp == null) {
						cp = new ConnectionPool();
						request.getSession().setAttribute("CPool", cp);
					}
					ArrayList<Accademic_YearObject> list = AccademicModel.getAccademic(listClass.get(indexClass).getClasses_id(), term, cp);
					
					String html = AccademicModel.accademicShow(list);
					request.getSession().setAttribute(html, "accademicshow");
					
					System.out.println("thanh cong load");
					
					
					request.getSession().setAttribute("termSubject",String.valueOf(term));
				}
				
				
				String htmlSelectClass = ClassesModel.classNameHTML(listClass, indexClass);
				request.getSession().setAttribute("slClassName", htmlSelectClass);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/view/accademic/accademic.jsp");
				dispatcher.forward(request, response);
			}else {
				response.sendRedirect("accademic?err=1");
			}
			
			
			
			
			
			
			
			
		}
	}

}
