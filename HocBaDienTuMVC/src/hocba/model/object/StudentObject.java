package hocba.model.object;

public class StudentObject extends ClassesObject{
	private int student_id;
	private String student_sex;
	private String student_nation;
	private String student_birthday;
	private String student_birthplace;
	private String student_address;
	private String student_phone;
	private String student_hobbis;
	private String student_guardian_name;
	private String student_guardian_birthday;
	private String student_guardian_job;
	private String student_guardian_phone;
	private String student_name;
	private int student_class_id;
	private String student_priority;
	private String student_social_component;
	private String student_exemptions;
	private String student_email;
	private String roles_java;
	private String student_province;
	private String student_district;
	private String student_ward;
	/*
	public boolean equals(StudentObject st) {
		if(this.student_id != st.student_id) {
			return false;
		}if(!this.student_sex.equals(st.student_sex)) {
			return false;
		}if(!this.student_nation.equals(st.student_nation)) {
			return false;
		}if(!this.student_birthday.equals(st.student_birthday)) {
			return false;
		}if(!this.student_birthplace.equals(st.student_birthplace)) {
			return false;
		}if(!this.student_address.equals(st.student_address)) {
			return false;
		}if(!this.student_phone.equals(st.student_phone)) {
			return false;
		}if(!this.student_hobbis.equals(st.student_hobbis)) {
			return false;
		}if(!this.student_guardian_name.equals(st.student_guardian_name)) {
			return false;
		}if(!this.student_guardian_birthday.equals(st.student_guardian_birthday)) {
			return false;
		}if(!this.student_guardian_job.equals(st.student_guardian_job)) {
			return false;
		}if(!this.student_guardian_phone.equals(st.student_guardian_phone)) {
			return false;
		}if(!this.student_name.equals(st.student_name)) {
			return false;
		}if(this.student_class_id != st.student_class_id) {
			return false;
		}if(!this.student_priority.equals(st.student_priority)) {
			return false;
		}if(!this.student_social_component.equals(st.student_social_component)) {
			return false;
		}if(!this.student_exemptions.equals(st.student_exemptions)) {
			return false;
		}if(!this.student_email.equals(st.student_email)) {
			return false;
		}
		
		
		
		return true;
	}
	*/
	public String getRoles_java() {
		return roles_java;
	}

	public void setRoles_java(String roles_java) {
		this.roles_java = roles_java;
	}

	/*Contructer*/
	public StudentObject(){
		this.roles_java = "";
	}
	
	public StudentObject(ClassesObject item){
		super(item);
	}
	
	@Override
	public String toString() {
		return "{'student_sex':'" + student_sex + "', 'student_nation':'"
				+ student_nation + "', 'student_birthday':'" + student_birthday + "', 'student_birthplace':'"
				+ student_birthplace + "', 'student_address':'" + student_address + "', 'student_phone':'" + student_phone
				+ "', 'student_hobbis':'" + student_hobbis + "', 'student_guardian_name':'" + student_guardian_name
				+ "', 'student_guardian_birthday':'" + student_guardian_birthday + "', 'student_guardian_job':'"
				+ student_guardian_job + "', 'student_guardian_phone':'" + student_guardian_phone + "', 'student_name':'"
				+ student_name + "', 'student_class_id':'" + student_class_id + "', 'student_priority':'" + student_priority
				+ "', 'student_social_component':'" + student_social_component + "', 'student_exemptions':'"
				+ student_exemptions + "', 'student_email':'" + student_email + "'}";
	}

	/*Contructer full attribute*/
	public StudentObject(int student_id,String student_sex,String student_nation,String student_birthday,String student_birthplace,String student_address,String student_phone,String student_hobbis,String student_guardian_name,String student_guardian_birthday,String student_guardian_job,String student_guardian_phone,String student_name,int student_class_id,String student_priority,String student_social_component,String student_exemptions,String student_email){
		this.student_id = student_id;
		this.student_sex = student_sex;
		this.student_nation = student_nation;
		this.student_birthday = student_birthday;
		this.student_birthplace = student_birthplace;
		this.student_address = student_address;
		this.student_phone = student_phone;
		this.student_hobbis = student_hobbis;
		this.student_guardian_name = student_guardian_name;
		this.student_guardian_birthday = student_guardian_birthday;
		this.student_guardian_job = student_guardian_job;
		this.student_guardian_phone = student_guardian_phone;
		this.student_name = student_name;
		this.student_class_id = student_class_id;
		this.student_priority = student_priority;
		this.student_social_component = student_social_component;
		this.student_exemptions = student_exemptions;
		this.student_email = student_email;

	}

