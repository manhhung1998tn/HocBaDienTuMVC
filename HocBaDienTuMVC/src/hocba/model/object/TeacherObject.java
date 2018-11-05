package hocba.model.object;

public class TeacherObject extends AccoutObject{
	private int teacher_id;
	private int teacher_accout_id;
	private String teacher_notes;
	private byte teacher_permisson;
	
	
	/*Contructer*/
	public TeacherObject(){
		
	}

	/*Contructer full attribute*/
	public TeacherObject(int teacher_id,int teacher_accout_id,String teacher_notes,byte teacher_permisson){
		this.teacher_id = teacher_id;
		this.teacher_accout_id = teacher_accout_id;
		this.teacher_notes = teacher_notes;
		this.teacher_permisson = teacher_permisson;

	}

	/*Contructer Object*/

	public TeacherObject(TeacherObject item){
		this(item.getTeacher_id(),item.getTeacher_accout_id(),item.getTeacher_notes(),item.getTeacher_permisson());
	}

	public TeacherObject(AccoutObject item){
		super(item);
	}
	
	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public int getTeacher_accout_id() {
		return teacher_accout_id;
	}

	public void setTeacher_accout_id(int teacher_accout_id) {
		this.teacher_accout_id = teacher_accout_id;
	}

	public String getTeacher_notes() {
		return teacher_notes;
	}

	public void setTeacher_notes(String teacher_notes) {
		this.teacher_notes = teacher_notes;
	}

	public byte getTeacher_permisson() {
		return teacher_permisson;
	}

	public void setTeacher_permisson(byte teacher_permisson) {
		this.teacher_permisson = teacher_permisson;
	}
	
	
	
}