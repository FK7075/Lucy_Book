package xflfk.wicresoft.entitry;

public class Consigness {
	private Integer consid;//
	private String consName;//收货人姓名
	private String consTel;//收货人电话
	private String consAddre;//收获地址
	private String isDef;//是否设置为默认收货人
	private Integer uid;//创建该收货人的用户
	public Integer getConsid() {
		return consid;
	}
	public void setConsid(Integer consid) {
		this.consid = consid;
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
	public String getIsDef() {
		return isDef;
	}
	public void setIsDef(String isDef) {
		this.isDef = isDef;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "Consigness [consid=" + consid + ", consName=" + consName + ", consTel=" + consTel + ", consAddre="
				+ consAddre + ", isDef=" + isDef + ", uid=" + uid + "]";
	}
	

}
