package hocba.model.object;

public class SubjectObject{
	private int subject_id;
	private String subject_name;
	private int subject_teacher_id;
	private TeacherObject teacher;
	private StudentObject student;
	
	private short subject_term1_score_15;
	private short subject_term1_score_45_1;
	private short subject_term1_score_45_2;
	private short subject_term1_score_average;
	private short subject_term1_score_test;
	private short subject_term1_score_final;
	private short subject_term2_score_15;
	private short subject_term2_score_45_1;
	private short subject_term2_score_45_2;
	private short subject_term2_score_average;
	private short subject_term2_score_test;
	private short subject_term2_score_final;
	private short subject_score;
	
	
	
	private int subject_accademic_year_id;
	private String subject_notes;
	
	private String roles_java;
	
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

	/*Contructer*/
	public SubjectObject(){
		this.roles_java = "";
		this.student = new StudentObject();
		this.teacher = new TeacherObject();
	}

	/*Contructer full attribute*/
	public SubjectObject(int subject_id,String subject_name,int subject_teacher_id,short subject_term1_score_15,short subject_term1_score_45_1,
			short subject_term1_score_45_2,short subject_term1_score_average,short subject_term1_score_test,
			short subject_term1_score_final,short subject_term2_score_15,short subject_term2_score_45_1,
			short subject_term2_score_45_2,short subject_term2_score_average,short subject_term2_score_test,
			short subject_term2_score_final,int subject_accademic_year_id, String subject_notes){
		this.subject_id = subject_id;
		this.subject_name = subject_name;
		this.subject_teacher_id = subject_teacher_id;
		this.subject_term1_score_15 = subject_term1_score_15;
		this.subject_term1_score_45_1 = subject_term1_score_45_1;
		this.subject_term1_score_45_2 = subject_term1_score_45_2;
		this.subject_term1_score_average = subject_term1_score_average;
		this.subject_term1_score_test = subject_term1_score_test;
		this.subject_term1_score_final = subject_term1_score_final;
		this.subject_term2_score_15 = subject_term2_score_15;
		this.subject_term2_score_45_1 = subject_term2_score_45_1;
		this.subject_term2_score_45_2 = subject_term2_score_45_2;
		this.subject_term2_score_average = subject_term2_score_average;
		this.subject_term2_score_test = subject_term2_score_test;
		this.subject_term2_score_final = subject_term2_score_final;
		this.subject_accademic_year_id = subject_accademic_year_id;
		this.subject_notes = subject_notes;
		
		
		this.student = new StudentObject();
		this.teacher = new TeacherObject();

	}

	/*Contructer Object*/

	public SubjectObject(SubjectObject item){
		this(item.getSubject_id(),item.getSubject_name(),item.getSubject_teacher_id(),
				item.getSubject_term1_score_15(),item.getSubject_term1_score_45_1(),
				item.getSubject_term1_score_45_2(),item.getSubject_term1_score_average(),
				item.getSubject_term1_score_test(),item.getSubject_term1_score_final(),
				item.getSubject_term2_score_15(),item.getSubject_term2_score_45_1(),
				item.getSubject_term2_score_45_2(),item.getSubject_term2_score_average(),
				item.getSubject_term2_score_test(),item.getSubject_term2_score_final(),
				item.getSubject_accademic_year_id(), item.getSubject_notes());
	}

