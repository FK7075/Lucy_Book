package xflfk.wicresoft.entitry;

public class Stort {
	private Integer stid;
	private String stName;//书本类型
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
