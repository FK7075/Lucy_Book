package xflfk.wicresoft.entitry;

public class User {
	private Integer uid;
	private String uName;//�û���
	private String uSex;//�Ա�
	private String uPassword;//����
	private String uPor;//ͷ��
	private String uTel;//�û��绰
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuSex() {
		return uSex;
	}
	public void setuSex(String uSex) {
		this.uSex = uSex;
	}
	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	public String getuPor() {
		return uPor;
	}
	public void setuPor(String uPor) {
		this.uPor = uPor;
	}
	public String getuTel() {
		return uTel;
	}
	public void setuTel(String uTel) {
		this.uTel = uTel;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uName=" + uName + ", uSex=" + uSex + ", uPassword=" + uPassword + ", uPor="
				+ uPor + ", uTel=" + uTel + "]";
	}
	

}
