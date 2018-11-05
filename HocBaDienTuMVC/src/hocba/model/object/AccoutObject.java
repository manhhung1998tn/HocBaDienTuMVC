package hocba.model.object;

public class AccoutObject{
	private int accout_id;
	private String accout_name;
	private String accout_pass;
	private String accout_fullname;
	private String accout_mobilephone;
	private String accout_email;
	private String accout_address;
	private String accout_roles;
	private String accout_created_date;
	private byte accout_permission;
	private String accout_nation;
	private String accout_religion;
	private String accout_last_logined;
	private int accout_parent_id;
	private int accout_logined;

	/*Contructer*/
	public AccoutObject(){

	}

	/*Contructer full attribute*/
	public AccoutObject(int accout_id,String accout_name,String accout_pass,String accout_fullname,String accout_mobilephone,String accout_email,String accout_address,String accout_roles,String accout_created_date,byte accout_permission,String accout_nation,String accout_religion,String accout_last_logined,int accout_parent_id,int accout_logined){
		this.accout_id = accout_id;
		this.accout_name = accout_name;
		this.accout_pass = accout_pass;
		this.accout_fullname = accout_fullname;
		this.accout_mobilephone = accout_mobilephone;
		this.accout_email = accout_email;
		this.accout_address = accout_address;
		this.accout_roles = accout_roles;
		this.accout_created_date = accout_created_date;
		this.accout_permission = accout_permission;
		this.accout_nation = accout_nation;
		this.accout_religion = accout_religion;
		this.accout_last_logined = accout_last_logined;
		this.accout_parent_id = accout_parent_id;
		this.accout_logined = accout_logined;

	}

	/*Contructer Object*/

	public AccoutObject(AccoutObject item){
		this(item.getAccout_id(),item.getAccout_name(),item.getAccout_pass(),item.getAccout_fullname(),item.getAccout_mobilephone(),
				item.getAccout_email(),item.getAccout_address(),item.getAccout_roles(),item.getAccout_created_date(),item.getAccout_permission(),
				item.getAccout_nation(),item.getAccout_religion(),item.getAccout_last_logined(),item.getAccout_parent_id(),item.getAccout_logined());
	}

	public int getAccout_id() {
		return accout_id;
	}

	public void setAccout_id(int accout_id) {
		this.accout_id = accout_id;
	}

	public String getAccout_name() {
		return accout_name;
	}

	public void setAccout_name(String accout_name) {
		this.accout_name = accout_name;
	}

	public String getAccout_pass() {
		return accout_pass;
	}

	public void setAccout_pass(String accout_pass) {
		this.accout_pass = accout_pass;
	}

	public String getAccout_fullname() {
		return accout_fullname;
	}

	public void setAccout_fullname(String accout_fullname) {
		this.accout_fullname = accout_fullname;
	}

	public String getAccout_mobilephone() {
		return accout_mobilephone;
	}

	public void setAccout_mobilephone(String accout_mobilephone) {
		this.accout_mobilephone = accout_mobilephone;
	}

	public String getAccout_email() {
		return accout_email;
	}

	public void setAccout_email(String accout_email) {
		this.accout_email = accout_email;
	}

	public String getAccout_address() {
		return accout_address;
	}

	public void setAccout_address(String accout_address) {
		this.accout_address = accout_address;
	}

	public String getAccout_roles() {
		return accout_roles;
	}

	public void setAccout_roles(String accout_roles) {
		this.accout_roles = accout_roles;
	}

	public String getAccout_created_date() {
		return accout_created_date;
	}

	public void setAccout_created_date(String accout_created_date) {
		this.accout_created_date = accout_created_date;
	}

	public byte getAccout_permission() {
		return accout_permission;
	}

	public void setAccout_permission(byte accout_permission) {
		this.accout_permission = accout_permission;
	}

	public String getAccout_nation() {
		return accout_nation;
	}

	public void setAccout_nation(String accout_nation) {
		this.accout_nation = accout_nation;
	}

	public String getAccout_religion() {
		return accout_religion;
	}

	public void setAccout_religion(String accout_religion) {
		this.accout_religion = accout_religion;
	}

	public String getAccout_last_logined() {
		return accout_last_logined;
	}

	public void setAccout_last_logined(String accout_last_logined) {
		this.accout_last_logined = accout_last_logined;
	}

	public int getAccout_parent_id() {
		return accout_parent_id;
	}

	public void setAccout_parent_id(int accout_parent_id) {
		this.accout_parent_id = accout_parent_id;
	}

	public int getAccout_logined() {
		return accout_logined;
	}

	public void setAccout_logined(int accout_logined) {
		this.accout_logined = accout_logined;
	}

	@Override
	public String toString() {
		return "AccoutObject [accout_id=" + accout_id + ", accout_name=" + accout_name + ", accout_pass=" + accout_pass
				+ ", accout_fullname=" + accout_fullname + ", accout_mobilephone=" + accout_mobilephone
				+ ", accout_email=" + accout_email + ", accout_address=" + accout_address + ", accout_roles="
				+ accout_roles + ", accout_created_date=" + accout_created_date + ", accout_permission="
				+ accout_permission + ", accout_nation=" + accout_nation + ", accout_religion=" + accout_religion
				+ ", accout_last_logined=" + accout_last_logined + ", accout_parent_id=" + accout_parent_id
				+ ", accout_logined=" + accout_logined + "]";
	}
	
	
	
	
}