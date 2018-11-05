package hocba.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hocba.model.object.AccoutObject;
import hocba.sql.MakeCondition;
import hocba.util.Utilities;


public class AccoutDAO extends BasicDAO {
	
	
	public AccoutDAO(ConnectionPool cp) {
		super(cp, "Accout");
		// TODO Auto-generated constructor stub
	}
	

	

	/**
	 * @author ManhHung
	 * <p>CreatDate : <p> Oct 1, 2018 - 11:37:59 PM
	 * <p>Last Updated : <p>
	 */
	public boolean addAccout(AccoutObject item) {
		if(isExisting(item)) {
			return false;
		}
		// TODO Auto-generated method stub
		String sql = "";
		
		
		sql += "INSERT INTO tblaccout ( "
				+ "accout_name , accout_pass , "
				+ "accout_fullname , accout_mobilephone , "
				+ "accout_email , accout_address , "
				+ "accout_roles , accout_created_date , "
				+ "accout_permission , accout_nation , "
				+ "accout_religion , accout_last_logined , "
				+ "accout_parent_id , accout_logined "
				+ ") VALUE (   ?  ,  md5(?)  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  )";
		
		
		try {
			
			PreparedStatement pre = this.conn.prepareStatement(sql);
			pre.setString(1 , item.getAccout_name());
			pre.setString(2 , item.getAccout_pass());
			pre.setString(3 , Utilities.encode(item.getAccout_fullname())); // cÃ³ chá»©a kÃ½ tá»± utf-8
			pre.setString(4 , item.getAccout_mobilephone());
			pre.setString(5 , item.getAccout_email());
			pre.setString(6 , Utilities.encode(item.getAccout_address())); // cÃ³ chá»©a kÃ½ tá»± utf-8
			pre.setString(7 , item.getAccout_roles());
			pre.setString(8 , item.getAccout_created_date());
			pre.setByte(9 , item.getAccout_permission());
			pre.setString(10 , Utilities.encode(item.getAccout_nation())); // cÃ³ chá»©a kÃ½ tá»± utf-8
			pre.setString(11 , Utilities.encode(item.getAccout_religion())); // cÃ³ chá»©a kÃ½ tá»± utf-8
			pre.setString(12 , item.getAccout_last_logined());
			pre.setInt(13 , item.getAccout_parent_id());
			pre.setInt(14 , item.getAccout_logined());
			
			return this.add(pre);
			//pre.setString(arg0, arg1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	/**
	 * 
	 * <p>Description: </p> kiá»ƒm tra trÃ¹ng tÃªn tÃ i khoáº£n
	 * @author ManhHung
	 * @version 1.0
	 * <p>CreatDate : <p> Oct 1, 2018 - 11:33:39 PM
	 * @param item - Ä‘á»‘i tÆ°á»£ng cáº§n kiá»ƒm tra
	 * @return trÃ¹ng tráº£ vá»� true, khÃ´ng trÃ¹ng tráº£ vá»� false;
	 */
    private boolean isExisting(AccoutObject item){

        boolean flag = false;
        String sql = "SELECT accout_id FROM tblaccout WHERE accout_name ='" + item.getAccout_name() + "' ";
        try {
            ResultSet rs = this.gets(sql);
            if(rs != null){
                if(rs.next()){
                    flag = true;
                }
            }

            rs.close();

        } catch (SQLException ex) {

        }


        return flag;
    }


	/**
	 * @author ManhHung
	 * <p>CreatDate : <p> Oct 2, 2018 - 01:06:59 AM
	 * <p>Last Updated : <p>
	 */
	public boolean editAccout(AccoutObject item) {
		// TODO Auto-generated method stub
		
		String sql = "";
		sql += "UPDATE tblaccout SET  accout_pass = md5(?)  , "
				+ "accout_fullname = ?  , accout_mobilephone = ?  , "
				+ "accout_email = ?  , accout_address = ?  , "
				+ "accout_roles = ?  ,  "
				+ "accout_permission = ?  , accout_nation = ?  , "
				+ "accout_religion = ?  , accout_last_logined = ?  , "
				+ "accout_logined = ? "
				+ " WHERE accout_id = ? ;";
		
		
		try {
			PreparedStatement pre = this.conn.prepareStatement(sql);
			
			
			pre.setString(1 , item.getAccout_pass());
			pre.setString(2 , item.getAccout_fullname()); // cÃ³ chá»©a kÃ½ tá»± utf-8
			pre.setString(3 , item.getAccout_mobilephone());
			pre.setString(4 , item.getAccout_email());
			pre.setString(5 , item.getAccout_address()); // cÃ³ chá»©a kÃ½ tá»± utf-8
			pre.setString(6 , item.getAccout_roles());
			
			pre.setByte(7 , item.getAccout_permission());
			pre.setString(8 , item.getAccout_nation()); // cÃ³ chá»©a kÃ½ tá»± utf-8
			pre.setString(9 , item.getAccout_religion()); // cÃ³ chá»©a kÃ½ tá»± utf-8
			pre.setString(10 , item.getAccout_last_logined());
			
			pre.setInt(11 , item.getAccout_logined());
			
			pre.setInt(12, item.getAccout_id());
			
			
			return this.edit(pre);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	/**
	 * <p>Description: </p> update logined and last logined when accout login
	 * @author ManhHung
	 * <p>CreatDate : <p> Oct 7, 2018 - 12:52:05 AM
	 * <p>Last Updated : <p>
	 * @param item
	 * @return
	 */
	public boolean updateLoginAccout(AccoutObject item) {
		// TODO Auto-generated method stub
		
		String sql = "";
		sql += "UPDATE tblaccout SET accout_last_logined = ? , "
				+ "accout_logined = ? "
				+ " WHERE accout_id = ? ;";
		
		
		try {
			PreparedStatement pre = this.conn.prepareStatement(sql);
			
			
		
			pre.setString(1 , item.getAccout_last_logined());
			
			pre.setInt(2 , item.getAccout_logined());
			
			pre.setInt(3, item.getAccout_id());
			
			
			return this.edit(pre);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	
	
	

	/**
	 * @author ManhHung
	 * <p>CreatDate : <p> Oct 2, 2018 - 01:06:59 AM
	 * <p>Last Updated : <p>
	 */
	public boolean delAccout(AccoutObject item,AccoutObject similar) {
		// TODO Auto-generated method stub
		String condition = "";
		if(similar != null) {
			condition = MakeCondition.conditonAccoutPermiss(similar);
		}
		String sql = "DELETE FROM tblaccout WHERE accout_id = ? " + " AND " + condition + " ";
        PreparedStatement pre = null;
        try {

            pre = this.conn.prepareStatement(sql);
            pre.setInt(1,item.getAccout_id());


            return this.del(pre);
        } catch (SQLException ex) {
        }

        return false;
	}


	/**
	 * @author ManhHung
	 * <p>CreatDate : <p> Oct 2, 2018 - 01:06:59 AM
	 * <p>Last Updated : <p>
	 */
	public AccoutObject getAccout(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tblaccout WHERE accout_id = ? ";
		
		AccoutObject item = null;
        ResultSet rs = this.get(sql,id);
        if(rs != null){
            try {
                if (rs.next()) {
                    item = new AccoutObject();
                    item.setAccout_id(rs.getInt("accout_id"));
                    item.setAccout_name(rs.getString("accout_name"));
                    item.setAccout_pass(rs.getString("accout_pass"));
                    item.setAccout_fullname(rs.getString("accout_fullname"));
                    item.setAccout_mobilephone(rs.getString("accout_mobilephone"));
                    item.setAccout_email(rs.getString("accout_email"));
                    item.setAccout_address(rs.getString("accout_address"));
                    item.setAccout_roles(rs.getString("accout_roles"));
                    item.setAccout_created_date(rs.getString("accout_created_date"));
                    item.setAccout_permission(rs.getByte("accout_permission"));
                    item.setAccout_nation(rs.getString("accout_nation"));
                    item.setAccout_religion(rs.getString("accout_religion"));
                    item.setAccout_last_logined(rs.getString("accout_last_logined"));
                    item.setAccout_parent_id(rs.getInt("accout_parent_id"));
                    item.setAccout_logined(rs.getInt("accout_logined"));

                }
            } catch (SQLException ex) {
            }
        }


        return item;
	}
	
	
	
	
	/**
	 * @author ManhHung
	 * <p>CreatDate : <p> Oct 2, 2018 - 01:06:59 AM
	 * <p>Last Updated : <p>
	 */
	public ArrayList<AccoutObject> getAccouts(AccoutObject similar, int at, int total) {
		String condition = "";
		if(similar != null && MakeCondition.conditonAccoutPermiss(similar) != null) {
			condition = "WHERE " + MakeCondition.conditonAccoutPermiss(similar);
		}
		
		String sql = "SELECT * FROM tblaccout ";
		sql += " " + condition + " ";
        sql += "ORDER BY accout_id ASC ";
        sql += "LIMIT  " + at + ", " + total;
        
        
        
        ArrayList<AccoutObject> items = new ArrayList<AccoutObject>();
	      AccoutObject item = null;
	      
	      //Lay doi tuong
	      ResultSet rs = this.gets(sql);
	      if(rs != null){
	          try {
	              while (rs.next()) {
	                  item = new AccoutObject();
	                  item.setAccout_id(rs.getInt("accout_id"));
				        item.setAccout_name(rs.getString("accout_name"));
				        item.setAccout_pass(rs.getString("accout_pass"));
				        item.setAccout_fullname(rs.getString("accout_fullname"));
				        item.setAccout_mobilephone(rs.getString("accout_mobilephone"));
				        item.setAccout_email(rs.getString("accout_email"));
				        item.setAccout_address(rs.getString("accout_address"));
				        item.setAccout_roles(rs.getString("accout_roles"));
				        item.setAccout_created_date(rs.getString("accout_created_date"));
				        item.setAccout_permission(rs.getByte("accout_permission"));
				        item.setAccout_nation(rs.getString("accout_nation"));
				        item.setAccout_religion(rs.getString("accout_religion"));
				        item.setAccout_last_logined(rs.getString("accout_last_logined"));
				        item.setAccout_parent_id(rs.getInt("accout_parent_id"));
				        item.setAccout_logined(rs.getInt("accout_logined"));

	                  items.add(item);

	         


	              }
	          } catch (SQLException ex) {
	              ex.printStackTrace();
	          }
	      }


	      return items;
		
	}



	
	/**
	 * @author ManhHung
	 * <p>CreatDate : <p> Oct 2, 2018 - 01:43:59 AM
	 * <p>Last Updated : <p>
	 */
	public AccoutObject getAccout(String username, String password) {
		String sql = "SELECT *  "
				+ "FROM tblaccout WHERE accout_name = ? && accout_pass = md5(?) ";
        AccoutObject item = null;

	       //Lay doi tuong
	       ResultSet rs = this.get(sql, username, password);;
	       if(rs != null){
	           try {
	               if (rs.next()) {
	                   item = new AccoutObject();
					    item.setAccout_id(rs.getInt("accout_id"));
				        item.setAccout_name(rs.getString("accout_name"));
				        item.setAccout_pass(rs.getString("accout_pass"));
				        item.setAccout_fullname(rs.getString("accout_fullname"));
				        item.setAccout_mobilephone(rs.getString("accout_mobilephone"));
				        item.setAccout_email(rs.getString("accout_email"));
				        item.setAccout_address(rs.getString("accout_address"));
				        item.setAccout_roles(rs.getString("accout_roles"));
				        item.setAccout_created_date(rs.getString("accout_created_date"));
				        item.setAccout_permission(rs.getByte("accout_permission"));
				        item.setAccout_nation(rs.getString("accout_nation"));
				        item.setAccout_religion(rs.getString("accout_religion"));
				        item.setAccout_last_logined(rs.getString("accout_last_logined"));
				        item.setAccout_parent_id(rs.getInt("accout_parent_id"));
				        item.setAccout_logined(rs.getInt("accout_logined"));
	               }
	           } catch (SQLException ex) {
	           }
	       }


	       return item;
	}

}
