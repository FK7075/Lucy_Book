package xflfk.wicresoft.entitry;

public class LucyCfg {
	private Integer cfgid;
	private Integer pagesize;
	private Integer inventory;

	public Integer getCfgid() {
		return cfgid;
	}
	public void setCfgid(Integer cfgid) {
		this.cfgid = cfgid;
	}
	public Integer getPagesize() {
		return pagesize;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	public Integer getInventory() {
		return inventory;
	}
	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}
	@Override
	public String toString() {
		return "LucyCfg [cfgid=" + cfgid + ", pagesize=" + pagesize + ", inventory=" + inventory + "]";
	}


}
