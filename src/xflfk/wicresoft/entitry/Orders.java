package xflfk.wicresoft.entitry;


public class Orders {
	private Integer ordid;
	private Integer uid;//�����ö������û�
	private String ordTime;//����ʱ��
	private String ordState;//����״̬
	private Double ordTotal;//�����ܼƼ۸�
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
	public Double getOrdTotal() {
		return ordTotal;
	}
	public void setOrdTotal(Double ordTotal) {
		this.ordTotal = ordTotal;
	}
	@Override
	public String toString() {
		return "Orders [ordid=" + ordid + ", uid=" + uid + ", ordTime=" + ordTime + ", ordState=" + ordState
				+ ", ordTotal=" + ordTotal + "]";
	}


}
