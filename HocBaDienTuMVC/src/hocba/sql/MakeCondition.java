package hocba.sql;

import hocba.model.object.AccoutObject;
import hocba.model.object.ClassesObject;
import hocba.model.object.StudentObject;

public class MakeCondition {
	
	public static String conditonAccoutPermiss(AccoutObject similar) {
		String tmp = null;
		if(similar != null) {
			if(similar.getAccout_permission() > 0) {
				tmp = " (accout_permission < " + similar.getAccout_permission() +  " ) ";
			}
		}
		return tmp;
	}
	
	 /**
     * 
     * <p>Description: </p>
     * @author ManhHung
     * <p>CreatDate : <p> Oct 4, 2018 - 8:50:41 AM
     * <p>Last Updated : <p>
     * @param similar
     * @return
     */
    public static String createCondition(StudentObject similar){
      String tmp = "";
      
      if(similar != null){
          if(similar.getRoles_java().indexOf("classes_name") != -1 && similar.getClass() != null) {
              tmp = " (classes_name = '" + similar.getClasses_name() + "') ";
          }
          
          if(similar.getRoles_java().indexOf("student_class_id") != -1 && similar.getStudent_class_id() > 0) {
              tmp = " (student_class_id = " + similar.getStudent_class_id() + ") ";
          }
          
          if(similar.getRoles_java().indexOf("classes_teacher_id") != -1 && similar.getClasses_mainteacher_id() > 0) {
        	  tmp = "(classes_teacher_id = )" + similar.getClasses_mainteacher_id() + ")";
          }
          
          
          
      }
      
      return tmp;
  }
    
    
    
    public static String createCondition(ClassesObject similar){
        String tmp = "";
      
       
       
            if(similar.getRoles_java().indexOf("classes_name") != -1 && similar.getClasses_name() != null) {
                tmp = " (classes_name = '" + similar.getClasses_name() + "') ";
               
            }else if(similar.getRoles_java().indexOf("classes_mainteacher_id") != -1 && similar.getClasses_mainteacher_id() > 0) {
          	  tmp = "(classes_mainteacher_id = " + similar.getClasses_mainteacher_id() + ")";
            }
            
        
        return tmp;
    }
    
    
    
    
  
    
}
