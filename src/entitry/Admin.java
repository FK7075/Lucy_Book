package entitry;


/**
 * 实体类——管理员
 * @author fk-7075
 *
 */
public class Admin {
	private Integer admid;//id
	private String admName;//登录名
	private String admPassword;//密码
	private String admPor;//头像
	private String admTel;//联系电话
	private Integer pagesize;
	private Integer inventory;
	
	public Integer getInventory() {
		return inventory;
	}
	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}
	public Integer getPagesize() {
		return pagesize;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	public String getAdmTel() {
		return admTel;
	}
	public void setAdmTel(String admTel) {
		this.admTel = admTel;
	}
	public Integer getAdmid() {
		return admid;
	}
	public void setAdmid(Integer admid) {
		this.admid = admid;
	}
	public String getAdmName() {
		return admName;
	}
	public void setAdmName(String admName) {
		this.admName = admName;
	}
	public String getAdmPassword() {
		return admPassword;
	}
	public void setAdmPassword(String admPassword) {
		this.admPassword = admPassword;
	}
	public String getAdmPor() {
		return admPor;
	}
	public void setAdmPor(String admPor) {
		this.admPor = admPor;
	}
	@Override
	public String toString() {
		return "Admin [admid=" + admid + ", admName=" + admName + ", admPassword=" + admPassword + ", admPor=" + admPor
				+ ", admTel=" + admTel + ", pagesize=" + pagesize + ", inventory=" + inventory + "]";
	}

}
