package xflfk.wicresoft.entitry;


public class ShoppCart {
	private Integer shopid;//id
	private Integer bid;//�鱾��Ϣ
	private Integer number;// ��������
	private Double money;//�۸�С��
	public Integer getShopid() {
		return shopid;
	}
	public void setShopid(Integer shopid) {
		this.shopid = shopid;
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
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "ShoppCart [shopid=" + shopid + ", bid=" + bid + ", number=" + number + ", money=" + money + "]";
	}

}
