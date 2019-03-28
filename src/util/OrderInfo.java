package util;
/**
 * 包装类——订单的所有信息
 * @author fk-7075
 *
 */
public class OrderInfo {
	private Integer ordid;
	private Integer bSales;
	private String bName;//书名
	private Integer number;//数量
	private String consName;//收货人
	private String consTel;//收货人电话
	private String consAddre;//收货地址
	private String uName;//创建该订单的用户
	private String ordTime;//创建时间
	private String ordPayState;//付款状态
	private String ordSendState;//发货状态
	private Double ordTotal;//订单总计价格
	private String userdetail;//用户备注
	
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
