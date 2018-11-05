package hocba.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hocba.model.object.ClassesObject;
import hocba.model.object.StudentObject;
import hocba.sql.MakeCondition;



public class StudentDAO extends BasicDAO{

	public StudentDAO(ConnectionPool cp) {
		super(cp, "Student");
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @author ManhHung
	 * <p>CreatDate : <p> Oct 2, 2018 - 2:47:59 AM
	 * <p>Last Updated : <p>
	 */
	public boolean addStudent(StudentObject item) {
		
		// TODO Auto-generated method stub
		String sql = "";
		sql += "INSERT INTO tblstudent ( "
				+ "student_sex , student_nation , student_birthday , "
				+ "student_birthplace , student_address , student_phone , "
				+ "student_hobbis , student_guardian_name , student_guardian_birthday , "
				+ "student_guardian_job , student_guardian_phone , student_name , student_class_id , "
				+ "student_priority , student_social_component , student_exemptions , student_email , "
				+ "student_province , student_district , student_ward ) "
				+ "VALUE (   ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ? , ? , ? , ? )";
		
	
		
		
		try {
			
			PreparedStatement pre = this.conn.prepareStatement(sql);
			pre.setString( 1 , item.getStudent_sex());
			pre.setString( 2 , item.getStudent_nation());
			pre.setObject( 3 , item.getStudent_birthday());
			pre.setString( 4 , item.getStudent_birthplace());
			pre.setString( 5 , item.getStudent_address());
			pre.setString( 6 , item.getStudent_phone());
			pre.setString( 7 , item.getStudent_hobbis());
			pre.setString( 8 , item.getStudent_guardian_name());
			pre.setString( 9 , item.getStudent_guardian_birthday());
			pre.setString( 10 , item.getStudent_guardian_job());
			pre.setString( 11 , item.getStudent_guardian_phone());
			pre.setString( 12 , item.getStudent_name());
			pre.setInt( 13 , item.getStudent_class_id());
			pre.setString( 14 , item.getStudent_priority());
			pre.setString( 15 , item.getStudent_social_component());
			pre.setString( 16 , item.getStudent_exemptions());
			pre.setString( 17 , item.getStudent_email());
			pre.setString(18, item.getStudent_province());
			pre.setString(19, item.getStudent_district());
			pre.setString(20, item.getStudent_ward());
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
	 * <p>CreatDate : <p> Oct 2, 2018 -  2:47:59 AM
	 * <p>Last Updated : <p>
	 */
	public boolean editStudent(StudentObject item) {
		// TODO Auto-generated method stub
		
		String sql = "";
		sql += "UPDATE  tblstudent SET "
				+ "student_sex = ?  , student_nation = ?  , "
				+ "student_birthday = ?  , student_birthplace = ?  , "
				+ "student_address = ?  , student_phone = ?  , student_hobbis = ?  , "
				+ "student_guardian_name = ?  , student_guardian_birthday = ?  , "
				+ "student_guardian_job = ?  , student_guardian_phone = ?  , "
				+ "student_name = ?  , student_class_id = ?  , student_priority = ?  , "
				+ "student_social_component = ?  , student_exemptions = ?  , "
				+ "student_email = ? , "
				+ "student_province = ? , student_district = ? , student_ward = ? "
				+ "WHERE student_id = ?";
		
		
		try {
			PreparedStatement pre = this.conn.prepareStatement(sql);
			pre.setString( 1 , item.getStudent_sex());
			pre.setString( 2 , item.getStudent_nation());
			pre.setObject( 3 , item.getStudent_birthday());
			pre.setString( 4 , item.getStudent_birthplace());
			pre.setString( 5 , item.getStudent_address());
			pre.setString( 6 , item.getStudent_phone());
			pre.setString( 7 , item.getStudent_hobbis());
			pre.setString( 8 , item.getStudent_guardian_name());
			pre.setString( 9 , item.getStudent_guardian_birthday());
			pre.setString( 10 , item.getStudent_guardian_job());
			pre.setString( 11 , item.getStudent_guardian_phone());
			pre.setString( 12 , item.getStudent_name());
			pre.setInt( 13 , item.getStudent_class_id());
			pre.setString( 14 , item.getStudent_priority());
			pre.setString( 15 , item.getStudent_social_component());
			pre.setString( 16 , item.getStudent_exemptions());
			pre.setString( 17 , item.getStudent_email());
			
			pre.setString(18, item.getStudent_province());
			pre.setString(19, item.getStudent_district());
			pre.setString(20, item.getStudent_ward());
			
			pre.setInt(21, item.getStudent_id());
			
			
			
			return this.edit(pre);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	/**
	 * @author ManhHung
	 * <p>CreatDate : <p> Oct 2, 2018 -  2:47:59 AM
	 * <p>Last Updated : <p>
	 */
	public boolean delStudent(StudentObject item) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM tblstudent WHERE student_id = ? ";
        PreparedStatement pre = null;
        try {

            pre = this.conn.prepareStatement(sql);
            pre.setInt(1,item.getStudent_id());
            

            return this.del(pre);
        } catch (SQLException ex) {
        }

        return false;
	}
	
	
	
	public StudentObject getClassesByIdTeacherSubject(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tblclasses\r\n" + 
				"LEFT JOIN tblstudent ON tblclasses.classes_id = tblstudent.student_class_id\r\n" + 
				"LEFT JOIN tblaccademic_year ON tblaccademic_year.accademic_year_student_id = tblstudent.student_id\r\n" + 
				"LEFT JOIN tblsubject ON tblsubject.subject_accademic_year_id = tblaccademic_year.accademic_year_id\r\n" + 
				"WHERE subject_teacher_id = ?";
	

        
		StudentObject item = null;

        //Lay doi tuong
        ResultSet rs = this.get(sql,id);
        if(rs != null){
            try {
                if (rs.next()) {
                    item = new StudentObject();
                    
                    item = new StudentObject();
                    item.setStudent_id(rs.getInt("student_id"));
                    item.setStudent_name(rs.getString("student_name"));
                    item.setStudent_class_id(rs.getInt("student_class_id"));
            
                    
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
	

	/**
	 * @author ManhHung
	 * <p>CreatDate : <p> Oct 2, 2018 - 2:47:59 AM
	 * <p>Last Updated : <p>
	 */
		public StudentObject getStudent(int id) {
			// TODO Auto-generated method stub
			String sql = "SELECT * FROM tblstudent " 
					+ " LEFT JOIN tblclasses " 
					+ " ON tblstudent.student_class_id = tblclasses.classes_id "
					+ " WHERE student_id = ? ";
			
	      
	        
	        StudentObject item = null;

	        //Lay doi tuong
	        ResultSet rs = this.get(sql,id);
	        if(rs != null){
	            try {
	                if (rs.next()) {
	                    item = new StudentObject();
	                    item.setStudent_id(rs.getInt("student_id"));
	                    item.setStudent_sex(rs.getString("student_sex"));
	                    item.setStudent_nation(rs.getString("student_nation"));
	                    item.setStudent_birthday(rs.getString("student_birthday"));
	                    item.setStudent_birthplace(rs.getString("student_birthplace"));
	                    item.setStudent_address(rs.getString("student_address"));
	                    item.setStudent_phone(rs.getString("student_phone"));
	                    item.setStudent_hobbis(rs.getString("student_hobbis"));
	                    item.setStudent_guardian_name(rs.getString("student_guardian_name"));
	                    item.setStudent_guardian_birthday(rs.getString("student_guardian_birthday"));
	                    item.setStudent_guardian_job(rs.getString("student_guardian_job"));
	                    item.setStudent_guardian_phone(rs.getString("student_guardian_phone"));
	                    item.setStudent_name(rs.getString("student_name"));
	                    item.setStudent_class_id(rs.getInt("student_class_id"));
	                    item.setStudent_priority(rs.getString("student_priority"));
	                    item.setStudent_social_component(rs.getString("student_social_component"));
	                    item.setStudent_exemptions(rs.getString("student_exemptions"));
	                    item.setStudent_email(rs.getString("student_email"));
	                    
	                    item.setStudent_province(rs.getString("student_province"));
	                    item.setStudent_district(rs.getString("student_district"));
	                    item.setStudent_ward(rs.getString("student_ward"));
	                    
	                    
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
		
	

	/**
	 * @author ManhHung
	 * <p>CreatDate : <p> Oct 2, 2018 -  2:47:59 AM
	 * <p>Last Updated : <p>
	 */
	

	public ArrayList<StudentObject> getStudents(StudentObject similar, int at, int total) {
		String sql = "SELECT * FROM tblstudent ";
		sql += " LEFT JOIN tblclasses " 
				+ " ON tblstudent.student_class_id = tblclasses.classes_id ";
		
		if(similar != null) {
			sql += "WHERE ";
			sql += MakeCondition.createCondition(similar);
		}
		sql += " ";
        sql += "ORDER BY student_id ASC ";
        if(at > 0 && total > 0) {
        	sql += " LIMIT  " + at + ", " + total;
        }
   
        
        ArrayList<StudentObject> items = new ArrayList<StudentObject>();
	      StudentObject item = null;

	      ResultSet rs = this.gets(sql);
	      if(rs != null){
	          try {
	              while (rs.next()) {
	                  item = new StudentObject();
	                 
	                  item.setStudent_id(rs.getInt("student_id"));
	                  item.setStudent_sex(rs.getString("student_sex"));
	                  item.setStudent_nation(rs.getString("student_nation"));
	                  item.setStudent_birthday(rs.getString("student_birthday"));
	                  item.setStudent_birthplace(rs.getString("student_birthplace"));
	                  item.setStudent_address(rs.getString("student_address"));
	                  item.setStudent_phone(rs.getString("student_phone"));
	                  item.setStudent_hobbis(rs.getString("student_hobbis"));
	                  item.setStudent_guardian_name(rs.getString("student_guardian_name"));
	                  item.setStudent_guardian_birthday(rs.getString("student_guardian_birthday"));
	                  item.setStudent_guardian_job(rs.getString("student_guardian_job"));
	                  item.setStudent_guardian_phone(rs.getString("student_guardian_phone"));
	                  item.setStudent_name(rs.getString("student_name"));
	                  item.setStudent_class_id(rs.getInt("student_class_id"));
	                  item.setStudent_priority(rs.getString("student_priority"));
	                  item.setStudent_social_component(rs.getString("student_social_component"));
	                  item.setStudent_exemptions(rs.getString("student_exemptions"));
	                  item.setStudent_email(rs.getString("student_email"));
	                  
	                  item.setStudent_province(rs.getString("student_province"));
	                    item.setStudent_district(rs.getString("student_district"));
	                    item.setStudent_ward(rs.getString("student_ward"));
	                  
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

	public static void main(String args[]) {
		
	}


	
}
