package xflfk.wicresoft.entitry;

public class BookInfo {
	private Integer bid;
	private Integer autid;
	private String bPhoto;
	private String bName;
	private String autName;
	private String stName;
	private Integer bStore;
	private Double bPrice;
	private String bdetail;
	
	
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
		return "BookInfo [bid=" + bid + ", autid=" + autid + ", bPhoto=" + bPhoto + ", bName=" + bName + ", autName="
				+ autName + ", stName=" + stName + ", bStore=" + bStore + ", bPrice=" + bPrice + ", bdetail=" + bdetail
				+ "]";
	}



}
