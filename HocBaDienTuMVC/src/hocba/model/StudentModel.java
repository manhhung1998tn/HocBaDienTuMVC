package hocba.model;

import java.util.ArrayList;

import com.mysql.fabric.xmlrpc.base.Array;

import hocba.dao.ConnectionPool;
import hocba.dao.StudentDAO;
import hocba.model.object.Accademic_YearObject;
import hocba.model.object.StudentObject;
import hocba.util.Utilities;


public class StudentModel {
	
	
	/**
	 * 
	 * <p>Description: </p> Lay mot mang danh sach hoc sinh theo lop hoc
	 * @author ManhHung
	 * <p>CreatDate : <p> Oct 7, 2018 - 2:03:27 AM
	 * <p>Last Updated : <p>
	 * @param idClass
	 * @param cp
	 * @return
	 */
	public static ArrayList<StudentObject> getListStudent(int idClass, ConnectionPool cp){
		ArrayList<StudentObject> list = null;
		StudentDAO studentDAO = new StudentDAO(cp);
		
		
		StudentObject similar = new StudentObject();
		similar.setRoles_java("student_class_id");
		similar.setStudent_class_id(idClass);
		list = studentDAO.getStudents(similar, 0, 0);
		
		return list;
		
	}
	
	
	public static boolean editStudent(StudentObject studentObject, ConnectionPool cp) {
		
		StudentDAO studentDAO = new StudentDAO(cp);
		
		
		return studentDAO.editStudent(studentObject);
	}
	
	public static StudentObject getStudent(int id, ConnectionPool cp) {
		StudentDAO dao = new StudentDAO(cp);
		return dao.getStudent(id);
	}
	
	public static String infoStudentHTML(ArrayList<StudentObject> list) {
		String html = "";
		int stt = 1;
		for(StudentObject v : list) {
			html += "<tr>";
			html += "<td>"+(stt)+"</td>\r\n" + 
					"<td>"+v.getStudent_name()+"</td>" +
					"<td>"+v.getStudent_id()+"</td>" +
					"<td>"+v.getStudent_phone()+"</td>" + 
					
					"<td>"+v.getStudent_email()+"</td>" +
					
					
					"<td>"+v.getStudent_guardian_name()+"</td>" +
					"<td>"+v.getStudent_guardian_phone()+"</td>" +	
					"<td><button index=\""+(stt-1)+"\" onclick=\"showInfo(this)\" id=\"\" type=\"button\" class=\"btn btn-link\" style=\"padding: 0;\" >Chi Tiết</button></td>";
			html += "<td><a href=\"editstudent?id="+v.getStudent_id()+"\" type=\"button\" class=\"btn btn-link\" style=\"padding: 0;\" >Sửa</a></td>";
			html += "</tr>";
			
			stt++;
		}
		
		
		return html;
	}
	

	
	public static String toJsonListStudent(ArrayList<StudentObject> list) {
		String html = "";
		html += "<script type=\"text/javascript\">" + "\r\nvar infoStudentArray = [\r\n";
		for(StudentObject v : list) {
			html += v + ",";
		}
		
		
		html += "\r\n];";
		html += "\r\n";
		
		html += "</script>";
		
		return html;
	}
	public static String editAddressStudent(StudentObject studentObject, int per) {
		String html = "";
		html += "<div class=\"table-responsive\">";		
		html += "<table class=\"table\">";
			html += "<thead>\r\n" + 
					"<tr>\r\n" + 
					"<td colspan=\"2\" class=\"heade-table\">Hộ Khẩu Thường Trú</td>\r\n" + 
					"</tr>\r\n" + 
					"</thead>";
						
			html += "<tbody>";
			
			
			html += "<tr>";
			html += "<td>Địa Chỉ Hiện Tại</td>\r\n" + 
					"<td class=\"hungdz\"><input type=\"\" class=\"form-control point-studen\" name=\"student_address\" onchange=\"changePoint(this)\"  value=\""+studentObject.getStudent_address()+"\"></td>";
			html += "</tr>";
			
			html += "<tr>";
			html += "<td>Tỉnh / TP</td>\r\n" + 
					"<td class=\"hungdz\">\r\n" + 
					"<select name=\"province\" id=\"tinh_tp\" class=\"form-control\">\r\n" + 
					"      <option value=\""+ studentObject.getStudent_province() +"\" selected hidden >"+ studentObject.getStudent_province() +"</option>\r\n" + 
					"</select>\r\n" + 
					"</td>";
			html += "</tr>";
			
			html += "<tr>";
			html += "<td>Quận Huyện</td>\r\n" + 
					"<td  class=\"hungdz\">\r\n" + 
					"<select name=\"district\" id=\"quan_huyen\" class=\"form-control\">\r\n" + 
					"      <option value=\""+ studentObject.getStudent_district() +"\" selected hidden >"+ studentObject.getStudent_district() +"</option>\r\n" + 
					"</select>\r\n" + 
					"</td>";
			html += "</tr>";
			
			
			html += "<tr>";
			html += "<td>Xã Phường</td>\r\n" + 
					"<td class=\"hungdz\">\r\n" + 
					"<select name=\"ward\" id=\"xa_phuong\" class=\"form-control\">\r\n" + 
					"      <option value=\""+ studentObject.getStudent_ward() +"\" hidden selected >"+ studentObject.getStudent_ward() +"</option>\r\n" + 
					"</select>\r\n" + 
					"</td>";
			html += "</tr>";
			


			html += "<tr>";
			html += "<td>Dân Tộc</td>\r\n" + 
					"<td class=\"hungdz\"><input type=\"\" class=\"form-control point-studen\" name=\"student_nation\" onchange=\"changePoint(this)\" value=\""+studentObject.getStudent_nation()+"\" ></td>";
			html += "</tr>";
			
			html += "<input name=\"student_id\" value=\""+ studentObject.getStudent_id() +"\" type=\"hidden\" />";
			
		
			
			html += "</tbody>";
		html +="</table>";
	html += "</div>";
		
		return html;
	}
	
