package xflfk.wicresoft.entitry;


public class Orders {
	private Integer ordid;
	private Integer consid;
	private Integer uid;//�����ö������û�
	private String ordTime;//����ʱ��
	private String ordPayState;//����״̬
	private String ordSendState;//����״̬
	private Double ordTotal;//�����ܼƼ۸�
	private String userdetail;//�û���ע
	
	
	public Integer getConsid() {
		return consid;
	}
	public void setConsid(Integer consid) {
		this.consid = consid;
	}
	public String getUserdetail() {
		return userdetail;
	}
	public void setUserdetail(String userdetail) {
		this.userdetail = userdetail;
	}
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
	
	public String getOrdPayState() {
		return ordPayState;
	}
	public void setOrdPayState(String ordPayState) {
		this.ordPayState = ordPayState;
	}
	public String getOrdSendState() {
		return ordSendState;
	}
	public void setOrdSendState(String ordSendState) {
		this.ordSendState = ordSendState;
	}
	public Double getOrdTotal() {
		return ordTotal;
	}
	public void setOrdTotal(Double ordTotal) {
		this.ordTotal = ordTotal;
	}
	@Override
	public String toString() {
		return "Orders [ordid=" + ordid + ", consid=" + consid + ", uid=" + uid + ", ordTime=" + ordTime
				+ ", ordPayState=" + ordPayState + ", ordSendState=" + ordSendState + ", ordTotal=" + ordTotal
				+ ", userdetail=" + userdetail + "]";
	}
}
