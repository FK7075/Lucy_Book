package xflfk.wicresoft.entitry;

/**
 * 实体类——书本类型
 * @author fk-7075
 *
 */
public class Stort {
	private Integer stid;
	private String stName;//书本类型
	private String isShow;
	
	public String getIsShow() {
		return isShow;
	}
	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
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
		return "Stort [stid=" + stid + ", stName=" + stName + ", isShow=" + isShow + "]";
	}

}
