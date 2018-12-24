package xflfk.wicresoft.entitry;


public class ShoppCart {
	private Integer shopid;
	private String shopTime;//创建时间
	private Integer uid;//创建该购物车的用户
	private Integer detid;//明细信息
	public Integer getShopid() {
		return shopid;
	}
	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}
	public String getShopTime() {
		return shopTime;
	}
	public void setShopTime(String shopTime) {
		this.shopTime = shopTime;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getDetid() {
		return detid;
	}
	public void setDetid(Integer detid) {
		this.detid = detid;
	}
	@Override
	public String toString() {
		return "ShoppCart [shopid=" + shopid + ", shopTime=" + shopTime + ", uid=" + uid + ", detid=" + detid + "]";
	}

	

}
