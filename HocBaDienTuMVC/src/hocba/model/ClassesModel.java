package hocba.model;

import java.util.ArrayList;
import java.util.HashMap;
import hocba.dao.ClassesDAO;
import hocba.dao.ConnectionPool;
import hocba.dao.TeacherDAO;
import hocba.model.object.AccoutObject;
import hocba.model.object.ClassesObject;
import hocba.model.object.TeacherObject;

public class ClassesModel {
	public static ArrayList<ClassesObject> getClassByTeacher(TeacherObject teacherObject, ConnectionPool cp) throws NullPointerException{
		ArrayList<ClassesObject> list = null;
			
		if(teacherObject == null) {
			return null;
		}
			
		ClassesDAO classesDAO = new ClassesDAO(cp);
		
		
		ClassesObject similar = new ClassesObject();
		similar.setRoles_java("classes_mainteacher_id");
		similar.setClasses_mainteacher_id(teacherObject.getTeacher_id());
		
		
		list = classesDAO.getClassess(similar, -1, 0,classesDAO.getMaxCourse());
		
		classesDAO.releaseConnection();
		
		return list ;
		
	}
	
	
	/**
	 * <p>Description: </p> Lấy Danh sách lớp học theo giáo viêt và từ n khóa mới nhất
	 * @author ManhHung
	 * <p>CreatDate : <p> Oct 15, 2018 - 5:36:04 AM
	 * <p>Last Updated : <p>
	 * @param teacherObject
	 * @param ncourse
	 * @param cp
	 * @return
	 */
	public static ArrayList<ClassesObject> getClassByTeacherSubject(TeacherObject teacherObject,int ncourse, ConnectionPool cp){
		if(teacherObject == null) {
			return null;
		}
		
		ArrayList<ClassesObject> list = null;
		ClassesDAO classesDAO = new ClassesDAO(cp);
		int coursemax = classesDAO.getMaxCourse();
		
		list = classesDAO.getClassesByTeacherSubject(teacherObject.getTeacher_id(), coursemax-ncourse);
		classesDAO.releaseConnection();
		return list;
	}
	
	
	
	public static String classNameHTML(ArrayList<ClassesObject> list, int selected){
		String tmp1 = "selected";
		if(selected != -1) {
			tmp1 = "";
		}
		String html = " <option value=\"\" disabled "+tmp1+" hidden >Chọn Lớp</option>";
		int i = 0;
		if(list != null) {
			for(ClassesObject v : list) {
				if(selected == i) {
					html += "<option selected value=\""+i+"\">"+v.getClasses_name()+"</option>";
				}else {
					html += "<option  value=\""+i+"\">"+v.getClasses_name()+"</option>";
				}
				i++;
			}
			
		}
		

		
		
		
		return html;
	}

	
	
	
}
