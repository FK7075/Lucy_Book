package xflfk.wicresoft.entitry;

/**
 * 包装类——有关书本的所有信息
 * @author fk-7075
 *
 */
public class BookInfo {
	private Integer bid;
	private Integer ordid;
	private Integer shopid;
	private Integer autid;
	private Integer bSales;
	private String bPhoto;
	private String bName;
	private String autName;
	private String stName;
	private Integer bStore;
	private Double bPrice;
	private String bdetail;
	private String state;
	private Double money;
	private Integer number;
	
	public Integer getbSales() {
		return bSales;
	}
	public void setbSales(Integer bSales) {
		this.bSales = bSales;
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
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getShopid() {
		return shopid;
	}
	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getAutid() {
		return autid;
	}
	public void setAutid(Integer autid) {
		this.autid = autid;
	}
	public String getBdetail() {
		return bdetail;
	}
	public void setBdetail(String bdetail) {
		this.bdetail = bdetail;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getAutName() {
		return autName;
	}
	public void setAutName(String autName) {
		this.autName = autName;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public Integer getbStore() {
		return bStore;
	}
	public void setbStore(Integer bStore) {
		this.bStore = bStore;
	}
	public Double getbPrice() {
		return bPrice;
	}
	public void setbPrice(Double bPrice) {
		this.bPrice = bPrice;
	}
	
	public String getbPhoto() {
		return bPhoto;
	}
	public void setbPhoto(String bPhoto) {
		this.bPhoto = bPhoto;
	}
	
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	@Override
	public String toString() {
		return "BookInfo [bid=" + bid + ", ordid=" + ordid + ", shopid=" + shopid + ", autid=" + autid + ", bSales="
				+ bSales + ", bPhoto=" + bPhoto + ", bName=" + bName + ", autName=" + autName + ", stName=" + stName
				+ ", bStore=" + bStore + ", bPrice=" + bPrice + ", bdetail=" + bdetail + ", state=" + state + ", money="
				+ money + ", number=" + number + "]";
	}


}
