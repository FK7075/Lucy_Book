package xflfk.wicresoft.entitry;

import java.util.Date;

public class Orders {
	private Integer ordid;
	private Integer uid;//�����ö������û�
	private Date ordTime;//����ʱ��
	private String ordState;//����״̬
	private Integer detid;//��ϸ��Ϣ
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
