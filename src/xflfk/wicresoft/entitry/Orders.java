package xflfk.wicresoft.entitry;

import java.util.Date;

public class Orders {
	private Integer ordid;
	private Integer uid;//创建该订单的用户
	private Date ordTime;//创建时间
	private String ordState;//订单状态
	private Integer detid;//明细信息
	public Integer getOrdid() {
		return ordid;
	}
	public void setOrdid(Integer ordid) {
		this.ordid = ordid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Date getOrdTime() {
		return ordTime;
	}
	public void setOrdTime(Date ordTime) {
		this.ordTime = ordTime;
	}
	public String getOrdState() {
		return ordState;
	}
	public void setOrdState(String ordState) {
		this.ordState = ordState;
	}
	public Integer getDetid() {
		return detid;
	}
	public void setDetid(Integer detid) {
		this.detid = detid;
	}
	@Override
	public String toString() {
		return "Orders [ordid=" + ordid + ", uid=" + uid + ", ordTime=" + ordTime + ", ordState=" + ordState
				+ ", detid=" + detid + "]";
	}
	

}
