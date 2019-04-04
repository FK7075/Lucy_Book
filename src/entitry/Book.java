package entitry;

import xfl.fk.annotation.Lucky;

/**
 * 实体类——书本
 * @author fk-7075
 *
 */
@Lucky(id="bid")
public class Book {
	private Integer bid;
	private String bName;//书名
	private Double bPrice;//单价
	private Integer bStore;//库存
	private String bPhoto;//图片
	private String bdetail;//描述
	private Integer stid;//书本类型
	private Integer autid;//作者信息
	private Integer bSales;//销量
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public Double getbPrice() {
		return bPrice;
	}
	public void setbPrice(Double bPrice) {
		this.bPrice = bPrice;
	}
	public Integer getbStore() {
		return bStore;
	}
	public void setbStore(Integer bStore) {
		this.bStore = bStore;
	}
	public String getbPhoto() {
		return bPhoto;
	}
	public void setbPhoto(String bPhoto) {
		this.bPhoto = bPhoto;
	}
	public String getBdetail() {
		return bdetail;
	}
	public void setBdetail(String bdetail) {
		this.bdetail = bdetail;
	}
	public Integer getbSales() {
		return bSales;
	}
	public void setbSales(Integer bSales) {
		this.bSales = bSales;
	}
	public Integer getStid() {
		return stid;
	}
	public void setStid(Integer stid) {
		this.stid = stid;
	}
	public Integer getAutid() {
		return autid;
	}
	public void setAutid(Integer autid) {
		this.autid = autid;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bName=" + bName + ", bPrice=" + bPrice + ", bStore=" + bStore + ", bPhoto="
				+ bPhoto + ", bdetail=" + bdetail + ", stid=" + stid + ", autid=" + autid + ", bSales=" + bSales + "]";
	}
}
