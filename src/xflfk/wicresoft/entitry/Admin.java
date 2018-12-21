package xflfk.wicresoft.entitry;

public class Admin {
	private Integer admid;//id
	private String admName;//µÇÂ¼Ãû
	private String admPassword;//ÃÜÂë
	private String admPor;//Í·Ïñ
	public Integer getAdmid() {
		return admid;
	}
	public void setAdmid(Integer admid) {
		this.admid = admid;
	}
	public String getAdmName() {
		return admName;
	}
	public void setAdmName(String admName) {
		this.admName = admName;
	}
	public String getAdmPassword() {
		return admPassword;
	}
	public void setAdmPassword(String admPassword) {
		this.admPassword = admPassword;
	}
	public String getAdmPor() {
		return admPor;
	}
	public void setAdmPor(String admPor) {
		this.admPor = admPor;
	}
	@Override
	public String toString() {
		return "Admin [admid=" + admid + ", admName=" + admName + ", admPassword=" + admPassword + ", admPor=" + admPor
				+ "]";
	}
	

}
