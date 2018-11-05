package hocba.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hocba.model.object.Accademic_YearObject;


public class Accademic_YearDAO extends BasicDAO {

	public Accademic_YearDAO(ConnectionPool cp) {
		super(cp, "Accademic_Year");
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @author ManhHung
	 * <p>CreatDate : <p> Oct 2, 2018 - 02:35:59 AM
	 * <p>Last Updated : <p>
	 */
	public boolean addAccademic_Year(Accademic_YearObject item) {
		
		// TODO Auto-generated method stub
		String sql = "";
		sql += "INSERT INTO tblaccademic_year ( "
				+ "accademic_year_student_id , accademic_year_status , "
				+ "accademic_year_notes , accademic_year_score_final , "
				+ "accademic_year_score_term_1 , accademic_year_score_term_2 , "
				+ "accademic_year_name ) "
				+ "VALUE (   ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  )";
		
		
	
		
		
		try {
			
			PreparedStatement pre = this.conn.prepareStatement(sql);
			pre.setInt( 1 , item.getAccademic_year_student_id());
			pre.setShort( 2 , item.getAccademic_year_status());
			pre.setString( 3 , item.getAccademic_year_notes());
			pre.setShort( 4 , item.getAccademic_year_score_final());
			pre.setShort( 5 , item.getAccademic_year_score_term_1());
			pre.setShort( 6 , item.getAccademic_year_score_term_2());
			pre.setByte( 7 , item.getAccademic_year_name());
			
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
	 * <p>CreatDate : <p> Oct 2, 2018 - 02:35:59 AM
	 * <p>Last Updated : <p>
	 */
	public boolean editAccademic_Year(Accademic_YearObject item) {
		// TODO Auto-generated method stub
		
		String sql = "";
		sql += "UPDATE  tblaccademic_year SET "
				+ "accademic_year_student_id = ?  , accademic_year_status = ?  , "
				+ "accademic_year_notes = ?  , accademic_year_score_final = ?  , "
				+ "accademic_year_score_term_1 = ?  , accademic_year_score_term_2 = ?  , "
				+ "accademic_year_name = ? WHERE accademic_year_id = ?";
		
		
		try {
			PreparedStatement pre = this.conn.prepareStatement(sql);
			pre.setInt( 1 , item.getAccademic_year_student_id());
			pre.setShort( 2 , item.getAccademic_year_status());
			pre.setString( 3 , item.getAccademic_year_notes());
			pre.setShort( 4 , item.getAccademic_year_score_final());
			pre.setShort( 5 , item.getAccademic_year_score_term_1());
			pre.setShort( 6 , item.getAccademic_year_score_term_2());
			pre.setByte( 7 , item.getAccademic_year_name());;
			pre.setInt(5, item.getAccademic_year_id());
			
			
			
			return this.edit(pre);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}


	/**
	 * @author ManhHung
	 * <p>CreatDate : <p> Oct 2, 2018 - 02:35:59 AM
	 * <p>Last Updated : <p>
	 */
	public boolean delAccademic_Year(Accademic_YearObject item) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM tblaccademic_year WHERE accademic_year_id = ? ";
        PreparedStatement pre = null;
        try {

            pre = this.conn.prepareStatement(sql);
            pre.setInt(1,item.getAccademic_year_id());
            

            return this.del(pre);
        } catch (SQLException ex) {
        }

        return false;
	}


	/**
	 * @author ManhHung
	 * <p>CreatDate : <p> Oct 2, 2018 - 01:58:59 AM
	 * <p>Last Updated : <p>
	 */
	public Accademic_YearObject getAccademic_Year(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tblaccademic_year WHERE accademic_year_id = ? ";
		
      
        
        
        Accademic_YearObject item = null;

        //Lay doi tuong
        ResultSet rs = this.get(sql,id);
        if(rs != null){
            try {
                if (rs.next()) {
                    item = new Accademic_YearObject();
                    
                    item.setAccademic_year_id(rs.getInt("accademic_year_id"));
	                  item.setAccademic_year_student_id(rs.getInt("accademic_year_student_id"));
	                  item.setAccademic_year_status(rs.getByte("accademic_year_status"));
	                  item.setAccademic_year_notes(rs.getString("accademic_year_notes"));
	                  item.setAccademic_year_score_final(rs.getShort("accademic_year_score_final"));
	                  item.setAccademic_year_score_term_1(rs.getShort("accademic_year_score_term_1"));
	                  item.setAccademic_year_score_term_2(rs.getShort("accademic_year_score_term_2"));
	                  item.setAccademic_year_name(rs.getByte("accademic_year_name"));
                }
            } catch (SQLException ex) {
            }
        }


        return item;
	}
	
	
	
	
	/**
	 * @author ManhHung
	 * <p>CreatDate : <p> Oct 2, 2018 - 02:35:59 AM
	 * <p>Last Updated : <p>
	 */
	public ArrayList<Accademic_YearObject> getAccademic_Years(Accademic_YearObject similar, int at, int total) {
		String sql = "SELECT * FROM tblaccademic_year ";
		sql += " ";
        sql += "ORDER BY accademic_year_id ASC ";
        sql += "LIMIT  " + at + ", " + total;
        

        //Lay doi tuong
        ResultSet rs = this.gets(sql);
        ArrayList<Accademic_YearObject> list = null;
        Accademic_YearObject item = null;
        if(rs != null){
        	list = new ArrayList<>();
            try {
                while (rs.next()) {
                	 item = new Accademic_YearObject();
                    
                    item.setAccademic_year_id(rs.getInt("accademic_year_id"));
	                  item.setAccademic_year_student_id(rs.getInt("accademic_year_student_id"));
	                  item.setAccademic_year_status(rs.getByte("accademic_year_status"));
	                  item.setAccademic_year_notes(rs.getString("accademic_year_notes"));
	                  item.setAccademic_year_score_final(rs.getShort("accademic_year_score_final"));
	                  item.setAccademic_year_score_term_1(rs.getShort("accademic_year_score_term_1"));
	                  item.setAccademic_year_score_term_2(rs.getShort("accademic_year_score_term_2"));
	                  item.setAccademic_year_name(rs.getByte("accademic_year_name"));
	                  
	                  list.add(item);
	                  
	                  
                }
            } catch (SQLException ex) {
            }
        }


        return list;
        
		
	}




	
}
