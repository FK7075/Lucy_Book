package xflfk.wicresoft.entitry;

/**
 * 实体类——购物车
 * @author fk-7075
 *
 */
public class ShoppCart {
	private Integer shopid;//id
	private Integer bid;//书本信息
	private Integer uid;// 购书数量
	private String state;//价格小计
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
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "ShoppCart [shopid=" + shopid + ", bid=" + bid + ", uid=" + uid + ", state=" + state + "]";
	}


}
