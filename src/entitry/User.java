package entitry;

import xfl.fk.annotation.Lucky;

/**
 * ʵ���ࡪ���û�
 * @author fk-7075
 *
 */
@Lucky(id="uid")
public class User {
	private Integer uid;
	private String uName;//�û���
	private String uSex;//�Ա�
	private String uPassword;//����
	private Integer myCons;//
	private String uTel;//�û��绰
	private Integer changenum;
	
	public Integer getChangenum() {
		return changenum;
	}
	public void setChangenum(Integer changenum) {
		this.changenum = changenum;
	}
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
	
	public Integer getMyCons() {
		return myCons;
	}
	public void setMyCons(Integer myCons) {
		this.myCons = myCons;
	}
	public String getuTel() {
		return uTel;
	}
	public void setuTel(String uTel) {
		this.uTel = uTel;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uName=" + uName + ", uSex=" + uSex + ", uPassword=" + uPassword + ", myCons="
				+ myCons + ", uTel=" + uTel + ", changenum=" + changenum + "]";
	}
}
