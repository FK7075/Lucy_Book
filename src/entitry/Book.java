package entitry;

import xfl.fk.annotation.Lucky;

/**
 * ʵ���ࡪ���鱾
 * @author fk-7075
 *
 */
@Lucky(id="bid")
public class Book {
	private Integer bid;
	private String bName;//����
	private Double bPrice;//����
	private Integer bStore;//���
	private String bPhoto;//ͼƬ
	private String bdetail;//����
	private Integer stid;//�鱾����
	private Integer autid;//������Ϣ
	private Integer bSales;//����
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