	/*Contructer Object*/

	public StudentObject(StudentObject item){
		this(item.getStudent_id(),item.getStudent_sex(),item.getStudent_nation(),item.getStudent_birthday(),item.getStudent_birthplace(),item.getStudent_address(),item.getStudent_phone(),item.getStudent_hobbis(),item.getStudent_guardian_name(),item.getStudent_guardian_birthday(),item.getStudent_guardian_job(),item.getStudent_guardian_phone(),item.getStudent_name(),item.getStudent_class_id(),item.getStudent_priority(),item.getStudent_social_component(),item.getStudent_exemptions(),item.getStudent_email());
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_sex() {
		return student_sex;
	}

	public void setStudent_sex(String student_sex) {
		this.student_sex = student_sex;
	}

	public String getStudent_nation() {
		return student_nation;
	}

	public void setStudent_nation(String student_nation) {
		this.student_nation = student_nation;
	}

	public String getStudent_birthday() {
		return student_birthday;
	}

	public void setStudent_birthday(String student_birthday) {
		this.student_birthday = student_birthday;
	}

	public String getStudent_birthplace() {
		return student_birthplace;
	}

	public void setStudent_birthplace(String student_birthplace) {
		this.student_birthplace = student_birthplace;
	}

	public String getStudent_address() {
		return student_address;
	}

	public void setStudent_address(String student_address) {
		this.student_address = student_address;
	}

	public String getStudent_phone() {
		return student_phone;
	}

	public void setStudent_phone(String student_phone) {
		this.student_phone = student_phone;
	}

	public String getStudent_hobbis() {
		return student_hobbis;
	}

	public void setStudent_hobbis(String student_hobbis) {
		this.student_hobbis = student_hobbis;
	}

	public String getStudent_guardian_name() {
		return student_guardian_name;
	}

	public void setStudent_guardian_name(String student_guardian_name) {
		this.student_guardian_name = student_guardian_name;
	}

	public String getStudent_guardian_birthday() {
		return student_guardian_birthday;
	}

	public void setStudent_guardian_birthday(String student_guardian_birthday) {
		this.student_guardian_birthday = student_guardian_birthday;
	}

	public String getStudent_guardian_job() {
		return student_guardian_job;
	}

	public void setStudent_guardian_job(String student_guardian_job) {
		this.student_guardian_job = student_guardian_job;
	}

	public String getStudent_guardian_phone() {
		return student_guardian_phone;
	}

	public void setStudent_guardian_phone(String student_guardian_phone) {
		this.student_guardian_phone = student_guardian_phone;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public int getStudent_class_id() {
		return student_class_id;
	}

	public void setStudent_class_id(int student_class_id) {
		this.student_class_id = student_class_id;
	}

	public String getStudent_priority() {
		return student_priority;
	}

	public void setStudent_priority(String student_priority) {
		this.student_priority = student_priority;
	}

	public String getStudent_social_component() {
		return student_social_component;
	}

	public void setStudent_social_component(String student_social_component) {
		this.student_social_component = student_social_component;
	}

	public String getStudent_exemptions() {
		return student_exemptions;
	}

	public void setStudent_exemptions(String student_exemptions) {
		this.student_exemptions = student_exemptions;
	}

	public String getStudent_email() {
		return student_email;
	}

	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}

	public String getStudent_province() {
		return student_province;
	}

	public void setStudent_province(String student_province) {
		this.student_province = student_province;
	}

	public String getStudent_district() {
		return student_district;
	}

	public void setStudent_district(String student_district) {
		this.student_district = student_district;
	}

	public String getStudent_ward() {
		return student_ward;
	}

	public void setStudent_ward(String student_ward) {
		this.student_ward = student_ward;
	}

	
	
	
}