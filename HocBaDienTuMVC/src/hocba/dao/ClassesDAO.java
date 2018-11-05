package hocba.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.fabric.xmlrpc.base.Array;

import hocba.model.object.ClassesObject;
import hocba.sql.MakeCondition;


public class ClassesDAO extends BasicDAO {

	public ClassesDAO(ConnectionPool cp) {
		super(cp, "Classes");
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @author ManhHung
	 * <p>CreatDate : <p> Oct 2, 2018 - 01:58:59 AM
	 * <p>Last Updated : <p>
	 */
	public boolean addClasses(ClassesObject item) {
		
		// TODO Auto-generated method stub
		String sql = "";
		sql += "INSERT INTO tblclasses ( "
				+ "classes_name , classes_mainteacher_id , "
				+ "classes_course , classes_student_count "
				+ ") VALUE (   ?  ,  ?  ,  ?  ,  ?  ) ";
		
	
		
		
		try {
			
			PreparedStatement pre = this.conn.prepareStatement(sql);
			pre.setString( 1 , item.getClasses_name());
			pre.setInt( 2 , item.getClasses_mainteacher_id());
			pre.setShort( 3 , item.getClasses_course());
			pre.setShort( 4 , item.getClasses_student_count());
			
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
	 * <p>CreatDate : <p> Oct 2, 2018 - 01:58:59 AM
	 * <p>Last Updated : <p>
	 */
	public boolean editClasses(ClassesObject item) {
		// TODO Auto-generated method stub
		
		String sql = "";
		sql += "UPDATE  tblclasses SET "
				+ "classes_name = ?  , classes_mainteacher_id = ?  , "
				+ "classes_course = ?  , classes_student_count = ? "
				+ " WHERE classes_id = ?";
		
		
		try {
			PreparedStatement pre = this.conn.prepareStatement(sql);
			pre.setString( 1 , item.getClasses_name());
			pre.setInt( 2 , item.getClasses_mainteacher_id());
			pre.setShort( 3 , item.getClasses_course());
			pre.setShort( 4 , item.getClasses_student_count());
			pre.setInt(5, item.getClasses_id());
			
			
			
			return this.edit(pre);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}


	/**
	 * @author ManhHung
	 * <p>CreatDate : <p> Oct 2, 2018 - 01:58:59 AM
	 * <p>Last Updated : <p>
	 */
	public boolean delClasses(ClassesObject item) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM tblclasses WHERE classes_id = ? ";
        PreparedStatement pre = null;
        try {

            pre = this.conn.prepareStatement(sql);
            pre.setInt(1,item.getClasses_id());
            

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
	public ClassesObject getClasses(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tblclasses WHERE classes_id = ? ";
	

        
        ClassesObject item = null;

        //Lay doi tuong
        ResultSet rs = this.get(sql,id);
        if(rs != null){
            try {
                if (rs.next()) {
                    item = new ClassesObject();
                    item.setClasses_id(rs.getInt("classes_id"));
                    item.setClasses_name(rs.getString("classes_name"));
                    item.setClasses_mainteacher_id(rs.getInt("classes_mainteacher_id"));
                    item.setClasses_course(rs.getShort("classes_course"));
                    item.setClasses_student_count(rs.getShort("classes_student_count"));
                }
            } catch (SQLException ex) {
            }
        }


        return item;
        
        
        
        
	}
	
	
	public ArrayList<ClassesObject> getClassesByTeacherSubject(int id, int course) {
		
		// TODO Auto-generated method stub
		
		String sql = "SELECT DISTINCT tblclasses.classes_id , tblclasses.classes_name, tblclasses.classes_course, tblclasses.classes_mainteacher_id, tblclasses.classes_student_count "
				+ " FROM tblstudent " + 
				" LEFT JOIN tblclasses ON tblclasses.classes_id = tblstudent.student_class_id " + 
				" LEFT JOIN tblaccademic_year ON tblaccademic_year.accademic_year_student_id = tblstudent.student_id " + 
				" LEFT JOIN tblsubject ON tblsubject.subject_accademic_year_id = tblaccademic_year.accademic_year_id " + 
				" WHERE subject_teacher_id = ? AND classes_course > "+ course +" ";
				
		
        
		 ArrayList<ClassesObject> items = null;
	      ClassesObject item = null;
	     
	      //Lay doi tuong
	      ResultSet rs =  this.get(sql,id);
	      if(rs != null){
	    	  items = new ArrayList<>();
	          try {
	              while (rs.next()) {
	                  item = new ClassesObject();
	                 
	                  item.setClasses_id(rs.getInt("classes_id"));
	                  item.setClasses_name(rs.getString("classes_name"));
	                  item.setClasses_mainteacher_id(rs.getInt("classes_mainteacher_id"));
	                  item.setClasses_course(rs.getShort("classes_course"));
	                  item.setClasses_student_count(rs.getShort("classes_student_count"));

	                  items.add(item);

	         


	              }
	          } catch (SQLException ex) {
	              ex.printStackTrace();
	          }
	      }


	      return items;
  
        
	}
	
	
	public int getMaxCourse() {
		
		String sql = "SELECT MAX(classes_course) FROM tblclasses ";
		sql += " ";
		sql += " LIMIT 0 , 1 ";
		
		
		
		ResultSet rs = this.gets(sql);
		
		if(rs != null) {
			try {
				if(rs.next()) {
					return rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return 0;
	}
	

	/**
	 * @author ManhHung
	 * <p>CreatDate : <p> Oct 2, 2018 - 01:06:59 AM
	 * <p>Last Updated : <p>
	 */
	public ArrayList<ClassesObject> getClassess(ClassesObject similar, int at, int total, int course) {
		String sql = "SELECT * FROM tblclasses ";
		sql += " ";
		sql += " WHERE (classes_course > " + (course-3) + ") ";
		if(similar != null) {
			
			sql += " AND " + MakeCondition.createCondition(similar);
		}
		sql += " ";
        sql += "ORDER BY classes_id ASC ";
        if(at > 0 && total > 0) {
        	sql += " LIMIT  " + at + ", " + total;
        }
        
    
        
        
        ArrayList<ClassesObject> items = null;
	      ClassesObject item = null;
	     
	      //Lay doi tuong
	      ResultSet rs =  this.gets(sql);
	      if(rs != null){
	    	  items = new ArrayList<>();
	          try {
	              while (rs.next()) {
	                  item = new ClassesObject();
	                 
	                  item.setClasses_id(rs.getInt("classes_id"));
	                  item.setClasses_name(rs.getString("classes_name"));
	                  item.setClasses_mainteacher_id(rs.getInt("classes_mainteacher_id"));
	                  item.setClasses_course(rs.getShort("classes_course"));
	                  item.setClasses_student_count(rs.getShort("classes_student_count"));

	                  items.add(item);

	         


	              }
	          } catch (SQLException ex) {
	              ex.printStackTrace();
	          }
	      }


	      return items;
		
	}
	
	public static void main(String[] args) {
		ArrayList<ClassesObject> list = new ClassesDAO(null).getClassesByTeacherSubject(22,0);
		for(ClassesObject v : list) {
			System.out.println(v.getClasses_name());
		}
		
		
		
		
		
		
		
	}




	
}
