package xflfk.wicresoft.entitry;

public class Detail {
	private Integer detid;//
	private Integer bid;//书本信息
	private Integer ordid;//订单信息
	private Double money;//总金额
	private Integer number;//购买数量
	private Integer consid;//收货人信息
	private String userdetail;//用户备注
	public Integer getDetid() {
		return detid;
	}
	public void setDetid(Integer detid) {
		this.detid = detid;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getConsid() {
		return consid;
	}
	public void setConsid(Integer consid) {
		this.consid = consid;
	}
	public String getUserdetail() {
		return userdetail;
	}
	public void setUserdetail(String userdetail) {
		this.userdetail = userdetail;
	}
	public Integer getOrdid() {
		return ordid;
	}
	public void setOrdid(Integer ordid) {
		this.ordid = ordid;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "Detail [detid=" + detid + ", bid=" + bid + ", ordid=" + ordid + ", money=" + money + ", number="
				+ number + ", consid=" + consid + ", userdetail=" + userdetail + "]";
	}

}