	public int getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}

	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}

	public int getSubject_teacher_id() {
		return subject_teacher_id;
	}

	public void setSubject_teacher_id(int subject_teacher_id) {
		this.subject_teacher_id = subject_teacher_id;
	}

	public short getSubject_term1_score_15() {
		return subject_term1_score_15;
	}

	public void setSubject_term1_score_15(short subject_term1_score_15) {
		this.subject_term1_score_15 = subject_term1_score_15;
	}

	public short getSubject_term1_score_45_1() {
		return subject_term1_score_45_1;
	}

	public void setSubject_term1_score_45_1(short subject_term1_score_45_1) {
		this.subject_term1_score_45_1 = subject_term1_score_45_1;
	}

	public short getSubject_term1_score_45_2() {
		return subject_term1_score_45_2;
	}

	public void setSubject_term1_score_45_2(short subject_term1_score_45_2) {
		this.subject_term1_score_45_2 = subject_term1_score_45_2;
	}

	public short getSubject_term1_score_average() {
		return subject_term1_score_average;
	}

	public void setSubject_term1_score_average(short subject_term1_score_average) {
		this.subject_term1_score_average = subject_term1_score_average;
	}

	public short getSubject_term1_score_test() {
		return subject_term1_score_test;
	}

	public void setSubject_term1_score_test(short subject_term1_score_test) {
		this.subject_term1_score_test = subject_term1_score_test;
	}

	public short getSubject_term1_score_final() {
		return subject_term1_score_final;
	}

	public void setSubject_term1_score_final(short subject_term1_score_final) {
		this.subject_term1_score_final = subject_term1_score_final;
	}

	public short getSubject_term2_score_15() {
		return subject_term2_score_15;
	}

	public void setSubject_term2_score_15(short subject_term2_score_15) {
		this.subject_term2_score_15 = subject_term2_score_15;
	}

	public short getSubject_term2_score_45_1() {
		return subject_term2_score_45_1;
	}

	public void setSubject_term2_score_45_1(short subject_term2_score_45_1) {
		this.subject_term2_score_45_1 = subject_term2_score_45_1;
	}

	public short getSubject_term2_score_45_2() {
		return subject_term2_score_45_2;
	}

	public void setSubject_term2_score_45_2(short subject_term2_score_45_2) {
		this.subject_term2_score_45_2 = subject_term2_score_45_2;
	}

	public short getSubject_term2_score_average() {
		return subject_term2_score_average;
	}

	public void setSubject_term2_score_average(short subject_term2_score_average) {
		this.subject_term2_score_average = subject_term2_score_average;
	}

	public short getSubject_term2_score_test() {
		return subject_term2_score_test;
	}

	public void setSubject_term2_score_test(short subject_term2_score_test) {
		this.subject_term2_score_test = subject_term2_score_test;
	}

	public short getSubject_term2_score_final() {
		return subject_term2_score_final;
	}

	public void setSubject_term2_score_final(short subject_term2_score_final) {
		this.subject_term2_score_final = subject_term2_score_final;
	}

	public int getSubject_accademic_year_id() {
		return subject_accademic_year_id;
	}

	public void setSubject_accademic_year_id(int subject_accademic_year_id) {
		this.subject_accademic_year_id = subject_accademic_year_id;
	}

	public String getSubject_notes() {
		return subject_notes;
	}

	public void setSubject_notes(String subject_notes) {
		this.subject_notes = subject_notes;
	}
	
	

	public short getSubject_score() {
		return subject_score;
	}

	public void setSubject_score(short subject_score) {
		this.subject_score = subject_score;
	}

	@Override
	public String toString() {
		return "SubjectObject [subject_id=" + subject_id + ", subject_name=" + subject_name + ", subject_teacher_id="
				+ subject_teacher_id + ", teacher=" + teacher + ", subject_term1_score_15=" + subject_term1_score_15
				+ ", subject_term1_score_45_1=" + subject_term1_score_45_1 + ", subject_term1_score_45_2="
				+ subject_term1_score_45_2 + ", subject_term1_score_average=" + subject_term1_score_average
				+ ", subject_term1_score_test=" + subject_term1_score_test + ", subject_term1_score_final="
				+ subject_term1_score_final + ", subject_term2_score_15=" + subject_term2_score_15
				+ ", subject_term2_score_45_1=" + subject_term2_score_45_1 + ", subject_term2_score_45_2="
				+ subject_term2_score_45_2 + ", subject_term2_score_average=" + subject_term2_score_average
				+ ", subject_term2_score_test=" + subject_term2_score_test + ", subject_term2_score_final="
				+ subject_term2_score_final + ", subject_accademic_year_id=" + subject_accademic_year_id
				+ ", subject_notes=" + subject_notes + "]";
	}

	public StudentObject getStudent() {
		return student;
	}

	public void setStudent(StudentObject student) {
		this.student = student;
	}
	
	
	
	
}