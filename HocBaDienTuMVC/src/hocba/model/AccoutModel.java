package hocba.model;

import java.util.ArrayList;

import hocba.dao.AccoutDAO;
import hocba.dao.ConnectionPool;
import hocba.model.object.AccoutObject;

public class AccoutModel {
	public static boolean delAccout(int id, AccoutObject accout,ConnectionPool cp) {
		AccoutDAO accoutDAO = new AccoutDAO(cp);
		AccoutObject item = new AccoutObject();
		item.setAccout_id(id);
		boolean rs = accoutDAO.delAccout(item,accout);
		
		accoutDAO.releaseConnection();
		return rs;
	}
	
	public static ArrayList<AccoutObject> getListAccout(AccoutObject acocutLogin,int page,int max,ConnectionPool cp){
		ArrayList<AccoutObject> list = null;
		AccoutDAO accoutDAO = new AccoutDAO(cp);
		AccoutObject similar = new AccoutObject();
		similar.setAccout_permission(acocutLogin.getAccout_permission());
		
		list = accoutDAO.getAccouts(similar, (page-1)*max, page*max);
		accoutDAO.releaseConnection();
		return list;
	}
	
	public static String listAccoutHTML(ArrayList<AccoutObject> list, int index) {
		String html = "";
		html += "<tbody>";
		for(AccoutObject v : list) {
			html += "<tr>\r\n" + 
					"<td style=\"width: 40px;\" ><input type=\"checkbox\" tag=\""+ v.getAccout_id() +"\"></td>\r\n" + 
					"<td>"+ (++index) +"</td>\r\n" + 
					"<td>"+ v.getAccout_created_date() +"</td>\r\n" + 
					"<td>"+ v.getAccout_name() +"</td>\r\n" + 
					"<td>"+ v.getAccout_fullname() +"</td>\r\n" + 
					"<td>"+ v.getAccout_email() +"</td>\r\n" +
					"<td>"+ v.getAccout_address() +"</td>\r\n" +
					"<td>"+ v.getAccout_logined() +"</td>\r\n" +
					//"<td>"+  +"</td>\r\n" +
						
					"<td><a href=\"delaccout?id="+v.getAccout_id()+"\" class=\"delaccout\">Xóa</a>&nbsp;&nbsp;<a href=\"infoaccout?id="+ v.getAccout_id() +"\">Chi Tiết</a></td>" + 
					"</tr>";
		}
		
		
		
		
		
		html += "</tbody>";
		return html;
	}
	
	
	public static String infoAccoutHTML(AccoutObject accoutObject, int per) {
		String html = "<tbody>";
		html += "<tr>";
		html += "<td>Họ Tên</td>\r\n" + 
				"<td class=\"hungdz\"><input readonly type=\"\" class=\"form-control point-studen\" name=\"student_name\" onchange=\"changePoint(this)\"  value=\""+accoutObject.getAccout_fullname()+"\"></td>";
		html += "</tr>";
		
		html += "<tr>";
		html += "<td>Số Điện Thoại</td>\r\n" + 
				"<td class=\"hungdz\"><input readonly type=\"\" class=\"form-control point-studen\" name=\"student_name\" onchange=\"changePoint(this)\"  value=\""+accoutObject.getAccout_mobilephone()+"\"></td>";
		html += "</tr>";
		
		html += "<tr>";
		html += "<td>Email</td>\r\n" + 
				"<td class=\"hungdz\"><input readonly type=\"\" class=\"form-control point-studen\" name=\"student_name\" onchange=\"changePoint(this)\"  value=\""+accoutObject.getAccout_email()+"\"></td>";
		html += "</tr>";
		
		html += "<tr>";
		html += "<td>Tên Tài Khoản</td>\r\n" + 
				"<td class=\"hungdz\"><input readonly type=\"\" class=\"form-control point-studen\" name=\"student_name\" onchange=\"changePoint(this)\"  value=\""+accoutObject.getAccout_name()+"\"></td>";
		html += "</tr>";
		
		
		
		html += "</tbody>";
		return html;
	}
}
