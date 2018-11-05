package hocba.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hocba.dao.ConnectionPool;
import hocba.dao.StudentDAO;
import hocba.model.StudentModel;
import hocba.model.object.AccoutObject;
import hocba.model.object.StudentObject;
import hocba.model.object.TeacherObject;
import hocba.util.Utilities;

/**
 * Servlet implementation class EditInfoStudent
 */

public class EditStudentInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String editStudentHTML;
    private StudentObject studentObject;
    private TeacherObject teacherMain;
    private static final String CONTENT_TYPE = "text/html;charset=utf-8";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStudentInfoController() {
        super();
        // TODO Auto-generated constructor stub
        editStudentHTML = "";
        studentObject = null;
        teacherMain = null;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AccoutObject accout = (AccoutObject)request.getSession().getAttribute("UserLogin");
		if(accout != null) {
			
			teacherMain = (TeacherObject)request.getSession().getAttribute("teacherMain");
			
			if(teacherMain == null) {
				response.sendRedirect("home?err=notteacher");
			}else {
				request.setCharacterEncoding("UTF-8");
				int idStudent = Utilities.getIntParameter(request, "id");
				if(idStudent != -1) {
					
					ConnectionPool cp = (ConnectionPool)request.getSession().getAttribute("CPool");
					if(cp == null) {
						cp = new ConnectionPool();
						request.getSession().setAttribute("CPool", cp);
					}
					
					studentObject = StudentModel.getStudent(idStudent, cp);
					if(studentObject != null && studentObject.getClasses_mainteacher_id() == teacherMain.getTeacher_id()) {
						
						request.getSession().setAttribute("editInfoStudent", StudentModel.editInfoStudent(studentObject,accout.getAccout_permission()));
						request.getSession().setAttribute("editGuardianStudent", StudentModel.editGuardianStudent(studentObject,accout.getAccout_permission()));
						request.getSession().setAttribute("editAddressStudent", StudentModel.editAddressStudent(studentObject,accout.getAccout_permission()));
						
						
						//Xuat giao dien
						request.getRequestDispatcher("/view/edit-info-student.jsp").forward(request, response);
					}else {
						response.sendRedirect("infostudent");
					}
						
					
					
				}else {
					response.sendRedirect("infostudent");
				}
				
			}
			
			
			
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
		request.setCharacterEncoding("UTF-8");
		if(teacherMain == null) {
			response.sendRedirect("home?err=notteacher");
		}else {
			int idStudent = Utilities.getIntParameter(request, "student_id");
			if(studentObject == null || studentObject.getStudent_id() != idStudent) {
				response.sendRedirect("infostudent");
			}else {
				StudentObject studentEdit = new StudentObject(studentObject);
				boolean checkEdit = true;
				//studentEdit.setStudent_id(Utilities.getIntParameter(request,"student_id"));
				
				
				
				
				
				
				
				
				//studentEdit.setStudent_birthplace(Utilities.encode(Utilities.getValue(request.getParameter("student_birthplace"))));
				String province = Utilities.getValue(request.getParameter("province"));
				String district = Utilities.getValue(request.getParameter("district"));
				String ward = Utilities.getValue(request.getParameter("ward"));
				
			
				if(province.equals("") || district.equals("") || ward.equals("")) {
					checkEdit = false;
				}else {
					studentEdit.setStudent_province(Utilities.encode(province));
					studentEdit.setStudent_district(Utilities.encode(district));
					studentEdit.setStudent_ward(Utilities.encode(ward));
				}
				
				
				studentEdit.setStudent_address(Utilities.encode(Utilities.getValue(request.getParameter("student_address"))));
				studentEdit.setStudent_nation(Utilities.encode(Utilities.getValue(request.getParameter("student_nation"))));
				
				
				
				studentEdit.setStudent_guardian_name(Utilities.encode(Utilities.getValue(request.getParameter("student_guardian_name"))));
				
				studentEdit.setStudent_guardian_job(Utilities.encode(Utilities.getValue(request.getParameter("student_guardian_job"))));
				studentEdit.setStudent_guardian_phone(Utilities.encode(Utilities.getValue(request.getParameter("student_guardian_phone"))));
				
				
				//studentEdit.setStudent_name(Utilities.encode(Utilities.getValue(request.getParameter("student_name"))));
				//studentEdit.setClasses_name(Utilities.encode(Utilities.getValue(request.getParameter("classes_name"))));
				
				studentEdit.setStudent_sex(Utilities.encode(Utilities.getValue(request.getParameter("student_sex"))));
				
				
				studentEdit.setStudent_email(Utilities.encode(Utilities.getValue(request.getParameter("student_email"))));
				studentEdit.setStudent_phone(Utilities.encode(Utilities.getValue(request.getParameter("student_phone"))));
				studentEdit.setStudent_birthday(Utilities.getDateFromString(Utilities.encode(Utilities.getValue(request.getParameter("student_birthday")))));
				if(studentEdit.getStudent_birthday() == null) {
					checkEdit = false;
				}
				
				studentEdit.setStudent_hobbis(Utilities.encode(Utilities.getValue(request.getParameter("student_hobbis"))));
				studentEdit.setStudent_priority(Utilities.encode(Utilities.getValue(request.getParameter("student_priority"))));
				studentEdit.setStudent_social_component(Utilities.encode(Utilities.getValue(request.getParameter("student_social_component"))));
				studentEdit.setStudent_exemptions(Utilities.encode(Utilities.getValue(request.getParameter("student_exemptions"))));
				
				
				
				
				if(checkEdit) {
					ConnectionPool cp = (ConnectionPool)request.getSession().getAttribute("CPool");
					if(cp == null) {
						cp = new ConnectionPool();
						request.getSession().setAttribute("CPool", cp);
					}
					
					if(StudentModel.editStudent(studentEdit, cp)) {
						response.sendRedirect("editstudent?id="+idStudent+"&rs=1");
						
					}else {
						response.sendRedirect("editstudent?id="+idStudent+"&rs=0");
					}
					
				}else {
					response.sendRedirect("editstudent?id="+idStudent+"&rs=0");
				}
			
				
			}
		}
	}

}
