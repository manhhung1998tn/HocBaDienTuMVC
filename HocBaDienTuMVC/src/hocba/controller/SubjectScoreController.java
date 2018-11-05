package hocba.controller;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.xmlrpc.base.Array;
import com.sun.xml.internal.bind.v2.model.util.ArrayInfoUtil;

import hocba.dao.ConnectionPool;
import hocba.dao.SubjectDAO;
import hocba.dao.TeacherDAO;
import hocba.model.ClassesModel;
import hocba.model.SubjectModel;
import hocba.model.TeacherModel;
import hocba.model.object.AccoutObject;
import hocba.model.object.ClassesObject;
import hocba.model.object.StudentObject;
import hocba.model.object.SubjectObject;
import hocba.model.object.TeacherObject;
import hocba.util.Utilities;

/**
 * Servlet implementation class SubjectPointController
 */


public class SubjectScoreController extends HttpServlet {
	private ArrayList<ClassesObject> listClass;
	private static final long serialVersionUID = 1L;
    private TeacherObject teacherObject;
    private ArrayList<String> listSubjectName;
    private int indexClassName;
    private int indexSubjectName;
    private ArrayList<SubjectObject> listSubject;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectScoreController() {
    	
        super();
        // TODO Auto-generated constructor stub
        listClass = null;
        teacherObject = null;
        listSubjectName = null;
        indexClassName = -1;
        indexSubjectName = -1;
        listSubject = null;
       
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
			
			
			teacherObject = TeacherModel.getTeacherByAccout(accout, cp);
			//Kiem tra xem co phai giao vien hay k
			if(teacherObject != null) {
				//include jsp
				
				//Lay lop 
				listClass = ClassesModel.getClassByTeacherSubject(teacherObject,3, cp);
				
					
				

				
				
					request.getSession().setAttribute("slClassSubject", ClassesModel.classNameHTML(listClass, indexClassName));
					
					request.getSession().setAttribute("slSubjectName",SubjectModel.subjectNameHTML(listSubjectName, indexSubjectName));
					RequestDispatcher dispatcher = request.getRequestDispatcher("/view/subject-score.jsp");
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
		request.setCharacterEncoding("UTF-8");
		String errsl = "";
		AccoutObject accout = (AccoutObject)request.getSession().getAttribute("UserLogin");
		// check login
		if(accout == null) {
			response.sendRedirect("login");
		}else {
			int custId =  Utilities.getIntParameter(request, "custId");
			
			System.out.println("custId : " + custId);
			if(custId != -1) {
				int termSubject = Utilities.getIntParameter(request, "termSubject");
				
				int typeScore = Utilities.getIntParameter(request, "typeScore");
				System.out.println("typeScore : " + typeScore);
				
				if(termSubject == -1) {
					termSubject = 0;
				}

				if(typeScore == -1) {
					typeScore = 0;
				}
				
				request.getSession().setAttribute("termSubject",String.valueOf(termSubject));
				request.getSession().setAttribute("typeScore",String.valueOf(typeScore));
				
				ArrayList<String> errList = new ArrayList<>();
				ConnectionPool cp = (ConnectionPool)request.getSession().getAttribute("CPool");
				if(cp == null) {
					cp = new ConnectionPool();
					request.getSession().setAttribute("CPool", cp);
				}
				
				
				
				boolean checksl = false;
				if(custId == 1) {
					checksl = true;
					request.getSession().removeAttribute("tbSubject");
					request.getSession().setAttribute("slSubjectName",SubjectModel.subjectNameHTML(null, -1));
					if(listClass != null) {
						
						
						indexClassName = Utilities.getIntParameter(request, "classSubject");
						if(indexClassName >= 0 && indexClassName < listClass.size()) {
							listSubjectName = SubjectModel.getSubjectName(teacherObject, listClass.get(indexClassName), cp);
							indexSubjectName = -1;
							
							request.getSession().setAttribute("slClassSubject", ClassesModel.classNameHTML(listClass, indexClassName));
							request.getSession().setAttribute("slSubjectName", SubjectModel.subjectNameHTML(listSubjectName, indexSubjectName));
						}else {
							indexClassName = -1;
							errsl = "home?parraerr=classsubject";
							System.out.println("Lỗi Không có classubject phù hợp");
							
						}	
					}
				
					
					
				}
				if(custId == 2) {
					
					checksl = true;
					if( indexClassName != -1 && listSubjectName != null && listClass != null) {
						request.getSession().removeAttribute("tbSubject");
						indexSubjectName = Utilities.getIntParameter(request, "subjectSubject");
						if(indexSubjectName < listSubjectName.size() && indexSubjectName >= 0) {
							listSubject = SubjectModel.getListSubject(teacherObject, listClass.get(indexClassName),listSubjectName.get(indexSubjectName), cp);
							request.getSession().setAttribute("slClassSubject", ClassesModel.classNameHTML(listClass, indexClassName));
							
							request.getSession().setAttribute("slSubjectName",SubjectModel.subjectNameHTML(listSubjectName, indexSubjectName));
							
							
							request.getSession().setAttribute("tbSubject", SubjectModel.subjectHTML(listSubject, typeScore));
						}else {
							errsl = "home?parraerr=subjectname";
							
						}
					}
					
	
				}
				
			
				
			
					
			
				
				if(custId == 3) {
					System.out.println("Vao custID 3");
					if(listSubject != null) {
						System.out.println("Vao list != null");
						
					
						int i = 0;
						SubjectObject item;
						ArrayList<Integer> indexUpdate = new ArrayList<>();
						for(SubjectObject v : listSubject) {
							
							
							
						
							
								boolean updateaverage = false;;
								boolean updatefinal = false;
								item = new SubjectObject(v);
								short subject_term1_score_15 = (short)Utilities.getScoreParameter(request, "term1_score_15" + "_" + i);
								short subject_term1_score_45_1 = (short)Utilities.getScoreParameter(request, "term1_score_45_1" + "_" + i);
								short subject_term1_score_45_2 = (short)Utilities.getScoreParameter(request, "term1_score_45_2" + "_" + i);
								//short subject_term1_score_average = (short)Utilities.getScoreParameter(request, "term1_score_average" + "_" + i);
								short subject_term1_score_test = (short)Utilities.getScoreParameter(request, "term1_score_test" + "_" + i);
								//short subject_term1_score_final =  (short)Utilities.getScoreParameter(request, "term1_score_final" + "_" + i);
								if(subject_term1_score_15 != -1 && subject_term1_score_15 != v.getSubject_term1_score_15()) {
									v.setSubject_term1_score_15(subject_term1_score_15);
									updateaverage = true;
								}
								
								if(subject_term1_score_45_1 != -1 && subject_term1_score_45_1 != v.getSubject_term1_score_45_1()) {
									v.setSubject_term1_score_45_1(subject_term1_score_45_1);
									updateaverage = true;
								}
								
								if(subject_term1_score_45_2 != -1 && subject_term1_score_45_2 != v.getSubject_term1_score_45_2()) {
									v.setSubject_term1_score_45_2(subject_term1_score_45_2);
									updateaverage = true;
								}
								
								
								if(v.getSubject_term1_score_45_1() != -1 && v.getSubject_term1_score_45_2() != -1 && v.getSubject_term1_score_15() != -1 && updateaverage) {
									v.setSubject_term1_score_average(Utilities.averageScore(v.getSubject_term1_score_15(), v.getSubject_term1_score_45_1(), v.getSubject_term1_score_45_2()));
								}
								
								if(subject_term1_score_test != -1 && subject_term1_score_test != v.getSubject_term1_score_test()) {
									v.setSubject_term1_score_test(subject_term1_score_test);
									updatefinal = true;
								}
								
								if(updatefinal && v.getSubject_term1_score_average() != -1) {
									v.setSubject_term1_score_final(Utilities.finalScore(v.getSubject_term1_score_test(), v.getSubject_term1_score_average()));
									
									//tinh diem tong ket ca nam
									if(v.getSubject_term2_score_average() != -1) {
										v.setSubject_score(Utilities.finalScore(v.getSubject_term2_score_average(), v.getSubject_term1_score_average()));
									}
								}
								
								if(updatefinal || updateaverage) {
									System.out.println("id subject " + listSubject.get(i).getSubject_id() + " chuẩn bị update");
									indexUpdate.add(i);
								}
								
								
								
								
							
					
							
							i++;
						}//END FOR
						
						if(indexUpdate.size() > 0) {
							
							ArrayList<Integer> indexErr = SubjectModel.updateListSubject(listSubject, indexUpdate,1, cp);
							if(indexErr.size() == 0) {
								errList.add("update=true");
								System.out.println("all subject update successful");
								request.getSession().setAttribute("tbSubject", SubjectModel.subjectHTML(listSubject, typeScore));
							}else {
								if(indexUpdate.size() == indexErr.size()) {
									errList.add("update=falseall");
									System.out.println("all subject update failed");
								}else {
									errList.add("update=false");
									System.out.println( indexErr.size() +  " subject update failed");
									request.getSession().setAttribute("tbSubject", SubjectModel.subjectHTML(listSubject, typeScore));
								}

							}
							
						}else {
							errList.add("notthingupdate=1");
						}
						
						
					}
				}
				if(custId == 4) {
					System.out.println("Vao custID 4");
					if(listSubject != null) {

						int i = 0;
						
						ArrayList<Integer> indexUpdate = new ArrayList<>();
						for(SubjectObject v : listSubject) {
							
							
							
								boolean updateaverage = false;
								boolean updatefinal = false;
								
								short subject_term2_score_15 = (short)Utilities.getScoreParameter(request, "term2_score_15" + "_" + i);
								short subject_term2_score_45_1 = (short)Utilities.getScoreParameter(request, "term2_score_45_1" + "_" + i);
								short subject_term2_score_45_2 = (short)Utilities.getScoreParameter(request, "term2_score_45_2" + "_" + i);
								//short subject_term2_score_average = (short)Utilities.getScoreParameter(request, "term2_score_average" + "_" + i);
								short subject_term2_score_test = (short)Utilities.getScoreParameter(request, "term2_score_test" + "_" + i);
								System.out.println("subject_term2_score_test : " + subject_term2_score_test);
								//short subject_term2_score_final =  (short)Utilities.getScoreParameter(request, "term2_score_final" + "_" + i);
								
								if(subject_term2_score_15 != -1 && subject_term2_score_15 != v.getSubject_term2_score_15()) {
									v.setSubject_term2_score_15(subject_term2_score_15);
									updateaverage = true;
								}
								
								if(subject_term2_score_45_1 != -1 && subject_term2_score_45_1 != v.getSubject_term2_score_45_1()) {
									v.setSubject_term2_score_45_1(subject_term2_score_45_1);
									updateaverage = true;
								}
								
								if(subject_term2_score_45_2 != -1 && subject_term2_score_45_2 != v.getSubject_term2_score_45_2()) {
									v.setSubject_term2_score_45_2(subject_term2_score_45_2);
									updateaverage = true;
								}
								
								
								if(v.getSubject_term2_score_45_1() != -1 && v.getSubject_term2_score_45_2() != -1 && v.getSubject_term2_score_15() != -1 && updateaverage) {
									v.setSubject_term2_score_average(Utilities.averageScore(v.getSubject_term2_score_15(), v.getSubject_term2_score_45_1(), v.getSubject_term2_score_45_2()));
								}
								
								if(subject_term2_score_test != -1 && subject_term2_score_test != v.getSubject_term2_score_test()) {
									v.setSubject_term2_score_test(subject_term2_score_test);
									updatefinal = true;
								}
								
								if(updatefinal && v.getSubject_term2_score_average() != -1) {
									
									v.setSubject_term2_score_final(Utilities.finalScore(v.getSubject_term2_score_test(), v.getSubject_term2_score_average()));
									
									//tinh diem tong ket ca nam
									if(v.getSubject_term2_score_average() != -1) {
										v.setSubject_score(Utilities.finalScore(v.getSubject_term2_score_average(), v.getSubject_term1_score_average()));
									}

								}
								
								if(updatefinal || updateaverage) {
									System.out.println("id subject " + listSubject.get(i).getSubject_id() + " chuẩn bị update");
									indexUpdate.add(i);
								}
								
								
								
								
							
							
							
							i++;
							
							
							
						}// END FOR
						
						if(indexUpdate.size() > 0) {
							
							ArrayList<Integer> indexErr = SubjectModel.updateListSubject(listSubject, indexUpdate,2, cp);
							if(indexErr.size() == 0) {
								errList.add("update=true");
								System.out.println("all subject update successful");
								request.getSession().setAttribute("tbSubject", SubjectModel.subjectHTML(listSubject, typeScore));
							}else {
								if(indexUpdate.size() == indexErr.size()) {
									errList.add("update=falseall");
									System.out.println("all subject update failed");
								}else {
									errList.add("update=false");
									System.out.println( indexErr.size() +  " subject update failed");
									request.getSession().setAttribute("tbSubject", SubjectModel.subjectHTML(listSubject, typeScore));
								}

							}
							
						}else {
							errList.add("notthingupdate=1");
						}
						
						
					}
					
				}
				if(custId == 5) {
					System.out.println("Vao custID 5");
					if(listSubject != null) {
						System.out.println("Vao list != null");
			
						int i = 0;
					
						ArrayList<Integer> indexUpdate = new ArrayList<>();
						for(SubjectObject v : listSubject) {
							
							
							
							
					
						
								boolean isUpdate = false;
								String notes = Utilities.encode(Utilities.getValue(request.getParameter("notes_" + i)));
								System.out.println( "notes : " + notes);
								if(notes != v.getSubject_notes()) {
									v.setSubject_notes(notes);
									isUpdate = true;
								}
								
								if(isUpdate) {
									indexUpdate.add(i);
								}
								
								
								
								
							
						
							
							i++;
						} // END FOR
						
						
						if(indexUpdate.size() > 0) {
							
							ArrayList<Integer> indexErr = SubjectModel.updateListSubject(listSubject, indexUpdate,3, cp);
							if(indexErr.size() == 0) {
								errList.add("update=true");
								System.out.println("all subject update successful");
								request.getSession().setAttribute("tbSubject", SubjectModel.subjectHTML(listSubject, typeScore));
							}else {
								if(indexUpdate.size() == indexErr.size()) {
									errList.add("update=falseall");
									System.out.println("all subject update failed");
								}else {
									errList.add("update=false");
									System.out.println( indexErr.size() +  " subject update failed");
									request.getSession().setAttribute("tbSubject", SubjectModel.subjectHTML(listSubject, typeScore));
								}

							}
							
						}else {
							errList.add("notthingupdate=1");
						}
						
						
					}
				}
				
//				String html = ClassesModel.classNameHTML(listClass, Utilities.getIntParameter(request, "classSubject"));
//				request.getSession().setAttribute("slClassSubject", html);
//	
//				html = SubjectModel.subjectNameHTML(listSubjectName, Utilities.getIntParameter(request, "subjectSubject"));
//				request.getSession().setAttribute("slSubjectName", html);
				
				if(!checksl) {
					
//					if(errList.size() > 0) {
//						String err = "";
//						for(String v : errList) {
//							err += v + "&";
//						}
//						response.sendRedirect("subject?" + err);
//						
//					}else {
//						
//					}
					RequestDispatcher dispatcher = request.getRequestDispatcher("/view/subject-score.jsp");
					dispatcher.forward(request, response);
				}else {
					
					System.out.println("Không vào selet");
					if(!errsl.equals("")) {
						response.sendRedirect(errsl);
						
					}else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("/view/subject-score.jsp");
						dispatcher.forward(request, response);
					}
				}
				
				
				
				
				
			}else {
				response.sendRedirect("home?parraerr=custId");
			}
			
			
			
			
		
			
			
			
		}
		
		
	}

}
