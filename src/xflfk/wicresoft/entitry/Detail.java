package xflfk.wicresoft.entitry;

public class Detail {
	private Integer detid;//
	private Integer bid;//�鱾��Ϣ
	private Integer uid;//�û���Ϣ
	private Integer ordid;//������Ϣ
	private Double money;//�ܽ��
	private Integer number;//��������
	private Integer consid;//�ջ�����Ϣ
	private String userdetail;//�û���ע
	private String detState;//״̬
	public Integer getDetid() {
		return detid;
	}
	public void setDetid(Integer detid) {
		this.detid = detid;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
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
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getDetState() {
		return detState;
	}
	public void setDetState(String detState) {
		this.detState = detState;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "Detail [detid=" + detid + ", bid=" + bid + ", uid=" + uid + ", ordid=" + ordid + ", money=" + money
				+ ", number=" + number + ", consid=" + consid + ", userdetail=" + userdetail + ", detState=" + detState
				+ "]";
	}

}
