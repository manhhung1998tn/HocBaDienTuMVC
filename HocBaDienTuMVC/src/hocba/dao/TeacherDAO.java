package hocba.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hocba.model.object.TeacherObject;


public class TeacherDAO extends BasicDAO{

	

	public TeacherDAO(ConnectionPool cp) {
		super(cp, "Teacher");
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @author ManhHung
	 * <p>CreatDate : <p> Oct 2, 2018 - 2:17:59 AM
	 * <p>Last Updated : <p>
	 */
	public boolean addTeacher(TeacherObject item) {
		
		// TODO Auto-generated method stub
		String sql = "";
		sql += "INSERT INTO tblteacher ( teacher_accout_id , teacher_notes , teacher_permisson ) VALUE (   ?  ,  ?  ,  ?  ) ";
		
	
		
		
		try {
			
			PreparedStatement pre = this.conn.prepareStatement(sql);
			pre.setInt( 1 , item.getTeacher_accout_id());
			pre.setString( 2 , item.getTeacher_notes());
			pre.setByte( 3 , item.getTeacher_permisson());
			
			return this.add(pre);
			//pre.setString(arg0, arg1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	


	/**
	 * @author ManhHung
	 * <p>CreatDate : <p> Oct 2, 2018 - 2:17:59 AM
	 * <p>Last Updated : <p>
	 */
	public boolean editTeacher(TeacherObject item) {
		// TODO Auto-generated method stub
		
		String sql = "";
		sql += "UPDATE  tblteacher SET teacher_accout_id = ?  , teacher_notes = ?  , teacher_permisson = ? WHERE teacher_id = ?";
		
		
		try {
			PreparedStatement pre = this.conn.prepareStatement(sql);
			
			
			
			return this.edit(pre);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}


	/**
	 * @author ManhHung
	 * <p>CreatDate : <p> Oct 2, 2018 - 2:17:59 AM
	 * <p>Last Updated : <p>
	 */
	public boolean delTeacher(TeacherObject item) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM tblteacher WHERE teacher_id = ? ";
        PreparedStatement pre = null;
        try {

            pre = this.conn.prepareStatement(sql);
            pre.setInt(1,item.getTeacher_id());
            

            return this.del(pre);
        } catch (SQLException ex) {
        }

        return false;
	}
	
	public TeacherObject getTeacherByAccout(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT *  FROM tblteacher " 
				+ "LEFT JOIN tblaccout ON tblteacher.teacher_accout_id = tblaccout.accout_id "
				+ "WHERE teacher_accout_id = ? ";
		
        ResultSet rs = this.get(sql,id);
        TeacherObject item = null;
        
        if(rs != null){
	          try {
	              while (rs.next()) {
	                  
	            	  
	            	  
	            	  item = new TeacherObject();
	                  item.setTeacher_id(rs.getInt("teacher_id"));
	                  item.setTeacher_accout_id(rs.getInt("teacher_accout_id"));
	                  item.setTeacher_notes(rs.getString("teacher_notes"));
	                  item.setTeacher_permisson(rs.getByte("teacher_permisson"));
	                 
	                  item.setAccout_id(rs.getInt("accout_id"));
	                    item.setAccout_name(rs.getString("accout_name"));
	                    //item.setAccout_pass(rs.getString("accout_pass"));
	                    item.setAccout_fullname(rs.getString("accout_fullname"));
	                    item.setAccout_mobilephone(rs.getString("accout_mobilephone"));
	                   item.setAccout_email(rs.getString("accout_email"));
	                    item.setAccout_address(rs.getString("accout_address"));
	                    //item.setAccout_roles(rs.getString("accout_roles"));
	                    //item.setAccout_created_date(rs.getString("accout_created_date"));
	                    //item.setAccout_permission(rs.getByte("accout_permission"));
	                    item.setAccout_nation(rs.getString("accout_nation"));
	                    item.setAccout_religion(rs.getString("accout_religion"));
	                    //item.setAccout_last_logined(rs.getString("accout_last_logined"));
	                    //item.setAccout_parent_id(rs.getInt("accout_parent_id"));
	                    //item.setAccout_logined(rs.getInt("accout_logined"));
	         


	              }
	          } catch (SQLException ex) {
	              ex.printStackTrace();
	          }
	      }
        
        
        return item;
	}

	/**
	 * @author ManhHung
	 * <p>CreatDate : <p> Oct 2, 2018 - 2:17:59 AM
	 * <p>Last Updated : <p>
	 */
	public TeacherObject getTeacher(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT *  FROM tblteacher " 
				+ "LEFT JOIN tblaccout ON tblteacher.teacher_accout_id = tblaccout.accout_id "
				+ "WHERE teacher_id = ? ";
		
        ResultSet rs = this.get(sql,id);
        TeacherObject item = null;
        
        if(rs != null){
	          try {
	              while (rs.next()) {
	                  
	            	  
	            	  
	            	  item = new TeacherObject();
	                  item.setTeacher_id(rs.getInt("teacher_id"));
	                  item.setTeacher_accout_id(rs.getInt("teacher_accout_id"));
	                  item.setTeacher_notes(rs.getString("teacher_notes"));
	                  item.setTeacher_permisson(rs.getByte("teacher_permisson"));
	                 
	                  item.setAccout_id(rs.getInt("accout_id"));
	                    item.setAccout_name(rs.getString("accout_name"));
	                    item.setAccout_pass(rs.getString("accout_pass"));
	                    item.setAccout_fullname(rs.getString("accout_fullname"));
	                    item.setAccout_mobilephone(rs.getString("accout_mobilephone"));
	                    item.setAccout_email(rs.getString("accout_email"));
	                    item.setAccout_address(rs.getString("accout_address"));
	                    //item.setAccout_roles(rs.getString("accout_roles"));
	                    //item.setAccout_created_date(rs.getString("accout_created_date"));
	                    //item.setAccout_permission(rs.getByte("accout_permission"));
	                    item.setAccout_nation(rs.getString("accout_nation"));
	                    item.setAccout_religion(rs.getString("accout_religion"));
	                    //item.setAccout_last_logined(rs.getString("accout_last_logined"));
	                    //item.setAccout_parent_id(rs.getInt("accout_parent_id"));
	                    //item.setAccout_logined(rs.getInt("accout_logined"));
	         


	              }
	          } catch (SQLException ex) {
	              ex.printStackTrace();
	          }
	      }
        
        
        return item;
	}
	
	
	

	/**
	 * @author ManhHung
	 * <p>CreatDate : <p> Oct 2, 2018 - 2:17:59 AM
	 * <p>Last Updated : <p>
	 */
	public ArrayList<TeacherObject> getTeachers(TeacherObject similar, int at, int total) {
		String sql = "SELECT * FROM tblteacher ";
		sql += " ";
        sql += "ORDER BY teacher_id ASC ";
        sql += "LIMIT  " + at + ", " + total;
       
		
        ArrayList<TeacherObject> items = new ArrayList<TeacherObject>();
	      TeacherObject item = null;
	      //Lay doi tuong
	      ResultSet rs = this.gets(sql);
	      if(rs != null){
	          try {
	              while (rs.next()) {
	                  
	            	  item = new TeacherObject();
	                  item.setTeacher_id(rs.getInt("teacher_id"));
	                  item.setTeacher_accout_id(rs.getInt("teacher_accout_id"));
	                  item.setTeacher_notes(rs.getString("teacher_notes"));
	                  item.setTeacher_permisson(rs.getByte("teacher_permisson"));
	                  
	                  item.setAccout_id(rs.getInt("accout_id"));
	                    item.setAccout_name(rs.getString("accout_name"));
	                    item.setAccout_pass(rs.getString("accout_pass"));
	                    item.setAccout_fullname(rs.getString("accout_fullname"));
	                    item.setAccout_mobilephone(rs.getString("accout_mobilephone"));
	                    item.setAccout_email(rs.getString("accout_email"));
	                    item.setAccout_address(rs.getString("accout_address"));
	                    item.setAccout_roles(rs.getString("accout_roles"));
	                    //item.setAccout_created_date(rs.getString("accout_created_date"));
	                    //item.setAccout_permission(rs.getByte("accout_permission"));
	                    item.setAccout_nation(rs.getString("accout_nation"));
	                    item.setAccout_religion(rs.getString("accout_religion"));
	                    //item.setAccout_last_logined(rs.getString("accout_last_logined"));
	                    //item.setAccout_parent_id(rs.getInt("accout_parent_id"));
	                    //item.setAccout_logined(rs.getInt("accout_logined"));
	         
	                  
	                  items.add(item);
	                  
	         


	              }
	          } catch (SQLException ex) {
	              ex.printStackTrace();
	          }
	      }


	      return items;
	}

}
