package xflfk.wicresoft.entitry;

import java.util.Date;

public class ShoppCart {
	private Integer shopid;
	private Date shopTime;//����ʱ��
	private Integer uid;//�����ù��ﳵ���û�
	private Integer detid;//��ϸ��Ϣ
	public Integer getShopid() {
		return shopid;
	}
	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}
	public Date getShopTime() {
		return shopTime;
	}
	public void setShopTime(Date shopTime) {
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