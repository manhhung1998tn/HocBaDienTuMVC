package hocba.model.object;

import java.util.ArrayList;

public class ClassesObject{
	private int classes_id;
	private String classes_name;
	private int classes_mainteacher_id;
	private TeacherObject teacher;
	private short classes_course;
	private short classes_student_count;

	/**
	 * <p>Description: </p> Tim Kiem Vi Tri Cua Object theo id class trong aray list
	 * @author ManhHung
	 * <p>CreatDate : <p> Oct 7, 2018 - 2:30:51 AM
	 * <p>Last Updated : <p>
	 * @param list
	 * @return 
	 */
	public int findCLassId(ArrayList<ClassesObject> list) {
		
		int left = 0;
		int right = list.size()-1;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			if (this.classes_id == list.get(mid).getClasses_id()) 
				return mid;
			else if (this.classes_id < list.get(mid).getClasses_id()) 
				right = mid - 1;
			else if (this.classes_id > list.get(mid).getClasses_id()) 
				left = mid + 1;
		} 
		
		
		return -1;
	}
	
	private String roles_java;
	/*Contructer*/
	public ClassesObject(){
		
	}

	
	
	public String getRoles_java() {
		return roles_java;
	}



	public void setRoles_java(String roles_java) {
		this.roles_java = roles_java;
	}



	public TeacherObject getTeacher() {
		return teacher;
	}



	public void setTeacher(TeacherObject teacher) {
		this.teacher = teacher;
	}



	/*Contructer full attribute*/
	public ClassesObject(int classes_id,String classes_name,int classes_mainteacher_id,short classes_course,short classes_student_count){
		this.classes_id = classes_id;
		this.classes_name = classes_name;
		this.classes_mainteacher_id = classes_mainteacher_id;
		this.classes_course = classes_course;
		this.classes_student_count = classes_student_count;

	}

	/*Contructer Object*/

	public ClassesObject(ClassesObject item){
		this(item.getClasses_id(),item.getClasses_name(),item.getClasses_mainteacher_id(),item.getClasses_course(),item.getClasses_student_count());
	}



	public int getClasses_id() {
		return classes_id;
	}



	public void setClasses_id(int classes_id) {
		this.classes_id = classes_id;
	}



	public String getClasses_name() {
		return classes_name;
	}



	public void setClasses_name(String classes_name) {
		this.classes_name = classes_name;
	}



	public int getClasses_mainteacher_id() {
		return classes_mainteacher_id;
	}



	public void setClasses_mainteacher_id(int classes_mainteacher_id) {
		this.classes_mainteacher_id = classes_mainteacher_id;
	}



	public short getClasses_course() {
		return classes_course;
	}



	public void setClasses_course(short classes_course) {
		this.classes_course = classes_course;
	}



	public short getClasses_student_count() {
		return classes_student_count;
	}



	public void setClasses_student_count(short classes_student_count) {
		this.classes_student_count = classes_student_count;
	}



	@Override
	public String toString() {
		return "ClassesObject [classes_id=" + classes_id + ", classes_name=" + classes_name
				+ ", classes_mainteacher_id=" + classes_mainteacher_id + ", classes_course=" + classes_course
				+ ", classes_student_count=" + classes_student_count + "]";
	}

	
	
	
	
	
}