	public static String editGuardianStudent(StudentObject studentObject, int per) {
		String html = "";
		html += "<div class=\"table-responsive\">";		
		html += "<table class=\"table\">";
			html += "<thead>\r\n" + 
					"<tr>\r\n" + 
					"<td colspan=\"2\" class=\"heade-table\">Thông Tin Người Giám Hộ</td>\r\n" + 
					"</tr>\r\n" + 
					"</thead>";
				
			html += "<tbody>";
			
			html += "<tr>";
			html += "<td>Họ Tên</td>\r\n" + 
					"<td class=\"hungdz\"><input type=\"\" class=\"form-control point-studen\" name=\"student_guardian_name\" onchange=\"changePoint(this)\"  value=\""+studentObject.getStudent_guardian_name()+"\"></td>";
			html += "</tr>";
				
			
			
			html += "<tr>";
			html += "<td>Nghề Nghiệp</td>\r\n" + 
					"<td class=\"hungdz\"><input type=\"\" class=\"form-control point-studen\" name=\"student_guardian_job\" onchange=\"changePoint(this)\"  value=\""+studentObject.getStudent_guardian_job()+"\"></td>";
			html += "</tr>";			
			
			html += "<tr>";
			html += "<td>Số Điện Thoại</td>\r\n" + 
					"<td class=\"hungdz\"><input type=\"\" class=\"form-control point-studen\" name=\"student_guardian_phone\" onchange=\"changePoint(this)\"  value=\""+studentObject.getStudent_guardian_phone()+"\"></td>";
			html += "</tr>";
			
			
			
			
			html += "</tbody>";
		html +="</table>";
	html += "</div>";
		
		return html;
	}
	
