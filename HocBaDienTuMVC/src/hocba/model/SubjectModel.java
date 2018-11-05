package hocba.model;

import java.util.ArrayList;

import com.mysql.fabric.xmlrpc.base.Array;

import hocba.dao.ClassesDAO;
import hocba.dao.ConnectionPool;
import hocba.dao.SubjectDAO;
import hocba.model.object.ClassesObject;
import hocba.model.object.SubjectObject;
import hocba.model.object.TeacherObject;
import hocba.util.Utilities;

public class SubjectModel {
	
	public static ArrayList<Integer> updateListSubject(ArrayList<SubjectObject> list, ArrayList<Integer> indexUpdate,int term, ConnectionPool cp) {
		ArrayList<Integer> indexErr = new ArrayList<>();
		SubjectDAO subjectDAO = new SubjectDAO(cp);
		
		for(Integer v : indexUpdate) {
			
			if(!subjectDAO.editSubjectByTeacher(list.get(v), term)) {
				indexErr.add(v);
			}
		}
		
		subjectDAO.releaseConnection();
		
		return indexErr;
	}
	
	public static ArrayList<String> getSubjectName(TeacherObject teacherObject, ClassesObject classesObject ,ConnectionPool cp){
		
		ArrayList<String> list = null;
		SubjectDAO subjectDAO = new SubjectDAO(cp);
		list = subjectDAO.getNameSubjectsByTeacher(teacherObject, classesObject);
		
		
		
		subjectDAO.releaseConnection();
		return list;
	}
	
	public static boolean checkScore(short score) {
		if(score < 0) {
			return false;
		}
		
		if(score > 1000) {
			return false;
		}
		return true;
	}
	
