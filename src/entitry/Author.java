package entitry;

import xfl.fk.annotation.Lucky;

/**
 * ʵ���ࡪ������
 * @author fk-7075
 *
 */
@Lucky(id="autid")
public class Author {
	private Integer autid;//id
	private String autName;//��������
	private String autSex;//�Ա�
	private String autPlace;//����
	private String autdate;//��������
	private String autPor;//����ͼƬ
	private String autdetail;//�й����ߵ�����
	public Integer getAutid() {
		return autid;
	}
	public void setAutid(Integer autid) {
		this.autid = autid;
	}
	public String getAutName() {
		return autName;
	}
	public void setAutName(String autName) {
		this.autName = autName;
	}
	public String getAutSex() {
		return autSex;
	}
	public void setAutSex(String autSex) {
		this.autSex = autSex;
	}
	public String getAutPlace() {
		return autPlace;
	}
	public void setAutPlace(String autPlace) {
		this.autPlace = autPlace;
	}
	public String getAutdate() {
		return autdate;
	}
	public void setAutdate(String autdate) {
		this.autdate = autdate;
	}
	public String getAutPor() {
		return autPor;
	}
	public void setAutPor(String autPor) {
		this.autPor = autPor;
	}
	public String getAutdetail() {
		return autdetail;
	}
	public void setAutdetail(String autdetail) {
		this.autdetail = autdetail;
	}
	@Override
	public String toString() {
		return "Author [autid=" + autid + ", autName=" + autName + ", autSex=" + autSex + ", autPlace=" + autPlace
				+ ", autdate=" + autdate + ", autPor=" + autPor + ", autdetail=" + autdetail + "]";
	}
	

}
