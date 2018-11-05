package hocba.model.object;

public class Accademic_YearObject{
	private int accademic_year_id;
	private int accademic_year_student_id;
	private byte accademic_year_status;
	private String accademic_year_notes;
	
	private short accademic_year_score_final;
	private short accademic_year_score_term_1;
	private short accademic_year_score_term_2;
	
	private byte accademic_year_name;

	
		
	private String roles_java;
	
	public String getRoles_java() {
		return roles_java;
	}

	public void setRoles_java(String roles_java) {
		this.roles_java = roles_java;
	}
	/*Contructer*/
	public Accademic_YearObject(){
		this.roles_java = "";
	}

	/*Contructer full attribute*/
	public Accademic_YearObject(int accademic_year_id,int accademic_year_student_id,
			byte accademic_year_status,String accademic_year_notes,
			short accademic_year_score_final,short accademic_year_score_term_1,
			short accademic_year_score_term_2,byte accademic_year_name){
		
		this.accademic_year_id = accademic_year_id;
		this.accademic_year_student_id = accademic_year_student_id;
		this.accademic_year_status = accademic_year_status;
		this.accademic_year_notes = accademic_year_notes;
		this.accademic_year_score_final = accademic_year_score_final;
		this.accademic_year_score_term_1 = accademic_year_score_term_1;
		this.accademic_year_score_term_2 = accademic_year_score_term_2;
		this.accademic_year_name = accademic_year_name;

		
	}

	/*Contructer Object*/

	public Accademic_YearObject(Accademic_YearObject item){
		this(item.getAccademic_year_id(),item.getAccademic_year_student_id(),
				item.getAccademic_year_status(),item.getAccademic_year_notes(),
				item.getAccademic_year_score_final(),item.getAccademic_year_score_term_1(),item.getAccademic_year_score_term_2(),item.getAccademic_year_name());
	}

	public int getAccademic_year_id() {
		return accademic_year_id;
	}

	public void setAccademic_year_id(int accademic_year_id) {
		this.accademic_year_id = accademic_year_id;
	}

	public int getAccademic_year_student_id() {
		return accademic_year_student_id;
	}

	public void setAccademic_year_student_id(int accademic_year_student_id) {
		this.accademic_year_student_id = accademic_year_student_id;
	}

	public byte getAccademic_year_status() {
		return accademic_year_status;
	}

	public void setAccademic_year_status(byte accademic_year_status) {
		this.accademic_year_status = accademic_year_status;
	}

	public String getAccademic_year_notes() {
		return accademic_year_notes;
	}

	public void setAccademic_year_notes(String accademic_year_notes) {
		this.accademic_year_notes = accademic_year_notes;
	}

	public short getAccademic_year_score_final() {
		return accademic_year_score_final;
	}

	public void setAccademic_year_score_final(short accademic_year_score_final) {
		this.accademic_year_score_final = accademic_year_score_final;
	}

	public short getAccademic_year_score_term_1() {
		return accademic_year_score_term_1;
	}

	public void setAccademic_year_score_term_1(short accademic_year_score_term_1) {
		this.accademic_year_score_term_1 = accademic_year_score_term_1;
	}

	public short getAccademic_year_score_term_2() {
		return accademic_year_score_term_2;
	}

	public void setAccademic_year_score_term_2(short accademic_year_score_term_2) {
		this.accademic_year_score_term_2 = accademic_year_score_term_2;
	}

	public byte getAccademic_year_name() {
		return accademic_year_name;
	}

	public void setAccademic_year_name(byte accademic_year_name) {
		this.accademic_year_name = accademic_year_name;
	}

	@Override
	public String toString() {
		return "Accademic_YearObject [accademic_year_id=" + accademic_year_id + ", accademic_year_student_id="
				+ accademic_year_student_id + ", accademic_year_status=" + accademic_year_status
				+ ", accademic_year_notes=" + accademic_year_notes + ", accademic_year_score_final="
				+ accademic_year_score_final + ", accademic_year_score_term_1=" + accademic_year_score_term_1
				+ ", accademic_year_score_term_2=" + accademic_year_score_term_2 + ", accademic_year_name="
				+ accademic_year_name + "]";
	}
	
	
	
	
}