	public static String editInfoStudent(StudentObject studentObject, int per) {
		String html = "";
		html += "<div class=\"table-responsive\">";		
		html += "<table class=\"table\">";
			html += "<thead>\r\n" + 
					"<tr>\r\n" + 
					"<td colspan=\"2\" class=\"heade-table\">Thông Tin Học Sinh</td>\r\n" + 
					"</tr>\r\n" + 
					"</thead>";
			
			html += "<tbody>";
			
			html += "<tr>";
			html += "<td>Họ Tên</td>\r\n" + 
					"<td class=\"hungdz\"><input readonly type=\"\" class=\"form-control point-studen\" name=\"student_name\" onchange=\"changePoint(this)\"  value=\""+studentObject.getStudent_name()+"\"></td>";
			html += "</tr>";	
			
			
			html += "<tr>";
			html += "<td>Lớp </td>\r\n" + 
					"<td class=\"hungdz\"><input readonly type=\"\" class=\"form-control point-studen\" name=\"classes_name\" onchange=\"changePoint(this)\"  value=\""+studentObject.getClasses_name()+"\"></td>";
			html += "</tr>";
			
			
			

			html += "<tr>";
			html += "<td>Giới Tính</td>\r\n" + 
					"<td class=\"hungdz\">\r\n" + 
					"<select id=\"student_sex\" name=\"student_sex\" class=\"form-control\">\r\n" + 
					"      <option value=\""+ studentObject.getStudent_sex() +"\" selected >"+ studentObject.getStudent_sex() +"</option>\r\n" + 
					"</select>\r\n" + 
					"</td>";
			html += "</tr>";
			
			html += "<tr>";
			html += "<td>Email Học Sinh</td>\r\n" + 
					"<td class=\"hungdz\"><input type=\"\" class=\"form-control point-studen\" name=\"student_email\" onchange=\"changePoint(this)\"  value=\""+studentObject.getStudent_email()+"\"></td>";
			html += "</tr>";	
			
			
			html += "<tr>";
			html += "<td>Số Điện Thoại</td>\r\n" + 
					"<td class=\"hungdz\"><input type=\"\" class=\"form-control point-studen\" name=\"student_phone\" onchange=\"changePoint(this)\"  value=\""+studentObject.getStudent_phone()+"\"></td>";
			html += "</tr>";	
			
			
			html += "<tr>";
			html += "<td>Ngày Sinh</td>\r\n" + 
					"<td class=\"hungdz\"><input type=\"date\" class=\"form-control point-studen\" name=\"student_birthday\" onchange=\"changePoint(this)\"  value=\""+ Utilities.coverDateForHTML(studentObject.getStudent_birthday())+"\"></td>";
			html += "</tr>";
			
			
			
			html += "<tr>";
			html += "<td>Sở Thích</td>\r\n" + 
					"<td class=\"hungdz\"><input type=\"\" class=\"form-control point-studen\" name=\"student_hobbis\" onchange=\"changePoint(this)\"  value=\""+studentObject.getStudent_hobbis()+"\"></td>";
			html += "</tr>";
			
			
			
			html += "<tr>";
			html += "<td>Đối Tượng Yêu Tiên</td>\r\n" + 
					"<td class=\"hungdz\"><input type=\"\" class=\"form-control point-studen\" name=\"student_priority\" onchange=\"changePoint(this)\"  value=\""+studentObject.getStudent_priority()+"\"></td>";
			html += "</tr>";
			
			
			
			
			html += "<tr>";
			html += "<td>Thành Phần Xã Hội</td>\r\n" + 
					"<td class=\"hungdz\"><input type=\"\" class=\"form-control point-studen\" name=\"student_social_component\" onchange=\"changePoint(this)\"  value=\""+studentObject.getStudent_social_component()+"\"></td>";
			html += "</tr>";
			
			
			html += "<tr>";
			html += "<td>Đối Tượng Miễm Giảm</td>\r\n" + 
					"<td class=\"hungdz\"><input type=\"\" class=\"form-control point-studen\" name=\"student_exemptions\" onchange=\"changePoint(this)\" value=\""+studentObject.getStudent_exemptions()+"\"  ></td>";
			html += "</tr>";
			
			
			
		
			
			
		
			html += "</tbody>";
		html +="</table>";
	html += "</div>";
		return html;
	}
	
	public static String editStudent(StudentObject studentObject, int per) {
		String html = "<div class=\"col-md-6 col-sm-12 tab-content-left\">";
			html += "<div class=\"panel panel-default\">";
				html += "<div class=\"panel-body\">";
					
				html += "</div>";
			html += "</div>";
		html += "</div>";
		
		
		
		
		html += "<div class=\"col-md-6 col-sm-12 tab-content-right\">";
		html += "<div class=\"panel panel-default\">";
			html += "<div class=\"panel-body\">";
				html += StudentModel.editAddressStudent(studentObject, per);
			html += "</div>";
		html += "</div>";
	html += "</div>";
		return html;
	}
	
	public static void main(String[] args) {
		String str = "Nguy&#7877;n M&#7841;nh H&ugrave;ng";
		
	}
	
	
	
	
	
	
	
	
}
