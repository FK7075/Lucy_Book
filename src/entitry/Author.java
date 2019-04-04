package entitry;

import xfl.fk.annotation.Lucky;

/**
 * 实体类——作者
 * @author fk-7075
 *
 */
@Lucky(id="autid")
public class Author {
	private Integer autid;//id
	private String autName;//作者姓名
	private String autSex;//性别
	private String autPlace;//籍贯
	private String autdate;//出生日期
	private String autPor;//作者图片
	private String autdetail;//有关作者的描述
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
