package xflfk.wicresoft.entitry;

/**
 * ʵ���ࡪ���鱾����
 * @author fk-7075
 *
 */
public class Stort {
	private Integer stid;
	private String stName;//�鱾����
	public Integer getStid() {
		return stid;
	}
	public void setStid(Integer stid) {
		this.stid = stid;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	@Override
	public String toString() {
		return "Stort [stid=" + stid + ", stName=" + stName + "]";
	}


	

}
