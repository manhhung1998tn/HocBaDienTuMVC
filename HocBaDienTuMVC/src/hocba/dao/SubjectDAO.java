package hocba.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hocba.model.object.ClassesObject;
import hocba.model.object.SubjectObject;
import hocba.model.object.TeacherObject;
import hocba.util.Utilities;


public class SubjectDAO extends BasicDAO {

	public SubjectDAO(ConnectionPool cp) {
		super(cp, "Subject");
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @author ManhHung
	 * <p>CreatDate : <p> Oct 2, 2018 - 2:24:00 AM
	 * <p>Last Updated : <p>
	 */
	public boolean addSubject(SubjectObject item) {
		
		// TODO Auto-generated method stub
		String sql = "";
		sql += "INSERT INTO tblsubject ( "
				+ "subject_name , subject_teacher_id , "
				+ "subject_term1_score_15 , subject_term1_score_45_1 , "
				+ "subject_term1_score_45_2 , subject_term1_score_average , "
				+ "subject_term1_score_test , subject_term1_score_final , "
				+ "subject_term2_score_15 , subject_term2_score_45_1 , "
				+ "subject_term2_score_45_2 , subject_term2_score_average , "
				+ "subject_term2_score_test , subject_term2_score_final , "
				+ "subject_accademic_year_id , subject_notes , subject_score  ) "
				+ "VALUE (   ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ? , ? , ? )";
		
	
		
		
		try {
			
			PreparedStatement pre = this.conn.prepareStatement(sql);
			pre.setString( 1 , item.getSubject_name());
			pre.setInt( 2 , item.getSubject_teacher_id());
			pre.setShort( 3 , item.getSubject_term1_score_15());
			pre.setShort( 4 , item.getSubject_term1_score_45_1());
			pre.setShort( 5 , item.getSubject_term1_score_45_2());
			pre.setShort( 6 , item.getSubject_term1_score_average());
			pre.setShort( 7 , item.getSubject_term1_score_test());
			pre.setShort( 8 , item.getSubject_term1_score_final());
			pre.setShort( 9 , item.getSubject_term2_score_15());
			pre.setShort( 10 , item.getSubject_term2_score_45_1());
			pre.setShort( 11 , item.getSubject_term2_score_45_2());
			pre.setShort( 12 , item.getSubject_term2_score_average());
			pre.setShort( 13 , item.getSubject_term2_score_test());
			pre.setShort( 14 , item.getSubject_term2_score_final());
			
			
			
			pre.setInt( 15 , item.getSubject_accademic_year_id());
			pre.setString(16, item.getSubject_notes());
			
			pre.setShort( 17 , item.getSubject_score());
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
	 * <p>CreatDate : <p> Oct 2, 2018 - 2:24:00 AM
	 * <p>Last Updated : <p>
	 */
	public boolean editSubject(SubjectObject item) {
		// TODO Auto-generated method stub
		
		String sql = "";
		sql += "UPDATE  tblsubject SET "
				+ "subject_name = ?  , subject_teacher_id = ?  , "
				+ "subject_term1_score_15 = ?  , subject_term1_score_45_1 = ?  , "
				+ "subject_term1_score_45_2 = ?  , subject_term1_score_average = ?  , "
				+ "subject_term1_score_test = ?  , subject_term1_score_final = ?  , "
				+ "subject_term2_score_15 = ?  , subject_term2_score_45_1 = ?  , "
				+ "subject_term2_score_45_2 = ?  , subject_term2_score_average = ?  , "
				+ "subject_term2_score_test = ?  , subject_term2_score_final = ?  , "
				+ "subject_accademic_year_id = ? , subject_notes = ? , "
				+ "subject_score = ? "
				+ "WHERE subject_id = ?";
		
		
		try {
			PreparedStatement pre = this.conn.prepareStatement(sql);
			pre.setString( 1 , item.getSubject_name()); // có chứa ký tự utf-8
			pre.setInt( 2 , item.getSubject_teacher_id());
			pre.setShort( 3 , item.getSubject_term1_score_15());
			pre.setShort( 4 , item.getSubject_term1_score_45_1());
			pre.setShort( 5 , item.getSubject_term1_score_45_2());
			pre.setShort( 6 , item.getSubject_term1_score_average());
			pre.setShort( 7 , item.getSubject_term1_score_test());
			pre.setShort( 8 , item.getSubject_term1_score_final());
			pre.setShort( 9 , item.getSubject_term2_score_15());
			pre.setShort( 10 , item.getSubject_term2_score_45_1());
			pre.setShort( 11 , item.getSubject_term2_score_45_2());
			pre.setShort( 12 , item.getSubject_term2_score_average());
			pre.setShort( 13 , item.getSubject_term2_score_test());
			pre.setShort( 14 , item.getSubject_term2_score_final());
			pre.setInt( 15 , item.getSubject_accademic_year_id());
			pre.setString(16, item.getSubject_notes());
			pre.setShort( 17 , item.getSubject_score());
			pre.setInt(18 , item.getSubject_id());
			
			
			
			return this.edit(pre);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public boolean editSubjectByTeacher(SubjectObject item, int roles) {
		// TODO Auto-generated method stub
		if(roles > 3 || roles < 0) {
			return false;
		}
		
		
		String sql = "";
		sql += "UPDATE  tblsubject SET ";
		if(roles == 1) {
			sql += " subject_term1_score_15 = ?  , subject_term1_score_45_1 = ?  , "
					+ "subject_term1_score_45_2 = ?  , subject_term1_score_average = ?  , "
					+ "subject_term1_score_test = ?  , subject_term1_score_final = ?  , "
					+ "subject_score = ? ";
			
		}else if(roles == 2){
			sql += " subject_term2_score_15 = ?  , subject_term2_score_45_1 = ?  , "
					+ "subject_term2_score_45_2 = ?  , subject_term2_score_average = ?  , "
					+ "subject_term2_score_test = ?  , subject_term2_score_final = ?  , "
					+ "subject_score = ? ";
		}else {
			sql += " subject_notes = ? ";
		}
		
		
		
		sql+=  "WHERE subject_id = ?";
		
		
		try {
			int i = 1;
			PreparedStatement pre = this.conn.prepareStatement(sql);
			if(roles == 1) {
				pre.setShort( i++ , item.getSubject_term1_score_15());
				pre.setShort( i++ , item.getSubject_term1_score_45_1());
				pre.setShort( i++ , item.getSubject_term1_score_45_2());
				pre.setShort( i++ , item.getSubject_term1_score_average());
				pre.setShort( i++ , item.getSubject_term1_score_test());
				pre.setShort( i++ , item.getSubject_term1_score_final());
				pre.setShort( i++ , item.getSubject_score());
				
			}else if(roles == 2){
				pre.setShort( i++ , item.getSubject_term2_score_15());
				pre.setShort( i++ , item.getSubject_term2_score_45_1());
				pre.setShort( i++ , item.getSubject_term2_score_45_2());
				pre.setShort( i++ , item.getSubject_term2_score_average());
				pre.setShort( i++ , item.getSubject_term2_score_test());
				pre.setShort( i++ , item.getSubject_term2_score_final());
				pre.setShort( i++ , item.getSubject_score());
			}else {
				
				pre.setString(i++, item.getSubject_notes());
			}
	
			pre.setInt(i++ , item.getSubject_id());
			
			
			
			return this.edit(pre);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}


	/**
	 * @author ManhHung
	 * <p>CreatDate : <p> Oct 2, 2018 - 2:24:00 AM
	 * <p>Last Updated : <p>
	 */
	public boolean delSubject(SubjectObject item) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM tblsubject WHERE subject_id = ? ";
        PreparedStatement pre = null;
        try {

            pre = this.conn.prepareStatement(sql);
            pre.setInt(1,item.getSubject_id());
            

            return this.del(pre);
        } catch (SQLException ex) {
        }

        return false;
	}


	/**
	 * @author ManhHung
	 * <p>CreatDate : <p> Oct 2, 2018 - 2:24:00 AM
	 * <p>Last Updated : <p>
	 */
	public SubjectObject getSubject(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tblsubject WHERE subject_id = ? ";
		
       
        
        SubjectObject item = null;

        //Lay doi tuong
        ResultSet rs = this.get(sql,id);
        if(rs != null){
            try {
                if (rs.next()) {
                    item = new SubjectObject();
                    
                    item.setSubject_id(rs.getInt("subject_id"));
                    item.setSubject_name(rs.getString("subject_name"));
                    item.setSubject_teacher_id(rs.getInt("subject_teacher_id"));
                    item.setSubject_term1_score_15(rs.getShort("subject_term1_score_15"));
                    item.setSubject_term1_score_45_1(rs.getShort("subject_term1_score_45_1"));
                    item.setSubject_term1_score_45_2(rs.getShort("subject_term1_score_45_2"));
                    item.setSubject_term1_score_average(rs.getShort("subject_term1_score_average"));
                    item.setSubject_term1_score_test(rs.getShort("subject_term1_score_test"));
                    item.setSubject_term1_score_final(rs.getShort("subject_term1_score_final"));
                    item.setSubject_term2_score_15(rs.getShort("subject_term2_score_15"));
                    item.setSubject_term2_score_45_1(rs.getShort("subject_term2_score_45_1"));
                    item.setSubject_term2_score_45_2(rs.getShort("subject_term2_score_45_2"));
                    item.setSubject_term2_score_average(rs.getShort("subject_term2_score_average"));
                    item.setSubject_term2_score_test(rs.getShort("subject_term2_score_test"));
                    item.setSubject_term2_score_final(rs.getShort("subject_term2_score_final"));
                    item.setSubject_accademic_year_id(rs.getInt("subject_accademic_year_id"));
                    item.setSubject_notes(rs.getString("subject_notes"));
                    item.setSubject_score(rs.getShort("subject_score"));
                    
                    
                    
                    
                }	
            } catch (SQLException ex) {
            }
        }


        return item;
	}
	
	/**
	 * <p>Description: </p> Lấy Danh Sách điểm môn học
	 * @author ManhHung
	 * @author ManhHung
	 * <p>CreatDate : <p> Oct 15, 2018 - 9:42:53 PM
	 * <p>Last Updated : <p>
	 * @param teacherObject
	 * @param classesObject
	 * @param subject_name
	 * @param accademic_year_name
	 * @return
	 */
	public ArrayList<SubjectObject> getListSubject(TeacherObject teacherObject, ClassesObject classesObject,String subject_name, String accademic_year_name) {

		
		String sql = "SELECT * FROM tblsubject\r\n" + 
				"LEFT JOIN tblaccademic_year ON tblsubject.subject_accademic_year_id = tblaccademic_year.accademic_year_id\r\n" + 
				"LEFT JOIN tblstudent ON tblaccademic_year.accademic_year_student_id = tblstudent.student_id\r\n" + 
				"\r\n" + 
				"LEFT JOIN tblclasses ON tblclasses.classes_id = tblstudent.student_class_id\r\n" + 
				"WHERE subject_teacher_id = "+ teacherObject.getTeacher_id() +" AND classes_id = "+ classesObject.getClasses_id() +
				" AND accademic_year_name = " + accademic_year_name + " AND subject_name = '" + subject_name + "'";
       
        
        
        ArrayList<SubjectObject> items = new ArrayList<SubjectObject>();
	      SubjectObject item = null;
	    
	      //Lay doi tuong
	      ResultSet rs = this.gets(sql);
	      if(rs != null){
	          try {
	              while (rs.next()) {
	                  item = new SubjectObject();
	                 
	                  item.setSubject_id(rs.getInt("subject_id"));
	                  item.setSubject_name(rs.getString("subject_name"));
	                  item.setSubject_teacher_id(rs.getInt("subject_teacher_id"));
	                  item.setSubject_term1_score_15(rs.getShort("subject_term1_score_15"));
	                  item.setSubject_term1_score_45_1(rs.getShort("subject_term1_score_45_1"));
	                  item.setSubject_term1_score_45_2(rs.getShort("subject_term1_score_45_2"));
	                  item.setSubject_term1_score_average(rs.getShort("subject_term1_score_average"));
	                  item.setSubject_term1_score_test(rs.getShort("subject_term1_score_test"));
	                  item.setSubject_term1_score_final(rs.getShort("subject_term1_score_final"));
	                  item.setSubject_term2_score_15(rs.getShort("subject_term2_score_15"));
	                  item.setSubject_term2_score_45_1(rs.getShort("subject_term2_score_45_1"));
	                  item.setSubject_term2_score_45_2(rs.getShort("subject_term2_score_45_2"));
	                  item.setSubject_term2_score_average(rs.getShort("subject_term2_score_average"));
	                  item.setSubject_term2_score_test(rs.getShort("subject_term2_score_test"));
	                  item.setSubject_term2_score_final(rs.getShort("subject_term2_score_final"));
	                  item.setSubject_accademic_year_id(rs.getInt("subject_accademic_year_id"));
	                  item.setSubject_notes(rs.getString("subject_notes"));
	                  item.setSubject_score(rs.getShort("subject_score"));
	                  
	                  
	                  
	                  item.getStudent().setStudent_id(rs.getInt("student_id"));
	                  item.getStudent().setStudent_name(rs.getString("student_name"));
	                  
	                  items.add(item);

	         


	              }
	          } catch (SQLException ex) {
	              ex.printStackTrace();
	          }
	      }


	      return items;
        
	}
	
	
public ArrayList<String> getNameSubjectsByTeacher(TeacherObject teacherObject, ClassesObject classesObject) {

		
		String sql = "SELECT DISTINCT subject_name FROM tblsubject\r\n" + 
				"LEFT JOIN tblaccademic_year ON tblsubject.subject_accademic_year_id = tblaccademic_year.accademic_year_id\r\n" + 
				"LEFT JOIN tblstudent ON tblaccademic_year.accademic_year_student_id = tblstudent.student_id\r\n" + 
				"\r\n" + 
				"LEFT JOIN tblclasses ON tblclasses.classes_id = tblstudent.student_class_id\r\n" + 
				"WHERE subject_teacher_id = "+ teacherObject.getTeacher_id() +" AND classes_id = "+ classesObject.getClasses_id() + " ";
				
       
        
        
        ArrayList<String> items = null;
	    
	      //Lay doi tuong
	      ResultSet rs = this.gets(sql);
	      if(rs != null){
	    	  items = new ArrayList<>();
	          try {
	              while (rs.next()) {
	                
	                 
	                  items.add(rs.getString("subject_name"));

	              }
	          } catch (SQLException ex) {
	              ex.printStackTrace();
	          }
	      }


	      return items;
        
	}
	
	
	/**
	 * @author ManhHung
	 * <p>CreatDate : <p> Oct 2, 2018 - 2:24:00 AM
	 * <p>Last Updated : <p>
	 */
	public ArrayList<SubjectObject> getSubjects(SubjectObject similar, int at, int total) {
		String sql = "SELECT * FROM tblsubject ";
		sql += " ";
        sql += "ORDER BY subject_id ASC ";
        if(at != 0 && total != 0) {
        	sql += " LIMIT  " + at + ", " + total;
        }
        
        
        ArrayList<SubjectObject> items = new ArrayList<SubjectObject>();
	      SubjectObject item = null;
	    
	      //Lay doi tuong
	      ResultSet rs = this.gets(sql);
	      if(rs != null){
	          try {
	              while (rs.next()) {
	                  item = new SubjectObject();
	                 
	                  item.setSubject_id(rs.getInt("subject_id"));
	                  item.setSubject_name(rs.getString("subject_name"));
	                  item.setSubject_teacher_id(rs.getInt("subject_teacher_id"));
	                  item.setSubject_term1_score_15(rs.getShort("subject_term1_score_15"));
	                  item.setSubject_term1_score_45_1(rs.getShort("subject_term1_score_45_1"));
	                  item.setSubject_term1_score_45_2(rs.getShort("subject_term1_score_45_2"));
	                  item.setSubject_term1_score_average(rs.getShort("subject_term1_score_average"));
	                  item.setSubject_term1_score_test(rs.getShort("subject_term1_score_test"));
	                  item.setSubject_term1_score_final(rs.getShort("subject_term1_score_final"));
	                  item.setSubject_term2_score_15(rs.getShort("subject_term2_score_15"));
	                  item.setSubject_term2_score_45_1(rs.getShort("subject_term2_score_45_1"));
	                  item.setSubject_term2_score_45_2(rs.getShort("subject_term2_score_45_2"));
	                  item.setSubject_term2_score_average(rs.getShort("subject_term2_score_average"));
	                  item.setSubject_term2_score_test(rs.getShort("subject_term2_score_test"));
	                  item.setSubject_term2_score_final(rs.getShort("subject_term2_score_final"));
	                  item.setSubject_accademic_year_id(rs.getInt("subject_accademic_year_id"));
	                  item.setSubject_notes(rs.getString("subject_notes"));
	                  item.setSubject_score(rs.getShort("subject_score"));
	                  
	                  
	                  items.add(item);

	         


	              }
	          } catch (SQLException ex) {
	              ex.printStackTrace();
	          }
	      }


	      return items;
        
	}

	public static void main(String [] args) {
		SubjectDAO dao = new SubjectDAO(null);
		SubjectObject subjectObject = dao.getSubject(911);
		System.out.println(Utilities.decode(subjectObject.getSubject_notes()));
	}



	
}
