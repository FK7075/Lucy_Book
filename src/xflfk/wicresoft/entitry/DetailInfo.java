package xflfk.wicresoft.entitry;

public class DetailInfo {
	private String uName;
	private String uTel;
	private String bphoto;
	private String bName;
	private Integer number;
	private Double money;
	private String consName;
	private String consTel;
	private String consAddre;
	private String userdetail;
	
	public String getUserdetail() {
		return userdetail;
	}
	public void setUserdetail(String userdetail) {
		this.userdetail = userdetail;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	
	public String getConsName() {
		return consName;
	}
	public void setConsName(String consName) {
		this.consName = consName;
	}
	public String getConsTel() {
		return consTel;
	}
	public void setConsTel(String consTel) {
		this.consTel = consTel;
	}
	public String getConsAddre() {
		return consAddre;
	}
	public void setConsAddre(String consAddre) {
		this.consAddre = consAddre;
	}
	public String getuTel() {
		return uTel;
	}
	public void setuTel(String uTel) {
		this.uTel = uTel;
	}
	public String getBphoto() {
		return bphoto;
	}
	public void setBphoto(String bphoto) {
		this.bphoto = bphoto;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "DetailInfo [uName=" + uName + ", uTel=" + uTel + ", bphoto=" + bphoto + ", bName=" + bName + ", number="
				+ number + ", money=" + money + ", consName=" + consName + ", consTel=" + consTel + ", consAddre="
				+ consAddre + ", userdetail=" + userdetail + "]";
	}

	
}
