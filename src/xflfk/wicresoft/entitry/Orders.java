package xflfk.wicresoft.entitry;


public class Orders {
	private Integer ordid;
	private Integer uid;//创建该订单的用户
	private String ordTime;//创建时间
	private String ordState;//订单状态
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
	public String getOrdTime() {
		return ordTime;
	}
	public void setOrdTime(String ordTime) {
		this.ordTime = ordTime;
	}
	public String getOrdState() {
		return ordState;
	}
	public void setOrdState(String ordState) {
		this.ordState = ordState;
	}
	@Override
	public String toString() {
		return "Orders [ordid=" + ordid + ", uid=" + uid + ", ordTime=" + ordTime + ", ordState=" + ordState + "]";
	}


}
