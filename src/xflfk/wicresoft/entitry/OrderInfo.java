package xflfk.wicresoft.entitry;

public class OrderInfo {
	private Integer ordid;
	private String uName;//�����ö������û�
	private String ordTime;//����ʱ��
	private String ordPayState;//����״̬
	private String ordSendState;//����״̬
	private Double ordTotal;//�����ܼƼ۸�
	private String userdetail;//�û���ע
	
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
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
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
		return "OrderInfo [ordid=" + ordid + ", uName=" + uName + ", ordTime=" + ordTime + ", ordPayState="
				+ ordPayState + ", ordSendState=" + ordSendState + ", ordTotal=" + ordTotal + ", userdetail="
				+ userdetail + "]";
	}

}
