package entitry;

import xfl.fk.annotation.Lucky;

/**
 * ʵ���ࡪ���ջ���
 * @author fk-7075
 *
 */
@Lucky(id="consid")
public class Consigness {
	private Integer consid;//
	private String consName;//�ջ�������
	private String consTel;//�ջ��˵绰
	private String consAddre;//�ջ��ַ
	private Integer uid;//�������ջ��˵��û�
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
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "Consigness [consid=" + consid + ", consName=" + consName + ", consTel=" + consTel + ", consAddre="
				+ consAddre + ", uid=" + uid + "]";
	}

}