package hocba.model;




import hocba.dao.ConnectionPool;
import hocba.dao.TeacherDAO;
import hocba.model.object.AccoutObject;
import hocba.model.object.TeacherObject;

public class TeacherModel {
	public static TeacherObject getTeacherByAccout(AccoutObject accout, ConnectionPool cp) {
		
		
		TeacherDAO teacherDAO = new TeacherDAO(cp);

		teacherDAO.releaseConnection();
		
		return teacherDAO.getTeacherByAccout(accout.getAccout_id());
	}
	
	
	public static String infoAccoutHTML(TeacherObject teacherObject, int per) {
		String html = "<tbody>";
		html += "<tr>";
		html += "<td>Địa Chỉ Hiện Tại</td>\r\n" + 
				"<td class=\"hungdz\"><input readonly type=\"\" class=\"form-control point-studen\" name=\"student_name\" onchange=\"changePoint(this)\"  value=\""+teacherObject.getAccout_address()+"\"></td>";
		html += "</tr>";
		
		html += "<tr>";
		html += "<td>Tỉnh / TP</td>\r\n" + 
				"<td class=\"hungdz\">\r\n" + 
				"<select name=\"province\" id=\"tinh_tp\" class=\"form-control\">\r\n" + 
				"      <option value=\""+ "" +"\" selected hidden >"+ "Thái Nguyên" +"</option>\r\n" + 
				"</select>\r\n" + 
				"</td>";
		html += "</tr>";
		
		html += "<tr>";
		html += "<td>Quận Huyện</td>\r\n" + 
				"<td  class=\"hungdz\">\r\n" + 
				"<select name=\"district\" id=\"quan_huyen\" class=\"form-control\">\r\n" + 
				"      <option value=\""+ "" +"\" selected hidden >"+ "Thành Phố Thái Nguyên" +"</option>\r\n" + 
				"</select>\r\n" + 
				"</td>";
		html += "</tr>";
		
		
		html += "<tr>";
		html += "<td>Xã Phường</td>\r\n" + 
				"<td class=\"hungdz\">\r\n" + 
				"<select name=\"ward\" id=\"xa_phuong\" class=\"form-control\">\r\n" + 
				"      <option value=\""+ "" +"\" hidden selected >"+ "Phường Quang Trung" +"</option>\r\n" + 
				"</select>\r\n" + 
				"</td>";
		html += "</tr>";
		
		
		html += "<tr>";
		html += "<td>Dân Tộc</td>\r\n" + 
				"<td class=\"hungdz\"><input readonly type=\"\" class=\"form-control point-studen\" name=\"student_name\" onchange=\"changePoint(this)\"  value=\""+teacherObject.getAccout_nation()+"\"></td>";
		html += "</tr>";
		
		html += "<tr>";
		html += "<td>Tôn Giáo</td>\r\n" + 
				"<td class=\"hungdz\"><input readonly type=\"\" class=\"form-control point-studen\" name=\"student_name\" onchange=\"changePoint(this)\"  value=\""+teacherObject.getAccout_religion()+"\"></td>";
		html += "</tr>";
		
		
		
		
		
		
		html += "</tbody>";
		return html;
	}
	
	

	
}
