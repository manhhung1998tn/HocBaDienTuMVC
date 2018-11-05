package hocba.model;




import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import hocba.dao.AccoutDAO;
import hocba.dao.ConnectionPool;
import hocba.model.object.AccoutObject;


public class UserModel{
	
	
	
	/**
	 * @author ManhHung
	 * <p>CreatDate : <p> Oct 4, 2018 - 9:46:44 PM
	 * <p>Last Updated : <p> 
	 * @param username
	 * @param pass
	 * @param request
	 * @return true if username && password exist in data - false otherwise
	 */
	public static AccoutObject checkLogin(String username, String pass, ConnectionPool cp) {
		System.out.println( "UserModel : " + username + "|" + pass);
		//Lấy CPool trong context

		AccoutDAO accoutDAO = new AccoutDAO(cp);
		
		
		AccoutObject accout = accoutDAO.getAccout(username, pass);
		
		if(accout != null) {
			accout.setAccout_logined(accout.getAccout_logined()+1);
			accout.setAccout_last_logined(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
			accoutDAO.updateLoginAccout(accout);
		}
		
		
		accoutDAO.releaseConnection();
		return accout;
	}
	
	
	
	public static void main(String[] args) {
//		AccoutDAO accoutDAO = new AccoutDAO(null);
//		AccoutObject tmp = accoutDAO.getAccout("admin", "123456");
//		if(tmp == null) {
//			System.out.println("Đăng Nhập Thất Bại");
//			
//		}else {
//			System.out.println("Thành Công");
//			System.out.println(tmp);
//		}
		
	}
	
	
	
	

}