	public static String scoreToString(short score) {
		if(score == -1) {
			return "";
		}
		String tmp = String.valueOf((score / (double)100));
		
		return tmp;
	}
	
	
	public static ArrayList<SubjectObject> getListSubject(TeacherObject teacherObject, ClassesObject classesObject,String subject_name,ConnectionPool cp){
		ArrayList<SubjectObject> list = null;
		
		ClassesDAO classesDAO = new ClassesDAO(cp);
		int coursemax = classesDAO.getMaxCourse();
		classesDAO.releaseConnection();
		
		
		SubjectDAO subjectDAO = new SubjectDAO(cp);
		String accademic_year_name = "";
		int tmp = coursemax - classesObject.getClasses_course();
		if(tmp == 0) {
			accademic_year_name = "1";
		}else if(tmp == 1) {
			accademic_year_name = "2";
		}else if(tmp == 2) {
			accademic_year_name = "3";
		}else {
			accademic_year_name = "-1";
		}
		
		
		
		
		list = subjectDAO.getListSubject(teacherObject, classesObject,subject_name, accademic_year_name);
		
		subjectDAO.releaseConnection();
		return list;
	}
	
	
	public static String subjectNameHTML(ArrayList<String> list, int selected){
		String tmp1 = "selected";
		if(selected != -1) {
			tmp1 = "";
		}
		
		String html = "";
		System.out.println("selected subject name : " + selected);
		int i = 0;
		if(list != null) {
			
			
			
			for(String v : list) {
				if(selected == i) {
					html += "<option selected value=\""+i+"\">"+v+"</option>";
					
				}else {
					html += "<option  value=\""+i+"\">"+v+"</option>";
				}
				i++;
			}
			
		}
		

		
		
		html += " <option value=\"\" disabled "+tmp1+" hidden >Chọn Môn</option>";
		return html;
	}
	
	
	/**
	 * 
	 * <p>Description: </p>
	 * @author ManhHung
	 * <p>CreatDate : <p> Oct 22, 2018 - 6:07:07 PM
	 * <p>Last Updated : <p>
	 * @param list
	 * @param typescore  0 - all , 1 - 15p , 2 - 45p , 3 - test
	 * @return
	 */
	public static String subjectHTML(ArrayList<SubjectObject> list, int typescore) {
		
		String readonly = "readonly";
		String tongquan = "readonly";
		if(typescore != 0) {
			tongquan = "";
		}
		
		
		String term1 = " <table style = \"display:none\" class=\"table table-striped table-bordered table-hover\" id=\"term-1\" >";
		String term2 = "";
		term2 += " <table style = \"display:none\" class=\"table table-striped table-bordered table-hover\" id=\"term-2\" >";
		String average = " <table style = \"display:none\" class=\"table table-striped table-bordered table-hover\" id=\"average\" >";
		term1 += "";
		term2 += "";
		average += "";
		
		term1 += "<thead>\r\n" + 
				"<tr>\r\n" + 
				"<th>Họ Tên</th>\r\n" + 
				"<th>Mã HS</th>\r\n";
		
		if(typescore == 0 || typescore == 1) {
			term1 += "<th>Điểm 15p</th>\r\n";
		}
		
		if(typescore == 0 || typescore == 2) {
			term1 +="<th>KT 1 tiết lần 1</th>\r\n" + 
					"<th>KT 1 tiết lần 2</th>\r\n";
		}
		
		if(typescore == 0 || typescore == 3) {
			term1 += "<th>Điểm Thi</th>\r\n";
		}
		
		if(typescore == 0) {
			term1 += "<th>Trung Bình Môn</th>\r\n";					
			term1 += "<th>Tổng Kết HK</th>\r\n";
			
		}
		
		term1 += "\r\n" + 
				"</tr>\r\n" + 
				"</thead></tbody>";
		
		//ky 2
	
		term2 += "<thead>\r\n" + 
				"<tr>\r\n" + 
				"<th>Họ Tên</th>\r\n" + 
				"<th>Mã HS</th>\r\n";
		if(typescore == 0 || typescore == 1) {
			term2 += "<th>Điểm 15p</th>\r\n";
		}
		
		if(typescore == 0 || typescore == 2) {
			term2 +="<th>KT 1 tiết lần 1</th>\r\n" + 
					"<th>KT 1 tiết lần 2</th>\r\n";
		}
		
		if(typescore == 0 || typescore == 3) {
			term2 += "<th>Điểm Thi</th>\r\n";	
		}
		
		if(typescore == 0) {
			term2 += "<th>Trung Bình Môn</th>\r\n";
			term2 += "<th>Tổng Kết HK</th>\r\n";
			
		}
		term2 += "\r\n" + 
				"</tr>\r\n" + 
				"</thead></tbody>";
		

		// trung binh mon
		
		
		average += "<thead>\r\n" + 
				"<tr>\r\n" + 
				"<th>Họ Tên</th>\r\n" + 
				"<th>Mã HS</th>\r\n" + 
				"<th>Điêm Kỳ 1</th>\r\n" + 
				"<th>Điểm Kỳ 2</th>\r\n" + 
				"<th>Tổng Kết</th>\r\n" + 
				"<th>Nhận Xét</th>\r\n" + 
				"</tr>\r\n" + 
				"</thead></tbody>";
		int i = 0;
		for(SubjectObject v : list) {
			
			
			
			term1 += "<tr>\r\n" + 
					"<td>"+ v.getStudent().getStudent_name() +"</td>\r\n" + 
					"<td>"+ v.getStudent().getStudent_id() +"</td>\r\n";
	
					 
					
					
			if(typescore == 0 || typescore == 1) {
				term1 += " <td class=\"inData dataScore\">"
						+ "<input type=\"\" value=\""+ SubjectModel.scoreToString(v.getSubject_term1_score_15()) +"\" class=\"form-control point-studen\" name=\"term1_score_15_"+ i +"\" onchange=\"changePoint(this)\"></td>\r\n";
			}
			
			if(typescore == 0 || typescore == 2) {
				term1 +=" <td class=\"inData dataScore\">"
						+ "<input type=\"\" value=\""+ SubjectModel.scoreToString(v.getSubject_term1_score_45_1()) +"\" class=\"form-control point-studen\" name=\"term1_score_45_1_"+ i +"\" onchange=\"changePoint(this)\"></td>\r\n" + 
					" <td class=\"inData dataScore\">"
						+ "<input type=\"\" value=\""+ SubjectModel.scoreToString(v.getSubject_term1_score_45_2()) +"\" class=\"form-control point-studen\" name=\"term1_score_45_2_"+ i +"\" onchange=\"changePoint(this)\"></td>\r\n";
			}
			
			if(typescore == 0 || typescore == 3) {
				term1 += " <td class=\"inData dataScore\">"
						+ "<input  type=\"\" value=\""+ SubjectModel.scoreToString(v.getSubject_term1_score_test()) +"\" class=\"form-control point-studen\" name=\"term1_score_test_"+ i +"\" onchange=\"changePoint(this)\"></td>\r\n";	
			}
			
			if(typescore == 0) {
				term1 += " <td class=\"inData dataScore\">"
						+ "<input "+ readonly +" type=\"\" value=\""+  SubjectModel.scoreToString(v.getSubject_term1_score_average()) +"\" class=\"form-control point-studen\" name=\"term1_score_average_"+ i +"\" onchange=\"changePoint(this)\"></td>\r\n" + 
					 
					" <td class=\"inData dataScore\">"
						+ "<input "+ readonly +" type=\"\" value=\""+ SubjectModel.scoreToString(v.getSubject_term1_score_final()) +"\" class=\"form-control point-studen\" name=\"term1_score_final_"+ i +"\" onchange=\"changePoint(this)\"></td>\r\n" + 
					"<input type=\"hidden\" id=\"custId\" name=\"term1_"+ i +"\" value=\""+ v.getSubject_id() +"\">" ;
				
			}
			
			term1 += "</tr>";
			
	
			
			
			// ky 2		
			term2 += "<tr>\r\n" + 
					"<td>"+ v.getStudent().getStudent_name() +"</td>\r\n" + 
					"<td>"+ v.getStudent().getStudent_id() +"</td>\r\n";

					
					 
					
			
			if(typescore == 0 || typescore == 1) {
				term2 += " <td class=\"inData dataScore\">"
						+ "<input type=\"\" value=\""+ SubjectModel.scoreToString(v.getSubject_term2_score_15()) +"\" class=\"form-control point-studen\" name=\"term2_score_15_"+ i +"\" onchange=\"changePoint(this)\"></td>\r\n";
			}
			
			if(typescore == 0 || typescore == 2) {
				term2 +=" <td class=\"inData dataScore\">"
						+ "<input type=\"\" value=\""+ SubjectModel.scoreToString(v.getSubject_term2_score_45_1()) +"\" class=\"form-control point-studen\" name=\"term2_score_45_1_"+ i +"\" onchange=\"changePoint(this)\"></td>\r\n" + 
					" <td class=\"inData dataScore\">"
						+ "<input type=\"\" value=\""+ SubjectModel.scoreToString(v.getSubject_term2_score_45_2()) +"\" class=\"form-control point-studen\" name=\"term2_score_45_2_"+ i +"\" onchange=\"changePoint(this)\"></td>\r\n";
			}
			
			if(typescore == 0 || typescore == 3) {
				term2 += " <td class=\"inData dataScore\">"
						+ "<input type=\"\" value=\""+ SubjectModel.scoreToString(v.getSubject_term2_score_test()) +"\" class=\"form-control point-studen\" name=\"term2_score_test_"+i +"\" onchange=\"changePoint(this)\"></td>\r\n";	
			}
			
			if(typescore == 0) {
				term2 += " <td  class=\"inData dataScore\">"
						+ "<input "+ readonly +" type=\"\" value=\""+  SubjectModel.scoreToString(v.getSubject_term2_score_average()) +"\" class=\"form-control point-studen\" name=\"term2_score_average_"+ i +"\" onchange=\"changePoint(this)\"></td>\r\n" +  
					" <td class=\"inData dataScore\">"
						+ "<input "+ readonly +" type=\"\" value=\""+ SubjectModel.scoreToString(v.getSubject_term2_score_final()) +"\" class=\"form-control point-studen\" name=\"term2_score_final_"+ i +"\" onchange=\"changePoint(this)\"></td>\r\n";
					

				
			}
			
			term2 += "</tr>";

			
			// trung binh
			average += "<tr>\r\n" + 
					"<td>"+ v.getStudent().getStudent_name() +"</td>\r\n" + 
					"<td>"+ v.getStudent().getStudent_id() +"</td>\r\n" + 
					" <td class=\"inData dataScore\">"
						+ "<input "+ readonly +" type=\"\" value=\""+ SubjectModel.scoreToString(v.getSubject_term1_score_final()) +"\" class=\"form-control point-studen\" name=\"\" onchange=\"changePoint(this)\"></td>\r\n" + 
				
					" <td class=\"inData dataScore\">"
						+ "<input "+ readonly +" type=\"\" value=\""+ SubjectModel.scoreToString(v.getSubject_term2_score_final()) +"\" class=\"form-control point-studen\" name=\"\" onchange=\"changePoint(this)\"></td>\r\n" + 
				
					" <td class=\"inData dataScore\">"
					+ "<input "+ readonly +" type=\"\" value=\""+ SubjectModel.scoreToString(v.getSubject_score()) +"\" class=\"form-control point-studen\" name=\"\" onchange=\"changePoint(this)\"></td>\r\n" + 

					"<td class=\"inData\"><input value=\""+ v.getSubject_notes() +"\" type=\"\" class=\"form-control point-studen\" name=\"notes_"+ i +"\" onchange=\"changePoint(this)\"></td>\r\n" + 					
					"</tr>";
			
			
			average+= "<input type=\"hidden\" id=\"custId\" name=\"idsubject"+ i +"\" value=\""+ v.getSubject_id() +"\">";
			
			
			i++;
		}
		
		
		term1 += " </tbody></table>";
		term2 += " </tbody></table>";
		average += " </tbody></table>";
		
		
		return term1 + term2 + average;
	}
	
	public static void main(String [] args) {
		String str = SubjectModel.scoreToString((short)1234);
		System.out.println("cover : " + str);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
