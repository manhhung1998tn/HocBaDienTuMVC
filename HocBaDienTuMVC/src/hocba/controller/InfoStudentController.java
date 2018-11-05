package hocba.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.accessibility.internal.resources.accessibility_zh_TW;

import hocba.dao.ConnectionPool;
import hocba.dao.TeacherDAO;
import hocba.model.ClassesModel;
import hocba.model.StudentModel;
import hocba.model.TeacherModel;
import hocba.model.object.AccoutObject;
import hocba.model.object.ClassesObject;
import hocba.model.object.StudentObject;
import hocba.model.object.TeacherObject;
import hocba.util.Utilities;

/**
 * Servlet implementation class InfoStudentController
 */
@WebServlet("/InfoStudentController")
public class InfoStudentController extends HttpServlet {
	
	private ArrayList<ClassesObject> listClass;
	private ArrayList<StudentObject> listStudent;
	private TeacherObject teacherMain;
	private static final long serialVersionUID = 1L;
    private int indexClass;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoStudentController() {
        super();
        // TODO Auto-generated constructor stub
        teacherMain = null;
        listClass = null;
        listStudent = null;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		AccoutObject accout = (AccoutObject)request.getSession().getAttribute("UserLogin");
		// check login
		if(accout == null) {
			response.sendRedirect("login");
		}else {
			
			//get CPool
			ConnectionPool cp = (ConnectionPool)request.getSession().getAttribute("CPool");
			if(cp == null) {
				cp = new ConnectionPool();
				request.getSession().setAttribute("CPool", cp);
			}
			
			
			//get teacher 
			teacherMain = TeacherModel.getTeacherByAccout(accout, cp);
			
			
			// kiem tra danh 
			if(teacherMain != null) {
				request.getSession().setAttribute("teacherMain", teacherMain);
				
				listClass = ClassesModel.getClassByTeacher(teacherMain, cp);
				indexClass = -1;
				String htmlSelectClass = ClassesModel.classNameHTML(listClass, indexClass);
				
				request.getSession().setAttribute("slClassInfoStudent", htmlSelectClass);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/view/info-student.jsp");
				dispatcher.forward(request, response);
					
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
		
		//check login
		if(accout == null) {
			response.sendRedirect("login");
		}else {
			//get id class
			indexClass = Utilities.getIntParameter(request, "class");
			
			
			// listClass là mảng các lớp học được khai báo private và định nghĩ trên doGet
			if(indexClass != -1 && listClass != null) {
				
				
				
				
				//check teacher is class'mainteacher
				if(indexClass < listClass.size() && indexClass >= 0) {
					ConnectionPool cp = (ConnectionPool)request.getSession().getAttribute("CPool");
					if(cp == null) {
						cp = new ConnectionPool();
						request.getSession().setAttribute("CPool", cp);
					}
					
					
					//get list student by class
					listStudent = StudentModel.getListStudent(listClass.get(indexClass).getClasses_id(), cp);
					
					if(listStudent != null) {
						System.out.println("liststudent : " + listStudent.size());
						String htmlInfoStudent = StudentModel.infoStudentHTML(listStudent);
						String htmlFullInfo = StudentModel.toJsonListStudent(listStudent);
						
						request.getSession().setAttribute("infoStudent", htmlInfoStudent);
						request.getSession().setAttribute("fullInfoStudent", htmlFullInfo);
					}else {
						System.out.println("null cmnr");
					}
					
					
					
					
					
					
					
					
					String htmlSelectClass = ClassesModel.classNameHTML(listClass, indexClass);	
					request.getSession().setAttribute("slClassInfoStudent", htmlSelectClass);
					
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("/view/info-student.jsp");
					dispatcher.forward(request, response);
				}else {
					// when teacher not teachermain class
					doGet(request, response);
				}

				
			}else {
				
				doGet(request, response);
			}
		}
	}

	
	
	
}
