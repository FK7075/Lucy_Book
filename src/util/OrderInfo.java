package util;
/**
 * ��װ�ࡪ��������������Ϣ
 * @author fk-7075
 *
 */
public class OrderInfo {
	private Integer ordid;
	private Integer bSales;
	private String bName;//����
	private Integer number;//����
	private String consName;//�ջ���
	private String consTel;//�ջ��˵绰
	private String consAddre;//�ջ���ַ
	private String uName;//�����ö������û�
	private String ordTime;//����ʱ��
	private String ordPayState;//����״̬
	private String ordSendState;//����״̬
	private Double ordTotal;//�����ܼƼ۸�
	private String userdetail;//�û���ע
	
	public Integer getbSales() {
		return bSales;
	}
	public void setbSales(Integer bSales) {
		this.bSales = bSales;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getConsName() {
		return consName;
	}
	public void setConsName(String consName) {
		this.consName = consName;
	}
	public String getConsTel() {
		return consTel;
	}
	public void setConsTel(String consTel) {
		this.consTel = consTel;
	}
	public String getConsAddre() {
		return consAddre;
	}
	public void setConsAddre(String consAddre) {
		this.consAddre = consAddre;
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
		return "OrderInfo [ordid=" + ordid + ", bSales=" + bSales + ", bName=" + bName + ", number=" + number
				+ ", consName=" + consName + ", consTel=" + consTel + ", consAddre=" + consAddre + ", uName=" + uName
				+ ", ordTime=" + ordTime + ", ordPayState=" + ordPayState + ", ordSendState=" + ordSendState
				+ ", ordTotal=" + ordTotal + ", userdetail=" + userdetail + "]";
	}



}
